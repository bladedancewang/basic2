package org.basic.modules.test.service.impl;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.common.utils.Query;
import org.basic.modules.test.dao.TShopSysSnDao;
import org.basic.modules.test.entity.TShopSysSnEntity;
import org.basic.modules.test.service.TShopSysSnService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("tShopSysSnService")
public class TShopSysSnServiceImpl extends ServiceImpl<TShopSysSnDao, TShopSysSnEntity> implements TShopSysSnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TShopSysSnEntity> page = this.selectPage(
                new Query<TShopSysSnEntity>(params).getPage(),
                new EntityWrapper<TShopSysSnEntity>()
        );

        return new PageUtils(page);
    }

}
