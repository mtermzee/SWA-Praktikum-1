package de.hsos.swa.ssa.suchen.ui.view;

import java.util.List;

import de.hsos.swa.ssa.suchen.bl.Ware;

public class AuswahlView {

    public void auswahlStartListe() {
        System.out.println();
        System.out.println("(1) Warenkorb erstellen/wehcseln");
        System.out.println("(2) Ware zum Warenkorb hinzufügen");
        System.out.println("(3) Waren anzeigen");
        System.out.println("(!) Zurück beliebige Taste drücken");
        System.out.println();
    }

    public void druckWaren(List<Ware> waren) {
        if (waren == null || waren.size() == 0) {
            System.out.println("ware not found");
        } else
            waren.forEach(System.out::println);
    }
}
