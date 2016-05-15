package org.edward.javastudy.springinaction.ido1;

/**
 * Created by edward on 16-5-14.
 */
public class Stage {

    private Stage(){}

    private static class StageSingletonHolder{
        static Stage instance = new Stage();
    }

    public static Stage getInstance() {
        return StageSingletonHolder.instance;
    }

}
