package com.oplus.anim.model.content;

import android.graphics.Paint;
import b6.t;
import com.oplus.anim.C0820a;
import com.oplus.anim.EffectiveAnimationDrawable;
import f6.C1014a;
import f6.C1015b;
import f6.C1017d;
import g6.c;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeStroke implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f25998a;

    /* renamed from: b, reason: collision with root package name */
    public final C1015b f25999b;

    /* renamed from: c, reason: collision with root package name */
    public final List<C1015b> f26000c;

    /* renamed from: d, reason: collision with root package name */
    public final C1014a f26001d;

    /* renamed from: e, reason: collision with root package name */
    public final C1017d f26002e;

    /* renamed from: f, reason: collision with root package name */
    public final C1015b f26003f;

    /* renamed from: g, reason: collision with root package name */
    public final LineCapType f26004g;

    /* renamed from: h, reason: collision with root package name */
    public final LineJoinType f26005h;

    /* renamed from: i, reason: collision with root package name */
    public final float f26006i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f26007j;

    /* loaded from: classes3.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap a() {
            int i10 = a.f26016a[ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes3.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join a() {
            int i10 = a.f26017b[ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f26016a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f26017b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f26017b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26017b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26017b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f26016a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26016a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26016a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, C1015b c1015b, List<C1015b> list, C1014a c1014a, C1017d c1017d, C1015b c1015b2, LineCapType lineCapType, LineJoinType lineJoinType, float f10, boolean z10) {
        this.f25998a = str;
        this.f25999b = c1015b;
        this.f26000c = list;
        this.f26001d = c1014a;
        this.f26002e = c1017d;
        this.f26003f = c1015b2;
        this.f26004g = lineCapType;
        this.f26005h = lineJoinType;
        this.f26006i = f10;
        this.f26007j = z10;
    }

    @Override // g6.c
    public b6.c a(EffectiveAnimationDrawable effectiveAnimationDrawable, C0820a c0820a, com.oplus.anim.model.layer.a aVar) {
        return new t(effectiveAnimationDrawable, aVar, this);
    }

    public LineCapType b() {
        return this.f26004g;
    }

    public C1014a c() {
        return this.f26001d;
    }

    public C1015b d() {
        return this.f25999b;
    }

    public LineJoinType e() {
        return this.f26005h;
    }

    public List<C1015b> f() {
        return this.f26000c;
    }

    public float g() {
        return this.f26006i;
    }

    public String h() {
        return this.f25998a;
    }

    public C1017d i() {
        return this.f26002e;
    }

    public C1015b j() {
        return this.f26003f;
    }

    public boolean k() {
        return this.f26007j;
    }
}
