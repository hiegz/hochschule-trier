package de.hstr.bigdata.redisexample;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.common.io.Resources;

public class RedisCredentials {
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream in = Resources.getResource("redis.properties").openStream()) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String host() {
        return properties.getProperty("redis.hostname");
    }

    public static int port() {
        return Integer.valueOf(properties.getProperty("redis.port"));
    }

    public static String username() {
        return properties.getProperty("redis.username");
    }

    public static String password() {
        return properties.getProperty("redis.password");
    }
}
