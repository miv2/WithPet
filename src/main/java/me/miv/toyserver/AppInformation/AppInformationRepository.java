package me.miv.toyserver.AppInformation;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import static me.miv.toyserver.AppInformation.QAppInformation.appInformation;

@Repository
public class AppInformationRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public AppInformationRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public AppInformation selectAppVersion() {
        return jpaQueryFactory.selectFrom(appInformation)
                .orderBy(appInformation.id.desc())
                .limit(1)
                .fetchOne();
    }
}
