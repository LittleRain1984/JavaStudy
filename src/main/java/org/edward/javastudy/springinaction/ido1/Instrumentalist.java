package org.edward.javastudy.springinaction.ido1;

/**
 * Created by edward on 16-5-14.
 */
public class Instrumentalist implements Performer {


    private Instrument instrument;
    private String song;

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println("Playing " + song);
        instrument.play();
    }
}
