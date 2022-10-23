package de.hsos.swa.ssa.suchen.al;

import java.util.List;

import de.hsos.swa.ssa.suchen.bl.Ware;

public interface WaehleWare {
    boolean wareZuWarenkorbHinzufuegen(Ware ware);

    List<Ware> holeWaren();
}
