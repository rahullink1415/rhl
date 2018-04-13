
package com.rahulkumar.soccerinfo.model.sportsModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Leagues {

    @SerializedName("leagues")
    @Expose
    private List<League> leagues = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Leagues() {
    }

    /**
     * 
     * @param leagues
     */
    public Leagues(List<League> leagues) {
        super();
        this.leagues = leagues;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

}
