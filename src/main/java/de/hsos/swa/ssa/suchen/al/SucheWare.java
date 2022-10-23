package de.hsos.swa.ssa.suchen.al;

import java.util.List;

import de.hsos.swa.ssa.suchen.bl.Ware;

public interface SucheWare {
    List<Ware> sucheWare(String wareName);

    Ware sucheWare(long wareNummer);
}
