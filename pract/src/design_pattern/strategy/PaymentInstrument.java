package design_pattern.strategy;

public class PaymentInstrument {
    public enum InstrumentType {
        UPI("UPI Payment"),
        CREDIT_CARD("Credit Card Payment");

        private final String name;
        InstrumentType(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    private float amount;
    private String upiId;
    private String userName;
    private String password;
    private InstrumentType type;

    public PaymentInstrument(PaymentInstrumentBuilder paymentInstrumentBuilder) {
        this.amount = paymentInstrumentBuilder.amount;
        this.upiId = paymentInstrumentBuilder.upiId;
        this.userName = paymentInstrumentBuilder.userName;
        this.password = paymentInstrumentBuilder.password;
        this.type = paymentInstrumentBuilder.type;
    }

    public float getAmount() {
        return amount;
    }

    public String getUpiId() {
        return upiId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public InstrumentType getType() {
        return type;
    }
}
