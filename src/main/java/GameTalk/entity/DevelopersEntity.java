package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "developers", schema = "YNC")
@SequenceGenerator(name = "developer_seq",
        sequenceName = "developer_seq", allocationSize = 1)
public class DevelopersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "developer_seq")
    @Column(name = "developer_id")
    private Long developerId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "url")
    private String url;
}
