module co.ao.yami_service {
    requires javafx.fxml;
    requires javafx.web;


    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.java;
    requires java.naming;
    requires com.jfoenix;



    opens co.ao.yami_service to javafx.fxml;
    exports co.ao.yami_service;
    exports co.ao.bd;
    opens co.ao.bd to javafx.fxml;
}