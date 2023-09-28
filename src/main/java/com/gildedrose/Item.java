package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {
        switch (this.name) {
            case "Aged Brie":
                if (this.quality < 50) {
                    this.quality++;
                }
                this.sellIn--;
                if (this.sellIn < 0 && this.quality < 50) {
                    this.quality++;
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (this.quality < 50) {
                    this.quality++;
                }
                if (this.sellIn < 11 && this.quality < 50) {
                    this.quality++;
                }
                if (this.sellIn < 6 && this.quality < 50) {
                    this.quality++;
                }
                this.sellIn--;
                if (this.sellIn < 0) {
                    this.quality = 0;
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
                //Nothing to do
                break;
            default:
                if (this.quality > 0) {
                    this.quality--;
                }
                this.sellIn--;
                if (this.sellIn < 0 && this.quality > 0) {
                    this.quality--;
                }
                break;
        }
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
