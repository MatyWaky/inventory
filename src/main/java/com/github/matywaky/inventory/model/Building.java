package com.github.matywaky.inventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "street", nullable = false)
    private String street;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_city"), nullable = false)
    private City city;
}
