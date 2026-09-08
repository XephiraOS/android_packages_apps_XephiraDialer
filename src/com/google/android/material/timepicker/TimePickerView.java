package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import e4.g;
import e4.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class TimePickerView extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    public final Chip f24235a;

    /* renamed from: b, reason: collision with root package name */
    public final Chip f24236b;

    /* renamed from: c, reason: collision with root package name */
    public final ClockHandView f24237c;

    /* renamed from: d, reason: collision with root package name */
    public final ClockFaceView f24238d;

    /* renamed from: e, reason: collision with root package name */
    public final MaterialButtonToggleGroup f24239e;

    /* renamed from: f, reason: collision with root package name */
    public final View.OnClickListener f24240f;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView.h(TimePickerView.this);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            TimePickerView.i(TimePickerView.this);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureDetector f24243a;

        public c(GestureDetector gestureDetector) {
            this.f24243a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f24243a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
    }

    /* loaded from: classes3.dex */
    public interface e {
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static /* synthetic */ e h(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    public static /* synthetic */ d i(TimePickerView timePickerView) {
        timePickerView.getClass();
        return null;
    }

    public final void k() {
        Chip chip = this.f24235a;
        int i10 = g.f30881i0;
        chip.setTag(i10, 12);
        this.f24236b.setTag(i10, 10);
        this.f24235a.setOnClickListener(this.f24240f);
        this.f24236b.setOnClickListener(this.f24240f);
        this.f24235a.setAccessibilityClassName("android.view.View");
        this.f24236b.setAccessibilityClassName("android.view.View");
    }

    public final void l() {
        c cVar = new c(new GestureDetector(getContext(), new b()));
        this.f24235a.setOnTouchListener(cVar);
        this.f24236b.setOnTouchListener(cVar);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this && i10 == 0) {
            this.f24236b.sendAccessibilityEvent(8);
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f24240f = new a();
        LayoutInflater.from(context).inflate(i.f30938r, this);
        this.f24238d = (ClockFaceView) findViewById(g.f30884k);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(g.f30890n);
        this.f24239e = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new MaterialButtonToggleGroup.d() { // from class: com.google.android.material.timepicker.d
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i11, boolean z10) {
                TimePickerView.this.j(materialButtonToggleGroup2, i11, z10);
            }
        });
        this.f24235a = (Chip) findViewById(g.f30896q);
        this.f24236b = (Chip) findViewById(g.f30892o);
        this.f24237c = (ClockHandView) findViewById(g.f30886l);
        l();
        k();
    }

    public final /* synthetic */ void j(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10) {
    }
}
