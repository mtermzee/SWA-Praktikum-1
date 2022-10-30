package de.hsos.swa.ssa.suchen.ui.controller;

import java.util.Scanner;

import de.hsos.swa.ssa.suchen.al.SucheWare;
import de.hsos.swa.ssa.suchen.bl.SuchAlgorithmus;
import de.hsos.swa.ssa.suchen.ui.view.SuchView;

public class SuchControl {
    // view
    SuchView suchView = new SuchView();

    // interface
    SucheWare sucheWare;

    Scanner auswhal = new Scanner(System.in);
    String option;
    boolean weiter = true;

    public SuchControl(SucheWare sucheWare) {
        this.sucheWare = sucheWare;
    }

    public void handelSuchView() {
        do {
            suchView.suchenStartListe();
            option = auswhal.nextLine();
            switch (option) {
                case "1":
                    switchAlgorithmus();
                    String warename = suchView.inputWarename();
                    sucheWarenMitName(warename);
                    break;
                case "2":
                    long warenummer = suchView.inputWarenummer();
                    sucheWarenMitNummer(warenummer);
                    break;
                default:
                    System.out.println("Zurück...");
                    weiter = false;
                    break;
            }
        } while (weiter);
    }

    public void switchAlgorithmus() {
        suchView.algorithmusListe();
        option = auswhal.nextLine();
        switch (option) {
            case "1":
                sucheWare.algoAsuweahlen(SuchAlgorithmus.KeywordMatching);
                System.out.println("Keyword Matching...");
                break;
            case "2":
                sucheWare.algoAsuweahlen(SuchAlgorithmus.SemanticMatching);
                System.out.println("Semantic Matching...");
                break;
            default:
                sucheWare.algoAsuweahlen(SuchAlgorithmus.KeywordMatching);
                System.out.println("Keyword Matching...");
                break;
        }
    }

    public void sucheWarenMitName(String warenname) {
        sucheWare.sucheWare(warenname);
    }

    public void sucheWarenMitNummer(long warennummer) {
        sucheWare.sucheWare(warennummer);
    }
}
