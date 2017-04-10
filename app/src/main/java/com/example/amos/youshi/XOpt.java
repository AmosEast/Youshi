package com.example.amos.youshi;

/**
 * Created by amos on 17-4-9.
 */

public class XOpt {
    private  String opt_name;
    private int opt_image;

    public XOpt(String name, int imageId) {
        this.opt_name = name;
        this.opt_image = imageId;
    }

    public String getOpt_name() {
        return opt_name;
    }

    public int getOpt_image() {
        return opt_image;
    }
}
