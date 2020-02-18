package model;

/**
 * Created by wolfsoft4 on 8/1/19.
 */

public class WorklistModel {

    public boolean selected=false;

    public String txtfishing,time;
    public int position;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }




    public String getTxtfishing() {
        return txtfishing;
    }

    public void setTxtfishing(String txtfishing) {
        this.txtfishing = txtfishing;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public WorklistModel(int position, String txtfishing, String time) {
        this.position=position;
        this.txtfishing = txtfishing;
        this.time = time;
    }
}
