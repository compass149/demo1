package com.pgm.springdemo.sample;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleDTO {
    private String name;
    private int age;
    private String[] hobby;
}
