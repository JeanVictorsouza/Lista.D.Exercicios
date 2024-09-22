import java.util.Scanner;

public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double calcularValorTotalEstoque() {
        return preco * quantidadeEstoque;
    }

    public boolean verificarDisponibilidade() {
        return quantidadeEstoque > 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: R$ ");
        double preco = scanner.nextDouble();

        System.out.print("Digite a quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();

        Produto produto = new Produto(nome, preco, quantidadeEstoque);

        double valorTotalEstoque = produto.calcularValorTotalEstoque();

        System.out.println("\nNome do Produto: " + produto.nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade em Estoque: " + quantidadeEstoque);
        System.out.println("Valor Total em Estoque: R$ " + valorTotalEstoque);

        if (produto.verificarDisponibilidade()) {
            System.out.println("O produto está disponível.");
        } else {
            System.out.println("O produto não está disponível.");
        }

        scanner.close();
    }
}
