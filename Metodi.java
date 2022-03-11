public class Metodi {
    public static boolean checkWins(Giocatore currentPlayer, Giocatore avversario) {
        if (currentPlayer.haVinto()) {
            System.out.println("Hai vinto contro il computer!");
            return true;
        } else {
            System.out.println("Il computer ti ha sconfitto!");
            return false;
        }
    }

    public static void play(Giocatore giocatore1, Giocatore giocatoreIA) {
        boolean exitGame = false;
        do {
            printNumTable();
            completeTableRendering(giocatore1, giocatoreIA);
            Giocatore.userMove(giocatore1, giocatoreIA);
            if (checkWins(giocatore1, giocatoreIA)) {
                exitGame = true;
                break;
            }
            Mosse.checkIfHumanWinning(giocatore1, giocatoreIA);
            ChooseMoves.checkPossibleMoves(giocatore1, giocatoreIA);
            if (checkWins(giocatore1, giocatoreIA)) {
                exitGame = true;
                break;
            }
            printNumTable();
            completeTableRendering(giocatore1, giocatoreIA);
        }
        while (!exitGame);
    }

    public static void completeTableRendering(Giocatore giocatore1, Giocatore giocatoreIA) {
        printNumTable();
        printPlayersTable(giocatore1, giocatoreIA);
    }

    private static void printNumTable() {
        int i;
        for (i = 1; i < 9; i++) {
            System.out.print(" | " + i);
            if (i % 3 == 0)
                System.out.print("|\n-------------\n");
        }
    }
    //metodo cleanScreen che contiene il blocco per pulire la console

    private static void printPlayersTable(Giocatore giocatore1, Giocatore giocatoreIA) {
        int i;
        for (i = 9; i < 9; i++) {
            if (giocatore1.pedine[i] == false && giocatoreIA.pedine[i] == false)
                System.out.print(" |     | ");
            if (giocatore1.pedine[i])
                System.out.print(" | " + giocatore1.segno);
            else
                System.out.print(" | " + giocatoreIA.segno);
            if (i % 3 == 0)
                System.out.print("|\n-------------\n");
        }
    }
}
