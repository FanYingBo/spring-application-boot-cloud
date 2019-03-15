package com.study.selfs.gupao.springboot.test;


import com.study.selfs.gupao.springboot.jdbc.SpringBootDataSourceDemo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,classes = SpringBootDataSourceDemo.class)
public class MutliDataSourceTest {

    @Autowired
    @Qualifier("slaveJdbcTemplate")
    private JdbcTemplate slaveJdbcTemplate;
    @Autowired
    @Qualifier("masterJdbcTemplate")
    private JdbcTemplate masterJdbcTemplate;

    @Before
    public void init(){

    }

    @Test
    public void testDataSourceTransaction(){
        masterJdbcTemplate.execute("INSERT INTO tb_normal_custom(name,age,sex,createdate) values ('albb',23,1,'2018-10-23 20:00:10')");
        slaveJdbcTemplate.execute("INSERT INTO tb_normal_custom(name,age,sex,createdate) values ('albbd',23,1,'2018-10-23 20:01:10')");

    }
}
