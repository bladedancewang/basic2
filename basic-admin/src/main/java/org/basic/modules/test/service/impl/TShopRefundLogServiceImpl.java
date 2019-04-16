package org.basic.modules.test.service.impl;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.common.utils.Query;
import org.basic.modules.test.dao.TShopRefundLogDao;
import org.basic.modules.test.entity.TShopRefundLogEntity;
import org.basic.modules.test.service.TShopRefundLogService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("tShopRefundLogService")
public class TShopRefundLogServiceImpl extends ServiceImpl<TShopRefundLogDao, TShopRefundLogEntity> implements TShopRefundLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TShopRefundLogEntity> page = this.selectPage(
                new Query<TShopRefundLogEntity>(params).getPage(),
                new EntityWrapper<TShopRefundLogEntity>()
        );

        return new PageUtils(page);
    }

}
