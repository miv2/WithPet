package me.miv.toyserver.AppInformation;

import com.querydsl.jpa.impl.JPAQuery;
import me.miv.toyserver.common.response.ApplicationResponse;
import me.miv.toyserver.common.response.ApplicationResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/version")
public class AppInformationController {

    private final AppInformationService appInformationService;

    public AppInformationController(AppInformationService appInformationService) {
        this.appInformationService = appInformationService;
    }

    @GetMapping
    public ApplicationResponse<AppInformation> getAppVersion() {
        return ApplicationResponse.ok("앱버전 조회", appInformationService.getAppVersion());
    }

}
