package legatura;

import oras.Oras;

public class Legatura {

    protected int km;
    Oras orasPlecare, orasDestinatie;

    public Legatura() {
    }

    public Legatura(int km, Oras orasPlecare, Oras orasDestinatie) {
        this.km = km;
        this.orasPlecare = orasPlecare;
        this.orasDestinatie = orasDestinatie;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Oras getOrasPlecare() {
        return orasPlecare;
    }

    public void setOrasPlecare(Oras orasPlecare) {
        this.orasPlecare = orasPlecare;
    }

    public Oras getOrasDestinatie() {
        return orasDestinatie;
    }

    public void setOrasDestinatie(Oras orasDestinatie) {
        this.orasDestinatie = orasDestinatie;
    }

    @Override
    public String toString() {
        return "Legatura{" +
                "km=" + km +
                ", orasPlecare=" + orasPlecare +
                ", orasDestinatie=" + orasDestinatie +
                '}';
    }
}
