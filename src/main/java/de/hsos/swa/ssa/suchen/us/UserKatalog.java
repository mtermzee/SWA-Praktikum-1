package de.hsos.swa.ssa.suchen.us;

public interface UserKatalog {
    boolean wechselUser(String username);

    long gebeAktuelleUserID();

    String gebeUsername();
}
