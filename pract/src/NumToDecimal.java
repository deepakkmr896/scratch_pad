public class NumToDecimal implements Generics<Number, Float> {

    @Override
    public Float getResult(Number req) {
        return req.floatValue();
    }
}
