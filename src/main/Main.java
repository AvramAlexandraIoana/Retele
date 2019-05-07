package main;

import audit.CsvAudit;
import csv.*;
import legatura.Legatura;
import masini.*;
import modele.Card;
import modele.TitularFirma;
import modele.Tranzactie;
import oras.Oras;
import servicii.ServiciuTranzactii;

import java.net.Inet4Address;
import java.sql.SQLOutput;
import java.util.*;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

       /* Cele 10 interogari sunt:
        -adaugarea unui microbuz
        -adaugarea unui autobuz
        -plata unui bilet
        -anularea unui bilet
        determinare legaturi care au statia de plecare Bucuresti
        -determinarea numelor soferilor de pe microbuze
        --sa se vada cine dintre microbuze si autobuze are un numar mai mare
        --sa se decida legatura care are un numar maxim de km
        --stergerea unui autobuz din autobuze disponibile(in caz de defectare)
        --stergerea unui microbuz din microbuze disponibile
        1 .a lista cu cel putin 8 tipuri de obiecte
        */
        //lista cu 8 obiecte

        List li = new ArrayList();
        Oras o1 = new Oras("Bucuresti");
        Legatura o2 = new Legatura(4000, new Oras("Cluj"), new Oras("Iasi"));
        Autobuz o3 = new Autobuz("BMW",2010,"GJ1273",30);
        Microbuz o4 = new Microbuz("Audi",2015,"B16253","Ionel");
        Oras o5 = new Oras("Timisoara");
        Oras o6 = new Oras("Targu-Jiu");
        Legatura o7 = new Legatura(500, o5, o6);
        Autobuz o8 =  new Autobuz("Logan",2018,"TM16253",50);
        li.add(o1);
        li.add(o2);
        li.add(o3);
        li.add(o4);
        li.add(o5);
        li.add(o6);
        li.add(o7);
        li.add(o8);
        for(Object t:li)
            System.out.println(t);


        //o clasa de baza Masina si 2 clase derivate Microbuz si autobuz
        // 1.2.c
        Masina[] au1 = new Masina[5];
        au1[0] = new Microbuz("audi",1999,"gz1918","ionel");
        au1[1] = new Autobuz("bmw",2010,"cj2366",50);
        au1[2] = new Autobuz("audi",2008,"B1283",24);
        au1[3] = new Microbuz("logan",2010,"Gj1763","popescu");
        au1[4] = new Microbuz("pasat",2017,"DJ162","MARIA");
        for(int i=0; i< 5; i++)
         System.out.println(au1[i].toString());


        Oras oras1 = new Oras("Targu-Jiu");
        System.out.println(oras1);
        Oras oras2 = new Oras("Bucuresti");
        Legatura ob = new Legatura(4000, oras1, oras2);
        System.out.println(ob);

        TitularFirma titular = new TitularFirma("Popescu", 23);
        Tranzactie[] tranzactii = new Tranzactie[3];
        tranzactii[0] = new Tranzactie(20.3,"Targu-Jiu");
        tranzactii[1] = new Tranzactie(20,"Craiova");

        Card card = new Card();
        card.setSold(2000);
        card.setTitular(titular);
        card.setTranzactii(tranzactii);


        ServiciuTranzactii serviciuTranzactii = new ServiciuTranzactii();
        System.out.println(serviciuTranzactii.adaugaTranzactie(card,
                new Tranzactie(100,"Anulare calatorie")));
        System.out.println(serviciuTranzactii.adaugaTranzactie(card,
                new Tranzactie(200,"Anulare calatorie")));
        System.out.println(serviciuTranzactii.adaugaTranzactie(card,
                new Tranzactie(500,"Adaugare calatorie")));
        Autobuz [] au = new  Autobuz [1];
        au[0] = new Autobuz("BMV",1998,"1728gv",23);
        Microbuz [] micro = new Microbuz[1];
        micro[0] = new Microbuz("Audi",2010,"Gj101","Popescu");
        Oras plecare = new Oras("Cluj");
        Oras destinatie = new Oras("Bucuresti");
        Legatura[] leg = new Legatura[1];
        leg[0] = new Legatura(500,plecare,destinatie);
        Disponibile masini = new Disponibile();
        masini.setDisponibile(au);
        masini.setNumarAutobuze(1);
        masini.setNumarMicrobuze(1);
        masini.setDisponibile1(micro);
        masini.setLegaturi(leg);
        System.out.println(masini.toString());
        ServiciuTranzactii serviciuTranzactii1 = new ServiciuTranzactii();
        serviciuTranzactii1.adaugareAutobuz(masini,
                new Autobuz("dacia", 2010, "1726", 29));
        serviciuTranzactii1.adaugareAutobuz(masini,
                new Autobuz("audi",2008,"B1283",24));
        serviciuTranzactii1.adaugareAutobuz(masini,
                new Autobuz("bmv1",2011,"CJ23",24));
        serviciuTranzactii1.adaugareMicrobuz(masini,
                new Microbuz("bmw", 2007, "CJ123", "Ionel"));
        serviciuTranzactii1.adaugareMicrobuz(masini,
                new Microbuz("audi",2017,"DJ1233","Gabriel"));
        serviciuTranzactii1.adaugareMicrobuz(masini,
                new Microbuz("dacia", 2009, "C1223", "Lucian"));
        serviciuTranzactii1.adaugareMicrobuz(masini,
                new Microbuz("logan",2018,"GJ1233","Tudor"));
        serviciuTranzactii1.anuleazaAutobuz(masini, 1);//anulez autobuzul de pe pozitia 1
        serviciuTranzactii1.adaugareLegatura(masini,
                new Legatura(1000, new Oras("Bucuresti"), new Oras("Cluj")));
        serviciuTranzactii1.adaugareLegatura(masini,
                new Legatura(700, new Oras("Iasi"), new Oras("Cluj")));
         System.out.println(serviciuTranzactii1.numarMaximKm(masini));//numarul maxim de km din toate legaturile
         System.out.println(serviciuTranzactii1.numarMaximAuto(masini));//daca nrautobuze>nrmicrobuz va fi 1,altfel 0
         System.out.println(masini.toString());

         String[] ob2 = serviciuTranzactii1.numeSoferi(masini);
         for(int i=0; i< ob2.length; i++)
             System.out.println(ob2[i].toString());

        List l2 = serviciuTranzactii1.legPlecareBucuresti(masini);
        for(Object p:l2 )
            System.out.println(p.toString());

        Oras[] orase = new Oras[8];
        orase[0] = new Oras("Bucuresti");
        orase[1] = new Oras("Arad");
        orase[2] = new Oras("Targu-Jiu");
        orase[3] = new Oras("Cluj");
        orase[4] = new Oras("Iasi");
        orase[5] = new Oras("Timisoara");
        orase[6] = new Oras("Craiova");
        orase[7] = new Oras("Bacau");
        for(int i=0; i<8; i++)
            System.out.println(orase[i].toString());


        //punctul 2.c + 2.b
        //folosirea unui map
        Map<String,  Oras> orase4 = new HashMap<String, Oras>();
        orase4.put("Bucuresti",new Oras("Cluj"));
        orase4.put("Iasi",new Oras("Timisoara"));
        orase4.put("Bacau",new Oras("Iasi"));
        System.out.println(orase4.get("Iasi"));

        List lista = new ArrayList();
        lista.add(new Oras("Bacau"));
        lista.add(new Oras("Bucuresti"));
        lista.add(new Oras("Arad"));
        lista.add(new Oras("Timisoara"));
        for(Object i:lista)
            System.out.println(i);
        //sorteaza crescator dupa numarul de locuri
        Masina[] tp = new Autobuz[9];
        tp[0] = new Autobuz("BMW",1999,"GZ1737",45);
        tp[1] = new Autobuz("BMW",1999,"GZ1737",23);
        tp[2] = new Autobuz("BMW",1999,"GZ1737",5);
        tp[3] = new Autobuz("BMW",1999,"GZ1737",2);
        tp[4] = new Autobuz("BMW",1999,"GZ1737",12);
        tp[5] = new Autobuz("BMW",1999,"GZ1737",43);
        tp[6] = new Autobuz("BMW",1999,"GZ1737",15);
        tp[7] = new Autobuz("BMW",1999,"GZ1737",10);
        tp[8] = new Autobuz("BMW",1999,"GZ1737",1);
        Arrays.sort(tp);
        for(int i=0; i<9; i++)
            System.out.println(tp[i].toString());


        Oras plecare1 = new Oras("Cluj");
        Oras destinatie1 = new Oras("Bucuresti");
        Legatura leg1 = new Legatura(360, plecare1, destinatie1);
        System.out.println(leg1.toString());

        String numeFisier1 = System.getProperty("user.dir") + "/oras.csv";

        System.out.println("Scrie in fisierul oras.csv:");
        CsvScriereOras.scriereCsvFisierOras(numeFisier1);

        System.out.println("Citeste din fisierul oras.csv:");
        CsvCitireOras.citireCsvFisierOras(numeFisier1);

        String numeFisier2 = System.getProperty("user.dir") + "/microbuz.csv";

        System.out.println("Scrie in fisierul microbuz.csv");
        CsvScriereMicrobuz.scriereCsvFisierMicrobuz(numeFisier2);

        System.out.println("Citeste din fisierul microbuz.csv:");
        CsvCitireMicrobuz.citireCsvFisierMicrobuz(numeFisier2);

        String numeFisier3 = System.getProperty("user.dir") + "/autobuz.csv";

        System.out.println("Scrie in fisierul autobuz.csv:");
        CsvScriereAutobuz.scriereCsvFisierAutobuz(numeFisier3);

        System.out.println("Citeste din fisierul autobuz.csv:");
        CsvCitireAutobuz.citireCsvFisierAutobuz(numeFisier3);

        String numeFisier4 = System.getProperty("user.dir") + "/legatura.csv";

        System.out.println("Scrie in fisierul legatura.csv");
        CsvScriereLegatura.scriereCsvFisierLegatura(numeFisier4);

        System.out.println("Citeste din fisierul legatura.csv:");
        CsvCitireLegatura.citireCsvFisierLegatura(numeFisier4);


    }
}
