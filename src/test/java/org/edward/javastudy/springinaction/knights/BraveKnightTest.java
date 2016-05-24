package org.edward.javastudy.springinaction.knights;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

/**
 * Created by edward on 16-5-13.
 */
public class BraveKnightTest {

    @Test
    public void test(){
        Quest mockQuest = mock(Quest.class);

        BraveKnight knight =  new BraveKnight(mockQuest);
        knight.enbarkOnQuest();

        knight.enbarkOnQuest();

        Mockito.verify(mockQuest, times(2)).embark();
    }


}
