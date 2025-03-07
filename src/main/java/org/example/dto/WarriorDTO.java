package org.example.dto;

import lombok.Data;

@Data
public class WarriorDTO {

    private String warriorImageUrl;

    private String cloudId;

    private String name;

    private long power;

    private long defence;

    private String type;  //physic / magic

    private String element;
}
