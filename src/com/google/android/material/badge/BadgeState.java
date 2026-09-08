package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.internal.ThemeEnforcement;
import e4.C0979e;
import e4.j;
import e4.k;
import e4.l;
import e4.m;
import java.util.Locale;
import n4.C1370a;
import u4.C1607c;
import u4.C1608d;

/* loaded from: classes3.dex */
public final class BadgeState {

    /* renamed from: a, reason: collision with root package name */
    public final State f22650a;

    /* renamed from: b, reason: collision with root package name */
    public final State f22651b;

    /* renamed from: c, reason: collision with root package name */
    public final float f22652c;

    /* renamed from: d, reason: collision with root package name */
    public final float f22653d;

    /* renamed from: e, reason: collision with root package name */
    public final float f22654e;

    /* renamed from: f, reason: collision with root package name */
    public final float f22655f;

    /* renamed from: g, reason: collision with root package name */
    public final float f22656g;

    /* renamed from: h, reason: collision with root package name */
    public final float f22657h;

    /* renamed from: i, reason: collision with root package name */
    public final int f22658i;

    /* renamed from: j, reason: collision with root package name */
    public final int f22659j;

    /* renamed from: k, reason: collision with root package name */
    public int f22660k;

    public BadgeState(Context context, int i10, int i11, int i12, State state) {
        CharSequence charSequence;
        int i13;
        int i14;
        int i15;
        int i16;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        int intValue6;
        int intValue7;
        int intValue8;
        int intValue9;
        int intValue10;
        int intValue11;
        int intValue12;
        int intValue13;
        int intValue14;
        boolean booleanValue;
        State state2 = new State();
        this.f22651b = state2;
        state = state == null ? new State() : state;
        if (i10 != 0) {
            state.f22670a = i10;
        }
        TypedArray a10 = a(context, state.f22670a, i11, i12);
        Resources resources = context.getResources();
        this.f22652c = a10.getDimensionPixelSize(m.f31154K, -1);
        this.f22658i = context.getResources().getDimensionPixelSize(C0979e.f30785g0);
        this.f22659j = context.getResources().getDimensionPixelSize(C0979e.f30789i0);
        this.f22653d = a10.getDimensionPixelSize(m.f31264U, -1);
        int i17 = m.f31242S;
        int i18 = C0979e.f30820y;
        this.f22654e = a10.getDimension(i17, resources.getDimension(i18));
        int i19 = m.f31297X;
        int i20 = C0979e.f30822z;
        this.f22656g = a10.getDimension(i19, resources.getDimension(i20));
        this.f22655f = a10.getDimension(m.f31143J, resources.getDimension(i18));
        this.f22657h = a10.getDimension(m.f31253T, resources.getDimension(i20));
        boolean z10 = true;
        this.f22660k = a10.getInt(m.f31373e0, 1);
        state2.f22678i = state.f22678i == -2 ? 255 : state.f22678i;
        if (state.f22680k != -2) {
            state2.f22680k = state.f22680k;
        } else {
            int i21 = m.f31362d0;
            if (a10.hasValue(i21)) {
                state2.f22680k = a10.getInt(i21, 0);
            } else {
                state2.f22680k = -1;
            }
        }
        if (state.f22679j != null) {
            state2.f22679j = state.f22679j;
        } else {
            int i22 = m.f31187N;
            if (a10.hasValue(i22)) {
                state2.f22679j = a10.getString(i22);
            }
        }
        state2.f22684o = state.f22684o;
        if (state.f22685p != null) {
            charSequence = state.f22685p;
        } else {
            charSequence = context.getString(k.f30988p);
        }
        state2.f22685p = charSequence;
        if (state.f22686q != 0) {
            i13 = state.f22686q;
        } else {
            i13 = j.f30947a;
        }
        state2.f22686q = i13;
        if (state.f22687r != 0) {
            i14 = state.f22687r;
        } else {
            i14 = k.f30993u;
        }
        state2.f22687r = i14;
        if (state.f22689y != null && !state.f22689y.booleanValue()) {
            z10 = false;
        }
        state2.f22689y = Boolean.valueOf(z10);
        if (state.f22681l != -2) {
            i15 = state.f22681l;
        } else {
            i15 = a10.getInt(m.f31340b0, -2);
        }
        state2.f22681l = i15;
        if (state.f22682m != -2) {
            i16 = state.f22682m;
        } else {
            i16 = a10.getInt(m.f31351c0, -2);
        }
        state2.f22682m = i16;
        if (state.f22674e != null) {
            intValue = state.f22674e.intValue();
        } else {
            intValue = a10.getResourceId(m.f31165L, l.f31019b);
        }
        state2.f22674e = Integer.valueOf(intValue);
        if (state.f22675f != null) {
            intValue2 = state.f22675f.intValue();
        } else {
            intValue2 = a10.getResourceId(m.f31176M, 0);
        }
        state2.f22675f = Integer.valueOf(intValue2);
        if (state.f22676g != null) {
            intValue3 = state.f22676g.intValue();
        } else {
            intValue3 = a10.getResourceId(m.f31275V, l.f31019b);
        }
        state2.f22676g = Integer.valueOf(intValue3);
        if (state.f22677h != null) {
            intValue4 = state.f22677h.intValue();
        } else {
            intValue4 = a10.getResourceId(m.f31286W, 0);
        }
        state2.f22677h = Integer.valueOf(intValue4);
        if (state.f22671b != null) {
            intValue5 = state.f22671b.intValue();
        } else {
            intValue5 = H(context, a10, m.f31121H);
        }
        state2.f22671b = Integer.valueOf(intValue5);
        if (state.f22673d != null) {
            intValue6 = state.f22673d.intValue();
        } else {
            intValue6 = a10.getResourceId(m.f31198O, l.f31023f);
        }
        state2.f22673d = Integer.valueOf(intValue6);
        if (state.f22672c != null) {
            state2.f22672c = state.f22672c;
        } else {
            int i23 = m.f31209P;
            if (a10.hasValue(i23)) {
                state2.f22672c = Integer.valueOf(H(context, a10, i23));
            } else {
                state2.f22672c = Integer.valueOf(new C1608d(context, state2.f22673d.intValue()).i().getDefaultColor());
            }
        }
        if (state.f22688x != null) {
            intValue7 = state.f22688x.intValue();
        } else {
            intValue7 = a10.getInt(m.f31132I, 8388661);
        }
        state2.f22688x = Integer.valueOf(intValue7);
        if (state.f22690z != null) {
            intValue8 = state.f22690z.intValue();
        } else {
            intValue8 = a10.getDimensionPixelSize(m.f31231R, resources.getDimensionPixelSize(C0979e.f30787h0));
        }
        state2.f22690z = Integer.valueOf(intValue8);
        if (state.f22661A != null) {
            intValue9 = state.f22661A.intValue();
        } else {
            intValue9 = a10.getDimensionPixelSize(m.f31220Q, resources.getDimensionPixelSize(C0979e.f30723A));
        }
        state2.f22661A = Integer.valueOf(intValue9);
        if (state.f22662B != null) {
            intValue10 = state.f22662B.intValue();
        } else {
            intValue10 = a10.getDimensionPixelOffset(m.f31308Y, 0);
        }
        state2.f22662B = Integer.valueOf(intValue10);
        if (state.f22663C != null) {
            intValue11 = state.f22663C.intValue();
        } else {
            intValue11 = a10.getDimensionPixelOffset(m.f31384f0, 0);
        }
        state2.f22663C = Integer.valueOf(intValue11);
        if (state.f22664D != null) {
            intValue12 = state.f22664D.intValue();
        } else {
            intValue12 = a10.getDimensionPixelOffset(m.f31318Z, state2.f22662B.intValue());
        }
        state2.f22664D = Integer.valueOf(intValue12);
        if (state.f22665E != null) {
            intValue13 = state.f22665E.intValue();
        } else {
            intValue13 = a10.getDimensionPixelOffset(m.f31395g0, state2.f22663C.intValue());
        }
        state2.f22665E = Integer.valueOf(intValue13);
        if (state.f22668H != null) {
            intValue14 = state.f22668H.intValue();
        } else {
            intValue14 = a10.getDimensionPixelOffset(m.f31329a0, 0);
        }
        state2.f22668H = Integer.valueOf(intValue14);
        state2.f22666F = Integer.valueOf(state.f22666F == null ? 0 : state.f22666F.intValue());
        state2.f22667G = Integer.valueOf(state.f22667G == null ? 0 : state.f22667G.intValue());
        if (state.f22669I != null) {
            booleanValue = state.f22669I.booleanValue();
        } else {
            booleanValue = a10.getBoolean(m.f31110G, false);
        }
        state2.f22669I = Boolean.valueOf(booleanValue);
        a10.recycle();
        if (state.f22683n == null) {
            state2.f22683n = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            state2.f22683n = state.f22683n;
        }
        this.f22650a = state;
    }

