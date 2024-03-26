public class App {

    public static void main(String[] args) {
        // Creazione del lucchetto con combinazione scelta dall'utente
        int[] combinazione = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Inserisci la cifra " + (i + 1) + " della combinazione (0-9):");
            combinazione[i] = Integer.parseInt(System.console().readLine());
        }
        Lucchetto lucchetto = new Lucchetto(combinazione);

        // Prove di apertura e chiusura
        System.out.println("Lucchetto coperto: " + lucchetto.seiAperto());
        System.out.println("Lucchetto chiuso: " + lucchetto.seiChiuso());
        System.out.println("Prova di apertura con chiave errata...");
        lucchetto.apri(new int[]{1, 2, 3});
        System.out.println("Lucchetto aperto: " + lucchetto.seiAperto());
        System.out.println("Prova di apertura con chiave corretta...");
        lucchetto.apri(combinazione);
        System.out.println("Lucchetto aperto: " + lucchetto.seiAperto());
        lucchetto.chiudi();
        System.out.println("Lucchetto chiuso: " + lucchetto.seiChiuso());

        // Comportamento dopo aver usato forza()
        lucchetto.forza();
        System.out.println("Lucchetto guasto: " + lucchetto.seiGuasto());
        System.out.println("Lucchetto aperto: " + lucchetto.seiAperto());
        System.out.println("Tentativo di apertura dopo forzatura...");
        lucchetto.apri(combinazione);
        System.out.println("Lucchetto aperto: " + lucchetto.seiAperto());
    }
}