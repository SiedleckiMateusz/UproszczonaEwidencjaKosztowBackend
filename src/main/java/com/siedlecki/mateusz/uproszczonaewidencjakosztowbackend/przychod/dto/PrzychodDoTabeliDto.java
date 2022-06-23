package com.siedlecki.mateusz.uproszczonaewidencjakosztowbackend.przychod.dto;

import com.siedlecki.mateusz.uproszczonaewidencjakosztowbackend.przychod.PrzychodEntity;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PrzychodDoTabeliDto {
    private Integer id;
    private LocalDate data;
    private Integer kwota;
    private Integer kwotaNarastajacoMiesiecznie;
    private Integer kwotaNarastajacoOdPoczatku;
    private String info;

    public PrzychodDoTabeliDto(PrzychodEntity p) {
        this.id = p.getId();
        this.data = p.getDate();
        this.kwota = p.getPrice();
        this.info = p.getInfo();
    }

    public void setKwotaNarastajacoMiesiecznie(Integer kwotaNarastajacoMiesiecznie) {
        this.kwotaNarastajacoMiesiecznie = kwotaNarastajacoMiesiecznie;
    }

    public void setKwotaNarastajacoOdPoczatku(Integer kwotaNarastajacoOdPoczatku) {
        this.kwotaNarastajacoOdPoczatku = kwotaNarastajacoOdPoczatku;
    }
}
