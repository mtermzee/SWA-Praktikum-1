package de.hsos.swa.ssa.suchen.ui.controller;

import java.util.Scanner;

import de.hsos.swa.ssa.suchen.al.EinkaueferIn;
import de.hsos.swa.ssa.suchen.al.HoleWarenkorb;
import de.hsos.swa.ssa.suchen.ui.view.SuchenStartView;

public class SuchenStartControl {
    // controllers
    SuchControl suchControl;
    PruefControl pruefControl;
    AuswahlControl auswahlControl;
    WareControl wareControl;

    // view
    SuchenStartView suchenStartView;

    // interface
    HoleWarenkorb holeWarenkorb;

    Scanner auswhal = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    String option;
    boolean weiter = true;
    long warennummer = 0;

    public SuchenStartControl() {
        EinkaueferIn einkaueferIn = new EinkaueferIn();
        suchControl = new SuchControl(einkaueferIn);
        pruefControl = new PruefControl(einkaueferIn);
        auswahlControl = new AuswahlControl(einkaueferIn);
        wareControl = new WareControl(einkaueferIn);
        suchenStartView = new SuchenStartView();
        holeWarenkorb = einkaueferIn;
    }

    public void handelSuchenStartView() {
        do {
            suchenStartView.suchenStartListe();
            option = auswhal.nextLine();
            switch (option) {
                case "1":
                    suchControl.handelSuchView();
                    break;
                case "2":
                    pruefControl.handelPruefView();
                    break;
                case "3":
                    wareControl.handelWareView();
                    break;
                case "4":
                    auswahlControl.handelAuswahlView();
                    break;
                case "5":
                    holeWareAusWarenkorb();
                    break;
                case "6":
                    System.out.println("Warennummer eingeben: ");
                    warennummer = input.nextLong();
                    holeWareAusWarenkorbMitNummer(warennummer);
                    break;
                default:
                    System.out.println("Zurück...");
                    weiter = false;
                    break;
            }
        } while (weiter);
    }

    public void holeWareAusWarenkorb() {
        System.out.println(holeWarenkorb.holeWarenkorb());
    }

    public void holeWareAusWarenkorbMitNummer(long warenkorbNummer) {
        System.out.println(holeWarenkorb.holeWarenkorb(warenkorbNummer));
    }
}
