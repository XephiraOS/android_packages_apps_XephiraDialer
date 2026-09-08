package q0;

import android.content.Context;
import android.util.ArraySet;
import com.oplus.dialer.R;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* compiled from: CountryCodeProvider.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final List<String> f36125b = Arrays.asList("CA", "GB", "JP", "MX", "US");

    /* renamed from: a, reason: collision with root package name */
    public final Set<String> f36126a;

    public f(Context context) {
        ArraySet arraySet = new ArraySet(Arrays.asList(context.getResources().getStringArray(R.array.assisted_dialing_cc_values)));
        this.f36126a = arraySet;
        H7.b.e("CountryCodeProvider", "CountryCodeProvider: Using country codes: " + arraySet);
    }
}
