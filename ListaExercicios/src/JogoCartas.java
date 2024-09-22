import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Carta {
    private String cor;
    private String valor;

    public Carta(String cor, String valor) {
        this.cor = cor;
        this.valor = valor;
    }

    public String getCor() {
        return cor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return cor + " " + valor;
    }
}

class JogoCartas {
    private ArrayList<Carta> baralho;
    private ArrayList<Carta> cartasJogador1;
    private ArrayList<Carta> cartasJogador2;
    private Carta cartaAtual;

    public JogoCartas() {
        baralho = new ArrayList<>();
        cartasJogador1 = new ArrayList<>();
        cartasJogador2 = new ArrayList<>();
        inicializarBaralho();
    }

    private void inicializarBaralho() {
        String[] cores = {"Vermelho", "Verde", "Azul", "Amarelo"};
        String[] valores = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Pular", "Reverso", "+2"};

        for (String cor : cores) {
            for (String valor : valores) {
                baralho.add(new Carta(cor, valor));
            }
        }
    }

    public void embaralharCartas() {
        Collections.shuffle(baralho);
        System.out.println("Baralho embaralhado.");
    }

    public void distribuirCartas() {
        for (int i = 0; i < 7; i++) {
            cartasJogador1.add(baralho.remove(0));
            cartasJogador2.add(baralho.remove(0));
        }
        cartaAtual = baralho.remove(0); // A primeira carta no centro do jogo
        System.out.println("Cartas distribuídas.");
    }

    private void exibirCartasJogador(ArrayList<Carta> cartas) {
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println((i + 1) + ". " + cartas.get(i));
        }
    }

    private void jogarCarta(ArrayList<Carta> cartasJogador, int indice) {
        Carta cartaJogada = cartasJogador.get(indice);
        if (cartaJogada.getCor().equals(cartaAtual.getCor()) || cartaJogada.getValor().equals(cartaAtual.getValor())) {
            cartaAtual = cartaJogada;
            cartasJogador.remove(indice);
            System.out.println("Você jogou: " + cartaJogada);
        } else {
            System.out.println("Jogada inválida. A carta deve ter a mesma cor ou valor.");
        }
    }

    public void jogadaJogador1() {
        System.out.println("Carta atual: " + cartaAtual);
        System.out.println("Suas cartas:");
        exibirCartasJogador(cartasJogador1);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha uma carta para jogar (número da carta): ");
        int escolha = scanner.nextInt();
        if (escolha > 0 && escolha <= cartasJogador1.size()) {
            jogarCarta(cartasJogador1, escolha - 1);
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    public void jogadaJogador2() {
        System.out.println("Carta atual: " + cartaAtual);
        System.out.println("Cartas do Jogador 2:");
        exibirCartasJogador(cartasJogador2);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Escolha uma carta para jogar (número da carta): ");
        int escolha = scanner.nextInt();
        if (escolha > 0 && escolha <= cartasJogador2.size()) {
            jogarCarta(cartasJogador2, escolha - 1);
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    private boolean verificarVitoria(ArrayList<Carta> cartasJogador) {
        return cartasJogador.isEmpty();
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        boolean jogoAtivo = true;

        embaralharCartas();
        distribuirCartas();

        while (jogoAtivo) {
            System.out.println("\nTurno do Jogador 1:");
            jogadaJogador1();
            if (verificarVitoria(cartasJogador1)) {
                System.out.println("Jogador 1 venceu!");
                break;
            }

            System.out.println("\nTurno do Jogador 2:");
            jogadaJogador2();
            if (verificarVitoria(cartasJogador2)) {
                System.out.println("Jogador 2 venceu!");
                break;
            }

            System.out.println("Continuar jogando? (1 - Sim / 2 - Não): ");
            int continuar = scanner.nextInt();
            if (continuar == 2) {
                jogoAtivo = false;
                System.out.println("Jogo encerrado.");
            }
        }
    }

    public static void main(String[] args) {
        JogoCartas jogo = new JogoCartas();
        jogo.iniciarJogo();
    }
}
