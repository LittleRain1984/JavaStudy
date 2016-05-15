package org.edward.javastudy.springinaction.ido1;

/**
 * Created by edward on 16-5-15.
 */
public class Saxophone implements Instrument {
    @Override
    public void play() {
        System.out.println("Playing " + this);
    }
}
