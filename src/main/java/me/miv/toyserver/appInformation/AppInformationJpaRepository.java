package me.miv.toyserver.appInformation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppInformationJpaRepository extends JpaRepository<AppInformation, Long> {
}
