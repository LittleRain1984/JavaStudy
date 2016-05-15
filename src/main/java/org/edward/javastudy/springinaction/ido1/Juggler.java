package org.edward.javastudy.springinaction.ido1;

/**
 * Created by edward on 16-5-13.
 */
public class Juggler implements Performer {
    private int beanBags = 3;

    public Juggler() {
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println(this.getClass().getCanonicalName() + " Jugglling " + beanBags + " BeanBags.");
    }

}
