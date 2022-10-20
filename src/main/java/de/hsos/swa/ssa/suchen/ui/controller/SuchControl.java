package de.hsos.swa.ssa.suchen.ui.controller;

import java.util.Scanner;

import de.hsos.swa.ssa.suchen.al.EinkaueferIn;
import de.hsos.swa.ssa.suchen.al.SucheWare;
import de.hsos.swa.ssa.suchen.ui.view.SuchView;

public class SuchControl {
    // view
    SuchView suchView = new SuchView();

    // interface
    SucheWare sucheWare = new EinkaueferIn();

    Scanner auswhal = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    String option;
    boolean weiter = true;
    long warennummer = 0;
    String warenname = "";

    public void handelSuchView() {
        do {
            suchView.suchenStartListe();
            option = auswhal.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Warenname eingeben: ");
                    warenname = input.nextLine();
                    sucheWarenMitName(warenname);
                    break;
                case "2":
                    System.out.println("Warennummer eingeben: ");
                    warennummer = input.nextLong();
                    sucheWarenMitNummer(warennummer);
                    break;
                default:
                    System.out.println("Zurück...");
                    weiter = false;
                    break;
            }
        } while (weiter);
    }

    public void sucheWarenMitName(String warenname) {
        sucheWare.sucheWare(warenname);
    }

    public void sucheWarenMitNummer(long warennummer) {
        sucheWare.sucheWare(warennummer);
    }
}
