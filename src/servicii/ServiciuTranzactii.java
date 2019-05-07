package servicii;

import audit.CsvAudit;
import legatura.Legatura;
import masini.*;
import modele.Card;
import modele.Tranzactie;

import java.util.ArrayList;
import java.util.List;

public class ServiciuTranzactii {

    //determinare legaturi care au statia de plecare Bucuresti
    public List legPlecareBucuresti(Disponibile leg){
        CsvAudit.scrieCsvAudit("legPlecareBucuresti");
        int lungime = leg.getLegaturi().length;
        List l = new ArrayList();
        for(int i=0; i< lungime; i++){
            if( leg.getLegaturi()[i].getOrasPlecare().getNume() == "Bucuresti") {
                Legatura p1 = new Legatura(leg.getLegaturi()[i].getKm(),
                        leg.getLegaturi()[i].getOrasPlecare(),
                        leg.getLegaturi()[i].getOrasDestinatie());
                l.add(p1);
            }
            }
        return l;
    }
    //un String cu numele soferilor de pe microbuze
    public String[] numeSoferi(Disponibile micro){
        CsvAudit.scrieCsvAudit("numeSoferi");
        int lungime = micro.getDisponibile1().length;
        String[] ob = new String[lungime];
        for(int i=0; i<lungime; i++)
            ob[i] = micro.getDisponibile1()[i].getNumeSofer();

        return ob;

    }
   // determina legatura cu cei mai multi km
    public Legatura numarMaximKm(Disponibile leg)
    {
        CsvAudit.scrieCsvAudit("numarMaximKm");
        int amax = 0;
        int lungime = leg.getLegaturi().length;
        int poz = 0;
        for(int i=0; i< lungime; i++){
            if(leg.getLegaturi()[i].getKm()> amax){
                amax = leg.getLegaturi()[i].getKm();
                poz = i;
            }
        }
        return leg.getLegaturi()[poz];

    }
    //determina cine are mai multe masini (Autobuzele/Microbuze)
    public int  numarMaximAuto(Disponibile au){
        CsvAudit.scrieCsvAudit("numarMaximAuto");
        if(au.getNumarAutobuze() >= au.getNumarMicrobuze()) return 1;
        return 0;
    }
    //adaugare autobuz (adaugare in lista + recalculare numar)
    public Disponibile adaugareAutobuz(Disponibile autobuze, Autobuz autobuz){
        CsvAudit.scrieCsvAudit("adaugareAutobuz");
        int lungime = autobuze.getDisponibile().length;
        Autobuz[] auto = new Autobuz[lungime + 1];
        for (int i = 0; i < lungime; i++)
            auto[i] = autobuze.getDisponibile()[i];
        auto[lungime] = autobuz;
        autobuze.setDisponibile(auto);
        autobuze.setNumarAutobuze(autobuze.getNumarAutobuze() + 1);
        return autobuze;

    }
    //stergere autobuz (stergere din lista + recalculare numar)
    public Disponibile anuleazaAutobuz(Disponibile autobuze, int numarAutobuz){
        CsvAudit.scrieCsvAudit("anuleazaAutobuz");
        int lungime = autobuze.getDisponibile().length;
        Autobuz[] auto =  new Autobuz[lungime - 1];
        for (int i=0; i< lungime; i++){
            if(i != numarAutobuz) auto[i] = autobuze.getDisponibile()[i];
               else
            {
                int poz = i;
                for (int j = poz; j< lungime - 1; j++)
                    auto[j] = autobuze.getDisponibile()[j+1];
                break;
            }
        }
        autobuze.setDisponibile(auto);
        autobuze.setNumarAutobuze(autobuze.getNumarAutobuze() - 1);
        return autobuze;
    }
    //adaugare microbuz (adaugare in lista + recalculare numar)
    public Disponibile adaugareMicrobuz(Disponibile microbuze, Microbuz microbuz){
        CsvAudit.scrieCsvAudit("adaugareMicrobuz");
        int lungime = microbuze.getDisponibile1().length;
        Microbuz[] auto = new Microbuz[lungime + 1];
        for(int i=0; i< lungime; i++)
            auto[i] = microbuze.getDisponibile1()[i];
        auto[lungime] = microbuz;
        microbuze.setDisponibile1(auto);
        microbuze.setNumarMicrobuze(microbuze.getNumarMicrobuze() + 1);
        return microbuze;

    }
    //stergere microbuz (stergere din lista + recalculare numar)
    public Disponibile anuleazaMicrobuz(Disponibile microbuze, int numarMicrobuz){
        CsvAudit.scrieCsvAudit("anuleazaMicrobuz");
        int lungime = microbuze.getDisponibile1().length;
        Microbuz [] auto =  new Microbuz[lungime - 1];
        for (int i=0; i< lungime; i++){
            if(i != numarMicrobuz) auto[i] = microbuze.getDisponibile1()[i];
            else
            {
                int poz = i;
                for (int j = poz; j< lungime-1; j++)
                    auto[j] = microbuze.getDisponibile1()[j+1];
                break;
            }
        }
        microbuze.setDisponibile1(auto);
        microbuze.setNumarMicrobuze(microbuze.getNumarMicrobuze() - 1);
        return microbuze;
    }
    //adauga legatura
    public Disponibile adaugareLegatura(Disponibile legaturi, Legatura legatura){
        CsvAudit.scrieCsvAudit("adaugareLegatura");
        int lungime = legaturi.getLegaturi().length;
        Legatura[] leg = new Legatura[lungime + 1];
        for(int i=0; i< lungime; i++)
            leg[i] = legaturi.getLegaturi()[i];
        leg[lungime] = legatura;
        legaturi.setLegaturi(leg);
        return legaturi;

    }
    //cumparare bilet sau anulare bilet
    public Card adaugaTranzactie(Card card, Tranzactie tranzactie) {
        CsvAudit.scrieCsvAudit("adaugaTranzactie");
        int lungime = card.getTranzactii().length;
        Tranzactie[] tranzactii = new Tranzactie[lungime + 1];

        if (card.getSold() > tranzactie.getSuma()) {
            //alocare lista noua cu valoarea adaugata

            for (int i = 0; i < lungime; i++) {
                tranzactii[i] = card.getTranzactii()[i];
            }
            tranzactii[lungime] = tranzactie;
            card.setTranzactii(tranzactii);
            if (tranzactie.getDescriere().contentEquals("Anulare calatorie")){
                double soldRamas = card.getSold() - tranzactie.getSuma();
                card.setSold(soldRamas);
                }
                else {
                    double soldRamas = card.getSold() + tranzactie.getSuma();
                    card.setSold(soldRamas);
                }

            }

        return card;
        }






}
