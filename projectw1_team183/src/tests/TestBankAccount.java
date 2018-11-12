package tests;

import model.BankAccount;
import model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBankAccount {
    private Customer user;
    private BankAccount userAccount;
    private final String name = "Ali";
    private final int age = 21;

    @BeforeEach
    public void initialize() {
        user = new Customer(name, age);
        userAccount = new BankAccount(user);

    }

    @Test
    public void testDeposit() {
        double withdrawAmount = 50;
        assertFalse (withdrawAmount <= userAccount.balance);

        withdrawAmount = 0;
        assertTrue(withdrawAmount <= userAccount.balance);
    }
    @Test
    public void testsetName() {
        userAccount.setAccountName("hee");
        assertTrue(userAccount.getName().equals("hee"));
    }

    @Test
    public void testGetBalance() {
        assertEquals(userAccount.balance, 0.00);
    }

    @Test
    public void testGetName() {
        assertEquals(userAccount.getName(), name);
    }
}
