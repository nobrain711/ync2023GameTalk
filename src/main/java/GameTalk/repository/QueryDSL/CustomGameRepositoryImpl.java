package GameTalk.repository.QueryDSL;

import GameTalk.DTO.game.GameDetailsDTO;
import GameTalk.DTO.game.GameListDTO;
import GameTalk.DTO.game.Info.DeveloperDTO;
import GameTalk.DTO.game.Info.PublishersDTO;
import GameTalk.entity.*;
import GameTalk.entity.joinEntity.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;


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
    QDlcsEntity dlcs = QDlcsEntity.dlcsEntity;

    // Join Entity
    QGameDeveloperEntity gameDeveloper = QGameDeveloperEntity.gameDeveloperEntity;
    QGameGenreEntity gameGenre = QGameGenreEntity.gameGenreEntity;
    QGamePublisherEntity gamePublisher = QGamePublisherEntity.gamePublisherEntity;
    QGamePlatformEntity gamePlatform = QGamePlatformEntity.gamePlatformEntity;

    /*genres SubQuery
     * game에 해당하는 genres조회
     * String으로 반환
     * */
    JPQLQuery<String> genreSub = JPAExpressions.select(
                    Expressions.stringTemplate(
                            "LISTAGG({0}, ', ') WITHIN GROUP ( ORDER BY {0})", genres.name
                    ))
            .from(genres)
            .innerJoin(genres.gameGenere, gameGenre)
            .where(games.gameId.eq(gameGenre.games.gameId));


    /* developer SubQuery
     * String으로 반환
     * game에 해당하는 developer의 name url를 LISTAGG를 이용하여서 반환
     * example "comName1@comURL1, comName2@comURL2
     * */
    JPQLQuery<String> developerSub = JPAExpressions.select(
                    Expressions.stringTemplate(
                            "LISTAGG({0}||'@'||{1}, ', ') WITHIN GROUP ( ORDER BY {0})",
                            developers.name, developers.url
                    ))
            .from(developers)
            .innerJoin(developers.gameDeveloper, gameDeveloper)
            .where(games.gameId.eq(gameDeveloper.games.gameId));


    /* publishers SubQuery
     * String으로 반환
     * game에 해당하는 publishers의 name url를 LISTAGG를 이용하여서 반환
     * example "comName1@comURL1, comName2@comURL2
     * */
    JPQLQuery<String> publisherSub = JPAExpressions.select(
                    Expressions.stringTemplate(
                            "LISTAGG({0}||'@'||{1}, ', ') WITHIN GROUP (ORDER BY {0})",
                            publishers.name, publishers.url))
            .from(publishers)
            .innerJoin(publishers.gamePublisher, gamePublisher)
            .where(games.gameId.eq(gamePublisher.games.gameId));


    JPQLQuery<String> platformSub = JPAExpressions.select(
                    Expressions.stringTemplate(
                            "LISTAGG({0}, ', ') WITHIN GROUP (ORDER BY {0})", platform.name
                    ))
            .from(platform)
            .innerJoin(platform.gamePlatform, gamePlatform)
            .where(games.gameId.eq(gamePlatform.games.gameId));


    /* game list page*/
    @Override
    public List<GameListDTO> getList() {
        List<GameListDTO> result = queryFactory
                .select(games.gameId,
                        games.title,
                        games.relesaeDate,
                        series.name,
                        genreSub,
                        developerSub,
                        publisherSub,
                        platformSub)
                .from(games)
                .leftJoin(games.series, series)
                .orderBy(games.relesaeDate.desc())
                .transform(groupBy(games.gameId).
                        list(Projections.constructor(GameListDTO.class, games.gameId, games.title, games.relesaeDate, series.name,
                                genreSub, developerSub, publisherSub, platformSub)));

        return result;
    }

    /* game Deatil Page*/
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

    @Override
    public List<GamesEntity> findByChildGames(GamesEntity parentGame) {
        List<GamesEntity> result = queryFactory
                .select(dlcs.childGame)
                .from(dlcs)
                .where(dlcs.parentGame.eq(parentGame))
                .stream().toList();

        return result;
    }

    @Override
    public GamesEntity findByParentGame(GamesEntity childGame) {
        GamesEntity result = queryFactory
                .select(dlcs.parentGame)
                .from(dlcs)
                .where(dlcs.childGame.eq(childGame))
                .fetchOne();

        return result;
    }

    public Tuple getData(Long gameId) {
        Tuple result = queryFactory
                .select(games.gameId,
                        games.title,
                        new CaseBuilder()
                                .when(dlcs.parentGame.eq(games)).then(0)
                                .when(dlcs.childGame.eq(games)).then(1)
                                .otherwise((NumberExpression<Integer>) null)
                )
                .from(games)
                .where(games.gameId.eq(gameId))
                .fetchOne();

        return result;
    }
}
