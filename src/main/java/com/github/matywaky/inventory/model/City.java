package com.github.matywaky.inventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 50)
    private String code;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_country"), nullable = false)
    private Country country;
}
