package de.hstr.bigdata.redisexample;

import static de.hstr.bigdata.redisexample.RedisCredentials.host;
import static de.hstr.bigdata.redisexample.RedisCredentials.password;
import static de.hstr.bigdata.redisexample.RedisCredentials.port;
import static de.hstr.bigdata.redisexample.RedisCredentials.username;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisUserCountsTest {
    private UserCounts redisUserCounts;
    private Jedis jedis;

    @Before
    public void setUp() {
        jedis = new Jedis(host(), port());
        jedis.auth(username(), password());
        redisUserCounts = new RedisUserCounts(host(), port(), username(), password());
    }
    
    @After
    public void tearDown() throws Exception {
        for (int user = 1; user <= 3; user++) {
            jedis.del(String.format("%s:user%d", username(), user));
            for (int page = 1; page <= 3; page++) {
                jedis.del(String.format("%s:user%d:page%d", username(), user, page));
            }            
        }
        jedis.del(String.format("%s:user1:sport", username()));
        jedis.del(String.format("%s:user2:sport", username()));
        jedis.close();
        redisUserCounts.close();
    }
    
    @Test
    public void testCountOne() {
        redisUserCounts.countAccess("user1", "sport");
        
        assertThat(redisUserCounts.getCount("user1", "sport"), is(1));
        assertThat(redisUserCounts.getCount("user2", "sport"), is(0));
    }
    
    @Test
    public void testCountMany() {
        redisUserCounts.countAccess("user1", "page1");
        redisUserCounts.countAccess("user1", "page2");
        redisUserCounts.countAccess("user1", "page2");
        redisUserCounts.countAccess("user2", "page1");
        redisUserCounts.countAccess("user2", "page1");
        redisUserCounts.countAccess("user2", "page2");
        redisUserCounts.countAccess("user2", "page2");
        redisUserCounts.countAccess("user2", "page3");
        redisUserCounts.countAccess("user2", "page3");
        redisUserCounts.countAccess("user2", "page3");
        redisUserCounts.countAccess("user2", "page3");
        redisUserCounts.countAccess("user3", "page1");
        redisUserCounts.countAccess("user3", "page1");
        redisUserCounts.countAccess("user3", "page2");
        redisUserCounts.countAccess("user3", "page2");
        redisUserCounts.countAccess("user3", "page2");
        redisUserCounts.countAccess("user3", "page2");
        redisUserCounts.countAccess("user3", "page3");
        redisUserCounts.countAccess("user3", "page3");
        redisUserCounts.countAccess("user3", "page3");
        
        assertThat(redisUserCounts.getCount("user1", "page1"), is(1));
        assertThat(redisUserCounts.getCount("user1", "page2"), is(2));
        assertThat(redisUserCounts.getCount("user1", "page3"), is(0));
        
        assertThat(redisUserCounts.getCount("user2", "page1"), is(2));
        assertThat(redisUserCounts.getCount("user2", "page2"), is(2));
        assertThat(redisUserCounts.getCount("user2", "page3"), is(4));
        
        assertThat(redisUserCounts.getCount("user3", "page1"), is(2));
        assertThat(redisUserCounts.getCount("user3", "page2"), is(4));
        assertThat(redisUserCounts.getCount("user3", "page3"), is(3));
    }
}
