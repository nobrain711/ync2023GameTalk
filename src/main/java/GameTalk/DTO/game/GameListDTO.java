package GameTalk.DTO.game;

import lombok.ToString;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
@ToString
public class GameListDTO {
    private Long gameId;
    private String title;
    private LocalDate releaseDate;
    private String series;
    private List<String> genres;
    private List<String> developers;
    private List<String> publishers;
    private List<String> platforms;

    private List<String> stringToList(String input) {
        List<String> result;
        if (input.contains("\" ") == true && input != null) {
            result = Arrays.asList(input.split("\" "));
        } else {
            result = Arrays.asList(input);
        }
        return result;
    }

    public GameListDTO(Long gameId, String title, LocalDate releaseDate, String series,
                       String genres, String developers,
                       String publishers, String platforms) {
        this.gameId = gameId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.series = series;
        this.genres = stringToList(genres);
        this.developers = stringToList(developers);
        this.publishers = stringToList(publishers);
        this.platforms = stringToList(platforms);
    }
}
