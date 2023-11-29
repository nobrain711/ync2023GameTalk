package GameTalk.DTO.game;

import GameTalk.DTO.game.Info.DeveloperDTO;
import GameTalk.DTO.game.Info.PublishersDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * gameId: 게임 식별 번호
 * title: 게임 제목
 * releaseDate: 게임 출시일
 * series: 게임 시리즈
 * genres: 게임 장르
 * publishers: 게임 배급사
 * developers: 게임 개발사
 * platforms: 게임 플레이 가능한 플랫폼
 * dlcs: 게임 DLC 혹은 DLC의 부모게임
 */
@Data
public class GameListDTO {
    private Long gameId;
    private String title;
    private LocalDate releaseDate;
    private String series;
    private List<String> genres;
    private List<DeveloperDTO> developers;
    private List<PublishersDTO> publishers;
    private List<String> platforms;

    public GameListDTO(Long gameId, String title, LocalDate releaseDate, String series,
                       String genres, String developers,
                       String publishers, String platforms) {
        this.gameId = gameId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.series = series;
        this.genres = List.of(genres.split(","));
        this.developers = Arrays.stream(developers.split(","))
                .map(pair -> {
                    String[] parts = pair.split("@");
                    return new DeveloperDTO(parts[0], parts[1]);
                }).collect(Collectors.toList());
        this.publishers = Arrays.stream(publishers.split(","))
                .map(pair -> {
                    String[] parts = pair.split("@");
                    return new PublishersDTO(parts[0], parts[1]);
                }).collect(Collectors.toList());
        this.platforms = List.of(platforms.split(","));
    }
}
