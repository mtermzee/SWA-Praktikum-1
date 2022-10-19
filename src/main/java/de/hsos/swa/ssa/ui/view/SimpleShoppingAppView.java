package de.hsos.swa.ssa.ui.view;

public class SimpleShoppingAppView {
    BegruessungView begruessungView = new BegruessungView();
    MenueView menueView = new MenueView();

    public void appView() {
        begruessungView.begruessungListe();
        menueView.menueListe();
    }

}
