import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {

    public static void main(String[] args) {
        Random gerador = new Random();
        int numero = gerador.nextInt(100) + 1;
        int tentativas = 0;
        int chances = 10;
        boolean acertou = false;
        List<Integer> chutes = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Chute um número de 1 a 100.");

        while (tentativas < chances) {
            System.out.printf("Tentativa %d de %d. Qual seu chute? ", tentativas + 1, chances);
            int chute = scanner.nextInt();

            if (chutes.contains(chute)) {
                System.out.println("Você já digitou esse número, digite outro.");
                continue;
            }

            chutes.add(chute);
            tentativas++;

            if (chute == numero) {
                acertou = true;
                break;
            } else if (chute < numero) {
                System.out.println("O número é mais alto");
            } else {
                System.out.println("O número é mais baixo");
            }
        }

        if (acertou) {
            System.out.printf("Você acertou o número com %d tentativas.\n", tentativas);
        } else {
            System.out.printf("Seus %d chutes esgotaram. O número era %d.\n", chances, numero);
        }

        scanner.close();
    }
}