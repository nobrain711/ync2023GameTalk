package GameTalk.service;


import GameTalk.DTO.Page.PageRequestDTO;
import GameTalk.DTO.Page.PageResultDTO;
import GameTalk.DTO.game.GaemListDTO;
import GameTalk.DTO.game.GameDetailsDTO;
import GameTalk.entity.GamesEntity;

public interface GameService {
    default void dtoToGamesEntity(GameDetailsDTO dto) {

        // games
        GamesEntity games = GamesEntity.builder()
                .title(dto.getTitle())
                .info(dto.getInfo())
                .relesaeDate(dto.getReleaseDate())
                .build();
    }

    void register(GameDetailsDTO dto);
    GameDetailsDTO get(Long gameId);

    PageResultDTO<GaemListDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
}
