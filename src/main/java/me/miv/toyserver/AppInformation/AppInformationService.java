package me.miv.toyserver.AppInformation;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppInformationService {

    private final AppInformationRepository appInformationRepository;

    public AppInformationService(AppInformationRepository appInformationRepository) {
        this.appInformationRepository = appInformationRepository;
    }

    public void appVersionSave(String Version) {
        AppInformation appInformation = new AppInformation(Version);
        appInformationRepository.save(appInformation);
    }

    public List<AppInformation> getAppVersion() {
        List<AppInformation> appInformations = appInformationRepository.findAll();
        return appInformations;
    }
}
