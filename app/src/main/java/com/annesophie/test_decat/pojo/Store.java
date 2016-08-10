package com.annesophie.test_decat.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* Créé à l'aide de http://www.jsonschema2pojo.org/ */

public class Store {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("directorSignature")
    @Expose
    private String directorSignature;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("ebookingPhone")
    @Expose
    private String ebookingPhone;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("gpsX")
    @Expose
    private Double gpsX;
    @SerializedName("gpsY")
    @Expose
    private Double gpsY;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("facebookUrl")
    @Expose
    private String facebookUrl;
    @SerializedName("twitterAccount")
    @Expose
    private String twitterAccount;
    @SerializedName("welcomePicture")
    @Expose
    private String welcomePicture;
    @SerializedName("selfScanning")
    @Expose
    private Boolean selfScanning;
    @SerializedName("openingStore")
    @Expose
    private Boolean openingStore;
    @SerializedName("workshop")
    @Expose
    private Boolean workshop;
    @SerializedName("storeReviews")
    @Expose
    private Boolean storeReviews;
    @SerializedName("contactUrl")
    @Expose
    private String contactUrl;
    @SerializedName("directorLastName")
    @Expose
    private String directorLastName;
    @SerializedName("address")
    @Expose
    private String address;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     *
     * @param countryCode
     * The countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The directorSignature
     */
    public String getDirectorSignature() {
        return directorSignature;
    }

    /**
     *
     * @param directorSignature
     * The directorSignature
     */
    public void setDirectorSignature(String directorSignature) {
        this.directorSignature = directorSignature;
    }

    /**
     *
     * @return
     * The address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     *
     * @param address2
     * The address2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @param postalCode
     * The postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return
     * The region
     */
    public String getRegion() {
        return region;
    }

    /**
     *
     * @param region
     * The region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     *
     * @return
     * The ebookingPhone
     */
    public String getEbookingPhone() {
        return ebookingPhone;
    }

    /**
     *
     * @param ebookingPhone
     * The ebookingPhone
     */
    public void setEbookingPhone(String ebookingPhone) {
        this.ebookingPhone = ebookingPhone;
    }

    /**
     *
     * @return
     * The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     * The gpsX
     */
    public Double getGpsX() {
        return gpsX;
    }

    /**
     *
     * @param gpsX
     * The gpsX
     */
    public void setGpsX(Double gpsX) {
        this.gpsX = gpsX;
    }

    /**
     *
     * @return
     * The gpsY
     */
    public Double getGpsY() {
        return gpsY;
    }

    /**
     *
     * @param gpsY
     * The gpsY
     */
    public void setGpsY(Double gpsY) {
        this.gpsY = gpsY;
    }

    /**
     *
     * @return
     * The fax
     */
    public String getFax() {
        return fax;
    }

    /**
     *
     * @param fax
     * The fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     *
     * @return
     * The facebookUrl
     */
    public String getFacebookUrl() {
        return facebookUrl;
    }

    /**
     *
     * @param facebookUrl
     * The facebookUrl
     */
    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    /**
     *
     * @return
     * The twitterAccount
     */
    public String getTwitterAccount() {
        return twitterAccount;
    }

    /**
     *
     * @param twitterAccount
     * The twitterAccount
     */
    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    /**
     *
     * @return
     * The welcomePicture
     */
    public String getWelcomePicture() {
        return welcomePicture;
    }

    /**
     *
     * @param welcomePicture
     * The welcomePicture
     */
    public void setWelcomePicture(String welcomePicture) {
        this.welcomePicture = welcomePicture;
    }

    /**
     *
     * @return
     * The selfScanning
     */
    public Boolean getSelfScanning() {
        return selfScanning;
    }

    /**
     *
     * @param selfScanning
     * The selfScanning
     */
    public void setSelfScanning(Boolean selfScanning) {
        this.selfScanning = selfScanning;
    }

    /**
     *
     * @return
     * The openingStore
     */
    public Boolean getOpeningStore() {
        return openingStore;
    }

    /**
     *
     * @param openingStore
     * The openingStore
     */
    public void setOpeningStore(Boolean openingStore) {
        this.openingStore = openingStore;
    }

    /**
     *
     * @return
     * The workshop
     */
    public Boolean getWorkshop() {
        return workshop;
    }

    /**
     *
     * @param workshop
     * The workshop
     */
    public void setWorkshop(Boolean workshop) {
        this.workshop = workshop;
    }

    /**
     *
     * @return
     * The storeReviews
     */
    public Boolean getStoreReviews() {
        return storeReviews;
    }

    /**
     *
     * @param storeReviews
     * The storeReviews
     */
    public void setStoreReviews(Boolean storeReviews) {
        this.storeReviews = storeReviews;
    }

    /**
     *
     * @return
     * The contactUrl
     */
    public String getContactUrl() {
        return contactUrl;
    }

    /**
     *
     * @param contactUrl
     * The contactUrl
     */
    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    /**
     *
     * @return
     * The directorLastName
     */
    public String getDirectorLastName() {
        return directorLastName;
    }

    /**
     *
     * @param directorLastName
     * The directorLastName
     */
    public void setDirectorLastName(String directorLastName) {
        this.directorLastName = directorLastName;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String storeToString() {
        return getId() + "" + getAddress();
    }

}
