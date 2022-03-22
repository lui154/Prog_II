package com;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import modelo.Motorista;
import modelo.Operacao;
import modelo.Veiculo;
import util.Dao;

public class LocacaoController {
    @FXML
    private ComboBox<Veiculo> selectVeiculo;
    private List<Veiculo> v;
    private ObservableList<Veiculo> listaVeiculo;
    
    @FXML
    private ComboBox<Motorista> selectMotorista;
    private List<Motorista> m;
    private ObservableList<Motorista> listaMotorista;
    
    @FXML
    private DatePicker dataLocacao;
    
    @FXML
    private void initialize() {
        Dao<Veiculo> daov = new Dao(Veiculo.class);
        Dao<Motorista> daom = new Dao(Motorista.class);

        v = daov.listarTodos();
        listaVeiculo = FXCollections.observableArrayList(v);
        selectVeiculo.getItems().addAll(listaVeiculo);
        selectVeiculo.setValue(listaVeiculo.get(0));

        m = daom.listarTodos();
        listaMotorista = FXCollections.observableArrayList(m);
        selectMotorista.getItems().addAll(listaMotorista);
        selectMotorista.setValue(listaMotorista.get(0));

        dataLocacao.setValue(LocalDate.now());
    }
    
    @FXML
    private void locarVeiculo(){
        Operacao o = new Operacao();
        o.setVeiculo(selectVeiculo.getValue());
        o.setMotorista(selectMotorista.getValue());
        o.setDataLocacao(dataLocacao.getValue());
        Dao<Operacao> dao = new Dao(Operacao.class);
        dao.inserir(o);
    }
    
    @FXML
    private void voltar() throws IOException{
        App.setRoot("menu");
    }
    
}