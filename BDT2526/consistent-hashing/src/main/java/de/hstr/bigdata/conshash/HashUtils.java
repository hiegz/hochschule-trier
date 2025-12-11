package de.hstr.bigdata.conshash;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public final class HashUtils {
    /**
     * Eine für unsere Zwecke bessere Hash-Funktion als String.hashCode();
     * 
     * @param value
     * @return hashcode
     */
    public static final int hashCode(String value) {
        return Hashing.md5().hashString(value, Charsets.UTF_8).asInt();
    }
    
    private HashUtils() {
        // nicht instanziieren!
    }
}
