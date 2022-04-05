package com.trkj.project_java.mapper;

import com.trkj.project_java.entity.Returngoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface ReturngoodsMapper extends BaseMapper<Returngoods> {
    @Select("select MAX(returnGoods_id) from RETURNGOODS")
    int selectMaxId();


}
