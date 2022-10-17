package com.siedlecki.mateusz.uproszczonaewidencjakosztowbackend.przychod.dto;

import com.siedlecki.mateusz.uproszczonaewidencjakosztowbackend.przychod.PrzychodEntity;
import lombok.Getter;

import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DaneDoTabeliDto {
    private Integer przychodCalkowity = 0;
    private Integer sredniaDziennie = 0;
    private final List<PrzychodDoTabeliDto> przychodyDoTabeliList = new ArrayList<>();

    public DaneDoTabeliDto(List<PrzychodEntity> przychodEntityList) {
        Month miesiac = null;
        int sumaMiesieczna = 0;
        przychodEntityList = przychodEntityList.stream()
                .sorted(Comparator.comparing(PrzychodEntity::getDate))
                .collect(Collectors.toList());
        for (PrzychodEntity p: przychodEntityList){
            PrzychodDoTabeliDto dto = new PrzychodDoTabeliDto(p);
            przychodCalkowity +=dto.getKwota();
            if (miesiac == dto.getData().getMonth()){
                sumaMiesieczna += dto.getKwota();
            }else {
                miesiac = dto.getData().getMonth();
                sumaMiesieczna = dto.getKwota();
            }
            dto.setKwotaNarastajacoMiesiecznie(sumaMiesieczna);
            dto.setKwotaNarastajacoOdPoczatku(przychodCalkowity);
            przychodyDoTabeliList.add(dto);
        }

        przychodyDoTabeliList.sort(Comparator.comparing(PrzychodDoTabeliDto::getData).reversed());

        if (!przychodyDoTabeliList.isEmpty()){
            sredniaDziennie = przychodCalkowity/przychodyDoTabeliList.size();
        }
    }
}
