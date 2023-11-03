package GameTalk.DTO.game;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
public class GameDetailsDTO {
    private Long gameId;
    private String title;
    private String info;
    private Date releaseDate;
    private String series;
    private List<String> genres;
    private List<String> publishers;
    private List<String> developers;
    private List<String> platforms;
    private List<Long> dlcs;
}
