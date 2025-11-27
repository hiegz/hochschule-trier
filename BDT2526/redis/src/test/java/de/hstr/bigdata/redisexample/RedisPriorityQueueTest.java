package de.hstr.bigdata.redisexample;

import static de.hstr.bigdata.redisexample.RedisCredentials.host;
import static de.hstr.bigdata.redisexample.RedisCredentials.password;
import static de.hstr.bigdata.redisexample.RedisCredentials.port;
import static de.hstr.bigdata.redisexample.RedisCredentials.username;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisPriorityQueueTest {
    private Jedis jedis;
    private RedisPriorityQueue<String> redisQueue;

    @Before
    public void setUp() {
        jedis = new Jedis(host(), port());
        jedis.auth(username(), password());
        
        redisQueue = new RedisPriorityQueue<String>(host(), port(), username(), password(), username() + ":queuekey");
    }
    
    @After
    public void tearDown() {
        jedis.del(username() + ":queuekey");
    }
    
    @Test
    public void testEmpty() throws ClassNotFoundException, IOException {
        assertThat(redisQueue.pop(), is(nullValue()));
    }
    
    @Test
    public void testQueue() throws ClassNotFoundException, IOException {
        redisQueue.push("aaa", 0.2);
        redisQueue.push("bbb", 0.5);
        redisQueue.push("ccc", 0.1);
        assertThat(redisQueue.pop(), is("ccc"));
        assertThat(redisQueue.pop(), is("aaa"));
        assertThat(redisQueue.pop(), is("bbb"));
        assertThat(redisQueue.pop(), is(nullValue()));
        redisQueue.push("ddd", 0.3);
        redisQueue.push("eee", 0.1);
        redisQueue.push("fff", 0.4);
        redisQueue.push("ggg", 0.2);
        assertThat(redisQueue.pop(), is("eee"));
        assertThat(redisQueue.pop(), is("ggg"));
        assertThat(redisQueue.pop(), is("ddd"));
        assertThat(redisQueue.pop(), is("fff"));
        assertThat(redisQueue.pop(), is(nullValue()));
        redisQueue.push("hhh", 0.2);
        redisQueue.push("iii", 0.1);
        assertThat(redisQueue.pop(), is("iii"));
        assertThat(redisQueue.pop(), is("hhh"));
        assertThat(redisQueue.pop(), is(nullValue()));
    }
}