    public static int H(Context context, TypedArray typedArray, int i10) {
        return C1607c.a(context, typedArray, i10).getDefaultColor();
    }

    public int A() {
        return this.f22651b.f22673d.intValue();
    }

    public int B() {
        return this.f22651b.f22665E.intValue();
    }

    public int C() {
        return this.f22651b.f22663C.intValue();
    }

    public boolean D() {
        if (this.f22651b.f22680k != -1) {
            return true;
        }
        return false;
    }

    public boolean E() {
        if (this.f22651b.f22679j != null) {
            return true;
        }
        return false;
    }

    public boolean F() {
        return this.f22651b.f22669I.booleanValue();
    }

    public boolean G() {
        return this.f22651b.f22689y.booleanValue();
    }

    public void I(int i10) {
        this.f22650a.f22678i = i10;
        this.f22651b.f22678i = i10;
    }

    public final TypedArray a(Context context, int i10, int i11, int i12) {
        AttributeSet attributeSet;
        int i13;
        int i14;
        if (i10 != 0) {
            attributeSet = C1370a.k(context, i10, "badge");
            i13 = attributeSet.getStyleAttribute();
        } else {
            attributeSet = null;
            i13 = 0;
        }
        AttributeSet attributeSet2 = attributeSet;
        if (i13 == 0) {
            i14 = i12;
        } else {
            i14 = i13;
        }
        return ThemeEnforcement.obtainStyledAttributes(context, attributeSet2, m.f31099F, i11, i14, new int[0]);
    }

