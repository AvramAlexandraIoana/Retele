package masini;

public class Masina {

    private String marca;
    private int anFabricatie;
    private String nrInmatriculare;

    public Masina() {
    }

    public Masina(String marca, int anFabricatie, String nrInmatriculare) {
        this.marca = marca;
        this.anFabricatie = anFabricatie;
        this.nrInmatriculare = nrInmatriculare;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "marca='" + marca + '\'' +
                ", anFabricatie=" + anFabricatie +
                ", nrInmatriculare='" + nrInmatriculare + '\'' +
                '}';
    }
}
