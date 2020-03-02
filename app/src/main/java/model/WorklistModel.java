package model;

import java.io.Serializable;

/**
 * Created by wolfsoft4 on 8/1/19.
 */

public class WorklistModel implements Serializable {

    public WorklistModel(boolean selected, String activityName, String time, String activityType, String activityDesc, String date,int id) {
        this.selected = selected;
        this.activityName = activityName;
        this.time = time;
        this.activityType = activityType;
        this.activityDesc = activityDesc;
        this.date = date;
        //this.position = position;
        this.id = id;
        this.isLive = true;
    }

    public WorklistModel() {
    }

    public boolean selected=false;

    public boolean getisLive() {
        return isLive;
    }

    public void setisLive(boolean live) {
        isLive = live;
    }

    public boolean isLive = true;


    public  String  activityName,time,activityType,activityDesc,date;
    //public int position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

//    public int getPosition() {
//        return position;
//    }

//    public void setPosition(int position) {
//        this.position = position;
//    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
