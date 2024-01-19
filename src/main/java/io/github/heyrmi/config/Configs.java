package io.github.heyrmi.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@Config.LoadPolicy(LoadType.MERGE)
@Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"
})

public interface Configs extends Config {
    @DefaultValue("https://hub.lambdatest.com/wd/hub")
    String hubUrl();

    @DefaultValue("no")
    String sendAllureResults();

    @DefaultValue("no")
    String publishAllureResults();

    String browserName();

    String browserVersion();

    String platform();

    String username();

    String accesskey();
}
