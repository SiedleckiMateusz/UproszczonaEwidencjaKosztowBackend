package com.siedlecki.mateusz.uproszczonaewidencjakosztowbackend.przychod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PrzychodRepository extends JpaRepository<PrzychodEntity,Integer> {

}
