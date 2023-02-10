module com.teste.teste {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens com.ruhelp.ruhelp to javafx.fxml;
    exports com.ruhelp.ruhelp;
}