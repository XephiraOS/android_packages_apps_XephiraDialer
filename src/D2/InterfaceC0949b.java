package d2;

import A2.j;
import A2.l;
import android.app.Application;
import android.content.Context;
import com.android.incallui.AudioModeProvider;
import com.android.incallui.CallList;
import com.android.incallui.InCallPresenter;
import com.android.incallui.OplusCallList;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusInCallPresenter;
import com.android.incallui.OplusProximitySensor;
import com.android.incallui.ProximitySensor;
import com.android.incallui.TelecomAdapter;
import com.android.oplus.brand.BrandCenter;
import com.internal_dependency.AddOnSdkDepends;
import kotlin.jvm.internal.i;

/* compiled from: BaseRepository.kt */
/* renamed from: d2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0949b {
    OplusInCallPresenter C0();

    void f();

    /* compiled from: BaseRepository.kt */
    /* renamed from: d2.b$a */
    /* loaded from: classes.dex */
    public static final class a {
        public static AddOnSdkDepends a(InterfaceC0949b interfaceC0949b) {
            return AddOnSdkDepends.Companion.getSInstance();
        }

        public static Application b(InterfaceC0949b interfaceC0949b) {
            Application inCallAppInstance = OplusInCallApp.getInCallAppInstance();
            i.e(inCallAppInstance, "getInCallAppInstance()");
            return inCallAppInstance;
        }

        public static AudioModeProvider c(InterfaceC0949b interfaceC0949b) {
            AudioModeProvider audioModeProvider = AudioModeProvider.getInstance();
            i.e(audioModeProvider, "getInstance()");
            return audioModeProvider;
        }

        public static BrandCenter d(InterfaceC0949b interfaceC0949b) {
            return BrandCenter.f19187a.a();
        }

        public static OplusCallList e(InterfaceC0949b interfaceC0949b) {
            CallList callList = CallList.getInstance();
            i.d(callList, "null cannot be cast to non-null type com.android.incallui.OplusCallList");
            return (OplusCallList) callList;
        }

        public static A2.c f(InterfaceC0949b interfaceC0949b) {
            A2.c d10 = A2.c.d();
            i.e(d10, "getInstance()");
            return d10;
        }

        public static j g(InterfaceC0949b interfaceC0949b) {
            j J10 = j.J();
            i.e(J10, "getInstance()");
            return J10;
        }

        public static Context h(InterfaceC0949b interfaceC0949b) {
            Context defaultDisplayUiContext = OplusInCallApp.getDefaultDisplayUiContext();
            i.e(defaultDisplayUiContext, "getDefaultDisplayUiContext()");
            return defaultDisplayUiContext;
        }

        public static l i(InterfaceC0949b interfaceC0949b) {
            l d10 = l.d();
            i.e(d10, "getInstance()");
            return d10;
        }

        public static OplusInCallPresenter j(InterfaceC0949b interfaceC0949b) {
            OplusInCallPresenter realInstance = InCallPresenter.getInstance().realInstance();
            i.e(realInstance, "getInstance().realInstance()");
            return realInstance;
        }

        public static OplusProximitySensor k(InterfaceC0949b interfaceC0949b) {
            ProximitySensor proximitySensor = interfaceC0949b.C0().getProximitySensor();
            if (proximitySensor instanceof OplusProximitySensor) {
                return (OplusProximitySensor) proximitySensor;
            }
            return null;
        }

        public static TelecomAdapter l(InterfaceC0949b interfaceC0949b) {
            TelecomAdapter telecomAdapter = TelecomAdapter.getInstance();
            i.e(telecomAdapter, "getInstance()");
            return telecomAdapter;
        }

        public static void m(InterfaceC0949b interfaceC0949b) {
        }
    }
}
