package com.hsc.dao;

import com.hsc.entity.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IAreaDao {
    /**
     * 查询所有的某 1 级的省份或城市
     */
    @Select("SELECT * FROM area WHERE pid=#{pid};")
    List<Area> findCities(int pid);
}
