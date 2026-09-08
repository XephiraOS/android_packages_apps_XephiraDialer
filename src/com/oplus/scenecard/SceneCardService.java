package com.oplus.scenecard;

import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Outline;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Pair;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceControlViewHost;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.oplus.coreapp.appfeature.AppFeatureProviderUtils;
import com.oplus.scenecard.ISceneCardService;
import com.oplus.scenecard.SceneCardService;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public abstract class SceneCardService extends Service {

    /* renamed from: b, reason: collision with root package name */
    public int f28934b;

    /* renamed from: c, reason: collision with root package name */
    public int f28935c;

    /* renamed from: d, reason: collision with root package name */
    public Executor f28936d;

    /* renamed from: e, reason: collision with root package name */
    public Context f28937e;

    /* renamed from: a, reason: collision with root package name */
    public final int f28933a = 1;

    /* renamed from: f, reason: collision with root package name */
    public float f28938f = 25.0f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap<Integer, Pair<IBinder, SurfaceControlViewHost>> f28939g = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public final ISceneCardService f28940h = new AnonymousClass1();

    /* renamed from: i, reason: collision with root package name */
    public final ContentObserver f28941i = new a(new Handler(Looper.getMainLooper()));

    /* renamed from: com.oplus.scenecard.SceneCardService$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends ISceneCardService.Stub {
        public AnonymousClass1() {
        }

        @Override // com.oplus.scenecard.ISceneCardService
        public void B4(final GetCardRequest getCardRequest, final IShowCardCallback iShowCardCallback) {
            SceneCardService.this.f28936d.execute(new Runnable() { // from class: com.oplus.scenecard.i
                @Override // java.lang.Runnable
                public final void run() {
                    SceneCardService.AnonymousClass1.this.a8(getCardRequest, iShowCardCallback);
                }
            });
        }

        @Override // com.oplus.scenecard.ISceneCardService
        public void G0(final int i10) {
            SceneCardService.this.f28936d.execute(new Runnable() { // from class: com.oplus.scenecard.f
                @Override // java.lang.Runnable
                public final void run() {
                    SceneCardService.AnonymousClass1.this.Z7(i10);
                }
            });
        }

        @Override // com.oplus.scenecard.ISceneCardService
        public void N0(final int i10) {
            SceneCardService.this.f28936d.execute(new Runnable() { // from class: com.oplus.scenecard.c
                @Override // java.lang.Runnable
                public final void run() {
                    SceneCardService.AnonymousClass1.this.c8(i10);
                }
            });
        }

        @Override // com.oplus.scenecard.ISceneCardService
        public void V0(final Bundle bundle) {
            SceneCardService.this.f28936d.execute(new Runnable() { // from class: com.oplus.scenecard.e
                @Override // java.lang.Runnable
                public final void run() {
                    SceneCardService.AnonymousClass1.this.e8(bundle);
                }
            });
        }

        public final /* synthetic */ void W7(Configuration configuration) {
            SceneCardService.this.i(configuration);
        }

        public final /* synthetic */ void X7(int i10) {
            SceneCardService.this.j(i10);
        }

        public final /* synthetic */ void Y7(int i10) {
            SceneCardService.this.l(i10);
        }

        public final /* synthetic */ void Z7(int i10) {
            SceneCardService.this.m(i10);
        }

        public final /* synthetic */ void a8(GetCardRequest getCardRequest, IShowCardCallback iShowCardCallback) {
            SceneCardService.this.n(getCardRequest, iShowCardCallback);
        }

        public final /* synthetic */ void b8(int i10) {
            SceneCardService.this.o(i10);
        }

        public final /* synthetic */ void c8(int i10) {
            SceneCardService.this.p(i10);
        }

        public final /* synthetic */ void d8(boolean z10) {
            SceneCardService.this.r(z10);
        }

        @Override // com.oplus.scenecard.ISceneCardService
        public void e6(final boolean z10) {
            SceneCardService.this.f28936d.execute(new Runnable() { // from class: com.oplus.scenecard.h
                @Override // java.lang.Runnable
                public final void run() {
                    SceneCardService.AnonymousClass1.this.d8(z10);
                }
            });
        }

        public final /* synthetic */ void e8(Bundle bundle) {
            SceneCardService.this.t(bundle);
        }

        @Override // com.oplus.scenecard.ISceneCardService
        public void w0(final Configuration configuration) {
            SceneCardService.this.f28936d.execute(new Runnable() { // from class: com.oplus.scenecard.d
                @Override // java.lang.Runnable
                public final void run() {
                    SceneCardService.AnonymousClass1.this.W7(configuration);
                }
            });
        }

        @Override // com.oplus.scenecard.ISceneCardService
        public void x6(final int i10) {
            SceneCardService.this.f28936d.execute(new Runnable() { // from class: com.oplus.scenecard.j
                @Override // java.lang.Runnable
                public final void run() {
                    SceneCardService.AnonymousClass1.this.b8(i10);
                }
            });
        }

        @Override // com.oplus.scenecard.ISceneCardService
        public void x7(final int i10) {
            SceneCardService.this.f28936d.execute(new Runnable() { // from class: com.oplus.scenecard.b
                @Override // java.lang.Runnable
                public final void run() {
                    SceneCardService.AnonymousClass1.this.Y7(i10);
                }
            });
        }

        @Override // com.oplus.scenecard.ISceneCardService
        public void z6(final int i10) {
            SceneCardService.this.f28936d.execute(new Runnable() { // from class: com.oplus.scenecard.g
                @Override // java.lang.Runnable
                public final void run() {
                    SceneCardService.AnonymousClass1.this.X7(i10);
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri, int i10) {
            super.onChange(z10, uri, i10);
            com.oplus.scenecard.a.c("SceneCardService", "gesture degrees change.");
            SceneCardService sceneCardService = SceneCardService.this;
            sceneCardService.u(sceneCardService.getContentResolver());
        }
    }

    /* loaded from: classes3.dex */
    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 48.0f);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends FrameLayout {

        /* renamed from: a, reason: collision with root package name */
        public IBinder f28945a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f28946b;

        /* renamed from: c, reason: collision with root package name */
        public int f28947c;

        /* renamed from: d, reason: collision with root package name */
        public int f28948d;

        /* renamed from: e, reason: collision with root package name */
        public int f28949e;

        public c(Context context) {
            super(context);
            a(context);
        }

        public final void a(Context context) {
            this.f28947c = ViewConfiguration.get(context).getScaledTouchSlop();
        }

        public void b(IBinder iBinder) {
            this.f28945a = iBinder;
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 2 && this.f28946b) {
                    int x10 = (int) (motionEvent.getX() - this.f28948d);
                    int y10 = (int) (motionEvent.getY() - this.f28949e);
                    int i10 = (x10 * x10) + (y10 * y10);
                    int i11 = this.f28947c;
                    if (i10 > i11 * i11) {
                        this.f28946b = false;
                        double degrees = Math.toDegrees(Math.atan2(y10, x10));
                        if (Math.abs(degrees) <= SceneCardService.this.f28938f || Math.abs(degrees) > 180.0d - SceneCardService.this.f28938f) {
                            return true;
                        }
                    }
                }
            } else {
                this.f28948d = (int) motionEvent.getX();
                this.f28949e = (int) motionEvent.getY();
                this.f28946b = true;
                com.oplus.scenecard.a.a("SceneCardService", "dispatchTouchEvent: " + motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    public abstract View f(Context context, int i10, int i11, int i12);

    public final Context g(int i10) {
        Context createDisplayContext = createDisplayContext(((DisplayManager) getSystemService(DisplayManager.class)).getDisplay(i10));
        createDisplayContext.setTheme(getThemeResId());
        return createDisplayContext;
    }

    public final void h() {
        Context context = this.f28937e;
        if (context != null) {
            Display display = context.getDisplay();
            if (display != null) {
                Point point = new Point();
                display.getRealSize(point);
                this.f28934b = point.x;
                this.f28935c = point.y;
            }
            com.oplus.scenecard.a.c("SceneCardService", "initDefaultSize: mWidth: " + this.f28934b + " mHeight: " + this.f28935c);
        }
    }

    public void i(Configuration configuration) {
        com.oplus.scenecard.a.c("SceneCardService", "onCardConfigurationChanged: ");
        s();
        Context context = this.f28937e;
        if (context != null) {
            context.getResources().updateConfiguration(configuration, this.f28937e.getResources().getDisplayMetrics());
        }
    }

    public final void j(int i10) {
        k(this.f28937e, i10);
    }

    public void k(Context context, int i10) {
        com.oplus.scenecard.a.c("SceneCardService", "onCardCreate: " + i10);
    }

    public void l(int i10) {
        com.oplus.scenecard.a.c("SceneCardService", "onCardDestroy: " + i10 + " release.");
        Pair<IBinder, SurfaceControlViewHost> remove = this.f28939g.remove(Integer.valueOf(i10));
        if (remove != null) {
            ((SurfaceControlViewHost) remove.second).release();
        }
    }

    public void m(int i10) {
        com.oplus.scenecard.a.c("SceneCardService", "onCardPause: " + i10);
    }

    public final void n(GetCardRequest getCardRequest, IShowCardCallback iShowCardCallback) {
        boolean z10;
        SurfaceControlViewHost surfaceControlViewHost;
        int i10 = getCardRequest.i();
        int h10 = getCardRequest.h();
        int b10 = getCardRequest.b();
        int d10 = getCardRequest.d();
        GetCardResponse getCardResponse = new GetCardResponse(b10);
        IBinder f10 = getCardRequest.f();
        if (i10 <= 0 || h10 <= 0) {
            i10 = this.f28934b;
            h10 = this.f28935c;
        }
        try {
            Size size = new Size(i10, h10);
            Pair<IBinder, SurfaceControlViewHost> pair = this.f28939g.get(Integer.valueOf(b10));
            StringBuilder sb = new StringBuilder();
            sb.append("onCardRequestShow: displayId ");
            sb.append(d10);
            sb.append(" hostInputToken: ");
            sb.append(f10);
            sb.append(" width: ");
            sb.append(size.getWidth());
            sb.append(" height: ");
            sb.append(size.getHeight());
            sb.append(" cardId: ");
            sb.append(b10);
            sb.append(" surfaceViewHost is null ? ");
            if (pair == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb.append(z10);
            com.oplus.scenecard.a.c("SceneCardService", sb.toString());
            if (pair != null && pair.first != f10) {
                com.oplus.scenecard.a.c("SceneCardService", "Release expired surfaceViewHost with token=" + pair.first);
                ((SurfaceControlViewHost) pair.second).release();
                this.f28939g.remove(Integer.valueOf(b10));
                pair = null;
            }
            if (pair == null) {
                c cVar = new c(this.f28937e);
                cVar.b(f10);
                View f11 = f(this.f28937e, b10, size.getWidth(), size.getHeight());
                if (f11 == null) {
                    return;
                }
                cVar.removeAllViews();
                if (f11.getParent() != null) {
                    ((ViewGroup) f11.getParent()).removeView(f11);
                }
                cVar.addView(f11);
                cVar.setOutlineProvider(new b());
                cVar.setClipToOutline(true);
                Context context = this.f28937e;
                surfaceControlViewHost = new SurfaceControlViewHost(context, context.getDisplay(), f10);
                surfaceControlViewHost.setView(cVar, size.getWidth(), size.getHeight());
                this.f28939g.put(Integer.valueOf(b10), new Pair<>(f10, surfaceControlViewHost));
            } else {
                surfaceControlViewHost = (SurfaceControlViewHost) pair.second;
            }
            getCardResponse.b(surfaceControlViewHost.getSurfacePackage());
            iShowCardCallback.Z4(getCardResponse);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public void o(int i10) {
        com.oplus.scenecard.a.c("SceneCardService", "onCardResume: " + i10);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f28940h.asBinder();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f28936d = getMainExecutor();
        this.f28937e = g(1);
        h();
        q(this.f28937e);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        s();
        getContentResolver().unregisterContentObserver(this.f28941i);
    }

    public void p(int i10) {
        com.oplus.scenecard.a.c("SceneCardService", "onCardUnsubscribed: " + i10);
    }

    public void q(Context context) {
        com.oplus.scenecard.a.c("SceneCardService", "onCreate: ");
        u(getContentResolver());
        getContentResolver().registerContentObserver(Settings.System.getUriFor("secondary_card_gesture_min_settings"), false, this.f28941i);
    }

    public void r(boolean z10) {
        com.oplus.scenecard.a.c("SceneCardService", "onLockStateChanged: ");
    }

    public final void s() {
        HashMap<Integer, Pair<IBinder, SurfaceControlViewHost>> hashMap = this.f28939g;
        if (hashMap != null) {
            for (Integer num : hashMap.keySet()) {
                num.intValue();
                ((SurfaceControlViewHost) this.f28939g.get(num).second).release();
            }
            this.f28939g.clear();
        }
    }

    public void t(Bundle bundle) {
        com.oplus.scenecard.a.c("SceneCardService", "sendCommand");
    }

    public final void u(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return;
        }
        float f10 = Settings.System.getFloat(contentResolver, "secondary_card_gesture_min_settings", 0.0f);
        if (f10 > 0.0f && f10 < 90.0f) {
            this.f28938f = f10;
        } else {
            this.f28938f = AppFeatureProviderUtils.e(contentResolver, "secondary.card.gesture.min.degrees", 25.0f);
        }
        com.oplus.scenecard.a.c("SceneCardService", "updateDegrees: " + f10 + ", degrees: " + this.f28938f);
    }
}
