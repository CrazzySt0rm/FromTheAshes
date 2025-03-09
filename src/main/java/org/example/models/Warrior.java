package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "warrior")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Warrior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String warriorImageUrl;

    private String cloudId;

    private String name;

    private Long power;

    private Long defence;

    private String type;  //physic / magic

    private String element;

}
