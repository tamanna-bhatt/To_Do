package model;

import android.content.res.ColorStateList;

public class TodotodaytaskModel {
    String todotext, todotext2, todotext3, todotext4, todotext5;
    Integer todoimg, todoimg2;

    public TodotodaytaskModel(String todotext, String todotext2, String todotext3, String todotext4, String todotext5, Integer todoimg, Integer todoimg2) {
        this.todotext = todotext;
        this.todotext2 = todotext2;
        this.todotext3 = todotext3;
        this.todotext4 = todotext4;
        this.todotext5 = todotext5;
        this.todoimg = todoimg;
        this.todoimg2 = todoimg2;
    }
    //int radio;

//    public TodotodaytaskModel(String s4, String s3, String s2, String s1, String s, Integer integer, int radio) {
//        this.radio = radio;
//    }
//
//    public ColorStateList getRadio() {
//        return radio;
//    }
//
//    public void setRadio(int radio) {
//        this.radio = radio;
//    }

    public String getTodotext() {
        return todotext;
    }

    public void setTodotext(String todotext) {
        this.todotext = todotext;
    }

    public String getTodotext2() {
        return todotext2;
    }

    public void setTodotext2(String todotext2) {
        this.todotext2 = todotext2;
    }

    public String getTodotext3() {
        return todotext3;
    }

    public void setTodotext3(String todotext3) {
        this.todotext3 = todotext3;
    }

    public String getTodotext4() {
        return todotext4;
    }

    public void setTodotext4(String todotext4) {
        this.todotext4 = todotext4;
    }

    public String getTodotext5() {
        return todotext5;
    }

    public void setTodotext5(String todotext5) {
        this.todotext5 = todotext5;
    }

    public Integer getTodoimg() {
        return todoimg;
    }

    public void setTodoimg(Integer todoimg) {
        this.todoimg = todoimg;
    }

    public Integer getTodoimg2() {
        return todoimg2;
    }

    public void setTodoimg2(Integer todoimg2) {
        this.todoimg2 = todoimg2;
    }
}
