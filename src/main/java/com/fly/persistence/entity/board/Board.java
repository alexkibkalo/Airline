package com.fly.persistence.entity.board;

import com.fly.persistence.entity.filght.Flight;
import com.fly.persistence.entity.general.IdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "board")
public class Board extends IdEntity {

    @Column(nullable = false)
    private String aircraft;

    @Column(nullable = false, unique = true)
    private String registration;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String issue;

    @Column(nullable = false)
    private String airline;

    @Column(columnDefinition = "BYTEA")
    private byte[] photo;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private boolean available;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Flight> flights;
}
