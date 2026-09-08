package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import t.C1573a;
import v.C1616b;

/* compiled from: ConstraintSet.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f8689e = {0, 4, 8};

    /* renamed from: f, reason: collision with root package name */
    public static SparseIntArray f8690f;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8691a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f8692b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public boolean f8693c = true;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<Integer, a> f8694d = new HashMap<>();

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f8695a;

        /* renamed from: b, reason: collision with root package name */
        public final d f8696b = new d();

        /* renamed from: c, reason: collision with root package name */
        public final c f8697c = new c();

        /* renamed from: d, reason: collision with root package name */
        public final C0106b f8698d = new C0106b();

        /* renamed from: e, reason: collision with root package name */
        public final e f8699e = new e();

        /* renamed from: f, reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f8700f = new HashMap<>();

        public void d(ConstraintLayout.LayoutParams layoutParams) {
            C0106b c0106b = this.f8698d;
            layoutParams.leftToLeft = c0106b.f8742h;
            layoutParams.leftToRight = c0106b.f8744i;
            layoutParams.rightToLeft = c0106b.f8746j;
            layoutParams.rightToRight = c0106b.f8748k;
            layoutParams.topToTop = c0106b.f8749l;
            layoutParams.topToBottom = c0106b.f8750m;
            layoutParams.bottomToTop = c0106b.f8751n;
            layoutParams.bottomToBottom = c0106b.f8752o;
            layoutParams.baselineToBaseline = c0106b.f8753p;
            layoutParams.startToEnd = c0106b.f8754q;
            layoutParams.startToStart = c0106b.f8755r;
            layoutParams.endToStart = c0106b.f8756s;
            layoutParams.endToEnd = c0106b.f8757t;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = c0106b.f8705D;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = c0106b.f8706E;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = c0106b.f8707F;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = c0106b.f8708G;
            layoutParams.goneStartMargin = c0106b.f8716O;
            layoutParams.goneEndMargin = c0106b.f8715N;
            layoutParams.goneTopMargin = c0106b.f8712K;
            layoutParams.goneBottomMargin = c0106b.f8714M;
            layoutParams.horizontalBias = c0106b.f8758u;
            layoutParams.verticalBias = c0106b.f8759v;
            layoutParams.circleConstraint = c0106b.f8761x;
            layoutParams.circleRadius = c0106b.f8762y;
            layoutParams.circleAngle = c0106b.f8763z;
            layoutParams.dimensionRatio = c0106b.f8760w;
            layoutParams.editorAbsoluteX = c0106b.f8702A;
            layoutParams.editorAbsoluteY = c0106b.f8703B;
            layoutParams.verticalWeight = c0106b.f8717P;
            layoutParams.horizontalWeight = c0106b.f8718Q;
            layoutParams.verticalChainStyle = c0106b.f8720S;
            layoutParams.horizontalChainStyle = c0106b.f8719R;
            layoutParams.constrainedWidth = c0106b.f8743h0;
            layoutParams.constrainedHeight = c0106b.f8745i0;
            layoutParams.matchConstraintDefaultWidth = c0106b.f8721T;
            layoutParams.matchConstraintDefaultHeight = c0106b.f8722U;
            layoutParams.matchConstraintMaxWidth = c0106b.f8723V;
            layoutParams.matchConstraintMaxHeight = c0106b.f8724W;
            layoutParams.matchConstraintMinWidth = c0106b.f8725X;
            layoutParams.matchConstraintMinHeight = c0106b.f8726Y;
            layoutParams.matchConstraintPercentWidth = c0106b.f8727Z;
            layoutParams.matchConstraintPercentHeight = c0106b.f8729a0;
            layoutParams.orientation = c0106b.f8704C;
            layoutParams.guidePercent = c0106b.f8740g;
            layoutParams.guideBegin = c0106b.f8736e;
            layoutParams.guideEnd = c0106b.f8738f;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = c0106b.f8732c;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = c0106b.f8734d;
            String str = c0106b.f8741g0;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.setMarginStart(c0106b.f8710I);
            layoutParams.setMarginEnd(this.f8698d.f8709H);
            layoutParams.validate();
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f8698d.a(this.f8698d);
            aVar.f8697c.a(this.f8697c);
            aVar.f8696b.a(this.f8696b);
            aVar.f8699e.a(this.f8699e);
            aVar.f8695a = this.f8695a;
            return aVar;
        }

        public final void f(int i10, ConstraintLayout.LayoutParams layoutParams) {
            this.f8695a = i10;
            C0106b c0106b = this.f8698d;
            c0106b.f8742h = layoutParams.leftToLeft;
            c0106b.f8744i = layoutParams.leftToRight;
            c0106b.f8746j = layoutParams.rightToLeft;
            c0106b.f8748k = layoutParams.rightToRight;
            c0106b.f8749l = layoutParams.topToTop;
            c0106b.f8750m = layoutParams.topToBottom;
            c0106b.f8751n = layoutParams.bottomToTop;
            c0106b.f8752o = layoutParams.bottomToBottom;
            c0106b.f8753p = layoutParams.baselineToBaseline;
            c0106b.f8754q = layoutParams.startToEnd;
            c0106b.f8755r = layoutParams.startToStart;
            c0106b.f8756s = layoutParams.endToStart;
            c0106b.f8757t = layoutParams.endToEnd;
            c0106b.f8758u = layoutParams.horizontalBias;
            c0106b.f8759v = layoutParams.verticalBias;
            c0106b.f8760w = layoutParams.dimensionRatio;
            c0106b.f8761x = layoutParams.circleConstraint;
            c0106b.f8762y = layoutParams.circleRadius;
            c0106b.f8763z = layoutParams.circleAngle;
            c0106b.f8702A = layoutParams.editorAbsoluteX;
            c0106b.f8703B = layoutParams.editorAbsoluteY;
            c0106b.f8704C = layoutParams.orientation;
            c0106b.f8740g = layoutParams.guidePercent;
            c0106b.f8736e = layoutParams.guideBegin;
            c0106b.f8738f = layoutParams.guideEnd;
            c0106b.f8732c = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            c0106b.f8734d = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            c0106b.f8705D = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            c0106b.f8706E = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            c0106b.f8707F = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            c0106b.f8708G = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            c0106b.f8717P = layoutParams.verticalWeight;
            c0106b.f8718Q = layoutParams.horizontalWeight;
            c0106b.f8720S = layoutParams.verticalChainStyle;
            c0106b.f8719R = layoutParams.horizontalChainStyle;
            c0106b.f8743h0 = layoutParams.constrainedWidth;
            c0106b.f8745i0 = layoutParams.constrainedHeight;
            c0106b.f8721T = layoutParams.matchConstraintDefaultWidth;
            c0106b.f8722U = layoutParams.matchConstraintDefaultHeight;
            c0106b.f8723V = layoutParams.matchConstraintMaxWidth;
            c0106b.f8724W = layoutParams.matchConstraintMaxHeight;
            c0106b.f8725X = layoutParams.matchConstraintMinWidth;
            c0106b.f8726Y = layoutParams.matchConstraintMinHeight;
            c0106b.f8727Z = layoutParams.matchConstraintPercentWidth;
            c0106b.f8729a0 = layoutParams.matchConstraintPercentHeight;
            c0106b.f8741g0 = layoutParams.constraintTag;
            c0106b.f8712K = layoutParams.goneTopMargin;
            c0106b.f8714M = layoutParams.goneBottomMargin;
            c0106b.f8711J = layoutParams.goneLeftMargin;
            c0106b.f8713L = layoutParams.goneRightMargin;
            c0106b.f8716O = layoutParams.goneStartMargin;
            c0106b.f8715N = layoutParams.goneEndMargin;
            c0106b.f8709H = layoutParams.getMarginEnd();
            this.f8698d.f8710I = layoutParams.getMarginStart();
        }

        public final void g(int i10, Constraints.LayoutParams layoutParams) {
            f(i10, layoutParams);
            this.f8696b.f8775d = layoutParams.f8655a;
            e eVar = this.f8699e;
            eVar.f8779b = layoutParams.f8658d;
            eVar.f8780c = layoutParams.f8659e;
            eVar.f8781d = layoutParams.f8660f;
            eVar.f8782e = layoutParams.f8661g;
            eVar.f8783f = layoutParams.f8662h;
            eVar.f8784g = layoutParams.f8663i;
            eVar.f8785h = layoutParams.f8664j;
            eVar.f8786i = layoutParams.f8665k;
            eVar.f8787j = layoutParams.f8666l;
            eVar.f8788k = layoutParams.f8667m;
            eVar.f8790m = layoutParams.f8657c;
            eVar.f8789l = layoutParams.f8656b;
        }

        public final void h(ConstraintHelper constraintHelper, int i10, Constraints.LayoutParams layoutParams) {
            g(i10, layoutParams);
            if (constraintHelper instanceof Barrier) {
                C0106b c0106b = this.f8698d;
                c0106b.f8735d0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                c0106b.f8731b0 = barrier.getType();
                this.f8698d.f8737e0 = barrier.getReferencedIds();
                this.f8698d.f8733c0 = barrier.getMargin();
            }
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0106b {

        /* renamed from: k0, reason: collision with root package name */
        public static SparseIntArray f8701k0;

        /* renamed from: c, reason: collision with root package name */
        public int f8732c;

        /* renamed from: d, reason: collision with root package name */
        public int f8734d;

        /* renamed from: e0, reason: collision with root package name */
        public int[] f8737e0;

        /* renamed from: f0, reason: collision with root package name */
        public String f8739f0;

        /* renamed from: g0, reason: collision with root package name */
        public String f8741g0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f8728a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f8730b = false;

        /* renamed from: e, reason: collision with root package name */
        public int f8736e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f8738f = -1;

        /* renamed from: g, reason: collision with root package name */
        public float f8740g = -1.0f;

        /* renamed from: h, reason: collision with root package name */
        public int f8742h = -1;

        /* renamed from: i, reason: collision with root package name */
        public int f8744i = -1;

        /* renamed from: j, reason: collision with root package name */
        public int f8746j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f8748k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f8749l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f8750m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f8751n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f8752o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f8753p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f8754q = -1;

        /* renamed from: r, reason: collision with root package name */
        public int f8755r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f8756s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f8757t = -1;

        /* renamed from: u, reason: collision with root package name */
        public float f8758u = 0.5f;

        /* renamed from: v, reason: collision with root package name */
        public float f8759v = 0.5f;

        /* renamed from: w, reason: collision with root package name */
        public String f8760w = null;

        /* renamed from: x, reason: collision with root package name */
        public int f8761x = -1;

        /* renamed from: y, reason: collision with root package name */
        public int f8762y = 0;

        /* renamed from: z, reason: collision with root package name */
        public float f8763z = 0.0f;

        /* renamed from: A, reason: collision with root package name */
        public int f8702A = -1;

        /* renamed from: B, reason: collision with root package name */
        public int f8703B = -1;

        /* renamed from: C, reason: collision with root package name */
        public int f8704C = -1;

        /* renamed from: D, reason: collision with root package name */
        public int f8705D = -1;

        /* renamed from: E, reason: collision with root package name */
        public int f8706E = -1;

        /* renamed from: F, reason: collision with root package name */
        public int f8707F = -1;

        /* renamed from: G, reason: collision with root package name */
        public int f8708G = -1;

        /* renamed from: H, reason: collision with root package name */
        public int f8709H = -1;

        /* renamed from: I, reason: collision with root package name */
        public int f8710I = -1;

        /* renamed from: J, reason: collision with root package name */
        public int f8711J = -1;

        /* renamed from: K, reason: collision with root package name */
        public int f8712K = -1;

        /* renamed from: L, reason: collision with root package name */
        public int f8713L = -1;

        /* renamed from: M, reason: collision with root package name */
        public int f8714M = -1;

        /* renamed from: N, reason: collision with root package name */
        public int f8715N = -1;

        /* renamed from: O, reason: collision with root package name */
        public int f8716O = -1;

        /* renamed from: P, reason: collision with root package name */
        public float f8717P = -1.0f;

        /* renamed from: Q, reason: collision with root package name */
        public float f8718Q = -1.0f;

        /* renamed from: R, reason: collision with root package name */
        public int f8719R = 0;

        /* renamed from: S, reason: collision with root package name */
        public int f8720S = 0;

        /* renamed from: T, reason: collision with root package name */
        public int f8721T = 0;

        /* renamed from: U, reason: collision with root package name */
        public int f8722U = 0;

        /* renamed from: V, reason: collision with root package name */
        public int f8723V = -1;

        /* renamed from: W, reason: collision with root package name */
        public int f8724W = -1;

        /* renamed from: X, reason: collision with root package name */
        public int f8725X = -1;

        /* renamed from: Y, reason: collision with root package name */
        public int f8726Y = -1;

        /* renamed from: Z, reason: collision with root package name */
        public float f8727Z = 1.0f;

        /* renamed from: a0, reason: collision with root package name */
        public float f8729a0 = 1.0f;

        /* renamed from: b0, reason: collision with root package name */
        public int f8731b0 = -1;

        /* renamed from: c0, reason: collision with root package name */
        public int f8733c0 = 0;

        /* renamed from: d0, reason: collision with root package name */
        public int f8735d0 = -1;

        /* renamed from: h0, reason: collision with root package name */
        public boolean f8743h0 = false;

        /* renamed from: i0, reason: collision with root package name */
        public boolean f8745i0 = false;

        /* renamed from: j0, reason: collision with root package name */
        public boolean f8747j0 = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f8701k0 = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.e.f8933P5, 24);
            f8701k0.append(androidx.constraintlayout.widget.e.f8942Q5, 25);
            f8701k0.append(androidx.constraintlayout.widget.e.f8960S5, 28);
            f8701k0.append(androidx.constraintlayout.widget.e.f8969T5, 29);
            f8701k0.append(androidx.constraintlayout.widget.e.f9014Y5, 35);
            f8701k0.append(androidx.constraintlayout.widget.e.f9005X5, 34);
            f8701k0.append(androidx.constraintlayout.widget.e.f8798A5, 4);
            f8701k0.append(androidx.constraintlayout.widget.e.f9270z5, 3);
            f8701k0.append(androidx.constraintlayout.widget.e.f9252x5, 1);
            f8701k0.append(androidx.constraintlayout.widget.e.f9063d6, 6);
            f8701k0.append(androidx.constraintlayout.widget.e.f9073e6, 7);
            f8701k0.append(androidx.constraintlayout.widget.e.f8861H5, 17);
            f8701k0.append(androidx.constraintlayout.widget.e.f8870I5, 18);
            f8701k0.append(androidx.constraintlayout.widget.e.f8879J5, 19);
            f8701k0.append(androidx.constraintlayout.widget.e.f9112i5, 26);
            f8701k0.append(androidx.constraintlayout.widget.e.f8978U5, 31);
            f8701k0.append(androidx.constraintlayout.widget.e.f8987V5, 32);
            f8701k0.append(androidx.constraintlayout.widget.e.f8852G5, 10);
            f8701k0.append(androidx.constraintlayout.widget.e.f8843F5, 9);
            f8701k0.append(androidx.constraintlayout.widget.e.f9103h6, 13);
            f8701k0.append(androidx.constraintlayout.widget.e.f9133k6, 16);
            f8701k0.append(androidx.constraintlayout.widget.e.f9113i6, 14);
            f8701k0.append(androidx.constraintlayout.widget.e.f9083f6, 11);
            f8701k0.append(androidx.constraintlayout.widget.e.f9123j6, 15);
            f8701k0.append(androidx.constraintlayout.widget.e.f9093g6, 12);
            f8701k0.append(androidx.constraintlayout.widget.e.f9043b6, 38);
            f8701k0.append(androidx.constraintlayout.widget.e.f8915N5, 37);
            f8701k0.append(androidx.constraintlayout.widget.e.f8906M5, 39);
            f8701k0.append(androidx.constraintlayout.widget.e.f9033a6, 40);
            f8701k0.append(androidx.constraintlayout.widget.e.f8897L5, 20);
            f8701k0.append(androidx.constraintlayout.widget.e.f9023Z5, 36);
            f8701k0.append(androidx.constraintlayout.widget.e.f8834E5, 5);
            f8701k0.append(androidx.constraintlayout.widget.e.f8924O5, 76);
            f8701k0.append(androidx.constraintlayout.widget.e.f8996W5, 76);
            f8701k0.append(androidx.constraintlayout.widget.e.f8951R5, 76);
            f8701k0.append(androidx.constraintlayout.widget.e.f9261y5, 76);
            f8701k0.append(androidx.constraintlayout.widget.e.f9243w5, 76);
            f8701k0.append(androidx.constraintlayout.widget.e.f9142l5, 23);
            f8701k0.append(androidx.constraintlayout.widget.e.f9162n5, 27);
            f8701k0.append(androidx.constraintlayout.widget.e.f9180p5, 30);
            f8701k0.append(androidx.constraintlayout.widget.e.f9189q5, 8);
            f8701k0.append(androidx.constraintlayout.widget.e.f9152m5, 33);
            f8701k0.append(androidx.constraintlayout.widget.e.f9171o5, 2);
            f8701k0.append(androidx.constraintlayout.widget.e.f9122j5, 22);
            f8701k0.append(androidx.constraintlayout.widget.e.f9132k5, 21);
            f8701k0.append(androidx.constraintlayout.widget.e.f8807B5, 61);
            f8701k0.append(androidx.constraintlayout.widget.e.f8825D5, 62);
            f8701k0.append(androidx.constraintlayout.widget.e.f8816C5, 63);
            f8701k0.append(androidx.constraintlayout.widget.e.f9053c6, 69);
            f8701k0.append(androidx.constraintlayout.widget.e.f8888K5, 70);
            f8701k0.append(androidx.constraintlayout.widget.e.f9225u5, 71);
            f8701k0.append(androidx.constraintlayout.widget.e.f9207s5, 72);
            f8701k0.append(androidx.constraintlayout.widget.e.f9216t5, 73);
            f8701k0.append(androidx.constraintlayout.widget.e.f9234v5, 74);
            f8701k0.append(androidx.constraintlayout.widget.e.f9198r5, 75);
        }

        public void a(C0106b c0106b) {
            this.f8728a = c0106b.f8728a;
            this.f8732c = c0106b.f8732c;
            this.f8730b = c0106b.f8730b;
            this.f8734d = c0106b.f8734d;
            this.f8736e = c0106b.f8736e;
            this.f8738f = c0106b.f8738f;
            this.f8740g = c0106b.f8740g;
            this.f8742h = c0106b.f8742h;
            this.f8744i = c0106b.f8744i;
            this.f8746j = c0106b.f8746j;
            this.f8748k = c0106b.f8748k;
            this.f8749l = c0106b.f8749l;
            this.f8750m = c0106b.f8750m;
            this.f8751n = c0106b.f8751n;
            this.f8752o = c0106b.f8752o;
            this.f8753p = c0106b.f8753p;
            this.f8754q = c0106b.f8754q;
            this.f8755r = c0106b.f8755r;
            this.f8756s = c0106b.f8756s;
            this.f8757t = c0106b.f8757t;
            this.f8758u = c0106b.f8758u;
            this.f8759v = c0106b.f8759v;
            this.f8760w = c0106b.f8760w;
            this.f8761x = c0106b.f8761x;
            this.f8762y = c0106b.f8762y;
            this.f8763z = c0106b.f8763z;
            this.f8702A = c0106b.f8702A;
            this.f8703B = c0106b.f8703B;
            this.f8704C = c0106b.f8704C;
            this.f8705D = c0106b.f8705D;
            this.f8706E = c0106b.f8706E;
            this.f8707F = c0106b.f8707F;
            this.f8708G = c0106b.f8708G;
            this.f8709H = c0106b.f8709H;
            this.f8710I = c0106b.f8710I;
            this.f8711J = c0106b.f8711J;
            this.f8712K = c0106b.f8712K;
            this.f8713L = c0106b.f8713L;
            this.f8714M = c0106b.f8714M;
            this.f8715N = c0106b.f8715N;
            this.f8716O = c0106b.f8716O;
            this.f8717P = c0106b.f8717P;
            this.f8718Q = c0106b.f8718Q;
            this.f8719R = c0106b.f8719R;
            this.f8720S = c0106b.f8720S;
            this.f8721T = c0106b.f8721T;
            this.f8722U = c0106b.f8722U;
            this.f8723V = c0106b.f8723V;
            this.f8724W = c0106b.f8724W;
            this.f8725X = c0106b.f8725X;
            this.f8726Y = c0106b.f8726Y;
            this.f8727Z = c0106b.f8727Z;
            this.f8729a0 = c0106b.f8729a0;
            this.f8731b0 = c0106b.f8731b0;
            this.f8733c0 = c0106b.f8733c0;
            this.f8735d0 = c0106b.f8735d0;
            this.f8741g0 = c0106b.f8741g0;
            int[] iArr = c0106b.f8737e0;
            if (iArr != null) {
                this.f8737e0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f8737e0 = null;
            }
            this.f8739f0 = c0106b.f8739f0;
            this.f8743h0 = c0106b.f8743h0;
            this.f8745i0 = c0106b.f8745i0;
            this.f8747j0 = c0106b.f8747j0;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f9102h5);
            this.f8730b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                int i11 = f8701k0.get(index);
                if (i11 != 80) {
                    if (i11 != 81) {
                        switch (i11) {
                            case 1:
                                this.f8753p = b.y(obtainStyledAttributes, index, this.f8753p);
                                break;
                            case 2:
                                this.f8708G = obtainStyledAttributes.getDimensionPixelSize(index, this.f8708G);
                                break;
                            case 3:
                                this.f8752o = b.y(obtainStyledAttributes, index, this.f8752o);
                                break;
                            case 4:
                                this.f8751n = b.y(obtainStyledAttributes, index, this.f8751n);
                                break;
                            case 5:
                                this.f8760w = obtainStyledAttributes.getString(index);
                                break;
                            case 6:
                                this.f8702A = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8702A);
                                break;
                            case 7:
                                this.f8703B = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8703B);
                                break;
                            case 8:
                                this.f8709H = obtainStyledAttributes.getDimensionPixelSize(index, this.f8709H);
                                break;
                            case 9:
                                this.f8757t = b.y(obtainStyledAttributes, index, this.f8757t);
                                break;
                            case 10:
                                this.f8756s = b.y(obtainStyledAttributes, index, this.f8756s);
                                break;
                            case 11:
                                this.f8714M = obtainStyledAttributes.getDimensionPixelSize(index, this.f8714M);
                                break;
                            case 12:
                                this.f8715N = obtainStyledAttributes.getDimensionPixelSize(index, this.f8715N);
                                break;
                            case 13:
                                this.f8711J = obtainStyledAttributes.getDimensionPixelSize(index, this.f8711J);
                                break;
                            case 14:
                                this.f8713L = obtainStyledAttributes.getDimensionPixelSize(index, this.f8713L);
                                break;
                            case 15:
                                this.f8716O = obtainStyledAttributes.getDimensionPixelSize(index, this.f8716O);
                                break;
                            case 16:
                                this.f8712K = obtainStyledAttributes.getDimensionPixelSize(index, this.f8712K);
                                break;
                            case 17:
                                this.f8736e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8736e);
                                break;
                            case 18:
                                this.f8738f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f8738f);
                                break;
                            case 19:
                                this.f8740g = obtainStyledAttributes.getFloat(index, this.f8740g);
                                break;
                            case 20:
                                this.f8758u = obtainStyledAttributes.getFloat(index, this.f8758u);
                                break;
                            case 21:
                                this.f8734d = obtainStyledAttributes.getLayoutDimension(index, this.f8734d);
                                break;
                            case 22:
                                this.f8732c = obtainStyledAttributes.getLayoutDimension(index, this.f8732c);
                                break;
                            case 23:
                                this.f8705D = obtainStyledAttributes.getDimensionPixelSize(index, this.f8705D);
                                break;
                            case 24:
                                this.f8742h = b.y(obtainStyledAttributes, index, this.f8742h);
                                break;
                            case 25:
                                this.f8744i = b.y(obtainStyledAttributes, index, this.f8744i);
                                break;
                            case 26:
                                this.f8704C = obtainStyledAttributes.getInt(index, this.f8704C);
                                break;
                            case 27:
                                this.f8706E = obtainStyledAttributes.getDimensionPixelSize(index, this.f8706E);
                                break;
                            case 28:
                                this.f8746j = b.y(obtainStyledAttributes, index, this.f8746j);
                                break;
                            case 29:
                                this.f8748k = b.y(obtainStyledAttributes, index, this.f8748k);
                                break;
                            case 30:
                                this.f8710I = obtainStyledAttributes.getDimensionPixelSize(index, this.f8710I);
                                break;
                            case 31:
                                this.f8754q = b.y(obtainStyledAttributes, index, this.f8754q);
                                break;
                            case 32:
                                this.f8755r = b.y(obtainStyledAttributes, index, this.f8755r);
                                break;
                            case 33:
                                this.f8707F = obtainStyledAttributes.getDimensionPixelSize(index, this.f8707F);
                                break;
                            case 34:
                                this.f8750m = b.y(obtainStyledAttributes, index, this.f8750m);
                                break;
                            case 35:
                                this.f8749l = b.y(obtainStyledAttributes, index, this.f8749l);
                                break;
                            case 36:
                                this.f8759v = obtainStyledAttributes.getFloat(index, this.f8759v);
                                break;
                            case 37:
                                this.f8718Q = obtainStyledAttributes.getFloat(index, this.f8718Q);
                                break;
                            case 38:
                                this.f8717P = obtainStyledAttributes.getFloat(index, this.f8717P);
                                break;
                            case 39:
                                this.f8719R = obtainStyledAttributes.getInt(index, this.f8719R);
                                break;
                            case 40:
                                this.f8720S = obtainStyledAttributes.getInt(index, this.f8720S);
                                break;
                            default:
                                switch (i11) {
                                    case 54:
                                        this.f8721T = obtainStyledAttributes.getInt(index, this.f8721T);
                                        break;
                                    case 55:
                                        this.f8722U = obtainStyledAttributes.getInt(index, this.f8722U);
                                        break;
                                    case 56:
                                        this.f8723V = obtainStyledAttributes.getDimensionPixelSize(index, this.f8723V);
                                        break;
                                    case 57:
                                        this.f8724W = obtainStyledAttributes.getDimensionPixelSize(index, this.f8724W);
                                        break;
                                    case 58:
                                        this.f8725X = obtainStyledAttributes.getDimensionPixelSize(index, this.f8725X);
                                        break;
                                    case 59:
                                        this.f8726Y = obtainStyledAttributes.getDimensionPixelSize(index, this.f8726Y);
                                        break;
                                    default:
                                        switch (i11) {
                                            case 61:
                                                this.f8761x = b.y(obtainStyledAttributes, index, this.f8761x);
                                                break;
                                            case 62:
                                                this.f8762y = obtainStyledAttributes.getDimensionPixelSize(index, this.f8762y);
                                                break;
                                            case 63:
                                                this.f8763z = obtainStyledAttributes.getFloat(index, this.f8763z);
                                                break;
                                            default:
                                                switch (i11) {
                                                    case 69:
                                                        this.f8727Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                        break;
                                                    case 70:
                                                        this.f8729a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                        break;
                                                    case 71:
                                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                        break;
                                                    case 72:
                                                        this.f8731b0 = obtainStyledAttributes.getInt(index, this.f8731b0);
                                                        break;
                                                    case 73:
                                                        this.f8733c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f8733c0);
                                                        break;
                                                    case 74:
                                                        this.f8739f0 = obtainStyledAttributes.getString(index);
                                                        break;
                                                    case 75:
                                                        this.f8747j0 = obtainStyledAttributes.getBoolean(index, this.f8747j0);
                                                        break;
                                                    case 76:
                                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f8701k0.get(index));
                                                        break;
                                                    case 77:
                                                        this.f8741g0 = obtainStyledAttributes.getString(index);
                                                        break;
                                                    default:
                                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f8701k0.get(index));
                                                        break;
                                                }
                                        }
                                }
                        }
                    } else {
                        this.f8745i0 = obtainStyledAttributes.getBoolean(index, this.f8745i0);
                    }
                } else {
                    this.f8743h0 = obtainStyledAttributes.getBoolean(index, this.f8743h0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: h, reason: collision with root package name */
        public static SparseIntArray f8764h;

        /* renamed from: a, reason: collision with root package name */
        public boolean f8765a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f8766b = -1;

        /* renamed from: c, reason: collision with root package name */
        public String f8767c = null;

        /* renamed from: d, reason: collision with root package name */
        public int f8768d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f8769e = 0;

        /* renamed from: f, reason: collision with root package name */
        public float f8770f = Float.NaN;

        /* renamed from: g, reason: collision with root package name */
        public float f8771g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f8764h = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.e.f8808B6, 1);
            f8764h.append(androidx.constraintlayout.widget.e.f8826D6, 2);
            f8764h.append(androidx.constraintlayout.widget.e.f8835E6, 3);
            f8764h.append(androidx.constraintlayout.widget.e.f8799A6, 4);
            f8764h.append(androidx.constraintlayout.widget.e.f9271z6, 5);
            f8764h.append(androidx.constraintlayout.widget.e.f8817C6, 6);
        }

        public void a(c cVar) {
            this.f8765a = cVar.f8765a;
            this.f8766b = cVar.f8766b;
            this.f8767c = cVar.f8767c;
            this.f8768d = cVar.f8768d;
            this.f8769e = cVar.f8769e;
            this.f8771g = cVar.f8771g;
            this.f8770f = cVar.f8770f;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f9262y6);
            this.f8765a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f8764h.get(index)) {
                    case 1:
                        this.f8771g = obtainStyledAttributes.getFloat(index, this.f8771g);
                        break;
                    case 2:
                        this.f8768d = obtainStyledAttributes.getInt(index, this.f8768d);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.f8767c = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.f8767c = s.c.f36582c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f8769e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f8766b = b.y(obtainStyledAttributes, index, this.f8766b);
                        break;
                    case 6:
                        this.f8770f = obtainStyledAttributes.getFloat(index, this.f8770f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public boolean f8772a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f8773b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f8774c = 0;

        /* renamed from: d, reason: collision with root package name */
        public float f8775d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f8776e = Float.NaN;

        public void a(d dVar) {
            this.f8772a = dVar.f8772a;
            this.f8773b = dVar.f8773b;
            this.f8775d = dVar.f8775d;
            this.f8776e = dVar.f8776e;
            this.f8774c = dVar.f8774c;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f9173o7);
            this.f8772a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == androidx.constraintlayout.widget.e.f9191q7) {
                    this.f8775d = obtainStyledAttributes.getFloat(index, this.f8775d);
                } else if (index == androidx.constraintlayout.widget.e.f9182p7) {
                    this.f8773b = obtainStyledAttributes.getInt(index, this.f8773b);
                    this.f8773b = b.f8689e[this.f8773b];
                } else if (index == androidx.constraintlayout.widget.e.f9209s7) {
                    this.f8774c = obtainStyledAttributes.getInt(index, this.f8774c);
                } else if (index == androidx.constraintlayout.widget.e.f9200r7) {
                    this.f8776e = obtainStyledAttributes.getFloat(index, this.f8776e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: n, reason: collision with root package name */
        public static SparseIntArray f8777n;

        /* renamed from: a, reason: collision with root package name */
        public boolean f8778a = false;

        /* renamed from: b, reason: collision with root package name */
        public float f8779b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f8780c = 0.0f;

        /* renamed from: d, reason: collision with root package name */
        public float f8781d = 0.0f;

        /* renamed from: e, reason: collision with root package name */
        public float f8782e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        public float f8783f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f8784g = Float.NaN;

        /* renamed from: h, reason: collision with root package name */
        public float f8785h = Float.NaN;

        /* renamed from: i, reason: collision with root package name */
        public float f8786i = 0.0f;

        /* renamed from: j, reason: collision with root package name */
        public float f8787j = 0.0f;

        /* renamed from: k, reason: collision with root package name */
        public float f8788k = 0.0f;

        /* renamed from: l, reason: collision with root package name */
        public boolean f8789l = false;

        /* renamed from: m, reason: collision with root package name */
        public float f8790m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f8777n = sparseIntArray;
            sparseIntArray.append(androidx.constraintlayout.widget.e.f8917N7, 1);
            f8777n.append(androidx.constraintlayout.widget.e.f8926O7, 2);
            f8777n.append(androidx.constraintlayout.widget.e.f8935P7, 3);
            f8777n.append(androidx.constraintlayout.widget.e.f8899L7, 4);
            f8777n.append(androidx.constraintlayout.widget.e.f8908M7, 5);
            f8777n.append(androidx.constraintlayout.widget.e.f8863H7, 6);
            f8777n.append(androidx.constraintlayout.widget.e.f8872I7, 7);
            f8777n.append(androidx.constraintlayout.widget.e.f8881J7, 8);
            f8777n.append(androidx.constraintlayout.widget.e.f8890K7, 9);
            f8777n.append(androidx.constraintlayout.widget.e.f8944Q7, 10);
            f8777n.append(androidx.constraintlayout.widget.e.f8953R7, 11);
        }

        public void a(e eVar) {
            this.f8778a = eVar.f8778a;
            this.f8779b = eVar.f8779b;
            this.f8780c = eVar.f8780c;
            this.f8781d = eVar.f8781d;
            this.f8782e = eVar.f8782e;
            this.f8783f = eVar.f8783f;
            this.f8784g = eVar.f8784g;
            this.f8785h = eVar.f8785h;
            this.f8786i = eVar.f8786i;
            this.f8787j = eVar.f8787j;
            this.f8788k = eVar.f8788k;
            this.f8789l = eVar.f8789l;
            this.f8790m = eVar.f8790m;
        }

        public void b(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f8854G7);
            this.f8778a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                switch (f8777n.get(index)) {
                    case 1:
                        this.f8779b = obtainStyledAttributes.getFloat(index, this.f8779b);
                        break;
                    case 2:
                        this.f8780c = obtainStyledAttributes.getFloat(index, this.f8780c);
                        break;
                    case 3:
                        this.f8781d = obtainStyledAttributes.getFloat(index, this.f8781d);
                        break;
                    case 4:
                        this.f8782e = obtainStyledAttributes.getFloat(index, this.f8782e);
                        break;
                    case 5:
                        this.f8783f = obtainStyledAttributes.getFloat(index, this.f8783f);
                        break;
                    case 6:
                        this.f8784g = obtainStyledAttributes.getDimension(index, this.f8784g);
                        break;
                    case 7:
                        this.f8785h = obtainStyledAttributes.getDimension(index, this.f8785h);
                        break;
                    case 8:
                        this.f8786i = obtainStyledAttributes.getDimension(index, this.f8786i);
                        break;
                    case 9:
                        this.f8787j = obtainStyledAttributes.getDimension(index, this.f8787j);
                        break;
                    case 10:
                        this.f8788k = obtainStyledAttributes.getDimension(index, this.f8788k);
                        break;
                    case 11:
                        this.f8789l = true;
                        this.f8790m = obtainStyledAttributes.getDimension(index, this.f8790m);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f8690f = sparseIntArray;
        sparseIntArray.append(androidx.constraintlayout.widget.e.f9220u0, 25);
        f8690f.append(androidx.constraintlayout.widget.e.f9229v0, 26);
        f8690f.append(androidx.constraintlayout.widget.e.f9247x0, 29);
        f8690f.append(androidx.constraintlayout.widget.e.f9256y0, 30);
        f8690f.append(androidx.constraintlayout.widget.e.f8829E0, 36);
        f8690f.append(androidx.constraintlayout.widget.e.f8820D0, 35);
        f8690f.append(androidx.constraintlayout.widget.e.f9047c0, 4);
        f8690f.append(androidx.constraintlayout.widget.e.f9037b0, 3);
        f8690f.append(androidx.constraintlayout.widget.e.f9017Z, 1);
        f8690f.append(androidx.constraintlayout.widget.e.f8901M0, 6);
        f8690f.append(androidx.constraintlayout.widget.e.f8910N0, 7);
        f8690f.append(androidx.constraintlayout.widget.e.f9117j0, 17);
        f8690f.append(androidx.constraintlayout.widget.e.f9127k0, 18);
        f8690f.append(androidx.constraintlayout.widget.e.f9137l0, 19);
        f8690f.append(androidx.constraintlayout.widget.e.f9201s, 27);
        f8690f.append(androidx.constraintlayout.widget.e.f9265z0, 32);
        f8690f.append(androidx.constraintlayout.widget.e.f8793A0, 33);
        f8690f.append(androidx.constraintlayout.widget.e.f9107i0, 10);
        f8690f.append(androidx.constraintlayout.widget.e.f9097h0, 9);
        f8690f.append(androidx.constraintlayout.widget.e.f8937Q0, 13);
        f8690f.append(androidx.constraintlayout.widget.e.f8964T0, 16);
        f8690f.append(androidx.constraintlayout.widget.e.f8946R0, 14);
        f8690f.append(androidx.constraintlayout.widget.e.f8919O0, 11);
        f8690f.append(androidx.constraintlayout.widget.e.f8955S0, 15);
        f8690f.append(androidx.constraintlayout.widget.e.f8928P0, 12);
        f8690f.append(androidx.constraintlayout.widget.e.f8856H0, 40);
        f8690f.append(androidx.constraintlayout.widget.e.f9202s0, 39);
        f8690f.append(androidx.constraintlayout.widget.e.f9193r0, 41);
        f8690f.append(androidx.constraintlayout.widget.e.f8847G0, 42);
        f8690f.append(androidx.constraintlayout.widget.e.f9184q0, 20);
        f8690f.append(androidx.constraintlayout.widget.e.f8838F0, 37);
        f8690f.append(androidx.constraintlayout.widget.e.f9087g0, 5);
        f8690f.append(androidx.constraintlayout.widget.e.f9211t0, 82);
        f8690f.append(androidx.constraintlayout.widget.e.f8811C0, 82);
        f8690f.append(androidx.constraintlayout.widget.e.f9238w0, 82);
        f8690f.append(androidx.constraintlayout.widget.e.f9027a0, 82);
        f8690f.append(androidx.constraintlayout.widget.e.f9008Y, 82);
        f8690f.append(androidx.constraintlayout.widget.e.f9246x, 24);
        f8690f.append(androidx.constraintlayout.widget.e.f9264z, 28);
        f8690f.append(androidx.constraintlayout.widget.e.f8891L, 31);
        f8690f.append(androidx.constraintlayout.widget.e.f8900M, 8);
        f8690f.append(androidx.constraintlayout.widget.e.f9255y, 34);
        f8690f.append(androidx.constraintlayout.widget.e.f8792A, 2);
        f8690f.append(androidx.constraintlayout.widget.e.f9228v, 23);
        f8690f.append(androidx.constraintlayout.widget.e.f9237w, 21);
        f8690f.append(androidx.constraintlayout.widget.e.f9219u, 22);
        f8690f.append(androidx.constraintlayout.widget.e.f8801B, 43);
        f8690f.append(androidx.constraintlayout.widget.e.f8918O, 44);
        f8690f.append(androidx.constraintlayout.widget.e.f8873J, 45);
        f8690f.append(androidx.constraintlayout.widget.e.f8882K, 46);
        f8690f.append(androidx.constraintlayout.widget.e.f8864I, 60);
        f8690f.append(androidx.constraintlayout.widget.e.f8846G, 47);
        f8690f.append(androidx.constraintlayout.widget.e.f8855H, 48);
        f8690f.append(androidx.constraintlayout.widget.e.f8810C, 49);
        f8690f.append(androidx.constraintlayout.widget.e.f8819D, 50);
        f8690f.append(androidx.constraintlayout.widget.e.f8828E, 51);
        f8690f.append(androidx.constraintlayout.widget.e.f8837F, 52);
        f8690f.append(androidx.constraintlayout.widget.e.f8909N, 53);
        f8690f.append(androidx.constraintlayout.widget.e.f8865I0, 54);
        f8690f.append(androidx.constraintlayout.widget.e.f9147m0, 55);
        f8690f.append(androidx.constraintlayout.widget.e.f8874J0, 56);
        f8690f.append(androidx.constraintlayout.widget.e.f9157n0, 57);
        f8690f.append(androidx.constraintlayout.widget.e.f8883K0, 58);
        f8690f.append(androidx.constraintlayout.widget.e.f9166o0, 59);
        f8690f.append(androidx.constraintlayout.widget.e.f9057d0, 61);
        f8690f.append(androidx.constraintlayout.widget.e.f9077f0, 62);
        f8690f.append(androidx.constraintlayout.widget.e.f9067e0, 63);
        f8690f.append(androidx.constraintlayout.widget.e.f8927P, 64);
        f8690f.append(androidx.constraintlayout.widget.e.f9000X0, 65);
        f8690f.append(androidx.constraintlayout.widget.e.f8981V, 66);
        f8690f.append(androidx.constraintlayout.widget.e.f9009Y0, 67);
        f8690f.append(androidx.constraintlayout.widget.e.f8982V0, 79);
        f8690f.append(androidx.constraintlayout.widget.e.f9210t, 38);
        f8690f.append(androidx.constraintlayout.widget.e.f8973U0, 68);
        f8690f.append(androidx.constraintlayout.widget.e.f8892L0, 69);
        f8690f.append(androidx.constraintlayout.widget.e.f9175p0, 70);
        f8690f.append(androidx.constraintlayout.widget.e.f8963T, 71);
        f8690f.append(androidx.constraintlayout.widget.e.f8945R, 72);
        f8690f.append(androidx.constraintlayout.widget.e.f8954S, 73);
        f8690f.append(androidx.constraintlayout.widget.e.f8972U, 74);
        f8690f.append(androidx.constraintlayout.widget.e.f8936Q, 75);
        f8690f.append(androidx.constraintlayout.widget.e.f8991W0, 76);
        f8690f.append(androidx.constraintlayout.widget.e.f8802B0, 77);
        f8690f.append(androidx.constraintlayout.widget.e.f9018Z0, 78);
        f8690f.append(androidx.constraintlayout.widget.e.f8999X, 80);
        f8690f.append(androidx.constraintlayout.widget.e.f8990W, 81);
    }

    public static int y(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        if (resourceId == -1) {
            return typedArray.getInt(i10, -1);
        }
        return resourceId;
    }

    public void A(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f8693c && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f8694d.containsKey(Integer.valueOf(id))) {
                this.f8694d.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f8694d.get(Integer.valueOf(id));
            if (!aVar.f8698d.f8730b) {
                aVar.f(id, layoutParams);
                if (childAt instanceof ConstraintHelper) {
                    aVar.f8698d.f8737e0 = ((ConstraintHelper) childAt).getReferencedIds();
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        aVar.f8698d.f8747j0 = barrier.w();
                        aVar.f8698d.f8731b0 = barrier.getType();
                        aVar.f8698d.f8733c0 = barrier.getMargin();
                    }
                }
                aVar.f8698d.f8730b = true;
            }
            d dVar = aVar.f8696b;
            if (!dVar.f8772a) {
                dVar.f8773b = childAt.getVisibility();
                aVar.f8696b.f8775d = childAt.getAlpha();
                aVar.f8696b.f8772a = true;
            }
            e eVar = aVar.f8699e;
            if (!eVar.f8778a) {
                eVar.f8778a = true;
                eVar.f8779b = childAt.getRotation();
                aVar.f8699e.f8780c = childAt.getRotationX();
                aVar.f8699e.f8781d = childAt.getRotationY();
                aVar.f8699e.f8782e = childAt.getScaleX();
                aVar.f8699e.f8783f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar2 = aVar.f8699e;
                    eVar2.f8784g = pivotX;
                    eVar2.f8785h = pivotY;
                }
                aVar.f8699e.f8786i = childAt.getTranslationX();
                aVar.f8699e.f8787j = childAt.getTranslationY();
                aVar.f8699e.f8788k = childAt.getTranslationZ();
                e eVar3 = aVar.f8699e;
                if (eVar3.f8789l) {
                    eVar3.f8790m = childAt.getElevation();
                }
            }
        }
    }

    public void B(b bVar) {
        for (Integer num : bVar.f8694d.keySet()) {
            num.intValue();
            a aVar = bVar.f8694d.get(num);
            if (!this.f8694d.containsKey(num)) {
                this.f8694d.put(num, new a());
            }
            a aVar2 = this.f8694d.get(num);
            C0106b c0106b = aVar2.f8698d;
            if (!c0106b.f8730b) {
                c0106b.a(aVar.f8698d);
            }
            d dVar = aVar2.f8696b;
            if (!dVar.f8772a) {
                dVar.a(aVar.f8696b);
            }
            e eVar = aVar2.f8699e;
            if (!eVar.f8778a) {
                eVar.a(aVar.f8699e);
            }
            c cVar = aVar2.f8697c;
            if (!cVar.f8765a) {
                cVar.a(aVar.f8697c);
            }
            for (String str : aVar.f8700f.keySet()) {
                if (!aVar2.f8700f.containsKey(str)) {
                    aVar2.f8700f.put(str, aVar.f8700f.get(str));
                }
            }
        }
    }

    public void C(boolean z10) {
        this.f8693c = z10;
    }

    public void D(int i10, int i11, int i12) {
        a o10 = o(i10);
        switch (i11) {
            case 1:
                o10.f8698d.f8705D = i12;
                return;
            case 2:
                o10.f8698d.f8706E = i12;
                return;
            case 3:
                o10.f8698d.f8707F = i12;
                return;
            case 4:
                o10.f8698d.f8708G = i12;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                o10.f8698d.f8710I = i12;
                return;
            case 7:
                o10.f8698d.f8709H = i12;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void E(boolean z10) {
        this.f8691a = z10;
    }

    public void F(int i10, int i11) {
        o(i10).f8696b.f8773b = i11;
    }

    public final String G(int i10) {
        switch (i10) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id = childAt.getId();
            if (!this.f8694d.containsKey(Integer.valueOf(id))) {
                Log.v("ConstraintSet", "id unknown " + C1573a.c(childAt));
            } else {
                if (this.f8693c && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.f8694d.containsKey(Integer.valueOf(id))) {
                    ConstraintAttribute.h(childAt, this.f8694d.get(Integer.valueOf(id)).f8700f);
                }
            }
        }
    }

    public void d(ConstraintLayout constraintLayout) {
        f(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void e(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int id = constraintHelper.getId();
        if (this.f8694d.containsKey(Integer.valueOf(id))) {
            a aVar = this.f8694d.get(Integer.valueOf(id));
            if (constraintWidget instanceof C1616b) {
                constraintHelper.o(aVar, (C1616b) constraintWidget, layoutParams, sparseArray);
            }
        }
    }

    public void f(ConstraintLayout constraintLayout, boolean z10) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f8694d.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id = childAt.getId();
            if (!this.f8694d.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + C1573a.c(childAt));
            } else {
                if (this.f8693c && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (this.f8694d.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = this.f8694d.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            aVar.f8698d.f8735d0 = 1;
                        }
                        int i11 = aVar.f8698d.f8735d0;
                        if (i11 != -1 && i11 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(aVar.f8698d.f8731b0);
                            barrier.setMargin(aVar.f8698d.f8733c0);
                            barrier.setAllowsGoneWidget(aVar.f8698d.f8747j0);
                            C0106b c0106b = aVar.f8698d;
                            int[] iArr = c0106b.f8737e0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = c0106b.f8739f0;
                                if (str != null) {
                                    c0106b.f8737e0 = m(barrier, str);
                                    barrier.setReferencedIds(aVar.f8698d.f8737e0);
                                }
                            }
                        }
                        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                        layoutParams.validate();
                        aVar.d(layoutParams);
                        if (z10) {
                            ConstraintAttribute.h(childAt, aVar.f8700f);
                        }
                        childAt.setLayoutParams(layoutParams);
                        d dVar = aVar.f8696b;
                        if (dVar.f8774c == 0) {
                            childAt.setVisibility(dVar.f8773b);
                        }
                        childAt.setAlpha(aVar.f8696b.f8775d);
                        childAt.setRotation(aVar.f8699e.f8779b);
                        childAt.setRotationX(aVar.f8699e.f8780c);
                        childAt.setRotationY(aVar.f8699e.f8781d);
                        childAt.setScaleX(aVar.f8699e.f8782e);
                        childAt.setScaleY(aVar.f8699e.f8783f);
                        if (!Float.isNaN(aVar.f8699e.f8784g)) {
                            childAt.setPivotX(aVar.f8699e.f8784g);
                        }
                        if (!Float.isNaN(aVar.f8699e.f8785h)) {
                            childAt.setPivotY(aVar.f8699e.f8785h);
                        }
                        childAt.setTranslationX(aVar.f8699e.f8786i);
                        childAt.setTranslationY(aVar.f8699e.f8787j);
                        childAt.setTranslationZ(aVar.f8699e.f8788k);
                        e eVar = aVar.f8699e;
                        if (eVar.f8789l) {
                            childAt.setElevation(eVar.f8790m);
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar2 = this.f8694d.get(num);
            int i12 = aVar2.f8698d.f8735d0;
            if (i12 != -1 && i12 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                C0106b c0106b2 = aVar2.f8698d;
                int[] iArr2 = c0106b2.f8737e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = c0106b2.f8739f0;
                    if (str2 != null) {
                        c0106b2.f8737e0 = m(barrier2, str2);
                        barrier2.setReferencedIds(aVar2.f8698d.f8737e0);
                    }
                }
                barrier2.setType(aVar2.f8698d.f8731b0);
                barrier2.setMargin(aVar2.f8698d.f8733c0);
                ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.v();
                aVar2.d(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (aVar2.f8698d.f8728a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                aVar2.d(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void g(int i10, ConstraintLayout.LayoutParams layoutParams) {
        if (this.f8694d.containsKey(Integer.valueOf(i10))) {
            this.f8694d.get(Integer.valueOf(i10)).d(layoutParams);
        }
    }

    public void h(Context context, int i10) {
        i((ConstraintLayout) LayoutInflater.from(context).inflate(i10, (ViewGroup) null));
    }

    public void i(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f8694d.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f8693c && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f8694d.containsKey(Integer.valueOf(id))) {
                this.f8694d.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f8694d.get(Integer.valueOf(id));
            aVar.f8700f = ConstraintAttribute.b(this.f8692b, childAt);
            aVar.f(id, layoutParams);
            aVar.f8696b.f8773b = childAt.getVisibility();
            aVar.f8696b.f8775d = childAt.getAlpha();
            aVar.f8699e.f8779b = childAt.getRotation();
            aVar.f8699e.f8780c = childAt.getRotationX();
            aVar.f8699e.f8781d = childAt.getRotationY();
            aVar.f8699e.f8782e = childAt.getScaleX();
            aVar.f8699e.f8783f = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                e eVar = aVar.f8699e;
                eVar.f8784g = pivotX;
                eVar.f8785h = pivotY;
            }
            aVar.f8699e.f8786i = childAt.getTranslationX();
            aVar.f8699e.f8787j = childAt.getTranslationY();
            aVar.f8699e.f8788k = childAt.getTranslationZ();
            e eVar2 = aVar.f8699e;
            if (eVar2.f8789l) {
                eVar2.f8790m = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                aVar.f8698d.f8747j0 = barrier.w();
                aVar.f8698d.f8737e0 = barrier.getReferencedIds();
                aVar.f8698d.f8731b0 = barrier.getType();
                aVar.f8698d.f8733c0 = barrier.getMargin();
            }
        }
    }

    public void j(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f8694d.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraints.getChildAt(i10);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f8693c && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f8694d.containsKey(Integer.valueOf(id))) {
                this.f8694d.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f8694d.get(Integer.valueOf(id));
            if (childAt instanceof ConstraintHelper) {
                aVar.h((ConstraintHelper) childAt, id, layoutParams);
            }
            aVar.g(id, layoutParams);
        }
    }

    public void k(int i10, int i11, int i12, int i13) {
        if (!this.f8694d.containsKey(Integer.valueOf(i10))) {
            this.f8694d.put(Integer.valueOf(i10), new a());
        }
        a aVar = this.f8694d.get(Integer.valueOf(i10));
        switch (i11) {
            case 1:
                if (i13 == 1) {
                    C0106b c0106b = aVar.f8698d;
                    c0106b.f8742h = i12;
                    c0106b.f8744i = -1;
                    return;
                } else if (i13 == 2) {
                    C0106b c0106b2 = aVar.f8698d;
                    c0106b2.f8744i = i12;
                    c0106b2.f8742h = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + G(i13) + " undefined");
                }
            case 2:
                if (i13 == 1) {
                    C0106b c0106b3 = aVar.f8698d;
                    c0106b3.f8746j = i12;
                    c0106b3.f8748k = -1;
                    return;
                } else if (i13 == 2) {
                    C0106b c0106b4 = aVar.f8698d;
                    c0106b4.f8748k = i12;
                    c0106b4.f8746j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + G(i13) + " undefined");
                }
            case 3:
                if (i13 == 3) {
                    C0106b c0106b5 = aVar.f8698d;
                    c0106b5.f8749l = i12;
                    c0106b5.f8750m = -1;
                    c0106b5.f8753p = -1;
                    return;
                }
                if (i13 == 4) {
                    C0106b c0106b6 = aVar.f8698d;
                    c0106b6.f8750m = i12;
                    c0106b6.f8749l = -1;
                    c0106b6.f8753p = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + G(i13) + " undefined");
            case 4:
                if (i13 == 4) {
                    C0106b c0106b7 = aVar.f8698d;
                    c0106b7.f8752o = i12;
                    c0106b7.f8751n = -1;
                    c0106b7.f8753p = -1;
                    return;
                }
                if (i13 == 3) {
                    C0106b c0106b8 = aVar.f8698d;
                    c0106b8.f8751n = i12;
                    c0106b8.f8752o = -1;
                    c0106b8.f8753p = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + G(i13) + " undefined");
            case 5:
                if (i13 == 5) {
                    C0106b c0106b9 = aVar.f8698d;
                    c0106b9.f8753p = i12;
                    c0106b9.f8752o = -1;
                    c0106b9.f8751n = -1;
                    c0106b9.f8749l = -1;
                    c0106b9.f8750m = -1;
                    return;
                }
                throw new IllegalArgumentException("right to " + G(i13) + " undefined");
            case 6:
                if (i13 == 6) {
                    C0106b c0106b10 = aVar.f8698d;
                    c0106b10.f8755r = i12;
                    c0106b10.f8754q = -1;
                    return;
                } else if (i13 == 7) {
                    C0106b c0106b11 = aVar.f8698d;
                    c0106b11.f8754q = i12;
                    c0106b11.f8755r = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + G(i13) + " undefined");
                }
            case 7:
                if (i13 == 7) {
                    C0106b c0106b12 = aVar.f8698d;
                    c0106b12.f8757t = i12;
                    c0106b12.f8756s = -1;
                    return;
                } else if (i13 == 6) {
                    C0106b c0106b13 = aVar.f8698d;
                    c0106b13.f8756s = i12;
                    c0106b13.f8757t = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + G(i13) + " undefined");
                }
            default:
                throw new IllegalArgumentException(G(i11) + " to " + G(i13) + " unknown");
        }
    }

    public void l(int i10, int i11, int i12, float f10) {
        C0106b c0106b = o(i10).f8698d;
        c0106b.f8761x = i11;
        c0106b.f8762y = i12;
        c0106b.f8763z = f10;
    }

    public final int[] m(View view, String str) {
        int i10;
        Object designInformation;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < split.length) {
            String trim = split[i11].trim();
            try {
                i10 = androidx.constraintlayout.widget.d.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i10 = 0;
            }
            if (i10 == 0) {
                i10 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i10 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i10 = ((Integer) designInformation).intValue();
            }
            iArr[i12] = i10;
            i11++;
            i12++;
        }
        if (i12 != split.length) {
            return Arrays.copyOf(iArr, i12);
        }
        return iArr;
    }

    public final a n(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.e.f9192r);
        z(context, aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    public final a o(int i10) {
        if (!this.f8694d.containsKey(Integer.valueOf(i10))) {
            this.f8694d.put(Integer.valueOf(i10), new a());
        }
        return this.f8694d.get(Integer.valueOf(i10));
    }

    public a p(int i10) {
        if (this.f8694d.containsKey(Integer.valueOf(i10))) {
            return this.f8694d.get(Integer.valueOf(i10));
        }
        return null;
    }

    public int q(int i10) {
        return o(i10).f8698d.f8734d;
    }

    public int[] r() {
        Integer[] numArr = (Integer[]) this.f8694d.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    public a s(int i10) {
        return o(i10);
    }

    public int t(int i10) {
        return o(i10).f8696b.f8773b;
    }

    public int u(int i10) {
        return o(i10).f8696b.f8774c;
    }

    public int v(int i10) {
        return o(i10).f8698d.f8732c;
    }

    public void w(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        a n10 = n(context, Xml.asAttributeSet(xml));
                        if (name.equalsIgnoreCase("Guideline")) {
                            n10.f8698d.f8728a = true;
                        }
                        this.f8694d.put(Integer.valueOf(n10.f8695a), n10);
                    }
                } else {
                    xml.getName();
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x017d, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.b.x(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public final void z(Context context, a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index != androidx.constraintlayout.widget.e.f9210t && androidx.constraintlayout.widget.e.f8891L != index && androidx.constraintlayout.widget.e.f8900M != index) {
                aVar.f8697c.f8765a = true;
                aVar.f8698d.f8730b = true;
                aVar.f8696b.f8772a = true;
                aVar.f8699e.f8778a = true;
            }
            switch (f8690f.get(index)) {
                case 1:
                    C0106b c0106b = aVar.f8698d;
                    c0106b.f8753p = y(typedArray, index, c0106b.f8753p);
                    break;
                case 2:
                    C0106b c0106b2 = aVar.f8698d;
                    c0106b2.f8708G = typedArray.getDimensionPixelSize(index, c0106b2.f8708G);
                    break;
                case 3:
                    C0106b c0106b3 = aVar.f8698d;
                    c0106b3.f8752o = y(typedArray, index, c0106b3.f8752o);
                    break;
                case 4:
                    C0106b c0106b4 = aVar.f8698d;
                    c0106b4.f8751n = y(typedArray, index, c0106b4.f8751n);
                    break;
                case 5:
                    aVar.f8698d.f8760w = typedArray.getString(index);
                    break;
                case 6:
                    C0106b c0106b5 = aVar.f8698d;
                    c0106b5.f8702A = typedArray.getDimensionPixelOffset(index, c0106b5.f8702A);
                    break;
                case 7:
                    C0106b c0106b6 = aVar.f8698d;
                    c0106b6.f8703B = typedArray.getDimensionPixelOffset(index, c0106b6.f8703B);
                    break;
                case 8:
                    C0106b c0106b7 = aVar.f8698d;
                    c0106b7.f8709H = typedArray.getDimensionPixelSize(index, c0106b7.f8709H);
                    break;
                case 9:
                    C0106b c0106b8 = aVar.f8698d;
                    c0106b8.f8757t = y(typedArray, index, c0106b8.f8757t);
                    break;
                case 10:
                    C0106b c0106b9 = aVar.f8698d;
                    c0106b9.f8756s = y(typedArray, index, c0106b9.f8756s);
                    break;
                case 11:
                    C0106b c0106b10 = aVar.f8698d;
                    c0106b10.f8714M = typedArray.getDimensionPixelSize(index, c0106b10.f8714M);
                    break;
                case 12:
                    C0106b c0106b11 = aVar.f8698d;
                    c0106b11.f8715N = typedArray.getDimensionPixelSize(index, c0106b11.f8715N);
                    break;
                case 13:
                    C0106b c0106b12 = aVar.f8698d;
                    c0106b12.f8711J = typedArray.getDimensionPixelSize(index, c0106b12.f8711J);
                    break;
                case 14:
                    C0106b c0106b13 = aVar.f8698d;
                    c0106b13.f8713L = typedArray.getDimensionPixelSize(index, c0106b13.f8713L);
                    break;
                case 15:
                    C0106b c0106b14 = aVar.f8698d;
                    c0106b14.f8716O = typedArray.getDimensionPixelSize(index, c0106b14.f8716O);
                    break;
                case 16:
                    C0106b c0106b15 = aVar.f8698d;
                    c0106b15.f8712K = typedArray.getDimensionPixelSize(index, c0106b15.f8712K);
                    break;
                case 17:
                    C0106b c0106b16 = aVar.f8698d;
                    c0106b16.f8736e = typedArray.getDimensionPixelOffset(index, c0106b16.f8736e);
                    break;
                case 18:
                    C0106b c0106b17 = aVar.f8698d;
                    c0106b17.f8738f = typedArray.getDimensionPixelOffset(index, c0106b17.f8738f);
                    break;
                case 19:
                    C0106b c0106b18 = aVar.f8698d;
                    c0106b18.f8740g = typedArray.getFloat(index, c0106b18.f8740g);
                    break;
                case 20:
                    C0106b c0106b19 = aVar.f8698d;
                    c0106b19.f8758u = typedArray.getFloat(index, c0106b19.f8758u);
                    break;
                case 21:
                    C0106b c0106b20 = aVar.f8698d;
                    c0106b20.f8734d = typedArray.getLayoutDimension(index, c0106b20.f8734d);
                    break;
                case 22:
                    d dVar = aVar.f8696b;
                    dVar.f8773b = typedArray.getInt(index, dVar.f8773b);
                    d dVar2 = aVar.f8696b;
                    dVar2.f8773b = f8689e[dVar2.f8773b];
                    break;
                case 23:
                    C0106b c0106b21 = aVar.f8698d;
                    c0106b21.f8732c = typedArray.getLayoutDimension(index, c0106b21.f8732c);
                    break;
                case 24:
                    C0106b c0106b22 = aVar.f8698d;
                    c0106b22.f8705D = typedArray.getDimensionPixelSize(index, c0106b22.f8705D);
                    break;
                case 25:
                    C0106b c0106b23 = aVar.f8698d;
                    c0106b23.f8742h = y(typedArray, index, c0106b23.f8742h);
                    break;
                case 26:
                    C0106b c0106b24 = aVar.f8698d;
                    c0106b24.f8744i = y(typedArray, index, c0106b24.f8744i);
                    break;
                case 27:
                    C0106b c0106b25 = aVar.f8698d;
                    c0106b25.f8704C = typedArray.getInt(index, c0106b25.f8704C);
                    break;
                case 28:
                    C0106b c0106b26 = aVar.f8698d;
                    c0106b26.f8706E = typedArray.getDimensionPixelSize(index, c0106b26.f8706E);
                    break;
                case 29:
                    C0106b c0106b27 = aVar.f8698d;
                    c0106b27.f8746j = y(typedArray, index, c0106b27.f8746j);
                    break;
                case 30:
                    C0106b c0106b28 = aVar.f8698d;
                    c0106b28.f8748k = y(typedArray, index, c0106b28.f8748k);
                    break;
                case 31:
                    C0106b c0106b29 = aVar.f8698d;
                    c0106b29.f8710I = typedArray.getDimensionPixelSize(index, c0106b29.f8710I);
                    break;
                case 32:
                    C0106b c0106b30 = aVar.f8698d;
                    c0106b30.f8754q = y(typedArray, index, c0106b30.f8754q);
                    break;
                case 33:
                    C0106b c0106b31 = aVar.f8698d;
                    c0106b31.f8755r = y(typedArray, index, c0106b31.f8755r);
                    break;
                case 34:
                    C0106b c0106b32 = aVar.f8698d;
                    c0106b32.f8707F = typedArray.getDimensionPixelSize(index, c0106b32.f8707F);
                    break;
                case 35:
                    C0106b c0106b33 = aVar.f8698d;
                    c0106b33.f8750m = y(typedArray, index, c0106b33.f8750m);
                    break;
                case 36:
                    C0106b c0106b34 = aVar.f8698d;
                    c0106b34.f8749l = y(typedArray, index, c0106b34.f8749l);
                    break;
                case 37:
                    C0106b c0106b35 = aVar.f8698d;
                    c0106b35.f8759v = typedArray.getFloat(index, c0106b35.f8759v);
                    break;
                case 38:
                    aVar.f8695a = typedArray.getResourceId(index, aVar.f8695a);
                    break;
                case 39:
                    C0106b c0106b36 = aVar.f8698d;
                    c0106b36.f8718Q = typedArray.getFloat(index, c0106b36.f8718Q);
                    break;
                case 40:
                    C0106b c0106b37 = aVar.f8698d;
                    c0106b37.f8717P = typedArray.getFloat(index, c0106b37.f8717P);
                    break;
                case 41:
                    C0106b c0106b38 = aVar.f8698d;
                    c0106b38.f8719R = typedArray.getInt(index, c0106b38.f8719R);
                    break;
                case 42:
                    C0106b c0106b39 = aVar.f8698d;
                    c0106b39.f8720S = typedArray.getInt(index, c0106b39.f8720S);
                    break;
                case 43:
                    d dVar3 = aVar.f8696b;
                    dVar3.f8775d = typedArray.getFloat(index, dVar3.f8775d);
                    break;
                case 44:
                    e eVar = aVar.f8699e;
                    eVar.f8789l = true;
                    eVar.f8790m = typedArray.getDimension(index, eVar.f8790m);
                    break;
                case 45:
                    e eVar2 = aVar.f8699e;
                    eVar2.f8780c = typedArray.getFloat(index, eVar2.f8780c);
                    break;
                case 46:
                    e eVar3 = aVar.f8699e;
                    eVar3.f8781d = typedArray.getFloat(index, eVar3.f8781d);
                    break;
                case 47:
                    e eVar4 = aVar.f8699e;
                    eVar4.f8782e = typedArray.getFloat(index, eVar4.f8782e);
                    break;
                case 48:
                    e eVar5 = aVar.f8699e;
                    eVar5.f8783f = typedArray.getFloat(index, eVar5.f8783f);
                    break;
                case 49:
                    e eVar6 = aVar.f8699e;
                    eVar6.f8784g = typedArray.getDimension(index, eVar6.f8784g);
                    break;
                case 50:
                    e eVar7 = aVar.f8699e;
                    eVar7.f8785h = typedArray.getDimension(index, eVar7.f8785h);
                    break;
                case 51:
                    e eVar8 = aVar.f8699e;
                    eVar8.f8786i = typedArray.getDimension(index, eVar8.f8786i);
                    break;
                case 52:
                    e eVar9 = aVar.f8699e;
                    eVar9.f8787j = typedArray.getDimension(index, eVar9.f8787j);
                    break;
                case 53:
                    e eVar10 = aVar.f8699e;
                    eVar10.f8788k = typedArray.getDimension(index, eVar10.f8788k);
                    break;
                case 54:
                    C0106b c0106b40 = aVar.f8698d;
                    c0106b40.f8721T = typedArray.getInt(index, c0106b40.f8721T);
                    break;
                case 55:
                    C0106b c0106b41 = aVar.f8698d;
                    c0106b41.f8722U = typedArray.getInt(index, c0106b41.f8722U);
                    break;
                case 56:
                    C0106b c0106b42 = aVar.f8698d;
                    c0106b42.f8723V = typedArray.getDimensionPixelSize(index, c0106b42.f8723V);
                    break;
                case 57:
                    C0106b c0106b43 = aVar.f8698d;
                    c0106b43.f8724W = typedArray.getDimensionPixelSize(index, c0106b43.f8724W);
                    break;
                case 58:
                    C0106b c0106b44 = aVar.f8698d;
                    c0106b44.f8725X = typedArray.getDimensionPixelSize(index, c0106b44.f8725X);
                    break;
                case 59:
                    C0106b c0106b45 = aVar.f8698d;
                    c0106b45.f8726Y = typedArray.getDimensionPixelSize(index, c0106b45.f8726Y);
                    break;
                case 60:
                    e eVar11 = aVar.f8699e;
                    eVar11.f8779b = typedArray.getFloat(index, eVar11.f8779b);
                    break;
                case 61:
                    C0106b c0106b46 = aVar.f8698d;
                    c0106b46.f8761x = y(typedArray, index, c0106b46.f8761x);
                    break;
                case 62:
                    C0106b c0106b47 = aVar.f8698d;
                    c0106b47.f8762y = typedArray.getDimensionPixelSize(index, c0106b47.f8762y);
                    break;
                case 63:
                    C0106b c0106b48 = aVar.f8698d;
                    c0106b48.f8763z = typedArray.getFloat(index, c0106b48.f8763z);
                    break;
                case 64:
                    c cVar = aVar.f8697c;
                    cVar.f8766b = y(typedArray, index, cVar.f8766b);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        aVar.f8697c.f8767c = typedArray.getString(index);
                        break;
                    } else {
                        aVar.f8697c.f8767c = s.c.f36582c[typedArray.getInteger(index, 0)];
                        break;
                    }
                case 66:
                    aVar.f8697c.f8769e = typedArray.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = aVar.f8697c;
                    cVar2.f8771g = typedArray.getFloat(index, cVar2.f8771g);
                    break;
                case 68:
                    d dVar4 = aVar.f8696b;
                    dVar4.f8776e = typedArray.getFloat(index, dVar4.f8776e);
                    break;
                case 69:
                    aVar.f8698d.f8727Z = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    aVar.f8698d.f8729a0 = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    C0106b c0106b49 = aVar.f8698d;
                    c0106b49.f8731b0 = typedArray.getInt(index, c0106b49.f8731b0);
                    break;
                case 73:
                    C0106b c0106b50 = aVar.f8698d;
                    c0106b50.f8733c0 = typedArray.getDimensionPixelSize(index, c0106b50.f8733c0);
                    break;
                case 74:
                    aVar.f8698d.f8739f0 = typedArray.getString(index);
                    break;
                case 75:
                    C0106b c0106b51 = aVar.f8698d;
                    c0106b51.f8747j0 = typedArray.getBoolean(index, c0106b51.f8747j0);
                    break;
                case 76:
                    c cVar3 = aVar.f8697c;
                    cVar3.f8768d = typedArray.getInt(index, cVar3.f8768d);
                    break;
                case 77:
                    aVar.f8698d.f8741g0 = typedArray.getString(index);
                    break;
                case 78:
                    d dVar5 = aVar.f8696b;
                    dVar5.f8774c = typedArray.getInt(index, dVar5.f8774c);
                    break;
                case 79:
                    c cVar4 = aVar.f8697c;
                    cVar4.f8770f = typedArray.getFloat(index, cVar4.f8770f);
                    break;
                case 80:
                    C0106b c0106b52 = aVar.f8698d;
                    c0106b52.f8743h0 = typedArray.getBoolean(index, c0106b52.f8743h0);
                    break;
                case 81:
                    C0106b c0106b53 = aVar.f8698d;
                    c0106b53.f8745i0 = typedArray.getBoolean(index, c0106b53.f8745i0);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f8690f.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f8690f.get(index));
                    break;
            }
        }
    }
}
