package com.example.eshop;

import android.os.Parcel;
import android.os.Parcelable;

public class Items implements Parcelable {
    int itemName;
    int itemPrice;
    int itemQuantity;
    int itemImage;
    int totalPRice;

    public Items(int itemName,int itemPrice,int itemImage){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        itemQuantity =0;
        this.itemImage = itemImage;
        totalPRice = itemPrice * itemQuantity;
    }

    protected Items(Parcel in) {
        itemName = in.readInt();
        itemPrice = in.readInt();
        itemQuantity = in.readInt();
        itemImage = in.readInt();
        totalPRice = in.readInt();
    }

    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };

    public int getItemPrice() {
        return itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }

    public int getTotalPRice() {
        return totalPRice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public int getItemName() {
        return itemName;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setTotalPRice(int totalPRice) {
        this.totalPRice = totalPRice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(itemName);
        parcel.writeInt(itemPrice);
        parcel.writeInt(itemQuantity);
        parcel.writeInt(itemImage);
        parcel.writeInt(totalPRice);
    }
}
