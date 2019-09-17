package com.chunlei.eat.model.resp;

/**
 * @Created by lcl on 2019/9/17 0017
 */
public class QrMsg {
    private String scene;
    private String page;
    private Integer width;

    @Override
    public String toString() {
        return "QrMsg{" +
                "scene='" + scene + '\'' +
                ", page='" + page + '\'' +
                ", width=" + width +
                '}';
    }

    public QrMsg() {
    }

    public QrMsg(String scene, String page, Integer width) {
        this.scene = scene;
        this.page = page;
        this.width = width;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
