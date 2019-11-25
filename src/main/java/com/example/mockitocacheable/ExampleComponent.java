package com.example.mockitocacheable;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ExampleComponent {

  @Cacheable(CacheConfiguration.EXAMPLE_CACHE)
  public String mockMe(String message) {
    return message;
  }
}
