package com.ramesh.eCommerce.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @NonNull
    @Column(unique = true)
    private String catagoryId;

    @ManyToMany
    private Category perentCatagory;


    private Integer level;

}
