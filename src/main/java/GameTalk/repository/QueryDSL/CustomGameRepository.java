package GameTalk.repository.QueryDSL;

import GameTalk.DTO.game.GameDetailsDTO;
import GameTalk.DTO.game.GameListDTO;

import java.util.List;

public interface CustomGameRepository {

    // game page List
    List<GameListDTO> getList();

    GameDetailsDTO detail(Long gameId);
}
