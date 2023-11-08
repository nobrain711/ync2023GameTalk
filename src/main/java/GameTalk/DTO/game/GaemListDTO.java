package GameTalk.DTO.game;

import lombok.ToString;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
 * gameId: 게임 식별 번호
 * title: 게임 제목
 * releaseDate: 게임 출시일
 * GameInfoDto: 장르, 개발사, 배급사, dlc 정보
 */
@ToString
public class GaemListDTO {
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
        if(input.contains("\" ") == true && input != null){
            result = Arrays.asList(input.split("\" "));
        }else {
            result = Arrays.asList(input);
        }
        return result;
    }

    public GaemListDTO(Long gameId, String title, LocalDate releaseDate, String series,
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
