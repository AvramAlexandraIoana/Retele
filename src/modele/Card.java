package modele;

import java.util.Arrays;

public class Card {

    TitularFirma titular;
    Tranzactie[] tranzactii;
    private double sold;

    public Card(TitularFirma titular, Tranzactie[] tranzactii, double sold) {
        this.titular = titular;
        this.tranzactii = tranzactii;
        this.sold = sold;
    }

    public Card() {
    }

    public TitularFirma getTitular() {
        return titular;
    }

    public void setTitular(TitularFirma titular) {
        this.titular = titular;
    }

    public Tranzactie[] getTranzactii() {
        return tranzactii;
    }

    public void setTranzactii(Tranzactie[] tranzactii) {
        this.tranzactii = tranzactii;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Card{" +
                "titular=" + titular +
                ", tranzactii=" + Arrays.toString(tranzactii) +
                ", sold=" + sold +
                '}';
    }


}
