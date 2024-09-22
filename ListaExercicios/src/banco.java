import java.util.ArrayList;
import java.util.Scanner;

class ContaBanco {
    private String numeroConta;
    private String nomeTitular;
    private double saldo;

    public ContaBanco(String numeroConta, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = 0;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saque inválido. Verifique o saldo disponível.");
        }
    }

    public void transferir(ContaBanco destino, double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destino.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Transferência inválida. Verifique o saldo disponível.");
        }
    }

    @Override
    public String toString() {
        return "Conta: " + numeroConta + ", Titular: " + nomeTitular + ", Saldo: " + saldo;
    }
}

class Banco {
    private ArrayList<ContaBanco> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void cadastrarCliente(String nomeTitular, String numeroConta) {
        ContaBanco novaConta = new ContaBanco(numeroConta, nomeTitular);
        contas.add(novaConta);
        System.out.println("Cliente cadastrado e conta aberta com sucesso!");
    }

    public ContaBanco buscarConta(String numeroConta) {
        for (ContaBanco conta : contas) {
            if (conta.getNumeroConta().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public void realizarDeposito(String numeroConta, double valor) {
        ContaBanco conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void realizarSaque(String numeroConta, double valor) {
        ContaBanco conta = buscarConta(numeroConta);
        if (conta != null) {
            conta.sacar(valor);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void realizarTransferencia(String contaOrigem, String contaDestino, double valor) {
        ContaBanco origem = buscarConta(contaOrigem);
        ContaBanco destino = buscarConta(contaDestino);
        if (origem != null && destino != null) {
            origem.transferir(destino, valor);
        } else {
            System.out.println("Uma ou ambas as contas não foram encontradas.");
        }
    }

    public void exibirContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (ContaBanco conta : contas) {
                System.out.println(conta);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar cliente e abrir conta");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar saque");
            System.out.println("4. Realizar transferência");
            System.out.println("5. Exibir todas as contas");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do titular: ");
                    String nomeTitular = scanner.nextLine();
                    System.out.print("Digite o número da conta: ");
                    String numeroConta = scanner.nextLine();
                    banco.cadastrarCliente(nomeTitular, numeroConta);
                    break;
                case 2:
                    System.out.print("Digite o número da conta: ");
                    String numeroContaDeposito = scanner.nextLine();
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    banco.realizarDeposito(numeroContaDeposito, valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o número da conta: ");
                    String numeroContaSaque = scanner.nextLine();
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    banco.realizarSaque(numeroContaSaque, valorSaque);
                    break;
                case 4:
                    System.out.print("Digite o número da conta de origem: ");
                    String contaOrigem = scanner.nextLine();
                    System.out.print("Digite o número da conta de destino: ");
                    String contaDestino = scanner.nextLine();
                    System.out.print("Digite o valor da transferência: ");
                    double valorTransferencia = scanner.nextDouble();
                    banco.realizarTransferencia(contaOrigem, contaDestino, valorTransferencia);
                    break;
                case 5:
                    banco.exibirContas();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}