package org.basic.modules.test.service.impl;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.common.utils.Query;
import org.basic.modules.test.dao.TShopOrderDao;
import org.basic.modules.test.entity.TShopOrderEntity;
import org.basic.modules.test.service.TShopOrderService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("tShopOrderService")
public class TShopOrderServiceImpl extends ServiceImpl<TShopOrderDao, TShopOrderEntity> implements TShopOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TShopOrderEntity> page = this.selectPage(
                new Query<TShopOrderEntity>(params).getPage(),
                new EntityWrapper<TShopOrderEntity>()
        );

        return new PageUtils(page);
    }

}
