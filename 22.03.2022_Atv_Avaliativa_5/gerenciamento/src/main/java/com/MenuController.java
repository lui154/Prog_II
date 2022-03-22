package com;

import java.io.IOException;
import javafx.fxml.FXML;

public class MenuController {
    @FXML
    private void cadastrarOperador() throws IOException{           
        App.setRoot("novoOperador");
    }
    
    @FXML
    private void cadastrarMotorista() throws IOException{           
        App.setRoot("novoMotorista");
    }
    
    @FXML
    private void cadastrarVeiculo() throws IOException{           
        App.setRoot("novoVeiculo");
    }
    
    @FXML
    private void locacaoVeiculo() throws IOException{           
        App.setRoot("locacaoVeiculo");
    }
    
    @FXML
    private void devolucaoVeiculo() throws IOException{           
        App.setRoot("devolucaoVeiculo");
    }
        
    @FXML
    private void consultarVeiculos() throws IOException{           
        App.setRoot("consultarEmprestimo");
    }
    
    @FXML
    private void sair(){
        System.exit(0);
    }
    
}
