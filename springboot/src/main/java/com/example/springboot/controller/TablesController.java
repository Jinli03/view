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
        queryWrapper.select("school", "city", "square", "pic"); // 选择要查询的字段
        queryWrapper.groupBy("school", "city", "square", "pic"); // 使用 GROUP BY 子句确保相同学校下的城市和地区也相同
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


    @GetMapping("/distinctSchool/{school}")
    public Result distinctSchools(@PathVariable String school) {
        List<Tables> schoolInfo = tablesService.list(Wrappers.<Tables>lambdaQuery()
                .eq(Tables::getSchool, school));

        // 根据 sub 属性进行分组
        Map<String, List<Tables>> groupedBySub = schoolInfo.stream()
                .collect(Collectors.groupingBy(Tables::getSub));

        // 提取每个分组中的招收人数列表
        Map<String, List<Integer>> personGroups = new HashMap<>();
        for (Map.Entry<String, List<Tables>> entry : groupedBySub.entrySet()) {
            List<Tables> tablesList = entry.getValue();
            List<Integer> personList = new ArrayList<>();
            for (Tables tables : tablesList) {
                personList.add(tables.getPerson21());
                personList.add(tables.getPerson22());
                personList.add(tables.getPerson23());
                // 您可以继续根据需要添加更多的 person 属性
            }
            personGroups.put(entry.getKey(), personList);
        }

        // 提取每个分组中的复试人数列表
        Map<String, List<Integer>> repersonGroups = new HashMap<>();
        for (Map.Entry<String, List<Tables>> entry : groupedBySub.entrySet()) {
            List<Tables> tablesList = entry.getValue();
            List<Integer> repersonList = new ArrayList<>();
            for (Tables tables : tablesList) {
                repersonList.add(tables.getReperson21());
                repersonList.add(tables.getReperson22());
                repersonList.add(tables.getReperson23());
                // 您可以继续根据需要添加更多的 reperson 属性
            }
            repersonGroups.put(entry.getKey(), repersonList);
        }

        // 提取每个分组中的复试分数线列表
        Map<String, List<Integer>> rescoreGroups = new HashMap<>();
        for (Map.Entry<String, List<Tables>> entry : groupedBySub.entrySet()) {
            List<Tables> tablesList = entry.getValue();
            List<Integer> rescoreList = new ArrayList<>();
            for (Tables tables : tablesList) {
                rescoreList.add(tables.getRescore21());
                rescoreList.add(tables.getRescore22());
                rescoreList.add(tables.getRescore23());
                // 您可以继续根据需要添加更多的 rescore 属性
            }
            rescoreGroups.put(entry.getKey(), rescoreList);
        }

        // 构建返回结果
        Map<String, Object> result = new HashMap<>();
        result.put("personGroups", personGroups);
        result.put("repersonGroups", repersonGroups);
        result.put("rescoreGroups", rescoreGroups);

        return Result.success(result);
    }

}
