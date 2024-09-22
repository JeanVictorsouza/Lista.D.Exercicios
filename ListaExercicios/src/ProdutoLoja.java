import java.util.ArrayList;
import java.util.Scanner;

class ProdutoLoja {
    private String nome;
    private double preco;
    private int quantidade;

    public ProdutoLoja(String nome, double preco, int quantidade) {
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

    public double calcularTotal(int quantidadeComprada) {
        return preco * quantidadeComprada;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + ", Preço: " + preco + ", Quantidade em Estoque: " + quantidade;
    }
}

class Carrinho {
    private ArrayList<ProdutoLoja> produtos;
    private ArrayList<Integer> quantidades;

    public Carrinho() {
        produtos = new ArrayList<>();
        quantidades = new ArrayList<>();
    }

    public void adicionarProduto(ProdutoLoja produto, int quantidade) {
        produtos.add(produto);
        quantidades.add(quantidade);
        produto.diminuirEstoque(quantidade);
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).calcularTotal(quantidades.get(i));
        }
        return total;
    }

    public void exibirCarrinho() {
        System.out.println("\nCarrinho de Compras:");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("Produto: " + produtos.get(i).getNome() + ", Quantidade: " + quantidades.get(i));
        }
    }
}

class LojaVirtual {
    private ArrayList<ProdutoLoja> produtos;

    public LojaVirtual() {
        produtos = new ArrayList<>();
    }

    public void cadastrarProduto(String nome, double preco, int quantidade) {
        ProdutoLoja novoProduto = new ProdutoLoja(nome, preco, quantidade);
        produtos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public ProdutoLoja buscarProduto(String nome) {
        for (ProdutoLoja produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public void exibirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (ProdutoLoja produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LojaVirtual loja = new LojaVirtual();
        Carrinho carrinho = new Carrinho();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Exibir produtos");
            System.out.println("3. Adicionar produto ao carrinho");
            System.out.println("4. Exibir carrinho");
            System.out.println("5. Calcular valor total");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Digite a quantidade em estoque: ");
                    int quantidade = scanner.nextInt();
                    loja.cadastrarProduto(nome, preco, quantidade);
                    break;
                case 2:
                    loja.exibirProdutos();
                    break;
                case 3:
                    System.out.print("Digite o nome do produto que deseja adicionar ao carrinho: ");
                    String nomeProduto = scanner.nextLine();
                    ProdutoLoja produto = loja.buscarProduto(nomeProduto);
                    if (produto != null) {
                        System.out.print("Digite a quantidade que deseja comprar: ");
                        int quantidadeComprada = scanner.nextInt();
                        if (quantidadeComprada <= produto.getQuantidade()) {
                            carrinho.adicionarProduto(produto, quantidadeComprada);
                            System.out.println("Produto adicionado ao carrinho!");
                        } else {
                            System.out.println("Quantidade indisponível em estoque.");
                        }
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 4:
                    carrinho.exibirCarrinho();
                    break;
                case 5:
                    double total = carrinho.calcularTotal();
                    System.out.println("Valor total da compra: R$ " + total);
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