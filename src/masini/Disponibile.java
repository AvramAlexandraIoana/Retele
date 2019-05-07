package masini;

import legatura.Legatura;

import java.util.Arrays;

public class Disponibile {

    private Autobuz[] disponibile;
    protected int numarAutobuze;
    private Microbuz[] disponibile1;
    protected int  numarMicrobuze;
    private Legatura[] legaturi;

    public Disponibile() {
    }

    public Disponibile(Autobuz[] disponibile, int numarAutobuze, Microbuz[] disponibile1, int numarMicrobuze, Legatura[] legaturi) {
        this.disponibile = disponibile;
        this.numarAutobuze = numarAutobuze;
        this.disponibile1 = disponibile1;
        this.numarMicrobuze = numarMicrobuze;
        this.legaturi = legaturi;
    }

    public Autobuz[] getDisponibile() {
        return disponibile;
    }

    public void setDisponibile(Autobuz[] disponibile) {
        this.disponibile = disponibile;
    }

    public int getNumarAutobuze() {
        return numarAutobuze;
    }

    public void setNumarAutobuze(int numarAutobuze) {
        this.numarAutobuze = numarAutobuze;
    }

    public Microbuz[] getDisponibile1() {
        return disponibile1;
    }

    public void setDisponibile1(Microbuz[] disponibile1) {
        this.disponibile1 = disponibile1;
    }

    public int getNumarMicrobuze() {
        return numarMicrobuze;
    }

    public void setNumarMicrobuze(int numarMicrobuze) {
        this.numarMicrobuze = numarMicrobuze;
    }

    public Legatura[] getLegaturi() {
        return legaturi;
    }

    public void setLegaturi(Legatura[] legaturi) {
        this.legaturi = legaturi;
    }

    @Override
    public String toString() {
        return "Disponibile{" +
                "disponibile=" + Arrays.toString(disponibile) +
                ", numarAutobuze=" + numarAutobuze +
                ", disponibile1=" + Arrays.toString(disponibile1) +
                ", numarMicrobuze=" + numarMicrobuze +
                ", legaturi=" + Arrays.toString(legaturi) +
                '}';
    }
}
