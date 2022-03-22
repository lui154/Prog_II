package com;


import javafx.fxml.FXML;
import modelo.Operacao;
import util.Dao;
import java.io.IOException;
import java.util.List;
import javafx.scene.control.TextField;

public class ConsultarController{

    @FXML
    private List<Operacao> ops;
    
    @FXML
    private TextField placaEntrada;

    @FXML
    private void consultaHistorico() throws IOException {
        Dao<Operacao> daoO = new Dao(Operacao.class);
        ops = daoO.listarTodos();

        placaEntrada.getText();
        
        for(Operacao aux : ops){
            if(aux.getVeiculo().getPlaca().equals(placaEntrada.getText())){
                   System.out.print(aux.getMotorista().getNome());
            }
        }
    }
      @FXML
    private void voltar() throws IOException{
        App.setRoot("menu");
    }
}
