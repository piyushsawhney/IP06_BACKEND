package in.knaps.api.client.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/client/api/v1/")
public interface ClientApiV1 {

    @Path("clientlist")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ClientBasicInfo> getClientList() throws SQLException;

    @Path("client/{clientId}/details")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    ClientDetailedInfo getClientDetails(@PathParam("clientId") String clientId);

    @Path("client/{clientId}/familydetails")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ClientDetailedInfo> getClientFamilyMemberDetails(@PathParam("clientId") String clientId);
}
