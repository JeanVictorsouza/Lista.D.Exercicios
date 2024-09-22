import java.util.Scanner;

public class Retangulo {
    private double largura;
    private double altura;

    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double calcularArea() {
        return largura * altura / 2;
    }

    public double calcularHipotenusa() {
        return Math.sqrt(Math.pow(largura, 2) + Math.pow(altura, 2));
    }

    public double calcularPerimetroTriangulo() {
        double hipotenusa = calcularHipotenusa();
        return largura + altura + hipotenusa;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a largura do retângulo: ");
        double largura = scanner.nextDouble();

        System.out.print("Digite a altura do retângulo: ");
        double altura = scanner.nextDouble();

        Retangulo retangulo = new Retangulo(largura, altura);

        System.out.println("\nLargura: " + retangulo.getLargura());
        System.out.println("Altura: " + retangulo.getAltura());
        System.out.println("Área: " + retangulo.calcularArea());
        System.out.println("Perímetro do triângulo (soma dos lados): " + retangulo.calcularPerimetroTriangulo());

        scanner.close();
    }
}
