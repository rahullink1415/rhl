
package com.rahulkumar.soccerinfo.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sports {

    @SerializedName("sports")
    @Expose
    private List<Sport> sports = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sports() {
    }

    /**
     * 
     * @param sports
     */
    public Sports(List<Sport> sports) {
        super();
        this.sports = sports;
    }

    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

}
