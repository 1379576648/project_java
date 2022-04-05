package com.trkj.project_java.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Customer;
import com.trkj.project_java.entity.Staff;
import com.trkj.project_java.entity.Tab;
import com.trkj.project_java.mapper.StaffMapper;
import com.trkj.project_java.mapper.TabMapper;
import com.trkj.project_java.service.ITabService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Service
public class TabServiceImpl extends ServiceImpl<TabMapper, Tab> implements ITabService {

    @Autowired
    private TabMapper tabMapper;

    /**
     * 查询所有记录
     *
     * @return
     */
    @Override
    public IPage<Tab> selectAllTab(Integer currentPage, Integer pagesSize, String customerName) {
        // 分页查询
        Page<Tab> page = new Page<>(currentPage, pagesSize);
        QueryWrapper<Tab> tabQueryWrapper = new QueryWrapper<>();
        if (!Objects.equals(customerName, "*****1*****1*****1")) {
            tabQueryWrapper.like("t4.customer_name", customerName);
        }
        tabQueryWrapper.eq("t1.deleted", 0);
        return tabMapper.selectListPage(page, tabQueryWrapper);
    }

    /**
     * 查询所有作废记录
     *
     * @return
     */
    @Override
    public IPage<Tab> selectAllTabAbolish(Integer currentPage, Integer pagesSize) {
        // 分页查询
        Page<Tab> page = new Page<>(currentPage, pagesSize);
        QueryWrapper<Tab> tabQueryWrapper = new QueryWrapper<>();
        tabQueryWrapper.ne("t1.deleted", 0);
        return tabMapper.selectListPage(page, tabQueryWrapper);
    }

    /**
     * 作废记录根据编号ID
     *
     * @param tabId
     * @return
     */
    @Override
    public String cancellationById(Integer tabId) {
        final var i = tabMapper.deleteById(tabId);
        if (i == 1) {
            return "作废成功";
        } else {
            return "作废失败";
        }
    }

    @Override
    public Tab selectTabByID(Integer tabId, Integer receivableId) {
        QueryWrapper<Tab> tabQueryWrapper = new QueryWrapper<>();
        tabQueryWrapper.eq("t1.receivable_id", receivableId);
        tabQueryWrapper.eq("t1.tab_id", tabId);
        return tabMapper.selectTabByID(tabQueryWrapper);
    }
}
