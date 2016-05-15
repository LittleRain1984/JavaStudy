package org.edward.javastudy.springinaction.knights;

/**
 * Created by edward on 16-5-13.
 */
public class BraveKnight {

    private Quest quest;

    public BraveKnight(Quest quest){
        this.quest = quest;
    }

    public void enbarkOnQuest() {
        quest.embark();
    }

}
