package org.edward.javastudy.springinaction.ido1;

/**
 * Created by edward on 16-5-13.
 */
public class HappyBirthDayPoem implements Poem {

    private static String[] LINES = {"Happy Birthday to You 1,",
            "Happy Birthday to you 1",
            "Happy Birthday to you 2",
            "Happy Birthday to you ~11"};

    public HappyBirthDayPoem(){}

    @Override
    public void recite() {
        for (String line : LINES) {
            System.out.println(line);
        }
    }
}
