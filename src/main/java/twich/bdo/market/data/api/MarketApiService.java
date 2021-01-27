package twich.bdo.market.data.api;

import twich.bdo.market.api.MarketApi;
import twich.bdo.market.api.data.BdoItem;
import twich.bdo.market.common.Service;
import twich.bdo.market.common.ServiceInitializationException;
import twich.bdo.market.common.ServiceShutdownException;
import twich.bdo.market.data.accessors.PAMarketDAO;

import java.util.Optional;

public class MarketApiService implements Service, MarketApi {

    private PAMarketDAO myMarketDao;

    public MarketApiService() {

    }

    /**
     * {@inheritDoc}
     */
    public void initialize() throws ServiceInitializationException {
        // initialize the market DAO
        myMarketDao = PAMarketDAO.getInstance();

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
    public Optional<BdoItem> getItemById(long id) {
        return Optional.ofNullable(myMarketDao.getItemById(id));
    }
}
