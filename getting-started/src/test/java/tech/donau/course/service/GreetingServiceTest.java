package tech.donau.course.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;


@QuarkusTest
public class GreetingServiceTest {

   @Inject
   GreetingService greetingService;

    @Test
    void checkReturnsHello() {
//        System.out.print(greetingService.sayHello());
        Assertions.assertEquals("_martin!your country is test England", greetingService.sayHello());
    }
}
