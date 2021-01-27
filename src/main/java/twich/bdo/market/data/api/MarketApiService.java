package twich.bdo.market.data.api;

import twich.bdo.market.common.Service;
import twich.bdo.market.common.ServiceInitializationException;
import twich.bdo.market.common.ServiceShutdownException;
import twich.bdo.market.data.accessors.MarketDAO;
import twich.bdo.market.api.data.BdoItem;
import twich.bdo.market.api.MarketApi;

import java.util.Optional;

public class MarketApiService implements Service, MarketApi {

    private MarketDAO myMarketDao;

    public MarketApiService() {

    }

    /**
     * {@inheritDoc}
     */
    public void initialize() throws ServiceInitializationException {
        // initialize the market DAO
        myMarketDao = MarketDAO.getInstance();

    }

    /**
     * {@inheritDoc}
     */
    public void shutdown() throws ServiceShutdownException {
        // destroy the market DAO
        myMarketDao = null;

    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<BdoItem> getItemByName(String itemName) {
        return Optional.ofNullable(myMarketDao.getItemByName(itemName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<BdoItem> getItemById(long id) {
        return Optional.ofNullable(myMarketDao.getItemById(id));
    }
}
