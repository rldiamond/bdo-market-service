package twich.bdo.market.data.accessors;

import twich.bdo.market.api.data.BdoItem;
import twich.bdo.market.api.data.MarketData;
import twich.bdo.market.api.rest.RestClient;
import twich.bdo.market.data.objects.PAMarketRequest;
import twich.bdo.market.data.objects.PAMarketResponse;
import twich.bdo.market.data.objects.PAMarketResponseTransformer;
import twich.bdo.market.data.objects.WorldMarketSubList;

public class PAMarketDAO {

    private static PAMarketDAO SINGLETON;

    public static PAMarketDAO getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new PAMarketDAO();
        }
        return SINGLETON;
    }

    private static final String BASE_URL = "https://marketweb-na.blackdesertonline.com/Trademarket/";

    private RestClient myRestClient;

    private PAMarketDAO() {
        myRestClient = RestClient.build(BASE_URL);
    }

    private PAMarketResponse getBiddingInfoList(long itemId){
        // build request object
        PAMarketRequest request = new PAMarketRequest();
        request.setMainKey(itemId);
        return myRestClient.post("GetBiddingInfoList", PAMarketResponse.class, request);
    }

    private WorldMarketSubList getWorldMarketSubList(long itemId) {
        PAMarketRequest request = new PAMarketRequest();
        request.setMainKey(itemId);
        return PAMarketResponseTransformer.transformWorldMarketSubListResponse(myRestClient.post("GetWorldMarketSubList", PAMarketResponse.class, request));
    }

    public BdoItem getItemById(long itemId) {
        WorldMarketSubList worldMarketSubList = getWorldMarketSubList(itemId);
        BdoItem bdoItem = new BdoItem();
        bdoItem.setId(worldMarketSubList.getItemId());
        MarketData marketData = new MarketData();
        marketData.setCost(worldMarketSubList.getBasePrice());
        marketData.setQuantityAvailable(worldMarketSubList.getCurrentStock());
        bdoItem.setMarketData(marketData);
        return bdoItem;
    }


}
