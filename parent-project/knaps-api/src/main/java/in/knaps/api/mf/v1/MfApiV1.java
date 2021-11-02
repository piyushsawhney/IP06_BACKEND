package in.knaps.api.mf.v1;

import in.knaps.api.mf.v1.scheme.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/mf/api/v1/client/{clientId}/")
public interface MfApiV1 {

    @Path("folios")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<FolioSummary> getClientFolios(@PathParam("clientId") String clientId);

    @Path("folio/scheme/return")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SchemeReturn getClientSchemeReturn(@PathParam("clientId") String clientId, FolioSchemeRequest schemeReturnRequest);

    @Path("folio/scheme/summary")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Map<String,SchemeSummary> getClientSchemeSummary(@PathParam("clientId") String clientId, FolioSchemeRequest folioSchemeRequest);


    @Path("folio/scheme/details")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    SchemeDetails getSchemeDetails(@PathParam("clientId") String clientId, FolioSchemeRequest folioSchemeRequest);

    @Path("systematiclist")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<FolioSystematicDetails> getClientSystematicList(@PathParam("clientId") String clientId);

    @Path("folio/scheme/transactions")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<SchemeTransaction> getFolioTransactionDetails(@PathParam("clientId") String clientId, FolioSchemeRequest folioSchemeRequest);
}
