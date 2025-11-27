package de.hstr.bigdata.redisexample;

/**
 * Zählt die Zugriffe von Benutzern auf Webseiten.
 * 
 * @author schmi
 */
public interface UserCounts extends AutoCloseable {
    /**
     * Zähle einen Zugriff.
     * 
     * @param userId ID des Benutzers
     * @param pageId ID der Webseite
     */
    void countAccess(String userId, String pageId);

    /**
     * @param userId ID des Benutzers
     * @param pageId ID der Webseite
     *
     * @return Anzahl der Zugriffe des Users auf die Seite
     */
    int getCount(String userId, String pageId);
}
