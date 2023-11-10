package GameTalk.repository.QueryDSL;

import GameTalk.DTO.game.GaemListDTO;
import GameTalk.DTO.game.GameDetailsDTO;
import GameTalk.entity.*;
import GameTalk.entity.joinEntity.QGameDeveloperEntity;
import GameTalk.entity.joinEntity.QGameGenreEntity;
import GameTalk.entity.joinEntity.QGamePlatformEntity;
import GameTalk.entity.joinEntity.QGamePublisherEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.group.GroupBy.groupBy;


@Log4j2
@Repository
@RequiredArgsConstructor
public class CustomGameRepositoryImpl implements CustomGameRepository {
    // Query
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

    // SubQuery
    // Genre
    JPQLQuery<String> genreSub = JPAExpressions.select(
                    Expressions.stringTemplate(
                            "LISTAGG({0}, '\" ') WITHIN GROUP ( ORDER BY {0})", genres.name
                    ))
            .from(genres)
            .innerJoin(genres.gameGenere, gameGenre)
            .where(games.gameId.eq(gameGenre.games.gameId));

    // Developer
    JPQLQuery<String> developerSub = JPAExpressions.select(
                    Expressions.stringTemplate(
                            "LISTAGG({0}, '\" ') WITHIN GROUP ( ORDER BY {0})", developers.name
                    ))
            .from(developers)
            .innerJoin(developers.gameDeveloper, gameDeveloper)
            .where(games.gameId.eq(gameDeveloper.games.gameId));

    // Publisher
    JPQLQuery<String> publisherSub = JPAExpressions.select(
                    Expressions.stringTemplate(
                            "LISTAGG({0}, '\" ') WITHIN GROUP (ORDER BY {0})", publishers.name
                    ))
            .from(publishers)
            .innerJoin(publishers.gamePublisher, gamePublisher)
            .where(games.gameId.eq(gamePublisher.games.gameId));

    // Platform
    JPQLQuery<String> platformSub = JPAExpressions.select(
                    Expressions.stringTemplate(
                            "LISTAGG({0}, '\" ') WITHIN GROUP (ORDER BY {0})", platform.name
                    ))
            .from(platform)
            .innerJoin(platform.gamePlatform, gamePlatform)
            .where(games.gameId.eq(gamePlatform.games.gameId));

    // game page List
    @Override
    public List<GaemListDTO> getList() {
        List<GaemListDTO> result = queryFactory
                .select(games.gameId,
                        games.title,
                        games.relesaeDate,
                        series.name,
                        genreSub,
                        developerSub,
                        publisherSub,
                        platformSub)
                .from(games)
                .innerJoin(games.series, series)
                .orderBy(games.gameId.desc())
                .transform(groupBy(games.gameId).list(Projections.constructor(GaemListDTO.class,
                        games.gameId, games.title, games.relesaeDate, series.name,
                        genreSub, developerSub, publisherSub, platformSub)));

        return result;
    }

    @Override
    public GameDetailsDTO detail(Long gameId) {
        GameDetailsDTO result = queryFactory
                .select(Projections.constructor(GameDetailsDTO.class,
                        games.gameId,
                        games.title,
                        games.info,
                        games.relesaeDate,
                        series.name,
                        genreSub,
                        developerSub,
                        publisherSub,
                        platformSub))
                .from(games)
                .innerJoin(games.series, series)
                .where(games.gameId.eq(gameId))
                .orderBy(games.gameId.desc())
                .fetchOne();

        return result;
    }
}
