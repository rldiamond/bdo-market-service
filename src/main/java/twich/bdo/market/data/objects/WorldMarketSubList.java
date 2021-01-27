package twich.bdo.market.data.objects;

public class WorldMarketSubList {

    private long itemId;
    private long minEnhancementRange;
    private long maxEnhancementRange;
    private double basePrice;
    private int currentStock;
    private int totalTrades;
    private double priceHardCapMin;
    private double priceHardCapMax;
    private double lastSalePrice;
    private long lastSaleTime;

    public WorldMarketSubList() {
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getMinEnhancementRange() {
        return minEnhancementRange;
    }

    public void setMinEnhancementRange(long minEnhancementRange) {
        this.minEnhancementRange = minEnhancementRange;
    }

    public long getMaxEnhancementRange() {
        return maxEnhancementRange;
    }

    public void setMaxEnhancementRange(long maxEnhancementRange) {
        this.maxEnhancementRange = maxEnhancementRange;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getTotalTrades() {
        return totalTrades;
    }

    public void setTotalTrades(int totalTrades) {
        this.totalTrades = totalTrades;
    }

    public double getPriceHardCapMin() {
        return priceHardCapMin;
    }

    public void setPriceHardCapMin(double priceHardCapMin) {
        this.priceHardCapMin = priceHardCapMin;
    }

    public double getPriceHardCapMax() {
        return priceHardCapMax;
    }

    public void setPriceHardCapMax(double priceHardCapMax) {
        this.priceHardCapMax = priceHardCapMax;
    }

    public double getLastSalePrice() {
        return lastSalePrice;
    }

    public void setLastSalePrice(double lastSalePrice) {
        this.lastSalePrice = lastSalePrice;
    }

    public long getLastSaleTime() {
        return lastSaleTime;
    }

    public void setLastSaleTime(long lastSaleTime) {
        this.lastSaleTime = lastSaleTime;
    }

    @Override
    public String toString() {
        return "WorldMarketSubList{" +
                "itemId=" + itemId +
                ", minEnhancementRange=" + minEnhancementRange +
                ", maxEnhancementRange=" + maxEnhancementRange +
                ", basePrice=" + basePrice +
                ", currentStock=" + currentStock +
                ", totalTrades=" + totalTrades +
                ", priceHardCapMin=" + priceHardCapMin +
                ", priceHardCapMax=" + priceHardCapMax +
                ", lastSalePrice=" + lastSalePrice +
                ", lastSaleTime=" + lastSaleTime +
                '}';
    }
}
