package com.rahulkumar.soccerinfo.model.sportsModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rahulkumar on 4/4/18.
 */

public class Teams implements Parcelable{
    private String strLocked;

    private String strDescriptionEN;


    private String strManager;


    private String strStadiumLocation;


    private String idSoccerXML;

    private String strDescriptionIT;

    private String strTeamShort;

    private String strTeam;

    private String strTeamFanart1;

    private String strRSS;

    private String strStadiumDescription;

    private String strTeamFanart4;

    private String strTeamFanart3;

    private String strTeamFanart2;

    private String idTeam;

    private String strYoutube;

    private String strFacebook;


    private String strStadiumThumb;

    private String strTeamLogo;

    private String strAlternate;

    private String strDescriptionDE;

    private String strInstagram;

    private String strTwitter;

    private String strWebsite;


    private String strTeamBanner;


    private String idLeague;


    private String strKeywords;

    private String strLeague;

    private String intFormedYear;

    private String strSport;

    private String strStadium;

    private String strTeamBadge;

    private String strCountry;

    private String strTeamJersey;

    private String intLoved;


    private String strGender;

    private String intStadiumCapacity;


    protected Teams(Parcel in) {
        strLocked = in.readString();
        strDescriptionEN = in.readString();
        strManager = in.readString();
        strStadiumLocation = in.readString();
        idSoccerXML = in.readString();
        strDescriptionIT = in.readString();
        strTeamShort = in.readString();
        strTeam = in.readString();
        strTeamFanart1 = in.readString();
        strRSS = in.readString();
        strStadiumDescription = in.readString();
        strTeamFanart4 = in.readString();
        strTeamFanart3 = in.readString();
        strTeamFanart2 = in.readString();
        idTeam = in.readString();
        strYoutube = in.readString();
        strFacebook = in.readString();
        strStadiumThumb = in.readString();
        strTeamLogo = in.readString();
        strAlternate = in.readString();
        strDescriptionDE = in.readString();
        strInstagram = in.readString();
        strTwitter = in.readString();
        strWebsite = in.readString();
        strTeamBanner = in.readString();
        idLeague = in.readString();
        strKeywords = in.readString();
        strLeague = in.readString();
        intFormedYear = in.readString();
        strSport = in.readString();
        strStadium = in.readString();
        strTeamBadge = in.readString();
        strCountry = in.readString();
        strTeamJersey = in.readString();
        intLoved = in.readString();
        strGender = in.readString();
        intStadiumCapacity = in.readString();
    }

    public static final Creator<Teams> CREATOR = new Creator<Teams>() {
        @Override
        public Teams createFromParcel(Parcel in) {
            return new Teams(in);
        }

        @Override
        public Teams[] newArray(int size) {
            return new Teams[size];
        }
    };

    public String getStrLocked() {
        return strLocked;
    }

    public void setStrLocked(String strLocked) {
        this.strLocked = strLocked;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }


    public String getStrManager() {
        return strManager;
    }

    public void setStrManager(String strManager) {
        this.strManager = strManager;
    }


    public String getStrStadiumLocation() {
        return strStadiumLocation;
    }

    public void setStrStadiumLocation(String strStadiumLocation) {
        this.strStadiumLocation = strStadiumLocation;
    }


    public String getIdSoccerXML() {
        return idSoccerXML;
    }

    public void setIdSoccerXML(String idSoccerXML) {
        this.idSoccerXML = idSoccerXML;
    }

    public String getStrDescriptionIT() {
        return strDescriptionIT;
    }

    public void setStrDescriptionIT(String strDescriptionIT) {
        this.strDescriptionIT = strDescriptionIT;
    }

    public String getStrTeamShort() {
        return strTeamShort;
    }

