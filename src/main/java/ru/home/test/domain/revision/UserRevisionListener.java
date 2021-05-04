package ru.home.test.domain.revision;

import org.hibernate.envers.RevisionListener;

/**
 * Custom revision listener.
 *
 * @author Aleksandr Barinov
 */
class UserRevisionListener implements RevisionListener {

    private final static String USERNAME = "vpupkin";
 
    @Override
    public void newRevision(Object o) {
        Revision r = (Revision) o;
        r.setUsername(USERNAME);
    }
}
