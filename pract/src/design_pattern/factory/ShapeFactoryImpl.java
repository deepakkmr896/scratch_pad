package design_pattern.factory;

public class ShapeFactoryImpl implements ShapeFactory{
    @Override
    public Shape create(String type) {
        if (type.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        return null;
    }
}
