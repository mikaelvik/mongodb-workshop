package no.bekk.dropwizard.workshop;

import no.bekk.dropwizard.workshop.health.MongoHealthCheck;
import no.bekk.dropwizard.workshop.resources.DudesResource;
import no.bekk.dropwizard.workshop.resources.JongoResource;
import no.bekk.dropwizard.workshop.resources.MongoResource;

import com.mongodb.MongoClient;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 */
public class MongoWorkshopService extends Service<MongoWorkshopConfiguration> {

    public static void main(String[] args) throws Exception {
        new MongoWorkshopService().run(args);
    }

    @Override public void initialize(Bootstrap<MongoWorkshopConfiguration> bootstrap) {
        bootstrap.setName("mongo-workshop");
        bootstrap.addBundle(new AssetsBundle("/assets/", "/"));
    }

    @Override public void run(MongoWorkshopConfiguration configuration, Environment environment) throws Exception {
        final MongoClient mongoClient = configuration.getMongoClient();

        environment.addResource(new MongoResource(mongoClient));
        environment.addResource(new JongoResource(mongoClient));
        environment.addResource(new DudesResource(mongoClient));

        environment.addHealthCheck(new MongoHealthCheck(mongoClient));
    }

}
