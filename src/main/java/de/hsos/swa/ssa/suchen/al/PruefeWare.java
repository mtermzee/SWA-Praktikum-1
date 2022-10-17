package de.hsos.swa.ssa.suchen.al;

import java.util.List;

import de.hsos.swa.ssa.suchen.bl.Produktinformation;
import de.hsos.swa.ssa.suchen.bl.Ware;

public interface PruefeWare {
    List<Produktinformation> holeDetailInformation(Ware ware);
}
