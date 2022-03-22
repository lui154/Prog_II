package modelo;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="motorista")
@DiscriminatorValue("Motorista")
public class Motorista extends Pessoa{
    @Column(length = 30)
    private String CNH;
    @Column(length = 30)
    private String secao;
    
    public Motorista(){
    }
    
    public Motorista(String nome, Endereco endereco, String CNH, String secao){
        super(nome, endereco);
        this.CNH = CNH;
        this.secao = secao;
    }

    public String getCNH() {
        return CNH;
    }

    public void setCNH(String CNH) {
        this.CNH = CNH;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }
    
    
}
