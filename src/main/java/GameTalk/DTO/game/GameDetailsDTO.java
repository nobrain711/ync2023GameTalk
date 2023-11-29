package GameTalk.DTO.game;

import GameTalk.DTO.game.Info.DeveloperDTO;
import GameTalk.DTO.game.Info.PublishersDTO;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * gameId: 게임 식별 번호
 * title: 게임 제목
 * info: 게임 설명
 * releaseDate: 게임 출시일
 * series: 게임 시리즈
 * genres: 게임 장르
 * publishers: 게임 배급사
 * developers: 게임 개발사
 * platforms: 게임 플레이 가능한 플랫폼
 * dlcs: 게임 DLC 혹은 DLC의 부모게임
 */
@Data
public class GameDetailsDTO {
    private Long gameId;
    private String title;
    private String info;
    private LocalDate releaseDate;
    private String series;
    private List<String> genres;
    private List<DeveloperDTO> developers;
    private List<PublishersDTO> publishers;
    private List<String> platforms;
//    private List<Long> dlcs;

    public GameDetailsDTO(Long gameId, String title, String info, LocalDate releaseDate, String series,
                       List<String> genres, List<DeveloperDTO> developer, List<PublishersDTO> publishers, List<String> platfroms){
        this.gameId =gameId;
        this.title = title;
        this.info = info;
        this.releaseDate = releaseDate;
        this.series = series;
        this.genres = genres;
        this.developers = developer;
        this.publishers = publishers;
        this.platforms = platfroms;
    }

    public GameDetailsDTO(Long gameId, String title, String info, LocalDate releaseDate,
                          String series, String genres, String developers, String publishers, String platforms) {
        this.gameId = gameId;
        this.title = title;
        this.info = info;
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
