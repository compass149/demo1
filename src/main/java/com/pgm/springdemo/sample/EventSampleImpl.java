package com.pgm.springdemo.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("event")
public class EventSampleImpl implements  ISampleDAO{
}
