package in.knaps.mf.v1;

import in.knaps.mf.v1.scheme.FolioSummary;
import in.knaps.mf.v1.scheme.SchemeReturn;
import in.knaps.mf.v1.scheme.FolioSchemeRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
    List<FolioSystematicDetails> getClientSystematicList(@PathParam("clientId") String clientId);

    @Path("folio/{folioNumber}/scheme/{schemeCode}/transactions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    FolioTransactionDetails getFolioTransactionDetails(@PathParam("clientId") String clientId, @PathParam("folioNumber") String folioNumber, @PathParam("schemeCode") String schemeCode);
}
