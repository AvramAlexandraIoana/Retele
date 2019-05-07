package csv;

import oras.Oras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CsvCitireOras {

    public static final String delimiator = ",";

    public static final int orasIndex = 0;

    public static void citireCsvFisierOras(String numeFisier){

        BufferedReader fisierCitire = null;
        try{
            List<Oras> orase = new ArrayList<>();

            String linie = "";

            //Creez fisierul de citire
            fisierCitire = new BufferedReader(new FileReader(numeFisier));

            //Citim prima linie
            fisierCitire.readLine();

            //Citim linie cu linie pornind de la a doua linie
            while((linie = fisierCitire.readLine()) != null){
                String[] sir = linie.split(delimiator);
                if(sir.length > 0){
                    Oras oras = new Oras(sir[orasIndex]);
                    orase.add(oras);
                }
            }
            //Afisez noua lista de legaturi
            for (Oras oras : orase){
                System.out.println(oras.toString());
            }


        }catch (Exception e){
            System.out.println("Eroare in CsvCitireOras!!");
            e.printStackTrace();

        }finally {
            try{
                fisierCitire.close();
            }catch(IOException e){
                System.out.println("Eroare cat timp se inchide fisierul de citire!");
                e.printStackTrace();
            }
        }

    }

}
