package design_pattern.abstract_factory;

public class SmallMonitor implements Monitor {
    @Override
    public MonitorDTO create() {
        return new MonitorDTO("24", "LED");
    }
}
