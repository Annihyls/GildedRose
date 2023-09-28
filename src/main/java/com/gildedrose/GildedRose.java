package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQualityAllItems() {
    for (int i = 0; i < items.length; i++) {
        items[i].updateQuality();
    }
  }
}
