package GameTalk.DTO.game.Info;

import lombok.Data;

@Data
public class PublishersDTO {
    private String name;
    private String url;

    public PublishersDTO(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
