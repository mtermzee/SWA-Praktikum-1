package de.hsos.swa.ssa.suchen.acl;

import java.util.ArrayList;
import java.util.List;

public class Warenkorb {

    private long warenkorbNummer;
    private List<WareDTO> waren = new ArrayList<>();

    public Warenkorb() {
    }

    public Warenkorb(long warenkorbNummer) {
        this.warenkorbNummer = warenkorbNummer;
    }

    public Warenkorb(long warenkorbNummer, List<WareDTO> waren) {
        this.warenkorbNummer = warenkorbNummer;
        this.waren = waren;
    }

    public long getWarenkorbNummer() {
        return warenkorbNummer;
    }

    public void setWarenkorbNummer(long warenkorbNummer) {
        this.warenkorbNummer = warenkorbNummer;
    }

    public List<WareDTO> getWaren() {
        return waren;
    }

    public void setWaren(List<WareDTO> waren) {
        this.waren = waren;
    }

    public void addWare(WareDTO ware) {
        waren.add(ware);
    }

    public void warenDrucken() {
        System.out.println(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (warenkorbNummer ^ (warenkorbNummer >>> 32));
        result = prime * result + ((waren == null) ? 0 : waren.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Warenkorb other = (Warenkorb) obj;
        if (warenkorbNummer != other.warenkorbNummer)
            return false;
        if (waren == null) {
            if (other.waren != null)
                return false;
        } else if (!waren.equals(other.waren))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Warenkorb [warenkorbNummer=" + warenkorbNummer + ", waren=" + waren + "]";
    }

}
