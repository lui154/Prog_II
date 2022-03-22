package com;

import java.io.IOException;
import javafx.fxml.FXML;

public class LoginController {
 
    @FXML
    private void logar() throws IOException{
        App.setRoot("menu");
    }
    
    @FXML
    private void cancelar() throws IOException{
        System.exit(0);
    }
}
