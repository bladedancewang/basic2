package org.basic.modules.test.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.basic.common.utils.PageUtils;
import org.basic.common.utils.R;
import org.basic.common.validator.ValidatorUtils;
import org.basic.modules.test.entity.TShopPaymentLogEntity;
import org.basic.modules.test.service.TShopPaymentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 支付中心-电商支付流水表
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
@RestController
@RequestMapping("sys/tshoppaymentlog")
public class TShopPaymentLogController {
    @Autowired
    private TShopPaymentLogService tShopPaymentLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:tshoppaymentlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tShopPaymentLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:tshoppaymentlog:info")
    public R info(@PathVariable("id") Long id){
        TShopPaymentLogEntity tShopPaymentLog = tShopPaymentLogService.selectById(id);

        return R.ok().put("tShopPaymentLog", tShopPaymentLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:tshoppaymentlog:save")
    public R save(@RequestBody TShopPaymentLogEntity tShopPaymentLog){
        tShopPaymentLogService.insert(tShopPaymentLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:tshoppaymentlog:update")
    public R update(@RequestBody TShopPaymentLogEntity tShopPaymentLog){
        ValidatorUtils.validateEntity(tShopPaymentLog);
        tShopPaymentLogService.updateAllColumnById(tShopPaymentLog);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:tshoppaymentlog:delete")
    public R delete(@RequestBody Long[] ids){
        tShopPaymentLogService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
