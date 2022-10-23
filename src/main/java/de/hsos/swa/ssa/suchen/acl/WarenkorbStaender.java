package de.hsos.swa.ssa.suchen.acl;

public interface WarenkorbStaender {
    Warenkorb holeWarenkorb();

    Warenkorb holeWarenkorb(long warenKorbNummer);

    void aktuellerWarenkorbWechseln(long warenkorbNummer);
}
