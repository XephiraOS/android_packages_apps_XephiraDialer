package N8;

import N8.h;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import android.view.Surface;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import m9.q;

/* compiled from: VideoShowPlayerImpl.kt */
/* loaded from: classes4.dex */
public final class h extends Y7.c implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, N8.d {

    /* renamed from: y, reason: collision with root package name */
    public static final c f2394y = new c(null);

    /* renamed from: z, reason: collision with root package name */
    public static final SparseArray<String> f2395z = new b();

    /* renamed from: d, reason: collision with root package name */
    public final Context f2396d;

    /* renamed from: e, reason: collision with root package name */
    public int f2397e;

    /* renamed from: f, reason: collision with root package name */
    public final double[] f2398f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2399g;

    /* renamed from: h, reason: collision with root package name */
    public int f2400h;

    /* renamed from: i, reason: collision with root package name */
    public String f2401i;

    /* renamed from: j, reason: collision with root package name */
    public final a f2402j;

    /* renamed from: k, reason: collision with root package name */
    public final a f2403k;

    /* renamed from: l, reason: collision with root package name */
    public final a f2404l;

    /* renamed from: m, reason: collision with root package name */
    public final a f2405m;

    /* renamed from: n, reason: collision with root package name */
    public final a f2406n;

    /* renamed from: o, reason: collision with root package name */
    public final Set<O8.c> f2407o;

    /* renamed from: p, reason: collision with root package name */
    public N8.c f2408p;

    /* renamed from: q, reason: collision with root package name */
    public AudioManager f2409q;

    /* renamed from: r, reason: collision with root package name */
    public P8.b<Object> f2410r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2411s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2412t;

    /* renamed from: u, reason: collision with root package name */
    public Surface f2413u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f2414v;

    /* renamed from: w, reason: collision with root package name */
    public final O8.a f2415w;

    /* renamed from: x, reason: collision with root package name */
    public final AudioManager.OnAudioFocusChangeListener f2416x;

    /* compiled from: VideoShowPlayerImpl.kt */
    /* loaded from: classes4.dex */
    public class a extends Y7.b {
        public a() {
        }

        @Override // Y7.b
        public void a() {
            h hVar = h.this;
            String name = getName();
            kotlin.jvm.internal.i.e(name, "name");
            hVar.f2401i = name;
            h.this.q0("StateChanger  Enter ");
        }

        @Override // Y7.b
        public void b() {
            h.this.q0("BaseState  exit " + getName());
        }

        @Override // Y7.b
        public boolean c(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            h.this.q0("base processMessage what =" + ((String) h.f2395z.get(msg.what)));
            switch (msg.what) {
                case 1:
                    h hVar = h.this;
                    hVar.H0(hVar.f2402j);
                    return true;
                case 2:
                    h hVar2 = h.this;
                    hVar2.H0(hVar2.f2403k);
                    return true;
                case 3:
                    h hVar3 = h.this;
                    hVar3.H0(hVar3.f2404l);
                    return true;
                case 4:
                    h hVar4 = h.this;
                    hVar4.H0(hVar4.f2405m);
                    return true;
                case 5:
                    h hVar5 = h.this;
                    hVar5.H0(hVar5.f2406n);
                    return true;
                case 6:
                    return true;
                case 7:
                    h hVar6 = h.this;
                    hVar6.H0(hVar6.f2402j);
                    h.this.u();
                    return true;
                case 8:
                    h.this.q0("base processMessage ignore replay ");
                    return true;
                default:
                    return false;
            }
        }
    }

    /* compiled from: VideoShowPlayerImpl.kt */
    /* loaded from: classes4.dex */
    public static final class b extends SparseArray<String> {
        public b() {
            put(1, "enter_idle_state");
            put(2, "enter_prepare_state");
            put(3, "enter_play_state");
            put(4, "enter_pause_state");
            put(5, "enter_stop_state");
            put(6, "enter_release_state");
            put(7, "quit_state_machine");
            put(8, "enter_enter_replay");
            put(100, "event_fadeup");
            put(101, "event_get_current_position");
        }
    }

    /* compiled from: VideoShowPlayerImpl.kt */
    /* loaded from: classes4.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: VideoShowPlayerImpl.kt */
    /* loaded from: classes4.dex */
    public final class d extends a {
        public d() {
            super();
        }

