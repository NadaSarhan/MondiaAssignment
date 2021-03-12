
package com.nada.mondiaassignment.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IdBag implements Serializable
{

    @SerializedName("isrc")
    @Expose
    private String isrc;
    @SerializedName("roviId")
    @Expose
    private String roviId;
    @SerializedName("roviTrackId")
    @Expose
    private String roviTrackId;
    @SerializedName("ean")
    @Expose
    private String ean;
    @SerializedName("upc")
    @Expose
    private String upc;
    @SerializedName("icpn")
    @Expose
    private String icpn;
    @SerializedName("roviReleaseId")
    @Expose
    private String roviReleaseId;
    private final static long serialVersionUID = -4991558143616029298L;

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public String getRoviId() {
        return roviId;
    }

    public void setRoviId(String roviId) {
        this.roviId = roviId;
    }

    public String getRoviTrackId() {
        return roviTrackId;
    }

    public void setRoviTrackId(String roviTrackId) {
        this.roviTrackId = roviTrackId;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getIcpn() {
        return icpn;
    }

    public void setIcpn(String icpn) {
        this.icpn = icpn;
    }

    public String getRoviReleaseId() {
        return roviReleaseId;
    }

    public void setRoviReleaseId(String roviReleaseId) {
        this.roviReleaseId = roviReleaseId;
    }

}
