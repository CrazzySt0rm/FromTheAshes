package org.example.dto;

import lombok.Data;

@Data
public class MageDTO {

    private String mageImageUrl;

    private String cloudId;

    private String name;

    private Long power;

    private Long defence;

    private String type;  //physic / magic

    private String element;
}
