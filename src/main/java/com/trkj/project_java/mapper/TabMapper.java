package com.trkj.project_java.mapper;

import com.trkj.project_java.entity.Tab;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-03-30
 */
@Mapper
public interface TabMapper extends BaseMapper<Tab> {
    public String selectDJBH(@Param("id") int tabId);

    public String selectName(@Param("id") int tabId);

    public List<Tab> selectLikeName(@Param("name") String name,@Param("method") String method);

    public List<Tab> selectLikeName2(@Param("name") String name,@Param("method") String method);
}
