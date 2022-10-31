package de.hsos.swa.ssa.suchen.ui.view;

import java.util.List;
import java.util.Scanner;

import de.hsos.swa.ssa.suchen.bl.Ware;

public class AuswahlView {
    Scanner input = new Scanner(System.in);

    public void auswahlStartListe() {
        System.out.println();
        System.out.println("(1) Ware zum Warenkorb hinzufügen");
        System.out.println("(2) Waren anzeigen");
        System.out.println("(!) Zurück beliebige Taste drücken");
        System.out.println();
    }

    public void druckWaren(List<Ware> waren) {
        if (waren == null || waren.size() == 0) {
            System.out.println("ware not found");
        } else
            waren.forEach(System.out::println);
    }

    public long inputWarenummer() {
        System.out.println("Warennummer eingeben: ");
        long warennummer = input.nextLong();
        return warennummer;
    }

}
