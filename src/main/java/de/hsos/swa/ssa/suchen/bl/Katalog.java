package de.hsos.swa.ssa.suchen.bl;

import java.util.List;

public interface Katalog {
    void legeSuchalgorithmusFest(SuchAlgorithmus suchalgorithmus);

    List<Ware> suchen(String wareName);

    Ware suchen(long wareNummer);

    List<Produktinformation> gebeProduktinformationen(long wareNummer);

    List<Ware> gebeWaren();

    void addWare(Ware ware);

    void deleteWare(long wareNummer);

    void updateWare(Ware ware);
}
