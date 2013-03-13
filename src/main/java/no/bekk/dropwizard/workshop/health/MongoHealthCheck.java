package no.bekk.dropwizard.workshop.health;

import java.util.List;

import com.mongodb.MongoClient;
import com.yammer.metrics.core.HealthCheck;

import static java.lang.String.format;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 */
public class MongoHealthCheck extends HealthCheck {

    private final MongoClient mongoClient;

    public MongoHealthCheck(MongoClient mongoClient) {
        super("mongoConnection");
        this.mongoClient = mongoClient;
    }

    @Override protected Result check() throws Exception {
        List<String> databaseNames = mongoClient.getDatabaseNames();
        if (databaseNames.isEmpty()) {
            return Result.unhealthy("Could not get database names");
        }
        if (!databaseNames.contains("artists")) {
            return Result.unhealthy("Could not find database 'artists'");
        }
        return Result.healthy();
    }

}
