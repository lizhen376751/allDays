package com.dudu.lizhen.web.module;

import java.io.Serializable;

/**
 * 店铺信息
 */
public class ShopInfo implements Serializable {
    /**
     * shopcode
     */
    private String id;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     *
     */
    private String lat;
    /**
     *
     */
    private String lon;
    /**
     *
     */
    private String state;
    /**
     * 地址
     */
    private String address;
    /**
     * 城市区号
     */
    private String city;
    /**
     * 电话
     */
    private String tel;
    /**
     * 手机
     */
    private String mobile;
    /**
     *
     */
    private String serviceContent;
    /**
     *
     */
    private Float hardware;
    /**
     *
     */
    private Float environment;
    /**
     *
     */
    private Float artificer;
    /**
     *
     */
    private Float service;
    /**
     * 店铺介绍
     */
    private String introduction;
    /**
     * 图片
     */
    private String imgListView;
    /**
     *
     */
    private String imgBig;
    /**
     * 图片介绍
     */
    private String imgIntroduct;
    /**
     *
     */
    private String shopStrength;
    /**
     * 人气
     */
    private int renqi;
    /**
     * 评价
     */
    private int pingjia;
    /**
     * 微信token
     */
    private String wXtoken;
    /**
     * 微信wXAppId
     */
    private String wXAppId;
    /**
     *
     */
    private String wXAppSecret;
    /**
     * 欢迎图片
     */
    private String welcomeImg;
    /**
     * 欢迎文字
     */
    private String welcomeTxt;
    /**
     * 路径
     */
    private String url;

    /**
     * Gets id.
     *
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets shop name.
     *
     * @return shopName shop name
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * Sets shop name.
     *
     * @param shopName shopName
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * Gets lat.
     *
     * @return lat lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * Sets lat.
     *
     * @param lat lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * Gets lon.
     *
     * @return lon lon
     */
    public String getLon() {
        return lon;
    }

    /**
     * Sets lon.
     *
     * @param lon lon
     */
    public void setLon(String lon) {
        this.lon = lon;
    }

    /**
     * Gets state.
     *
     * @return state state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets address.
     *
     * @return address address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets city.
     *
     * @return city city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets tel.
     *
     * @return tel tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Sets tel.
     *
     * @param tel tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Gets mobile.
     *
     * @return mobile mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets mobile.
     *
     * @param mobile mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets service content.
     *
     * @return serviceContent service content
     */
    public String getServiceContent() {
        return serviceContent;
    }

    /**
     * Sets service content.
     *
     * @param serviceContent serviceContent
     */
    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    /**
     * Gets hardware.
     *
     * @return hardware hardware
     */
    public Float getHardware() {
        return hardware;
    }

    /**
     * Sets hardware.
     *
     * @param hardware hardware
     */
    public void setHardware(Float hardware) {
        this.hardware = hardware;
    }

    /**
     * Gets environment.
     *
     * @return environment environment
     */
    public Float getEnvironment() {
        return environment;
    }

    /**
     * Sets environment.
     *
     * @param environment environment
     */
    public void setEnvironment(Float environment) {
        this.environment = environment;
    }

    /**
     * Gets artificer.
     *
     * @return artificer artificer
     */
    public Float getArtificer() {
        return artificer;
    }

    /**
     * Sets artificer.
     *
     * @param artificer artificer
     */
    public void setArtificer(Float artificer) {
        this.artificer = artificer;
    }

    /**
     * Gets service.
     *
     * @return service service
     */
    public Float getService() {
        return service;
    }

    /**
     * Sets service.
     *
     * @param service service
     */
    public void setService(Float service) {
        this.service = service;
    }

    /**
     * Gets introduction.
     *
     * @return introduction introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * Sets introduction.
     *
     * @param introduction introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * Gets img list view.
     *
     * @return imgListView img list view
     */
    public String getImgListView() {
        return imgListView;
    }

    /**
     * Sets img list view.
     *
     * @param imgListView imgListView
     */
    public void setImgListView(String imgListView) {
        this.imgListView = imgListView;
    }

    /**
     * Gets img big.
     *
     * @return imgBig img big
     */
    public String getImgBig() {
        return imgBig;
    }

    /**
     * Sets img big.
     *
     * @param imgBig imgBig
     */
    public void setImgBig(String imgBig) {
        this.imgBig = imgBig;
    }

