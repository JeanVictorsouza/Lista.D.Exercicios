import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paciente {
    private String nome;
    private int idade;
    private List<String> historicoConsultas;

    public Paciente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.historicoConsultas = new ArrayList<>();
    }

    public void adicionarConsulta(String consulta) {
        historicoConsultas.add(consulta);
        System.out.println("Consulta adicionada com sucesso.");
    }

    public void exibirConsultas() {
        if (historicoConsultas.isEmpty()) {
            System.out.println("Nenhuma consulta registrada.");
        } else {
            System.out.println("Histórico de Consultas:");
            for (String consulta : historicoConsultas) {
                System.out.println("- " + consulta);
            }
        }
    }

    // Método principal para execução
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade do paciente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        Paciente paciente = new Paciente(nome, idade);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar nova consulta");
            System.out.println("2. Exibir histórico de consultas");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da consulta: ");
                    String consulta = scanner.nextLine();
                    paciente.adicionarConsulta(consulta);
                    break;
                case 2:
                    paciente.exibirConsultas();
                    break;
                case 3:
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
