package com.mercadona.shopone;

public class MercadonaShopOne {
    Item[] itemActual;
    boolean isFrozen, isCheese,isHam, isSalt;

    public MercadonaShopOne(Item[] items) {
        this.itemActual = items;
    }

    public void updateQuality() {
        for (Item item: itemActual) {
            isFrozen = item.name.contains("Frozen");
            isCheese = item.name.equals("Aged blue cheese");
            isHam = item.name.equals("Ham");
            isSalt = item.name.equals("Iodized salt");

            if (isFrozen){
                item.sellIn -= 1;
                if (item.sellIn<=0){
                    item.quality = 0;
                }else{
                    upgradeQuality(2, item);
                }

            }

            if (!isCheese && !isHam) {
                if (item.quality > 0) {
                    if (!isSalt) {
                        downgradeQuality(1, item);
                    }
                }
            } else {
                if (item.quality < 50) {
                    upgradeQuality(1, item);


                    if (isHam) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                upgradeQuality(1, item);

                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                upgradeQuality(1, item);

                            }
                        }
                    }
                }
            }

            if (!isSalt) {
                item.sellIn -= 1;
            }

            if (item.sellIn < 0) {
                if (!isCheese) {
                    if (!isHam) {
                        if (item.quality > 0) {
                            if (!isSalt) {
                                downgradeQuality(1, item);

                            }
                        }
                    } else {
                        downgradeQuality(item.quality,item);

                    }
                } else {
                    if (item.quality < 50) {
                        upgradeQuality(1, item);

                    }
                }
            }
        }
    }
public void upgradeQuality(int upgrade, Item item){
        item.quality += upgrade;

}
public void downgradeQuality(int downgrade, Item item){
    item.quality-=downgrade;
}

}