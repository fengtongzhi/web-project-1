package com.feng.controller;

import com.feng.pojo.Dept;
import com.feng.pojo.Result;
import com.feng.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门
     * @return
     */
    @RequestMapping(value = "/depts",method = RequestMethod.GET)//指定请求方式
    public Result list(){
        List<Dept> deptList= deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    @RequestMapping(value = "/depts",method = RequestMethod.DELETE)//指定请求方式
    public Result delete(Integer id){
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 插入数据
     * @param dept
     * @return
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 依据id查找数据
     * @param id
     * @return
     */
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer id){
        Dept dept=deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 更新数据
     * @param dept
     * @return
     */
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }

}
