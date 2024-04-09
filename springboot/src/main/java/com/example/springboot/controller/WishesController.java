/**
 * 功能：
 * 作者：JInli
 * 日期： 2024/4/5 23:49
 */
package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Wishes;
import com.example.springboot.service.WishesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/wishes")
public class WishesController {

    @Resource
    WishesService wishesService;

    @PutMapping("/save")
    public Result save(@RequestBody Wishes wish) {
        // 检查是否存在与要添加的记录相同的记录
        List<Wishes> existingWishes = wishesService.list(Wrappers.<Wishes>lambdaQuery()
                        .eq(Wishes::getSchool, wish.getSchool())
                        .eq(Wishes::getSub, wish.getSub())
                        .eq(Wishes::getCity, wish.getCity())
                // 按需添加其他条件
        );

        if (!existingWishes.isEmpty()) {
            // 如果存在相同记录，则不执行保存操作
            return Result.error("Record already exists.");
        }else{
            // 执行保存操作
            wishesService.save(wish);
            return Result.success("Wish saved successfully.");
        }
    }

    @GetMapping("/selectThree")
    public Result selectThreeSchools(@RequestParam String name) {
        // 查询数据库中符合条件的记录，并随机排序，选择前三条记录
        List<Wishes> wishesList = wishesService.list(Wrappers.<Wishes>lambdaQuery()
                .eq(Wishes::getName, name)
                .orderByAsc(Wishes::getId)
                .last("LIMIT 3")
        );

        // 如果查询结果不为空，则返回成功结果和查询结果；否则，返回失败结果
        if (!wishesList.isEmpty()) {
            return Result.success(wishesList);
        } else {
            return Result.error("No records found.");
        }
    }

    @GetMapping("/selectAll/{name}")
    public Result selectAllSchools(@PathVariable String name) {
        QueryWrapper<Wishes> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);

        // 执行查询
        List<Wishes> wishesList = wishesService.list(queryWrapper);

        // 返回结果
        return Result.success(wishesList);
    }
}