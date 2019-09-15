package com.chunlei.eat.model.resp;

import com.chunlei.eat.entity.FoodInfo;

import java.util.List;

/**
 * @Created by lcl on 2019/9/14 0014
 */
public class MenuCate {
    private Integer cateId;
    private String cateName;
    private String iconUrl;
    private List<FoodInfo> dishs;

    public MenuCate() {
    }

    public MenuCate(Integer cateId, String cateName, String iconUrl, List<FoodInfo> dishs) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.iconUrl = iconUrl;
        this.dishs = dishs;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public List<FoodInfo> getDishs() {
        return dishs;
    }

    public void setDishs(List<FoodInfo> dishs) {
        this.dishs = dishs;
    }
}
