package design_pattern.abstract_factory;

public class QuertyButton implements Button {
    @Override
    public ButtonDTO create() {
        return new ButtonDTO("QUERTY", "2024");
    }
}
