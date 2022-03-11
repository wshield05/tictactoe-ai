public class Main {
    public static void main(String[] args) {
        String n = Giocatore.getNome();
        String nomeGiocatore;
        boolean isTurno;
        if (Giocatore.startMatch() == 's' || Giocatore.startMatch() == 'S') {

            Main giocatore1 = new Giocatore(n, true);
            Main giocatoreIA = new Giocatore("PC", false);
        } else {
            Main giocatoreIA = new Giocatore("PC", true);
            Main giocatore1 = new Giocatore(n, false);
        }
        
        Metodi.play(Main.giocatore1, Main.giocatoreIA);
    }
}
