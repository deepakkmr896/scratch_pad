public class Test1 {
    private String name;
    private String age;
    private int roll;

    public Test1(String name, String age, int roll) {
        this.name = name;
        this.age = age;
        this.roll = roll;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return this.roll == ((Test1)obj).roll && this.name.equals(((Test1)obj).name);
    }
}
