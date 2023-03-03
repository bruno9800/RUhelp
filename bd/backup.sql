--
-- PostgreSQL database dump
--

-- Dumped from database version 15.2
-- Dumped by pg_dump version 15.2

-- Started on 2023-03-03 10:36:07

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE postgres;
--
-- TOC entry 3347 (class 1262 OID 5)
-- Name: postgres; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';


ALTER DATABASE postgres OWNER TO postgres;

\connect postgres

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3348 (class 0 OID 0)
-- Dependencies: 3347
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 2 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 3349 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 16437)
-- Name: emprestar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.emprestar (
    pkfk_cpf bigint NOT NULL,
    pk_coddisp integer NOT NULL,
    horario character(20) NOT NULL,
    diasemana character(20) NOT NULL,
    dataemprestimo date,
    fk_cpf2 bigint
);


ALTER TABLE public.emprestar OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16436)
-- Name: emprestar_pk_coddisp_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.emprestar_pk_coddisp_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.emprestar_pk_coddisp_seq OWNER TO postgres;

--
-- TOC entry 3350 (class 0 OID 0)
-- Dependencies: 216
-- Name: emprestar_pk_coddisp_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.emprestar_pk_coddisp_seq OWNED BY public.emprestar.pk_coddisp;


--
-- TOC entry 218 (class 1259 OID 16712)
-- Name: solicitar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.solicitar (
    pkfk_cpf bigint NOT NULL,
    pkfk_cpf2 bigint NOT NULL,
    pkfk_coddisp integer NOT NULL
);


ALTER TABLE public.solicitar OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16398)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    pk_cpf bigint NOT NULL,
    matricula bigint NOT NULL,
    nome character(100) NOT NULL,
    categoria character(2) NOT NULL,
    senha character(256) NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 3182 (class 2604 OID 16440)
-- Name: emprestar pk_coddisp; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestar ALTER COLUMN pk_coddisp SET DEFAULT nextval('public.emprestar_pk_coddisp_seq'::regclass);


--
-- TOC entry 3340 (class 0 OID 16437)
-- Dependencies: 217
-- Data for Name: emprestar; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.emprestar (pkfk_cpf, pk_coddisp, horario, diasemana, dataemprestimo, fk_cpf2) VALUES (123, 2, 'Janta               ', 'Quarta              ', NULL, NULL);
INSERT INTO public.emprestar (pkfk_cpf, pk_coddisp, horario, diasemana, dataemprestimo, fk_cpf2) VALUES (456789, 4, 'Janta               ', 'Quarta              ', NULL, NULL);
INSERT INTO public.emprestar (pkfk_cpf, pk_coddisp, horario, diasemana, dataemprestimo, fk_cpf2) VALUES (123456789, 5, 'Janta               ', 'Quarta              ', NULL, NULL);
INSERT INTO public.emprestar (pkfk_cpf, pk_coddisp, horario, diasemana, dataemprestimo, fk_cpf2) VALUES (123, 6, 'Almoço              ', 'Segunda             ', NULL, NULL);


--
-- TOC entry 3341 (class 0 OID 16712)
-- Dependencies: 218
-- Data for Name: solicitar; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.solicitar (pkfk_cpf, pkfk_cpf2, pkfk_coddisp) VALUES (123, 456789, 4);
INSERT INTO public.solicitar (pkfk_cpf, pkfk_cpf2, pkfk_coddisp) VALUES (123, 123456789, 5);
INSERT INTO public.solicitar (pkfk_cpf, pkfk_cpf2, pkfk_coddisp) VALUES (123456789, 123, 2);


