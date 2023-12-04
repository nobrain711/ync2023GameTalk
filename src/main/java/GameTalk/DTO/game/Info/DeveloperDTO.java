package GameTalk.DTO.game.Info;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeveloperDTO {
    private String name;
    private String url;

    public DeveloperDTO(@JsonProperty("name") String name,
                        @JsonProperty("url") String url) {
        this.name = name;
        this.url = url;
    }
}
