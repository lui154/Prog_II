package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modelo.Buscador;
import modelo.Endereco;
import modelo.Operador;
import util.Dao;

public class OperadorController {

    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoLogin;
    @FXML
    private TextField campoSenha;
    
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
            Alert aviso = new Alert(Alert.AlertType.ERROR);
            aviso.setHeaderText("");
            aviso.setContentText(e.getMessage());
            aviso.showAndWait();           
        }
    }
    
    @FXML
    private void salvar(){
        Operador operador = new Operador();
        
        operador.setNome(campoNome.getText());
        operador.setLogin(campoLogin.getText());
        operador.setSenha(campoSenha.getText()); 
        
        Dao<Operador> dao = new Dao(Operador.class); 
        dao.inserir(operador);
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("");
        alerta.setContentText("Operador cadastrado");
        alerta.showAndWait();
        
        campoNome.setText("");
        campoLogin.setText("");
        campoSenha.setText("");
    }
    
    
    @FXML
    private void cancelar() throws IOException {
        App.setRoot("menu");
    }
    
}
