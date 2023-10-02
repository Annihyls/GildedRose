package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void nextDay() {
      for (Item item : items) {
          item.updateQuality();
      }
  }
}
