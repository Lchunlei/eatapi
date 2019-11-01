package com.chunlei.eat.controller;

import com.chunlei.eat.entity.MsgBoard;
import com.chunlei.eat.model.ApiResp;
import com.chunlei.eat.service.MsgBoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Created by lcl on 2019/10/23 0023
 */
@RestController
@RequestMapping("/board")
@Api(value = "board",tags = "留言板")
public class MsgBoardController {
    private static final Logger log = LoggerFactory.getLogger(MsgBoardController.class);

    @Autowired
    private MsgBoardService msgBoardService;

    @RequestMapping(value = "/shop",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="查看本店留言板", notes="查看本店留言板")
    public ApiResp shop(@RequestParam String eToken,@RequestParam Integer pageNum){
        ApiResp resp = new ApiResp();
        log.info("\n-----查看本店留言板---->"+pageNum+"-->"+eToken);
        msgBoardService.fingShopMsgs(eToken,pageNum,resp);
        log.info("\n-----查看本店留言板resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/qr",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="根据桌码看留言", notes="根据桌码看留言")
    public ApiResp shop(@RequestParam Integer qrId,@RequestParam Integer pageNum){
        ApiResp resp = new ApiResp();
        log.info("\n-----根据桌码看留言---->"+qrId);
        msgBoardService.findByQr(qrId,pageNum,resp);
        log.info("\n-----根据桌码看留言resp---->"+resp);
        return resp;
    }

    /**
     * 实体内shopId请使用本店任意桌码ID
     * */
    @RequestMapping(value = "/say",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="添加留言", notes="添加留言")
    public ApiResp sayMsg(@RequestBody MsgBoard msgBoard){
        ApiResp resp = new ApiResp();
        log.info("\n-----添加留言---->"+msgBoard);
        msgBoardService.addOne(msgBoard,resp);
        log.info("\n-----添加留言resp---->"+resp);
        return resp;
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ApiOperation(value="删除本店留言板", notes="删除本店留言板")
    public ApiResp delOne(@RequestParam String eToken,@RequestParam Integer mbId){
        ApiResp resp = new ApiResp();
        log.info("\n-----删除本店留言板---->"+mbId+"-->"+eToken);
        msgBoardService.delOne(eToken,mbId,resp);
        log.info("\n-----删除本店留言板resp---->"+resp);
        return resp;
    }

}
