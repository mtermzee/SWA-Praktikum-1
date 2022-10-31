package de.hsos.swa.ssa.suchen.al;

import java.util.List;

import de.hsos.swa.ssa.suchen.bl.Ware;

public interface WaehleWare {
    boolean wareZuWarenkorbHinzufuegen(long wareNummer);

    boolean wareAusWarenkorbLoeschen(long wareNummer);

    void aktuellerWarenkorbWechseln(long warenNummer);

    List<Ware> holeWaren();
}
