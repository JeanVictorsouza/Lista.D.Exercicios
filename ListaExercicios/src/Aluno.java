import java.util.Scanner;

public class Aluno {
    private String nome;
    private String matricula;
    private double[] notas;

    public Aluno(String nome, String matricula, double[] notas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public String verificarSituacao() {
        double media = calcularMedia();
        if (media >= 5.0) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();

        System.out.print("Quantas notas o aluno tem? ");
        int quantidadeNotas = scanner.nextInt();
        double[] notas = new double[quantidadeNotas];

        for (int i = 0; i < quantidadeNotas; i++) {
            System.out.print("Digite a nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        Aluno aluno = new Aluno(nome, matricula, notas);

        System.out.println("\nNome: " + aluno.nome);
        System.out.println("Matrícula: " + aluno.matricula);
        System.out.println("Média: " + aluno.calcularMedia());
        System.out.println("Situação: " + aluno.verificarSituacao());

        scanner.close();
    }
}
