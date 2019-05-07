package csv;

import masini.Microbuz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvCitireMicrobuz {

    public static final String delimitator = ",";

    public static final int marcaIndex = 0;
    public static final int anIndex = 1;
    public static final int numarIndex = 2;
    public static final int numeIndex = 3;

    public static void citireCsvFisierMicrobuz(String numeFisier){

        BufferedReader fisierCitire = null;

        try{

            List<Microbuz>microbuze = new ArrayList<>();

            String linie = "";

            //creem fisierul de citire
            fisierCitire = new BufferedReader(new FileReader(numeFisier));

            //Citim din CSV header-ul
            fisierCitire.readLine();

            //citim linie cu linie incepand cu a doua linie
            while((linie = fisierCitire.readLine()) != null){

                String[] sir = linie.split(delimitator);
                if (sir.length > 0) {

                    Microbuz microbuz = new Microbuz(sir[marcaIndex],
                            Integer.parseInt(sir[anIndex]), sir[numarIndex], sir[numeIndex]);
                    microbuze.add(microbuz);
                }
            }

            for (Microbuz microbuz : microbuze){
                System.out.println(microbuz.toString());
            }

        } catch (Exception e){
            System.out.println("Eroare in CsvCitireMicrobuz!!");
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
