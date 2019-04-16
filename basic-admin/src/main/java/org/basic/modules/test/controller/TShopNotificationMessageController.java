package org.basic.modules.test.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.basic.common.utils.PageUtils;
import org.basic.common.utils.R;
import org.basic.common.validator.ValidatorUtils;
import org.basic.modules.test.entity.TShopNotificationMessageEntity;
import org.basic.modules.test.service.TShopNotificationMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 通知消息（订单、物流）
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
@RestController
@RequestMapping("sys/tshopnotificationmessage")
public class TShopNotificationMessageController {
    @Autowired
    private TShopNotificationMessageService tShopNotificationMessageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:tshopnotificationmessage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tShopNotificationMessageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:tshopnotificationmessage:info")
    public R info(@PathVariable("id") Long id){
        TShopNotificationMessageEntity tShopNotificationMessage = tShopNotificationMessageService.selectById(id);

        return R.ok().put("tShopNotificationMessage", tShopNotificationMessage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:tshopnotificationmessage:save")
    public R save(@RequestBody TShopNotificationMessageEntity tShopNotificationMessage){
        tShopNotificationMessageService.insert(tShopNotificationMessage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:tshopnotificationmessage:update")
    public R update(@RequestBody TShopNotificationMessageEntity tShopNotificationMessage){
        ValidatorUtils.validateEntity(tShopNotificationMessage);
        tShopNotificationMessageService.updateAllColumnById(tShopNotificationMessage);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:tshopnotificationmessage:delete")
    public R delete(@RequestBody Long[] ids){
        tShopNotificationMessageService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
