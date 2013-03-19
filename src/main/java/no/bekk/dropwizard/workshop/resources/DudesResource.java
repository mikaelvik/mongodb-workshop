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
        return collection("workshop", "dudes").find().limit(100).as(Dude.class);
    }

    @GET
    public Iterable<Dude> dudeQuery(@QueryParam("name") String name) {
        return collection("workshop", "dudes")
                .find( /* di kode her */ )
                .as(Dude.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response dudeInsert(@Valid Dude dude) {
        System.out.println("dude = " + dude);

        // di kode her

        return Response.created(
                UriBuilder.fromResource(DudesResource.class)
                        .build( /* di kode kanskje også her? */ )
        ).build();
    }

}
