package com.sourabh.onlineticketbooking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Lock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theatre_id", referencedColumnName = "id")
    private Theatre theatre;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private  Movie movie;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "screen_id", referencedColumnName = "id")
    private  Screen screen;
    @Column(name = "startTime")
    private Date startTime;
    @Version
    private Integer version;

}
