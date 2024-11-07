package com.nunosousa.kafkaDemo.event;

import com.nunosousa.kafkaDemo.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEvent implements Serializable {
    private EventType eventType;
    private Long timestamp;

    private String id;
    private String name;
    private String description;
    private String source;
}
