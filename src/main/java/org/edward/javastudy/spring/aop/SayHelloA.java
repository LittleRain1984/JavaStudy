package org.edward.javastudy.spring.aop;

/**
 * Created by edward on 16-5-19.
 */
public class SayHelloA implements ISayHello {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void sayHello() {
        System.out.println(this.getClass().getCanonicalName() + "   hello: " + name);
    }
}
