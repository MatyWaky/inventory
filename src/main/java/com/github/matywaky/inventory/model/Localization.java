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

    @Column(name = "room", length = 30, unique = true)
    private String room;

    @ManyToOne
    @JoinColumn(name = "building_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_building"), nullable = false)
    private Building building;
}
