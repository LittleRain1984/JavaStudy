package org.edward.javastudy.springinaction.ido1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by edward on 16-5-13.
 */
public class Application {
    public static void main(String[] args) throws PerformanceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("org/edward/javastudy/springinaction/ido1/beans.xml");
//        Juggler duke = (Juggler) ctx.getBean("duke");
//        try {
//            duke.perform();
//        } catch (PerformanceException e) {
//            e.printStackTrace();
//        }

//        Juggler duke = (Juggler) ctx.getBean("poeticDuke");
//        duke.perform();
        Performer kenny = (Performer) ctx.getBean("kenny");
        kenny.perform();

        Performer kenny2 = (Performer) ctx.getBean("kenny2");
        kenny2.perform();
    }
}
