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
    Scanner input = new Scanner(System.in);
    String option;
    boolean weiter = true;
    long warennummer = 0;

    public WareControl(VerwalteWare waehleWare) {
        this.waehleWare = waehleWare;
    }

    public void handelWareView() {
        do {
            wareView.wareStartListe();
            option = auswhal.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Warenname eingeben: ");
                    String warenname = input.next();
                    System.out.println("Preis eingeben: ");
                    double preis = input.nextDouble();
                    System.out.println("Beschreibung eingeben: ");
                    String beschreibung = input.next();
                    Ware ware = new Ware(warenname, preis, beschreibung);
                    waehleWare.addWare(ware);
                    System.out.println("Ware wurde hinzugefügt");
                    break;
                case "2":
                    System.out.println("Warennummer eingeben: ");
                    warennummer = input.nextLong();
                    Ware tempWare = waehleWare.sucheWare(warennummer);
                    if (tempWare != null) {
                        System.out.println("Warenname eingeben: ");
                        String tempWarenname = input.next();
                        if (!tempWarenname.equals("")) {
                            tempWare.setName(tempWarenname);
                        }
                        System.out.println("Preis eingeben: ");
                        double tempPreis = input.nextDouble();
                        if (tempPreis != 0) {
                            tempWare.setPreis(tempPreis);
                        }
                        System.out.println("Beschreibung eingeben: ");
                        String tempBeschreibung = input.next();
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
                    System.out.println("Warennummer eingeben: ");
                    warennummer = input.nextLong();
                    waehleWare.deleteWare(warennummer);
                    break;
                default:
                    System.out.println("Zurück...");
                    weiter = false;
                    break;
            }
        } while (weiter);
    }
}
