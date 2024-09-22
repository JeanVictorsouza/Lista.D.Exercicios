import java.util.Random;
import java.util.Scanner;

class JogoAdivinhacao {
    private int numeroSecreto;
    private int tentativas;

    public JogoAdivinhacao() {
        Random random = new Random();
        numeroSecreto = random.nextInt(100) + 1; // Gera um número entre 1 e 100
        tentativas = 0;
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        boolean acertou = false;

        System.out.println("Bem-vindo ao Jogo de Adivinhação!");
        System.out.println("Eu escolhi um número entre 1 e 100. Tente adivinhar!");

        while (!acertou) {
            System.out.print("Digite seu palpite: ");
            int palpite = scanner.nextInt();
            tentativas++;

            if (palpite < 1 || palpite > 100) {
                System.out.println("Por favor, escolha um número entre 1 e 100.");
            } else if (palpite < numeroSecreto) {
                System.out.println("Seu palpite é menor que o número secreto.");
            } else if (palpite > numeroSecreto) {
                System.out.println("Seu palpite é maior que o número secreto.");
            } else {
                System.out.println("Parabéns! Você acertou o número em " + tentativas + " tentativas.");
                acertou = true;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        JogoAdivinhacao jogo = new JogoAdivinhacao();
        jogo.jogar();
    }
}