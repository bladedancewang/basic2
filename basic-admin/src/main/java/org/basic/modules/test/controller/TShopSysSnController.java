package org.basic.modules.test.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.basic.common.utils.PageUtils;
import org.basic.common.utils.R;
import org.basic.common.validator.ValidatorUtils;
import org.basic.modules.test.entity.TShopSysSnEntity;
import org.basic.modules.test.service.TShopSysSnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 系统中心-序列号
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
@RestController
@RequestMapping("sys/tshopsyssn")
public class TShopSysSnController {
    @Autowired
    private TShopSysSnService tShopSysSnService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:tshopsyssn:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tShopSysSnService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:tshopsyssn:info")
    public R info(@PathVariable("id") Long id){
        TShopSysSnEntity tShopSysSn = tShopSysSnService.selectById(id);

        return R.ok().put("tShopSysSn", tShopSysSn);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:tshopsyssn:save")
    public R save(@RequestBody TShopSysSnEntity tShopSysSn){
        tShopSysSnService.insert(tShopSysSn);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:tshopsyssn:update")
    public R update(@RequestBody TShopSysSnEntity tShopSysSn){
        ValidatorUtils.validateEntity(tShopSysSn);
        tShopSysSnService.updateAllColumnById(tShopSysSn);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:tshopsyssn:delete")
    public R delete(@RequestBody Long[] ids){
        tShopSysSnService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
