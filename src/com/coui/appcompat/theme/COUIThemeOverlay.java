package com.coui.appcompat.theme;

import X8.b;
import X8.c;
import X8.h;
import X8.n;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.OplusBaseConfiguration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.widget.ImageView;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.darkmode.COUIDarkModeUtil;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.tintimageview.COUITintUtil;
import com.coui.appcompat.version.COUICompatUtil;
import com.coui.appcompat.version.COUIVersionUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import oplus.content.res.OplusExtraConfiguration;

/* loaded from: classes3.dex */
public class COUIThemeOverlay {
    private static final String BASE_CONFIG_NEW = "android.content.res.OplusBaseConfiguration";
    private static final String COLOR_MATERIAL_ENABLE = "color_material_enable";
    private static final int COMPAT_VERSION = 12000;
    private static final int COUI_CUSTOM_FALG = 131072;
    private static final int COUI_CUSTOM_THEME_FLAG = 256;
    private static final int COUI_ONLINE_FALG = 1048576;
    private static final int COUI_SELECT_FALG = 65535;
    private static final int COUI_SINGLE_FALG = 65536;
    private static final int COUI_THIRD_THEME_FLAG = 1;
    private static final int COUI_TYPE_FALG = 16711680;
    private static final int COUI_WALLPAPER_FALG = 262144;
    private static final String CUSTOM_THEME_PATH = "my_company/media/theme/";
    private static final String CUSTOM_THEME_PATH_SETTING = "custom_theme_path_setting";
    private static final String DATA_THEME_PATH = "data/theme/";
    private static final String TAG = "COUIThemeOverlay";
    private static final String THEME_VERSION_KEY = "ro.oplus.theme.version";
    private static final String WRAPPER_CLASS_NEW = "com.oplus.inner.content.res.ConfigurationWrapper";
    private static int mCompatVersion;
    private static boolean mThemeO;
    private static String mThemeOverlayName;
    private static boolean mThemeP;
    private static boolean mThemeR;
    private SparseIntArray themeOverlays = new SparseIntArray();
    private HashMap<String, WeakReference<Boolean>> mMetaCaches = new HashMap<>();

    /* loaded from: classes3.dex */
    public static class SingleTone {
        private static final COUIThemeOverlay INSTANCE = new COUIThemeOverlay();

        private SingleTone() {
        }
    }

