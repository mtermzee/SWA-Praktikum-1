package de.hsos.swa.ssa.suchen.ui.controller;

import java.util.Scanner;

import de.hsos.swa.ssa.suchen.al.WaehleWare;
import de.hsos.swa.ssa.suchen.ui.view.AuswahlView;

public class AuswahlControl {
    // view
    AuswahlView auswahlView = new AuswahlView();

    // interface
    WaehleWare waehleWare;

    Scanner auswhal = new Scanner(System.in);
    String option;
    boolean weiter = true;
    long nummer;

    public AuswahlControl(WaehleWare waehleWare) {
        this.waehleWare = waehleWare;
    }

    public void handelAuswahlView() {
        do {
            auswahlView.auswahlStartListe();
            option = auswhal.nextLine();
            switch (option) {
                case "1":
                    nummer = auswahlView.inputWarenummer();
                    waehleWare(nummer);
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
        waehleWare.wareZuWarenkorbHinzufuegen(warennummer);
    }

    public void aktuellerWarenkorbWechseln(long warenkorbNummer) {
        waehleWare.aktuellerWarenkorbWechseln(warenkorbNummer);
    }
}
