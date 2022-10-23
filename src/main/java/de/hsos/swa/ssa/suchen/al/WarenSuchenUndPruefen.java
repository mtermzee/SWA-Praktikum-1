package de.hsos.swa.ssa.suchen.al;

import java.util.List;

import de.hsos.swa.ssa.suchen.bl.Katalog;
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
}
