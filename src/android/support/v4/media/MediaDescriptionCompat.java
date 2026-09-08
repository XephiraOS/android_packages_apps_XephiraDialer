package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.c;
import android.support.v4.media.d;

/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f6964a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f6965b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f6966c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f6967d;

    /* renamed from: e, reason: collision with root package name */
    public final Bitmap f6968e;

    /* renamed from: f, reason: collision with root package name */
    public final Uri f6969f;

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f6970g;

    /* renamed from: h, reason: collision with root package name */
    public final Uri f6971h;

    /* renamed from: i, reason: collision with root package name */
    public Object f6972i;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.b(c.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i10) {
            return new MediaDescriptionCompat[i10];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public String f6973a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f6974b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f6975c;

        /* renamed from: d, reason: collision with root package name */
        public CharSequence f6976d;

        /* renamed from: e, reason: collision with root package name */
        public Bitmap f6977e;

        /* renamed from: f, reason: collision with root package name */
        public Uri f6978f;

        /* renamed from: g, reason: collision with root package name */
        public Bundle f6979g;

        /* renamed from: h, reason: collision with root package name */
        public Uri f6980h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f6973a, this.f6974b, this.f6975c, this.f6976d, this.f6977e, this.f6978f, this.f6979g, this.f6980h);
        }

        public b b(CharSequence charSequence) {
            this.f6976d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f6979g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f6977e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f6978f = uri;
            return this;
        }

        public b f(String str) {
            this.f6973a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f6980h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f6975c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f6974b = charSequence;
            return this;
        }
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f6964a = str;
        this.f6965b = charSequence;
        this.f6966c = charSequence2;
        this.f6967d = charSequence3;
        this.f6968e = bitmap;
        this.f6969f = uri;
        this.f6970g = bundle;
        this.f6971h = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.support.v4.media.MediaDescriptionCompat b(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L74
            android.support.v4.media.MediaDescriptionCompat$b r1 = new android.support.v4.media.MediaDescriptionCompat$b
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.c.f(r8)
            r1.f(r2)
            java.lang.CharSequence r2 = android.support.v4.media.c.h(r8)
            r1.i(r2)
            java.lang.CharSequence r2 = android.support.v4.media.c.g(r8)
            r1.h(r2)
            java.lang.CharSequence r2 = android.support.v4.media.c.b(r8)
            r1.b(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.c.d(r8)
            r1.d(r2)
            android.net.Uri r2 = android.support.v4.media.c.e(r8)
            r1.e(r2)
            android.os.Bundle r2 = android.support.v4.media.c.c(r8)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 == 0) goto L44
            android.support.v4.media.session.MediaSessionCompat.a(r2)
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
            goto L45
        L44:
            r4 = r0
        L45:
            if (r4 == 0) goto L5d
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L57
            int r6 = r2.size()
            r7 = 2
            if (r6 != r7) goto L57
            goto L5e
        L57:
            r2.remove(r3)
            r2.remove(r5)
        L5d:
            r0 = r2
        L5e:
            r1.c(r0)
            if (r4 == 0) goto L67
            r1.g(r4)
            goto L6e
        L67:
            android.net.Uri r0 = android.support.v4.media.d.a(r8)
            r1.g(r0)
        L6e:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.a()
            r0.f6972i = r8
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.b(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public Object d() {
        Object obj = this.f6972i;
        if (obj == null) {
            Object b10 = c.a.b();
            c.a.g(b10, this.f6964a);
            c.a.i(b10, this.f6965b);
            c.a.h(b10, this.f6966c);
            c.a.c(b10, this.f6967d);
            c.a.e(b10, this.f6968e);
            c.a.f(b10, this.f6969f);
            c.a.d(b10, this.f6970g);
            d.a.a(b10, this.f6971h);
            Object a10 = c.a.a(b10);
            this.f6972i = a10;
            return a10;
        }
        return obj;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String f() {
        return this.f6964a;
    }

    public String toString() {
        return ((Object) this.f6965b) + ", " + ((Object) this.f6966c) + ", " + ((Object) this.f6967d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        c.i(d(), parcel, i10);
    }
}
