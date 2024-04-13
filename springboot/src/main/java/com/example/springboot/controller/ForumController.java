/**
 * 功能：
 * 作者：JInli
 * 日期： 2024/3/30 23:18
 */
package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Forum;
import com.example.springboot.service.ForumService;
import com.example.springboot.common.AuthAccess;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/forum") //通过/web/hello访问
public class ForumController {
    @Resource
    ForumService forumService;

    @ApiOperation("获取评论数据")
    @GetMapping("/select")
    public Result selectComments() {
        List<Forum> forumList = forumService.list(new QueryWrapper<Forum>().orderByDesc("id"));
        return Result.success(forumList);
    }
}
