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
        // DW #1
        // di kode her
        // collection("workshop", "dudes")...
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response dudeInsert(@Valid Dude dude) {
        // DW #2
        System.out.println("dude = " + dude);

        // di kode her

        return Response.created(
                UriBuilder.fromResource(DudesResource.class)
                        .build( /* di kode kanskje også her? */ )
        ).build();
    }

    @GET
    @Path("/filter")
    public Iterable<Dude> dudeQuery(@QueryParam("q") String query) {
        // DW #3

        System.out.println("query = " + query);
        return collection("workshop", "dudes")
                .find( /* di kode her */ )
                .as(Dude.class);
    }

}
