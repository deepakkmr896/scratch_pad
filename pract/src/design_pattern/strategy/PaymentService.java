package design_pattern.strategy;

import enums.Status;

public class PaymentService {
    public PaymentResult makePayment(PaymentMethod paymentMethod) {
        boolean isValid = paymentMethod.validate();

        if (!isValid) {
            return new PaymentResult(Status.FAILED, paymentMethod.instrument);
        }
        try {
            return paymentMethod.pay();
        } catch (Exception e) {
            return new PaymentResult(Status.SERVER_ERROR, paymentMethod.instrument);
        }
    }
}
