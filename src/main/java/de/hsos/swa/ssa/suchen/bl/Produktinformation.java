package de.hsos.swa.ssa.suchen.bl;

public class Produktinformation {
    String bezeichnung;
    Object information;

    public Produktinformation(String bezeichnung, Object information) {
        this.bezeichnung = bezeichnung;
        this.information = information;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Object getInformation() {
        return information;
    }

    public void setInformation(Object information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Produktinformation [bezeichnung=" + bezeichnung + ", information=" + information + "]";
    }

}
