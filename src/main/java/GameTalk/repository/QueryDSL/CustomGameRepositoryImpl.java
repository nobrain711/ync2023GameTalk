package GameTalk.repository.QueryDSL;

import GameTalk.entity.*;
import GameTalk.entity.joinEntity.QGameDeveloperEntity;
import GameTalk.entity.joinEntity.QGameGenreEntity;
import GameTalk.entity.joinEntity.QGamePlatformEntity;
import GameTalk.entity.joinEntity.QGamePublisherEntity;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;


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

    // game page List
    @Override
    public List<Tuple> paging() {
        List<Tuple> gameList = queryFactory
                .select(games.gameId,
                        games.title,
                        games.relesaeDate,
                        series.name,
                        JPAExpressions.select(
                                        Expressions.stringTemplate(
                                                "LISTAGG({0}, ', ') WITHIN GROUP ( ORDER BY {0})", genres.name
                                        ))
                                .from(genres)
                                .innerJoin(genres.gameGenere, gameGenre)
                                .where(games.gameId.eq(gameGenre.games.gameId)),
                        JPAExpressions.select(
                                        Expressions.stringTemplate(
                                                "LISTAGG({0}, ', ') WITHIN GROUP ( ORDER BY {0})", developers.name
                                        ))
                                .from(developers)
                                .innerJoin(developers.gameDeveloper, gameDeveloper)
                                .where(games.gameId.eq(gameDeveloper.games.gameId)),
                        JPAExpressions.select(
                                Expressions.stringTemplate(
                                        "LISTAGG({0}, ', ') WITHIN GROUP (ORDER BY {0})", publishers.name
                                ))
                                .from(publishers)
                                .innerJoin(publishers.gamePublisher, gamePublisher)
                                .where(games.gameId.eq(gamePublisher.games.gameId)),
                        JPAExpressions.select(
                                Expressions.stringTemplate(
                                        "LISTAGG({0}, ', ') WITHIN GROUP (ORDER BY {0})", platform.name
                                ))
                                .from(platform)
                                .innerJoin(platform.gamePlatform, gamePlatform)
                                .where(games.gameId.eq(gamePlatform.games.gameId))
                )
                .from(games)
                .innerJoin(games.series, series)
                .orderBy(games.gameId.desc())
                .groupBy(games.gameId, games.title, games.relesaeDate, series.name)
                .fetch();
        return gameList;
    }
}
