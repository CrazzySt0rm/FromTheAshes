package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "mage")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //url фото/изображения
    private String mageImageUrl;

    private String cloudId;

    private String name;

    private Long power;

    private Long defence;

    private String type;  //physic / magic

    private String element;
}
