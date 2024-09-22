import java.util.ArrayList;
import java.util.Scanner;

class ProdutosVendidos {
    private String nome;
    private double preco;
    private int quantidade;

    public ProdutosVendidos(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void diminuirEstoque(int quantidadeComprada) {
        if (quantidade >= quantidadeComprada) {
            quantidade -= quantidadeComprada;
        }
    }

    @Override
    public String toString() {
        return "Produto: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade;
    }
}

class MaquinaDeVendas {
    private ArrayList<ProdutosVendidos> produtos;
    private double saldo;

    public MaquinaDeVendas() {
        produtos = new ArrayList<>();
        saldo = 0.0;
    }

    public void cadastrarProduto(String nome, double preco, int quantidade) {
        ProdutosVendidos novoProduto = new ProdutosVendidos(nome, preco, quantidade);
        produtos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível.");
        } else {
            System.out.println("Produtos disponíveis:");
            for (ProdutosVendidos produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public void inserirDinheiro(double valor) {
        saldo += valor;
        System.out.println("Você inseriu R$ " + valor);
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void selecionarProduto(String nomeProduto) {
        ProdutosVendidos produto = buscarProduto(nomeProduto);
        if (produto != null) {
            if (produto.getQuantidade() > 0) {
                if (saldo >= produto.getPreco()) {
                    saldo -= produto.getPreco();
                    produto.diminuirEstoque(1);
                    System.out.println("Você comprou: " + produto.getNome());
                    System.out.println("Saldo restante: R$ " + saldo);
                } else {
                    System.out.println("Saldo insuficiente para comprar " + produto.getNome());
                }
            } else {
                System.out.println("Produto esgotado.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
    private ProdutosVendidos buscarProduto(String nome) {
        for (ProdutosVendidos produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public void devolverTroco() {
        if (saldo > 0) {
            System.out.println("Seu troco é: R$ " + saldo);
            saldo = 0.0;
        } else {
            System.out.println("Nenhum saldo para devolver.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaquinaDeVendas maquina = new MaquinaDeVendas();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Exibir produtos");
            System.out.println("3. Inserir dinheiro");
            System.out.println("4. Comprar produto");
            System.out.println("5. Devolver troco");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Digite a quantidade em estoque: ");
                    int quantidade = scanner.nextInt();
                    maquina.cadastrarProduto(nome, preco, quantidade);
                    break;
                case 2:
                    maquina.exibirProdutos();
                    break;
                case 3:
                    System.out.print("Digite o valor a ser inserido: ");
                    double valor = scanner.nextDouble();
                    maquina.inserirDinheiro(valor);
                    break;
                case 4:
                    System.out.print("Digite o nome do produto que deseja comprar: ");
                    String nomeProduto = scanner.nextLine();
                    maquina.selecionarProduto(nomeProduto);
                    break;
                case 5:
                    maquina.devolverTroco();
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