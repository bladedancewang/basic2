package org.basic.modules.test.service;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.modules.test.entity.TShopSysSnEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 系统中心-序列号
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
public interface TShopSysSnService extends IService<TShopSysSnEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

