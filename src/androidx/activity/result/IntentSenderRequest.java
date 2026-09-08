package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: IntentSenderRequest.kt */
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final IntentSender f7149a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f7150b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7151c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7152d;

    /* renamed from: e, reason: collision with root package name */
    public static final c f7148e = new c(null);
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new b();

    /* compiled from: IntentSenderRequest.kt */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final IntentSender f7153a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f7154b;

        /* renamed from: c, reason: collision with root package name */
        public int f7155c;

        /* renamed from: d, reason: collision with root package name */
        public int f7156d;

        public a(IntentSender intentSender) {
            i.f(intentSender, "intentSender");
            this.f7153a = intentSender;
        }

        public final IntentSenderRequest a() {
            return new IntentSenderRequest(this.f7153a, this.f7154b, this.f7155c, this.f7156d);
        }

        public final a b(Intent intent) {
            this.f7154b = intent;
            return this;
        }

        public final a c(int i10, int i11) {
            this.f7156d = i10;
            this.f7155c = i11;
            return this;
        }
    }

    /* compiled from: IntentSenderRequest.kt */
    /* loaded from: classes.dex */
    public static final class b implements Parcelable.Creator<IntentSenderRequest> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest createFromParcel(Parcel inParcel) {
            i.f(inParcel, "inParcel");
            return new IntentSenderRequest(inParcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest[] newArray(int i10) {
            return new IntentSenderRequest[i10];
        }
    }

    /* compiled from: IntentSenderRequest.kt */
    /* loaded from: classes.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(f fVar) {
            this();
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i10, int i11) {
        i.f(intentSender, "intentSender");
        this.f7149a = intentSender;
        this.f7150b = intent;
        this.f7151c = i10;
        this.f7152d = i11;
    }

    public final Intent b() {
        return this.f7150b;
    }

    public final int d() {
        return this.f7151c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int f() {
        return this.f7152d;
    }

    public final IntentSender h() {
        return this.f7149a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        i.f(dest, "dest");
        dest.writeParcelable(this.f7149a, i10);
        dest.writeParcelable(this.f7150b, i10);
        dest.writeInt(this.f7151c);
        dest.writeInt(this.f7152d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public IntentSenderRequest(android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.i.f(r4, r0)
            java.lang.Class<android.content.IntentSender> r0 = android.content.IntentSender.class
            java.lang.ClassLoader r0 = r0.getClassLoader()
            android.os.Parcelable r0 = r4.readParcelable(r0)
            kotlin.jvm.internal.i.c(r0)
            android.content.IntentSender r0 = (android.content.IntentSender) r0
            java.lang.Class<android.content.Intent> r1 = android.content.Intent.class
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r4.readParcelable(r1)
            android.content.Intent r1 = (android.content.Intent) r1
            int r2 = r4.readInt()
            int r4 = r4.readInt()
            r3.<init>(r0, r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.IntentSenderRequest.<init>(android.os.Parcel):void");
    }
}
