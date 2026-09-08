package com.oplus.backup.sdk.common.load;

import android.content.Context;
import com.oplus.backup.sdk.common.plugin.BRPluginConfig;
import com.oplus.backup.sdk.common.utils.BRLog;
import com.oplus.backup.sdk.common.utils.FileUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes3.dex */
public class BRPluginLoader {
    private static final String TAG = "BRPluginLoader";
    private HashMap<BRPluginConfig, ClassLoader> mPluginMap = new HashMap<>();

    public Class<?> findClass(BRPluginConfig bRPluginConfig, ClassLoader classLoader, int i10) {
        Class<?> cls = null;
        try {
            String[] pluginClass = bRPluginConfig.getPluginClass();
            if (pluginClass != null && pluginClass.length > i10) {
                cls = classLoader.loadClass(pluginClass[i10]);
            }
        } catch (ClassNotFoundException e10) {
            BRLog.e(TAG, "findClass, e =" + e10.getMessage());
        }
        if (cls != null) {
            BRLog.d(TAG, "findClass success:");
        } else {
            BRLog.d(TAG, "findClass failed:");
        }
        return cls;
    }

    public BRPluginConfig[] getLoadedPlugins() {
        Set<BRPluginConfig> keySet = this.mPluginMap.keySet();
        if (keySet != null && keySet.size() > 0) {
            return (BRPluginConfig[]) keySet.toArray(new BRPluginConfig[0]);
        }
        return null;
    }

    public ClassLoader load(Context context, BRPluginConfig bRPluginConfig) {
        return load(context, bRPluginConfig, false);
    }

    public boolean unload(BRPluginConfig bRPluginConfig) {
        this.mPluginMap.remove(bRPluginConfig);
        FileUtils.deleteFileOrFolder(new File(bRPluginConfig.getOptimizedDirectory()));
        return true;
    }

    public ClassLoader load(Context context, BRPluginConfig bRPluginConfig, boolean z10) {
        if (bRPluginConfig == null) {
            BRLog.e(TAG, "pluginConfig is null!");
            return null;
        }
        if (this.mPluginMap.containsKey(bRPluginConfig)) {
            if (!z10) {
                return this.mPluginMap.get(bRPluginConfig);
            }
            unload(bRPluginConfig);
        }
        BRLog.w(TAG, "pluginConfig no dexPaths!");
        ClassLoader classLoader = context.getClassLoader();
        this.mPluginMap.put(bRPluginConfig, classLoader);
        return classLoader;
    }

    public void getLocalPlugin() {
    }
}
