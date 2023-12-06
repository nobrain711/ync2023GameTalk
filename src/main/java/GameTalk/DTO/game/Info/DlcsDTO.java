package GameTalk.DTO.game.Info;

import lombok.Data;

import java.util.List;

@Data
public class DlcsDTO {
    /* 변수 설명
    @dlc_status: 게임 dlc 여부
    @gameId: 게임 아이디 부모이든 자식이든 등록 List<Long>로 하느 이유는 어려개 대응
    @gameTitle: 게임 타이틀 게임 등록시 사용 위에 와 같은 이유로 사용
    */
    private Integer dlc_status;
    private List<Long> gameId;
    private List<String> gameTitle;
    
    /*Entity to DTO
    * 엔터티 조회시 작동*/
    public DlcsDTO(Integer dlc_status, List<Long> gameId, List<String> gameTitle) {
        this.dlc_status = dlc_status;
        this.gameId = gameId;
        this.gameTitle = gameTitle;
    }

    /* DTO to Entity
    * 엔터로 변환시 사용*/
    public DlcsDTO(Integer dlc_status, List<String> gameTitle) {
        this.dlc_status = dlc_status;
        this.gameTitle = gameTitle;
    }
}
