import java.util.Scanner;

public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    public boolean isTrianguloValido() {
        return (ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA);
    }

    public double calcularArea() {
        double semiPerimetro = (ladoA + ladoB + ladoC) / 2;
        return Math.sqrt(semiPerimetro * (semiPerimetro - ladoA) * (semiPerimetro - ladoB) * (semiPerimetro - ladoC));
    }

    public String tipoDoTriangulo() {
        if (ladoA == ladoB && ladoB == ladoC) {
            return "Equilátero";
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do lado A: ");
        double ladoA = scanner.nextDouble();

        System.out.print("Digite o valor do lado B: ");
        double ladoB = scanner.nextDouble();

        System.out.print("Digite o valor do lado C: ");
        double ladoC = scanner.nextDouble();

        Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);
        if (triangulo.isTrianguloValido()) {
            System.out.println("\nO triângulo é: " + triangulo.tipoDoTriangulo());

            double area = triangulo.calcularArea();
            System.out.println("A área do triângulo é: " + area);
        } else {
            System.out.println("\nOs valores inseridos não formam um triângulo válido.");
        }

        scanner.close();
    }
}
