package dev.keirz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListSubscribersTest {

    private ListSubscribers sut;
    private DataSourceProperties db;

    @BeforeEach
    void setUp() {
        db = new DataSourceProperties(
                "localhost",
                5432,
                "newsletter",
                "postgres",
                "password"
        );

        sut = new ListSubscribers(db);
    }

    @Test
    void shouldListAllSubscribers(){

        List<String> emails = sut.handleRequest();
        assertEquals(5, emails.size());

    }

}