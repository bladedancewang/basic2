package org.basic.modules.test.service.impl;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.common.utils.Query;
import org.basic.modules.test.dao.TShopErrorLogDao;
import org.basic.modules.test.entity.TShopErrorLogEntity;
import org.basic.modules.test.service.TShopErrorLogService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("tShopErrorLogService")
public class TShopErrorLogServiceImpl extends ServiceImpl<TShopErrorLogDao, TShopErrorLogEntity> implements TShopErrorLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TShopErrorLogEntity> page = this.selectPage(
                new Query<TShopErrorLogEntity>(params).getPage(),
                new EntityWrapper<TShopErrorLogEntity>()
        );

        return new PageUtils(page);
    }

}
