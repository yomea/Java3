package com.pinglun.mapper;

import com.pinglun.pojo.TbPinglun;
import com.pinglun.pojo.TbPinglunExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPinglunMapper {
    int countByExample(TbPinglunExample example);

    int deleteByExample(TbPinglunExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPinglun record);

    int insertSelective(TbPinglun record);

    List<TbPinglun> selectByExampleWithBLOBs(TbPinglunExample example);

    List<TbPinglun> selectByExample(TbPinglunExample example);

    TbPinglun selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPinglun record, @Param("example") TbPinglunExample example);

    int updateByExampleWithBLOBs(@Param("record") TbPinglun record, @Param("example") TbPinglunExample example);

    int updateByExample(@Param("record") TbPinglun record, @Param("example") TbPinglunExample example);

    int updateByPrimaryKeySelective(TbPinglun record);

    int updateByPrimaryKeyWithBLOBs(TbPinglun record);

    int updateByPrimaryKey(TbPinglun record);
}