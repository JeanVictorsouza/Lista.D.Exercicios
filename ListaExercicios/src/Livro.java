import java.util.Scanner;

public class Livro {
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private boolean disponivel;

    public Livro(String titulo, String autor, int numeroPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.disponivel = true; // O livro começa disponível
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Livro emprestado com sucesso.");
        } else {
            System.out.println("O livro não está disponível para emprestimo.");
        }
    }

    public void devolver() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("O livro já está disponível.");
        }
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        System.out.print("Digite o número de páginas do livro: ");
        int numeroPaginas = scanner.nextInt();

        Livro livro = new Livro(titulo, autor, numeroPaginas);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Emprestar livro");
            System.out.println("2. Devolver livro");
            System.out.println("3. Verificar disponibilidade");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    livro.emprestar();
                    break;
                case 2:
                    livro.devolver();
                    break;
                case 3:
                    if (livro.isDisponivel()) {
                        System.out.println("O livro está disponível.");
                    } else {
                        System.out.println("O livro não está disponível.");
                    }
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