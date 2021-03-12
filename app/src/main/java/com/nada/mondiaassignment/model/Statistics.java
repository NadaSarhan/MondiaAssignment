
package com.nada.mondiaassignment.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statistics implements Serializable
{

    @SerializedName("popularity")
    @Expose
    private Integer popularity;
    @SerializedName("estimatedRecentCount")
    @Expose
    private Integer estimatedRecentCount;
    @SerializedName("estimatedTotalCount")
    @Expose
    private Integer estimatedTotalCount;
    private final static long serialVersionUID = -6815431383167812621L;

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Integer getEstimatedRecentCount() {
        return estimatedRecentCount;
    }

    public void setEstimatedRecentCount(Integer estimatedRecentCount) {
        this.estimatedRecentCount = estimatedRecentCount;
    }

    public Integer getEstimatedTotalCount() {
        return estimatedTotalCount;
    }

    public void setEstimatedTotalCount(Integer estimatedTotalCount) {
        this.estimatedTotalCount = estimatedTotalCount;
    }

}
