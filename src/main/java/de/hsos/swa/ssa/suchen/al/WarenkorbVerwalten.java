package de.hsos.swa.ssa.suchen.al;

import de.hsos.swa.ssa.suchen.acl.WareDTO;
import de.hsos.swa.ssa.suchen.acl.Warenkorb;
import de.hsos.swa.ssa.suchen.acl.WarenkorbFuerSuche;
import de.hsos.swa.ssa.suchen.acl.WarenkorbImpl;
import de.hsos.swa.ssa.suchen.acl.WarenkorbStaender;
import de.hsos.swa.ssa.suchen.bl.Ware;

public class WarenkorbVerwalten {

    private WareDTO konvDto;
    private WarenkorbFuerSuche warenkorbFuerSuche;
    private WarenkorbStaender warenkorbStaender;

    public WarenkorbVerwalten() {
        WarenkorbImpl warenkorbImpl = new WarenkorbImpl();
        konvDto = new WareDTO();
        warenkorbFuerSuche = warenkorbImpl;
        warenkorbStaender = warenkorbImpl;
        warenkorbStaender.aktuellerWarenkorbWechseln(1);
    }

    public void wareZuWarenkorbSenden(Ware ware) {
        this.konvDto = new WareDTO(ware);
        warenkorbFuerSuche.wareHinzufuegen(konvDto);
    }

    public boolean wareZuWarenkorbLoeschen(long wareNummer) {
        return warenkorbFuerSuche.wareLoeschen(wareNummer);
    }

    public void aktuelleWarenkorb(long wareNummer) {
        warenkorbStaender.aktuellerWarenkorbWechseln(wareNummer);
    }

    public Warenkorb warenkorbHolen() {
        return warenkorbStaender.holeWarenkorb();
    }

    public Warenkorb warenkorbHolen(long warekorbNummer) {
        return warenkorbStaender.holeWarenkorb(warekorbNummer);
    }

}
