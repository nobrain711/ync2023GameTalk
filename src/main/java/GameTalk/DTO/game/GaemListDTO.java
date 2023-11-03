package GameTalk.DTO.game;

import lombok.ToString;

import java.time.LocalDate;
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
    //    private List<String> developers;
//    private List<String> publishers;
    private List<String> platforms;

    private List<String> ListDistinct (List<String> list){
        return list.stream().distinct().collect(Collectors.toList());
    }
    public GaemListDTO(Long gameId, String title, LocalDate releaseDate, String series,
//                       , List<String> developers, List<String> publishers,
                       List<String> genres, List<String> platforms
    ) {
        this.gameId = gameId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.series = series;
        this.genres = ListDistinct(genres);
//        this.developers = developers;
//        this.publishers = publishers;
        this.platforms = ListDistinct(platforms);
        //        this.gameInfoDTO = new GameInfoDTO(genres, publishers, platforms, developers);
    }
}
