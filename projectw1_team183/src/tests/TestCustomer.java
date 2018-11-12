package tests;

import model.Customer;
import interfaces.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCustomer {
    private Person user;
    private final String name = "Ali";
    private final int age = 21;

    @BeforeEach
    public void initialize() {
        user = new Customer(name, age);

    }

    @Test
    public void testGetName() {
        assertEquals(user.getName(), "Ali");
    }

    @Test
    public void testGetAge() {
        assertEquals(user.getAge(), 21);
    }



}

