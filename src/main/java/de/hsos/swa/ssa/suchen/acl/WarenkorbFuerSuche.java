package de.hsos.swa.ssa.suchen.acl;

public interface WarenkorbFuerSuche {
    void wareHinzufuegen(WareDTO ware);

    boolean wareLoeschen(long wareNummer);

    long gebeWarenkorbNummer();
}
