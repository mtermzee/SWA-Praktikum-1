package de.hsos.swa.ssa.suchen.dal;

public class SemanticMatching implements WarenSuche {
    private String SQL_SELECT_BY_NAME;

    @Override
    public String gebeSqlFuerSucheWare() {
        this.SQL_SELECT_BY_NAME = "SELECT warenummer, warename, ware_preis, ware_beschreibung FROM ware WHERE warename LIKE '%' ? '%'";

        return this.SQL_SELECT_BY_NAME;
    }

}
