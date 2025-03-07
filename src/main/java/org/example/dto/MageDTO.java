package org.example.dto;

import lombok.Data;

@Data
public class MageDTO {

    private String mageImageUrl;

    private String cloudId;

    private String name;

    private long power;

    private long defence;

    private String type;  //physic / magic

    private String element;
}
