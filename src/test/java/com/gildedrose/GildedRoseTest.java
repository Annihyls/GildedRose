package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  //@Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("FIXME", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality(); //UN JOUR EST PASSé !
    assertEquals("FIXME", element.name, "the name changed");
  }

  @Test
  @DisplayName("Test Aged Brie")
  void testAgedBrie(){
    Item agedBrie = new Item("Aged Brie", 0, 80);
    GildedRose app = new GildedRose(new Item[] {agedBrie});

    //for agedBrie.sellIn < 6 and quality > 50
    app.updateQuality();
    assertEquals(-1, agedBrie.sellIn, "agedBrie.sellIn < 6 and quality > 50");
    assertEquals(80, agedBrie.quality, "agedBrie.sellIn < 6 and quality > 50");

    //for agedBrie.sellIn < 0 et quality < 50
    app.items[0] = new Item("Aged Brie", -1, 40);
    app.updateQuality();
    assertEquals(-2, app.items[0].sellIn, "agedBrie.sellIn < 0 et quality < 50");
    assertEquals(42, app.items[0].quality, "agedBrie.sellIn < 0 et quality < 50");
    //CE N EST PAS DU PASSAGE PAR REFERENCE
/*
    //for agedBrie.sellIn < 11 et > 6 and quality > 50
    agedBrie = new Item("Aged Brie", 8, 80);
    app.updateQuality();
    assertEquals(8, agedBrie.sellIn, "agedBrie.sellIn < 11 et > 6 and quality > 50");
    assertEquals(80, agedBrie.quality, "agedBrie.sellIn < 11 et > 6 and quality > 50");

    //for agedBrie.sellIn < 0 and quality > 50
    agedBrie = new Item("Aged Brie", -1, 80);
    app.updateQuality();
    assertEquals(-1, agedBrie.sellIn, "agedBrie.sellIn < 0 and quality > 50");
    assertEquals(80, agedBrie.quality, "agedBrie.sellIn < 0 and quality > 50");

    //for agedBrie.sellIn < 0 et quality < 50
    agedBrie = new Item("Aged Brie", -1, 40);
    app.updateQuality();
    assertEquals(-1, agedBrie.sellIn, "agedBrie.sellIn < 0 et quality < 50");
    assertEquals(40, agedBrie.quality, "agedBrie.sellIn < 0 et quality < 50");

    //for agedBrie.sellIn < 6 et quality < 50
    agedBrie = new Item("Aged Brie", 4, 40);
    app.updateQuality();
    assertEquals(4, agedBrie.sellIn, "agedBrie.sellIn < 6 et quality < 50");
    assertEquals(40, agedBrie.quality, "agedBrie.sellIn < 6 et quality < 50");

    //for agedBrie.sellIn < 11 et quality < 50
    agedBrie = new Item("Aged Brie", 9, 40);
    app.updateQuality();
    assertEquals(9, agedBrie.sellIn, "agedBrie.sellIn < 11 et quality < 50");
    assertEquals(40, agedBrie.quality, "agedBrie.sellIn < 11 et quality < 50");

    //for agedBrie.sellIn > 11 and quality > 50
    agedBrie = new Item("Aged Brie", 14, 56);
    app.updateQuality();
    assertEquals(14, agedBrie.sellIn, "agedBrie.sellIn > 11 and quality > 50");
    assertEquals(56, agedBrie.quality, "agedBrie.sellIn > 11 and quality > 50");

    //for agedBrie.sellIn > 11 and quality < 50
    agedBrie = new Item("Aged Brie", 14, 46);
    app.updateQuality();
    assertEquals(14, agedBrie.sellIn, "agedBrie.sellIn > 11 and quality < 50");
    assertEquals(46, agedBrie.quality, "agedBrie.sellIn > 11 and quality < 50");
 */
  }

  //@Test
  @DisplayName("Test Sulfura, Hand of Ragnaros")
  void testSulfura(){
    Item sulfura = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    GildedRose app = new GildedRose(new Item[] {sulfura});

    //for Sulfura.sellIn < 6 and quality > 50
    app.updateQuality();
    assertEquals(0, sulfura.sellIn, "Sulfura.sellIn < 6 and quality > 50");
    assertEquals(80, sulfura.quality, "Sulfura.sellIn < 6 and quality > 50");
    /*

    //for Sulfura.sellIn < 11 et > 6 and quality > 50
    sulfura = new Item("Sulfuras, Hand of Ragnaros", 8, 80);
    app.updateQuality();
    assertEquals(8, sulfura.sellIn, "Sulfura.sellIn < 11 et > 6 and quality > 50");
    assertEquals(80, sulfura.quality, "Sulfura.sellIn < 11 et > 6 and quality > 50");

    //for Sulfura.sellIn < 0 and quality > 50
    sulfura = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
    app.updateQuality();
    assertEquals(-1, sulfura.sellIn, "Sulfura.sellIn < 0 and quality > 50");
    assertEquals(80, sulfura.quality, "Sulfura.sellIn < 0 and quality > 50");

    //for Sulfura.sellIn < 0 et quality < 50
    sulfura = new Item("Sulfuras, Hand of Ragnaros", -1, 40);
    app.updateQuality();
    assertEquals(-1, sulfura.sellIn, "Sulfura.sellIn < 0 et quality < 50");
    assertEquals(40, sulfura.quality, "Sulfura.sellIn < 0 et quality < 50");

    //for Sulfura.sellIn < 6 et quality < 50
    sulfura = new Item("Sulfuras, Hand of Ragnaros", 4, 40);
    app.updateQuality();
    assertEquals(4, sulfura.sellIn, "Sulfura.sellIn < 6 et quality < 50");
    assertEquals(40, sulfura.quality, "Sulfura.sellIn < 6 et quality < 50");

    //for Sulfura.sellIn < 11 et quality < 50
    sulfura = new Item("Sulfuras, Hand of Ragnaros", 9, 40);
    app.updateQuality();
    assertEquals(9, sulfura.sellIn, "Sulfura.sellIn < 11 et quality < 50");
    assertEquals(40, sulfura.quality, "Sulfura.sellIn < 11 et quality < 50");

    //for Sulfura.sellIn > 11 et quality > 50
    sulfura = new Item("Sulfuras, Hand of Ragnaros", 15, 80);
    app.updateQuality();
    assertEquals(15, sulfura.sellIn, "Sulfura.sellIn > 11 et quality > 50");
    assertEquals(80, sulfura.quality, "Sulfura.sellIn > 11 et quality > 50");

    //for Sulfura.sellIn > 11 et quality < 50
    sulfura = new Item("Sulfuras, Hand of Ragnaros", 15, 40);
    app.updateQuality();
    assertEquals(15, sulfura.sellIn, "Sulfura.sellIn > 11 et quality < 50");
    assertEquals(40, sulfura.quality, "Sulfura.sellIn > 11 et quality < 50");

     */
  }

  //@Test
  @DisplayName("Test Backstage passes to a TAFKAL80ETC concert")
  void testBackStage(){
    Item backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 80);
    GildedRose app = new GildedRose(new Item[] {backstage});

    //for backstage.sellIn < 6 and quality > 50
    app.updateQuality();
    assertEquals(-1, backstage.sellIn, "backstage.sellIn < 6 and quality > 50");
    assertEquals(0, backstage.quality, "backstage.sellIn < 6 and quality > 50");
