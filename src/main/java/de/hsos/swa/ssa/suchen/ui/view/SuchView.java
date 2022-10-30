package de.hsos.swa.ssa.suchen.ui.view;

import java.util.Scanner;

public class SuchView {
    Scanner input = new Scanner(System.in);

    public void suchenStartListe() {
        System.out.println();
        System.out.println("(1) Suche nach Warenname");
        System.out.println("(2) Suche nach Warenennummer");
        System.out.println("(!) Zurück beliebige Taste drücken");
        System.out.println();
    }

    public void algorithmusListe() {
        System.out.println();
        System.out.println("(1) Keyword Matching");
        System.out.println("(2) Semantic Matching");
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
}
