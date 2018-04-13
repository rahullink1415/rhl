
package com.rahulkumar.soccerinfo.model.sportsModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sport {

    @SerializedName("idSport")
    @Expose
    private String idSport;
    @SerializedName("strSport")
    @Expose
    private String strSport;
    @SerializedName("strSportThumb")
    @Expose
    private String strSportThumb;
    @SerializedName("strSportDescription")
    @Expose
    private String strSportDescription;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sport() {
    }

    /**
     * 
     * @param strSport
     * @param strSportDescription
     * @param strSportThumb
     * @param idSport
     */
    public Sport(String idSport, String strSport, String strSportThumb, String strSportDescription) {
        super();
        this.idSport = idSport;
        this.strSport = strSport;
        this.strSportThumb = strSportThumb;
        this.strSportDescription = strSportDescription;
    }

    public String getIdSport() {
        return idSport;
    }

    public void setIdSport(String idSport) {
        this.idSport = idSport;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrSportThumb() {
        return strSportThumb;
    }

    public void setStrSportThumb(String strSportThumb) {
        this.strSportThumb = strSportThumb;
    }

    public String getStrSportDescription() {
        return strSportDescription;
    }

    public void setStrSportDescription(String strSportDescription) {
        this.strSportDescription = strSportDescription;
    }

}
