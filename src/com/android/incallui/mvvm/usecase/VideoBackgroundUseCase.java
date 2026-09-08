package com.android.incallui.mvvm.usecase;

import A2.z;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.lifecycle.w;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.OplusInCallApp;
import com.android.incallui.OplusPhoneUserActionStatistics;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.TelecomAdapter;
import com.android.incallui.WearInfoQueryUtils;
import com.android.incallui.mvvm.usecase.VideoBackgroundUseCase;
import com.android.incallui.mvvm.usecase.a;
import com.android.incallui.mvvm.usecase.b;
import com.android.incallui.mvvm.utils.IgnoreEqualsLiveDataKt;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.utils.y;
import d2.C0950c;
import e2.C0968c;
import e2.C0969d;
import f2.c;
import kotlin.jvm.internal.i;
import m9.g;
import m9.q;
import v9.l;
import v9.p;

/* compiled from: VideoBackgroundUseCase.kt */
/* loaded from: classes.dex */
public final class VideoBackgroundUseCase extends C0950c {

    /* renamed from: c, reason: collision with root package name */
    public static M8.a f18571c;

    /* renamed from: e, reason: collision with root package name */
    public static final h<Drawable> f18573e;

    /* renamed from: f, reason: collision with root package name */
    public static ViewGroup f18574f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f18575g;

    /* renamed from: h, reason: collision with root package name */
    public static P8.b<Object> f18576h;

    /* renamed from: i, reason: collision with root package name */
    public static final h<Integer> f18577i;

    /* renamed from: j, reason: collision with root package name */
    public static final y<Integer> f18578j;

    /* renamed from: a, reason: collision with root package name */
    public static final VideoBackgroundUseCase f18569a = new VideoBackgroundUseCase();

    /* renamed from: b, reason: collision with root package name */
    public static Handler f18570b = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    public static final O8.b f18572d = new a();

    /* compiled from: VideoBackgroundUseCase.kt */
    /* loaded from: classes.dex */
    public static final class a implements O8.b {
        public static final void f(int i10) {
            VideoBackgroundUseCase.f18569a.u(i10);
        }

        @Override // O8.b
        public void a(final int i10) {
            Log.d("VideoBackgroundUseCase", "video show startRing type = " + i10);
            if (z.b()) {
                VideoBackgroundUseCase.f18569a.u(i10);
            } else {
                VideoBackgroundUseCase.f18570b.post(new Runnable() { // from class: f2.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoBackgroundUseCase.a.f(i10);
                    }
                });
            }
        }

        @Override // O8.b
        public void b() {
            Log.d("VideoBackgroundUseCase", "onVideoShowStart ");
            VideoBackgroundUseCase.f18569a.j().o(2);
        }

        @Override // O8.b
        public void c() {
            Log.d("VideoBackgroundUseCase", "onVideoShowDestroyed mVideoShowController=" + VideoBackgroundUseCase.f18571c);
            VideoBackgroundUseCase.f18571c = null;
            VideoBackgroundUseCase.f18569a.j().o(0);
        }

