package org.basic.modules.test.service;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.modules.test.entity.TShopOrderEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 订单中心-订单表
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
public interface TShopOrderService extends IService<TShopOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

