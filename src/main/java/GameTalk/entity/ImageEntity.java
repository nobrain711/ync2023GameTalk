package GameTalk.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "images")
@SequenceGenerator(name = "image_seq", sequenceName = "image_seq", allocationSize = 1)
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iamge_seq")
    @Column(name = "image_id")
    private Long imageId;

    @Column(name = "url", nullable = false, length = 255)
    private String url;
}
