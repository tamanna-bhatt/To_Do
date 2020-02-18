package model;

/**
 * Created by wolfsoft4 on 11/1/19.
 */

public class ProjectModel {




    String name, task;
    Integer profile_image, profile_image1, profile_image2, profile_image3;

    public ProjectModel( String name, String task, Integer profile_image, Integer profile_image1, Integer profile_image2, Integer profile_image3) {

        this.name = name;
        this.task = task;
        this.profile_image = profile_image;
        this.profile_image1 = profile_image1;
        this.profile_image2 = profile_image2;
        this.profile_image3 = profile_image3;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Integer getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(Integer profile_image) {
        this.profile_image = profile_image;
    }

    public Integer getProfile_image1() {
        return profile_image1;
    }

    public void setProfile_image1(Integer profile_image1) {
        this.profile_image1 = profile_image1;
    }

    public Integer getProfile_image2() {
        return profile_image2;
    }

    public void setProfile_image2(Integer profile_image2) {
        this.profile_image2 = profile_image2;
    }

    public Integer getProfile_image3() {
        return profile_image3;
    }

    public void setProfile_image3(Integer profile_image3) {
        this.profile_image3 = profile_image3;
    }
}


