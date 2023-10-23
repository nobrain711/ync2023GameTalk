package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "images", schema = "YNC",
        indexes = {@Index(name = "idx_images_game_id", columnList = "game_id"),
                @Index(name = "idx_images_primary_status", columnList = "primary_status")})
@SequenceGenerator(name = "image_seq", sequenceName = "image_seq",
        allocationSize = 1, schema = "YNC")
public class ImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "image_seq")
    @Column(name = "image_id")
    private Long imageId;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id",
            insertable = false, updatable = false)
    private GamesEntity games;

    @Column(name = "url")
    private String url;

    @Column(name = "primary_status", columnDefinition = "NUMBER(1)")
    private Boolean primaryStatus;
}
