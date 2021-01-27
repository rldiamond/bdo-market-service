package twich.bdo.market.data.accessors;

import twich.bdo.market.data.MarketResponseTransformer;
import twich.bdo.market.data.objects.MarketResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twich.bdo.market.api.data.BdoItem;
import twich.bdo.market.api.rest.RestClient;

import java.util.concurrent.TimeUnit;

public class MarketDAO extends BaseDAO {

    private static MarketDAO SINGLETON;

    /**
     * @return the Singleton instance of the Market DAO.
     */
    public static MarketDAO getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new MarketDAO();
        }
        return SINGLETON;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MarketDAO.class);
    private static final String BASE_URL = "https://omegapepega.com/na/";
    private final RestClient restClient;


    private MarketDAO() {
        restClient = RestClient.build(BASE_URL);
    }

    private MarketResponse fetchDataById(long id) {
        LOGGER.info("Fetching data for Item with ID: " + id);
        final int retries = 3;
        MarketResponse response = null;
        int attempt = 0;
        while (response == null) {
            try {
                response = restClient.get(String.valueOf(id) + "/0", MarketResponse.class);
            } catch (Exception ex) {
                LOGGER.error("Error received", ex);
                attempt++;
                LOGGER.warn("Could not fetch data for: " + id + ". Attempt " + attempt + "/" + retries);
                if (attempt == retries) {
                    LOGGER.error("Failed to retrieve data for: " + id + " after retrying several times!");
                    response = new MarketResponse();
                } else {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        LOGGER.error("Interrupted!", e);
                        break;
                    }
                }
            }
        }
        return response;
    }

    private MarketResponse fetchDataByName(String name) {
        String searchTerm = name.trim().replace(" ", "%20");
        MarketResponse response = null;
        try {
            LOGGER.info("Searching market API for: " + name);
            response = restClient.get(searchTerm + "/0", MarketResponse.class);
        } catch (Exception ex) {
            LOGGER.warn("Failed to find data in market API for: " + name);
        }
        if (response != null && response.getName().equalsIgnoreCase(name)) {
            LOGGER.info("Found item: " + name);
        }
        return response;
    }

    public BdoItem getItemByName(String name) {
        MarketResponse response = fetchDataByName(name);
        return MarketResponseTransformer.transform(response);
    }

    public BdoItem getItemById(long id) {
        MarketResponse response = fetchDataById(id);
        return MarketResponseTransformer.transform(response);
    }
}
