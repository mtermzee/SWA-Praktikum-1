package de.hsos.swa.ssa.suchen.al;

import java.util.List;

import de.hsos.swa.ssa.suchen.bl.Produktinformation;;

public interface PruefeWare {
    List<Produktinformation> holeDetailInformation(long wareNummer);
}
