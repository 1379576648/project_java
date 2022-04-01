package com.trkj.project_java.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.trkj.project_java.entity.Stock;
import com.trkj.project_java.entity.Stockvo;

public interface IStockvoService extends IService<Stockvo> {
    IPage<Stockvo> selectStockPage(Stockvo stockvo);
}