        @Override // N8.h.a, Y7.b
        public void a() {
            super.a();
            h.D0(h.this, 1, false, 2, null);
            h.this.f2411s = true;
        }

        @Override // N8.h.a, Y7.b
        public void b() {
            super.b();
            h.this.f2411s = false;
        }

        @Override // N8.h.a, Y7.b
        public boolean c(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            h.this.q0("IdleState processMessage msg = " + ((String) h.f2395z.get(msg.what)));
            if (6 == msg.what) {
                h.this.G0();
                return true;
            }
            return super.c(msg);
        }

        @Override // Y7.b, Y7.a
        public String getName() {
            return "IdleState";
        }
    }

    /* compiled from: VideoShowPlayerImpl.kt */
    /* loaded from: classes4.dex */
    public final class e extends a {
        public e() {
            super();
        }

        @Override // N8.h.a, Y7.b
        public void a() {
            super.a();
            h.this.s0();
        }

        @Override // N8.h.a, Y7.b
        public boolean c(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            h.this.q0("PauseState processMessage msg = " + ((String) h.f2395z.get(msg.what)));
            return super.c(msg);
        }

        @Override // Y7.b, Y7.a
        public String getName() {
            return "PauseState";
        }
    }

    /* compiled from: VideoShowPlayerImpl.kt */
    /* loaded from: classes4.dex */
    public final class f extends a {
        public f() {
            super();
        }

        @Override // N8.h.a, Y7.b
        public void a() {
            super.a();
            N8.c cVar = h.this.f2408p;
            if (cVar != null) {
                h hVar = h.this;
                hVar.t0();
                hVar.z(101, 20L);
                if (hVar.f2400h != 6 && hVar.f2400h != 7) {
                    h.D0(hVar, 4, false, 2, null);
                    if (hVar.f2399g) {
                        cVar.t(0.0f);
                        return;
                    } else {
                        cVar.t(0.0f);
                        hVar.x(100);
                        return;
                    }
                }
                cVar.k(0);
                cVar.t(0.0f);
                h.D0(hVar, 4, false, 2, null);
            }
        }

        @Override // N8.h.a, Y7.b
        public boolean c(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            h.this.q0("PlayingState processMessage msg = " + ((String) h.f2395z.get(msg.what)));
            int i10 = msg.what;
            if (i10 != 2) {
                if (i10 == 3) {
                    h.this.q0("already in playing state do nothing return");
                    return true;
                }
                if (i10 == 6) {
                    h.this.G0();
                    return true;
                }
                if (i10 == 8) {
                    h.this.z0();
                    return true;
                }
                if (i10 == 100) {
                    h.this.p0();
                    return true;
                }
                if (i10 == 101) {
                    if (!h.this.f2415w.a()) {
                        return true;
                    }
                    int o02 = h.this.o0();
                    h.this.q0("event_get_current_position  currentPosition = " + o02);
                    if (o02 > 0) {
                        h.D0(h.this, 5, false, 2, null);
                    } else {
                        h.this.z(101, 20L);
                    }
                }
                return super.c(msg);
            }
            if (h.this.f2414v) {
                h.this.q0("can not change state from play to ready return");
            } else {
                h.this.q0("surface has not been set, should prepare again!");
                h hVar = h.this;
                hVar.H0(hVar.f2403k);
            }
            return true;
        }

        @Override // Y7.b, Y7.a
        public String getName() {
            return "PlayingState";
        }
    }

    /* compiled from: VideoShowPlayerImpl.kt */
    /* loaded from: classes4.dex */
    public final class g extends a {
        public g() {
            super();
        }

        @Override // N8.h.a, Y7.b
        public void a() {
            super.a();
            h.this.v0();
        }

        @Override // N8.h.a, Y7.b
        public boolean c(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            h.this.q0("PrepareState processMessage msg = " + ((String) h.f2395z.get(msg.what)));
            if (msg.what == 2) {
                h.this.v0();
                return true;
            }
            return super.c(msg);
        }

        @Override // Y7.b, Y7.a
        public String getName() {
            return "PrepareState";
        }
    }

