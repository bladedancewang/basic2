package org.basic.modules.test.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.basic.common.utils.PageUtils;
import org.basic.common.utils.R;
import org.basic.common.validator.ValidatorUtils;
import org.basic.modules.test.entity.TShopMqErrorLogEntity;
import org.basic.modules.test.service.TShopMqErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * mq消费错误表
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
@RestController
@RequestMapping("sys/tshopmqerrorlog")
public class TShopMqErrorLogController {
    @Autowired
    private TShopMqErrorLogService tShopMqErrorLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:tshopmqerrorlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tShopMqErrorLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:tshopmqerrorlog:info")
    public R info(@PathVariable("id") Long id){
        TShopMqErrorLogEntity tShopMqErrorLog = tShopMqErrorLogService.selectById(id);

        return R.ok().put("tShopMqErrorLog", tShopMqErrorLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:tshopmqerrorlog:save")
    public R save(@RequestBody TShopMqErrorLogEntity tShopMqErrorLog){
        tShopMqErrorLogService.insert(tShopMqErrorLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:tshopmqerrorlog:update")
    public R update(@RequestBody TShopMqErrorLogEntity tShopMqErrorLog){
        ValidatorUtils.validateEntity(tShopMqErrorLog);
        tShopMqErrorLogService.updateAllColumnById(tShopMqErrorLog);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:tshopmqerrorlog:delete")
    public R delete(@RequestBody Long[] ids){
        tShopMqErrorLogService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
