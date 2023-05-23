package com.example.controller;

import com.example.dao.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class MainController {

    @Autowired
    private MyDao myDao;
    @GetMapping("/data")
    @ResponseBody
    public String getData() {
        //DAO를 사용하여 데이터베이스에서 리스트로 된 데이터 가져옴
        List<String> data = myDao.fetchData();

        return data.toString();
    }
}
