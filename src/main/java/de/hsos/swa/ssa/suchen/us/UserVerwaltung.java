package de.hsos.swa.ssa.suchen.us;

import java.util.HashMap;
import java.util.Map;

public class UserVerwaltung implements UserKatalog {
    Map<Long, User> userMap = new HashMap<>();
    long aktuellerUserID;

    public UserVerwaltung() {
        User admin = new User(0, "admin");
        userMap.put(admin.getId(), admin);
        aktuellerUserID = admin.getId();
    }

    @Override
    public boolean wechselUser(String username) {
        for (User user : userMap.values()) {
            if (user.getUsername().equals(username)) {
                aktuellerUserID = user.getId();
                return true;
            }
        }
        aktuellerUserID = userMap.size();
        User user = new User(aktuellerUserID, username);
        userMap.put(aktuellerUserID, user);

        return false;
    }

    @Override
    public long gebeAktuelleUserID() {
        return aktuellerUserID;
    }

    @Override
    public String gebeUsername() {
        return userMap.get(aktuellerUserID).getUsername();
    }

}
