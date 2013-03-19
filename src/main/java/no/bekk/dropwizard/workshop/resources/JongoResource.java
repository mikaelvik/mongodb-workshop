package no.bekk.dropwizard.workshop.resources;

import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mongodb.MongoClient;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 */
@Path("/jongo")
@Produces(MediaType.APPLICATION_JSON)
public class JongoResource extends BasicJongoResource {

    public JongoResource(MongoClient mongoClient) {
        super(mongoClient);
    }

    @GET
    @Path("/{dbname}/{collection}")
    public Iterable<Map> collectionContent(@PathParam("dbname") String db, @PathParam("collection") String coll) {
        return collection(db, coll).find().fields(FIELDS_SKIP_ID).as(Map.class);
    }

    @GET
    @Path("/{dbname}/{collection}/ready")
    public boolean collectionReady(@PathParam("dbname") String db, @PathParam("collection") String coll) {
        return collection(db, coll).count() > 0;
    }

    @GET
    @Path("/{dbname}/{collection}/query")
    public Iterable<Map> collectionQuery(@PathParam("dbname") String db, @PathParam("collection") String coll, @QueryParam("name") String name) {
        return collection(db, coll)
                .find("{name: {$regex: #}}", name)
                .fields(FIELDS_SKIP_ID)
                .as(Map.class);
    }

}
