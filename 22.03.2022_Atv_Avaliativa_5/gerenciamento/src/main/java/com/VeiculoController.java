package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modelo.Veiculo;
import util.Dao;

public class VeiculoController {

    @FXML
    private TextField campoPlaca;
    
    @FXML
    private TextField campoMarca;
    
    @FXML
    private TextField campoModelo;
    
    @FXML
    private void salvar(){
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(campoPlaca.getText());
        veiculo.setMarca(campoMarca.getText());
        veiculo.setModelo(campoModelo.getText()); 
        
        Dao<Veiculo> dao = new Dao(Veiculo.class); 
        dao.inserir(veiculo);
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Veiculo cadastrado");
        alerta.showAndWait();
        
        campoPlaca.setText("");
        campoMarca.setText("");
        campoModelo.setText("");
             
    }
    
    @FXML
    private void cancelar() throws IOException{
        App.setRoot("menu");
    }
    
}