package com.trkj.project_java.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.trkj.project_java.entity.Commodity;
import com.trkj.project_java.service.ICommodityService;
import com.trkj.project_java.vo.AjaxResponse;
import org.aspectj.weaver.loadtime.Aj;
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
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    public ICommodityService iCommodityService;

    public String add (@RequestBody Commodity commodity){
        if (iCommodityService.appcommod(commodity) >=1){
            System.out.println("成功");
            return "成功";

        }
        System.out.println("失败");
        return "失败";
    }
    /*
    * 分页查询商品表
    * */
    @GetMapping("/selectPageC")
    public AjaxResponse select(@RequestParam("currentPage") int currenPage, @RequestParam("pagesize") int pagesize,@RequestParam("input") String commodityName){
        Page<Commodity> page = new Page<>(currenPage, pagesize);
        return AjaxResponse.success(iCommodityService.selectPage(page,commodityName));
    }
    /*
    * 根据id查询商品表
    * */
    @GetMapping("/selectById/{id}")
    public Commodity selectById(@PathVariable("id") int id){
        return iCommodityService.selectId(id);
    }

    /*
    * 根据id修改商品表
    * */
    @PostMapping("/updata")
    public int updata(@RequestBody Commodity commodity){
        return iCommodityService.updata(commodity);
    }
    /*
    * 模糊查询商品名称
    * */
    @GetMapping("/selectName/{commodityName}")
    public Commodity selectName(@PathVariable("commodityName") String commodityName){
        return iCommodityService.selectName(commodityName);
    }


}
