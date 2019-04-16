package org.basic.modules.test.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.basic.common.utils.PageUtils;
import org.basic.common.utils.R;
import org.basic.common.validator.ValidatorUtils;
import org.basic.modules.test.entity.TShopOrderEntity;
import org.basic.modules.test.service.TShopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 订单中心-订单表
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
@RestController
@RequestMapping("sys/tshoporder")
public class TShopOrderController {
    @Autowired
    private TShopOrderService tShopOrderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:tshoporder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tShopOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:tshoporder:info")
    public R info(@PathVariable("id") Long id){
        TShopOrderEntity tShopOrder = tShopOrderService.selectById(id);

        return R.ok().put("tShopOrder", tShopOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:tshoporder:save")
    public R save(@RequestBody TShopOrderEntity tShopOrder){
        tShopOrderService.insert(tShopOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:tshoporder:update")
    public R update(@RequestBody TShopOrderEntity tShopOrder){
        ValidatorUtils.validateEntity(tShopOrder);
        tShopOrderService.updateAllColumnById(tShopOrder);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:tshoporder:delete")
    public R delete(@RequestBody Long[] ids){
        tShopOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
