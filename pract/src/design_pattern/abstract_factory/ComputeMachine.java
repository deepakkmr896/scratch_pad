package design_pattern.abstract_factory;

// class -> Builder which can build the required object with preferred fields
// define -> ComputeMachine (required object) -> ComputeMachineBuilder which will build object
// What attributes?? -> MonitorDTO and ButtonDTO
// How to create DTOs?? -> use Abstract Factory
// create interface -> Monitor and Button
// implement the Monitor and Button with concrete class
public final class ComputeMachine {
    private final MonitorDTO monitor;
    private final ButtonDTO button;

    public ComputeMachine(ComputeMachineBuilder builder) {
        this.monitor = builder.monitor;
        this.button = builder.button;
    }

    public static class ComputeMachineBuilder {
        private MonitorDTO monitor;
        private ButtonDTO button;
        public ComputeMachineBuilder monitor(MonitorDTO monitor) {
            this.monitor = monitor;
            return this;
        }

        public ComputeMachineBuilder button(ButtonDTO button) {
            this.button = button;
            return this;
        }

        public ComputeMachine build() {
            return new ComputeMachine(this);
        }
    }

    @Override
    public String toString() {
        return "Monitor size: " + this.monitor.size() + " type: " + this.monitor.type() + " Button size: " + this.button.type() + " Year of Manufacture: " + this.button.yearOfManufacture();
    }
}
