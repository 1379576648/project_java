package com.trkj.project_java.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Returngoods;
import com.trkj.project_java.entity.Supplier;
import com.trkj.project_java.mapper.ReturnGoodsVoMapper;
import com.trkj.project_java.mapper.SupplierMapper;
import com.trkj.project_java.pojovo.ReturnGoodsVo;
import com.trkj.project_java.service.IReturngoodsService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/returngoods")
public class ReturngoodsController {
    @Autowired
    private ReturnGoodsVoMapper returnGoodsVoMapper;

    @Autowired
    private IReturngoodsService returngoodsService;

    @Autowired
    private SupplierMapper supplierMapper;

    /**
     * 查询已出库的数据
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/selectReturnGoods")
    public IPage<ReturnGoodsVo> selectReturnGoods(@RequestParam("currentPage") int page, @RequestParam("pageSize") int size
            , @RequestParam("supplierName") String shopName) {
        Page<ReturnGoodsVo> page1 = new Page<>(page, size);
        QueryWrapper<ReturnGoodsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .and(wrapper->wrapper.like("s.SUPPLIER_NAME", shopName).or().like("c.COMMODITY_NAME", shopName))
                .eq("RETURNGOODS_STATE", 1);
        IPage<ReturnGoodsVo> returnGoodsVoIPage = returnGoodsVoMapper.selectAll(page1, queryWrapper);
        return returnGoodsVoIPage;

    }

    /**
     * 查询已未出库的数据
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/notDelivered")
    public IPage<ReturnGoodsVo> notDelivered(@RequestParam("page") int page, @RequestParam("size") int size,
                                             @RequestParam("supplierName2") String shopName) {
        Page<ReturnGoodsVo> page1 = new Page<>(page, size);
        QueryWrapper<ReturnGoodsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .and(wrapper->wrapper.like("s.SUPPLIER_NAME", shopName).or().like("c.COMMODITY_NAME", shopName))
                .eq("RETURNGOODS_STATE", 2);
        IPage<ReturnGoodsVo> returnGoodsVoIPage = returnGoodsVoMapper.selectAll(page1, queryWrapper);
        return returnGoodsVoIPage;

    }

    /**
     * 修改未出库的状态
     */
    @PostMapping("/updateReturnGoods")

    public Result updateReturnGoods(@RequestBody Returngoods returngoods) {
        return returngoodsService.updateReturnGoods(returngoods);
    }

    /**
     * 根据id查询
     */
    @GetMapping("/selectReturnGoodsById/{id}")
    public ReturnGoodsVo selectReturnGoodsById(@PathVariable("id") int id){
        QueryWrapper<ReturnGoodsVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("RETURNGOODS_ID",id);
        return  returnGoodsVoMapper.selectReturnGoodsById(queryWrapper);
    }

    /**
     * 查询供应商信息
     */
    @GetMapping("/selectSupplier")
    public Result selectSuppliers(){
        List<Supplier> suppliers = supplierMapper.selectList(null);
        return Result.success(suppliers);
    }

    /**
     *
     * @param returngoods
     * @return
     */
    @PostMapping("insertReturnGoods/{id}")
    public Result insert(@PathVariable("id") int id,@RequestBody Returngoods returngoods){
        return returngoodsService.insertReturnGoods(returngoods,id);
    }

    /**
     * 查询退货商品信息
     * @param id
     * @return
     */
    @GetMapping("/selectReturnCommodity/{id}")
    public Result selectReturnCommodity(@PathVariable("id")int id){
        List<ReturnGoodsVo> returnGoodsVo = returnGoodsVoMapper.selectReturnCommodity(id);
        return Result.success(returnGoodsVo);
    }


}
