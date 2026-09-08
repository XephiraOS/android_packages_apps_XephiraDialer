package u8;

import android.content.Context;
import com.android.incallui.OplusAutoRedialNotificationUI;

/* compiled from: PageVisitBean.java */
/* loaded from: classes3.dex */
public class d extends f {

    /* renamed from: g, reason: collision with root package name */
    public String f37360g;

    /* renamed from: h, reason: collision with root package name */
    public long f37361h;

    /* renamed from: i, reason: collision with root package name */
    public String f37362i;

    public d(Context context) {
        super(context);
    }

    @Override // u8.f
    public int g() {
        return 1003;
    }

    public String l() {
        return this.f37362i;
    }

    public long m() {
        return this.f37361h;
    }

    public String n() {
        return this.f37360g;
    }

    public void o(String str) {
        this.f37362i = str;
        d("activities", str);
    }

    public void p(long j10) {
        this.f37361h = j10;
        c("duration", j10);
    }

    public void q(String str) {
        this.f37360g = str;
        d(OplusAutoRedialNotificationUI.TIME, str);
    }

    public String toString() {
        return "time is :" + n() + "\nduration is :" + m() + "\nactivities is :" + l() + "\n";
    }
}
