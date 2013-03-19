package no.bekk.dropwizard.workshop.resources;

import no.bekk.dropwizard.workshop.core.Dude;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

/**
 * @author Mikael Vik (BEKK) - mikael.vik@bekk.no
 */
@Path("/dudes")
@Produces(MediaType.APPLICATION_JSON)
public class DudesResource extends BasicJongoResource {

    public DudesResource(MongoClient mongoClient) {
        super(mongoClient);
    }

    @GET
    @Path("/all")
    public Iterable<Dude> all() {
        // DW #1

        return collection("workshop", "dudes").find().limit(20).as(Dude.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response dudeInsert(@Valid Dude dude) {
        // DW #2
        System.out.println("dude = " + dude);

        WriteResult save = collection("workshop", "dudes").save(dude);

        return Response.created(
                UriBuilder.fromResource(DudesResource.class)
                        .build("id", save.getField("_id"))
        ).build();
    }

    @GET
    @Path("/filter")
    public Iterable<Dude> dudeQuery(@QueryParam("q") String query) {
        // DW #3
        System.out.println("query = " + query);
        return collection("workshop", "dudes")
                .find("{name: {$regex: #}}", query)
                .as(Dude.class);
    }

}
