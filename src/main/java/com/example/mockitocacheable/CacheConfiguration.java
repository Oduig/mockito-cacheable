package com.example.mockitocacheable;

import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
public class CacheConfiguration {

  static final String EXAMPLE_CACHE = "exampleCache";

  private static final int CACHE_EXPIRATION_DURATION_SECONDS = 60;

  @Bean
  public Cache rolesCache() {
    return new CaffeineCache(EXAMPLE_CACHE, Caffeine.newBuilder()
        .expireAfterWrite(CACHE_EXPIRATION_DURATION_SECONDS, TimeUnit.SECONDS)
        .build());
  }
}

