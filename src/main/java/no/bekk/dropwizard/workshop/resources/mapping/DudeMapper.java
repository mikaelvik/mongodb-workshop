package no.bekk.dropwizard.workshop.resources.mapping;

import no.bekk.dropwizard.workshop.core.Dude;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 */
public class DudeMapper extends AbstractParamMapper<Dude> {

    protected DudeMapper(String originalParam) {
        super(originalParam);
    }

    @Override public void parse(String param) {
        object = new Dude();
        object.setName(param);
    }

}
