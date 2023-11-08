package GameTalk.repository.QueryDSL;

import GameTalk.DTO.game.GaemListDTO;
import GameTalk.DTO.game.GameDetailsDTO;

import java.util.List;

public interface CustomGameRepository {
    List<GaemListDTO> paging();
    GameDetailsDTO detail(Long gameId);
}
