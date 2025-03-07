package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "archer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Archer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String archerImageUrl;

    private String cloudId;

    private String name;

    private long power;

    private long defence;

    private String type;  //physic / magic

    private String element;

}
