package twich.bdo.market.data.objects;

public class PAMarketResponse {

    private int resultCode;
    private String resultMsg;

    public PAMarketResponse() {
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
