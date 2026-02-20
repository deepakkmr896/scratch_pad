package design_pattern.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        // Client
        PaymentInstrument upiInstrument = new PaymentInstrumentBuilder()
                .amount(10.0f)
                .upiId("dk@okicici")
                .type(PaymentInstrument.InstrumentType.UPI)
                .build();

        PaymentMethod upiPayment = new UPIPaymentMethod(upiInstrument);

        PaymentInstrument creditCardInstrument = new PaymentInstrumentBuilder()
                .amount(15.0f)
                .userName("depakk")
                .password("pass@w0rd")
                .type(PaymentInstrument.InstrumentType.CREDIT_CARD)
                .build();

        PaymentMethod creditCardPayment = new CreditCardPayment(creditCardInstrument);

        PaymentService service = new PaymentService();

        try {
            int coreSize = 2;
            int maxCore = coreSize + 2;
            try (ExecutorService executorService = new ThreadPoolExecutor(coreSize, maxCore, 120L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10))) {

                List<Callable<PaymentResult>> callables = new ArrayList<>();
                callables.add(() -> service.makePayment(upiPayment));
                callables.add(() -> service.makePayment(creditCardPayment));
                List<Future<PaymentResult>> res = executorService.invokeAll(callables);
                for (Future<PaymentResult> future: res) {
                    PaymentResult result = future.get();
                    System.out.printf("Payment %s by %s for Amount: %f%n", result.getStatus().name(), result.getInstrument().getType().getName(), result.getInstrument().getAmount());
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.printf("Sorry!! Something went wrong!! %s%n", e.getMessage());
        }
    }
}
