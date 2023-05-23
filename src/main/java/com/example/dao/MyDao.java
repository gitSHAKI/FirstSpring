package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MyDao {
    //해당 클래스는 Data Access Object, 즉 데이터베이스에 접근하기 위해 생성됨
    @Autowired
    //스프링의 JdbcTemplate 를 사용하여 쿼리를 불러옴
    private JdbcTemplate jdbcTemplate;

    public List<String> fetchData() {
        String columnName;
        Object value;
        String sql = "SELECT * FROM studenttb1";

        //리스트형으로 결과를 매핑하여 Map에 속성이름과 값을(Object)형으로 넣음
        List<Map<String, Object>> tableData = jdbcTemplate.queryForList(sql);
        //메서드에 맞는 반환값을 받기 위한, 하나의 문자열로 출력하기 위한 리스트
        List<String> result = new ArrayList<>();
        //리스트에 Map에 있는 값을 전부 내부클래스 Entry 를 통해 추가
        for (Map<String, Object> row : tableData) {
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                columnName = entry.getKey();
                value = entry.getValue();
                result.add(columnName + " : " + value);
            }
        }
        return result;
    }

}
