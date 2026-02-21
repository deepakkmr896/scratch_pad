package design_pattern.strategy;

import enums.Status;

public class CreditCardPayment extends PaymentMethod {

    CreditCardPayment(PaymentInstrument instrument) {
        super(instrument);
    }

    @Override
    boolean validate() {
        return !this.getInstrument().getUserName().isBlank() && !this.getInstrument().getPassword().isBlank();
    }

    @Override
    PaymentResult pay() throws InterruptedException {
        Status status = Status.FAILED;
        System.out.println("Processing Credit Card Payments...");
        status = Status.PENDING;
        Thread.sleep(5);

        status = Status.SUCCESS;

        return new PaymentResult(status, this.getInstrument());
    }
}
