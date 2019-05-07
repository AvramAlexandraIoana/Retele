package csv;


import legatura.Legatura;
import oras.Oras;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvScriereLegatura {

    private static final String delimitator = ",";
    private static final String linieNoua = "\n";

    private static final String inceputFisier = "km,orasPlecare,orasDestinatie";

    public static void scriereCsvFisierLegatura(String numeFisier) {

        Legatura legatura1 = new Legatura(345, new Oras("Bucuresti"), new Oras("Cluj"));
        Legatura legatura2 = new Legatura(200, new Oras("Targu-Jiu"), new Oras("Timisoara"));
        Legatura legatura3 = new Legatura(400, new Oras("Bucuresti"), new Oras("Constanta"));
        Legatura legatura4 = new Legatura(234, new Oras("Iasi"), new Oras("Suceava"));

        List<Legatura> legaturi = new ArrayList<>();
        legaturi.add(legatura1);
        legaturi.add(legatura2);
        legaturi.add(legatura3);
        legaturi.add(legatura4);

        FileWriter fisierScriere = null;

        try {
            fisierScriere = new FileWriter(numeFisier);

            fisierScriere.append(inceputFisier);

            fisierScriere.append(linieNoua);


            for (Legatura legatura : legaturi) {
                fisierScriere.append(String.valueOf(legatura.getKm()));
                fisierScriere.append(delimitator);
                fisierScriere.append(legatura.getOrasPlecare().getNume());
                fisierScriere.append(delimitator);
                fisierScriere.append(legatura.getOrasDestinatie().getNume());
                fisierScriere.append(linieNoua);

            }
            System.out.println("Fisierul CSV a fost creat cu succes!");
        } catch(Exception e){
            System.out.println("Eroare in CsvScriereLegatura!");
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

