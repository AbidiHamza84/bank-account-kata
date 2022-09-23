package fr.ing.interview.bankaccountkata.service.Exeption;

public class LowAmountException extends Exception{
    public LowAmountException(String message) {
        super(message);
    }
}
