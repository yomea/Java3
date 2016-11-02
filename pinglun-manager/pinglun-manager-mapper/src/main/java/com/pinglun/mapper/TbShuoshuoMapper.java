package com.pinglun.mapper;

import com.pinglun.pojo.TbShuoshuo;
import com.pinglun.pojo.TbShuoshuoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbShuoshuoMapper {
    int countByExample(TbShuoshuoExample example);

    int deleteByExample(TbShuoshuoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbShuoshuo record);

    int insertSelective(TbShuoshuo record);

    List<TbShuoshuo> selectByExampleWithBLOBs(TbShuoshuoExample example);

    List<TbShuoshuo> selectByExample(TbShuoshuoExample example);

    TbShuoshuo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbShuoshuo record, @Param("example") TbShuoshuoExample example);

    int updateByExampleWithBLOBs(@Param("record") TbShuoshuo record, @Param("example") TbShuoshuoExample example);

    int updateByExample(@Param("record") TbShuoshuo record, @Param("example") TbShuoshuoExample example);

    int updateByPrimaryKeySelective(TbShuoshuo record);

    int updateByPrimaryKeyWithBLOBs(TbShuoshuo record);

    int updateByPrimaryKey(TbShuoshuo record);
}