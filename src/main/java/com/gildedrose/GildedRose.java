package com.gildedrose;

class GildedRose {
  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      switch(items[i].name) {
        case "Aged Brie":
          if(items[i].quality < 50) {
            items[i].quality++;
          }
          items[i].sellIn--;
          if(items[i].sellIn < 0 && items[i].quality < 50) {
            items[i].quality++;
          }
          break;
        case "Backstage passes to a TAFKAL80ETC concert":
          if(items[i].quality < 50) {
            items[i].quality++;
          }
          if(items[i].sellIn < 11 && items[i].quality < 50) {
            items[i].quality++;
          }
          if(items[i].sellIn < 6 && items[i].quality < 50) {
            items[i].quality++;
          }
          items[i].sellIn--;
          if(items[i].sellIn < 0) {
            items[i].quality = 0;
          }
          break;
        case "Sulfuras, Hand of Ragnaros":
          //Nothing to do
          break;
        default:
          //TODO
          break;
      }
      //first statement just to disable Aged brie from process
      if(!items[i].name.equals("Aged Brie")
              && !items[i].name.equals("Sulfuras, Hand of Ragnaros")
              && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          if (items[i].quality > 0) {
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
              items[i].quality = items[i].quality - 1;
            }
          }
        } else {
          if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
              if (items[i].sellIn < 11) {
                if (items[i].quality < 50) {
                  items[i].quality = items[i].quality + 1;
                }
              }

              if (items[i].sellIn < 6) {
                if (items[i].quality < 50) {
                  items[i].quality = items[i].quality + 1;
                }
              }
            }
          }
        }

        if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
          items[i].sellIn = items[i].sellIn - 1;
        }

        if (items[i].sellIn < 0) {
          if (!items[i].name.equals("Aged Brie")) {
            if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
              if (items[i].quality > 0) {
                if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                  items[i].quality = items[i].quality - 1;
                }
              }
            } else {
              items[i].quality = items[i].quality - items[i].quality;
            }
          } else {
            if (items[i].quality < 50) {
              items[i].quality = items[i].quality + 1;
            }
          }
        }
      }

    }
  }
}