    public void setStrTeamShort(String strTeamShort) {
        this.strTeamShort = strTeamShort;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamFanart1() {
        return strTeamFanart1;
    }

    public void setStrTeamFanart1(String strTeamFanart1) {
        this.strTeamFanart1 = strTeamFanart1;
    }

    public String getStrRSS() {
        return strRSS;
    }

    public void setStrRSS(String strRSS) {
        this.strRSS = strRSS;
    }

    public String getStrStadiumDescription() {
        return strStadiumDescription;
    }

    public void setStrStadiumDescription(String strStadiumDescription) {
        this.strStadiumDescription = strStadiumDescription;
    }

    public String getStrTeamFanart4() {
        return strTeamFanart4;
    }

    public void setStrTeamFanart4(String strTeamFanart4) {
        this.strTeamFanart4 = strTeamFanart4;
    }

    public String getStrTeamFanart3() {
        return strTeamFanart3;
    }

    public void setStrTeamFanart3(String strTeamFanart3) {
        this.strTeamFanart3 = strTeamFanart3;
    }

    public String getStrTeamFanart2() {
        return strTeamFanart2;
    }

    public void setStrTeamFanart2(String strTeamFanart2) {
        this.strTeamFanart2 = strTeamFanart2;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public String getStrFacebook() {
        return strFacebook;
    }

    public void setStrFacebook(String strFacebook) {
        this.strFacebook = strFacebook;
    }


    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrTeamLogo() {
        return strTeamLogo;
    }

    public void setStrTeamLogo(String strTeamLogo) {
        this.strTeamLogo = strTeamLogo;
    }

    public String getStrAlternate() {
        return strAlternate;
    }

    public void setStrAlternate(String strAlternate) {
        this.strAlternate = strAlternate;
    }

    public String getStrDescriptionDE() {
        return strDescriptionDE;
    }

    public void setStrDescriptionDE(String strDescriptionDE) {
        this.strDescriptionDE = strDescriptionDE;
    }

    public String getStrInstagram() {
        return strInstagram;
    }

    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
    }

    public String getStrTwitter() {
        return strTwitter;
    }

    public void setStrTwitter(String strTwitter) {
        this.strTwitter = strTwitter;
    }

    public String getStrWebsite() {
        return strWebsite;
    }

    public void setStrWebsite(String strWebsite) {
        this.strWebsite = strWebsite;
    }


    public String getStrTeamBanner() {
        return strTeamBanner;
    }

    public void setStrTeamBanner(String strTeamBanner) {
        this.strTeamBanner = strTeamBanner;
    }

    public String getIdLeague() {
        return idLeague;
    }

    public void setIdLeague(String idLeague) {
        this.idLeague = idLeague;
    }


    public String getStrKeywords() {
        return strKeywords;
    }

    public void setStrKeywords(String strKeywords) {
        this.strKeywords = strKeywords;
    }

    public String getStrLeague() {
        return strLeague;
    }

    public void setStrLeague(String strLeague) {
        this.strLeague = strLeague;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }

    public String getStrTeamJersey() {
        return strTeamJersey;
    }

    public void setStrTeamJersey(String strTeamJersey) {
        this.strTeamJersey = strTeamJersey;
    }

    public String getIntLoved() {
        return intLoved;
    }

    public void setIntLoved(String intLoved) {
        this.intLoved = intLoved;
    }


    public String getStrGender() {
        return strGender;
    }

    public void setStrGender(String strGender) {
        this.strGender = strGender;
    }

    public String getIntStadiumCapacity() {
        return intStadiumCapacity;
    }

    public void setIntStadiumCapacity(String intStadiumCapacity) {
        this.intStadiumCapacity = intStadiumCapacity;
    }


    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(strLocked);
        dest.writeString(strDescriptionEN);
        dest.writeString(strManager);
        dest.writeString(strStadiumLocation);
        dest.writeString(idSoccerXML);
        dest.writeString(strDescriptionIT);
        dest.writeString(strTeamShort);
        dest.writeString(strTeam);
        dest.writeString(strTeamFanart1);
        dest.writeString(strRSS);
        dest.writeString(strStadiumDescription);
        dest.writeString(strTeamFanart4);
        dest.writeString(strTeamFanart3);
        dest.writeString(strTeamFanart2);
        dest.writeString(idTeam);
        dest.writeString(strYoutube);
        dest.writeString(strFacebook);
        dest.writeString(strStadiumThumb);
        dest.writeString(strTeamLogo);
        dest.writeString(strAlternate);
        dest.writeString(strDescriptionDE);
        dest.writeString(strInstagram);
        dest.writeString(strTwitter);
        dest.writeString(strWebsite);
        dest.writeString(strTeamBanner);
        dest.writeString(idLeague);
        dest.writeString(strKeywords);
        dest.writeString(strLeague);
        dest.writeString(intFormedYear);
        dest.writeString(strSport);
        dest.writeString(strStadium);
        dest.writeString(strTeamBadge);
        dest.writeString(strCountry);
        dest.writeString(strTeamJersey);
        dest.writeString(intLoved);
        dest.writeString(strGender);
        dest.writeString(intStadiumCapacity);
    }
}
