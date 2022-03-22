package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Buscador;
import modelo.Endereco;
import modelo.Motorista;
import util.Dao;


public class MotoristaController {
    
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCNH;
    @FXML
    private TextField campoSecao;
    
    @FXML
    public TextField campoCep;
    
    @FXML
    private TextField campoLogradouro; 
    @FXML
    private TextField campoBairro;   
    @FXML
    private TextField campoComplemento;    
 
    @FXML
    private TextField  campoUf;    
    @FXML
    private TextField campoLocalidade;   
    

    private Endereco endereco;
    
    @FXML
    private void buscar(){
        Buscador b = new Buscador();
        
        try {
           endereco = b.buscar(campoCep.getText());
           campoLogradouro.setText(endereco.getLogradouro());
           campoLocalidade.setText(endereco.getLocalidade());
           campoUf.setText(endereco.getUf());
           campoBairro.setText(endereco.getBairro());
           campoComplemento.setText(endereco.getComplemento());
           
        } catch(IOException ex){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("");
            alerta.setContentText(ex.getMessage());
            alerta.showAndWait();
        } catch (Exception e) {           
            Alert aviso = new Alert(AlertType.ERROR);
            aviso.setHeaderText("");
            aviso.setContentText(e.getMessage());
            aviso.showAndWait();           
        }
    }
    
    @FXML
    private void salvar(){
        Motorista motorista = new Motorista();
        
        motorista.setNome(campoNome.getText());
        motorista.setCNH(campoCNH.getText());
        motorista.setSecao(campoSecao.getText());
        motorista.setEndereco(endereco);
        
        Dao<Motorista> dao = new Dao(Motorista.class);
        dao.inserir(motorista);
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Operador cadastrado");
        alerta.showAndWait();
        
        campoNome.setText("");
        campoCNH.setText("");
        campoSecao.setText("");
    }
    
    @FXML
    private void cancelar() throws IOException {
        App.setRoot("menu");
    }
}
