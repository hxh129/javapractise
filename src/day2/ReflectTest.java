package day2;

public class ReflectTest {
    private String name;

    public ReflectTest(String name) {
        this.name = name;
    }

    private String getName() {

        System.out.println(name);
        return name;
    }
}
