package com.example.demo;

import com.example.demo.bean.forRequest.PathParameterForm;
import com.example.demo.bean.forRequest.QueryParameterForm;
import com.example.demo.entity.TSchedule;
import com.example.demo.repository.TScheduleRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

@Api(value = "スケジュール参照", tags = {"schedule"})
@RestController
@RequestMapping("api")
public class ScheduleController {

    @Autowired
    TScheduleRepository tScheduleRepository;

    @ApiOperation(value = "スケジュール取得(月)", notes = "基準日から一ヶ月分のスケジュールを取得します。", response = TSchedule.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "基準日", required = true, paramType = "path"),
            @ApiImplicitParam(name = "format", value = "返却形式", paramType = "query", defaultValue = "json"),
            @ApiImplicitParam(name = "userId", value = "ユーザーＩＤ", required = true, paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 401, message = "ユーザーＩＤが登録されていません。"),
            @ApiResponse(code = 403, message = "データが登録されていません。"),
            @ApiResponse(code = 404, message = "URLが間違っています。")
    })
    @RequestMapping(value = "schedule/month/{date}", method = RequestMethod.GET)
    public List<TSchedule> getMonth(@ApiIgnore@PathVariable PathParameterForm pathForm, @ApiIgnore QueryParameterForm queryForm) {
        Page<TSchedule> tSchedule = tScheduleRepository.findAll(new PageRequest(0, 10));
        return tSchedule.getContent();
    }
}
