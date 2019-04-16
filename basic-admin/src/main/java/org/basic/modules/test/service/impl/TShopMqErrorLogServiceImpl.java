package org.basic.modules.test.service.impl;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.common.utils.Query;
import org.basic.modules.test.dao.TShopMqErrorLogDao;
import org.basic.modules.test.entity.TShopMqErrorLogEntity;
import org.basic.modules.test.service.TShopMqErrorLogService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("tShopMqErrorLogService")
public class TShopMqErrorLogServiceImpl extends ServiceImpl<TShopMqErrorLogDao, TShopMqErrorLogEntity> implements TShopMqErrorLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TShopMqErrorLogEntity> page = this.selectPage(
                new Query<TShopMqErrorLogEntity>(params).getPage(),
                new EntityWrapper<TShopMqErrorLogEntity>()
        );

        return new PageUtils(page);
    }

}
