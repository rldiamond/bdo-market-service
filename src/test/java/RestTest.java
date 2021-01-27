import org.junit.jupiter.api.Test;
import twich.bdo.market.api.data.BdoItem;
import twich.bdo.market.data.accessors.MarketDAO;

public class RestTest {

    @Test
    public void test() {

        BdoItem item = MarketDAO.getInstance().getItemById(721003);
        System.out.println(item);

    }
}
