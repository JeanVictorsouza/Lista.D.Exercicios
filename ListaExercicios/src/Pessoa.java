import java.util.Scanner;

public class Pessoa {
    private String nome;
    private int idade;
    private String profissao;

    public Pessoa(String nome, int idade, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }

    public int calcularAnosBissextos() {
        int anosBissextos = 0;
        for (int ano = 1; ano <= idade; ano++) {
            if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                anosBissextos++;
            }
        }
        return anosBissextos;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Profissão: " + profissao);
        System.out.println("Anos bissextos vividos: " + calcularAnosBissextos());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a idade da pessoa: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a profissão da pessoa: ");
        String profissao = scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, idade, profissao);

        pessoa.exibirInformacoes();

        scanner.close();
    }
}