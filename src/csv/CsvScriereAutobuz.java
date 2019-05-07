package csv;

import masini.Autobuz;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CsvScriereAutobuz {

    private static final String delimitator = ",";
    private static final String linieNoua = "\n";

    private static final String inceputFisier = "marca,anFabricatie,nrInmatriculare,nrLocuri";
    public static void scriereCsvFisierAutobuz(String numeFisier) {

        Autobuz autobuz1 = new Autobuz("BMW", 2007, "CJ123", 30);
        Autobuz autobuz2 = new Autobuz("AUDI", 2018, "B1223", 55);
        Autobuz autobuz3 = new Autobuz("LOGAN", 2010, "GJ123", 25);
        Autobuz autobuz4 = new Autobuz("PASSAT", 2015, "DJ123", 36);

        List<Autobuz> autobuze = new ArrayList<>();
        autobuze.add(autobuz1);
        autobuze.add(autobuz2);
        autobuze.add(autobuz3);
        autobuze.add(autobuz4);

        FileWriter fisierScriere = null;

        try {
            fisierScriere = new FileWriter(numeFisier);

            fisierScriere.append(inceputFisier);

            fisierScriere.append(linieNoua);


            for (Autobuz autobuz : autobuze) {
                fisierScriere.append(autobuz.getMarca());
                fisierScriere.append(delimitator);
                fisierScriere.append(String.valueOf(autobuz.getAnFabricatie()));
                fisierScriere.append(delimitator);
                fisierScriere.append(autobuz.getNrInmatriculare());
                fisierScriere.append(delimitator);
                fisierScriere.append(String.valueOf(autobuz.getNrLocuri()));
                fisierScriere.append(linieNoua);

            }
            System.out.println("Fisierul CSV a fost creat cu succes!");
        } catch(Exception e){
            System.out.println("Eroare in CsvScriereAutobuz!");
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
