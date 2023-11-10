package GameTalk.service;

import GameTalk.DTO.Page.PageRequestDTO;
import GameTalk.DTO.Page.PageResultDTO;
import GameTalk.DTO.game.GaemListDTO;
import GameTalk.DTO.game.GameDetailsDTO;
import GameTalk.repository.*;
import GameTalk.repository.QueryDSL.CustomGameRepositoryImpl;
import GameTalk.repository.joinEntity.GameDeveloperRepository;
import GameTalk.repository.joinEntity.GameGenreRepostiory;
import GameTalk.repository.joinEntity.GamePlatformRepository;
import GameTalk.repository.joinEntity.GamePublisherReposiory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class GameServiceImpl implements GameService {
    /* Repository*/
    private final GamesRepository gamesRepository;
    private final GenresRepository genresRepository;
    private final DeveloperRepository developerRepository;
    private final PublisherRepository publisherRepository;
    private final PlatformRepository platformRepository;
    private final GameGenreRepostiory gameGenreRepostiory;
    private final GameDeveloperRepository gameDeveloperRepository;
    private final GamePublisherReposiory gamePublisherReposiory;
    private final GamePlatformRepository gamePlatformRepository;

    private final CustomGameRepositoryImpl customGameRepository;

    @Override
    public void register(GameDetailsDTO dto) {

    }

    @Override
    public GameDetailsDTO get(Long gameId) {
        GameDetailsDTO detail = customGameRepository.detail(gameId);

        return detail;
    }

    @Override
    public PageResultDTO<GaemListDTO, Object[]> getList(PageRequestDTO pageRequestDTO){
        Pageable pageable = pageRequestDTO.getPageable(Sort.by("gameId").descending());
        Page<Object[]> result = customGameRepository.getList(pageable);
    }
}
