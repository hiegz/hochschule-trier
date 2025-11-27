package de.hstr.bigdata.redisexample;

import redis.clients.jedis.Jedis;

public class RedisUserCounts extends RedisClientBase implements UserCounts {
    RedisUserCounts(String host, int port, String username, String password) {
        super(host, port, username, password);
    }

    @Override
    public void countAccess(String userId, String pageId) {
        Jedis jedis = super.getJedis();
        String username = super.getUsername();
        String key = username + ":" + userId;

        jedis.hincrBy(key, pageId, 1);
    }

    @Override
    public int getCount(String userId, String pageId) {
        Jedis jedis = super.getJedis();
        String username = super.getUsername();
        String key = username + ":" + userId;

        String result = jedis.hget(key, pageId);
        if (result == null)
            return 0;
        return Integer.parseInt(result);
    }
}
