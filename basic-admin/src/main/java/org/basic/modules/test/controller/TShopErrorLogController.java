package org.basic.modules.test.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.basic.common.utils.PageUtils;
import org.basic.common.utils.R;
import org.basic.common.validator.ValidatorUtils;
import org.basic.modules.test.entity.TShopErrorLogEntity;
import org.basic.modules.test.service.TShopErrorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 错误信息表
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
@RestController
@RequestMapping("sys/tshoperrorlog")
public class TShopErrorLogController {
    @Autowired
    private TShopErrorLogService tShopErrorLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:tshoperrorlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tShopErrorLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:tshoperrorlog:info")
    public R info(@PathVariable("id") Long id){
        TShopErrorLogEntity tShopErrorLog = tShopErrorLogService.selectById(id);

        return R.ok().put("tShopErrorLog", tShopErrorLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:tshoperrorlog:save")
    public R save(@RequestBody TShopErrorLogEntity tShopErrorLog){
        tShopErrorLogService.insert(tShopErrorLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:tshoperrorlog:update")
    public R update(@RequestBody TShopErrorLogEntity tShopErrorLog){
        ValidatorUtils.validateEntity(tShopErrorLog);
        tShopErrorLogService.updateAllColumnById(tShopErrorLog);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:tshoperrorlog:delete")
    public R delete(@RequestBody Long[] ids){
        tShopErrorLogService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
