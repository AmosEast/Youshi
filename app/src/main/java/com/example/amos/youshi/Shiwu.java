package com.example.amos.youshi;

/**
 * Created by amos on 17-4-11.
 */

public class Shiwu {
    private String name;
    private int imageId;
    private  String yingyang;
    public Shiwu(String name, int imageId, String yingyang){
        this.name=name;
        this.imageId=imageId;
        this.yingyang=yingyang;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
    public  String getYingyang(){
        return yingyang;
    }

}