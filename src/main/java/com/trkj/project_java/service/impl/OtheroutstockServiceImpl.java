package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.trkj.project_java.entity.Otheroutstock;
import com.trkj.project_java.entity.Otheroutstockdetails;
import com.trkj.project_java.mapper.OtheroutstockMapper;
import com.trkj.project_java.mapper.OutinstocktypeMapper;
import com.trkj.project_java.mapper.StaffMapper;
import com.trkj.project_java.mapper.StockMapper;
import com.trkj.project_java.service.IOtheroutstockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class OtheroutstockServiceImpl extends ServiceImpl<OtheroutstockMapper, Otheroutstock> implements IOtheroutstockService {

    // 仓库表
    @Autowired
    private StockMapper stockMapper;

    // 出入库类型表
    @Autowired
    private OutinstocktypeMapper outinstocktypeMapper;

    // 用户
    @Autowired
    private StaffMapper staffMapper;


    // 查询所有仓库
    @Override
    public List<Map> selectAllStock() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("STOCK_ID","STOCK_NAME");
        return stockMapper.selectMaps(wrapper);
    }

    // 查询所有出库类型
    @Override
    public List<Map> selectAllOutStockType() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("OUTINSTOCKTYPE_ID","OUTINSTOCKTYPE_NAME");
        wrapper.eq("ISOUTIN",0); // 类型为出库的
        return outinstocktypeMapper.selectMaps(wrapper);
    }

    // 查询所有用户
    @Override
    public List<Map> selectAllStaff() {
        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.select("STAFF_ID","STAFF_NAME");
        wrapper.eq("STAFF_STATE",0); // 类型为出库的
        return staffMapper.selectMaps(wrapper);
    }

    // 新增其他出库单
    @Override
    @Transactional
    public int insertOtheroutstock(Otheroutstock otheroutstock, List<Otheroutstockdetails> otheroutstockdetails) {

        // 添加其他出库单



        // 如果小于1，就是添加失败，则回滚，前台会提示添加失败
        // 手动回滚
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return 0;
    }
}
