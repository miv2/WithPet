package me.miv.toyserver.appInformation;

import org.springframework.stereotype.Service;

@Service
public class AppInformationService {

    private final AppInformationJpaRepository appInformationJpaRepository;
    private final AppInformationRepository appInformationRepository;

    public AppInformationService(AppInformationJpaRepository appInformationJpaRepository, AppInformationRepository appInformationRepository) {
        this.appInformationJpaRepository = appInformationJpaRepository;
        this.appInformationRepository = appInformationRepository;
    }

    public void appVersionSave(String Version) {
        AppInformation appInformation = new AppInformation(Version);
        appInformationJpaRepository.save(appInformation);
    }

    public AppInformation getAppVersion() {
        AppInformation appInformation = appInformationRepository.selectAppVersion();
        return appInformation;
    }
}
