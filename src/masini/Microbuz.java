package masini;

public class Microbuz extends Masina {

    protected String numeSofer;


    public Microbuz(String numeSofer) {
        this.numeSofer = numeSofer;
    }

    public Microbuz(String marca, int anFabricatie, String nrInmatriculare, String numeSofer) {
        super(marca, anFabricatie, nrInmatriculare);
        this.numeSofer = numeSofer;
    }

    public String getNumeSofer() {
        return numeSofer;
    }

    public void setNumeSofer(String numeSofer) {
        this.numeSofer = numeSofer;
    }

    @Override
    public String toString() {
        return "Microbuz{" + super.toString() +
                ",numeSofer='" + numeSofer + '\'' +
                '}';
    }
}
