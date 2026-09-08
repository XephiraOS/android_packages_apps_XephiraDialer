package e2;

import D2.g;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import kotlin.jvm.internal.i;

/* compiled from: OmojiInfo.kt */
/* renamed from: e2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0968c {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f30584a;

    /* renamed from: b, reason: collision with root package name */
    public int f30585b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f30586c;

    public C0968c(Drawable drawable, int i10, Uri uri) {
        this.f30584a = drawable;
        this.f30585b = i10;
        this.f30586c = uri;
    }

    public final int a() {
        return this.f30585b;
    }

    public final Drawable b() {
        return this.f30584a;
    }

    public final Uri c() {
        return this.f30586c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0968c)) {
            return false;
        }
        C0968c c0968c = (C0968c) obj;
        if (!i.b(this.f30584a, c0968c.f30584a) || this.f30585b != c0968c.f30585b || !i.b(this.f30586c, c0968c.f30586c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i10;
        Drawable drawable = this.f30584a;
        int i11 = 0;
        if (drawable != null) {
            i10 = drawable.hashCode();
        } else {
            i10 = 0;
        }
        int i12 = ((i10 * 31) + this.f30585b) * 31;
        Uri uri = this.f30586c;
        if (uri != null) {
            i11 = uri.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "[ photo=" + this.f30584a + ", color=" + this.f30585b + ", videoUri=" + g.o(this.f30586c) + " ]";
    }

    public C0968c() {
        this(null, -1, null);
    }
}
