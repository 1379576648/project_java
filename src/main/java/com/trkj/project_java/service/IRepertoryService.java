package com.trkj.project_java.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.project_java.entity.Repertory;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface IRepertoryService  {

    /**
     * 高预警查询-xho
     * @return
     */
    IPage<Repertory> selectIPageRepertory(Repertory repertory);

    /**
     * 低预警查询-xho
     * @return
     */
    IPage<Repertory> selectIPageRepertorys(Repertory repertory);

}