    /* compiled from: VideoShowPlayerImpl.kt */
    /* renamed from: N8.h$h, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public final class C0051h extends a {
        public C0051h() {
            super();
        }

        @Override // N8.h.a, Y7.b
        public void a() {
            super.a();
            h.this.w(100);
            h.this.w(101);
            h.D0(h.this, 7, false, 2, null);
            h.this.F0();
        }

        @Override // N8.h.a, Y7.b
        public boolean c(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            h.this.q0("IdleState processMessage msg = " + ((String) h.f2395z.get(msg.what)));
            if (6 == msg.what) {
                h.this.x0();
            }
            return super.c(msg);
        }

        @Override // Y7.b, Y7.a
        public String getName() {
            return "StopState";
        }
    }

    /* compiled from: VideoShowPlayerImpl.kt */
    /* loaded from: classes4.dex */
    public static final class i implements O8.a {
        public i() {
        }

        public static final void h(h this$0, Surface surface) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            if (!this$0.l0()) {
                this$0.B0(surface);
            } else {
                this$0.E0(surface);
            }
        }

        @Override // O8.a
        public boolean a() {
            if (h.this.f2400h == 5) {
                R8.a.f3357a.b("VideoShowPlayerImpl", "current is playing ");
                N8.c cVar = h.this.f2408p;
                if (cVar == null) {
                    return false;
                }
                return cVar.f();
            }
            R8.a.f3357a.b("VideoShowPlayerImpl", "current is not playing ");
            return false;
        }

        @Override // O8.a
        public void b(P8.b<Object> bVar) {
            h.this.f2410r = bVar;
            h.this.n0();
            h.this.x(2);
        }

        @Override // O8.a
        public int c() {
            N8.c cVar = h.this.f2408p;
            if (cVar != null) {
                return cVar.e();
            }
            return 0;
        }

