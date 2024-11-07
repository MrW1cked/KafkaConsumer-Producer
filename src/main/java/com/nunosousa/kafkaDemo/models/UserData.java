package com.nunosousa.kafkaDemo.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserData {
    private String id;
    private String name;
    private String email;
    private String source;
}
