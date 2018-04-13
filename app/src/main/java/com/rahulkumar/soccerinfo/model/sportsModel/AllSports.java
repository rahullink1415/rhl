
package com.rahulkumar.soccerinfo.model.sportsModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllSports {

    @SerializedName("countrys")
    @Expose
    private List<Country> countrys = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AllSports() {
    }

    /**
     * 
     * @param countrys
     */
    public AllSports(List<Country> countrys) {
        super();
        this.countrys = countrys;
    }

    public List<Country> getCountrys() {
        return countrys;
    }

    public void setCountrys(List<Country> countrys) {
        this.countrys = countrys;
    }

}
