public class Test2 {
    private String name;
    private String age;
    private int roll;

    public Test2(String name, String age, int roll) {
        this.name = name;
        this.age = age;
        this.roll = roll;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return this.roll == ((Test2)obj).roll && this.name.equals(((Test2)obj).name);
    }
}
