package csv;


import legatura.Legatura;
import oras.Oras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvCitireLegatura {

    public static final String delimitator = ",";

    public static final int kmIndex = 0;
    public static final int plecareIndex = 1;
    public static final int destinatieIndex = 2;

    public static void citireCsvFisierLegatura(String numeFisier){

        BufferedReader fisierCitire = null;

        try{

            List<Legatura>legaturi = new ArrayList<>();

            String linie = "";

            //creem fisierul de citire
            fisierCitire = new BufferedReader(new FileReader(numeFisier));

            //Citim din CSV header-ul
            fisierCitire.readLine();

            //citim linie cu linie incepand cu a doua linie
            while((linie = fisierCitire.readLine()) != null){

                String[] sir = linie.split(delimitator);
                if (sir.length > 0) {

                    Legatura legatura = new Legatura(Integer.parseInt(sir[kmIndex]), new Oras(sir[plecareIndex]), new Oras(sir[destinatieIndex]));
                    legaturi.add(legatura);
                }
            }

            for (Legatura legatura : legaturi){
                System.out.println(legatura.toString());
            }

        } catch (Exception e){
            System.out.println("Eroare in CsvCitireLegatura!!");
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
