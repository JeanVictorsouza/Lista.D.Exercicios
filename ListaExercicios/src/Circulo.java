import java.util.Scanner;

public class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do raio do círculo: ");
        double raioUsuario = scanner.nextDouble();

        Circulo circulo = new Circulo(raioUsuario);

        System.out.println("Raio: " + circulo.getRaio());
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Perímetro: " + circulo.calcularPerimetro());
    }
}
