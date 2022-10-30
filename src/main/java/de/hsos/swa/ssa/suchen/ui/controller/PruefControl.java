package de.hsos.swa.ssa.suchen.ui.controller;

import java.util.Scanner;

import de.hsos.swa.ssa.suchen.al.PruefeWare;
import de.hsos.swa.ssa.suchen.ui.view.PruefView;

public class PruefControl {
    // view
    PruefView pruefView = new PruefView();

    // interface
    PruefeWare pruefeWare;

    Scanner auswhal = new Scanner(System.in);
    String option;
    boolean weiter = true;

    public PruefControl(PruefeWare pruefeWare) {
        this.pruefeWare = pruefeWare;
    }

    public void handelPruefView() {
        do {
            pruefView.pruefenStartListe();
            option = auswhal.nextLine();
            switch (option) {
                case "1":
                    long warennummer = pruefView.inputWarenummer();
                    holeWarenInfo(warennummer);
                    break;
                default:
                    System.out.println("Zurück...");
                    weiter = false;
                    break;
            }
        } while (weiter);
    }

    public void holeWarenInfo(long warennummer) {
        pruefeWare.holeDetailInformation(warennummer);
    }
}