        @Override // O8.b
        public void d(int i10) {
            Log.d("VideoBackgroundUseCase", "onVideoShowFailed reason = " + i10);
            a(0);
        }
    }

    static {
        h<Drawable> hVar = new h<>(true);
        final VideoBackgroundUseCase$mVideoPreview$1$1 videoBackgroundUseCase$mVideoPreview$1$1 = new l<Drawable, q>() { // from class: com.android.incallui.mvvm.usecase.VideoBackgroundUseCase$mVideoPreview$1$1
            public final void b(Drawable drawable) {
                Log.d("VideoBackgroundUseCase", ": mVideoPreview change " + drawable);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Drawable drawable) {
                b(drawable);
                return q.f35511a;
            }
        };
        hVar.j(new w() { // from class: f2.e
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                VideoBackgroundUseCase.q(l.this, obj);
            }
        });
        f18573e = hVar;
        h<Integer> hVar2 = new h<>(0, true);
        final VideoBackgroundUseCase$mVideoBackgroundState$1$1 videoBackgroundUseCase$mVideoBackgroundState$1$1 = new l<Integer, q>() { // from class: com.android.incallui.mvvm.usecase.VideoBackgroundUseCase$mVideoBackgroundState$1$1
            public final void b(Integer state) {
                StringBuilder sb = new StringBuilder();
                sb.append("video background state change ");
                a.C0181a c0181a = a.f18583b;
                i.e(state, "state");
                sb.append(c0181a.a(state.intValue()));
                Log.d("VideoBackgroundUseCase", sb.toString());
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Integer num) {
                b(num);
                return q.f35511a;
            }
        };
        hVar2.j(new w() { // from class: f2.f
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                VideoBackgroundUseCase.o(l.this, obj);
            }
        });
        f18577i = hVar2;
        c cVar = c.f31677a;
        y<Integer> y10 = IgnoreEqualsLiveDataKt.y(g.a(cVar.e(), cVar.d()), 0, true, new p<C0968c, Integer, Integer>() { // from class: com.android.incallui.mvvm.usecase.VideoBackgroundUseCase$mVideoBackgroundType$1
            public final Integer b(C0968c c0968c, int i10) {
                Uri uri;
                boolean isInComming = Call.State.isInComming(i10);
                int i11 = 0;
                if (isInComming) {
                    if (c0968c != null) {
                        uri = c0968c.c();
                    } else {
                        uri = null;
                    }
                    if (uri != null) {
                        i11 = 2;
                    } else if (!C0969d.a(c0968c) && R8.b.f() && R8.b.d()) {
                        i11 = 1;
                    }
                }
                return Integer.valueOf(i11);
            }

            @Override // v9.p
            public /* bridge */ /* synthetic */ Integer invoke(C0968c c0968c, Integer num) {
                return b(c0968c, num.intValue());
            }
        });
        final VideoBackgroundUseCase$mVideoBackgroundType$2$1 videoBackgroundUseCase$mVideoBackgroundType$2$1 = new l<Integer, q>() { // from class: com.android.incallui.mvvm.usecase.VideoBackgroundUseCase$mVideoBackgroundType$2$1
            public final void b(Integer videoBackgroundType) {
                StringBuilder sb = new StringBuilder();
                sb.append("observe video backgroundType change: ");
                b.a aVar = b.f18585c;
                i.e(videoBackgroundType, "videoBackgroundType");
                sb.append(aVar.a(videoBackgroundType.intValue()));
                Log.d("VideoBackgroundUseCase", sb.toString());
                P8.a aVar2 = null;
                if (videoBackgroundType.intValue() != 1) {
                    VideoBackgroundUseCase.f18569a.l().o(null);
                }
                VideoBackgroundUseCase videoBackgroundUseCase = VideoBackgroundUseCase.f18569a;
                if (videoBackgroundType.intValue() == 0 || (!OplusPhoneUtils.isZenMode() && !videoBackgroundUseCase.m())) {
                    aVar2 = videoBackgroundUseCase.i(videoBackgroundType.intValue());
                } else {
                    Log.d("VideoBackgroundUseCase", "zenMode or Mt Call by watch can not show video background return");
                }
                videoBackgroundUseCase.t(aVar2);
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Integer num) {
                b(num);
                return q.f35511a;
            }
        };
        y10.j(new w() { // from class: f2.g
            @Override // androidx.lifecycle.w
            public final void onChanged(Object obj) {
                VideoBackgroundUseCase.p(l.this, obj);
            }
        });
        f18578j = y10;
    }

    public static final void o(l tmp0, Object obj) {
        i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void p(l tmp0, Object obj) {
        i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void q(l tmp0, Object obj) {
        i.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final P8.a<Object> i(int i10) {
        P8.a<Object> aVar;
        Uri uri = null;
        if (i10 != 1) {
            if (i10 != 2) {
                return null;
            }
            C0968c value = c.f31677a.e().getValue();
            if (value != null) {
                uri = value.c();
            }
            aVar = new P8.a<>(uri);
        } else {
            try {
                String c10 = R8.b.c();
                String b10 = R8.b.b();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                f18573e.o(new BitmapDrawable(a().getResources(), BitmapFactory.decodeFile(b10, options)));
                aVar = new P8.a<>(c10);
            } catch (IllegalArgumentException e10) {
                Log.d("VideoBackgroundUseCase", "createVideoBackgroundSource: exception=" + e10.getMessage());
                return null;
            }
        }
        return aVar;
    }

    public final h<Integer> j() {
        return f18577i;
    }

    public final y<Integer> k() {
        return f18578j;
    }

    public final h<Drawable> l() {
        return f18573e;
    }

    public final boolean m() {
        if (!OplusPhoneUtils.isSupportHideMTCallUiByWatch(OplusInCallApp.getAppContext())) {
            Log.d("VideoBackgroundUseCase", "Telecom is not support hide incoming call by watch");
            return false;
        }
        if (!I2.a.e(OplusInCallApp.getAppContext().getContentResolver()) || !WearInfoQueryUtils.INSTANCE.getMHideIncomingCallUiByWear()) {
            return false;
        }
        Log.d("VideoBackgroundUseCase", " Mt Call by watch can not show video background return");
        return true;
    }

    public final boolean n() {
        if (f18577i.getValue().intValue() != 0) {
            return true;
        }
        return false;
    }

    public final void r(boolean z10) {
        f18575g = z10;
        M8.a aVar = f18571c;
        if (aVar != null) {
            aVar.d(z10);
        }
    }

    public final void s(ViewGroup viewGroup) {
        f18574f = viewGroup;
        M8.a aVar = f18571c;
        if (aVar != null) {
            aVar.c(viewGroup);
        }
    }

    public final void t(P8.b<Object> bVar) {
        f18576h = bVar;
        M8.a aVar = null;
        if (P8.c.a(bVar)) {
            M8.a aVar2 = f18571c;
            if (aVar2 == null) {
                M8.a a10 = M8.b.a(OplusInCallApp.getDefaultDisplayUiContext(), f18572d);
                if (a10 != null) {
                    a10.d(f18575g);
                    a10.f(bVar);
                    a10.c(f18574f);
                    aVar = a10;
                }
                f18571c = aVar;
                Log.d("VideoBackgroundUseCase", "init videoBackgroundController=" + f18571c);
                f18577i.o(1);
                return;
            }
            if (aVar2 != null) {
                aVar2.f(bVar);
                return;
            }
            return;
        }
        f18573e.o(null);
        M8.a aVar3 = f18571c;
        if (aVar3 != null) {
            aVar3.b();
        }
        f18571c = null;
        f18577i.o(0);
    }

    public final void u(int i10) {
        Call incomingCall = CallList.getInstance().getIncomingCall();
        if (incomingCall == null) {
            OplusPhoneUserActionStatistics.addNoIncomingRingAction(OplusInCallApp.getAppContext(), OplusPhoneUserActionStatistics.USER_ACTION_INCOMING_CALL_NULL, "InCallVideoShow");
            return;
        }
        String telecommCallId = TelecomAdapter.getInstance().oplusTelecomAdapter().getTelecommCallId(incomingCall.getId());
        if (telecommCallId != null) {
            A2.l.d().l(telecommCallId, i10, "InCallVideoShow");
        } else {
            OplusPhoneUserActionStatistics.addNoIncomingRingAction(OplusInCallApp.getAppContext(), OplusPhoneUserActionStatistics.USER_ACTION_INCOMING_CALL_ID_NULL, "InCallVideoShow");
        }
    }
}
