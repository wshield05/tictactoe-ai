public class ChooseMoves {
    public static void checkPossibleMoves(Giocatore currentPlayer, Giocatore avversario) {
        if (!bestPossibleOutcome(currentPlayer, avversario)) {//verifica se la posizione migliore (la casella centrale) è occupata
            if (!pedinaAngoli(currentPlayer, avversario)) {//verifica se una delle celle agli angoli è disponibile
                if (!alternative(currentPlayer, avversario))//verifica se una delle altre celle è disponibile
                    System.out.println("Non ci sono celle disponibili!");//a questo punto non ci sono celle disponibili: verifica chi ha vinto.
            }
        }
    }

    private static boolean bestPossibleOutcome(Giocatore currentPlayer, Giocatore avversario) {
        if (!avversario.pedine[4]) {
            currentPlayer.pedine[4] = true;
            return true;
        } else
            return false;
    }

    private static boolean pedinaAngoli(Giocatore currentPlayer, Giocatore avversario) {
        //if (!currentPlayer.bestPossibleOutcome(avversario)) //mettere nel metodo principale
        double randInt;
        boolean exitFlag = false;
        final double FIRST_POSSIBILITY = 0.225; //0.9/4 possibilità
        final double SECOND_POSSIBILITY = 0.45;
        final double THIRD_POSSIBILITY = 0.9;
        final int FIRST_POS=0;
        final int SEC_POS=2;
        final int THIRD_POS=6;
        final int FOURTH_POS=8;
        do {
            randInt = Math.random();
            if (randInt <= FIRST_POSSIBILITY) {
                if (!Giocatore.isValid(currentPlayer, avversario, FIRST_POS)) {
                    currentPlayer.pedine[FIRST_POS] = true;
                    exitFlag = true;
                }
            }
            if (randInt <= FIRST_POSSIBILITY) {
                if (!Giocatore.isValid(currentPlayer, avversario, SEC_POS)) {
                    currentPlayer.pedine[SEC_POS] = true;
                    exitFlag = true;
                }
            }
            if (randInt <= FIRST_POSSIBILITY) {
                if (!Giocatore.isValid(currentPlayer, avversario, THIRD_POS)) {
                    currentPlayer.pedine[THIRD_POS] = true;
                    exitFlag = true;
                }
            } else {
                if (!Giocatore.isValid(currentPlayer, avversario, FOURTH_POS)) {
                    currentPlayer.pedine[FOURTH_POS] = true;
                    exitFlag = true;
                }
            }
        }
        while (!exitFlag);
        if (exitFlag)
            return true;
        else
            return false;
    }

    private static boolean alternative(Giocatore currentPlayer, Giocatore avversario) {
        double randInt;
        boolean exitFlag = false;
        final double FIRST_POSSIBILITY = 0.225; //0.9/4 possibilità
        final double SECOND_POSSIBILITY = 0.45;
        final double THIRD_POSSIBILITY = 0.9;
        do {
            randInt = Math.random();
            if (randInt <= FIRST_POSSIBILITY) {
                if (!avversario.pedine[1] && !currentPlayer.pedine[1]) {
                    currentPlayer.pedine[1] = true;
                    exitFlag = true;
                }
            }
            if (randInt <= SECOND_POSSIBILITY) {
                if (!avversario.pedine[3] && !currentPlayer.pedine[3]) {
                    currentPlayer.pedine[3] = true;
                    exitFlag = true;
                }
            }
            if (randInt <= THIRD_POSSIBILITY) {
                if (!avversario.pedine[5] && !currentPlayer.pedine[5]) {
                    currentPlayer.pedine[5] = true;
                    exitFlag = true;
                }
            } else {
                if (!avversario.pedine[7] && !currentPlayer.pedine[7]) {
                    currentPlayer.pedine[7] = true;
                    exitFlag = true;
                }
            }
        }
        while (!exitFlag);
        if (exitFlag)
            return true;
        else
            return false;
    }
}
