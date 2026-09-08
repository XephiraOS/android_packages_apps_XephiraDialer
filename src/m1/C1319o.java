package m1;

import android.net.Uri;

/* compiled from: ContactsRequest.java */
/* renamed from: m1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1319o {

    /* renamed from: c, reason: collision with root package name */
    public CharSequence f35011c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f35012d;

    /* renamed from: e, reason: collision with root package name */
    public String f35013e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f35014f;

    /* renamed from: h, reason: collision with root package name */
    public Uri f35016h;

    /* renamed from: a, reason: collision with root package name */
    public boolean f35009a = true;

    /* renamed from: b, reason: collision with root package name */
    public int f35010b = 10;

    /* renamed from: g, reason: collision with root package name */
    public boolean f35015g = true;

    public int a() {
        return this.f35010b;
    }

    public CharSequence b() {
        return this.f35011c;
    }

    public Uri c() {
        return this.f35016h;
    }

    public boolean d() {
        return this.f35014f;
    }

    public boolean e() {
        return this.f35012d;
    }

    public boolean f() {
        return this.f35009a;
    }

    public void g(int i10) {
        this.f35010b = i10;
    }

    public void h(CharSequence charSequence) {
        this.f35011c = charSequence;
    }

    public void i(Uri uri) {
        this.f35016h = uri;
    }

    public void j(boolean z10) {
        this.f35014f = z10;
    }

    public void k(String str) {
        this.f35013e = str;
    }

    public void l(boolean z10) {
        this.f35012d = z10;
    }

    public String toString() {
        return "{ContactsRequest:mValid=" + this.f35009a + " mActionCode=" + this.f35010b + " mTitle=" + ((Object) this.f35011c) + " mSearchMode=" + this.f35012d + " mQueryString=" + this.f35013e + " mLegacyCompatibilityMode=" + this.f35014f + " mDirectorySearchEnabled=" + this.f35015g + " mContactUri=" + this.f35016h + "}";
    }
}
