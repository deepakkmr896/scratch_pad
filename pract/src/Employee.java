public class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public int compareTo(Employee o) {
//        return this.getName().compareTo(o.getName());
//    }

    @Override
    public String toString() {
        return "id: " + this.getId() + " name : " + this.getName();
    }
}
