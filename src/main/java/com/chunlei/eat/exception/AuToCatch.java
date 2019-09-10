package com.chunlei.eat.exception;

import com.alibaba.fastjson.JSON;
import com.chunlei.eat.model.ApiResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Created by lcl on 2019/9/9 0009
 */
@Component
public class AuToCatch implements HandlerExceptionResolver {
    private static final Logger log = LoggerFactory.getLogger(AuToCatch.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv=new ModelAndView();
        ApiResp resp=new ApiResp();
        /*  使用response返回 */
        response.setStatus(HttpStatus.OK.value()); //设置状态码200
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        resp.setRespCode("R444");
        log.error(ex.getMessage(),ex);
        resp.respErr("系统繁忙，请稍后！！");
        try {
            response.getWriter().write(JSON.toJSONString(resp));
        } catch (IOException e) {

        }
        return mv;
    }
}
