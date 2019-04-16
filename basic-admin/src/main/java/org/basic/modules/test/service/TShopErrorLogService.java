package org.basic.modules.test.service;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.modules.test.entity.TShopErrorLogEntity;

import com.baomidou.mybatisplus.service.IService;

/**
 * 错误信息表
 *
 * @author bladedance
 * @email bladedance@vip.qq.com
 * @date 2018-11-27 17:24:30
 */
public interface TShopErrorLogService extends IService<TShopErrorLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

