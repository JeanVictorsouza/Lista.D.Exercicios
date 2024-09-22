import java.util.ArrayList;
import java.util.Scanner;

class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone;
    }
}

class Agenda {
    private ArrayList<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(String nome, String telefone) {
        Contato novoContato = new Contato(nome, telefone);
        contatos.add(novoContato);
        System.out.println("Contato adicionado com sucesso!");
    }

    public void editarContato(String nome) {
        Contato contato = buscarContatoPorNome(nome);
        if (contato != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo telefone: ");
            String novoTelefone = scanner.nextLine();
            contato.setNome(novoNome);
            contato.setTelefone(novoTelefone);
            System.out.println("Contato editado com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public void removerContato(String nome) {
        Contato contato = buscarContatoPorNome(nome);
        if (contato != null) {
            contatos.remove(contato);
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public Contato buscarContatoPorNome(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public Contato buscarContatoPorTelefone(String telefone) {
        for (Contato contato : contatos) {
            if (contato.getTelefone().equals(telefone)) {
                return contato;
            }
        }
        return null;
    }

    public void exibirContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato na agenda.");
        } else {
            System.out.println("Contatos na agenda:");
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Editar contato");
            System.out.println("3. Remover contato");
            System.out.println("4. Buscar contato por nome");
            System.out.println("5. Buscar contato por telefone");
            System.out.println("6. Exibir todos os contatos");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone do contato: ");
                    String telefone = scanner.nextLine();
                    agenda.adicionarContato(nome, telefone);
                    break;
                case 2:
                    System.out.print("Digite o nome do contato que deseja editar: ");
                    String nomeEditar = scanner.nextLine();
                    agenda.editarContato(nomeEditar);
                    break;
                case 3:
                    System.out.print("Digite o nome do contato que deseja remover: ");
                    String nomeRemover = scanner.nextLine();
                    agenda.removerContato(nomeRemover);
                    break;
                case 4:
                    System.out.print("Digite o nome do contato que deseja buscar: ");
                    String nomeBuscar = scanner.nextLine();
                    Contato contatoNome = agenda.buscarContatoPorNome(nomeBuscar);
                    if (contatoNome != null) {
                        System.out.println(contatoNome);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o telefone do contato que deseja buscar: ");
                    String telefoneBuscar = scanner.nextLine();
                    Contato contatoTelefone = agenda.buscarContatoPorTelefone(telefoneBuscar);
                    if (contatoTelefone != null) {
                        System.out.println(contatoTelefone);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 6:
                    agenda.exibirContatos();
                    break;
                case 7:
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