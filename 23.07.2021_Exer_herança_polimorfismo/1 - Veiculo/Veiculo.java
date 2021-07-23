public class Veiculo {

    private String placa;
    private String marca;
    private Integer ano;
    private Double valor;

    public Veiculo(){
        this.marca = "";
        this.ano = 0;
        this.valor = 0.0;
        this.placa = "";
    }
    public Veiculo(String marca, Integer ano, Double valor, String placa) {
        this.marca = marca;
        this.ano = ano;
        this.valor = valor;
        this.placa = placa;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        Veiculo v = (Veiculo) obj;
        if (this.placa == v.placa){
        return true;
        }else return false;
    }
}