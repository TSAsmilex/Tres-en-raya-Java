import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        clearScreen();
        System.out.println("¡Bienvenido!");
        Thread.sleep(1200);

        var firstPlayerStarts = (new Random()).nextBoolean();
        var player1 = firstPlayerStarts? Options.X : Options.O;
        var player2 = firstPlayerStarts? Options.O : Options.X;

        var players = new Options[] {player1, player2};
        var current = 0;

        System.out.println("Empieza el jugador " + players[current]);
        Thread.sleep(2000);
        clearScreen();

        var game = new Board();
        Scanner scan = new Scanner(System.in);

        while (!game.finished()) {
            clearScreen();
            System.out.println(game.toString());
            System.out.println("Mueve ficha, jugador " + players[current].toString());

            int i = -1, j = -1;

            try {
                do {
                    i = scan.nextInt();
                    j = scan.nextInt();
                } while (!game.put(i-1, j-1, players[current]));

                current = (current + 1) % 2;
            }
            catch (InputMismatchException e) {
                scan.nextLine();
            }
        }

        scan.close();

        clearScreen();
        System.out.println(game.toString());
        System.out.println("¡Enhorabuena! Has ganado, jugador " + players[current].toString() + ".") ;
        Thread.sleep(100);
        System.out.println("Eres un máquina fiera mastodonte.");
        Thread.sleep(500);
    }


    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