--
-- TOC entry 3338 (class 0 OID 16398)
-- Dependencies: 215
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario (pk_cpf, matricula, nome, categoria, senha) VALUES (456789, 562922, 'Bruno bruno                                                                                         ', 'P2', 'brunodelas                                                                                                                                                                                                                                                      ');
INSERT INTO public.usuario (pk_cpf, matricula, nome, categoria, senha) VALUES (123, 2222222, 'joaozin                                                                                             ', 'P1', 'admin                                                                                                                                                                                                                                                           ');
INSERT INTO public.usuario (pk_cpf, matricula, nome, categoria, senha) VALUES (51515151, 515151515, 'adsadsasdasd                                                                                        ', 'P2', 'asdasdasd                                                                                                                                                                                                                                                       ');
INSERT INTO public.usuario (pk_cpf, matricula, nome, categoria, senha) VALUES (33666555999, 123456789, 'sadfsdfsdf                                                                                          ', 'P2', 'asdasdasdasd                                                                                                                                                                                                                                                    ');
INSERT INTO public.usuario (pk_cpf, matricula, nome, categoria, senha) VALUES (6311205564, 123456789, 'Vithor Freitas                                                                                      ', 'P2', 'vitindobd                                                                                                                                                                                                                                                       ');
INSERT INTO public.usuario (pk_cpf, matricula, nome, categoria, senha) VALUES (123456789, 2695959, 'Alazin rei delas                                                                                    ', 'P1', 'alazindelas                                                                                                                                                                                                                                                     ');


--
-- TOC entry 3351 (class 0 OID 0)
-- Dependencies: 216
-- Name: emprestar_pk_coddisp_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.emprestar_pk_coddisp_seq', 6, true);


--
-- TOC entry 3184 (class 2606 OID 16402)
-- Name: usuario User_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT "User_pkey" PRIMARY KEY (pk_cpf);


--
-- TOC entry 3186 (class 2606 OID 16442)
-- Name: emprestar emprestar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestar
    ADD CONSTRAINT emprestar_pkey PRIMARY KEY (pkfk_cpf, pk_coddisp);


--
-- TOC entry 3190 (class 2606 OID 16716)
-- Name: solicitar solicitar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitar
    ADD CONSTRAINT solicitar_pkey PRIMARY KEY (pkfk_cpf, pkfk_cpf2, pkfk_coddisp);


--
-- TOC entry 3188 (class 2606 OID 16711)
-- Name: emprestar unique_cod; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestar
    ADD CONSTRAINT unique_cod UNIQUE (pk_coddisp);


--
-- TOC entry 3191 (class 2606 OID 16448)
-- Name: emprestar emprestar_fk_cpf2_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestar
    ADD CONSTRAINT emprestar_fk_cpf2_fkey FOREIGN KEY (fk_cpf2) REFERENCES public.usuario(pk_cpf);


--
-- TOC entry 3192 (class 2606 OID 16443)
-- Name: emprestar emprestar_pkfk_cpf_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.emprestar
    ADD CONSTRAINT emprestar_pkfk_cpf_fkey FOREIGN KEY (pkfk_cpf) REFERENCES public.usuario(pk_cpf);


--
-- TOC entry 3193 (class 2606 OID 16727)
-- Name: solicitar solicitar_pkfk_coddisp_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitar
    ADD CONSTRAINT solicitar_pkfk_coddisp_fkey FOREIGN KEY (pkfk_coddisp) REFERENCES public.emprestar(pk_coddisp);


--
-- TOC entry 3194 (class 2606 OID 16722)
-- Name: solicitar solicitar_pkfk_cpf2_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitar
    ADD CONSTRAINT solicitar_pkfk_cpf2_fkey FOREIGN KEY (pkfk_cpf2) REFERENCES public.usuario(pk_cpf);


--
-- TOC entry 3195 (class 2606 OID 16717)
-- Name: solicitar solicitar_pkfk_cpf_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitar
    ADD CONSTRAINT solicitar_pkfk_cpf_fkey FOREIGN KEY (pkfk_cpf) REFERENCES public.usuario(pk_cpf);


-- Completed on 2023-03-03 10:36:07

--
-- PostgreSQL database dump complete
--

