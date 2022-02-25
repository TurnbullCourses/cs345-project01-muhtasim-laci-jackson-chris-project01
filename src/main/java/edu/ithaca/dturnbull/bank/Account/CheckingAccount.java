package edu.ithaca.dturnbull.bank.Account;

public class CheckingAccount extends AbstractAccount {
    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public CheckingAccount(double startingBalance) {
        if (isNumberValid(startingBalance)) {
            this.balance = startingBalance;
        } else {
            throw new IllegalArgumentException(
                    "Starting Balance: " + startingBalance + " is invalid, cannot create account");
        }
    }

    /**
     * @post reduces the balance by @param amount if amount is non-negative, smaller
     *       than balance and less than the withdraw limit.
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        if (isNumberValid(amount)) {
            if (amount <= balance) {
                balance -= amount;
                balance = Math.round(balance * 100.0) / 100.0; // Multiply by 100 and round to cut off all decimals past
                                                               // the hundreths place. Divide by 100 to make sure the
                                                               // number has two decimasl again
            } else {
                throw new InsufficientFundsException("Not enough money in the account.");
            }
        } else {
            throw new IllegalArgumentException("Amount to withdraw is invalid.");
        }
    }

    /**
     * @post reduces the balance by @param amount if amount is non-negative, smaller
     *       than balance and withdrawLimit.
     *       Deposits the same amount into @param transferee account.
     */
    public void transfer(double amount, AbstractAccount transferee) throws InsufficientFundsException {
        if (isNumberValid(amount)) {
            if (amount <= balance) {
                balance -= amount;
                balance = Math.round(balance * 100.0) / 100.0;// Multiply by 100 and round to cut off all decimals
                                                              // past the
                transferee.deposit(amount); // hundreths place. Divide by 100 to make sure the number has two
                                            // decimasl again
            } else {
                throw new InsufficientFundsException("Not enough money in the account.");
            }

        } else {
            throw new IllegalArgumentException("Amount to withdraw is invalid.");
        }
    }
}