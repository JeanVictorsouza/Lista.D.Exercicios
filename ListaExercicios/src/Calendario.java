import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Scanner;

class Calendario {
    private static HashMap<String, String> feriados = new HashMap<>();
    public Calendario() {
        feriados.put("01-01", "Ano Novo");
        feriados.put("07-09", "Independência do Brasil");
        feriados.put("25-12", "Natal");
        // Adicionar mais feriados conforme necessário
    }

    public void exibirCalendario(int ano, int mes) {
        System.out.println("\nCalendário de " + getNomeMes(mes) + " de " + ano);
        LocalDate primeiroDia = LocalDate.of(ano, mes, 1);
        int diasNoMes = primeiroDia.lengthOfMonth();

        System.out.println("Dom  Seg  Ter  Qua  Qui  Sex  Sáb");
        int diaSemanaInicio = primeiroDia.getDayOfWeek().getValue() % 7; // Ajusta para começar no domingo

        for (int i = 0; i < diaSemanaInicio; i++) {
            System.out.print("     "); // Espaço para os dias vazios no início do mês
        }

        for (int dia = 1; dia <= diasNoMes; dia++) {
            System.out.printf("%3d  ", dia);
            if ((dia + diaSemanaInicio) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public void verificarFeriado(int dia, int mes) {
        String chave = String.format("%02d-%02d", dia, mes);
        if (feriados.containsKey(chave)) {
            System.out.println("A data " + dia + "/" + mes + " é um feriado: " + feriados.get(chave));
        } else {
            System.out.println("A data " + dia + "/" + mes + " não é um feriado.");
        }
    }

    public long calcularDiferencaDias(int dia1, int mes1, int ano1, int dia2, int mes2, int ano2) {
        LocalDate data1 = LocalDate.of(ano1, mes1, dia1);
        LocalDate data2 = LocalDate.of(ano2, mes2, dia2);
        return ChronoUnit.DAYS.between(data1, data2);
    }

    private String getNomeMes(int mes) {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return meses[mes - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calendario calendario = new Calendario();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Exibir calendário de um mês");
            System.out.println("2. Verificar se uma data é feriado");
            System.out.println("3. Calcular diferença de dias entre duas datas");
            System.out.println("4. Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ano: ");
                    int ano = scanner.nextInt();
                    System.out.print("Digite o mês (1-12): ");
                    int mes = scanner.nextInt();
                    calendario.exibirCalendario(ano, mes);
                    break;
                case 2:
                    System.out.print("Digite o dia: ");
                    int diaFeriado = scanner.nextInt();
                    System.out.print("Digite o mês (1-12): ");
                    int mesFeriado = scanner.nextInt();
                    calendario.verificarFeriado(diaFeriado, mesFeriado);
                    break;
                case 3:
                    System.out.print("Digite a primeira data (dia mês ano): ");
                    int dia1 = scanner.nextInt();
                    int mes1 = scanner.nextInt();
                    int ano1 = scanner.nextInt();
                    System.out.print("Digite a segunda data (dia mês ano): ");
                    int dia2 = scanner.nextInt();
                    int mes2 = scanner.nextInt();
                    int ano2 = scanner.nextInt();
                    long diferenca = calendario.calcularDiferencaDias(dia1, mes1, ano1, dia2, mes2, ano2);
                    System.out.println("A diferença entre as datas é de " + diferenca + " dias.");
                    break;
                case 4:
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