    static {
        String configurationName;
        boolean z10;
        if (canReachFrameworkWrapper()) {
            configurationName = WRAPPER_CLASS_NEW;
        } else {
            configurationName = COUICompatUtil.getInstance().getConfigurationName();
        }
        mThemeOverlayName = configurationName;
        mThemeO = isThemeO();
        mThemeR = isThemeR();
        if (isThemeP() && COUIVersionUtil.getOSVersionCode() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        mThemeP = z10;
        mCompatVersion = getCompatVersion();
    }

    private boolean canReachBaseConfiguration() {
        try {
            Class.forName(BASE_CONFIG_NEW);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean canReachFrameworkWrapper() {
        try {
            Class.forName(WRAPPER_CLASS_NEW);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean getBoolValue(Resources resources, int i10) {
        if (resources != null && i10 != 0) {
            return resources.getBoolean(i10);
        }
        return false;
    }

    private static int getCompatVersion() {
        int i10 = 0;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            String str = (String) method.invoke(null, THEME_VERSION_KEY);
            if (!TextUtils.isEmpty(str)) {
                i10 = Integer.parseInt(str.trim());
            }
            if (i10 == 0) {
                String str2 = (String) method.invoke(null, COUICompatUtil.getInstance().getThemeVerisonName());
                if (!TextUtils.isEmpty(str2)) {
                    return Integer.parseInt(str2.trim());
                }
                return i10;
            }
            return i10;
        } catch (Exception e10) {
            COUILog.e(TAG, "getCompatVersion e: " + e10);
            return 0;
        }
    }

    private OplusExtraConfiguration getExtraConfig(Configuration configuration) {
        OplusBaseConfiguration oplusBaseConfiguration = (OplusBaseConfiguration) typeCasting(OplusBaseConfiguration.class, configuration);
        if (oplusBaseConfiguration == null) {
            return null;
        }
        return oplusBaseConfiguration.mOplusExtraConfiguration;
    }

    public static COUIThemeOverlay getInstance() {
        return SingleTone.INSTANCE;
    }

    private int getResId(Context context, String str, String str2) {
        if (context.getResources() != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(context.getPackageName())) {
            return context.getResources().getIdentifier(str, str2, context.getPackageName());
        }
        return 0;
    }

    private int getThemeArrayId(Context context, int i10, int i11) {
        String str;
        String str2;
        int i12 = 0;
        if (i10 > 0 && context.getResources() != null) {
            Resources resources = context.getResources();
            int i13 = mCompatVersion;
            if (i13 > COMPAT_VERSION) {
                TypedArray obtainTypedArray = resources.obtainTypedArray(b.f4339b);
                if (obtainTypedArray.length() >= i10) {
                    i12 = obtainTypedArray.getResourceId(i10 - 1, 0);
                }
                obtainTypedArray.recycle();
            } else if (i13 == COMPAT_VERSION) {
                if (mThemeR) {
                    str2 = "coui_theme_arrays_ids_patch_r";
                } else {
                    str2 = "coui_theme_arrays_ids_patch_o";
                }
                int resId = getResId(context, str2, "array");
                if (mThemeO && i11 == 1048576) {
                    resId = b.f4339b;
                }
                if (resId != 0) {
                    TypedArray obtainTypedArray2 = resources.obtainTypedArray(resId);
                    if (obtainTypedArray2.length() >= i10) {
                        i12 = obtainTypedArray2.getResourceId(i10 - 1, 0);
                    }
                    obtainTypedArray2.recycle();
                }
            } else {
                if (mThemeR) {
                    str = "coui_theme_arrays_ids_repatch_r";
                } else {
                    str = "coui_theme_arrays_ids_repatch_o";
                }
                int resId2 = getResId(context, str, "array");
                if (resId2 != 0) {
                    TypedArray obtainTypedArray3 = resources.obtainTypedArray(resId2);
                    if (obtainTypedArray3.length() >= i10) {
                        i12 = obtainTypedArray3.getResourceId(i10 - 1, 0);
                    }
                    obtainTypedArray3.recycle();
                }
            }
        }
        return i12;
    }

    private boolean hasCustomThemePkg(Context context) {
        String packageName = context.getPackageName();
        File file = new File(CUSTOM_THEME_PATH);
        if (!file.exists() || TextUtils.isEmpty(packageName)) {
            return false;
        }
        if (new File(file, packageName).exists()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return false;
        }
        String string = Settings.System.getString(context.getContentResolver(), CUSTOM_THEME_PATH_SETTING);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return new File(string, packageName).exists();
    }

    private boolean hasDataThemePkg(Context context) {
        String packageName = context.getPackageName();
        int i10 = 0;
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        OplusExtraConfiguration extraConfig = getExtraConfig(context.getResources().getConfiguration());
        if (extraConfig != null) {
            i10 = extraConfig.mUserId;
        }
        String str = DATA_THEME_PATH;
        if (i10 > 0) {
            str = DATA_THEME_PATH + i10;
        }
        return new File(str, packageName).exists();
    }

    private boolean isCOUIEnable(Context context) {
        Boolean bool;
        WeakReference<Boolean> weakReference = this.mMetaCaches.get(context.getPackageName());
        if (weakReference != null) {
            bool = weakReference.get();
        } else {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z10 = false;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData.getBoolean(COLOR_MATERIAL_ENABLE)) {
                z10 = true;
            }
            this.mMetaCaches.put(context.getPackageName(), new WeakReference<>(Boolean.valueOf(z10)));
        } catch (PackageManager.NameNotFoundException e10) {
            COUILog.e(TAG, "isCOUIEnable e: " + e10);
        }
        return z10;
    }

    private static boolean isThemeO() {
        String str = Build.MANUFACTURER;
        if (!str.equals(String.valueOf(new char[]{'O', 'P', 'P', 'O'})) && !str.equals(String.valueOf(new char[]{'O', 'p', 'p', 'o'}))) {
            return false;
        }
        return true;
    }

    private static boolean isThemeP() {
        String str = Build.MANUFACTURER;
        if (!str.equals(String.valueOf(new char[]{'O', 'n', 'e', 'P', 'l', 'u', 's'})) && !str.equals(String.valueOf(new char[]{'O', 'N', 'E', 'P', 'L', 'U', 'S'})) && !str.equals(String.valueOf(new char[]{'G', 'A', 'L', 'I', 'L', 'E', 'I'})) && !str.equals(String.valueOf(new char[]{'g', 'a', 'l', 'i', 'l', 'e', 'i'})) && !str.equals(String.valueOf(new char[]{'F', 'A', 'R', 'A', 'D', 'A', 'Y'})) && !str.equals(String.valueOf(new char[]{'f', 'a', 'r', 'a', 'd', 'a', 'y'}))) {
            return false;
        }
        return true;
    }

    private static boolean isThemeR() {
        String str = Build.MANUFACTURER;
        if (!str.equals(String.valueOf(new char[]{'R', 'E', 'A', 'L', 'M', 'E'})) && !str.equals(String.valueOf(new char[]{'R', 'e', 'a', 'l', 'm', 'e'})) && !str.equals(String.valueOf(new char[]{'r', 'e', 'a', 'l', 'm', 'e'}))) {
            return false;
        }
        return true;
    }

    private void resolveThemeStyle(Context context) {
        boolean z10;
        int themeArrayId;
        int i10;
        String str;
        if (context != null && !isRejectTheme(context)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{c.f4401q0});
            int integer = obtainStyledAttributes.getInteger(0, 0);
            obtainStyledAttributes.recycle();
            long cOUITheme = getCOUITheme(context.getResources().getConfiguration());
            int i11 = (int) (65535 & cOUITheme);
            int i12 = (int) (16711680 & cOUITheme);
            if (mCompatVersion < COMPAT_VERSION) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (cOUITheme != 0) {
                if (i11 != 0 || i12 != 0) {
                    if (i12 == 131072) {
                        setThemeOverlay(h.f4956x, n.f5038j);
                        return;
                    }
                    if (i12 == 65536) {
                        if (mThemeP) {
                            if (z10) {
                                str = "coui_theme_arrays_single_repatch_p";
                            } else {
                                str = "coui_theme_arrays_single_patch_p";
                            }
                            i10 = getResId(context, str, "array");
                        } else {
                            i10 = b.f4340c;
                        }
                    } else {
                        if (i12 == COUI_WALLPAPER_FALG) {
                            themeArrayId = b.f4338a;
                        } else if (i12 != 0 && i12 != 1048576) {
                            i10 = 0;
                            i11 = -1;
                        } else {
                            themeArrayId = getThemeArrayId(context, i11, i12);
                        }
                        int i13 = integer - 1;
                        i10 = themeArrayId;
                        i11 = i13;
                    }
                    if (i10 != 0 && i11 != -1) {
                        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(i10);
                        if (obtainTypedArray.length() > i11) {
                            setThemeOverlay(h.f4956x, obtainTypedArray.getResourceId(i11, 0));
                        }
                        obtainTypedArray.recycle();
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T typeCasting(Class<T> cls, Object obj) {
        if (obj != 0 && cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }

    public void applyCOUITintIcon(Context context, ImageView imageView, boolean z10) {
        Drawable drawable;
        if (imageView == null || isRejectTheme(context)) {
            return;
        }
        if ((!getInstance().isCOUITheme(context) && !z10) || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        if (drawable instanceof LayerDrawable) {
            COUITintUtil.tintDrawable(((LayerDrawable) drawable).getDrawable(0), COUIContextUtil.getAttrColor(context, c.f4349H));
        } else {
            COUITintUtil.tintDrawable(drawable, COUIContextUtil.getAttrColor(context, c.f4349H));
        }
        COUIDarkModeUtil.setForceDarkAllow(imageView, false);
        imageView.setImageDrawable(drawable);
    }

    public void applyThemeOverlays(Context context) {
        synchronized (this.themeOverlays) {
            try {
                clearThemeOverlays();
                resolveThemeStyle(context);
                for (int i10 = 0; i10 < this.themeOverlays.size(); i10++) {
                    context.setTheme(this.themeOverlays.valueAt(i10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void clearThemeOverlays() {
        synchronized (this.themeOverlays) {
            this.themeOverlays.clear();
        }
    }

    public long getCOUITheme(Configuration configuration) {
        if (!canReachBaseConfiguration()) {
            return 0L;
        }
        OplusExtraConfiguration extraConfig = getExtraConfig(configuration);
        if (extraConfig != null) {
            return extraConfig.mMaterialColor;
        }
        try {
            Class<?> cls = Class.forName(mThemeOverlayName);
            if (cls.getDeclaredConstructor(null).newInstance(null) == null) {
                return 0L;
            }
            return ((Long) cls.getMethod("getMaterialColor", Configuration.class).invoke(null, configuration)).longValue();
        } catch (Exception e10) {
            COUILog.e(TAG, "getCOUITheme e: " + e10);
            return 0L;
        }
    }

    public int getThemeOverlay(int i10) {
        int i11;
        synchronized (this.themeOverlays) {
            i11 = this.themeOverlays.get(i10);
        }
        return i11;
    }

    public boolean isCOUITheme(Context context) {
        long cOUITheme = getCOUITheme(context.getResources().getConfiguration());
        if (cOUITheme > 0 && (cOUITheme & 2147483647L) != 0) {
            return true;
        }
        return false;
    }

    public boolean isGreenMaterial(Context context) {
        long cOUITheme = getCOUITheme(context.getResources().getConfiguration());
        if (cOUITheme > 0 && (cOUITheme & 65535) == 5) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isRejectTheme(android.content.Context r12) {
        /*
            r11 = this;
            java.lang.String r0 = "COUIThemeOverlay"
            android.content.res.Resources r1 = r12.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            r2 = 0
            if (r1 == 0) goto La9
            boolean r3 = r11.canReachBaseConfiguration()
            if (r3 != 0) goto L15
            goto La9
        L15:
            r3 = 0
            r4 = 0
            android.content.res.Resources r6 = r12.getResources()     // Catch: java.lang.Exception -> L2d
            android.content.res.Configuration r6 = r6.getConfiguration()     // Catch: java.lang.Exception -> L2d
            oplus.content.res.OplusExtraConfiguration r6 = r11.getExtraConfig(r6)     // Catch: java.lang.Exception -> L2d
            boolean r7 = r6 instanceof oplus.content.res.OplusExtraConfiguration     // Catch: java.lang.Exception -> L2b
            if (r7 == 0) goto L47
            long r7 = r6.mThemeChangedFlags     // Catch: java.lang.Exception -> L2b
            goto L48
        L2b:
            r7 = move-exception
            goto L2f
        L2d:
            r7 = move-exception
            r6 = r3
        L2f:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "get extra config failed : "
            r8.append(r9)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            android.util.Log.d(r0, r7)
        L47:
            r7 = r4
        L48:
            if (r6 != 0) goto L86
            java.lang.String r6 = com.coui.appcompat.theme.COUIThemeOverlay.mThemeOverlayName     // Catch: java.lang.Exception -> L71
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch: java.lang.Exception -> L71
            java.lang.Object r9 = r6.newInstance()     // Catch: java.lang.Exception -> L71
            if (r9 == 0) goto L86
            java.lang.String r9 = "getThemeChangedFlags"
            java.lang.Class<android.content.res.Configuration> r10 = android.content.res.Configuration.class
            java.lang.Class[] r10 = new java.lang.Class[]{r10}     // Catch: java.lang.Exception -> L71
            java.lang.reflect.Method r6 = r6.getMethod(r9, r10)     // Catch: java.lang.Exception -> L71
            java.lang.Object[] r9 = new java.lang.Object[]{r1}     // Catch: java.lang.Exception -> L71
            java.lang.Object r3 = r6.invoke(r3, r9)     // Catch: java.lang.Exception -> L71
            java.lang.Long r3 = (java.lang.Long) r3     // Catch: java.lang.Exception -> L71
            long r7 = r3.longValue()     // Catch: java.lang.Exception -> L71
            goto L86
        L71:
            r3 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r9 = "isRejectTheme e: "
            r6.append(r9)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            com.coui.appcompat.log.COUILog.e(r0, r3)
        L86:
            r9 = 1
            long r9 = r9 & r7
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 == 0) goto La9
            r9 = 256(0x100, double:1.265E-321)
            long r6 = r7 & r9
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L9a
            boolean r11 = r11.hasCustomThemePkg(r12)
            goto L9e
        L9a:
            boolean r11 = r11.hasDataThemePkg(r12)
        L9e:
            if (r11 == 0) goto La9
            int r11 = r1.uiMode
            r11 = r11 & 48
            r12 = 32
            if (r11 == r12) goto La9
            r2 = 1
        La9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.theme.COUIThemeOverlay.isRejectTheme(android.content.Context):boolean");
    }

    public void setThemeOverlay(int i10, int i11) {
        synchronized (this.themeOverlays) {
            this.themeOverlays.put(i10, i11);
        }
    }

    public boolean shouldResetTheme(Configuration configuration) {
        long cOUITheme = getCOUITheme(configuration);
        if ((2147483647L & cOUITheme) != 0 && (cOUITheme & 262144) == 0) {
            return false;
        }
        return true;
    }
}
