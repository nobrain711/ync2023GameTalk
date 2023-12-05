package GameTalk.service;

import GameTalk.DTO.Page.PageRequestDTO;
import GameTalk.DTO.Page.PageResultDTO;
import GameTalk.DTO.game.GameListDTO;
import GameTalk.DTO.game.GameDetailsDTO;
import GameTalk.DTO.game.Info.DeveloperDTO;
import GameTalk.entity.*;
import GameTalk.entity.joinEntity.GameGenreEntity;
import GameTalk.repository.*;
import GameTalk.repository.QueryDSL.CustomGameRepositoryImpl;
import GameTalk.repository.joinEntity.GameDeveloperRepository;
import GameTalk.repository.joinEntity.GameGenreRepostiory;
import GameTalk.repository.joinEntity.GamePlatformRepository;
import GameTalk.repository.joinEntity.GamePublisherReposiory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity register(GameDetailsDTO dto) {
        Map<String, Object> dtoToEntity = dtoToEntity(dto);

        /* seriesEntity -> dtoToEntity
         * series -> DB
         * */
        SeriesEntity seriesEntity = (SeriesEntity) dtoToEntity.get("series");
        SeriesEntity series = seriesRepository.findByName(seriesEntity.getName());

        if (series == null) {
            series = seriesRepository.save(seriesEntity);
        }
        log.info(series);

        try {
            GamesEntity gamesEntity = (GamesEntity) dtoToEntity.get("games");
            gamesEntity.setSeries(series);
            GamesEntity games = gamesRepository.save(gamesEntity);

            log.info(games);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.badRequest().body("141111\n이미 등록이 된 게임 입니다.");
        }

        List<GenresEntity> genresEntityList = (List<GenresEntity>) dtoToEntity.get("genres");
        for (GenresEntity genre : genresEntityList) {
            GenresEntity entity = genresRepository.findByNameIgnoreCase(genre.getName());
            if (entity == null) {
                entity = genresRepository.save(genre);
            }
            GameGenreEntity.builder()
                            .games(games)
            log.info(entity);
        }

        List<DevelopersEntity> developersEntities = (List<DevelopersEntity>) dtoToEntity.get("developers");
        for (DevelopersEntity developer : developersEntities) {
            log.info("원래 entity : " + developer);
            DevelopersEntity entity = developerRepository.findByNameIgnoreCase(developer.getName());

            if (entity == null) {
                entity = developerRepository.save(developer);
            }
            log.info("등록된 entit" + entity);
        }

        List<PublishersEntity> publishersEntities = (List<PublishersEntity>) dtoToEntity.get("publisher");
        for (PublishersEntity publisher : publishersEntities) {
            log.info("원래 : " + publisher);
            PublishersEntity entity = publisherRepository.findByNameIgnoreCase(publisher.getName());
            if (entity == null) {
                entity = publisherRepository.save(publisher);
            }
            log.info("등록됨 : " + entity);
        }

        List<PlatformEntity> platformEntityList = (List<PlatformEntity>) dtoToEntity.get("platform");
        for (PlatformEntity platform : platformEntityList) {
            log.info("원래 : " + platform);
            PlatformEntity entity = platformRepository.findByNameIgnoreCase(platform.getName());
            if(entity == null){
                entity = platformRepository.save(platform);
            }
            log.info(entity);
        }
        return null;
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
