package audit;


import masini.Autobuz;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvAudit {

    private static final String delimitator = ",";
    private static final String linieNoua = "\n";

    private static final String inceputFisier = "nume_actiune, timestamp";
    private static FileWriter fisierScriere = null;

    static{
        try {
            fisierScriere = new FileWriter("audit.csv",true);

            fisierScriere.append(inceputFisier);

            fisierScriere.append(linieNoua);

            System.out.println("Fisierul CSV a fost creat cu succes!");
        } catch(Exception e){
            System.out.println("Eroare in CsvAudit!");
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
    public static void scrieCsvAudit(String numeActiune){

        Date date = new Date();

        SimpleDateFormat form = new SimpleDateFormat("hh:mm:ss:SSS a dd-MMM-yyyy");
        try {
            fisierScriere = new FileWriter("audit.csv", true);

             fisierScriere.append(numeActiune);
             fisierScriere.append(delimitator);
             fisierScriere.append(form.format(date));
             fisierScriere.append(linieNoua);

             System.out.println("Fisierul CSV a fost creat cu succes!");
        } catch(Exception e){
             System.out.println("Eroare in CsvAudit!");
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

