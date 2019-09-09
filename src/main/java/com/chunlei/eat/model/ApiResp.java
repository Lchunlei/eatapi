package com.chunlei.eat.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Created by lcl on 2019/8/19 0019
 */
@ApiModel(value="响应数据")
public class ApiResp<T> {
    @ApiModelProperty(value="返回码" ,required=true)
    private String respCode;
    @ApiModelProperty(value="返回信息" ,required=true)
    private String respMsg;
    @ApiModelProperty(value="返回数据" ,required=true)
    private T respData;

    public ApiResp() {
        this.respCode = "R000";
        this.respMsg = "操作成功！";
    }

    public ApiResp(String respCode, String respMsg) {
        this.respCode = respCode;
        this.respMsg = respMsg;
    }

    public void respErr(String errMsg) {
        this.respCode = "R500";
        this.respMsg = errMsg;
    }

    @Override
    public String toString() {
        return "ApiResp{" +
                "respCode='" + respCode + '\'' +
                ", respMsg='" + respMsg + '\'' +
                ", respData=" + respData +
                '}';
    }

    public T getRespData() {
        return respData;
    }

    public void setRespData(T respData) {
        this.respData = respData;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
}
