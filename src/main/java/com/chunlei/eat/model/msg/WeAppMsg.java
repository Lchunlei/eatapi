package com.chunlei.eat.model.msg;

/**
 * @Created by lcl on 2019/10/19 0019
 */
public class WeAppMsg {
    private String template_id;
    private String page;
    private String form_id;
    private Object data;

    public WeAppMsg() {
    }

    public WeAppMsg(String template_id, String form_id, Object data) {
        this.template_id = template_id;
        this.form_id = form_id;
        this.page = "pages/index/index";
        this.data = data;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getForm_id() {
        return form_id;
    }

    public void setForm_id(String form_id) {
        this.form_id = form_id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
