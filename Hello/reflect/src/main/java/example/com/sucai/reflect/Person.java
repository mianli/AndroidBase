package example.com.sucai.reflect;

/**
 * Created by limian on 2018/1/9.
 */

public class Person {

    private String name;
    private int age;
    private Student student;

    public Person() {
        student = new Student();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "age : " + age + ", name : " + name;
    }
}
