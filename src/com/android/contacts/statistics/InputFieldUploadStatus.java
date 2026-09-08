package com.android.contacts.statistics;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.incallui.OplusPhoneUtils;
import com.heytap.accessory.constant.FastPairConstants;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: InputFieldUploadStatus.kt */
/* loaded from: classes.dex */
public final class InputFieldUploadStatus implements Parcelable {

    /* renamed from: A, reason: collision with root package name */
    public static final b f17304A = new b(null);
    public static final Parcelable.Creator<InputFieldUploadStatus> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f17305a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17306b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17307c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f17308d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f17309e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17310f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f17311g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17312h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f17313i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f17314j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f17315k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f17316l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f17317m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f17318n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f17319o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f17320p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f17321q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f17322r;

    /* renamed from: x, reason: collision with root package name */
    public boolean f17323x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f17324y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f17325z;

    /* compiled from: InputFieldUploadStatus.kt */
    /* loaded from: classes.dex */
    public static final class a implements Parcelable.Creator<InputFieldUploadStatus> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputFieldUploadStatus createFromParcel(Parcel source) {
            i.f(source, "source");
            return new InputFieldUploadStatus(source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean(), source.readBoolean());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InputFieldUploadStatus[] newArray(int i10) {
            return new InputFieldUploadStatus[i10];
        }
    }

