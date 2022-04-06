package com.trkj.project_java.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.config.Result;
import com.trkj.project_java.entity.Returnsale;
import com.trkj.project_java.service.IReturnsaleService;
import com.trkj.project_java.vo.ReturnSaleVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/returnsale")
public class ReturnsaleController {

    @Autowired
    private IReturnsaleService iReturnsaleService;


    @GetMapping("/select")
    public Result select(@RequestParam("page")int page,
                         @RequestParam("size")int size ,@RequestParam("radio")boolean radio,
                         @RequestParam("like") String like){
        Page<ReturnSaleVo> page1 = new Page<>(page,size);
        return Result.success(iReturnsaleService.select(page1,radio,like));
    }

    @PostMapping("/del")
    public Result del(@RequestBody Returnsale returnsale){
        return Result.success(iReturnsaleService.del(returnsale.getReturnsaleId()));
    }

    @GetMapping("/before")
    public Result before(@RequestParam("page")int page,
                         @RequestParam("size")int size ,@RequestParam("like") String like){
        Page<ReturnSaleVo> page1 = new Page<>(page,size);
        return Result.success(iReturnsaleService.BeforeSelect(page1,like));
    }

}
