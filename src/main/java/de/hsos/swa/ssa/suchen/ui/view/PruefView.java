package de.hsos.swa.ssa.suchen.ui.view;

import java.util.Scanner;

public class PruefView {
    Scanner input = new Scanner(System.in);

    public void pruefenStartListe() {
        System.out.println();
        System.out.println("(1) Prüfen nach Waren Informationen");
        System.out.println("(!) Zurück beliebige Taste drücken");
        System.out.println();
    }

    public long inputWarenummer() {
        System.out.println("Warennummer eingeben: ");
        long warennummer = input.nextLong();
        return warennummer;
    }
}
