package com.example.amos.youshi;

/**
 * Created by amos on 17-4-11.
 */

public class Shiwu extends BaseActivity{
    private String name;
    private String imageURL;
    private  String yingyang;
    public Shiwu(String name, String imageUrl, String yingyang){
        this.name=name;
        this.imageURL=base_url + "/youshi" +imageUrl;
        this.yingyang=yingyang;
    }
    public String getName(){
        return name;
    }
    public String getImageURL(){
        return imageURL;
    }
    public  String getYingyang(){
        return yingyang;
    }

}