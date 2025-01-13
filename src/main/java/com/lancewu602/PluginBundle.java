package com.lancewu602;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

/**
 * @author WuQinglong
 * @since 2023/10/31 9:53 AM
 */
public class PluginBundle extends DynamicBundle {

    private static final String BUNDLE = "messages.plugin";

    private static final PluginBundle INSTANCE = new PluginBundle();

    private PluginBundle() {
        super(BUNDLE);
    }

    @NotNull
    public static String get(@NotNull @PropertyKey(resourceBundle = BUNDLE) String key, Object... params) {
        return INSTANCE.getMessage(key, params);
    }

}
