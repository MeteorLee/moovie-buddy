package moviebuddy;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class CaffeineTest {

    @Test
    void useCache() throws InterruptedException {
        Cache<String, Object> cache = Caffeine.newBuilder()
                .expireAfterWrite(200, TimeUnit.MILLISECONDS) // 200 밀리 초
                .maximumSize(100) // 최대 100개
                .build();

        String key = "springRunner";
        Object value = new Object();

        Assertions.assertNull(cache.getIfPresent(key));

        cache.put(key, value);
        Assertions.assertEquals(value, cache.getIfPresent(key));

        TimeUnit.MILLISECONDS.sleep(100);
        Assertions.assertEquals(value, cache.getIfPresent(key));

        TimeUnit.MILLISECONDS.sleep(100);
        Assertions.assertNull(cache.getIfPresent(key));

    }
}