    public int b() {
        return this.f22651b.f22666F.intValue();
    }

    public int c() {
        return this.f22651b.f22667G.intValue();
    }

    public int d() {
        return this.f22651b.f22678i;
    }

    public int e() {
        return this.f22651b.f22671b.intValue();
    }

    public int f() {
        return this.f22651b.f22688x.intValue();
    }

    public int g() {
        return this.f22651b.f22690z.intValue();
    }

    public int h() {
        return this.f22651b.f22675f.intValue();
    }

    public int i() {
        return this.f22651b.f22674e.intValue();
    }

    public int j() {
        return this.f22651b.f22672c.intValue();
    }

    public int k() {
        return this.f22651b.f22661A.intValue();
    }

    public int l() {
        return this.f22651b.f22677h.intValue();
    }

    public int m() {
        return this.f22651b.f22676g.intValue();
    }

    public int n() {
        return this.f22651b.f22687r;
    }

    public CharSequence o() {
        return this.f22651b.f22684o;
    }

    public CharSequence p() {
        return this.f22651b.f22685p;
    }

    public int q() {
        return this.f22651b.f22686q;
    }

    public int r() {
        return this.f22651b.f22664D.intValue();
    }

    public int s() {
        return this.f22651b.f22662B.intValue();
    }

    public int t() {
        return this.f22651b.f22668H.intValue();
    }

    public int u() {
        return this.f22651b.f22681l;
    }

    public int v() {
        return this.f22651b.f22682m;
    }

    public int w() {
        return this.f22651b.f22680k;
    }

    public Locale x() {
        return this.f22651b.f22683n;
    }

    public State y() {
        return this.f22650a;
    }

    public String z() {
        return this.f22651b.f22679j;
    }

    /* loaded from: classes3.dex */
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new a();

        /* renamed from: A, reason: collision with root package name */
        public Integer f22661A;

        /* renamed from: B, reason: collision with root package name */
        public Integer f22662B;

        /* renamed from: C, reason: collision with root package name */
        public Integer f22663C;

        /* renamed from: D, reason: collision with root package name */
        public Integer f22664D;

        /* renamed from: E, reason: collision with root package name */
        public Integer f22665E;

        /* renamed from: F, reason: collision with root package name */
        public Integer f22666F;

        /* renamed from: G, reason: collision with root package name */
        public Integer f22667G;

        /* renamed from: H, reason: collision with root package name */
        public Integer f22668H;

        /* renamed from: I, reason: collision with root package name */
        public Boolean f22669I;

        /* renamed from: a, reason: collision with root package name */
        public int f22670a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f22671b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f22672c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f22673d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f22674e;

        /* renamed from: f, reason: collision with root package name */
        public Integer f22675f;

        /* renamed from: g, reason: collision with root package name */
        public Integer f22676g;

        /* renamed from: h, reason: collision with root package name */
        public Integer f22677h;

        /* renamed from: i, reason: collision with root package name */
        public int f22678i;

        /* renamed from: j, reason: collision with root package name */
        public String f22679j;

        /* renamed from: k, reason: collision with root package name */
        public int f22680k;

