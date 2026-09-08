package com.oplus.aiunit.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* loaded from: classes3.dex */
public final class SimpleUnitInfo implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f25588a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25589b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25590c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f25591d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f25592e;

    /* renamed from: f, reason: collision with root package name */
    public int f25593f;

    /* loaded from: classes3.dex */
    public static final class CREATOR implements Parcelable.Creator<SimpleUnitInfo> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SimpleUnitInfo createFromParcel(Parcel parcel) {
            i.f(parcel, "parcel");
            return new SimpleUnitInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SimpleUnitInfo[] newArray(int i10) {
            return new SimpleUnitInfo[i10];
        }

        public /* synthetic */ CREATOR(f fVar) {
            this();
        }
    }

    public SimpleUnitInfo(int i10, String name, int i11) {
        i.f(name, "name");
        this.f25588a = i10;
        this.f25589b = name;
        this.f25590c = i11;
        this.f25593f = -1;
        this.f25591d = i11 >= 1 && i11 <= 4;
        this.f25592e = i11 == 0 || i11 == 12 || i11 == 13;
        this.f25593f = b();
    }

    public final int b() {
        if (!i.b(this.f25589b, "cloud_aigc_article_summary") && !i.b(this.f25589b, "cloud_aigc_call_summary") && !i.b(this.f25589b, "cloud_aigc_sdinpainting") && !i.b(this.f25589b, "cloud_aigc_segmentation") && !i.b(this.f25589b, "cloud_audio_asr")) {
            return 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleUnitInfo)) {
            return false;
        }
        SimpleUnitInfo simpleUnitInfo = (SimpleUnitInfo) obj;
        if (this.f25588a == simpleUnitInfo.f25588a && i.b(this.f25589b, simpleUnitInfo.f25589b) && this.f25590c == simpleUnitInfo.f25590c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Integer.hashCode(this.f25590c) + ((this.f25589b.hashCode() + (Integer.hashCode(this.f25588a) * 31)) * 31);
    }

    public String toString() {
        return "SimpleUnitInfo[" + this.f25588a + ", " + this.f25589b + ", " + this.f25590c + ", " + this.f25591d + ", " + this.f25592e + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        i.f(parcel, "parcel");
        parcel.writeInt(this.f25588a);
        parcel.writeString(this.f25589b);
        parcel.writeInt(this.f25590c);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SimpleUnitInfo(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.i.f(r3, r0)
            int r0 = r3.readInt()
            java.lang.String r1 = r3.readString()
            if (r1 != 0) goto L11
            java.lang.String r1 = ""
        L11:
            int r3 = r3.readInt()
            r2.<init>(r0, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.aiunit.core.data.SimpleUnitInfo.<init>(android.os.Parcel):void");
    }
}
