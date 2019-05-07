package csv;

import masini.Autobuz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvCitireAutobuz {

    public static final String delimitator = ",";

    public static final int marcaIndex = 0;
    public static final int anIndex = 1;
    public static final int numarIndex = 2;
    public static final int nrIndex = 3;

    public static void citireCsvFisierAutobuz(String numeFisier){

        BufferedReader fisierCitire = null;

        try{

            List<Autobuz>autobuze = new ArrayList<>();

            String linie = "";

            //creem fisierul de citire
            fisierCitire = new BufferedReader(new FileReader(numeFisier));

            //Citim din CSV header-ul
            fisierCitire.readLine();

            //citim linie cu linie incepand cu a doua linie
            while((linie = fisierCitire.readLine()) != null){

                String[] sir = linie.split(delimitator);
                if (sir.length > 0) {

                    Autobuz autobuz = new Autobuz(sir[marcaIndex],
                            Integer.parseInt(sir[anIndex]), sir[numarIndex],Integer.parseInt(sir[nrIndex]));
                    autobuze.add(autobuz);
                }
            }

            for (Autobuz autobuz : autobuze){
                System.out.println(autobuz.toString());
            }

        } catch (Exception e){
            System.out.println("Eroare in CsvCitireAutobuz!!");
            e.printStackTrace();
        }finally {
            try{
                fisierCitire.close();
            } catch(IOException e){
                System.out.println("Eroare cat timp se inchide fisierul de citire!");
                e.printStackTrace();
            }
        }

    }

}
