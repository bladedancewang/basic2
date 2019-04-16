package org.basic.modules.test.service;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.modules.test.entity.TShopNotificationMessageEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 通知消息（订单、物流）
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
public interface TShopNotificationMessageService extends IService<TShopNotificationMessageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

