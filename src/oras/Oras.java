package oras;

public class Oras {

    private String nume;

    public Oras(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "oras{" +
                "nume='" + nume + '\'' +
                '}';
    }

}
