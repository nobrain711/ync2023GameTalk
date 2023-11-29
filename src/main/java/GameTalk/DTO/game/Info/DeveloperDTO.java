package GameTalk.DTO.game.Info;

import lombok.Data;

@Data
public class DeveloperDTO {
    private String name;
    private String url;

    public DeveloperDTO(String name, String url){
        this.name = name;
        this.url = url;
    }
}
