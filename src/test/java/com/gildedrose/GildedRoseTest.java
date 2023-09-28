package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("FIXME", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQualityAllItems();
    //UN JOUR EST PASSé !
    assertEquals("FIXME", element.name, "the name changed");
  }

  @Test
  @DisplayName("Test Aged Brie")
  void testAgedBrie(){
    Item agedBrie = new Item("Aged Brie", 0, 80);
    GildedRose app = new GildedRose(new Item[] {agedBrie});

    //for agedBrie.sellIn < 6 and quality > 50
    app.updateQualityAllItems();
    assertEquals(-1, agedBrie.sellIn, "agedBrie.sellIn < 6 and quality > 50");
    assertEquals(80, agedBrie.quality, "agedBrie.sellIn < 6 and quality > 50");

    //for agedBrie.sellIn < 0 et quality < 50
    app.items[0] = new Item("Aged Brie", -1, 40);
    app.updateQualityAllItems();
    assertEquals(-2, app.items[0].sellIn, "agedBrie.sellIn < 0 et quality < 50");
    assertEquals(42, app.items[0].quality, "agedBrie.sellIn < 0 et quality < 50");

    //for agedBrie.sellIn > 0 et quality < 50
    app.items[0] = new Item("Aged Brie", 2, 40);
    app.updateQualityAllItems();
    assertEquals(1, app.items[0].sellIn, "agedBrie.sellIn > 0 et quality < 50");
    assertEquals(41, app.items[0].quality, "agedBrie.sellIn > 0 et quality < 50");

    //for agedBrie.sellIn < 0 et quality = 49
    app.items[0] = new Item("Aged Brie", -1, 49);
    app.updateQualityAllItems();
    assertEquals(-2, app.items[0].sellIn, "agedBrie.sellIn < 0 et quality = 49");
    assertEquals(50, app.items[0].quality, "agedBrie.sellIn < 0 et quality = 49");
  }

  @Test
  @DisplayName("Test Sulfura, Hand of Ragnaros")
  void testSulfura(){
    Item sulfura = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    GildedRose app = new GildedRose(new Item[] {sulfura});

    //for Sulfura.sellIn < 6 and quality > 50
    app.updateQualityAllItems();
    assertEquals(0, sulfura.sellIn, "Sulfura.sellIn < 6 and quality > 50");
    assertEquals(80, sulfura.quality, "Sulfura.sellIn < 6 and quality > 50");

    //for Sulfura.sellIn < 0 and quality > 0
    app.items[0] = new Item("Sulfuras, Hand of Ragnaros", -1, 20);
    app.updateQualityAllItems();
    assertEquals(-1, app.items[0].sellIn, "Sulfura.sellIn < 0 and quality > 0");
    assertEquals(20, app.items[0].quality, "Sulfura.sellIn < 0 and quality > 0");

    //for Sulfura.sellIn < 0 and quality < 0
    app.items[0] = new Item("Sulfuras, Hand of Ragnaros", -1, -12);
    app.updateQualityAllItems();
    assertEquals(-1, app.items[0].sellIn, "Sulfura.sellIn < 0 and quality < 0");
    assertEquals(-12, app.items[0].quality, "Sulfura.sellIn < 0 and quality < 0");

  }

  @Test
  @DisplayName("Test Backstage passes to a TAFKAL80ETC concert")
  void testBackStage(){
    Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 80);
    GildedRose app = new GildedRose(new Item[] {backstage});

    //for backstage.sellIn < 0 and quality > 50
    app.updateQualityAllItems();
    assertEquals(-1, backstage.sellIn, "backstage.sellIn < 0 and quality > 50");
    assertEquals(0, backstage.quality, "backstage.sellIn < 0 and quality > 50");

    //for backstage.sellIn < 11 et quality < 50
    app.items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 40);
    app.updateQualityAllItems();
    assertEquals(8, app.items[0].sellIn, "backstage.sellIn < 11 et quality < 50");
    assertEquals(42, app.items[0].quality, "backstage.sellIn < 11 et quality < 50");

    //for backstage.sellIn < 6 et quality < 50
    app.items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 40);
    app.updateQualityAllItems();
    assertEquals(3, app.items[0].sellIn, "backstage.sellIn < 6 et quality < 50");
    assertEquals(43, app.items[0].quality, "backstage.sellIn < 6 et quality < 50");

    //for backstage.sellIn < 6 et quality = 49
    app.items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49);
    app.updateQualityAllItems();
    assertEquals(3, app.items[0].sellIn, "backstage.sellIn < 6 et quality = 49");
    assertEquals(50, app.items[0].quality, "backstage.sellIn < 6 et quality = 49");

    //for backstage.sellIn >= 11 et quality < 50
    app.items[0] = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40);
    app.updateQualityAllItems();
    assertEquals(10, app.items[0].sellIn, "for backstage.sellIn >= 11 et quality < 50");
    assertEquals(41, app.items[0].quality, "for backstage.sellIn >= 11 et quality < 50");
  }

  @Test
  @DisplayName("Test randomAlcool")
  void testRandomAlcool(){
    Item randomAlcool = new Item("randomAlcool", 0, 80);
    GildedRose app = new GildedRose(new Item[] {randomAlcool});

    //for randomAlcool.sellIn < 0 and quality > 50
    app.updateQualityAllItems();
    assertEquals(-1, randomAlcool.sellIn, "randomAlcool.sellIn < 6 and quality > 50");
    assertEquals(78, randomAlcool.quality, "randomAlcool.sellIn < 6 and quality > 50");

    //for randomAlcool.sellIn < 6 and quality < 50
    app.items[0] = new Item("randomAlcool", 2, 0);
    app.updateQualityAllItems();
    assertEquals(1, app.items[0].sellIn, "randomAlcool.sellIn < 6 and quality < 0");
    assertEquals(0, app.items[0].quality, "randomAlcool.sellIn < 6 and quality < 0");

    app.items[0] = new Item("randomAlcool", 0, -2);
    app.updateQualityAllItems();
    assertEquals(-1, app.items[0].sellIn, "randomAlcool.sellIn < 0 and quality < 0");
    assertEquals(-2, app.items[0].quality, "randomAlcool.sellIn < 0 and quality < 0");

  }

}
