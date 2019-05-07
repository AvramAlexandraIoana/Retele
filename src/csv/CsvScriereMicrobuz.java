package csv;

import masini.Microbuz;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CsvScriereMicrobuz {

    private static final String delimitator = ",";
    private static final String linieNoua = "\n";

    private static final String inceputFisier = "marca,anFabricatie,nrInmatriculare,nume";

    public static void scriereCsvFisierMicrobuz(String numeFisier) {

        Microbuz microbuz1 = new Microbuz("BMW", 2007, "CJ123", "Ionel");
        Microbuz microbuz2 = new Microbuz("AUDI", 2018, "B1223", "Maria");
        Microbuz microbuz3 = new Microbuz("LOGAN", 2010, "GJ123", "Dan");
        Microbuz microbuz4 = new Microbuz("PASSAT", 2015, "DJ123", "Iulia");

        List<Microbuz> microbuze = new ArrayList<>();
        microbuze.add(microbuz1);
        microbuze.add(microbuz2);
        microbuze.add(microbuz3);
        microbuze.add(microbuz4);

        FileWriter fisierScriere = null;

        try {
            fisierScriere = new FileWriter(numeFisier);

            fisierScriere.append(inceputFisier);

            fisierScriere.append(linieNoua);


            for (Microbuz microbuz : microbuze) {
                fisierScriere.append(microbuz.getMarca());
                fisierScriere.append(delimitator);
                fisierScriere.append(String.valueOf(microbuz.getAnFabricatie()));
                fisierScriere.append(delimitator);
                fisierScriere.append(microbuz.getNrInmatriculare());
                fisierScriere.append(delimitator);
                fisierScriere.append(microbuz.getNumeSofer());
                fisierScriere.append(linieNoua);

            }
            System.out.println("Fisierul CSV a fost creat cu succes!");
        } catch(Exception e){
            System.out.println("Eroare in CsvScriereMicrobuz!");
            e.printStackTrace();
        } finally {

            try{
                fisierScriere.flush();
                fisierScriere.close();
            }  catch (IOException e){
                System.out.println("Eroare cand punem in fisier sau il inchidem!");
                e.printStackTrace();
            }
        }


    }


}
