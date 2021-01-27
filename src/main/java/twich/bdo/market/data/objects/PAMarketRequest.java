package twich.bdo.market.data.objects;

public class PAMarketRequest {

    private long keyType;
    private long mainKey;
    private long subKey;

    public PAMarketRequest() {
    }

    public long getKeyType() {
        return keyType;
    }

    public void setKeyType(long keyType) {
        this.keyType = keyType;
    }

    public long getMainKey() {
        return mainKey;
    }

    public void setMainKey(long mainKey) {
        this.mainKey = mainKey;
    }

    public long getSubKey() {
        return subKey;
    }

    public void setSubKey(long subKey) {
        this.subKey = subKey;
    }
}
