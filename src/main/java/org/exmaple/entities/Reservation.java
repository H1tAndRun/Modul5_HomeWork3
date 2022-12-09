package org.exmaple.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NonNull
    private Integer reservationNumber;

    @ManyToOne
    @JoinColumn(name = "name_room", referencedColumnName = "id", nullable = false)
    @NonNull
    private Room room;

    @Column(nullable = false)
    @NonNull
    private Date beginDate;

    @Column(nullable = false)
    @NonNull
    private Date endDate;

    @Column(nullable = false)
    @NonNull
    private String nameBuyer;
}
