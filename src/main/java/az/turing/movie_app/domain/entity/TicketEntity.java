package az.turing.movie_app.domain.entity;

import az.turing.movie_app.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ticket_seq")
    @SequenceGenerator(name="ticket_seq",sequenceName = "ticket_seq",allocationSize = 1)
    private Long id;

    @Column(name="ticket_number",nullable = false,unique = true)
    private String ticketNumber;

    @Column(name="price",nullable = false)
    private Double price;

    @Column(name="status",nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="movie_id",nullable = false)
    private MovieEntity movie;

}
