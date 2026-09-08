package A2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusInCallApp;

/* compiled from: OplusStatisticsManager.java */
/* loaded from: classes.dex */
public class w implements InCallPresenter.InCallUiListener {

    /* renamed from: g, reason: collision with root package name */
    public static w f172g = new w();

    /* renamed from: b, reason: collision with root package name */
    public long f174b = 0;

    /* renamed from: c, reason: collision with root package name */
    public long f175c = 0;

    /* renamed from: d, reason: collision with root package name */
    public long f176d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f177e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f178f = false;

    /* renamed from: a, reason: collision with root package name */
    public Context f173a = OplusInCallApp.getAppContext();

    /* compiled from: OplusStatisticsManager.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f179a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f180b;

        public a(String str, long j10) {
            this.f179a = str;
            this.f180b = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            SharedPreferences.Editor edit = w.this.f173a.getSharedPreferences("OplusStatisticsManager", 0).edit();
            edit.putLong(this.f179a, this.f180b);
            try {
                edit.apply();
            } catch (Exception e10) {
                Log.d("OplusStatisticsManager", "saveToSharedPreferences Exception = " + e10.getMessage());
            }
        }
    }

    public static w e() {
        return f172g;
    }

    public void b() {
        try {
            InCallPresenter.getInstance().removeInCallUiListener(this);
            if (Log.sOplusDebug) {
                Log.d("OplusStatisticsManager", "allCallRemoved mIsUiShowing = " + this.f178f);
            }
            if (this.f178f && this.f174b != 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f174b;
                if (Log.sOplusDebug) {
                    Log.d("OplusStatisticsManager", "allCallRemoved temp = " + elapsedRealtime);
                }
                this.f175c += elapsedRealtime;
            }
            i(this.f175c);
            if (this.f176d != 0) {
                long elapsedRealtime2 = this.f177e + (SystemClock.elapsedRealtime() - this.f176d);
                this.f177e = elapsedRealtime2;
                g(elapsedRealtime2);
            }
        } catch (Exception e10) {
            Log.w("OplusStatisticsManager", "allCallRemoved " + e10);
        }
        this.f178f = false;
        this.f176d = 0L;
        this.f174b = 0L;
    }

    public void c() {
        try {
            InCallPresenter.getInstance().addInCallUiListener(this);
            this.f176d = SystemClock.elapsedRealtime();
            this.f177e = d();
            this.f178f = InCallPresenter.getInstance().isActivityStarted();
            this.f175c = f();
            boolean isScreenInteractive = InCallPresenter.getInstance().isScreenInteractive();
            if (Log.sOplusDebug) {
                Log.d("OplusStatisticsManager", "firstCallAdded mIsUiShowing = " + this.f178f + " isScreenOn = " + isScreenInteractive);
            }
            if (this.f178f && isScreenInteractive) {
                this.f174b = this.f176d;
            }
        } catch (Exception e10) {
            Log.w("OplusStatisticsManager", "firstCallAdded " + e10);
        }
    }

    public long d() {
        Context context = this.f173a;
        if (context == null) {
            return 0L;
        }
        long j10 = context.getSharedPreferences("OplusStatisticsManager", 0).getLong("day_call_time", 0L);
        Log.d("OplusStatisticsManager", "getCallTime duration = " + j10);
        return j10;
    }

    public long f() {
        Context context = this.f173a;
        if (context == null) {
            return 0L;
        }
        long j10 = context.getSharedPreferences("OplusStatisticsManager", 0).getLong("day_ui_showing_time", 0L);
        Log.d("OplusStatisticsManager", "getUiShowingTime duration = " + j10);
        return j10;
    }

    public void g(long j10) {
        if (this.f173a == null) {
            return;
        }
        Log.d("OplusStatisticsManager", "saveCallTime duration = " + j10);
        h("day_call_time", j10);
    }

    public final void h(String str, long j10) {
        C2.b.a().execute(new a(str, j10));
    }

    public void i(long j10) {
        if (this.f173a == null) {
            return;
        }
        Log.d("OplusStatisticsManager", "saveUiShowingTime duration = " + j10);
        h("day_ui_showing_time", j10);
    }

    @Override // com.android.incallui.InCallPresenter.InCallUiListener
    public void onUiShowing(boolean z10) {
        if (z10) {
            if (!this.f178f) {
                this.f174b = SystemClock.elapsedRealtime();
            }
            this.f178f = true;
            return;
        }
        if (this.f178f && this.f174b != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f174b;
            if (Log.sOplusDebug) {
                Log.d("OplusStatisticsManager", "onUiShowing temp = " + elapsedRealtime);
            }
            this.f175c += elapsedRealtime;
        }
        this.f178f = false;
    }
}
