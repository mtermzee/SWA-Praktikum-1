package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.bl.Ware;

public interface VerwalteWare {
    void addWare(Ware ware);

    void deleteWare(long wareNummer);

    void updateWare(Ware ware);

    Ware sucheWare(long wareNummer);
}
