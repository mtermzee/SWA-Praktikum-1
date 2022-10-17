package de.hsos.swa.ssa.suchen.acl;

import de.hsos.swa.ssa.suchen.bl.Ware;

public class WareDTO {
    long nummer;
    String name;
    double preis;
    String beschreibung;

    public WareDTO(Ware ware) {
        this.nummer = ware.getNummer();
        this.name = ware.getName();
        this.preis = ware.getPreis();
        this.beschreibung = ware.getBeschreibung();
    }

    public static class WarenKonverter {
        public static WareDTO konvertiere(Ware ware) {
            return new WareDTO(ware);
        }
    }

    public WareDTO wareToDTO(Ware ware) {
        return WarenKonverter.konvertiere(ware);
    }
}
