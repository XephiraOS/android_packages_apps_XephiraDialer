package P3;

import android.content.Context;
import android.widget.ListView;

/* compiled from: PhoneNumberOrEmailListAdapter.java */
/* loaded from: classes3.dex */
public class g extends f {

    /* renamed from: Z, reason: collision with root package name */
    public boolean f2911Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f2912a0;

    public g(Context context) {
        super(context);
        this.f2911Z = true;
        this.f2912a0 = false;
    }

    @Override // com.android.contacts.list.d
    public void O0() {
        if (this.f2912a0) {
            StringBuilder sb = this.f16901R;
            sb.append(" AND ");
            sb.append("data1");
            sb.append("<>");
            sb.append("'" + com.android.contacts.framework.api.rcs.a.b() + "'");
            StringBuilder sb2 = this.f16901R;
            sb2.append(" AND ");
            sb2.append("data1");
            sb2.append("<>");
            sb2.append("'" + com.android.contacts.framework.api.rcs.a.a(com.android.contacts.framework.api.rcs.a.b()) + "'");
        }
        if (!this.f2911Z) {
            StringBuilder sb3 = this.f16901R;
            sb3.append(" AND ");
            sb3.append("has_phone_number");
            sb3.append("=1");
            StringBuilder sb4 = this.f16901R;
            sb4.append(" AND ");
            sb4.append("mimetype_id");
            sb4.append("=5");
        }
    }

    public void U0(boolean z10) {
        this.f2911Z = z10;
    }

    public void V0(ListView listView) {
        this.f2907V = listView;
    }

    public void W0(boolean z10) {
        this.f2912a0 = z10;
    }
}
