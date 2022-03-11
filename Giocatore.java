import java.util.Scanner;

public class Giocatore {

    public boolean pedine[] = {false, false, false, false, false, false, false, false, false};
    public String nomePlayer;
    public char segno;
    

    public Giocatore(String nomePlayer, boolean isTurno) {
        if (isTurno) {
            this.nomePlayer = nomePlayer;
            this.segno = 'X';
        } else {
            this.nomePlayer = nomePlayer;
            this.segno = 'O';
        }
    }

    public static void userMove(Giocatore currentPlayer, Giocatore avversario) {
        int numCell = -1;
        Scanner tast = new Scanner(System.in);
        do {
            System.out.print("Seleziona una cella che non sia gia' occupata: ");
            numCell = tast.nextInt();
            if (checkIfOccupied(avversario, numCell))
                System.out.println("Cella gia' occupata. Scegline un'altra.");
        }
        while (!isValid(avversario, currentPlayer, numCell));
    }

    private static boolean checkIfOccupied(Giocatore avversario, int numCell) {
        if (avversario.pedine[numCell])
            return true;
        else
            return false;
    }

    public static boolean isValid(Giocatore avversario, Giocatore currentPlayer, int numCell) {
        if (!avversario.pedine[numCell] && !currentPlayer.pedine[numCell])
            return true;
        else
            return false;
    }

    public static char startMatch() {
		Scanner tast = new Scanner(System.in);
		System.out.print("Ciao " + getNome() + "! Vuoi iniziare facendo la prima mossa? (S/N): ");
        char t = tast.next().charAt(0);
		return t;
		
    }
	public static String getNome(){
		
		Scanner tast = new Scanner(System.in);
        System.out.print("\nInserisci il tuo nome: ");
        String n = tast.nextLine();
        return n;
	}
    public boolean haVinto() {
        if (trisOrizzontale() || trisVerticale() || trisDiagonaleSx() || trisDiagonaleDx())
            return true;
        else
            return false;
    }

    private boolean trisOrizzontale() {
        if ((pedine[3] && pedine[4] && pedine[5]) || (pedine[6] && pedine[7] && pedine[8]) || (pedine[0] && pedine[1] && pedine[2]))
            return true;
        else
            return false;
    }

    private boolean trisVerticale() {
        if ((pedine[7] && pedine[4] && pedine[1]) || (pedine[6] && pedine[3] && pedine[0]) || (pedine[8] && pedine[5] && pedine[2]))
            return true;
        else
            return false;
    }

    private boolean trisDiagonaleSx() {
        if (pedine[6] && pedine[4] && pedine[2])
            return true;
        else
            return false;
    }

    private boolean trisDiagonaleDx() {
        if (pedine[0] && pedine[4] && pedine[8])
            return true;
        else
            return false;
    }

}
