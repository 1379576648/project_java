package com.trkj.project_java.mapper;

import com.trkj.project_java.entity.Paymenttab;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
public interface PaymenttabMapper extends BaseMapper<Paymenttab> {
    public String selectDJBH(@Param("id") int payId);

    public String selectName(@Param("id") int payId);

    public List<Paymenttab> selectLikeName(@Param("name") String name,@Param("method") String method);

    public List<Paymenttab> selectLikeName2(@Param("name") String name,@Param("method") String method);
}
