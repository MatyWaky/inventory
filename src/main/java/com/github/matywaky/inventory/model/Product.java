package com.github.matywaky.inventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String name;

    private Long price;

    @Column(nullable = false, name = "added_date")
    private Date addedDate;

    @Column(name = "removed_date")
    private Date removedDate;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_category"), nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "localization_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_localization"), nullable = false)
    private Localization localization;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_employee"), nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_status"), nullable = false)
    private Status status;

    @Column(name = "serial_number", length = 30)
    private String serialNumber;

    @Column(name = "inventory_number", length = 30, nullable = false)
    private String inventoryNumber;

    @Column(name = "document", length = 30, nullable = false)
    private String document;
}
