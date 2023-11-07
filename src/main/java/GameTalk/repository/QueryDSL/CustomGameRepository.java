package GameTalk.repository.QueryDSL;

import com.querydsl.core.Tuple;

import java.util.List;

public interface CustomGameRepository {
    List<Tuple> paging();
}
