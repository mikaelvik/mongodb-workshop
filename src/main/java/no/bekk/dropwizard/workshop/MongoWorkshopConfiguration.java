package no.bekk.dropwizard.workshop;

import java.net.UnknownHostException;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.MongoClient;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 */
public class MongoWorkshopConfiguration extends Configuration {

    @NotEmpty
    @JsonProperty
    private String mongoHost;

    @Min(1)
    @JsonProperty
    private int mongoPort;

    public MongoClient getMongoClient() {
        try {
            return new MongoClient(mongoHost, mongoPort);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

}
