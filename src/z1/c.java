package Z1;

import H1.f;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import com.android.incallui.CallList;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusPhoneUtils;

/* compiled from: FoldScreenCallCardUtils.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f5863a = new c();

    public static final Drawable a(H1.b bVar) {
        int i10;
        int i11;
        if (bVar == null) {
            return null;
        }
        try {
            if (OplusPhoneUtils.isNotShowHDIcon(bVar.h(), bVar.j())) {
                if (Log.sDebug) {
                    Log.d("FoldScreenCallCardUtils", "not show hd icon ");
                }
                return null;
            }
            Context defaultDisplayUiContext = OplusInCallApp.getDefaultDisplayUiContext();
            if (bVar.n()) {
                if (OplusPhoneUtils.shouldReplaceHDIconToVoWifiIcon(bVar.i())) {
                    if (bVar.m()) {
                        i11 = P1.c.f2840h;
                    } else {
                        i11 = P1.c.f2841i;
                    }
                    Log.d("FoldScreenCallCardUtils", "getAudioQualityDrawable = " + i11);
                    return defaultDisplayUiContext.getDrawable(i11);
                }
            } else {
                if (Log.sDebug) {
                    Log.d("FoldScreenCallCardUtils", "OPLUS_PHONE_HIDE_HD_ICON = " + OplusFeatureOption.OPLUS_PHONE_HIDE_HD_ICON);
                }
                if (OplusFeatureOption.OPLUS_PHONE_HIDE_HD_ICON) {
                    return defaultDisplayUiContext.getDrawable(-1);
                }
            }
            int a10 = bVar.a();
            if (a10 != 1) {
                if (a10 != 2) {
                    i10 = -1;
                } else {
                    i10 = P1.c.f2836d;
                }
            } else if (OplusFeatureOption.OPLUS_VERSION_EXP) {
                i10 = P1.c.f2838f;
            } else if (OplusPhoneUtils.isImsRegistered(defaultDisplayUiContext, CallList.getInstance().getActiveSubId())) {
                i10 = P1.c.f2839g;
            } else {
                i10 = P1.c.f2837e;
            }
            if (Log.sDebug) {
                Log.d("FoldScreenCallCardUtils", "getAudioQualityDrawable audioQualityType = " + bVar.a() + " drawableId = " + i10);
            }
            if (i10 == -1) {
                return null;
            }
            return defaultDisplayUiContext.getDrawable(i10);
        } catch (Exception e10) {
            Log.d("FoldScreenCallCardUtils", "getAudioQualityDrawable: " + e10.getMessage());
            return null;
        }
    }

    public static final int b(H1.a aVar, H1.b bVar) {
        if (aVar == null) {
            return -1;
        }
        H1.c a10 = aVar.a();
        f f10 = aVar.f();
        if (bVar != null && bVar.k() && !bVar.g()) {
            return 5;
        }
        if (aVar.c() != null) {
            return 7;
        }
        if (a10 != null && a10.a() != -1) {
            return 0;
        }
        if (f10 != null) {
            String c10 = f10.c();
            if (c10 != null && c10.length() != 0) {
                return 1;
            }
            String a11 = f10.a();
            if (a11 != null && a11.length() != 0) {
                return 3;
            }
            if (f10.b() != null) {
                return 2;
            }
        }
        if (aVar.k()) {
            return 8;
        }
        if (aVar.j()) {
            return 6;
        }
        return 4;
    }

    public static final Drawable c(Context context, int i10, boolean z10, int i11) {
        int i12;
        if (z10 || context == null || i11 == 5 || !OplusPhoneUtils.canDisplayCardIcon(context)) {
            return null;
        }
        if (i10 != 0) {
            if (i10 != 1) {
                i12 = -1;
            } else {
                i12 = P1.c.f2835c;
            }
        } else {
            i12 = P1.c.f2834b;
        }
        if (i12 == -1) {
            return null;
        }
        try {
            return context.getDrawable(i12);
        } catch (Exception e10) {
            Log.d("FoldScreenCallCardUtils", "getCardIcon: has exception = " + e10.getMessage());
            return null;
        }
    }

    public static final void d(View view) {
        Log.d("FoldScreenCallCardUtils", "refresh fold screen ui");
        if (view != null) {
            view.requestLayout();
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                parent.requestLayout();
            }
        }
    }
}
