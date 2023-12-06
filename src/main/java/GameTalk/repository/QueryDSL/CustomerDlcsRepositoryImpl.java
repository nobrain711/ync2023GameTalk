package GameTalk.repository.QueryDSL;

import GameTalk.entity.GamesEntity;
import GameTalk.entity.joinEntity.QDlcsEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomerDlcsRepositoryImpl implements CustomDlcsRepository {
    private final JPAQueryFactory queryFactory;
    QDlcsEntity dlcs = QDlcsEntity.dlcsEntity;

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
}
