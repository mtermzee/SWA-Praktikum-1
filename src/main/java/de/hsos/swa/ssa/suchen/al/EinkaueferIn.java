package de.hsos.swa.ssa.suchen.al;

import java.util.List;

import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class EinkaueferIn implements HoleWarenkorb, SucheWare, PruefeWare, WaehleWare {
    // services
    WarenSuchenUndPruefen warenSuchenUndPruefen = new WarenSuchenUndPruefen();
    WarenkorbVerwalten warenkorbVerwalten = new WarenkorbVerwalten();

    @Override
    public boolean wareZuWarenkorbHinzufuegen(Ware ware) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Produktinformation> holeDetailInformation(long wareNummer) {
        return warenSuchenUndPruefen.getWareInfos(wareNummer);
    }

    @Override
    public List<Ware> sucheWare(String wareName) {
        return warenSuchenUndPruefen.getSucheBeiName(wareName);
    }

    @Override
    public Ware sucheWare(long wareNummer) {
        return warenSuchenUndPruefen.getSucheBeiNummer(wareNummer);
    }

    @Override
    public WarenkorbFuerSuche holeWarenkorb() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WarenkorbFuerSuche holeWarenkorb(long warenKorbNummer) {
        // TODO Auto-generated method stub
        return null;
    }
}
