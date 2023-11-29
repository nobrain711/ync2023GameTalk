package GameTalk.service;

import GameTalk.DTO.Page.PageRequestDTO;
import GameTalk.DTO.Page.PageResultDTO;
import GameTalk.DTO.game.GameListDTO;
import GameTalk.DTO.game.GameDetailsDTO;
import GameTalk.entity.GamesEntity;
import GameTalk.entity.SeriesEntity;
import GameTalk.repository.*;
import GameTalk.repository.QueryDSL.CustomGameRepositoryImpl;
import GameTalk.repository.joinEntity.GameDeveloperRepository;
import GameTalk.repository.joinEntity.GameGenreRepostiory;
import GameTalk.repository.joinEntity.GamePlatformRepository;
import GameTalk.repository.joinEntity.GamePublisherReposiory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class GameServiceImpl implements GameService {
    /* Repository*/
    private final SeriesRepository seriesRepository;
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
    @Transactional
    public void register(GameDetailsDTO dto) {
        Map<String, Object> dtoToEntity = dtoToEntity(dto);

        /* seriesEntity -> dtoToEntity
         * seriex -> DB
         * */
        SeriesEntity seriesEntity = (SeriesEntity) dtoToEntity.get("series");
        SeriesEntity series = seriesRepository.findByName(seriesEntity.getName());

        if (series == null){
            seriesRepository.save(seriesEntity);
            series = seriesRepository.findByName(seriesEntity.getName());
        }

        GamesEntity gamesEntity = (GamesEntity) dtoToEntity.get("game");
        try{
            gamesRepository.save(gamesEntity);
            GamesEntity games = gamesRepository.findByTitle(gamesEntity.getTitle());
        }
    }

    @Override
    public GameDetailsDTO get(Long gameId) {
        GameDetailsDTO detail = customGameRepository.detail(gameId);

        return detail;
    }

    @Override
    public PageResultDTO<GameListDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
//        Pageable pageable = pageRequestDTO.getPageable(Sort.by("gameId").descending());
//        Page<Object[]> result = customGameRepository.getList(pageable);
//
//        List<GameListDTO> gameListDTO = result.getContent().stream()
//                .map(t -> new GameListDTO(
//                        (Long) t[0],
//                        (String) t[1],
//                        (LocalDate) t[2],
//                        (String) t[3],
//                        (String) t[4],
//                        (String) t[5],
//                        (String) t[6],
//                        (String) t[7]
//                ))
//                .collect(Collectors.toList());
//        return new PageResultDTO<>(result,gameListDTO);
        return null;
    }
}
