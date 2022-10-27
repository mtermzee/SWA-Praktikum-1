package de.hsos.swa.ssa.suchen.al;

import java.util.List;

import de.hsos.swa.ssa.suchen.bl.Katalog;
import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.SuchAlgorithmus;
import de.hsos.swa.ssa.suchen.bl.Ware;
import de.hsos.swa.ssa.suchen.dal.WarenRepository;

public class WarenSuchenUndPruefen {
    // interface
    Katalog katalog = new WarenRepository();

    public List<Ware> getSucheBeiName(String wareName) {
        return katalog.suchen(wareName);
    }

    public Ware getSucheBeiNummer(long wareNummer) {
        return katalog.suchen(wareNummer);
    }

    public List<Produktinformation> getWareInfos(long wareNummer) {
        return katalog.gebeProduktinformationen(wareNummer);
    }

    public List<Ware> getWaren() {
        return katalog.gebeWaren();
    }

    public void algoAsuweahlen(SuchAlgorithmus suchalgorithmus) {
        katalog.legeSuchalgorithmusFest(suchalgorithmus);
    }

    public void wareHinzufuegen(Ware ware) {
        katalog.addWare(ware);
    }

    public void wareLoeschen(long wareNummer) {
        katalog.deleteWare(wareNummer);
    }

    public void wareAendern(Ware ware) {
        katalog.updateWare(ware);
    }

}
