package O3;

import android.content.ContentUris;
import android.content.Context;
import android.provider.ContactsContract;

/* compiled from: ContactsProcessThreadsHelper.java */
/* loaded from: classes3.dex */
public class d extends g {

    /* renamed from: o, reason: collision with root package name */
    public Context f2685o;

    /* renamed from: p, reason: collision with root package name */
    public long[] f2686p;

    public d(Context context, long[] jArr) {
        super(context);
        this.f2686p = jArr;
        this.f2685o = context;
    }

    @Override // O3.g
    public void l() {
        if (this.f2686p.length > 0) {
            this.f2702g.I(1, null, null);
            int length = this.f2686p.length;
            for (int i10 = 0; i10 < length && !this.f2700e; i10++) {
                r(this.f2686p[i10]);
            }
        }
    }

    public final void r(long j10) {
        if (H7.a.b()) {
            H7.b.b("ContactsProcessThread", "doDeleteGroup groupId = " + j10);
        }
        if (G7.c.c(this.f2685o.getContentResolver(), ContentUris.withAppendedId(ContactsContract.Groups.CONTENT_URI, j10), null, null) != 1) {
            n(12);
            this.f2702g.I(4, null, null);
        }
    }
}