    /* compiled from: InputFieldUploadStatus.kt */
    /* loaded from: classes.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    public InputFieldUploadStatus() {
        this(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 2097151, null);
    }

    public final boolean A() {
        return this.f17305a;
    }

    public final boolean C() {
        return this.f17324y;
    }

    public final boolean D() {
        return this.f17325z;
    }

    public final boolean E() {
        return this.f17315k;
    }

    public final boolean F() {
        return this.f17323x;
    }

    public final void H(boolean z10) {
        this.f17319o = z10;
    }

    public final void J(boolean z10) {
        this.f17322r = z10;
    }

    public final void K(boolean z10) {
        this.f17317m = z10;
    }

    public final void M(boolean z10) {
        this.f17321q = z10;
    }

    public final void N(boolean z10) {
        this.f17316l = z10;
    }

    public final void P(boolean z10) {
        this.f17314j = z10;
    }

    public final void Q(boolean z10) {
        this.f17309e = z10;
    }

    public final void R(boolean z10) {
        this.f17320p = z10;
    }

    public final void W(boolean z10) {
        this.f17318n = z10;
    }

    public final void Y(boolean z10) {
        this.f17312h = z10;
    }

    public final boolean b() {
        return this.f17319o;
    }

    public final void b0(boolean z10) {
        this.f17307c = z10;
    }

    public final boolean d() {
        return this.f17322r;
    }

    public final void d0(boolean z10) {
        this.f17313i = z10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e0(boolean z10) {
        this.f17308d = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputFieldUploadStatus)) {
            return false;
        }
        InputFieldUploadStatus inputFieldUploadStatus = (InputFieldUploadStatus) obj;
        if (this.f17305a == inputFieldUploadStatus.f17305a && this.f17306b == inputFieldUploadStatus.f17306b && this.f17307c == inputFieldUploadStatus.f17307c && this.f17308d == inputFieldUploadStatus.f17308d && this.f17309e == inputFieldUploadStatus.f17309e && this.f17310f == inputFieldUploadStatus.f17310f && this.f17311g == inputFieldUploadStatus.f17311g && this.f17312h == inputFieldUploadStatus.f17312h && this.f17313i == inputFieldUploadStatus.f17313i && this.f17314j == inputFieldUploadStatus.f17314j && this.f17315k == inputFieldUploadStatus.f17315k && this.f17316l == inputFieldUploadStatus.f17316l && this.f17317m == inputFieldUploadStatus.f17317m && this.f17318n == inputFieldUploadStatus.f17318n && this.f17319o == inputFieldUploadStatus.f17319o && this.f17320p == inputFieldUploadStatus.f17320p && this.f17321q == inputFieldUploadStatus.f17321q && this.f17322r == inputFieldUploadStatus.f17322r && this.f17323x == inputFieldUploadStatus.f17323x && this.f17324y == inputFieldUploadStatus.f17324y && this.f17325z == inputFieldUploadStatus.f17325z) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return this.f17317m;
    }

    public final boolean h() {
        return this.f17321q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v24, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v26, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v28, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v30, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v32, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v34, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v36, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z10 = this.f17305a;
        int i10 = 1;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i11 = r02 * 31;
        ?? r22 = this.f17306b;
        int i12 = r22;
        if (r22 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        ?? r23 = this.f17307c;
        int i14 = r23;
        if (r23 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        ?? r24 = this.f17308d;
        int i16 = r24;
        if (r24 != 0) {
            i16 = 1;
        }
        int i17 = (i15 + i16) * 31;
        ?? r25 = this.f17309e;
        int i18 = r25;
        if (r25 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        ?? r26 = this.f17310f;
        int i20 = r26;
        if (r26 != 0) {
            i20 = 1;
        }
        int i21 = (i19 + i20) * 31;
        ?? r27 = this.f17311g;
        int i22 = r27;
        if (r27 != 0) {
            i22 = 1;
        }
        int i23 = (i21 + i22) * 31;
        ?? r28 = this.f17312h;
        int i24 = r28;
        if (r28 != 0) {
            i24 = 1;
        }
        int i25 = (i23 + i24) * 31;
        ?? r29 = this.f17313i;
        int i26 = r29;
        if (r29 != 0) {
            i26 = 1;
        }
        int i27 = (i25 + i26) * 31;
        ?? r210 = this.f17314j;
        int i28 = r210;
        if (r210 != 0) {
            i28 = 1;
        }
        int i29 = (i27 + i28) * 31;
        ?? r211 = this.f17315k;
        int i30 = r211;
        if (r211 != 0) {
            i30 = 1;
        }
        int i31 = (i29 + i30) * 31;
        ?? r212 = this.f17316l;
        int i32 = r212;
        if (r212 != 0) {
            i32 = 1;
        }
        int i33 = (i31 + i32) * 31;
        ?? r213 = this.f17317m;
        int i34 = r213;
        if (r213 != 0) {
            i34 = 1;
        }
        int i35 = (i33 + i34) * 31;
        ?? r214 = this.f17318n;
        int i36 = r214;
        if (r214 != 0) {
            i36 = 1;
        }
        int i37 = (i35 + i36) * 31;
        ?? r215 = this.f17319o;
        int i38 = r215;
        if (r215 != 0) {
            i38 = 1;
        }
        int i39 = (i37 + i38) * 31;
        ?? r216 = this.f17320p;
        int i40 = r216;
        if (r216 != 0) {
            i40 = 1;
        }
        int i41 = (i39 + i40) * 31;
        ?? r217 = this.f17321q;
        int i42 = r217;
        if (r217 != 0) {
            i42 = 1;
        }
        int i43 = (i41 + i42) * 31;
        ?? r218 = this.f17322r;
        int i44 = r218;
        if (r218 != 0) {
            i44 = 1;
        }
        int i45 = (i43 + i44) * 31;
        ?? r219 = this.f17323x;
        int i46 = r219;
        if (r219 != 0) {
            i46 = 1;
        }
        int i47 = (i45 + i46) * 31;
        ?? r220 = this.f17324y;
        int i48 = r220;
        if (r220 != 0) {
            i48 = 1;
        }
        int i49 = (i47 + i48) * 31;
        boolean z11 = this.f17325z;
        if (!z11) {
            i10 = z11 ? 1 : 0;
        }
        return i49 + i10;
    }

    public final boolean i() {
        return this.f17316l;
    }

    public final void i0(boolean z10) {
        this.f17311g = z10;
    }

    public final boolean j() {
        return this.f17314j;
    }

    public final boolean k() {
        return this.f17309e;
    }

    public final void k0(boolean z10) {
        this.f17306b = z10;
    }

    public final void l0(boolean z10) {
        this.f17310f = z10;
    }

    public final boolean m() {
        return this.f17320p;
    }

    public final boolean n() {
        return this.f17318n;
    }

    public final void n0(boolean z10) {
        this.f17305a = z10;
    }

    public final boolean p() {
        return this.f17312h;
    }

    public final void p0(boolean z10) {
        this.f17324y = z10;
    }

    public final boolean q() {
        return this.f17307c;
    }

    public final void q0(boolean z10) {
        this.f17325z = z10;
    }

    public final void r0(boolean z10) {
        this.f17315k = z10;
    }

    public final void s0(boolean z10) {
        this.f17323x = z10;
    }

    public final boolean t() {
        return this.f17313i;
    }

    public String toString() {
        return "InputFieldUploadStatus(nameUpload=" + this.f17305a + ", namePrefixUpload=" + this.f17306b + ", lastNameUpload=" + this.f17307c + ", middleNameUpload=" + this.f17308d + ", firstNameUpload=" + this.f17309e + ", nameSuffixUpload=" + this.f17310f + ", namePinyinUpload=" + this.f17311g + ", lastNamePinyinUpload=" + this.f17312h + ", middleNamePinyinUpload=" + this.f17313i + ", firstNamePinyinUpload=" + this.f17314j + ", numberUpload=" + this.f17315k + ", emailUpload=" + this.f17316l + ", companyUpload=" + this.f17317m + ", jobUpload=" + this.f17318n + ", addressUpload=" + this.f17319o + ", instantMessageUpload=" + this.f17320p + ", dateUpload=" + this.f17321q + ", affiliatedPersonUpload=" + this.f17322r + ", websiteUpload=" + this.f17323x + ", nicknameUpload=" + this.f17324y + ", noteUpload=" + this.f17325z + ")";
    }

    public final boolean v() {
        return this.f17308d;
    }

    public final boolean w() {
        return this.f17311g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        i.f(dest, "dest");
        dest.writeBoolean(this.f17305a);
        dest.writeBoolean(this.f17306b);
        dest.writeBoolean(this.f17307c);
        dest.writeBoolean(this.f17308d);
        dest.writeBoolean(this.f17309e);
        dest.writeBoolean(this.f17310f);
        dest.writeBoolean(this.f17311g);
        dest.writeBoolean(this.f17312h);
        dest.writeBoolean(this.f17313i);
        dest.writeBoolean(this.f17314j);
        dest.writeBoolean(this.f17315k);
        dest.writeBoolean(this.f17316l);
        dest.writeBoolean(this.f17317m);
        dest.writeBoolean(this.f17318n);
        dest.writeBoolean(this.f17319o);
        dest.writeBoolean(this.f17320p);
        dest.writeBoolean(this.f17321q);
        dest.writeBoolean(this.f17322r);
        dest.writeBoolean(this.f17323x);
        dest.writeBoolean(this.f17324y);
        dest.writeBoolean(this.f17325z);
    }

    public final boolean x() {
        return this.f17306b;
    }

    public final boolean z() {
        return this.f17310f;
    }

    public InputFieldUploadStatus(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, boolean z21, boolean z22, boolean z23, boolean z24, boolean z25, boolean z26, boolean z27, boolean z28, boolean z29, boolean z30) {
        this.f17305a = z10;
        this.f17306b = z11;
        this.f17307c = z12;
        this.f17308d = z13;
        this.f17309e = z14;
        this.f17310f = z15;
        this.f17311g = z16;
        this.f17312h = z17;
        this.f17313i = z18;
        this.f17314j = z19;
        this.f17315k = z20;
        this.f17316l = z21;
        this.f17317m = z22;
        this.f17318n = z23;
        this.f17319o = z24;
        this.f17320p = z25;
        this.f17321q = z26;
        this.f17322r = z27;
        this.f17323x = z28;
        this.f17324y = z29;
        this.f17325z = z30;
    }

    public /* synthetic */ InputFieldUploadStatus(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z20, boolean z21, boolean z22, boolean z23, boolean z24, boolean z25, boolean z26, boolean z27, boolean z28, boolean z29, boolean z30, int i10, f fVar) {
        this((i10 & 1) != 0 ? true : z10, (i10 & 2) != 0 ? true : z11, (i10 & 4) != 0 ? true : z12, (i10 & 8) != 0 ? true : z13, (i10 & 16) != 0 ? true : z14, (i10 & 32) != 0 ? true : z15, (i10 & 64) != 0 ? true : z16, (i10 & 128) != 0 ? true : z17, (i10 & 256) != 0 ? true : z18, (i10 & 512) != 0 ? true : z19, (i10 & 1024) != 0 ? true : z20, (i10 & 2048) != 0 ? true : z21, (i10 & 4096) != 0 ? true : z22, (i10 & 8192) != 0 ? true : z23, (i10 & 16384) != 0 ? true : z24, (i10 & FastPairConstants.PAIR_TYPE_BLE_IN_PAIR) != 0 ? true : z25, (i10 & 65536) != 0 ? true : z26, (i10 & 131072) != 0 ? true : z27, (i10 & 262144) != 0 ? true : z28, (i10 & 524288) != 0 ? true : z29, (i10 & OplusPhoneUtils.PROPERTY_HIGH_DEF_AUDIO_EVS) != 0 ? true : z30);
    }
}
