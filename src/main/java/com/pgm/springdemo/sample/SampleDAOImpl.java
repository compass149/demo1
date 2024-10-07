package com.pgm.springdemo.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository //bean을 만들어야 하므로 repository 적어둠
@Primary
public class SampleDAOImpl implements  ISampleDAO{
}
