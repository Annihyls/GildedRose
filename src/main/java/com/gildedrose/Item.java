package com.gildedrose;

public class Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURA = "Sulfuras, Hand of Ragnaros";
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
            case AGED_BRIE:
                if (this.quality < 50) {
                    this.quality++;
                }
                this.sellIn--;
                if (this.sellIn < 0 && this.quality < 50) {
                    this.quality++;
                }
                break;
            case BACKSTAGE:
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
            case SULFURA:
                if(this.quality != 80) {
                    this.quality = 80;
                }
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
