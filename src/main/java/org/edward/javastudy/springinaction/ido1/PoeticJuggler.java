package org.edward.javastudy.springinaction.ido1;

/**
 * Created by edward on 16-5-13.
 */
public class PoeticJuggler extends Juggler {
    private Poem poem;

    public PoeticJuggler(){}

    public PoeticJuggler(Poem poem) {
        this.poem = poem;
    }

    public PoeticJuggler(int beanBags, Poem poem){
        super(beanBags);
        this.poem = poem;
    }

    @Override
    public void perform() throws PerformanceException {
        super.perform();
        System.out.println(this.getClass().getCanonicalName() + " while reciting...");
        poem.recite();
    }
}
