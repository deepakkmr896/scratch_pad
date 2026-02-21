package design_pattern.strategy;

public abstract class PaymentMethod {
    private final PaymentInstrument instrument;

    PaymentMethod(PaymentInstrument instrument) {
        this.instrument = instrument;
    }

    abstract boolean validate();
    abstract PaymentResult pay() throws InterruptedException;

    public PaymentInstrument getInstrument() {
        return instrument;
    }
}
