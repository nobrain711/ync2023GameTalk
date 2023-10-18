package GameTalk.entity;

import GameTalk.entity.Intermediate.GemeGenerEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@Builder
@Table(name = "geners")
@Entity
@SequenceGenerator(name = "gener_seq", sequenceName = "gener_seq", allocationSize = 1)
public class GenersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gener_seq")
    private Long generId;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "gener")
    private List<GemeGenerEntity> gemeGener;
}
