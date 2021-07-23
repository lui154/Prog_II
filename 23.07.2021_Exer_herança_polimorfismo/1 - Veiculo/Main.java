public class Main {
    public static void main(String[] args) {

        Veiculo v1 = new Veiculo("Volvo", 2018, 95_000.0, "kjf100");
        Veiculo v2 = new Veiculo("Ford", 2015, 90_000.0, "kjf100");
        Veiculo v3 = new Veiculo("Chevrolet", 2012, 80_000.0, "ctf230");

        System.out.println(v1.equals(v2));
        System.out.println(v2.equals(v3));
    }
}
