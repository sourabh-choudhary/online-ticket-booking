package com.sourabh.onlineticketbooking.repository;

import com.sourabh.onlineticketbooking.model.Show;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show,Long> {
//    @Lock(LockModeType.OPTIMISTIC)
//    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value   ="120000")})
    @Override
    Optional<Show> findById(Long aLong);
}
