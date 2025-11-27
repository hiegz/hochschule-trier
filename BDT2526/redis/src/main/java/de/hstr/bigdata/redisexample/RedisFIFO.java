package de.hstr.bigdata.redisexample;

import java.io.IOException;
import java.io.Serializable;

public class RedisFIFO<T extends Serializable> extends RedisClientBase implements FIFO<T> {
    String queueKey;

    public RedisFIFO(String host, int port, String username, String password, String queueKey) {
        super(host, port, username, password);
        this.queueKey = queueKey;
    }

    @Override
    public void push(T t) throws IOException {
        String data = Serializables.objectToString(t);
        getJedis().lpush(queueKey, data);
    }

    @Override
    public T pop() throws ClassNotFoundException, IOException {
        String data = getJedis().rpop(queueKey);
        if (data == null)
            return null;
        return Serializables.stringToObject(data);
    }
}
