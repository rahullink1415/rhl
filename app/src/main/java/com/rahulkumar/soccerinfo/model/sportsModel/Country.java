
package com.rahulkumar.soccerinfo.model.sportsModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Parcelable {

    @SerializedName("idLeague")
    @Expose
    private String idLeague;
    @SerializedName("idSoccerXML")
    @Expose
    private Object idSoccerXML;
    @SerializedName("strSport")
    @Expose
    private String strSport;
    @SerializedName("strLeague")
    @Expose
    private String strLeague;
    @SerializedName("strLeagueAlternate")
    @Expose
    private String strLeagueAlternate;
    @SerializedName("intFormedYear")
    @Expose
    private String intFormedYear;
    @SerializedName("dateFirstEvent")
    @Expose
    private String dateFirstEvent;
    @SerializedName("strGender")
    @Expose
    private String strGender;
    @SerializedName("strCountry")
    @Expose
    private String strCountry;
    @SerializedName("strWebsite")
    @Expose
    private String strWebsite;
    @SerializedName("strFacebook")
    @Expose
    private String strFacebook;
    @SerializedName("strTwitter")
    @Expose
    private String strTwitter;
    @SerializedName("strYoutube")
    @Expose
    private String strYoutube;
    @SerializedName("strRSS")
    @Expose
    private String strRSS;
    @SerializedName("strDescriptionEN")
    @Expose
    private String strDescriptionEN;
    @SerializedName("strDescriptionDE")
    @Expose
    private Object strDescriptionDE;
    @SerializedName("strDescriptionFR")
    @Expose
    private Object strDescriptionFR;
    @SerializedName("strDescriptionIT")
    @Expose
    private Object strDescriptionIT;
    @SerializedName("strDescriptionCN")
    @Expose
    private Object strDescriptionCN;
    @SerializedName("strDescriptionJP")
    @Expose
    private Object strDescriptionJP;
    @SerializedName("strDescriptionRU")
    @Expose
    private Object strDescriptionRU;
    @SerializedName("strDescriptionES")
    @Expose
    private Object strDescriptionES;
    @SerializedName("strDescriptionPT")
    @Expose
    private Object strDescriptionPT;
    @SerializedName("strDescriptionSE")
    @Expose
    private Object strDescriptionSE;
    @SerializedName("strDescriptionNL")
    @Expose
    private Object strDescriptionNL;
    @SerializedName("strDescriptionHU")
    @Expose
    private Object strDescriptionHU;
    @SerializedName("strDescriptionNO")
    @Expose
    private Object strDescriptionNO;
    @SerializedName("strDescriptionPL")
    @Expose
    private Object strDescriptionPL;
    @SerializedName("strFanart1")
    @Expose
    private String strFanart1;
    @SerializedName("strFanart2")
    @Expose
    private String strFanart2;
    @SerializedName("strFanart3")
    @Expose
    private String strFanart3;
    @SerializedName("strFanart4")
    @Expose
    private String strFanart4;
    @SerializedName("strBanner")
    @Expose
    private Object strBanner;
    @SerializedName("strBadge")
    @Expose
    private String strBadge;
    @SerializedName("strLogo")
    @Expose
    private Object strLogo;
    @SerializedName("strPoster")
    @Expose
    private String strPoster;
    @SerializedName("strTrophy")
    @Expose
    private String strTrophy;
    @SerializedName("strNaming")
    @Expose
    private String strNaming;
    @SerializedName("strLocked")
    @Expose
    private String strLocked;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Country() {
    }

    /**
     * 
     * @param strLocked
     * @param dateFirstEvent
     * @param strDescriptionEN
     * @param strDescriptionRU
     * @param strTwitter
     * @param strWebsite
     * @param strDescriptionPL
     * @param strDescriptionCN
     * @param strBadge
     * @param strDescriptionNO
     * @param idLeague
     * @param strDescriptionES
     * @param strDescriptionPT
     * @param strDescriptionNL
     * @param strDescriptionSE
     * @param idSoccerXML
     * @param strLeague
     * @param strDescriptionIT
     * @param strLeagueAlternate
     * @param strLogo
     * @param intFormedYear
     * @param strSport
     * @param strCountry
     * @param strRSS
     * @param strBanner
     * @param strTrophy
     * @param strDescriptionJP
     * @param strYoutube
     * @param strDescriptionHU
     * @param strFacebook
     * @param strGender
     * @param strNaming
     * @param strDescriptionDE
     * @param strFanart4
     * @param strFanart3
     * @param strPoster
     * @param strFanart2
     * @param strDescriptionFR
     * @param strFanart1
     */
    public Country(String idLeague, Object idSoccerXML, String strSport, String strLeague, String strLeagueAlternate, String intFormedYear, String dateFirstEvent, String strGender, String strCountry, String strWebsite, String strFacebook, String strTwitter, String strYoutube, String strRSS, String strDescriptionEN, Object strDescriptionDE, Object strDescriptionFR, Object strDescriptionIT, Object strDescriptionCN, Object strDescriptionJP, Object strDescriptionRU, Object strDescriptionES, Object strDescriptionPT, Object strDescriptionSE, Object strDescriptionNL, Object strDescriptionHU, Object strDescriptionNO, Object strDescriptionPL, String strFanart1, String strFanart2, String strFanart3, String strFanart4, Object strBanner, String strBadge, Object strLogo, String strPoster, String strTrophy, String strNaming, String strLocked) {
        super();
        this.idLeague = idLeague;
        this.idSoccerXML = idSoccerXML;
        this.strSport = strSport;
        this.strLeague = strLeague;
        this.strLeagueAlternate = strLeagueAlternate;
        this.intFormedYear = intFormedYear;
        this.dateFirstEvent = dateFirstEvent;
        this.strGender = strGender;
        this.strCountry = strCountry;
        this.strWebsite = strWebsite;
        this.strFacebook = strFacebook;
        this.strTwitter = strTwitter;
        this.strYoutube = strYoutube;
        this.strRSS = strRSS;
        this.strDescriptionEN = strDescriptionEN;
        this.strDescriptionDE = strDescriptionDE;
        this.strDescriptionFR = strDescriptionFR;
        this.strDescriptionIT = strDescriptionIT;
        this.strDescriptionCN = strDescriptionCN;
        this.strDescriptionJP = strDescriptionJP;
        this.strDescriptionRU = strDescriptionRU;
        this.strDescriptionES = strDescriptionES;
        this.strDescriptionPT = strDescriptionPT;
        this.strDescriptionSE = strDescriptionSE;
        this.strDescriptionNL = strDescriptionNL;
        this.strDescriptionHU = strDescriptionHU;
        this.strDescriptionNO = strDescriptionNO;
        this.strDescriptionPL = strDescriptionPL;
        this.strFanart1 = strFanart1;
        this.strFanart2 = strFanart2;
        this.strFanart3 = strFanart3;
        this.strFanart4 = strFanart4;
        this.strBanner = strBanner;
        this.strBadge = strBadge;
        this.strLogo = strLogo;
        this.strPoster = strPoster;
        this.strTrophy = strTrophy;
        this.strNaming = strNaming;
        this.strLocked = strLocked;
    }

    protected Country(Parcel in) {
        idLeague = in.readString();
        strSport = in.readString();
        strLeague = in.readString();
        strLeagueAlternate = in.readString();
        intFormedYear = in.readString();
        dateFirstEvent = in.readString();
        strGender = in.readString();
        strCountry = in.readString();
        strWebsite = in.readString();
        strFacebook = in.readString();
        strTwitter = in.readString();
        strYoutube = in.readString();
        strRSS = in.readString();
        strDescriptionEN = in.readString();
        strFanart1 = in.readString();
        strFanart2 = in.readString();
        strFanart3 = in.readString();
        strFanart4 = in.readString();
        strBadge = in.readString();
        strPoster = in.readString();
        strTrophy = in.readString();
        strNaming = in.readString();
        strLocked = in.readString();
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }

    public Object getIdSoccerXML() {
        return idSoccerXML;
    }

    public void setIdSoccerXML(Object idSoccerXML) {
        this.idSoccerXML = idSoccerXML;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getStrLeagueAlternate() {
        return strLeagueAlternate;
    }

    public void setStrLeagueAlternate(String strLeagueAlternate) {
        this.strLeagueAlternate = strLeagueAlternate;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getDateFirstEvent() {
        return dateFirstEvent;
    }

    public void setDateFirstEvent(String dateFirstEvent) {
        this.dateFirstEvent = dateFirstEvent;
    }

    public String getStrGender() {
        return strGender;
    }

    public void setStrGender(String strGender) {
        this.strGender = strGender;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }

    public String getStrTwitter() {
        return strTwitter;
    }

    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrRSS() {
        return strRSS;
    }

    public void setStrRSS(String strRSS) {
        this.strRSS = strRSS;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    public Object getStrDescriptionDE() {
        return strDescriptionDE;
    }

    public void setStrDescriptionDE(Object strDescriptionDE) {
        this.strDescriptionDE = strDescriptionDE;
    }

    public Object getStrDescriptionFR() {
        return strDescriptionFR;
    }

    public void setStrDescriptionFR(Object strDescriptionFR) {
        this.strDescriptionFR = strDescriptionFR;
    }

    public Object getStrDescriptionIT() {
        return strDescriptionIT;
    }

    public void setStrDescriptionIT(Object strDescriptionIT) {
        this.strDescriptionIT = strDescriptionIT;
    }

    public Object getStrDescriptionCN() {
        return strDescriptionCN;
    }

    public void setStrDescriptionCN(Object strDescriptionCN) {
        this.strDescriptionCN = strDescriptionCN;
    }

    public Object getStrDescriptionJP() {
        return strDescriptionJP;
    }

    public void setStrDescriptionJP(Object strDescriptionJP) {
        this.strDescriptionJP = strDescriptionJP;
    }

    public Object getStrDescriptionRU() {
        return strDescriptionRU;
    }

    public void setStrDescriptionRU(Object strDescriptionRU) {
        this.strDescriptionRU = strDescriptionRU;
    }

    public Object getStrDescriptionES() {
        return strDescriptionES;
    }

    public void setStrDescriptionES(Object strDescriptionES) {
        this.strDescriptionES = strDescriptionES;
    }

    public Object getStrDescriptionPT() {
        return strDescriptionPT;
    }

    public void setStrDescriptionPT(Object strDescriptionPT) {
        this.strDescriptionPT = strDescriptionPT;
    }

    public Object getStrDescriptionSE() {
        return strDescriptionSE;
    }

    public void setStrDescriptionSE(Object strDescriptionSE) {
        this.strDescriptionSE = strDescriptionSE;
    }

    public Object getStrDescriptionNL() {
        return strDescriptionNL;
    }

    public void setStrDescriptionNL(Object strDescriptionNL) {
        this.strDescriptionNL = strDescriptionNL;
    }

    public Object getStrDescriptionHU() {
        return strDescriptionHU;
    }

    public void setStrDescriptionHU(Object strDescriptionHU) {
        this.strDescriptionHU = strDescriptionHU;
    }

    public Object getStrDescriptionNO() {
        return strDescriptionNO;
    }

    public void setStrDescriptionNO(Object strDescriptionNO) {
        this.strDescriptionNO = strDescriptionNO;
    }

    public Object getStrDescriptionPL() {
        return strDescriptionPL;
    }

    public void setStrDescriptionPL(Object strDescriptionPL) {
        this.strDescriptionPL = strDescriptionPL;
    }

    public String getStrFanart1() {
        return strFanart1;
    }

    public void setStrFanart1(String strFanart1) {
        this.strFanart1 = strFanart1;
    }

    public String getStrFanart2() {
        return strFanart2;
    }

    public void setStrFanart2(String strFanart2) {
        this.strFanart2 = strFanart2;
    }

    public String getStrFanart3() {
        return strFanart3;
    }

    public void setStrFanart3(String strFanart3) {
        this.strFanart3 = strFanart3;
    }

    public String getStrFanart4() {
        return strFanart4;
    }

    public void setStrFanart4(String strFanart4) {
        this.strFanart4 = strFanart4;
    }

    public Object getStrBanner() {
        return strBanner;
    }

    public void setStrBanner(Object strBanner) {
        this.strBanner = strBanner;
    }

    public String getStrBadge() {
        return strBadge;
    }

    public void setStrBadge(String strBadge) {
        this.strBadge = strBadge;
    }

    public Object getStrLogo() {
        return strLogo;
    }

    public void setStrLogo(Object strLogo) {
        this.strLogo = strLogo;
    }

    public String getStrPoster() {
        return strPoster;
    }

    public void setStrPoster(String strPoster) {
        this.strPoster = strPoster;
    }

    public String getStrTrophy() {
        return strTrophy;
    }

    public void setStrTrophy(String strTrophy) {
        this.strTrophy = strTrophy;
    }

    public String getStrNaming() {
        return strNaming;
    }

    public void setStrNaming(String strNaming) {
        this.strNaming = strNaming;
    }

    public String getStrLocked() {
        return strLocked;
    }

    public void setStrLocked(String strLocked) {
        this.strLocked = strLocked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idLeague);
        dest.writeString(strSport);
        dest.writeString(strLeague);
        dest.writeString(strLeagueAlternate);
        dest.writeString(intFormedYear);
        dest.writeString(dateFirstEvent);
        dest.writeString(strGender);
        dest.writeString(strCountry);
        dest.writeString(strWebsite);
        dest.writeString(strFacebook);
        dest.writeString(strTwitter);
        dest.writeString(strYoutube);
        dest.writeString(strRSS);
        dest.writeString(strDescriptionEN);
        dest.writeString(strFanart1);
        dest.writeString(strFanart2);
        dest.writeString(strFanart3);
        dest.writeString(strFanart4);
        dest.writeString(strBadge);
        dest.writeString(strPoster);
        dest.writeString(strTrophy);
        dest.writeString(strNaming);
        dest.writeString(strLocked);
    }
}
