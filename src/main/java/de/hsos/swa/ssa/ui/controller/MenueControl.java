package de.hsos.swa.ssa.ui.controller;

import java.util.Scanner;

import de.hsos.swa.ssa.suchen.ui.controller.SuchenStartControl;
import de.hsos.swa.ssa.ui.view.SimpleShoppingAppView;

public class MenueControl {
    SimpleShoppingAppView view = new SimpleShoppingAppView();
    SuchenStartControl suchenStartControl = new SuchenStartControl();

    Scanner input = new Scanner(System.in);
    int option = 0;
    boolean stop = true;

    public void handleMenueView() {
        do {
            System.out.println("**************************************");
            view.appView();
            option = input.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Suchen wird gestartet...");
                    suchenStartControl = new SuchenStartControl();
                    stop = false;
                    break;
                case 2:
                    System.out.println("Warenkorb gerade nicht verfügbar");
                    break;
                case 3:
                    System.out.println("Bezahlen gerade nicht verfügbar");
                    break;
                case 4:
                    System.out.println("Programm wird beendet");
                    stop = false;
                    break;
                default:
                    System.out.println("Falsche Eingabe");
                    break;
            }
        } while (stop);
    }
}
