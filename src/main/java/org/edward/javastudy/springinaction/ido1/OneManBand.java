package org.edward.javastudy.springinaction.ido1;

import java.util.Collection;

/**
 * Created by edward on 16-5-16.
 */
public class OneManBand implements Performer {
    private Collection<Instrument> instrumentCollection;


    @Override
    public void perform() throws PerformanceException {
        for(Instrument instrument : instrumentCollection) {
            instrument.play();
        }

    }

    public void setInstrumentCollection(Collection<Instrument> instrumentCollection) {
        this.instrumentCollection = instrumentCollection;
    }
}
