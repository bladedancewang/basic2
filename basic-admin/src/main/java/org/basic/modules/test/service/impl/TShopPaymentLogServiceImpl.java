package org.basic.modules.test.service.impl;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.common.utils.Query;
import org.basic.modules.test.dao.TShopPaymentLogDao;
import org.basic.modules.test.entity.TShopPaymentLogEntity;
import org.basic.modules.test.service.TShopPaymentLogService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("tShopPaymentLogService")
public class TShopPaymentLogServiceImpl extends ServiceImpl<TShopPaymentLogDao, TShopPaymentLogEntity> implements TShopPaymentLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TShopPaymentLogEntity> page = this.selectPage(
                new Query<TShopPaymentLogEntity>(params).getPage(),
                new EntityWrapper<TShopPaymentLogEntity>()
        );

        return new PageUtils(page);
    }

}
