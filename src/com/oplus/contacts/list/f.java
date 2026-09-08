package com.oplus.contacts.list;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import com.android.contacts.model.Account;
import com.customize.contacts.FeatureOption;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import w0.C1643c;

/* compiled from: ContactsMainListItem.kt */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final long f27923a;

    /* renamed from: b, reason: collision with root package name */
    public final String f27924b;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable f27925c;

    /* renamed from: d, reason: collision with root package name */
    public final String f27926d;

    /* renamed from: e, reason: collision with root package name */
    public final long f27927e;

    /* renamed from: f, reason: collision with root package name */
    public final String f27928f;

    /* renamed from: g, reason: collision with root package name */
    public final String f27929g;

    /* renamed from: h, reason: collision with root package name */
    public final int f27930h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f27931i;

    /* renamed from: j, reason: collision with root package name */
    public final String f27932j;

    /* renamed from: k, reason: collision with root package name */
    public final String f27933k;

    /* renamed from: l, reason: collision with root package name */
    public final String f27934l;

    /* renamed from: m, reason: collision with root package name */
    public final String f27935m;

    /* renamed from: n, reason: collision with root package name */
    public String f27936n;

    /* renamed from: o, reason: collision with root package name */
    public int f27937o;

    /* renamed from: p, reason: collision with root package name */
    public Account f27938p;

    public f() {
        this(0L, null, null, null, 0L, null, null, 0, false, null, null, null, null, 8191, null);
    }

    public final Account a() {
        if (this.f27938p == null) {
            this.f27938p = new Account(this.f27933k, this.f27932j);
        }
        return this.f27938p;
    }

    public final int b() {
        return this.f27937o;
    }

    public final String c() {
        return this.f27932j;
    }

    public final long d() {
        return this.f27923a;
    }

    public final Drawable e() {
        return this.f27925c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof f) && this.f27923a == ((f) obj).f27923a) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f27926d;
    }

    public final String g() {
        return this.f27924b;
    }

    public final String h() {
        return this.f27929g;
    }

    public int hashCode() {
        return Long.hashCode(this.f27923a);
    }

    public final Uri i() {
        return ContactsContract.Contacts.getLookupUri(this.f27923a, this.f27929g);
    }

    public final String j() {
        return this.f27934l;
    }

    public final long k() {
        return this.f27927e;
    }

    public final Uri l() {
        String str = this.f27928f;
        if (str != null) {
            return Uri.parse(str);
        }
        return null;
    }

    public final String m() {
        return this.f27936n;
    }

    public final boolean n() {
        return this.f27931i;
    }

    public final boolean o() {
        if (i.b(R0.a.f3166b, this.f27932j)) {
            return false;
        }
        if (FeatureOption.k() && i.b("com.android.oplus.sim", this.f27932j)) {
            return false;
        }
        return true;
    }

    public final boolean p() {
        return i.b("com.oplus.contacts.sim", this.f27932j);
    }

    public final boolean q() {
        String str;
        if (C1643c.w()) {
            return false;
        }
        if (this.f27925c == null && ((str = this.f27926d) == null || str.length() == 0)) {
            return false;
        }
        return true;
    }

    public final void r(int i10) {
        this.f27937o = i10;
    }

    public final void s(String str) {
        this.f27936n = str;
    }

    public final boolean t() {
        List Y9;
        if (this.f27935m != null && B3.a.d0() && com.android.contacts.framework.api.rcs.a.e()) {
            Y9 = StringsKt__StringsKt.Y(this.f27935m, new String[]{","}, false, 0, 6, null);
            List list = Y9;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (com.android.contacts.framework.api.rcs.a.c((String) it.next())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return "ContactsMainListItem(contactId=" + this.f27923a + ", displayName=" + this.f27924b + ", contactPresence=" + this.f27925c + ", contactStatus=" + this.f27926d + ", photoId=" + this.f27927e + ", photoThumbUri=" + this.f27928f + ", lookupKey=" + this.f27929g + ", isUserProfile=" + this.f27930h + ", starred=" + this.f27931i + ", accountType=" + this.f27932j + ", accountName=" + this.f27933k + ", organization=" + this.f27934l + ", rcsNumber=" + this.f27935m + ")";
    }

    public f(long j10, String str, Drawable drawable, String str2, long j11, String str3, String str4, int i10, boolean z10, String str5, String str6, String str7, String str8) {
        this.f27923a = j10;
        this.f27924b = str;
        this.f27925c = drawable;
        this.f27926d = str2;
        this.f27927e = j11;
        this.f27928f = str3;
        this.f27929g = str4;
        this.f27930h = i10;
        this.f27931i = z10;
        this.f27932j = str5;
        this.f27933k = str6;
        this.f27934l = str7;
        this.f27935m = str8;
        this.f27937o = -1;
    }

    public /* synthetic */ f(long j10, String str, Drawable drawable, String str2, long j11, String str3, String str4, int i10, boolean z10, String str5, String str6, String str7, String str8, int i11, kotlin.jvm.internal.f fVar) {
        this((i11 & 1) != 0 ? -1L : j10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : drawable, (i11 & 8) != 0 ? null : str2, (i11 & 16) == 0 ? j11 : -1L, (i11 & 32) != 0 ? null : str3, (i11 & 64) != 0 ? null : str4, (i11 & 128) != 0 ? -1 : i10, (i11 & 256) != 0 ? false : z10, (i11 & 512) != 0 ? null : str5, (i11 & 1024) != 0 ? null : str6, (i11 & 2048) != 0 ? null : str7, (i11 & 4096) == 0 ? str8 : null);
    }
}
