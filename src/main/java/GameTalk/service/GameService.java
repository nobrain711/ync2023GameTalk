package GameTalk.service;


import GameTalk.DTO.Page.PageRequestDTO;
import GameTalk.DTO.Page.PageResultDTO;
import GameTalk.DTO.game.GameListDTO;
import GameTalk.DTO.game.GameDetailsDTO;
import GameTalk.DTO.game.Info.DeveloperDTO;
import GameTalk.DTO.game.Info.PublishersDTO;
import GameTalk.entity.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface GameService {

    ResponseEntity register(GameDetailsDTO dto);

    GameDetailsDTO get(Long gameId);

    PageResultDTO<GameListDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    default Map<String, Object> dtoToEntity(GameDetailsDTO gameDetailsDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        // serice
        SeriesEntity seriesEntity = SeriesEntity.builder().name(gameDetailsDTO.getSeries()).build();
        entityMap.put("series", seriesEntity);

        // games
        GamesEntity gamesEntity = GamesEntity.builder()
                .title(gameDetailsDTO.getTitle())
                .info(gameDetailsDTO.getInfo())
                .relesaeDate(gameDetailsDTO.getReleaseDate())
                .build();
        entityMap.put("games", gamesEntity);

        // genre
        ArrayList<GenresEntity> genresEntities = new ArrayList<>();
        for (String genre : gameDetailsDTO.getGenres()) {
            genresEntities.add(GenresEntity.builder().name(genre).build());
        }
        entityMap.put("genres", genresEntities);

        // developer
        ArrayList<DevelopersEntity> developersEntities = new ArrayList<>();
        for (DeveloperDTO developer : gameDetailsDTO.getDevelopers()) {
            developersEntities.add(DevelopersEntity.builder().name(developer.getName()).url(developer.getUrl()).build());
        }
        entityMap.put("developers", developersEntities);

        // publisher
        ArrayList<PublishersEntity> publishersEntities = new ArrayList<>();
        for (PublishersDTO publisher : gameDetailsDTO.getPublishers()) {
            publishersEntities.add(PublishersEntity.builder().name(publisher.getName()).url(publisher.getUrl()).build());
        }
        entityMap.put("publisher", publishersEntities);

        // platform
        ArrayList<PlatformEntity> platformEntities = new ArrayList<>();
        for (String platform : gameDetailsDTO.getPlatforms()) {
            platformEntities.add(PlatformEntity.builder().name(platform).build());
        }
        entityMap.put("platform", platformEntities);

        return entityMap;
    }
}
