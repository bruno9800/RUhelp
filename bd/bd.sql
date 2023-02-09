CREATE TABLE IF NOT EXISTS public.usuario
(
    pk_cpf bigint NOT NULL,
    matricula bigint NOT NULL,
    nome "char" NOT NULL,
    categoria "char" NOT NULL,
    senha "char" NOT NULL,
    CONSTRAINT "User_pkey" PRIMARY KEY (pk_cpf)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuario
    OWNER to postgres;
	
CREATE TABLE IF NOT EXISTS public.emprestar
(
    pkfk_cpf bigint NOT NULL,
    pk_coddisp integer NOT NULL DEFAULT 'nextval('emprestar_pk_coddisp_seq'::regclass)',
    horario character(1) COLLATE pg_catalog."default" NOT NULL,
    diasemana character(1) COLLATE pg_catalog."default" NOT NULL,
    dataemprestimo date,
    fk_cpf2 bigint,
    CONSTRAINT emprestar_pkey PRIMARY KEY (pkfk_cpf, pk_coddisp),
    CONSTRAINT unique_cod UNIQUE (pk_coddisp),
    CONSTRAINT emprestar_fk_cpf2_fkey FOREIGN KEY (fk_cpf2)
        REFERENCES public.usuario (pk_cpf) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT emprestar_pkfk_cpf_fkey FOREIGN KEY (pkfk_cpf)
        REFERENCES public.usuario (pk_cpf) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.emprestar
    OWNER to postgres;
	
CREATE TABLE IF NOT EXISTS public.solicitar
(
    pkfk_cpf bigint NOT NULL,
    pkfk_cpf2 bigint NOT NULL,
    pkfk_coddisp integer NOT NULL,
    CONSTRAINT solicitar_pkey PRIMARY KEY (pkfk_cpf, pkfk_cpf2, pkfk_coddisp),
    CONSTRAINT solicitar_pkfk_coddisp_fkey FOREIGN KEY (pkfk_coddisp)
        REFERENCES public.emprestar (pk_coddisp) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT solicitar_pkfk_cpf2_fkey FOREIGN KEY (pkfk_cpf2)
        REFERENCES public.usuario (pk_cpf) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT solicitar_pkfk_cpf_fkey FOREIGN KEY (pkfk_cpf)
        REFERENCES public.usuario (pk_cpf) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.solicitar
    OWNER to postgres;