    /**
     * Gets img introduct.
     *
     * @return imgIntroduct img introduct
     */
    public String getImgIntroduct() {
        return imgIntroduct;
    }

    /**
     * Sets img introduct.
     *
     * @param imgIntroduct imgIntroduct
     */
    public void setImgIntroduct(String imgIntroduct) {
        this.imgIntroduct = imgIntroduct;
    }

    /**
     * Gets shop strength.
     *
     * @return shopStrength shop strength
     */
    public String getShopStrength() {
        return shopStrength;
    }

    /**
     * Sets shop strength.
     *
     * @param shopStrength shopStrength
     */
    public void setShopStrength(String shopStrength) {
        this.shopStrength = shopStrength;
    }

    /**
     * Gets renqi.
     *
     * @return renqi renqi
     */
    public int getRenqi() {
        return renqi;
    }

    /**
     * Sets renqi.
     *
     * @param renqi renqi
     */
    public void setRenqi(int renqi) {
        this.renqi = renqi;
    }

    /**
     * Gets pingjia.
     *
     * @return pingjia pingjia
     */
    public int getPingjia() {
        return pingjia;
    }

    /**
     * Sets pingjia.
     *
     * @param pingjia pingjia
     */
    public void setPingjia(int pingjia) {
        this.pingjia = pingjia;
    }

    /**
     * Gets xtoken.
     *
     * @return wXtoken xtoken
     */
    public String getwXtoken() {
        return wXtoken;
    }

    /**
     * Sets xtoken.
     *
     * @param wXtoken wXtoken
     */
    public void setwXtoken(String wXtoken) {
        this.wXtoken = wXtoken;
    }

    /**
     * Gets x app id.
     *
     * @return wXAppId x app id
     */
    public String getwXAppId() {
        return wXAppId;
    }

    /**
     * Sets x app id.
     *
     * @param wXAppId wXAppId
     */
    public void setwXAppId(String wXAppId) {
        this.wXAppId = wXAppId;
    }

    /**
     * Gets x app secret.
     *
     * @return wXAppSecret x app secret
     */
    public String getwXAppSecret() {
        return wXAppSecret;
    }

    /**
     * Sets x app secret.
     *
     * @param wXAppSecret wXAppSecret
     */
    public void setwXAppSecret(String wXAppSecret) {
        this.wXAppSecret = wXAppSecret;
    }

    /**
     * Gets welcome img.
     *
     * @return welcomeImg welcome img
     */
    public String getWelcomeImg() {
        return welcomeImg;
    }

    /**
     * Sets welcome img.
     *
     * @param welcomeImg welcomeImg
     */
    public void setWelcomeImg(String welcomeImg) {
        this.welcomeImg = welcomeImg;
    }

    /**
     * Gets welcome txt.
     *
     * @return welcomeTxt welcome txt
     */
    public String getWelcomeTxt() {
        return welcomeTxt;
    }

    /**
     * Sets welcome txt.
     *
     * @param welcomeTxt welcomeTxt
     */
    public void setWelcomeTxt(String welcomeTxt) {
        this.welcomeTxt = welcomeTxt;
    }

    /**
     * Gets url.
     *
     * @return url url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return 实体类以字符串的形式输出
     */
    @Override
    public String toString() {
        return "ShopInfo{"
                + "id='" + id + '\''
                + ", shopName='" + shopName + '\''
                + ", lat='" + lat + '\''
                + ", lon='" + lon + '\''
                + ", state='" + state + '\''
                + ", address='" + address + '\''
                + ", city='" + city + '\''
                + ", tel='" + tel + '\''
                + ", mobile='" + mobile + '\''
                + ", serviceContent='" + serviceContent + '\''
                + ", hardware=" + hardware
                + ", environment=" + environment
                + ", artificer=" + artificer
                + ", service=" + service
                + ", introduction='" + introduction + '\''
                + ", imgListView='" + imgListView + '\''
                + ", imgBig='" + imgBig + '\''
                + ", imgIntroduct='" + imgIntroduct + '\''
                + ", shopStrength='" + shopStrength + '\''
                + ", renqi=" + renqi
                + ", pingjia=" + pingjia
                + ", wXtoken='" + wXtoken + '\''
                + ", wXAppId='" + wXAppId + '\''
                + ", wXAppSecret='" + wXAppSecret + '\''
                + ", welcomeImg='" + welcomeImg + '\''
                + ", welcomeTxt='" + welcomeTxt + '\''
                + ", url='" + url + "}";
    }
}
