package com.siedlecki.mateusz.uproszczonaewidencjakosztowbackend.przychod;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "przychod")
public class PrzychodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;
    private Integer price;
    private String info;
}
