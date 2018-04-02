package org.edward.javastudy.jdk.valuereference;

public class Valuereference {
    public static void main(String[] args) {

        Dog dog = new Dog("Max2");
        new Valuereference().func2(dog);

        System.out.println(dog.getName());

        Dog dog2 = new Dog("Old");
        int age100 = 100;
        dog2.setAge(age100);
        new Valuereference().changeAge(dog2.getAge());
        System.out.println("age after change: " + dog2.getAge());

    }

    public static void func(Dog d) {
        d.getName().equals("Max");

        d = new Dog("Mini");
    }

    public void func2(Dog d) {
        d.getName().equals("Max");

        d = new Dog("Mini2");
    }


    public void changeAge(int age) {
        age = 10;
    }

}

class Dog {
    private String name;
    private int age;

    public Dog(String name) {
        this.setName(name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
