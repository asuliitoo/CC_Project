package cc.project.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import cc.project.dao.Query;
import cc.project.entities.User;
import cc.project.utils.AbstractResource;

/**
 *
 * @author saulopez
 * @date 28th December, 2018
 */
@Path("rest")
public class REST extends AbstractResource {
    
    Response response;
    
    
    public REST() {
        super();
    }
            
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response init() {    
        return buildResponse("Services Running", Status.OK);
    }
    
    @GET
    @Path("/user/{name}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response get(@PathParam("name") String name) {
        User user = Query.findUserByName(name);
        
        if (user == null) {
            response = buildResponse("User not found", Status.BAD_REQUEST);
        } else {
            response = buildResponse(user, Status.OK);
        }
                
        return response;
    }
    
}
