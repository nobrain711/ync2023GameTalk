package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "stores", schema = "YNC")
@SequenceGenerator(name = "store_seq", sequenceName = "store_seq",
allocationSize = 1, schema = "YNC")
public class StoresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "store_seq")
    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "price")
    private int price;

    @Column(name = "url")
    private String url;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "stores")
    private List<GamesEntity> games;
}
