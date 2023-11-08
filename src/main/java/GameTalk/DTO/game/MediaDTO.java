package GameTalk.DTO.game;

/*
 * url: 미디어 주소
 * primary: 미디어 중 사진이 표지 사진인지 여부
 * DB에는 int로 저장이 됨 0이면 false 1이면 ture
 * */
public class MediaDTO {
    private String url;
    private Boolean primary;

    public MediaDTO(String url, Boolean primary) {
        this.url = url;
        this.primary = primary;
    }
}
