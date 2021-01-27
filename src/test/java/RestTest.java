import org.junit.jupiter.api.Test;
import twich.bdo.market.api.data.BdoItem;
import twich.bdo.market.data.accessors.PAMarketDAO;

public class RestTest {


    @Test
    public void testPA() {
        BdoItem item = PAMarketDAO.getInstance().getItemById(721003);
        System.out.println(item);
    }
}
