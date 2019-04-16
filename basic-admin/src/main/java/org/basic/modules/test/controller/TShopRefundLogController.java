package org.basic.modules.test.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.basic.common.utils.PageUtils;
import org.basic.common.utils.R;
import org.basic.common.validator.ValidatorUtils;
import org.basic.modules.test.entity.TShopRefundLogEntity;
import org.basic.modules.test.service.TShopRefundLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 支付中心-电商退款流水表
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
@RestController
@RequestMapping("sys/tshoprefundlog")
public class TShopRefundLogController {
    @Autowired
    private TShopRefundLogService tShopRefundLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:tshoprefundlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tShopRefundLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:tshoprefundlog:info")
    public R info(@PathVariable("id") Long id){
        TShopRefundLogEntity tShopRefundLog = tShopRefundLogService.selectById(id);

        return R.ok().put("tShopRefundLog", tShopRefundLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:tshoprefundlog:save")
    public R save(@RequestBody TShopRefundLogEntity tShopRefundLog){
        tShopRefundLogService.insert(tShopRefundLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:tshoprefundlog:update")
    public R update(@RequestBody TShopRefundLogEntity tShopRefundLog){
        ValidatorUtils.validateEntity(tShopRefundLog);
        tShopRefundLogService.updateAllColumnById(tShopRefundLog);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:tshoprefundlog:delete")
    public R delete(@RequestBody Long[] ids){
        tShopRefundLogService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