/*
    //for backstage.sellIn < 11 et > 6 and quality > 50
    backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 80);
    app.updateQuality();
    assertEquals(8, backstage.sellIn, "backstage.sellIn < 11 et > 6 and quality > 50");
    assertEquals(80, backstage.quality, "backstage.sellIn < 11 et > 6 and quality > 50");

    //for backstage.sellIn < 0 and quality > 50
    backstage = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 80);
    app.updateQuality();
    assertEquals(-1, backstage.sellIn, "backstage.sellIn < 0 and quality > 50");
    assertEquals(80, backstage.quality, "backstage.sellIn < 0 and quality > 50");

    //for backstage.sellIn < 0 et quality < 50
    backstage = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 40);
    app.updateQuality();
    assertEquals(-1, backstage.sellIn, "backstage.sellIn < 0 et quality < 50");
    assertEquals(40, backstage.quality, "backstage.sellIn < 0 et quality < 50");

    //for backstage.sellIn < 6 et quality < 50
    backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 40);
    app.updateQuality();
    assertEquals(4, backstage.sellIn, "backstage.sellIn < 6 et quality < 50");
    assertEquals(40, backstage.quality, "backstage.sellIn < 6 et quality < 50");

    //for backstage.sellIn < 11 et quality < 50
    backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 9, 40);
    app.updateQuality();
    assertEquals(9, backstage.sellIn, "backstage.sellIn < 11 et quality < 50");
    assertEquals(40, backstage.quality, "backstage.sellIn < 11 et quality < 50");

    //for backstage.sellIn > 11 et quality > 50
    backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 19, 60);
    app.updateQuality();
    assertEquals(19, backstage.sellIn, "backstage.sellIn > 11 et quality > 50");
    assertEquals(60, backstage.quality, "backstage.sellIn > 11 et quality > 50");

    //for backstage.sellIn > 11 et quality < 50
    backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 19, 40);
    app.updateQuality();
    assertEquals(19, backstage.sellIn, "backstage.sellIn > 11 et quality < 50");
    assertEquals(40, backstage.quality, "backstage.sellIn > 11 et quality < 50");

 */
  }

  //@Test
  @DisplayName("Test randomAlcool")
  void testRandomAlcool(){
    Item randomAlcool = new Item("randomAlcool", 0, 80);
    GildedRose app = new GildedRose(new Item[] {randomAlcool});

    //for randomAlcool.sellIn < 6 and quality > 50
    app.updateQuality();
    assertEquals(-1, randomAlcool.sellIn, "randomAlcool.sellIn < 6 and quality > 50");
    assertEquals(78, randomAlcool.quality, "randomAlcool.sellIn < 6 and quality > 50");
/*
    //for randomAlcool.sellIn < 11 et > 6 and quality > 50
    randomAlcool = new Item("randomAlcool", 8, 80);
    app.updateQuality();
    assertEquals(8, randomAlcool.sellIn, "randomAlcool.sellIn < 11 et > 6 and quality > 50");
    assertEquals(80, randomAlcool.quality, "randomAlcool.sellIn < 11 et > 6 and quality > 50");

    //for randomAlcool.sellIn < 0 and quality > 50
    randomAlcool = new Item("randomAlcool", -1, 80);
    app.updateQuality();
    assertEquals(-1, randomAlcool.sellIn, "randomAlcool.sellIn < 0 and quality > 50");
    assertEquals(80, randomAlcool.quality, "randomAlcool.sellIn < 0 and quality > 50");

    //for randomAlcool.sellIn < 0 et quality < 50
    randomAlcool = new Item("randomAlcool", -1, 40);
    app.updateQuality();
    assertEquals(-1, randomAlcool.sellIn, "randomAlcool.sellIn < 0 et quality < 50");
    assertEquals(40, randomAlcool.quality, "randomAlcool.sellIn < 0 et quality < 50");

    //for randomAlcool.sellIn < 6 et quality < 50
    randomAlcool = new Item("randomAlcool", 4, 40);
    app.updateQuality();
    assertEquals(4, randomAlcool.sellIn, "randomAlcool.sellIn < 6 et quality < 50");
    assertEquals(40, randomAlcool.quality, "randomAlcool.sellIn < 6 et quality < 50");

    //for randomAlcool.sellIn < 11 et quality < 50
    randomAlcool = new Item("randomAlcool", 9, 40);
    app.updateQuality();
    assertEquals(9, randomAlcool.sellIn, "randomAlcool.sellIn < 11 et quality < 50");
    assertEquals(40, randomAlcool.quality, "randomAlcool.sellIn < 11 et quality < 50");

    //for randomAlcool.sellIn > 11 et quality > 50
    randomAlcool = new Item("randomAlcool", 19, 80);
    app.updateQuality();
    assertEquals(19, randomAlcool.sellIn, "randomAlcool.sellIn > 11 et quality > 50");
    assertEquals(80, randomAlcool.quality, "randomAlcool.sellIn > 11 et quality > 50");

    //for randomAlcool.sellIn > 11 et quality < 50
    randomAlcool = new Item("randomAlcool", 19, 40);
    app.updateQuality();
    assertEquals(19, randomAlcool.sellIn, "randomAlcool.sellIn > 11 et quality < 50");
    assertEquals(40, randomAlcool.quality, "randomAlcool.sellIn > 11 et quality < 50");

 */
  }

}
