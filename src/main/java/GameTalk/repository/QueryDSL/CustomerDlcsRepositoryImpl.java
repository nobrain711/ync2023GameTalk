package GameTalk.repository.QueryDSL;

import GameTalk.entity.GamesEntity;
import GameTalk.entity.QGamesEntity;
import GameTalk.entity.joinEntity.QDlcsEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
@Log4j2
public class CustomerDlcsRepositoryImpl implements CustomDlcsRepository {
    private final JPAQueryFactory queryFactory;
    QDlcsEntity dlcs = QDlcsEntity.dlcsEntity;

    @Override
    public List<GamesEntity> findByChildGames(GamesEntity parentGame) {
        List<GamesEntity> result = queryFactory.select(dlcs.childGame)
                .from(dlcs)
                .where(dlcs.parentGame.eq(parentGame))
                .stream().toList();

        return result;
    }
}
