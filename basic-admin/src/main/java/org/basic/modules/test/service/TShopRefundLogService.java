package org.basic.modules.test.service;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.modules.test.entity.TShopRefundLogEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 支付中心-电商退款流水表
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
public interface TShopRefundLogService extends IService<TShopRefundLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

