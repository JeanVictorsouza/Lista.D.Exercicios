import java.util.Scanner;

public class Funcionario {
    private String nome;
    private double salarioBruto;
    private String cargo;

    public Funcionario(String nome, double salarioBruto, String cargo) {
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        this.cargo = cargo;
    }
    public double calcularAliquota() {
        if (salarioBruto <= 1412.00) {
            return 7.5;
        } else if (salarioBruto <= 2666.68) {
            return 9.0;
        } else if (salarioBruto <= 4000.03) {
            return 12.0;
        } else if (salarioBruto <= 7786.02) {
            return 14.0;
        } else {
            return 0;
        }
    }

    public double calcularSalarioLiquido(double valorBeneficios) {
        double aliquota = calcularAliquota();
        double descontoImposto = salarioBruto * aliquota / 100;
        return salarioBruto - descontoImposto + valorBeneficios;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o salário bruto do funcionário: R$ ");
        double salarioBruto = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();

        System.out.print("Digite o valor dos benefícios (R$): ");
        double valorBeneficios = scanner.nextDouble();

        Funcionario funcionario = new Funcionario(nome, salarioBruto, cargo);

        double salarioLiquido = funcionario.calcularSalarioLiquido(valorBeneficios);

        System.out.println("\nNome: " + funcionario.nome);
        System.out.println("Cargo: " + funcionario.cargo);
        System.out.println("Salário Bruto: R$ " + salarioBruto);
        System.out.println("Alíquota aplicada: " + funcionario.calcularAliquota() + "%");
        System.out.println("Salário Líquido: R$ " + salarioLiquido);

        scanner.close();
    }
}
