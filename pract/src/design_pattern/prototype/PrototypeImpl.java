package design_pattern.prototype;

public class PrototypeImpl implements Prototype {

    @Override
    public PrototypeImpl clone() throws CloneNotSupportedException {
        return (PrototypeImpl) super.clone();
    }
}
