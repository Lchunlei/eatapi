package com.chunlei.eat.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by lcl on 2019/10/23 0023
 */
@RestController
@RequestMapping("/board")
@Api(value = "board",tags = "留言板")
public class MsgBoardController {
    private static final Logger log = LoggerFactory.getLogger(MsgBoardController.class);


}
