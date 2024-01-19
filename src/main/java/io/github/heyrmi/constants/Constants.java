package io.github.heyrmi.constants;

import lombok.Getter;

public final class Constants {

    private Constants() {
    }

    // FilePaths Constants
    private static final @Getter String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final @Getter String CONFIGFILEPATH = RESOURCESPATH + "/config.properties";

}
