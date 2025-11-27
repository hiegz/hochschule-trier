package de.hstr.bigdata.redisexample;

import redis.clients.jedis.Jedis;

public class RedisClientBase implements AutoCloseable {
    private Jedis jedis;
    private String username;

    public RedisClientBase(String host, int port, String username, String password) {
        this.jedis = new Jedis(host, port);
        this.username = username;
        jedis.auth(username, password);
    }

    @Override
    public void close() throws Exception {
        jedis.close();
    }

    protected Jedis getJedis() {
        return jedis;
    }

    protected String getUsername() {
        return username;
    }
}
