package com.customize.contacts.util;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: LongPressHelper.java */
/* loaded from: classes3.dex */
public class M {

    /* renamed from: a, reason: collision with root package name */
    public final View f21913a;

    /* renamed from: b, reason: collision with root package name */
    public final e f21914b;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f21916d;

    /* renamed from: c, reason: collision with root package name */
    public final float[] f21915c = new float[2];

    /* renamed from: e, reason: collision with root package name */
    public final View.OnTouchListener f21917e = new a();

    /* renamed from: f, reason: collision with root package name */
    public final View.OnLongClickListener f21918f = new b();

    /* renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f21919g = new c();

    /* compiled from: LongPressHelper.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (M.this.f21916d) {
                return false;
            }
            if (motionEvent.getActionMasked() == 0) {
                M.this.f21915c[0] = motionEvent.getX();
                M.this.f21915c[1] = motionEvent.getY();
            }
            M.this.f21914b.onTouch(view, motionEvent);
            return false;
        }
    }

    /* compiled from: LongPressHelper.java */
    /* loaded from: classes3.dex */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (M.this.f21916d) {
                return false;
            }
            M.this.f21914b.onLongClick(view, (int) M.this.f21915c[0], (int) M.this.f21915c[1]);
            return true;
        }
    }

    /* compiled from: LongPressHelper.java */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            M.this.f21914b.onClick(view);
        }
    }

    /* compiled from: LongPressHelper.java */
    /* loaded from: classes3.dex */
    public interface d {
        void G0(View view, int i10, int i11);

        boolean V0(View view, MotionEvent motionEvent);

        void c0(View view, int i10, int i11, int i12, int i13);
    }

    /* compiled from: LongPressHelper.java */
    /* loaded from: classes3.dex */
    public interface e {
        void onClick(View view);

        void onLongClick(View view, int i10, int i11);

        boolean onTouch(View view, MotionEvent motionEvent);
    }

    public M(View view, e eVar, boolean z10) {
        this.f21913a = view;
        this.f21914b = eVar;
        this.f21916d = z10;
    }

    public static void d(View view, boolean z10, e eVar) {
        new M(view, eVar, z10).e();
    }

    public final void e() {
        this.f21913a.setOnTouchListener(this.f21917e);
        this.f21913a.setOnLongClickListener(this.f21918f);
        this.f21913a.setOnClickListener(this.f21919g);
    }
}
