package twich.bdo.market.rest.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twich.bdo.market.common.ServiceInitializationException;
import twich.bdo.market.data.api.MarketApiService;
import twich.bdo.market.api.data.BdoItem;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/market")
public class MarketRestResource {

    private Logger LOGGER = LoggerFactory.getLogger(MarketRestResource.class);
    private MarketApiService myMarketService;

    public MarketRestResource() {
        myMarketService = new MarketApiService();
        try {
            myMarketService.initialize();
        } catch (ServiceInitializationException ex) {
            LOGGER.error("Failed to start the Market Service!", ex);
        }

    }

    @GET
    @Path("item/name={name}")
    @Produces(MediaType.APPLICATION_JSON)
    public BdoItem getItemByName(@PathParam("name") String name) {
        return myMarketService.getItemByName(name).get();
    }

    @GET
    @Path("item/id={id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BdoItem getItemById(@PathParam("id") long id) {
        return myMarketService.getItemById(id).get();
    }

}
