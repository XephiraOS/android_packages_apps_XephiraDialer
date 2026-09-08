package com.android.contacts.dialerui.dialer;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.dialerui.dialer.SatelliteDialer;
import com.android.contacts.framework.baseui.util.t;
import com.android.incallui.OplusPhoneUtils;
import com.oplus.dialer.R;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.F;
import kotlinx.coroutines.S;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: SatelliteDialer.kt */
/* loaded from: classes.dex */
public final class SatelliteDialer extends b {

    /* renamed from: n, reason: collision with root package name */
    public static final Statistics f14799n = new Statistics(null);

    /* renamed from: o, reason: collision with root package name */
    public static final m9.d<Statistics> f14800o;

    /* renamed from: m, reason: collision with root package name */
    public ViewGroup f14801m;

    /* compiled from: SatelliteDialer.kt */
    /* loaded from: classes.dex */
    public static final class Statistics implements t {
        public Statistics() {
        }

        @Override // com.android.contacts.framework.baseui.util.t
        public void a(int i10, Object obj, Object obj2) {
            Object b10;
            if (obj != null && (obj instanceof Context) && obj2 != null && (obj2 instanceof Uri)) {
                try {
                    Result.a aVar = Result.f34166a;
                    SatelliteDialer.f14799n.d((Context) obj, ((Uri) obj2).getSchemeSpecificPart());
                    b10 = Result.b(q.f35511a);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    b10 = Result.b(kotlin.b.a(th));
                }
                Throwable d10 = Result.d(b10);
                if (d10 != null) {
                    H7.b.c("Statistics", "onCall track: exception: " + d10);
                }
            }
        }

        public final Statistics b() {
            return (Statistics) SatelliteDialer.f14800o.getValue();
        }

        public final boolean c(Context context, String str) {
            boolean z10 = false;
            if (context != null && !TextUtils.isEmpty(str)) {
                Cursor e10 = G7.c.e(context.getContentResolver(), Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)).buildUpon().appendQueryParameter("limit", OplusPhoneUtils.DeviceState.LOCK_DEVICE).build(), new String[]{BreenoCallContract.BaseColumns._ID}, null, null, null);
                if (e10 != null) {
                    try {
                        if (e10.getCount() > 0) {
                            z10 = true;
                        }
                        q qVar = q.f35511a;
                        kotlin.io.a.a(e10, null);
                    } finally {
                    }
                }
            }
            return z10;
        }

        public final void d(Context context, String str) {
            if (context != null && str != null) {
                C1248i.d(F.a(S.b()), null, null, new SatelliteDialer$Statistics$trackCallActionIfInSatelliteMode$1(str, context, null), 3, null);
            }
        }

        public /* synthetic */ Statistics(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        m9.d<Statistics> a10;
        a10 = kotlin.a.a(LazyThreadSafetyMode.f34161a, new InterfaceC1637a<Statistics>() { // from class: com.android.contacts.dialerui.dialer.SatelliteDialer$Statistics$INSTANCE$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final SatelliteDialer.Statistics invoke() {
                return SatelliteDialer.f14799n;
            }
        });
        f14800o = a10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SatelliteDialer(Fragment fragment, ViewGroup root, int i10) {
        super(fragment, root, i10);
        kotlin.jvm.internal.i.f(fragment, "fragment");
        kotlin.jvm.internal.i.f(root, "root");
    }

    public static final Statistics H() {
        return f14799n.b();
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void D() {
        super.D();
        ViewGroup viewGroup = this.f14801m;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void k() {
        super.k();
        ViewGroup viewGroup = this.f14801m;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.android.contacts.dialerui.dialer.b
    public void m(int i10, boolean z10, boolean z11, boolean z12) {
        View l10;
        super.m(i10, z10, z11, z12);
        if (this.f14801m == null && (l10 = l((ViewStub) h().findViewById(R.id.single_sim_layout_satellite), R.id.single_sim_view_satellite)) != null) {
            ViewGroup viewGroup = (ViewGroup) l10.findViewById(R.id.single_sim_view_satellite);
            String str = null;
            if (viewGroup != null) {
                kotlin.jvm.internal.i.e(viewGroup, "findViewById<ViewGroup>(…ingle_sim_view_satellite)");
                viewGroup.setOnClickListener(this);
                ImageButton imageButton = (ImageButton) viewGroup.findViewById(R.id.sim_dial_btn_satellite);
                if (imageButton != null) {
                    kotlin.jvm.internal.i.e(imageButton, "findViewById<ImageButton…d.sim_dial_btn_satellite)");
                    imageButton.setOnClickListener(this);
                    Resources resources = imageButton.getResources();
                    if (resources != null) {
                        str = resources.getString(R.string.make_dial);
                    }
                    imageButton.setContentDescription(str);
                }
            } else {
                viewGroup = null;
            }
            this.f14801m = viewGroup;
        }
        w(h(), 1, 1, 1);
    }
}
