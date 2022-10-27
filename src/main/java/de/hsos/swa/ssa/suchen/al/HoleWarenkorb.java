package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.acl.Warenkorb;

public interface HoleWarenkorb {
    Warenkorb holeWarenkorb();

    Warenkorb holeWarenkorb(long warenKorbNummer);
}
