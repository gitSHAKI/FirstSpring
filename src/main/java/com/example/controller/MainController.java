package com.example.controller;

import com.example.dao.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class MainController {

    @Autowired
    private MyDao myDao;

    @PutMapping("/")
    @ResponseBody
    public ResponseEntity<String> saveData(@RequestBody Map<String, String> requestData) {
        String today = requestData.get("today");
        String todo = requestData.get("todo");
        myDao.saveData(today, todo);
        return ResponseEntity.ok("Data saved successfully!");
    }
    @GetMapping("/data")
    @ResponseBody
    public String getData() {
        //DAO를 사용하여 데이터베이스에서 리스트로 된 데이터 가져옴
        List<String> data = myDao.fetchData();
        return data.toString();
    }
}