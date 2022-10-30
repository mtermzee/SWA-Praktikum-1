package de.hsos.swa.ssa.suchen.ui.controller;

import java.util.Scanner;

import de.hsos.swa.ssa.suchen.al.VerwalteWare;
import de.hsos.swa.ssa.suchen.bl.Ware;
import de.hsos.swa.ssa.suchen.ui.view.WareView;

public class WareControl {
    // view
    WareView wareView = new WareView();

    // interface
    VerwalteWare waehleWare;

    Scanner auswhal = new Scanner(System.in);
    String option;
    boolean weiter = true;
    long warennummer;

    public WareControl(VerwalteWare waehleWare) {
        this.waehleWare = waehleWare;
    }

    public void handelWareView() {
        do {
            wareView.wareStartListe();
            option = auswhal.nextLine();
            switch (option) {
                case "1":
                    String warenname = wareView.inputWarename();
                    double preis = wareView.inputPreis();
                    String beschreibung = wareView.inputBeschreibung();
                    Ware ware = new Ware(warenname, preis, beschreibung);
                    waehleWare.addWare(ware);
                    System.out.println("Ware wurde hinzugefügt");
                    break;
                case "2":
                    warennummer = wareView.inputWarenummer();
                    Ware tempWare = waehleWare.sucheWare(warennummer);
                    if (tempWare != null) {
                        String tempWarenname = wareView.inputWarename();
                        if (!tempWarenname.equals("")) {
                            tempWare.setName(tempWarenname);
                        }
                        double tempPreis = wareView.inputPreis();
                        if (tempPreis != 0) {
                            tempWare.setPreis(tempPreis);
                        }
                        String tempBeschreibung = wareView.inputBeschreibung();
                        if (!tempBeschreibung.equals("")) {
                            tempWare.setBeschreibung(tempBeschreibung);
                        }
                        waehleWare.updateWare(tempWare);
                        System.out.println("Ware wurde aktualisiert");
                    } else {
                        System.out.println("Ware wurde nicht gefunden");
                    }
                    break;
                case "3":
                    warennummer = wareView.inputWarenummer();
                    ware = waehleWare.sucheWare(warennummer);
                    if (ware != null) {
                        waehleWare.deleteWare(warennummer);
                        System.out.println("Ware wurde gelöscht");
                    }
                    break;
                default:
                    System.out.println("Zurück...");
                    weiter = false;
                    break;
            }
        } while (weiter);
    }
}
