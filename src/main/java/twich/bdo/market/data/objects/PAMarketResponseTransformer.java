package twich.bdo.market.data.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PAMarketResponseTransformer {

    public static WorldMarketSubList transformWorldMarketSubListResponse(PAMarketResponse response) {
        WorldMarketSubList worldMarketSubList = new WorldMarketSubList();
        List<List<String>> data = parseResponseData(response.getResultMsg());
        // this should only have one
        if (!data.isEmpty())
        {
            List<String> ourData = data.get(0);
            worldMarketSubList.setItemId(Long.parseLong(ourData.get(0)));
            worldMarketSubList.setMinEnhancementRange(Long.parseLong(ourData.get(1)));
            worldMarketSubList.setMaxEnhancementRange(Long.parseLong(ourData.get(2)));
            worldMarketSubList.setBasePrice(Double.parseDouble(ourData.get(3)));
            worldMarketSubList.setCurrentStock(Integer.parseInt(ourData.get(4)));
            worldMarketSubList.setTotalTrades(Integer.parseInt(ourData.get(5)));
            worldMarketSubList.setPriceHardCapMin(Double.parseDouble(ourData.get(6)));
            worldMarketSubList.setPriceHardCapMax(Double.parseDouble(ourData.get(7)));
            worldMarketSubList.setLastSalePrice(Double.parseDouble(ourData.get(8)));
            worldMarketSubList.setLastSaleTime(Long.parseLong(ourData.get(9)));
        }
        return worldMarketSubList;
    }

    private static List<List<String>> parseResponseData(String response) {
        List<List<String>> responses = new ArrayList<>();
        String[] sections = response.split("\\|");

        for (String section : sections) {
            List<String> sectionComponents = new ArrayList<>();
            Collections.addAll(sectionComponents, section.split("-"));
            responses.add(sectionComponents);
        }

        return responses;

    }

}
