package in.knaps.mf.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/mf/api/v1/client/{clientId}/")
public interface MfApiV1 {

    @Path("foliolist")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<FolioSchemeSummary> getClientFolioList(@PathParam("clientId") String clientId);

    @Path("folio/{folioNumber}/details")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    FolioSchemeDetails getFolioDetails(@PathParam("clientId") String clientId, @PathParam("folioNumber") String folioNumber);

    @Path("systematiclist")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ClientSystematicList> getClientSystematicList(@PathParam("clientId") String clientId);

    @Path("folio/{folioNumber}/scheme/{schemeCode}/transactions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    FolioTransactionDetails getFolioTransactionDetails(@PathParam("clientId") String clientId, @PathParam("folioNumber") String folioNumber, @PathParam("schemeCode") String schemeCode);
}
