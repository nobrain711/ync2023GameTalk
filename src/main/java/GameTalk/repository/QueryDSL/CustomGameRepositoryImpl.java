package GameTalk.repository.QueryDSL;

import GameTalk.DTO.game.GaemListDTO;
import GameTalk.entity.*;
import GameTalk.entity.joinEntity.QGameDeveloperEntity;
import GameTalk.entity.joinEntity.QGameGenreEntity;
import GameTalk.entity.joinEntity.QGamePlatformEntity;
import GameTalk.entity.joinEntity.QGamePublisherEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

@Log4j2
@Repository
@RequiredArgsConstructor
public class CustomGameRepositoryImpl implements CustomGameRepository {
    private final JPAQueryFactory queryFactory;
    // Root Entity
    QGamesEntity games = QGamesEntity.gamesEntity;
    QSeriesEntity series = QSeriesEntity.seriesEntity;
    QGenresEntity genres = QGenresEntity.genresEntity;
    QDevelopersEntity developers = QDevelopersEntity.developersEntity;
    QPublishersEntity publishers = QPublishersEntity.publishersEntity;
    QPlatformEntity platform = QPlatformEntity.platformEntity;

    // Join Entity
    QGameDeveloperEntity gameDeveloper = QGameDeveloperEntity.gameDeveloperEntity;
    QGameGenreEntity gameGenre = QGameGenreEntity.gameGenreEntity;
    QGamePublisherEntity gamePublisher = QGamePublisherEntity.gamePublisherEntity;
    QGamePlatformEntity gamePlatform = QGamePlatformEntity.gamePlatformEntity;

    // game page List
    @Override
    public List<GaemListDTO> paging() {
        List<GaemListDTO> gameList = queryFactory
                .select(games.gameId,
                        games.title,
                        games.relesaeDate,
                        series.name,
                        genres.name,
                        platform.name
                )
                .from(games)
                .leftJoin(series)
                .on(series.sericeId.eq(games.series.sericeId))
                .innerJoin(gameGenre)
                .on(games.gameId.eq(gameGenre.games.gameId))
                .innerJoin(genres)
                .on(genres.genreId.eq(gameGenre.genres.genreId))
                .innerJoin(gamePlatform)
                .on(games.gameId.eq(gamePlatform.games.gameId))
                .innerJoin(platform)
                .on(platform.platformId.eq(gamePlatform.platforms.platformId))
                .distinct()
                .orderBy(games.gameId.desc())
                .transform(groupBy(games.gameId)
                        .list(Projections.constructor(GaemListDTO.class,
                                games.gameId, games.title, games.relesaeDate, series.name,
                                list(genres.name),list(platform.name))));
        return gameList;
    }
}
