package StrategyPattern;

// payment example
// strategy number 1
interface PayStrategy {
    void pay();
}

// strategy number 2
interface AuthStrategy {
    void auth();
}

// implementations of payStrategy
class OnlinePayment implements PayStrategy {
    @Override
    public void pay() {
        System.out.println("payment made successfully (online mode).");
    }
}

class OfflinePayment implements PayStrategy {
    @Override
    public void pay() {
        System.out.println("Payment made successfully (offline mode).");
    }
}

//implementations of AuthStrategy
class OTP implements AuthStrategy {
    @Override
    public void auth() {
        System.out.println("OTP verified successfully.");
    }
}

class Password implements AuthStrategy {
    @Override
    public void auth() {
        System.out.println("Password verified successfully.");
    }
}

class Biometrics implements AuthStrategy {
    @Override
    public void auth() {
        System.out.println("Fingerprint verified successfully.");
    }
}

class Signature implements AuthStrategy {
    @Override
    public void auth() {
        System.out.println("signature verified successfully");
    }
}

//The class which uses the strategies as a composition
abstract class SuperPayment {
    private final PayStrategy payStrategy; // composition
    private final AuthStrategy authStrategy; // composition

    public SuperPayment(AuthStrategy authStrategy,
                        PayStrategy payStrategy) {
        this.authStrategy = authStrategy;
        this.payStrategy = payStrategy;
    }

    public void auth() {
        authStrategy.auth();
    }

    public void makePayment() {
        payStrategy.pay();
    }

    public abstract void displayDetails();
}

//types of payment (children of SuperPayment)
class DebitCard extends SuperPayment {
    DebitCard(AuthStrategy authStrategy, PayStrategy payStrategy) {
        super(authStrategy, payStrategy);
    }

    @Override
    public void displayDetails() {
        System.out.println("payment made using DebitCard.");
    }
}

class CreditCard extends SuperPayment {
    CreditCard(AuthStrategy authStrategy, PayStrategy payStrategy) {
        super(authStrategy, payStrategy);
    }

    @Override
    public void displayDetails() {
        System.out.println("payment made using CreditCard.");
    }
}

class UPI extends SuperPayment {
    UPI(AuthStrategy authStrategy, PayStrategy payStrategy) {
        super(authStrategy, payStrategy);
    }

    @Override
    public void displayDetails() {
        System.out.println("payment made using UPI.");
    }
}

class GiftCard extends SuperPayment {
    GiftCard(AuthStrategy authStrategy, PayStrategy payStrategy) {
        super(authStrategy, payStrategy);
    }

    @Override
    public void displayDetails() {
        System.out.println("GiftCard redeemed.");
    }
}

class Challan extends SuperPayment {

    public Challan(AuthStrategy authStrategy, PayStrategy payStrategy) {
        super(authStrategy, payStrategy);
    }

    @Override
    public void displayDetails() {
        System.out.println("Challan payment made successfully");
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        // debit card payment uses OTP for auth and online payment for the transaction
        SuperPayment debitCard = new DebitCard(new OTP(), new OnlinePayment());
        debitCard.displayDetails();
        debitCard.auth();
        debitCard.makePayment();
        System.out.println("----------");
        // credit card payment uses Biometrics for auth and online payment for the transaction
        SuperPayment creditCard = new CreditCard(new Biometrics(), new OnlinePayment());
        creditCard.auth();
        creditCard.makePayment();
        creditCard.displayDetails();
        System.out.println("-----------");
        // challan payment uses signature for auth and offline payment for the transaction
        SuperPayment challan = new Challan(new Signature(), new OfflinePayment());
        challan.auth();
        challan.makePayment();
        challan.displayDetails();
    }
}