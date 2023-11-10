package GameTalk.repository.QueryDSL;

import GameTalk.DTO.game.GaemListDTO;
import GameTalk.DTO.game.GameDetailsDTO;

import java.util.List;

public interface CustomGameRepository {

    // game page List
    List<GaemListDTO> getList();

    GameDetailsDTO detail(Long gameId);
}
