package SavageMode;

import interfaces.Person;

public class Security extends BankSafe implements Person {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public boolean startHeist() { return false;
    }
}
