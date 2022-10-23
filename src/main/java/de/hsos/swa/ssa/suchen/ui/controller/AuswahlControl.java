package de.hsos.swa.ssa.suchen.ui.controller;

import java.util.Scanner;

import de.hsos.swa.ssa.suchen.al.EinkaueferIn;
import de.hsos.swa.ssa.suchen.al.WaehleWare;
import de.hsos.swa.ssa.suchen.ui.view.AuswahlView;

public class AuswahlControl {
    // view
    AuswahlView auswahlView = new AuswahlView();

    // interface
    WaehleWare waehleWare = new EinkaueferIn();

    Scanner auswhal = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    String option;
    boolean weiter = true;
    long warennummer = 0;

    public void handelAuswahlView() {
        do {
            auswahlView.auswahlStartListe();
            option = auswhal.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Warennummer eingeben: ");
                    warennummer = input.nextLong();
                    waehleWare(warennummer);
                    break;
                case "2":
                    auswahlView.druckWaren(waehleWare.holeWaren());
                    break;
                default:
                    System.out.println("Zurück...");
                    weiter = false;
                    break;
            }
        } while (weiter);
    }

    public void waehleWare(long warennummer) {
        System.out.println(waehleWare.wareZuWarenkorbHinzufuegen(null));
    }
}
