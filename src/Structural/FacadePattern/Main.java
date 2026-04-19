package Structural.FacadePattern;

public class Main {
    public static void main(String[] args) {
        BankingFacade bankingFacade = new BankingFacade();
        bankingFacade.payBill("123456", "BILL001", 50.0);
    }
}
