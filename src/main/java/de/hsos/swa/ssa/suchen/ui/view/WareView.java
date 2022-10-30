package de.hsos.swa.ssa.suchen.ui.view;

import java.util.Scanner;

public class WareView {
    Scanner input = new Scanner(System.in);

    public void wareStartListe() {
        System.out.println();
        System.out.println("(1) Ware hinzufügen");
        System.out.println("(2) Ware aktualisieren");
        System.out.println("(3) Ware löschen");
        System.out.println("(!) Zurück beliebige Taste drücken");
        System.out.println();
    }

    public long inputWarenummer() {
        System.out.println("Warennummer eingeben: ");
        long warennummer = input.nextLong();
        return warennummer;
    }

    public String inputWarename() {
        System.out.println("Warenname eingeben: ");
        String warenname = input.next();
        return warenname;
    }

    public double inputPreis() {
        System.out.println("Preis eingeben: ");
        double preis = input.nextDouble();
        return preis;
    }

    public String inputBeschreibung() {
        System.out.println("Beschreibung eingeben: ");
        String beschreibung = input.next();
        return beschreibung;
    }
}
