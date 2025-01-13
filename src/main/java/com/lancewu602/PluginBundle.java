package com.lancewu602;

import com.intellij.DynamicBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

/**
 * @author WuQinglong
 * @date 2025/1/13 17:44
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
