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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Warenkorb holeWarenkorb() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Warenkorb holeWarenkorb(long warenKorbNummer) {
        // TODO Auto-generated method stub
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
