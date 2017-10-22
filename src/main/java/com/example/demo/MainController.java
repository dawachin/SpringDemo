package com.example.demo;

import com.example.demo.entity.TSchedule;
import com.example.demo.form.ScheduleForm;
import com.example.demo.repository.TScheduleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    TScheduleRepository tScheduleRepository;

    @RequestMapping("/home")
    public String mainpage(Model model) {
        return "mainpage";
    }

    @RequestMapping("/regist")
    public String registpage(Model model) {
        return "regist";
    }

    @RequestMapping("/test")
    public String testpage(Model model) {
        System.out.println("[START] データベースに接続してデータを取得します。");
        Page<TSchedule> tSchedule = tScheduleRepository.findAll(new PageRequest(0, 10));
        for (TSchedule schedule : tSchedule) {
            System.out.println(schedule.getLocation());
        }
        System.out.println("[END  ] データベースに接続してデータを取得します。");
        model.addAttribute("message", "Hello Thymeleaf!!");
        model.addAttribute("tSchedule", tSchedule);
        return "test";
    }

    @ModelAttribute
    ScheduleForm setUpForm() {
        return new ScheduleForm();
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    String view(@Validated ScheduleForm scheduleForm, BindingResult result, Model model) {
        TSchedule tSchedule = new TSchedule();
        BeanUtils.copyProperties(scheduleForm, tSchedule);
        model.addAttribute("tSchedule", tSchedule);

        return "view";
    }


}