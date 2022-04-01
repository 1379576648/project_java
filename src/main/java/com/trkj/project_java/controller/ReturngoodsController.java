package com.trkj.project_java.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.mapper.ReturnGoodsVoMapper;
import com.trkj.project_java.pojovo.ReturnGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
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

    /**
     * 查询已出库的数据
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/selectReturnGoods")
    public IPage<ReturnGoodsVo> selectReturnGoods(@RequestParam("currentPage") int page,@RequestParam("pageSize") int size){
        Page<ReturnGoodsVo> page1 = new Page<>(page,size);
        IPage<ReturnGoodsVo> returnGoodsVoIPage = returnGoodsVoMapper.selectAll(page1,1);
        return returnGoodsVoIPage;

    }

}
