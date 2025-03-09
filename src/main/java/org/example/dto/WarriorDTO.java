package org.example.dto;

import lombok.Data;

@Data
public class WarriorDTO {

    private String warriorImageUrl;

    private String cloudId;

    private String name;

    private Long power;

    private Long defence;

    private String type;  //physic / magic

    private String element;
}
