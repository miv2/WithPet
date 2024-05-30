package me.miv.toyserver.AppInformation;

import jakarta.persistence.*;

@Entity
@Table(name = "app_information")
public class AppInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "version")
    private String version;

    public AppInformation() {}

    public AppInformation(String version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public String getVersion() {
        return version;
    }
}
