package com.dudu.lizhen.web.service;


import com.dudu.lizhen.web.mapper.ShopInfoDao;
import com.dudu.lizhen.web.module.ShopInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/28.
 */
@Service
public class ShopInfoService {
    /**
     * 注入dao层
     */
    @Autowired
    private ShopInfoDao shopInfoDao;

    /**
     * @param shopcode 店铺编码
     * @return 店铺信息
     */
    public ShopInfo getShopInfo(String shopcode) {
        return shopInfoDao.getShopInfo(shopcode);
    }
}
