import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Usuario {
    private String nome;
    private ArrayList<String> amigos;
    private ArrayList<String> posts;

    public Usuario(String nome) {
        this.nome = nome;
        this.amigos = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarAmigo(String amigo) {
        amigos.add(amigo);
        System.out.println(amigo + " adicionado como amigo.");
    }

    public void exibirAmigos() {
        System.out.println("Amigos de " + nome + ":");
        for (String amigo : amigos) {
            System.out.println("- " + amigo);
        }
    }

    public void publicarPost(String post) {
        posts.add(post);
        System.out.println("Post publicado: " + post);
    }

    public void exibirPosts() {
        System.out.println("Posts de " + nome + ":");
        for (String post : posts) {
            System.out.println("- " + post);
        }
    }

    public void comentarPost(int postIndex, String comentario) {
        if (postIndex >= 0 && postIndex < posts.size()) {
            String postAtualizado = posts.get(postIndex) + "\n  Comentário: " + comentario;
            posts.set(postIndex, postAtualizado);
            System.out.println("Comentário adicionado ao post.");
        } else {
            System.out.println("Post inválido.");
        }
    }
}

class RedeSocial {
    private HashMap<String, Usuario> usuarios;

    public RedeSocial() {
        this.usuarios = new HashMap<>();
    }

    public void cadastrarUsuario(String nome) {
        if (!usuarios.containsKey(nome)) {
            usuarios.put(nome, new Usuario(nome));
            System.out.println("Usuário " + nome + " cadastrado.");
        } else {
            System.out.println("Usuário já existe.");
        }
    }

    public Usuario buscarUsuario(String nome) {
        return usuarios.get(nome);
    }

    public void adicionarAmigo(String nomeUsuario, String nomeAmigo) {
        Usuario usuario = buscarUsuario(nomeUsuario);
        Usuario amigo = buscarUsuario(nomeAmigo);

        if (usuario != null && amigo != null) {
            usuario.adicionarAmigo(nomeAmigo);
            amigo.adicionarAmigo(nomeUsuario);
        } else {
            System.out.println("Um ou ambos os usuários não foram encontrados.");
        }
    }

    public void publicarPost(String nomeUsuario, String post) {
        Usuario usuario = buscarUsuario(nomeUsuario);
        if (usuario != null) {
            usuario.publicarPost(post);
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void comentarPost(String nomeUsuario, String nomeAutor, int postIndex, String comentario) {
        Usuario usuario = buscarUsuario(nomeAutor);
        if (usuario != null) {
            usuario.comentarPost(postIndex, comentario);
        } else {
            System.out.println("Usuário ou post não encontrado.");
        }
    }

    public void exibirUsuarios() {
        System.out.println("Usuários cadastrados:");
        for (String nome : usuarios.keySet()) {
            System.out.println("- " + nome);
        }
    }

    public static void main(String[] args) {
        RedeSocial rede = new RedeSocial();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Adicionar amigo");
            System.out.println("3. Publicar post");
            System.out.println("4. Comentar post");
            System.out.println("5. Buscar usuário");
            System.out.println("6. Exibir usuários");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do novo usuário: ");
                    String nome = scanner.nextLine();
                    rede.cadastrarUsuario(nome);
                    break;

                case 2:
                    System.out.print("Seu nome: ");
                    String seuNome = scanner.nextLine();
                    System.out.print("Nome do amigo a ser adicionado: ");
                    String nomeAmigo = scanner.nextLine();
                    rede.adicionarAmigo(seuNome, nomeAmigo);
                    break;

                case 3:
                    System.out.print("Seu nome: ");
                    String nomePost = scanner.nextLine();
                    System.out.print("Conteúdo do post: ");
                    String post = scanner.nextLine();
                    rede.publicarPost(nomePost, post);
                    break;

                case 4:
                    System.out.print("Nome do autor do post: ");
                    String nomeAutor = scanner.nextLine();
                    System.out.print("Índice do post (começa em 0): ");
                    int postIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Comentário: ");
                    String comentario = scanner.nextLine();
                    rede.comentarPost(nomeAutor, nomeAutor, postIndex, comentario);
                    break;

                case 5:
                    System.out.print("Nome do usuário: ");
                    String nomeBusca = scanner.nextLine();
                    Usuario usuario = rede.buscarUsuario(nomeBusca);
                    if (usuario != null) {
                        System.out.println("Usuário encontrado: " + usuario.getNome());
                        usuario.exibirAmigos();
                        usuario.exibirPosts();
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 6:
                    rede.exibirUsuarios();
                    break;

                case 7:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}