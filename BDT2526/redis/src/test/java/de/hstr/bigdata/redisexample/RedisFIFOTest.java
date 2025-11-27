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

public class RedisFIFOTest {
    private Jedis jedis;
    private FIFO<String> redisFIFO;

    @Before
    public void setUp() {
        jedis = new Jedis(host(), port());
        jedis.auth(username(), password());
        
        redisFIFO = new RedisFIFO<String>(host(), port(), username(), password(), username() + ":fifokey");
    }
    
    @After
    public void tearDown() {
        jedis.del(username() + ":fifokey");
    }
    
    @Test
    public void testEmpty() throws ClassNotFoundException, IOException {
        assertThat(redisFIFO.pop(), is(nullValue()));
    }
    
    @Test
    public void testFIFO() throws ClassNotFoundException, IOException {
        redisFIFO.push("aaa");
        redisFIFO.push("bbb");
        redisFIFO.push("ccc");
        assertThat(redisFIFO.pop(), is("aaa"));
        assertThat(redisFIFO.pop(), is("bbb"));
        assertThat(redisFIFO.pop(), is("ccc"));
        assertThat(redisFIFO.pop(), is(nullValue()));
        redisFIFO.push("ddd");
        redisFIFO.push("eee");
        redisFIFO.push("fff");
        redisFIFO.push("ggg");
        assertThat(redisFIFO.pop(), is("ddd"));
        assertThat(redisFIFO.pop(), is("eee"));
        assertThat(redisFIFO.pop(), is("fff"));
        assertThat(redisFIFO.pop(), is("ggg"));
        assertThat(redisFIFO.pop(), is(nullValue()));
        redisFIFO.push("hhh");
        redisFIFO.push("iii");
        assertThat(redisFIFO.pop(), is("hhh"));
        assertThat(redisFIFO.pop(), is("iii"));
        assertThat(redisFIFO.pop(), is(nullValue()));
    }
}
