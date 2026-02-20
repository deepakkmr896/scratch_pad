package design_pattern.strategy;

import enums.Status;

public class PaymentResult {
    public PaymentResult(Status status, PaymentInstrument instrument) {
        this.status = status;
        this.instrument = instrument;
    }

    public Status getStatus() {
        return status;
    }

    public PaymentInstrument getInstrument() {
        return instrument;
    }

    public Status status;
    public PaymentInstrument instrument;


}
