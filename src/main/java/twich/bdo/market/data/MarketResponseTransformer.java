package twich.bdo.market.data;

import twich.bdo.market.data.objects.MarketResponse;
import twich.bdo.market.api.data.BdoItem;
import twich.bdo.market.api.data.MarketData;

public class MarketResponseTransformer {

    public static BdoItem transform(MarketResponse marketResponse) {
        if (marketResponse == null) {
            return null;
        }
        BdoItem bdoItem = new BdoItem();

        bdoItem.setId(marketResponse.getMainKey());
        bdoItem.setName(marketResponse.getName());
        MarketData marketData = new MarketData();
        marketData.setCost(marketResponse.getPricePerOne());
        marketData.setQuantityAvailable(marketResponse.getCount());
        bdoItem.setMarketData(marketData);

        return bdoItem;
    }
}
