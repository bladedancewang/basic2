package org.basic.modules.test.service;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.modules.test.entity.TShopMqErrorLogEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * mq消费错误表
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
public interface TShopMqErrorLogService extends IService<TShopMqErrorLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

