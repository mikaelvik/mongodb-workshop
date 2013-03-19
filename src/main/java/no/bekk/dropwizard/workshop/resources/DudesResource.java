package no.bekk.dropwizard.workshop.resources;

import no.bekk.dropwizard.workshop.core.Dude;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
    public Dude dudeQuery(@QueryParam("name") String name) {
        return collection("workshop", "dudes")
                .findOne()
                .as(Dude.class);
    }

//    @POST
//    public boolean dudeInsert(@FormParam("dude") DudeMapper dude) {
//        System.out.println("dude = " + dude.get());
//        return true;
//    }

}
