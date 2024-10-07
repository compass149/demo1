package com.pgm.springdemo.sample;

import com.pgm.springdemo.config.AppConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
@ExtendWith({SpringExtension.class})
//@ContextConfiguration(classes = AppConfig.class)
@ContextConfiguration(locations = {"/test-context.xml", "file:src/main/webapp/WEB-INF/root-context.xml"})
//@RequiredArgsConstructor

public class SampleTest {
    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private SampleService sampleService;

    //@Autowired
    //@Qualifier("myDto1")
    //private final SampleDTO sampleDTO1; //final로 상수화시키면 autoWired하면 오류 뜸 (생성자로 주입받음)
    //private SampleDTO sampleDTO1;// 일반 생성자면 autowired로 주입받음

    @Test
    public void testService1(){
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }
    @Test
    public void ConnectionTest() throws Exception {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void setSampleServiceTest() {
        log.info(sampleService);
    }

    @Test
    public void testSample1() {
        //log.info(sampleDTO1);
    }

    @Test
    public void testSample() {
        //기존 방법
        SampleDTO dto = new SampleDTO();
        dto.setAge(20);
        dto.setName("오은호");
        String[] hobbies = {"수영", "자전거 타기"};
        dto.setHobby(hobbies);
        log.info(dto);
    }

    @Test
    public void testSample2() { //요즘에는 이거 안 쓰고 autoWired로 사용함
        ApplicationContext context = new ClassPathXmlApplicationContext("/test-context.xml");
        SampleDTO dto1 = (SampleDTO) context.getBean("sample1");
        log.info(dto1);
        SampleDTO dto2 = (SampleDTO) context.getBean("sample2");
        log.info(dto2);
    }

    @Test
    public void testSample3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SampleDTO dto1 = (SampleDTO) context.getBean("myDto1");
        log.info(dto1);
        SampleDTO dto2 = (SampleDTO) context.getBean("myDto2");
        log.info(dto2);
    }
}
