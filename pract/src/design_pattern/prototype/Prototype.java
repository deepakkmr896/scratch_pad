package design_pattern.prototype;

public interface Prototype extends Cloneable {
    Prototype clone() throws CloneNotSupportedException;
}
