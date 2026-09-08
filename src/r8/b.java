package R8;

import D2.h;
import android.content.ContentResolver;
import android.text.TextUtils;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusInCallApp;
import com.internal_dependency.SettingsUtils;
import kotlin.jvm.internal.i;

/* compiled from: VideoShowUtil.kt */
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f3364a = new b();

    public static final String b() {
        ContentResolver cr = OplusInCallApp.getInCallAppInstance().getContentResolver();
        SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
        i.e(cr, "cr");
        return settingsUtils.getGlobalSettingsString(cr, "theme_applied_video_preview_path", "");
    }

    public static final String c() {
        ContentResolver cr = OplusInCallApp.getInCallAppInstance().getContentResolver();
        SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
        i.e(cr, "cr");
        return settingsUtils.getGlobalSettingsString(cr, "theme_applied_video_path", "");
    }

    public static final boolean d() {
        if (OplusFeatureOption.VERSION_STORE) {
            return false;
        }
        boolean z10 = !TextUtils.isEmpty(c());
        a.f3357a.b("VideoShowUtil", "isVideoShowEnable, enable = " + z10);
        return z10;
    }

    public static final boolean e() {
        boolean a10 = h.a(OplusInCallApp.getInCallAppInstance(), "com.heytap.themestore", "video_show_support", "true");
        if (!a10) {
            a10 = h.a(OplusInCallApp.getInCallAppInstance(), "com.oplus.themestore", "video_show_support", "true");
        }
        a.f3357a.b("VideoShowUtil", "isVideoShowSupport, hasMeta = " + a10);
        return a10;
    }

    public static final boolean f() {
        boolean e10 = e();
        a.f3357a.b("VideoShowUtil", "isVideoShowSupportByThemeStore  isVideoShowSupport = " + e10);
        return e10;
    }

    public final String a(int i10) {
        switch (i10) {
            case -1:
                return "invalid";
            case 0:
            case 3:
            default:
                return "";
            case 1:
                return "idle";
            case 2:
                return "ready";
            case 4:
                return "play";
            case 5:
                return "playing";
            case 6:
                return "pause";
            case 7:
                return "stop";
            case 8:
                return "error";
            case 9:
                return "replay";
        }
    }
}
