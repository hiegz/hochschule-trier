package de.hstr.bigdata.redisexample;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.google.common.io.BaseEncoding;

public final class Serializables {
    
    public static String objectToString(Serializable obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        oos.close(); // schließt baos mit!
        return BaseEncoding.base64().encode(baos.toByteArray());
    }
    
    public static <T> T stringToObject(String str) throws ClassNotFoundException, IOException {
        byte[] decode = BaseEncoding.base64().decode(str);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(decode));
        @SuppressWarnings("unchecked")
        T readObject = (T) ois.readObject();
        ois.close(); // schließt ByteArrayInputStream mit!
        return readObject;
    }
    
    private Serializables() {
        // Nicht instanziieren!
    }
}
