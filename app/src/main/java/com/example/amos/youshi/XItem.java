package com.example.amos.youshi;

/**
 * Created by amos on 17-4-9.
 */

//选餐的item
public class XItem {
    private String fir_item;
    private String sec_item;

    public XItem(String fir_item, String sec_item) {
        this.fir_item = fir_item;
        this.sec_item = sec_item;
    }

    public String getFir_item() {
        return fir_item;
    }

    public String getSec_item() {
        return sec_item;
    }
}
