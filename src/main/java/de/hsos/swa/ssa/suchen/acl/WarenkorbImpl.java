package de.hsos.swa.ssa.suchen.acl;

import java.util.HashMap;
import java.util.Map;

public class WarenkorbImpl implements WarenkorbStaender, WarenkorbFuerSuche {
    Map<Long, Warenkorb> warenkorbMap = new HashMap<>();
    long currentWarenKorbID;

    public WarenkorbImpl() {
    }

    @Override
    public void wareHinzufuegen(WareDTO ware) {
        /*
         * warenkorb.addWare(ware);
         * warenkorb.warenDrucken();
         */
        Warenkorb warenkorb = warenkorbMap.get(currentWarenKorbID);
        warenkorb.addWare(ware);
        warenkorb.warenDrucken();
    }

    @Override
    public long gebeWarenkorbNummer() {
        return this.currentWarenKorbID;
    }

    @Override
    public Warenkorb holeWarenkorb() {
        return this.warenkorbMap.get(currentWarenKorbID);
    }

    @Override
    public Warenkorb holeWarenkorb(long warenKorbNummer) {
        if (warenkorbMap.containsKey(warenKorbNummer)) {
            return warenkorbMap.get(warenKorbNummer);
        }
        return null;
    }

    @Override
    public void aktuellerWarenkorbWechseln(long warenkorbNummer) {
        if (!warenkorbMap.containsKey(warenkorbNummer)) {
            warenkorbMap.put(warenkorbNummer, new Warenkorb(warenkorbNummer));
        }
        currentWarenKorbID = warenkorbNummer;
    }

}
