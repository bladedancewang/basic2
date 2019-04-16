package org.basic.modules.test.service.impl;

import java.util.Map;

import org.basic.common.utils.PageUtils;
import org.basic.common.utils.Query;
import org.basic.modules.test.dao.TShopNotificationMessageDao;
import org.basic.modules.test.entity.TShopNotificationMessageEntity;
import org.basic.modules.test.service.TShopNotificationMessageService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service("tShopNotificationMessageService")
public class TShopNotificationMessageServiceImpl extends ServiceImpl<TShopNotificationMessageDao, TShopNotificationMessageEntity> implements TShopNotificationMessageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TShopNotificationMessageEntity> page = this.selectPage(
                new Query<TShopNotificationMessageEntity>(params).getPage(),
                new EntityWrapper<TShopNotificationMessageEntity>()
        );

        return new PageUtils(page);
    }

}
