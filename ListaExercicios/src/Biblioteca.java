import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class book {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public book(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (disponivel) {
            disponivel = false;
            System.out.println("O livro \"" + titulo + "\" foi emprestado.");
        } else {
            System.out.println("O livro \"" + titulo + "\" já está emprestado.");
        }
    }

    public void devolver() {
        if (!disponivel) {
            disponivel = true;
            System.out.println("O livro \"" + titulo + "\" foi devolvido.");
        } else {
            System.out.println("O livro \"" + titulo + "\" já está disponível.");
        }
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Disponível: " + (disponivel ? "Sim" : "Não");
    }
}

class Biblioteca {
    private HashMap<String, book> livros;

    public Biblioteca() {
        livros = new HashMap<>();
    }

    public void cadastrarbook(String titulo, String autor) {
        if (!livros.containsKey(titulo)) {
            book novobook = new book(titulo, autor);
            livros.put(titulo, novobook);
            System.out.println("book cadastrado com sucesso: " + titulo);
        } else {
            System.out.println("O livro \"" + titulo + "\" já está cadastrado.");
        }
    }

    public book buscarbook(String titulo) {
        return livros.get(titulo);
    }

    public void emprestarbook(String titulo) {
        book livro = buscarbook(titulo);
        if (livro != null) {
            livro.emprestar();
        } else {
            System.out.println("book não encontrado.");
        }
    }

    public void devolverbook(String titulo) {
        book livro = buscarbook(titulo);
        if (livro != null) {
            livro.devolver();
        } else {
            System.out.println("book não encontrado.");
        }
    }

    public void exibirbooks() {
        System.out.println("books cadastrados:");
        for (book livro : livros.values()) {
            System.out.println(livro);
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Emprestar livro");
            System.out.println("3. Devolver livro");
            System.out.println("4. Verificar disponibilidade de um livro");
            System.out.println("5. Exibir todos os livros");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String autor = scanner.nextLine();
                    biblioteca.cadastrarbook(titulo, autor);
                    break;

                case 2:
                    System.out.print("Título do livro a ser emprestado: ");
                    String tituloEmprestimo = scanner.nextLine();
                    biblioteca.emprestarbook(tituloEmprestimo);
                    break;

                case 3:
                    System.out.print("Título do livro a ser devolvido: ");
                    String tituloDevolucao = scanner.nextLine();
                    biblioteca.devolverbook(tituloDevolucao);
                    break;

                case 4:
                    System.out.print("Título do livro a verificar: ");
                    String tituloVerificar = scanner.nextLine();
                    book livroVerificar = biblioteca.buscarbook(tituloVerificar);
                    if (livroVerificar != null) {
                        System.out.println(livroVerificar.isDisponivel() ? "O livro está disponível." : "O livro não está disponível.");
                    } else {
                        System.out.println("book não encontrado.");
                    }
                    break;

                case 5:
                    biblioteca.exibirbooks();
                    break;

                case 6:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}