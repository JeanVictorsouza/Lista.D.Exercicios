import java.util.Scanner;

public class ContaBancaria {
    private String numeroConta;
    private String nomeTitular;
    private double saldo;

    public ContaBancaria(String numeroConta, String nomeTitular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("O valor de depósito deve ser positivo.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar o saque.");
        } else {
            System.out.println("O valor de saque deve ser positivo.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContaBancaria conta = new ContaBancaria("12345", "João Silva", 1000.00);
        System.out.println("Conta criada com saldo inicial de R$" + conta.getSaldo());

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver Saldo");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para depósito: R$");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;

                case 2:
                    System.out.print("Digite o valor para saque: R$");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;

                case 3:
                    System.out.println("Seu saldo atual é: R$" + conta.getSaldo());
                    break;

                case 4:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}