        @Override // O8.a
        public void d(final Surface surface) {
            Handler h10 = h.this.h();
            if (h10 != null) {
                final h hVar = h.this;
                h10.post(new Runnable() { // from class: N8.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.i.h(h.this, surface);
                    }
                });
            }
        }

        @Override // O8.a
        public void e(boolean z10) {
            R8.a aVar = R8.a.f3357a;
            if (aVar.f()) {
                aVar.b("VideoShowPlayerImpl", "video show startToPlay videoOnly = " + z10);
            }
            if (h.this.f2408p != null) {
                h.this.f2399g = z10;
                h.this.y(3, z10 ? 1 : 0);
            }
        }

        @Override // O8.a
        public int f() {
            N8.c cVar = h.this.f2408p;
            if (cVar != null) {
                return cVar.d();
            }
            return 0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context mContext, HandlerThread thread, O8.c videoStateListener) {
        super("VideoShowPlayer", thread.getLooper());
        double[] dArr;
        kotlin.jvm.internal.i.f(mContext, "mContext");
        kotlin.jvm.internal.i.f(thread, "thread");
        kotlin.jvm.internal.i.f(videoStateListener, "videoStateListener");
        this.f2396d = mContext;
        this.f2401i = "unknown";
        d dVar = new d();
        this.f2402j = dVar;
        g gVar = new g();
        this.f2403k = gVar;
        f fVar = new f();
        this.f2404l = fVar;
        e eVar = new e();
        this.f2405m = eVar;
        C0051h c0051h = new C0051h();
        this.f2406n = c0051h;
        Set<O8.c> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap(8, 0.9f, 1));
        this.f2407o = newSetFromMap;
        this.f2415w = new i();
        this.f2416x = new AudioManager.OnAudioFocusChangeListener() { // from class: N8.f
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i10) {
                h.r0(h.this, i10);
            }
        };
        D0(this, -1, false, 2, null);
        g(dVar);
        g(gVar);
        g(fVar);
        g(eVar);
        g(c0051h);
        A(dVar);
        B();
        newSetFromMap.add(videoStateListener);
        Object systemService = mContext.getSystemService("audio");
        kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        this.f2409q = audioManager;
        kotlin.jvm.internal.i.c(audioManager);
        int streamVolume = audioManager.getStreamVolume(2);
        R8.a.f3357a.b("VideoShowPlayerImpl", "new VideoShowPlayer , currentVolume = " + streamVolume);
        if (streamVolume <= 8) {
            dArr = new double[]{0.06d, 0.24d, 0.5d, 1.0d};
        } else {
            dArr = new double[]{0.0625d, 0.1111d, 0.1736d, 0.25d, 0.34d, 0.444d, 0.5625d, 0.694d, 0.84d, 1.0d};
        }
        this.f2398f = dArr;
    }

    public static /* synthetic */ void D0(h hVar, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        hVar.C0(i10, z10);
    }

    public static final void r0(h this$0, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.q0("OnAudioFocusChangeListener focusChange =  " + i10);
        if (i10 != -3 && i10 != -2 && i10 != -1) {
            if (i10 == 1) {
                this$0.x(3);
                return;
            }
            return;
        }
        this$0.x(4);
    }

    public static final void w0(h this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Surface surface = this$0.f2413u;
        if (surface != null) {
            this$0.E0(surface);
            this$0.B0(null);
        }
    }

    public final void A0() {
        synchronized (this) {
            this.f2408p = null;
            q qVar = q.f35511a;
        }
    }

    public final void B0(Surface surface) {
        q0("setPendingSurface " + surface);
        this.f2413u = surface;
    }

    public final void C0(int i10, boolean z10) {
        Log.d("VideoShowPlayerImpl", "setPlayerState: " + R8.b.f3364a.a(i10));
        synchronized (this) {
            this.f2400h = i10;
            q qVar = q.f35511a;
        }
        if (!z10) {
            return;
        }
        Iterator<O8.c> it = this.f2407o.iterator();
        while (it.hasNext()) {
            it.next().e(i10);
        }
    }

    public final void E0(Surface surface) {
        q0("setSurfaceReal " + surface + ' ' + this.f2408p);
        N8.c cVar = this.f2408p;
        if (cVar != null) {
            try {
                cVar.s(surface);
                this.f2414v = true;
            } catch (IllegalStateException e10) {
                this.f2414v = false;
                D0(this, 8, false, 2, null);
                R8.a.f3357a.d("VideoShowPlayerImpl", "setSurface IllegalStateException  = " + e10.getMessage());
            } catch (Exception e11) {
                this.f2414v = false;
                D0(this, 8, false, 2, null);
                R8.a.f3357a.d("VideoShowPlayerImpl", "setSurface exception  = " + e11.getMessage());
            }
        }
    }

    public final void F0() {
        q0("stopPlay ");
        N8.c cVar = this.f2408p;
        if (cVar != null) {
            cVar.v();
        }
        G();
    }

    public final void G() {
        AudioManager audioManager = this.f2409q;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.f2416x);
        }
    }

    public final void G0() {
        q0("stopPlayAndRelease ");
        F0();
        x0();
    }

    public final void H0(Y7.a aVar) {
        q0("transitionTo =" + aVar.getName());
        C(aVar);
    }

    @Override // N8.d
    public O8.a a() {
        return this.f2415w;
    }

    @Override // N8.d
    public void b() {
        x(6);
        this.f2407o.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
    
        if (r0 != 9) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l0() {
        /*
            r3 = this;
            int r0 = r3.f2400h
            r1 = -1
            if (r0 == r1) goto L11
            r1 = 1
            if (r0 == r1) goto L11
            r2 = 8
            if (r0 == r2) goto L11
            r2 = 9
            if (r0 == r2) goto L11
            goto L12
        L11:
            r1 = 0
        L12:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "canSetSurface mPlayerState: "
            r0.append(r2)
            int r2 = r3.f2400h
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.q0(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: N8.h.l0():boolean");
    }

    public final void m0() {
        q0("clean  mIsQuit = " + this.f2412t);
        this.f2399g = false;
    }

    public final void n0() {
        synchronized (this) {
            try {
                if (this.f2408p == null) {
                    N8.c cVar = new N8.c();
                    this.f2408p = cVar;
                    cVar.q(this);
                    N8.c cVar2 = this.f2408p;
                    if (cVar2 != null) {
                        cVar2.o(this);
                    }
                }
                q qVar = q.f35511a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int o0() {
        N8.c cVar = this.f2408p;
        if (cVar != null) {
            return cVar.c();
        }
        return -1;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer player) {
        kotlin.jvm.internal.i.f(player, "player");
        R8.a.f3357a.b("VideoShowPlayerImpl", "---onCompletion--- ");
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer player, int i10, int i11) {
        kotlin.jvm.internal.i.f(player, "player");
        R8.a.f3357a.b("VideoShowPlayerImpl", "---onError--- ");
        D0(this, 8, false, 2, null);
        return false;
    }

    public final void p0() {
        R8.a aVar = R8.a.f3357a;
        aVar.a(this, "handleFadeUp...FadeUpCount = " + this.f2397e + ", length of Volume Array is " + this.f2398f.length);
        if (this.f2408p == null) {
            return;
        }
        if (this.f2397e < this.f2398f.length) {
            aVar.a(this, "Ringtone setVolume " + ((float) this.f2398f[this.f2397e]));
            z(100, 500L);
            N8.c cVar = this.f2408p;
            kotlin.jvm.internal.i.c(cVar);
            cVar.t((float) this.f2398f[this.f2397e]);
            this.f2397e++;
            return;
        }
        this.f2397e = 0;
    }

    public final void q0(String str) {
        R8.a.f3357a.b("VideoShowPlayerImpl", this.f2401i + "  " + str);
    }

    public final void s0() {
        q0("pausePlay ");
        N8.c cVar = this.f2408p;
        if (cVar != null) {
            cVar.g();
            D0(this, 6, false, 2, null);
            G();
        }
    }

    public final void t0() {
        R8.a aVar = R8.a.f3357a;
        if (aVar.f()) {
            aVar.b("VideoShowPlayerImpl", "real startToPlay..." + this.f2400h);
        }
        N8.c cVar = this.f2408p;
        if (cVar != null) {
            y0();
            try {
                cVar.u();
            } catch (Exception e10) {
                R8.a.f3357a.d("VideoShowPlayerImpl", "startToPlay  error:" + e10.getMessage());
                D0(this, 8, false, 2, null);
            }
        }
    }

    public final void u0() {
        if (this.f2412t) {
            return;
        }
        this.f2412t = true;
        w(100);
        w(101);
        D0(this, -1, false, 2, null);
        u();
        m0();
    }

    public final boolean v0() {
        Object e10;
        n0();
        N8.c cVar = this.f2408p;
        if (cVar != null) {
            try {
                cVar.j();
                P8.b<Object> bVar = this.f2410r;
                if (bVar != null && (e10 = bVar.e()) != null) {
                    if (e10 instanceof Uri) {
                        cVar.l(this.f2396d, (Uri) e10);
                    } else if (e10 instanceof String) {
                        cVar.m((String) e10);
                    } else {
                        R8.a.f3357a.d("VideoShowPlayerImpl", "error invalid source ");
                        return false;
                    }
                }
                cVar.n(true);
                cVar.h(2);
                Handler h10 = h();
                if (h10 != null) {
                    h10.post(new Runnable() { // from class: N8.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.w0(h.this);
                        }
                    });
                }
                D0(this, 2, false, 2, null);
                return true;
            } catch (Exception e11) {
                R8.a.f3357a.d("VideoShowPlayerImpl", "prepareToPlay  error:" + e11.getMessage());
                D0(this, 8, false, 2, null);
            }
        }
        return false;
    }

    @Override // Y7.c
    public void x(int i10) {
        q0("sendMessage " + f2395z.get(i10) + " what =" + i10);
        super.x(i10);
    }

    public final void x0() {
        N8.c cVar = this.f2408p;
        if (cVar != null) {
            cVar.i();
        }
        this.f2408p = null;
        B0(null);
        u0();
    }

    @Override // Y7.c
    public void y(int i10, int i11) {
        q0("sendMessage " + f2395z.get(i10) + " arg1 =" + i11);
        super.y(i10, i11);
    }

    public final void y0() {
        if (this.f2409q == null) {
            Object systemService = this.f2396d.getSystemService("audio");
            kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            this.f2409q = (AudioManager) systemService;
        }
        AudioManager audioManager = this.f2409q;
        if (audioManager != null) {
            audioManager.requestAudioFocus(null, 3, 2);
        }
    }

    public final void z0() {
        q0("resetPlayerAndRelease " + this.f2399g);
        C0(1, false);
        F0();
        N8.c cVar = this.f2408p;
        if (cVar != null) {
            cVar.i();
        }
        A0();
        n0();
        v0();
        if (this.f2413u != null && this.f2400h == 2) {
            q0("prepare cost long time, set surface delay");
            E0(this.f2413u);
            B0(null);
        }
        t0();
        if (this.f2400h != 8) {
            D0(this, 5, false, 2, null);
        }
        if (this.f2399g) {
            q0("resetPlayerAndRelease mPlayer " + this.f2408p);
            N8.c cVar2 = this.f2408p;
            if (cVar2 != null) {
                cVar2.t(0.0f);
            }
        }
    }
}
