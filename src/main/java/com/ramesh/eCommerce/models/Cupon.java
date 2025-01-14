package com.ramesh.eCommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private double discountPercentage;

    private LocalDate velidityStartDate;

    private LocalDate velidityEndDate;

    private double minimumOrderValue;

    private boolean isActive = true;

    @ManyToMany(mappedBy = "usedCupon")
    private Set<User> usedByUsers = new HashSet<>();



}
