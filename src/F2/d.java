package f2;

import com.android.incallui.Call;

/* compiled from: SecondaryCallInfoUseCase.kt */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f31685a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final com.android.incallui.mvvm.utils.h<String> f31686b = new com.android.incallui.mvvm.utils.h<>(true);

    /* renamed from: c, reason: collision with root package name */
    public static final com.android.incallui.mvvm.utils.h<Integer> f31687c = new com.android.incallui.mvvm.utils.h<>(0, true);

    public final void a(Call call) {
        if (call == null) {
            f31686b.o(null);
            f31687c.o(0);
        } else {
            f31686b.o(call.getId());
            f31687c.o(Integer.valueOf(call.getState()));
        }
    }
}
