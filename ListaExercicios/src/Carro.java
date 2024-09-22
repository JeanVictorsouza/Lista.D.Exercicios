import java.util.Scanner;

public class Carro {
    private String marca;
    private String modelo;
    private double velocidadeAtual;

    public Carro(String marca, String modelo, double velocidadeAtual) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadeAtual = velocidadeAtual;
    }

    public void acelerar(double aumento) {
        velocidadeAtual += aumento;
        System.out.println("Acelerou! Velocidade atual: " + velocidadeAtual + " km/h");
    }

    public void frear(double reducao) {
        if (velocidadeAtual - reducao < 0) {
            velocidadeAtual = 0;
        } else {
            velocidadeAtual -= reducao;
        }
        System.out.println("Freou! Velocidade atual: " + velocidadeAtual + " km/h");
    }

    public void exibirVelocidade() {
        System.out.println("Velocidade atual: " + velocidadeAtual + " km/h");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite a velocidade inicial do carro (km/h): ");
        double velocidadeAtual = scanner.nextDouble();

        Carro carro = new Carro(marca, modelo, velocidadeAtual);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Acelerar");
            System.out.println("2. Frear");
            System.out.println("3. Exibir velocidade atual");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a quantidade para acelerar (km/h): ");
                    double aumento = scanner.nextDouble();
                    carro.acelerar(aumento);
                    break;
                case 2:
                    System.out.print("Digite a quantidade para frear (km/h): ");
                    double reducao = scanner.nextDouble();
                    carro.frear(reducao);
                    break;
                case 3:
                    carro.exibirVelocidade();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}