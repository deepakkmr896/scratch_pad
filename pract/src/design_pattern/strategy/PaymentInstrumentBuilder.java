package design_pattern.strategy;

public class PaymentInstrumentBuilder {
    public float amount;
    public String upiId;
    public String userName;
    public String password;
    public PaymentInstrument.InstrumentType type;

    PaymentInstrumentBuilder amount(float amount) {
        this.amount = amount;
        return this;
    }

    PaymentInstrumentBuilder upiId(String upiId) {
        this.upiId = upiId;
        return this;
    }

    PaymentInstrumentBuilder userName(String userName) {
        this.userName = userName;
        return this;
    }

    PaymentInstrumentBuilder password(String password) {
        this.password = password;
        return this;
    }

    PaymentInstrumentBuilder type(PaymentInstrument.InstrumentType type) {
        this.type = type;
        return this;
    }

    PaymentInstrument build() {
        return new PaymentInstrument(this);
    }
}
