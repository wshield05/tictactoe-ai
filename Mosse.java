import java.util.Scanner;

public class Mosse {
    public static boolean checkIfHumanWinning(Giocatore humanPlayer, Giocatore cpuPlayer) {
        if (!checkObliquo(humanPlayer, cpuPlayer)) {
            if (!checkVerticali(humanPlayer, cpuPlayer)) {
                if (!checkOrizzontali(humanPlayer, cpuPlayer)) {
                    return false;
                } else
                    return true;
            } else
                return true;
        } else
            return true;
    }

    private static boolean checkObliquo(Giocatore humanPlayer, Giocatore cpuPlayer) {
        if (humanPlayer.pedine[4] && humanPlayer.pedine[6]) {
            cpuPlayer.pedine[2] = true;
            return true;
        }
        if (humanPlayer.pedine[8] && humanPlayer.pedine[4]) {
            cpuPlayer.pedine[0] = true;
            return true;
        } else
            return false;
    }

    private static boolean checkVerticali(Giocatore humanPlayer, Giocatore cpuPlayer) {
        if (humanPlayer.pedine[6] && humanPlayer.pedine[3]) {
            cpuPlayer.pedine[0] = true;
            return true;
        }
        if (humanPlayer.pedine[7] && humanPlayer.pedine[4]) {
            cpuPlayer.pedine[1] = true;
            return true;
        }
        if (humanPlayer.pedine[8] && humanPlayer.pedine[5]) {
            cpuPlayer.pedine[2] = true;
            return true;
        }
        if (humanPlayer.pedine[5] && humanPlayer.pedine[2]) {
            cpuPlayer.pedine[8] = true;
            return true;
        }
        if (humanPlayer.pedine[4] && humanPlayer.pedine[1]) {
            cpuPlayer.pedine[7] = true;
            return true;
        }
        if (humanPlayer.pedine[3] && humanPlayer.pedine[0]) {
            cpuPlayer.pedine[6] = true;
            return true;
        } else
            return false;
    }

    private static boolean checkOrizzontali(Giocatore humanPlayer, Giocatore cpuPlayer) {
        if (humanPlayer.pedine[0] && humanPlayer.pedine[1]) {
            cpuPlayer.pedine[2] = true;
            return true;
        }
        if (humanPlayer.pedine[3] && humanPlayer.pedine[4]) {
            cpuPlayer.pedine[5] = true;
            return true;
        }
        if (humanPlayer.pedine[6] && humanPlayer.pedine[7]) {
            cpuPlayer.pedine[8] = true;
            return true;
        }
        if (humanPlayer.pedine[7] && humanPlayer.pedine[8]) {
            cpuPlayer.pedine[6] = true;
            return true;
        }
        if (humanPlayer.pedine[4] && humanPlayer.pedine[5]) {
            cpuPlayer.pedine[3] = true;
            return true;
        }
        if (humanPlayer.pedine[1] && humanPlayer.pedine[2]) {
            cpuPlayer.pedine[0] = true;
            return true;
        } else
            return false;
    }
}
/*
Condizioni:

4,6->2 (obliquo 1) fatto
8,4->0 (obliquo 2) fatto
vert
6,3->0 fatto
7,4->1 fatto
8,5->2 fatto
5,2->8 fatto
4,1->7 fatto
3,0->6 fatto
orizz
0,1->2 fatto
3,4->5 fatto
6,7->8 fatto
7,8->6 fatto
4,5->3 fatto
1,2->0 fatto

sì, ho hardcodato tutto.
 */
