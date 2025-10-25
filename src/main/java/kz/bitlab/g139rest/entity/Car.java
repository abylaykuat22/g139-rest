package kz.bitlab.g139rest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CARS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL", unique = true)
    private String model;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "VOLUME")
    private Double volume;
}