        /* renamed from: l, reason: collision with root package name */
        public int f22681l;

        /* renamed from: m, reason: collision with root package name */
        public int f22682m;

        /* renamed from: n, reason: collision with root package name */
        public Locale f22683n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f22684o;

        /* renamed from: p, reason: collision with root package name */
        public CharSequence f22685p;

        /* renamed from: q, reason: collision with root package name */
        public int f22686q;

        /* renamed from: r, reason: collision with root package name */
        public int f22687r;

        /* renamed from: x, reason: collision with root package name */
        public Integer f22688x;

        /* renamed from: y, reason: collision with root package name */
        public Boolean f22689y;

        /* renamed from: z, reason: collision with root package name */
        public Integer f22690z;

        /* loaded from: classes3.dex */
        public class a implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public State[] newArray(int i10) {
                return new State[i10];
            }
        }

        public State() {
            this.f22678i = 255;
            this.f22680k = -2;
            this.f22681l = -2;
            this.f22682m = -2;
            this.f22689y = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            String str;
            parcel.writeInt(this.f22670a);
            parcel.writeSerializable(this.f22671b);
            parcel.writeSerializable(this.f22672c);
            parcel.writeSerializable(this.f22673d);
            parcel.writeSerializable(this.f22674e);
            parcel.writeSerializable(this.f22675f);
            parcel.writeSerializable(this.f22676g);
            parcel.writeSerializable(this.f22677h);
            parcel.writeInt(this.f22678i);
            parcel.writeString(this.f22679j);
            parcel.writeInt(this.f22680k);
            parcel.writeInt(this.f22681l);
            parcel.writeInt(this.f22682m);
            CharSequence charSequence = this.f22684o;
            String str2 = null;
            if (charSequence != null) {
                str = charSequence.toString();
            } else {
                str = null;
            }
            parcel.writeString(str);
            CharSequence charSequence2 = this.f22685p;
            if (charSequence2 != null) {
                str2 = charSequence2.toString();
            }
            parcel.writeString(str2);
            parcel.writeInt(this.f22686q);
            parcel.writeSerializable(this.f22688x);
            parcel.writeSerializable(this.f22690z);
            parcel.writeSerializable(this.f22661A);
            parcel.writeSerializable(this.f22662B);
            parcel.writeSerializable(this.f22663C);
            parcel.writeSerializable(this.f22664D);
            parcel.writeSerializable(this.f22665E);
            parcel.writeSerializable(this.f22668H);
            parcel.writeSerializable(this.f22666F);
            parcel.writeSerializable(this.f22667G);
            parcel.writeSerializable(this.f22689y);
            parcel.writeSerializable(this.f22683n);
            parcel.writeSerializable(this.f22669I);
        }

        public State(Parcel parcel) {
            this.f22678i = 255;
            this.f22680k = -2;
            this.f22681l = -2;
            this.f22682m = -2;
            this.f22689y = Boolean.TRUE;
            this.f22670a = parcel.readInt();
            this.f22671b = (Integer) parcel.readSerializable();
            this.f22672c = (Integer) parcel.readSerializable();
            this.f22673d = (Integer) parcel.readSerializable();
            this.f22674e = (Integer) parcel.readSerializable();
            this.f22675f = (Integer) parcel.readSerializable();
            this.f22676g = (Integer) parcel.readSerializable();
            this.f22677h = (Integer) parcel.readSerializable();
            this.f22678i = parcel.readInt();
            this.f22679j = parcel.readString();
            this.f22680k = parcel.readInt();
            this.f22681l = parcel.readInt();
            this.f22682m = parcel.readInt();
            this.f22684o = parcel.readString();
            this.f22685p = parcel.readString();
            this.f22686q = parcel.readInt();
            this.f22688x = (Integer) parcel.readSerializable();
            this.f22690z = (Integer) parcel.readSerializable();
            this.f22661A = (Integer) parcel.readSerializable();
            this.f22662B = (Integer) parcel.readSerializable();
            this.f22663C = (Integer) parcel.readSerializable();
            this.f22664D = (Integer) parcel.readSerializable();
            this.f22665E = (Integer) parcel.readSerializable();
            this.f22668H = (Integer) parcel.readSerializable();
            this.f22666F = (Integer) parcel.readSerializable();
            this.f22667G = (Integer) parcel.readSerializable();
            this.f22689y = (Boolean) parcel.readSerializable();
            this.f22683n = (Locale) parcel.readSerializable();
            this.f22669I = (Boolean) parcel.readSerializable();
        }
    }
}
