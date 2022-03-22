package modelo;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="operacao")
public class Operacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @JoinColumn(name="veiculo", referencedColumnName="id")
    @ManyToOne(optional=false, cascade=CascadeType.MERGE)
    private Veiculo veiculo;
    
    @JoinColumn(name="motorista", referencedColumnName="id")
    @ManyToOne(optional=false, cascade=CascadeType.MERGE)
    private Motorista motorista;
    
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataLocacao;
    
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate dataDevolucao;

    public Operacao() {

    }
    
    public String toString() {
        return motorista + " - " + veiculo;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
   
    
}