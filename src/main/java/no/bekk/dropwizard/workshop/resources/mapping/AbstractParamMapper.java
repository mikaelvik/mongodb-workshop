package no.bekk.dropwizard.workshop.resources.mapping;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 */
public abstract class AbstractParamMapper<T> {

    protected T object;
    private final String originalParam;


    protected AbstractParamMapper(String originalParam) {
        this.originalParam = originalParam;
        parse(originalParam);
    }

    public abstract void parse(String param);

    public T get() {
        return object;
    }

}
