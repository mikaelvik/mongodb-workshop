package no.bekk.dropwizard.workshop.resources;

import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 */
public class BasicJongoResource {

    protected static final String FIELDS_SKIP_ID = "{_id: 0}";
    protected final MongoClient mongoClient;

    public BasicJongoResource(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    protected MongoCollection collection(String dbname, String collectionName) {
        return getDB(dbname).getCollection(collectionName);
    }

    protected Jongo getDB(String dbname) {
        return new Jongo(mongoClient.getDB(dbname));
    }

}
