package com.sourabh.onlineticketbooking.repository;//package com.sourabh.booking.repository;

import com.sourabh.onlineticketbooking.model.Enum.City;
import com.sourabh.onlineticketbooking.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre,Integer> {

    @Query(value = "SELECT * FROM THEATRE where CITY=:#{#city?.name()}",nativeQuery = true)
    List<Theatre> findByCity(@Param("city") City city);
}
