package me.miv.toyserver.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.miv.toyserver.member.domain.Role;
import me.miv.toyserver.member.enumeration.RoleType;
import org.springframework.stereotype.Repository;

import static me.miv.toyserver.member.domain.QRole.role;

@Repository
public class RoleRepository {
    private final JPAQueryFactory jpaqueryfactory;

    public RoleRepository(JPAQueryFactory jpaqueryfactory) {
        this.jpaqueryfactory = jpaqueryfactory;
    }

    public Role findRoleByType(RoleType type) {
        return jpaqueryfactory.selectFrom(role)
                .where(role.roleType.eq(type))
                .fetchOne();
    }

}
