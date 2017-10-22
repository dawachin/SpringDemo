package com.example.demo;

import com.example.demo.entity.TSchedule;
import com.example.demo.repository.TScheduleRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ScheduleController {

    @Autowired
    TScheduleRepository tScheduleRepository;

    @ApiOperation(value = "スケジュール取得", notes = "スケジュール一覧を取得します。")
    @RequestMapping(value = "schedule", method = RequestMethod.GET)
    public List<TSchedule> getScheduleList() {
        Page<TSchedule> tSchedule = tScheduleRepository.findAll(new PageRequest(0, 10));
        return tSchedule.getContent();
    }

    @ApiOperation(value = "スケジュール取得", notes = "`基準日から１週間分のスケジュール一覧を取得します。")
    @RequestMapping(value = "schedule/{date}", method = RequestMethod.GET)
    public List<TSchedule> getScheduleList(@PathVariable String date) {
        Page<TSchedule> tSchedule = tScheduleRepository.findAll(new PageRequest(0, 10));
        return tSchedule.getContent();
    }
}
