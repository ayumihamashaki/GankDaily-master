package com.gudong.gankio.data.entity;

/**
 * Created by rmtic on 2016/1/22.
 */
public class Store extends Soul{

    @Override
    public String toString() {
        return "Store{" +
                "users=" + users +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storePhone='" + storePhone + '\'' +
                ", storeDesc='" + storeDesc + '\'' +
                ", storeOpenTime='" + storeOpenTime + '\'' +
                ", storeLongitude=" + storeLongitude +
                ", storeLatitude=" + storeLatitude +
                ", storeFacePicture='" + storeFacePicture + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", identityCardPicture='" + identityCardPicture + '\'' +
                ", logoPicture='" + logoPicture + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", villageId='" + villageId + '\'' +
                ", villageName='" + villageName + '\'' +
                ", villageAddress='" + villageAddress + '\'' +
                ", licenseId='" + licenseId + '\'' +
                '}';
    }

    public User users;
    public String storeName;
    public String storeAddress;
    public String storePhone;
    public String storeDesc;
    public String storeOpenTime;
    public float storeLongitude;
    public float storeLatitude;
    public String storeFacePicture;
    public String identityCard;
    public String identityCardPicture;
    public String logoPicture;
    public String registerTime;
    public String villageId;
    public String villageName;
    public String villageAddress;
    public String licenseId;

}
