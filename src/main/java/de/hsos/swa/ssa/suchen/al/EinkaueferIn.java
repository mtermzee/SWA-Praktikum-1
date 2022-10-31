package de.hsos.swa.ssa.suchen.al;

import java.util.List;

import de.hsos.swa.ssa.suchen.acl.Warenkorb;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.SuchAlgorithmus;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class EinkaueferIn implements HoleWarenkorb, SucheWare, PruefeWare, WaehleWare, VerwalteWare {
    // services
    WarenSuchenUndPruefen warenSuchenUndPruefen = new WarenSuchenUndPruefen();
    WarenkorbVerwalten warenkorbVerwalten = new WarenkorbVerwalten();

    @Override
    public boolean wareZuWarenkorbHinzufuegen(long wareNummer) {
        Ware ware = sucheWare(wareNummer);
        if (ware != null) {
            warenkorbVerwalten.wareZuWarenkorbSenden(ware);
            return true;
        } else
            return false;
    }

    @Override
    public boolean wareAusWarenkorbLoeschen(long wareNummer) {
        return warenkorbVerwalten.wareZuWarenkorbLoeschen(wareNummer);
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
    public Warenkorb holeWarenkorb() {
        return warenkorbVerwalten.warenkorbHolen();
    }

    @Override
    public Warenkorb holeWarenkorb(long warenKorbNummer) {
        return warenkorbVerwalten.warenkorbHolen(warenKorbNummer);
    }

    @Override
    public List<Ware> holeWaren() {
        return warenSuchenUndPruefen.getWaren();
    }

    @Override
    public void aktuellerWarenkorbWechseln(long warenNummer) {
        warenkorbVerwalten.aktuelleWarenkorb(warenNummer);
    }

    @Override
    public void algoAsuweahlen(SuchAlgorithmus suchalgorithmus) {
        warenSuchenUndPruefen.algoAsuweahlen(suchalgorithmus);
    }

    @Override
    public void addWare(Ware ware) {
        warenSuchenUndPruefen.wareHinzufuegen(ware);
    }

    @Override
    public void deleteWare(long wareNummer) {
        warenSuchenUndPruefen.wareLoeschen(wareNummer);
    }

    @Override
    public void updateWare(Ware ware) {
        warenSuchenUndPruefen.wareAendern(ware);
    }

}
