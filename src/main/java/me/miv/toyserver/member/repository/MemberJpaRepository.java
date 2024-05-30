package me.miv.toyserver.member.repository;

import me.miv.toyserver.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Boolean existsByLoginId(String loginId);
}
