package GameTalk.repository.QueryDSL;

import GameTalk.DTO.game.GameDetailsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomGameRepository {

    // game page List
    Page<Object[]> getList(Pageable pageable);

    GameDetailsDTO detail(Long gameId);
}
