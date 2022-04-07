package com.trkj.project_java.controller;


import com.trkj.project_java.service.ITabService;
import com.trkj.project_java.vo.AjaxResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 * 应收欠款流水表
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@RestController
@RequestMapping("/tab")
public class TabController {

    @Autowired
    private ITabService tabService;

    /**
     * 查询所有收款记录
     *
     * @param currentPage
     * @param pagesSize
     * @return
     * @Tab 应收欠款流水表
     */
    @GetMapping("/selectAllTab/{currentPage}/{pagesSize}/{customerName}")
    public AjaxResponse selectAllTab(@PathVariable("currentPage") Integer currentPage,
                                     @PathVariable("pagesSize") Integer pagesSize,
                                     @PathVariable("customerName") String customerName) {
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", tabService.selectAllTab(currentPage, pagesSize,customerName));
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }

    /**
     * 查询所有作废收款记录
     *
     * @param currentPage
     * @param pagesSize
     * @return
     * @Tab 应收欠款流水表
     */
    @GetMapping("/selectAllTabAbolish/{currentPage}/{pagesSize}")
    public AjaxResponse selectAllTabAbolish(@PathVariable("currentPage") Integer currentPage,
                                     @PathVariable("pagesSize") Integer pagesSize) {
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", tabService.selectAllTabAbolish(currentPage, pagesSize));
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }

    /**
     * 作废记录根据编号ID
     *
     * @param tabId
     * @return
     */
    @DeleteMapping("/cancellationById/{tabId}")
    public AjaxResponse cancellationById(@PathVariable("tabId") Integer tabId) {
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", tabService.cancellationById(tabId));
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }


    /**
     * 根据ID查询记录
     *
     * @return
     * @Tab 应收欠款流水表
     */
    @GetMapping("/selectTabByID/{tabId}/{receivableId}")
    public AjaxResponse selectTabByID(@PathVariable("tabId") Integer tabId,
                                      @PathVariable("receivableId") Integer receivableId) {
        Map<String, Object> map = new HashMap<>(2);
        try {
            map.put("state", 200);
            map.put("info", tabService.selectTabByID(tabId,receivableId));
        } catch (Exception e) {
            map.put("state", 400);
            map.put("info", e.getMessage());
        }
        return AjaxResponse.success(map);
    }
}
