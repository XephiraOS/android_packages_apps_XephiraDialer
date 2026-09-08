package com.oplus.blacklistapp.callintercept.widget;

import V6.j;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.l;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.picker.COUITimeLimitPicker;
import com.oplus.blacklistapp.callintercept.widget.LocalTimePicker;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import com.oplus.blacklistapp.u;
import com.oplus.utils.C0846g;
import java.util.ArrayList;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class ScheduleTimePreference extends Preference implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public View f26975a;

    /* renamed from: b, reason: collision with root package name */
    public View f26976b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f26977c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f26978d;

    /* renamed from: e, reason: collision with root package name */
    public LocalTimePicker f26979e;

    /* renamed from: f, reason: collision with root package name */
    public LocalTimePicker f26980f;

    /* renamed from: g, reason: collision with root package name */
    public int f26981g;

    /* renamed from: h, reason: collision with root package name */
    public int f26982h;

    /* renamed from: i, reason: collision with root package name */
    public int f26983i;

    /* renamed from: j, reason: collision with root package name */
    public int f26984j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f26985k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f26986l;

    /* renamed from: m, reason: collision with root package name */
    public h f26987m;

    /* renamed from: n, reason: collision with root package name */
    public Context f26988n;

    /* renamed from: o, reason: collision with root package name */
    public j.a f26989o;

    /* renamed from: p, reason: collision with root package name */
    public Handler f26990p;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                ScheduleTimePreference.this.u((LocalTimePicker) message.obj);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements LocalTimePicker.c {
        public b() {
        }

        @Override // com.oplus.blacklistapp.callintercept.widget.LocalTimePicker.c
        public void a(LocalTimePicker localTimePicker, int i10, int i11) {
            if (C0846g.c()) {
                Log.d("ScheduleTimePreference", "mOpenTimePicker_onTimeChangeEnd_hour = " + i10 + ", minute = " + i11);
            }
            ScheduleTimePreference.this.f26981g = i10;
            ScheduleTimePreference.this.f26982h = i11;
            ScheduleTimePreference.this.r(localTimePicker);
            if (ScheduleTimePreference.this.f26987m != null) {
                ScheduleTimePreference.this.f26987m.a(ScheduleTimePreference.this.f26981g, ScheduleTimePreference.this.f26982h);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements LocalTimePicker.c {
        public c() {
        }

        @Override // com.oplus.blacklistapp.callintercept.widget.LocalTimePicker.c
        public void a(LocalTimePicker localTimePicker, int i10, int i11) {
            if (C0846g.c()) {
                Log.d("ScheduleTimePreference", "mCloseTimePicker_onTimeChangeEnd_hour = " + i10 + ", minute = " + i11);
            }
            ScheduleTimePreference.this.f26983i = i10;
            ScheduleTimePreference.this.f26984j = i11;
            ScheduleTimePreference.this.r(localTimePicker);
            if (ScheduleTimePreference.this.f26987m != null) {
                ScheduleTimePreference.this.f26987m.b(ScheduleTimePreference.this.f26983i, ScheduleTimePreference.this.f26984j);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public ViewGroup.LayoutParams f26996a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LocalTimePicker f26997b;

        public e(LocalTimePicker localTimePicker) {
            this.f26997b = localTimePicker;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator != null && valueAnimator.getAnimatedValue() != null) {
                ViewGroup.LayoutParams layoutParams = this.f26997b.getLayoutParams();
                this.f26996a = layoutParams;
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.f26997b.setLayoutParams(this.f26996a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public ViewGroup.LayoutParams f27001a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LocalTimePicker f27002b;

        public g(LocalTimePicker localTimePicker) {
            this.f27002b = localTimePicker;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f27001a = this.f27002b.getLayoutParams();
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                this.f27001a.height = ((Integer) animatedValue).intValue();
                this.f27002b.setLayoutParams(this.f27001a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(int i10, int i11);

        void b(int i10, int i11);
    }

    public ScheduleTimePreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f26985k = false;
        this.f26986l = false;
        this.f26990p = new a();
        this.f26988n = context;
        setLayoutResource(r.f27443O);
    }

    private void q(l lVar) {
        int i10;
        COUICardListHelper.setItemCardBackground(lVar.itemView, 2);
        this.f26975a = (RelativeLayout) lVar.e(p.f27405o0);
        this.f26976b = (RelativeLayout) lVar.e(p.f27410r);
        this.f26975a.setOnClickListener(this);
        this.f26976b.setOnClickListener(this);
        this.f26977c = (TextView) lVar.e(p.f27401m0);
        this.f26978d = (TextView) lVar.e(p.f27406p);
        this.f26979e = (LocalTimePicker) lVar.e(p.f27403n0);
        this.f26980f = (LocalTimePicker) lVar.e(p.f27408q);
        boolean is24HourFormat = DateFormat.is24HourFormat(getContext());
        this.f26979e.setIs24HourView(Boolean.valueOf(is24HourFormat));
        this.f26980f.setIs24HourView(Boolean.valueOf(is24HourFormat));
        LocalTimePicker localTimePicker = this.f26979e;
        int i11 = 8;
        if (this.f26985k) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        localTimePicker.setVisibility(i10);
        this.f26979e.setExpanded(this.f26985k);
        this.f26979e.setTextVisibility(false);
        this.f26979e.setCurrentHour(Integer.valueOf(this.f26981g));
        this.f26979e.setCurrentMinute(Integer.valueOf(this.f26982h));
        this.f26979e.setOnTimeChangeEndListener(new b());
        LocalTimePicker localTimePicker2 = this.f26980f;
        if (this.f26986l) {
            i11 = 0;
        }
        localTimePicker2.setVisibility(i11);
        this.f26980f.setExpanded(this.f26986l);
        this.f26980f.setTextVisibility(false);
        this.f26980f.setCurrentHour(Integer.valueOf(this.f26983i));
        this.f26980f.setCurrentMinute(Integer.valueOf(this.f26984j));
        this.f26980f.setOnTimeChangeEndListener(new c());
        t(this.f26989o);
    }

    public final void m(boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z10) {
            if (this.f26979e.j()) {
                arrayList.add(n(this.f26979e));
            } else {
                if (this.f26980f.j()) {
                    arrayList.add(n(this.f26980f));
                }
                arrayList.add(o(this.f26979e));
            }
        } else if (this.f26980f.j()) {
            arrayList.add(n(this.f26980f));
        } else {
            if (this.f26979e.j()) {
                arrayList.add(n(this.f26979e));
            }
            arrayList.add(o(this.f26980f));
        }
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200L);
        animatorSet.start();
    }

    public final Animator n(LocalTimePicker localTimePicker) {
        View findViewById = localTimePicker.findViewById(a9.f.f6624N);
        localTimePicker.measure(View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        ObjectAnimator ofInt = ObjectAnimator.ofInt(localTimePicker, "height", findViewById.getMeasuredHeight(), 0);
        ofInt.addListener(new d(localTimePicker));
        ofInt.addUpdateListener(new e(localTimePicker));
        return ofInt;
    }

    public final Animator o(LocalTimePicker localTimePicker) {
        View findViewById = localTimePicker.findViewById(a9.f.f6624N);
        localTimePicker.measure(View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        ObjectAnimator ofInt = ObjectAnimator.ofInt(localTimePicker, "height", 0, findViewById.getMeasuredHeight());
        ofInt.addListener(new f(localTimePicker));
        ofInt.addUpdateListener(new g(localTimePicker));
        return ofInt;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        q(lVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == p.f27405o0) {
            if (this.f26979e.getVisibility() != 0) {
                this.f26979e.setVisibility(0);
                this.f26985k = true;
                this.f26986l = false;
            } else {
                this.f26985k = false;
            }
            m(true);
            return;
        }
        if (id == p.f27410r) {
            if (this.f26980f.getVisibility() != 0) {
                this.f26980f.setVisibility(0);
                this.f26985k = false;
                this.f26986l = true;
            } else {
                this.f26986l = false;
            }
            m(false);
        }
    }

    public final String p(LocalTimePicker localTimePicker) {
        int i10;
        String string;
        if (localTimePicker == this.f26979e) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, this.f26981g);
            calendar.set(12, this.f26982h);
            string = DateFormat.getTimeFormat(this.f26988n).format(calendar.getTime());
        } else {
            if ((this.f26981g * 60) + this.f26982h >= (this.f26983i * 60) + this.f26984j) {
                i10 = u.f27709w3;
            } else {
                i10 = 0;
            }
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(11, this.f26983i);
            calendar2.set(12, this.f26984j);
            String format = DateFormat.getTimeFormat(this.f26988n).format(calendar2.getTime());
            if (i10 != 0) {
                try {
                    string = this.f26988n.getResources().getString(i10, format);
                } catch (Exception e10) {
                    Log.w("ScheduleTimePreference", "getTimeStr_error = " + e10);
                }
            }
            string = format;
        }
        if (C0846g.c()) {
            Log.d("ScheduleTimePreference", "getTimeStr_tempTimeStr = " + string);
        }
        return string;
    }

    public final void r(COUITimeLimitPicker cOUITimeLimitPicker) {
        if (this.f26990p.hasMessages(100)) {
            this.f26990p.removeMessages(100);
        }
        this.f26990p.sendMessageDelayed(Message.obtain(this.f26990p, 100, cOUITimeLimitPicker), 0L);
    }

    public void s(h hVar) {
        this.f26987m = hVar;
    }

    public void t(j.a aVar) {
        TextView textView;
        this.f26989o = aVar;
        if (C0846g.c()) {
            Log.d("ScheduleTimePreference", "initUI_mStartHour = " + this.f26981g + ", mStartMinute = " + this.f26982h + ", mEndHour = " + this.f26983i + ", mEndMinute = " + this.f26984j + " mSchedule = " + this.f26989o);
        }
        if (aVar != null && (textView = this.f26977c) != null && this.f26978d != null) {
            if (this.f26981g != aVar.f4087b || this.f26982h != aVar.f4088c || textView.getText().toString().isEmpty()) {
                int i10 = aVar.f4087b;
                this.f26981g = i10;
                this.f26982h = aVar.f4088c;
                this.f26979e.setCurrentHour(Integer.valueOf(i10));
                this.f26979e.setCurrentMinute(Integer.valueOf(this.f26982h));
                this.f26977c.setForceDarkAllowed(false);
                this.f26977c.setText(p(this.f26979e));
            }
            if (this.f26983i != aVar.f4089d || this.f26984j != aVar.f4090e || this.f26978d.getText().toString().isEmpty()) {
                int i11 = aVar.f4089d;
                this.f26983i = i11;
                this.f26984j = aVar.f4090e;
                this.f26980f.setCurrentHour(Integer.valueOf(i11));
                this.f26980f.setCurrentMinute(Integer.valueOf(this.f26984j));
                this.f26978d.setForceDarkAllowed(false);
                this.f26978d.setText(p(this.f26980f));
            }
        }
    }

    public final void u(LocalTimePicker localTimePicker) {
        if (localTimePicker == null) {
            return;
        }
        LocalTimePicker localTimePicker2 = this.f26979e;
        if (localTimePicker == localTimePicker2) {
            localTimePicker2.setCurrentHour(Integer.valueOf(this.f26981g));
            this.f26979e.setCurrentMinute(Integer.valueOf(this.f26982h));
            this.f26977c.setText(p(this.f26979e));
        }
        this.f26980f.setCurrentHour(Integer.valueOf(this.f26983i));
        this.f26980f.setCurrentMinute(Integer.valueOf(this.f26984j));
        this.f26978d.setText(p(this.f26980f));
    }

    public ScheduleTimePreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ScheduleTimePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* loaded from: classes3.dex */
    public class d implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalTimePicker f26994a;

        public d(LocalTimePicker localTimePicker) {
            this.f26994a = localTimePicker;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f26994a.setExpanded(false);
            this.f26994a.setVisibility(8);
            LocalTimePicker unused = ScheduleTimePreference.this.f26979e;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalTimePicker f26999a;

        public f(LocalTimePicker localTimePicker) {
            this.f26999a = localTimePicker;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            LocalTimePicker unused = ScheduleTimePreference.this.f26979e;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f26999a.setExpanded(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
