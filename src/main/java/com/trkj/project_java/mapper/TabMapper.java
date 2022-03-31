package com.trkj.project_java.mapper;

import com.trkj.project_java.entity.Tab;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.graalvm.compiler.core.match.MatchableNode;

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
    public String selectDJBH(int receivableId);
}
