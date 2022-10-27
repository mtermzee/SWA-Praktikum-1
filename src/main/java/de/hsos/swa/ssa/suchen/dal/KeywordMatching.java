package de.hsos.swa.ssa.suchen.dal;

public class KeywordMatching implements WarenSuche {
    private String SQL_SELECT_BY_NAME;

    @Override
    public String gebeSqlFuerSucheWare() {
        this.SQL_SELECT_BY_NAME = "SELECT warenummer, warename, ware_preis, ware_beschreibung FROM ware WHERE warename = ?";
        return this.SQL_SELECT_BY_NAME;
    }

}
