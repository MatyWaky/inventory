package com.github.matywaky.inventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "localizations")
public class Localization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String room;

    @ManyToOne
    @JoinColumn(name = "building_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_building"), nullable = false)
    private Building building;
}
