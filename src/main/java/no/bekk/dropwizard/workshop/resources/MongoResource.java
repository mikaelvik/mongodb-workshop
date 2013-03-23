package no.bekk.dropwizard.workshop.resources;

import java.util.Collection;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.yammer.metrics.annotation.Timed;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 */
@Path("/mongo")
@Produces(MediaType.APPLICATION_JSON)
public class MongoResource {

    private final MongoClient mongoClient;

    public MongoResource(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @GET
    @Timed
    @Path("/list")
    public Collection<String> listDatabases() {
        return mongoClient.getDatabaseNames();
    }

    @GET
    @Timed
    @Path("/{dbname}/list")
    public Collection<String> listCollections(@PathParam("dbname") String db) {
        return mongoClient.getDB(db).getCollectionNames();
    }

    @GET
    @Path("/content/{dbname}/{collection}")
    public List<DBObject> collectionContent(@PathParam("dbname") String db, @PathParam("collection") String coll) {
        DBCollection col = mongoClient.getDB(db).getCollection(coll);
        return col.find().toArray();
    }

    @GET
    @Path("/search/{dbname}/{collection}")
    public List<DBObject> collectionQuery(@PathParam("dbname") String db,
                                          @PathParam("collection") String coll,
                                          @QueryParam("name") String name) {
        DBCollection col = mongoClient.getDB(db).getCollection(coll);
        BasicDBObject search = new BasicDBObject();
        search.put("name", name);
        return col.find(search).toArray();
    }

}
