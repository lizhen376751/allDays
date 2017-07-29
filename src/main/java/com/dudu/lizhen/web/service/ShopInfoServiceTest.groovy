package com.dudu.lizhen.web.service

import com.dudu.lizhen.test.DataSourceConst
import com.dudu.lizhen.test.DataSourceContextHolder
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by Administrator on 2017/7/27.
 */

class ShopInfoServiceTest {
    @Autowired
    private ShopInfoService shopInfoService;
    void testGetShopInfo() {
        DataSourceContextHolder.setDataSourceType(DataSourceConst.TEST);
        shopInfoService.getShopInfo();
    }
}
