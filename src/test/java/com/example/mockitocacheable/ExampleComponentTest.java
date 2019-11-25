package com.example.mockitocacheable;

import com.example.mockitocacheable.ExampleComponentTest.TestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = {
        MockitoCacheableApplication.class,
        TestConfiguration.class
    },
    webEnvironment = WebEnvironment.NONE
)
public class ExampleComponentTest {

  @Autowired
  private ExampleComponent exampleComponent;

  @Test
  public void mockMe_test1() {
    Mockito.when(exampleComponent.mockMe(Mockito.eq("Hello"))).thenReturn("Mock response 1");
  }

  @Test
  public void mockMe_test2() {
    Mockito.when(exampleComponent.mockMe(Mockito.eq("Goodbye"))).thenReturn("Mock response 2");
  }

  @Configuration
  public static class TestConfiguration {

    @Bean
    public ExampleComponent exampleComponent() {
      return Mockito.mock(ExampleComponent.class);
    }
  }
}
