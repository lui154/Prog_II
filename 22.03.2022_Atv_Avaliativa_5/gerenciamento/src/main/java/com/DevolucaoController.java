package com;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import modelo.Operacao;
import util.Dao;

public class DevolucaoController {

    @FXML
    private ComboBox<Operacao> selectOp;
    private List<Operacao> operacao;
    private ObservableList<Operacao> listaOperacao;

    @FXML
    private DatePicker dataLocacao;

    @FXML
    private DatePicker dataDevolucao;

    @FXML
    private void initialize() {
        Dao<Operacao> daoo = new Dao(Operacao.class);
        operacao = daoo.listarTodos();
        listaOperacao = FXCollections.observableArrayList(operacao);
        selectOp.getItems().addAll(listaOperacao);

        dataDevolucao.setValue(LocalDate.now());
    }

    @FXML
    private void buscarDataLocacao() {
        Operacao a = selectOp.getValue();
        dataLocacao.setValue(a.getDataLocacao());
    }

    @FXML
    private void devolucao() {
        Operacao o = selectOp.getValue();

        Dao<Operacao> dao = new Dao(Operacao.class);
        o.setDataDevolucao(dataDevolucao.getValue());
        dao.alterar(o);
    }

    @FXML
    private void voltar() throws IOException{
        App.setRoot("menu");
    }
    
}
