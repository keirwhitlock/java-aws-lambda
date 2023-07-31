package dev.keirz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloLambdaTest {

    @Test
    void shouldReturnHelloMessage(){
        var sut = new HelloLambda();
        Assertions.assertEquals("Hello, AWS Lambda!", sut.handleRequest());
    }
}