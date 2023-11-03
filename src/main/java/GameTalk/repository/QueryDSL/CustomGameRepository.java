package GameTalk.repository.QueryDSL;

import GameTalk.DTO.game.GaemListDTO;

import java.util.List;

public interface CustomGameRepository {
    List<GaemListDTO> paging();
}
