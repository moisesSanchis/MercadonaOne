package com.mercadona.shopone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MercadonaShopOneTest {

    @Test
    void itemGenericNotExpired() {
        Item[] items = new Item[] { new Item("generic", 3, 6) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("generic", app.itemActual[0].name);
        assertEquals(2, app.itemActual[0].sellIn);
        assertEquals(5, app.itemActual[0].quality);
    }
    @Test
    void itemGenericExpired() {
        Item[] items = new Item[] { new Item("expired", 0, 20) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("expired", app.itemActual[0].name);
        assertEquals(-1, app.itemActual[0].sellIn);
        assertEquals(18, app.itemActual[0].quality);
    }
    @Test
    void itemCheeseNotExpired() {
        Item[] items = new Item[]{new Item("Aged blue cheese", 2, 0)};
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Aged blue cheese", app.itemActual[0].name);
        assertEquals(1, app.itemActual[0].sellIn);
        assertEquals(1, app.itemActual[0].quality);
    }

    @Test
    void itemCheeseExpired() {
        Item[] items = new Item[] { new Item("Aged blue cheese", 0, 2) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Aged blue cheese", app.itemActual[0].name);
        assertEquals(-1, app.itemActual[0].sellIn);
        assertEquals(4, app.itemActual[0].quality);
    }
    @Test
    void itemSaltNotExpired() {
        Item[] items = new Item[]{new Item("Iodized salt", 0, 80)};
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Iodized salt", app.itemActual[0].name);
        assertEquals(0, app.itemActual[0].sellIn);
        assertEquals(80, app.itemActual[0].quality);
    }

    @Test
    void itemHamNotExpiredMinus5days() {
        Item[] items = new Item[] { new Item("Ham", 5, 49) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Ham", app.itemActual[0].name);
        assertEquals(4, app.itemActual[0].sellIn);
        assertEquals(50, app.itemActual[0].quality);
    }
    @Test
    void itemHamNotExpiredMinus10days() {
        Item[] items = new Item[] { new Item("Ham", 9, 45) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Ham", app.itemActual[0].name);
        assertEquals(8, app.itemActual[0].sellIn);
        assertEquals(47, app.itemActual[0].quality);
    }

    @Test
    void itemHamExpired() {
        Item[] items = new Item[] { new Item("Ham", 0, 20) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Ham", app.itemActual[0].name);
        assertEquals(-1, app.itemActual[0].sellIn);
        assertEquals(0, app.itemActual[0].quality);
    }
    @Test
    void itemQualityNeverNegative() {
        Item[] items = new Item[] { new Item("generic", 0, 1) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("generic", app.itemActual[0].name);
        assertEquals(-1, app.itemActual[0].sellIn);
        assertEquals(0, app.itemActual[0].quality);
    }
    @Test
    void itemQualityNeverplus50() {
        Item[] items = new Item[] { new Item("Ham", 20, 50) };
        MercadonaShopOne app = new MercadonaShopOne(items);
        app.updateQuality();
        assertEquals("Ham", app.itemActual[0].name);
        assertEquals(19, app.itemActual[0].sellIn);
        assertEquals(50, app.itemActual[0].quality);
    }

}
