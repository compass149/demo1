package com.pgm.springdemo.sample;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString
public class SampleService {
    @Autowired
    private SampleDAO sampleDAO;

    @Autowired
    private ISampleDAO sampleDAOImpl; //아무 것도 안 적으면 primary로 되어있는 객체를 주입받음

    @Autowired
    @Qualifier("event") //event라는 qualifier가 있는 것을 주입받음
    private ISampleDAO eventSampleDAO;

}
