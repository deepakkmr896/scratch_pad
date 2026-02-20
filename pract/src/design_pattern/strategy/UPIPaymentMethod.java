package design_pattern.strategy;

import enums.Status;

public class UPIPaymentMethod extends PaymentMethod {
    UPIPaymentMethod(PaymentInstrument instrument) {
        super(instrument);
    }

    @Override
    boolean validate() {
        boolean isValid = false;
        isValid = UPIPaymentMethod.isValidUPIID(this.instrument.getUpiId());
        if (!isValid) {
            return false;
        }

        return UPIPaymentMethod.isValidAmount(this.instrument.getAmount());
    }

    @Override
    PaymentResult pay() throws InterruptedException {
        Status status = Status.FAILED;
        System.out.println("Processing UPI Payments...");
        status = Status.PENDING;
        Thread.sleep(5);

        status = Status.SUCCESS;

        return new PaymentResult(status, this.instrument);
    }

    private static boolean isValidUPIID(String upiId) {
        return upiId != null && !upiId.isBlank();
    }

    private static boolean isValidAmount(float amount) {
        return amount > 0f;
    }
}
