module com {
    requires javafx.controls;
    requires javafx.fxml;
    
    
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.base;
    
    requires java.desktop;
    requires java.logging;
    
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    

    opens com to javafx.fxml;
    opens modelo to org.hibernate.orm.core , javafx.base;
    opens util to org.hibernate.orm.core , javafx.base;
    
    exports com;
    exports util;
    exports modelo;
}
