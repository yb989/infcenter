package com.yph.infcenter.mapper;

import com.yph.infcenter.entity.InterfaceLog;

public interface InterfaceLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InterfaceLog record);

    int insertSelective(InterfaceLog record);

    InterfaceLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InterfaceLog record);

    int updateByPrimaryKey(InterfaceLog record);
}