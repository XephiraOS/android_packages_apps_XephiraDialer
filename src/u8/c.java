package u8;

import android.content.Context;
import com.android.incallui.OplusAutoRedialNotificationUI;

/* compiled from: ExceptionBean.java */
/* loaded from: classes3.dex */
public class c extends f {

    /* renamed from: g, reason: collision with root package name */
    public long f37357g;

    /* renamed from: h, reason: collision with root package name */
    public String f37358h;

    /* renamed from: i, reason: collision with root package name */
    public int f37359i;

    public c(Context context) {
        super(context);
    }

    @Override // u8.f
    public int g() {
        return 1004;
    }

    public int l() {
        return this.f37359i;
    }

    public long m() {
        return this.f37357g;
    }

    public String n() {
        return this.f37358h;
    }

    public void o(int i10) {
        this.f37359i = i10;
        b(OplusAutoRedialNotificationUI.TIME, i10);
    }

    public void p(long j10) {
        this.f37357g = j10;
        c(OplusAutoRedialNotificationUI.TIME, j10);
    }

    public void q(String str) {
        this.f37358h = str;
        d("exception", str);
    }

    public String toString() {
        return "exception is :" + n() + "\ncount is :" + l() + "\ntime is :" + m() + "\n";
    }
}
