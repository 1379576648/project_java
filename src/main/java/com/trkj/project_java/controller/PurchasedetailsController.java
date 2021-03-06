package com.trkj.project_java.controller;


import com.trkj.project_java.entity.Purchasedetails;
import com.trkj.project_java.service.IPurchasedetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/purchasedetails")
public class PurchasedetailsController {
    @Autowired
    private IPurchasedetailsService iPurchasedetailsService;

    @PostMapping("/addPurchasedetails")
    public int addPurchasedetails(@RequestBody Purchasedetails purchasedetails){
        System.out.println(purchasedetails+".........");
        return iPurchasedetailsService.addPurchasedetails(purchasedetails);
    }

}
