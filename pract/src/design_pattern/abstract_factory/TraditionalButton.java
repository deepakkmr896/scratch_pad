package design_pattern.abstract_factory;

public class TraditionalButton implements Button{
    @Override
    public ButtonDTO create() {
        return new ButtonDTO("ABCD", "2023");
    }
}
