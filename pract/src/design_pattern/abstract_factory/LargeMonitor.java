package design_pattern.abstract_factory;

public class LargeMonitor implements Monitor {

    @Override
    public MonitorDTO create() {
        return new MonitorDTO("90", "LED");
    }
}
