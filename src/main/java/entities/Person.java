package entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name = "Personne")
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "nom")
    private String name ;
    @Column(unique = true)
    private String email ;
    private int age ;
}
