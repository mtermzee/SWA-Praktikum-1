package de.hsos.swa.ssa.suchen.bl;

import java.util.List;

public class Ware {
    long nummer;
    String name;
    double preis;
    String beschreibung;
    List<Produktinformation> produktinformationen;

    public Ware(long nummer, String name, double preis, String beschreibung) {
        this.nummer = nummer;
        this.name = name;
        this.preis = preis;
        this.beschreibung = beschreibung;
    }

    public Ware(long nummer, String name, double preis, String beschreibung,
            List<Produktinformation> produktinformationen) {
        this.nummer = nummer;
        this.name = name;
        this.preis = preis;
        this.beschreibung = beschreibung;
        this.produktinformationen = produktinformationen;
    }

    public long getNummer() {
        return nummer;
    }

    public void setNummer(long nummer) {
        this.nummer = nummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public List<Produktinformation> getProduktinformationen() {
        return produktinformationen;
    }

    public void setProduktinformationen(List<Produktinformation> produktinformationen) {
        this.produktinformationen = produktinformationen;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (nummer ^ (nummer >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        long temp;
        temp = Double.doubleToLongBits(preis);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((beschreibung == null) ? 0 : beschreibung.hashCode());
        result = prime * result + ((produktinformationen == null) ? 0 : produktinformationen.hashCode());
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
        Ware other = (Ware) obj;
        if (nummer != other.nummer)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Double.doubleToLongBits(preis) != Double.doubleToLongBits(other.preis))
            return false;
        if (beschreibung == null) {
            if (other.beschreibung != null)
                return false;
        } else if (!beschreibung.equals(other.beschreibung))
            return false;
        if (produktinformationen == null) {
            if (other.produktinformationen != null)
                return false;
        } else if (!produktinformationen.equals(other.produktinformationen))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ware [nummer=" + nummer + ", name=" + name + ", preis=" + preis + ", beschreibung=" + beschreibung
                + ", produktinformationen=" + produktinformationen + "]";
    }

}
