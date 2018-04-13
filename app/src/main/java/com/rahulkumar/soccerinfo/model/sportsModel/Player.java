package com.rahulkumar.soccerinfo.model.sportsModel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rahulkumar on 4/3/18.
 */

public class Player extends Sports implements Parcelable {
    private String strLocked;


    private String strDescriptionEN;


    private String strTwitter;

    private String strWebsite;

    private String idPlayer;


    private String strWeight;

    private String strBirthLocation;


    private String strPlayer;


    private String strSigning;

    private String strThumb;

    private String strHeight;


    private String dateBorn;

    private String strCutout;

    private String idSoccerXML;


    private String intSoccerXMLTeamID;

    private String strTeam;

    private String idPlayerManager;

    private String strWage;

    private String strSport;


    private String dateSigned;

    private String intLoved;

    private String strNationality;


    private String idTeam;

    private String strYoutube;

    private String strFacebook;


    private String strGender;


    private String strFanart4;

    private String strFanart3;

    private String strFanart2;

    private String strInstagram;


    private String strFanart1;

    private String strPosition;
    public Player(){}

    private Player(Parcel in) {
        strLocked = in.readString();
        strDescriptionEN = in.readString();
        strTwitter = in.readString();
        strWebsite = in.readString();
        idPlayer = in.readString();
        strWeight = in.readString();
        strBirthLocation = in.readString();
        strPlayer = in.readString();
        strSigning = in.readString();
        strThumb = in.readString();
        strHeight = in.readString();
        dateBorn = in.readString();
        strCutout = in.readString();
        idSoccerXML = in.readString();
        intSoccerXMLTeamID = in.readString();
        strTeam = in.readString();
        idPlayerManager = in.readString();
        strWage = in.readString();
        strSport = in.readString();
        dateSigned = in.readString();
        intLoved = in.readString();
        strNationality = in.readString();
        idTeam = in.readString();
        strYoutube = in.readString();
        strFacebook = in.readString();
        strGender = in.readString();
        strFanart4 = in.readString();
        strFanart3 = in.readString();
        strFanart2 = in.readString();
        strInstagram = in.readString();
        strFanart1 = in.readString();
        strPosition = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
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

    public String getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(String idPlayer) {
        this.idPlayer = idPlayer;
    }


    public String getStrWeight() {
        return strWeight;
    }

    public void setStrWeight(String strWeight) {
        this.strWeight = strWeight;
    }

    public String getStrBirthLocation() {
        return strBirthLocation;
    }

    public void setStrBirthLocation(String strBirthLocation) {
        this.strBirthLocation = strBirthLocation;
    }


    public String getStrPlayer() {
        return strPlayer;
    }

    public void setStrPlayer(String strPlayer) {
        this.strPlayer = strPlayer;
    }


    public String getStrSigning() {
        return strSigning;
    }

    public void setStrSigning(String strSigning) {
        this.strSigning = strSigning;
    }

    public String getStrThumb() {
        return strThumb;
    }

    public void setStrThumb(String strThumb) {
        this.strThumb = strThumb;
    }

    public String getStrHeight() {
        return strHeight;
    }

    public void setStrHeight(String strHeight) {
        this.strHeight = strHeight;
    }


    public String getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getStrCutout() {
        return strCutout;
    }

    public void setStrCutout(String strCutout) {
        this.strCutout = strCutout;
    }

    public String getIdSoccerXML() {
        return idSoccerXML;
    }

    public void setIdSoccerXML(String idSoccerXML) {
        this.idSoccerXML = idSoccerXML;
    }


    public String getIntSoccerXMLTeamID() {
        return intSoccerXMLTeamID;
    }

    public void setIntSoccerXMLTeamID(String intSoccerXMLTeamID) {
        this.intSoccerXMLTeamID = intSoccerXMLTeamID;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getIdPlayerManager() {
        return idPlayerManager;
    }

    public void setIdPlayerManager(String idPlayerManager) {
        this.idPlayerManager = idPlayerManager;
    }

    public String getStrWage() {
        return strWage;
    }

    public void setStrWage(String strWage) {
        this.strWage = strWage;
    }

    public String getStrSport() {
        return strSport;
    }

    public void setStrSport(String strSport) {
        this.strSport = strSport;
    }


    public String getDateSigned() {
        return dateSigned;
    }

    public void setDateSigned(String dateSigned) {
        this.dateSigned = dateSigned;
    }

    public String getIntLoved() {
        return intLoved;
    }

    public void setIntLoved(String intLoved) {
        this.intLoved = intLoved;
    }

    public String getStrNationality() {
        return strNationality;
    }

    public void setStrNationality(String strNationality) {
        this.strNationality = strNationality;
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


    public String getStrGender() {
        return strGender;
    }

    public void setStrGender(String strGender) {
        this.strGender = strGender;
    }


    public String getStrFanart4() {
        return strFanart4;
    }

    public void setStrFanart4(String strFanart4) {
        this.strFanart4 = strFanart4;
    }

    public String getStrFanart3() {
        return strFanart3;
    }

    public void setStrFanart3(String strFanart3) {
        this.strFanart3 = strFanart3;
    }

    public String getStrFanart2() {
        return strFanart2;
    }

    public void setStrFanart2(String strFanart2) {
        this.strFanart2 = strFanart2;
    }

    public String getStrInstagram() {
        return strInstagram;
    }

    public void setStrInstagram(String strInstagram) {
        this.strInstagram = strInstagram;
    }


    public String getStrFanart1() {
        return strFanart1;
    }

    public void setStrFanart1(String strFanart1) {
        this.strFanart1 = strFanart1;
    }

    public String getStrPosition() {
        return strPosition;
    }

    public void setStrPosition(String strPosition) {
        this.strPosition = strPosition;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(strLocked);
        dest.writeString(strDescriptionEN);
        dest.writeString(strTwitter);
        dest.writeString(strWebsite);
        dest.writeString(idPlayer);
        dest.writeString(strWeight);
        dest.writeString(strBirthLocation);
        dest.writeString(strPlayer);
        dest.writeString(strSigning);
        dest.writeString(strThumb);
        dest.writeString(strHeight);
        dest.writeString(dateBorn);
        dest.writeString(strCutout);
        dest.writeString(idSoccerXML);
        dest.writeString(intSoccerXMLTeamID);
        dest.writeString(strTeam);
        dest.writeString(idPlayerManager);
        dest.writeString(strWage);
        dest.writeString(strSport);
        dest.writeString(dateSigned);
        dest.writeString(intLoved);
        dest.writeString(strNationality);
        dest.writeString(idTeam);
        dest.writeString(strYoutube);
        dest.writeString(strFacebook);
        dest.writeString(strGender);
        dest.writeString(strFanart4);
        dest.writeString(strFanart3);
        dest.writeString(strFanart2);
        dest.writeString(strInstagram);
        dest.writeString(strFanart1);
        dest.writeString(strPosition);
    }
}