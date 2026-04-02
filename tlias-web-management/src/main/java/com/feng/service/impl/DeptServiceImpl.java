package com.feng.service.impl;

import com.feng.mapper.DeptMapper;
import com.feng.pojo.Dept;
import com.feng.service.DeptService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    /**
     * 删除部门
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    /**
     * 插入数据
     * @param dept
     */
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
