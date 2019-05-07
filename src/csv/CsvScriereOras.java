package csv;

import oras.Oras;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvScriereOras {

    private static final String delimitator = ",";
    private static final String linieNoua = "\n";

    private static final String inceputFisier = "nume";

    public static void scriereCsvFisierOras(String numeFisier){

        Oras oras1 = new Oras("Bucuresti");
        Oras oras2 = new Oras("Cluj");
        Oras oras3 = new Oras("Iasi");
        Oras oras4 = new Oras("Timisoara");
        Oras oras5 = new Oras("Targu-Jiu");
        Oras oras6 = new Oras("Ploiesti");

        List<Oras> orase = new ArrayList<>();
        orase.add(oras1);
        orase.add(oras2);
        orase.add(oras3);
        orase.add(oras4);
        orase.add(oras5);
        orase.add(oras6);

        FileWriter fisierCitire = null;

        try{
            fisierCitire = new FileWriter(numeFisier);

            fisierCitire.append(inceputFisier.toString());
            fisierCitire.append(linieNoua);

            for(Oras oras : orase){
                fisierCitire.append(oras.getNume());
                fisierCitire.append(linieNoua);
            }
            System.out.println("Fisierul CSV a fost creat cu succes!");
        } catch (Exception e){
            System.out.println("Eroare in CsvSciereOras!");
            e.printStackTrace();
        }finally {
            try {
                fisierCitire.flush();
                fisierCitire.close();
            }catch (IOException e){
                System.out.println("Eroare cand punem in fisier sau il inchidem!");
                e.printStackTrace();
            }
        }
        }
}
