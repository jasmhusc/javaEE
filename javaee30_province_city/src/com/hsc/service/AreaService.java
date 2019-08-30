package com.hsc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsc.dao.IAreaDao;
import com.hsc.entity.Area;
import com.hsc.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AreaService {
    /**
     * 查询所有的某 1 级的省份或城市
     */
    public String findCities(int id) throws JsonProcessingException {
        // 查询数据
        SqlSession session = MybatisUtils.getSession();
        IAreaDao areaDao = session.getMapper(IAreaDao.class);
        List<Area> cities = areaDao.findCities(id);
        MybatisUtils.closeSession(session);

        // 转换为json
        String json = new ObjectMapper().writeValueAsString(cities);
        return json;
    }
}
