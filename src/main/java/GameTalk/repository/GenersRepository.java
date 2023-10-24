package GameTalk.repository;

import GameTalk.entity.GenresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenersRepository extends JpaRepository<GenresEntity, Long> {

    // 게임 장르 검색 (들어간 문자열 하나만 있어도 됨) WHERE UPPER(name) = UPPER('%name%')
    List<GenresEntity> findByNameContainingIgnoreCase(String name);

    GenresEntity findByNameIgnoreCase(String name);

    @Query("SELECT gener.generId " +
            "FROM GenresEntity gener " +
            "WHERE UPPER(gener.name) = UPPER(:name) ")
    Long getGenerIdByTitleIgnoreCase(@Param("name") String name);
}
