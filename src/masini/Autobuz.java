package masini;

public class Autobuz extends Masina implements Comparable <Autobuz> {

    protected int nrLocuri;

    public Autobuz(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public Autobuz(String marca, int anFabricatie, String nrInmatriculare, int nrLocuri) {
        super(marca, anFabricatie, nrInmatriculare);
        this.nrLocuri = nrLocuri;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    public int compareTo(Autobuz ob)
    {
        return this.nrLocuri - ob.getNrLocuri();
    }

    @Override
    public String toString() {
        return "Autobuz{" + super.toString() +
                "nrLocuri=" + nrLocuri +
                '}';
    }
}
