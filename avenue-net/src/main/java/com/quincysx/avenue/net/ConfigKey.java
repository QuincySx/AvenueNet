package com.quincysx.avenue.net;

import android.support.annotation.StringDef;

/**
 * Created by quincysx on 2017/8/31.
 */

public final class ConfigKey {

    public static final String CONFIG_READY = "config_ready";
    public static final String APP_CONTEXT = "app_context";
    public static final String BASE_URL = "base_url";
    public static final String OKHTTP_LOGGER = "okhttp_logger";

    @StringDef({APP_CONTEXT, BASE_URL, OKHTTP_LOGGER})
    public @interface Key {

    }
}
