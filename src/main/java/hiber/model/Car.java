package hiber.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Column
    private String model;
    @Id
    @Column
    private int series;


}
