import java.util.Arrays;

public class Lucchetto {

    private int[] combinazione={-1,-1,-1};
    private boolean aperto;
    private boolean guasto;

    public Lucchetto(int[] combinazione) {
        if (!isValidCombinazione(combinazione)) {
            this.guasto = true;
            this.aperto = true;
            return;
        }
        this.combinazione = combinazione;
        this.aperto = true;
        this.guasto = false;
    }

    private boolean isValidCombinazione(int[] combinazione) {
        if (combinazione.length != 3) {
            return false;
        }
        for (int cifra : combinazione) {
            if (cifra < 0 || cifra > 9) {
                return false;
            }
        }
        return true;
    }

    public boolean seiGuasto() {
        return guasto;
    }

    public boolean seiAperto() {
        return aperto && !guasto;
    }

    public boolean seiChiuso() {
        return !aperto && !guasto;
    }

    public boolean apri(int[] chiave) {
        if (guasto) {
            return false;
        }
        if (Arrays.equals(chiave, combinazione)) {
            aperto = true;
            return true;
        }
        aperto = false;
        return false;
    }

    public boolean apri(int chiave) {
        int[] chiaveArray = {chiave / 100, (chiave % 100) / 10, chiave % 10};
        return apri(chiaveArray);
    }

    public boolean apri(String chiave) {
        if (chiave.length() < 3) {
            return false;
        }
        int[] chiaveArray = new int[3];
        for (int i = 0; i < 3; i++) {
            char c = chiave.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            chiaveArray[i] = c - '0';
        }
        return apri(chiaveArray);
    }

    public void chiudi() {
        if (!guasto && aperto) {
            aperto = false;
        }
    }

    public void forza() {
        guasto = true;
        aperto = true;
    }
}
