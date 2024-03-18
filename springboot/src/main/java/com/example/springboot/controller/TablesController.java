/**
 * 功能：
 * 作者：JInli
 * 日期： 2024/2/17 11:21
 */
package com.example.springboot.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.AuthAccess;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Tables;
import com.example.springboot.entity.User;
import com.example.springboot.service.TablesService;
import com.example.springboot.service.UserService;
import com.example.springboot.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/tables") //通过/web/hello访问
public class TablesController {

    @Resource
    TablesService tablesService;

    @Autowired
    UserService userService;

    @AuthAccess //token放行
    @PostMapping("/add")
    public Result add(@RequestBody Tables tables) {
        User currentUser = TokenUtils.getCurrentUser();
        tables.setUserId(currentUser.getId());
        tablesService.save(tables);
        return Result.success();
    }

    //更新
    @PutMapping("/update")
    public Result update(@RequestBody Tables table) {
        tablesService.updateById(table);
        return Result.success();
    }

    //单个删除
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        tablesService.removeById(id);
        return Result.success();
    }

    //批量删除
    @DeleteMapping("/delete/batch")
    public Result batchdelete(@RequestBody List<Integer> ids) {
        tablesService.removeByIds(ids);
        return Result.success();
    }

    //查询全部
    @GetMapping("/select")
    public Result selectNews() {
        List<Tables> tablesList = tablesService.list(new QueryWrapper<Tables>().orderByDesc("id"));
        return Result.success(tablesList);
    }

    //单条件查询
    @GetMapping("/selectById/{id}")
    public Result selectByIdNews(@PathVariable Integer id) {
        Tables tables = tablesService.getById(id);
        return Result.success(tables);
    }


    @GetMapping("/selectByPage")
    public Result selectByPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(name = "square", required = false) String square) {
        QueryWrapper<Tables> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(square), "square", square);
        queryWrapper.select("school", "city", "square"); // 选择要查询的字段
        queryWrapper.groupBy("school", "city", "square"); // 使用 GROUP BY 子句确保相同学校下的城市和地区也相同
        Page<Tables> page = tablesService.page(new Page<>(pageNum, pageSize), queryWrapper);
        List<Tables> records = page.getRecords();
        for (Tables record : records) {
            Integer authorid = record.getUserId();
            User user = userService.getById(authorid);
            if (user != null) {
                record.setUser(user.getName());
            }
        }
        return Result.success(page);
    }

    @GetMapping("/selectBySchool")
    public Result selectBySchool(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam String school) {
        QueryWrapper<Tables> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(school), "school", school);
        Page<Tables> page = tablesService.page(new Page<>(pageNum, pageSize), queryWrapper);
        List<Tables> records = page.getRecords();
        for (Tables record : records) {
            Integer authorid = record.getUserId();
            User user = userService.getById(authorid);
            if (user != null) {
                record.setUser(user.getName());
            }
        }
        return Result.success(page);
    }



    @GetMapping("/charts/{id}")
    public Result charts(@PathVariable Integer id) {
        List<Tables> list = tablesService.list(Wrappers.<Tables>lambdaQuery().eq(Tables::getId, id));
        // 合并 person23、person22 和 person21 的值成一个单一的数组
        List<Integer> combinedData = list.stream()
                .flatMap(table -> Stream.of(table.getPerson21(), table.getPerson22(), table.getPerson23()))
                .collect(Collectors.toList());
        return Result.success(combinedData);
    }

    @GetMapping("/distinctSchools")
    public Result distinctSchools() {
        List<Tables> distinctSchools = tablesService.list(Wrappers.<Tables>lambdaQuery()
                .select(Tables::getSchool, Tables::getCity, Tables::getSquare)
                .groupBy(Tables::getSchool, Tables::getCity, Tables::getSquare));
        return Result.success(distinctSchools);
    }








}
