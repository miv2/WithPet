package me.miv.toyserver.region.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.miv.toyserver.region.domain.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

import static me.miv.toyserver.region.domain.QRegion.region;

@Repository
public class RegionRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public RegionRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Region> findByMemberId(Long memberId) {
        return jpaQueryFactory.selectFrom(region)
                .where(region.memberId.ne(memberId))
                .fetch();
    }
}
