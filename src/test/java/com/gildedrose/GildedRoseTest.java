package com.gildedrose;

import org.junit.jupiter.api.*;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("FIXME", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.nextDay();
    assertEquals("FIXME", element.name, "the name changed");
  }

  @Test
  @DisplayName("Test Aged Brie")
  void testAgedBrie(){
    Item agedBrie = new Item(Item.AGED_BRIE, 0, 80);
    GildedRose app = new GildedRose(new Item[] {agedBrie});

    app.nextDay();
    assertEquals(-1, agedBrie.sellIn, "agedBrie.sellIn < 6 and quality > 50");
    assertEquals(50, agedBrie.quality, "agedBrie.sellIn < 6 and quality > 50");

    app.items[0] = new Item(Item.AGED_BRIE, -1, 40);
    app.nextDay();
    assertEquals(-2, app.items[0].sellIn, "agedBrie.sellIn < 0 et quality < 50");
    assertEquals(42, app.items[0].quality, "agedBrie.sellIn < 0 et quality < 50");

    app.items[0] = new Item(Item.AGED_BRIE, 2, 40);
    app.nextDay();
    assertEquals(1, app.items[0].sellIn, "agedBrie.sellIn > 0 et quality < 50");
    assertEquals(41, app.items[0].quality, "agedBrie.sellIn > 0 et quality < 50");

    app.items[0] = new Item(Item.AGED_BRIE, -1, 49);
    app.nextDay();
    assertEquals(-2, app.items[0].sellIn, "agedBrie.sellIn < 0 et quality = 49");
    assertEquals(50, app.items[0].quality, "agedBrie.sellIn < 0 et quality = 49");
  }

  @Test
  @DisplayName("Test Sulfura, Hand of Ragnaros")
  void testSulfura(){
    Item sulfura = new Item(Item.SULFURA, 0, 80);
    GildedRose app = new GildedRose(new Item[] {sulfura});

    app.nextDay();
    assertEquals(0, sulfura.sellIn, "Sulfura.sellIn < 6 and quality > 50");
    assertEquals(80, sulfura.quality, "Sulfura.sellIn < 6 and quality > 50");

    app.items[0] = new Item(Item.SULFURA, -1, 20);
    app.nextDay();
    assertEquals(-1, app.items[0].sellIn, "Sulfura.sellIn < 0 and quality > 0");
    assertEquals(80, app.items[0].quality, "Sulfura.sellIn < 0 and quality > 0");

    app.items[0] = new Item(Item.SULFURA, -1, -12);
    app.nextDay();
    assertEquals(-1, app.items[0].sellIn, "Sulfura.sellIn < 0 and quality < 0");
    assertEquals(80, app.items[0].quality, "Sulfura.sellIn < 0 and quality < 0");

  }

  @Test
  @DisplayName("Test Backstage passes to a TAFKAL80ETC concert")
  void testBackStage(){
    Item backstage = new Item(Item.BACKSTAGE, 0, 80);
    GildedRose app = new GildedRose(new Item[] {backstage});

    app.nextDay();
    assertEquals(-1, backstage.sellIn, "backstage.sellIn < 0 and quality > 50");
    assertEquals(0, backstage.quality, "backstage.sellIn < 0 and quality > 50");

    app.items[0] = new Item(Item.BACKSTAGE, 9, 40);
    app.nextDay();
    assertEquals(8, app.items[0].sellIn, "backstage.sellIn < 11 et quality < 50");
    assertEquals(42, app.items[0].quality, "backstage.sellIn < 11 et quality < 50");

    app.items[0] = new Item(Item.BACKSTAGE, 4, 40);
    app.nextDay();
    assertEquals(3, app.items[0].sellIn, "backstage.sellIn < 6 et quality < 50");
    assertEquals(43, app.items[0].quality, "backstage.sellIn < 6 et quality < 50");

    app.items[0] = new Item(Item.BACKSTAGE, 4, 49);
    app.nextDay();
    assertEquals(3, app.items[0].sellIn, "backstage.sellIn < 6 et quality = 49");
    assertEquals(50, app.items[0].quality, "backstage.sellIn < 6 et quality = 49");

    app.items[0] = new Item(Item.BACKSTAGE, 11, 40);
    app.nextDay();
    assertEquals(10, app.items[0].sellIn, "for backstage.sellIn >= 11 et quality < 50");
    assertEquals(41, app.items[0].quality, "for backstage.sellIn >= 11 et quality < 50");
  }

  @Test
  @DisplayName("Test randomAlcool")
  void testRandomAlcool(){
    Item randomAlcool = new Item("randomAlcool", 0, 80);
    GildedRose app = new GildedRose(new Item[] {randomAlcool});

    app.nextDay();
    assertEquals(-1, randomAlcool.sellIn, "randomAlcool.sellIn < 6 and quality > 50");
    assertEquals(48, randomAlcool.quality, "randomAlcool.sellIn < 6 and quality > 50");

    app.items[0] = new Item("randomAlcool", 2, 0);
    app.nextDay();
    assertEquals(1, app.items[0].sellIn, "randomAlcool.sellIn < 6 and quality < 0");
    assertEquals(0, app.items[0].quality, "randomAlcool.sellIn < 6 and quality < 0");

    app.items[0] = new Item("randomAlcool", 0, -2);
    app.nextDay();
    assertEquals(-1, app.items[0].sellIn, "randomAlcool.sellIn < 0 and quality < 0");
    assertEquals(0, app.items[0].quality, "randomAlcool.sellIn < 0 and quality < 0");

  }

}
