package GameTalk.DTO.game.Info;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PublishersDTO {
    private String name;
    private String url;

    public PublishersDTO(@JsonProperty("name") String name,
                         @JsonProperty("url") String url) {
        this.name = name;
        this.url = url;
    }
}
