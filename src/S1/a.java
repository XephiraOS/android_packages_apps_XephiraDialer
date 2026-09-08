package S1;

import android.telecom.CallAudioState;
import com.android.incallui.InCallPresenter;
import kotlin.jvm.internal.i;

/* compiled from: AudioSwitchCondition.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final InCallPresenter.InCallState f3372a;

    /* renamed from: b, reason: collision with root package name */
    public final CallAudioState f3373b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3374c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3375d;

    public a(InCallPresenter.InCallState inCallState, CallAudioState callAudioState, int i10, boolean z10) {
        this.f3372a = inCallState;
        this.f3373b = callAudioState;
        this.f3374c = i10;
        this.f3375d = z10;
    }

    public final int a() {
        return this.f3374c;
    }

    public final CallAudioState b() {
        return this.f3373b;
    }

    public final InCallPresenter.InCallState c() {
        return this.f3372a;
    }

    public final boolean d() {
        return this.f3375d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f3372a == aVar.f3372a && i.b(this.f3373b, aVar.f3373b) && this.f3374c == aVar.f3374c && this.f3375d == aVar.f3375d) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        InCallPresenter.InCallState inCallState = this.f3372a;
        int i10 = 0;
        if (inCallState == null) {
            hashCode = 0;
        } else {
            hashCode = inCallState.hashCode();
        }
        int i11 = hashCode * 31;
        CallAudioState callAudioState = this.f3373b;
        if (callAudioState != null) {
            i10 = callAudioState.hashCode();
        }
        int hashCode2 = (((i11 + i10) * 31) + Integer.hashCode(this.f3374c)) * 31;
        boolean z10 = this.f3375d;
        int i12 = z10;
        if (z10 != 0) {
            i12 = 1;
        }
        return hashCode2 + i12;
    }

    public String toString() {
        return "AudioSwitchCondition(inCallState=" + this.f3372a + ", callAudioState=" + this.f3373b + ", callAudioRoute=" + this.f3374c + ", isScreenFlipped=" + this.f3375d + ')';
    }
}
