package com.oplus.blacklistapp.callintercept.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.coui.appcompat.picker.COUITimeLimitPicker;
import com.oplus.utils.C0846g;

/* loaded from: classes3.dex */
public class LocalTimePicker extends COUITimeLimitPicker {

    /* renamed from: a, reason: collision with root package name */
    public int f26967a;

    /* renamed from: b, reason: collision with root package name */
    public int f26968b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f26969c;

    /* renamed from: d, reason: collision with root package name */
    public c f26970d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f26971e;

    /* renamed from: f, reason: collision with root package name */
    public Handler f26972f;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1 && LocalTimePicker.this.f26970d != null && !LocalTimePicker.this.h()) {
                if (C0846g.c()) {
                    Log.d("LocalTimePicker", "onTimeChangeEnd_msg.arg1 = " + message.arg1 + ", msg.arg2 = " + message.arg2);
                }
                LocalTimePicker.this.f26970d.a((LocalTimePicker) message.obj, message.arg1, message.arg2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements COUITimeLimitPicker.OnTimeChangedListener {
        public b() {
        }

        @Override // com.coui.appcompat.picker.COUITimeLimitPicker.OnTimeChangedListener
        public void onTimeChanged(COUITimeLimitPicker cOUITimeLimitPicker, int i10, int i11) {
            if (LocalTimePicker.this.f26967a == i10 && LocalTimePicker.this.f26968b == i11) {
                if (LocalTimePicker.this.h()) {
                    LocalTimePicker.this.f26972f.removeMessages(1);
                }
                if (C0846g.c()) {
                    Log.d("LocalTimePicker", "no change, only return!");
                    return;
                }
                return;
            }
            if (LocalTimePicker.this.f26971e) {
                if (LocalTimePicker.this.h()) {
                    LocalTimePicker.this.f26972f.removeMessages(1);
                }
                Message obtain = Message.obtain(LocalTimePicker.this.f26972f, 1, cOUITimeLimitPicker);
                obtain.arg1 = i10;
                obtain.arg2 = i11;
                LocalTimePicker.this.f26972f.sendMessageDelayed(obtain, 150L);
            }
            LocalTimePicker.this.f26967a = i10;
            LocalTimePicker.this.f26968b = i11;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(LocalTimePicker localTimePicker, int i10, int i11);
    }

    public LocalTimePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26967a = -1;
        this.f26968b = -1;
        this.f26972f = new a();
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L39
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L39
            r3 = 3
            if (r0 == r3) goto L16
            r3 = 4
            if (r0 == r3) goto L16
            r5.f26971e = r1
            goto L46
        L16:
            r5.f26971e = r2
            boolean r0 = r5.h()
            if (r0 == 0) goto L23
            android.os.Handler r0 = r5.f26972f
            r0.removeMessages(r2)
        L23:
            android.os.Handler r0 = r5.f26972f
            android.os.Message r0 = android.os.Message.obtain(r0, r2, r5)
            int r1 = r5.f26967a
            r0.arg1 = r1
            int r1 = r5.f26968b
            r0.arg2 = r1
            android.os.Handler r1 = r5.f26972f
            r3 = 150(0x96, double:7.4E-322)
            r1.sendMessageDelayed(r0, r3)
            goto L46
        L39:
            r5.f26971e = r1
            boolean r0 = r5.h()
            if (r0 == 0) goto L46
            android.os.Handler r0 = r5.f26972f
            r0.removeMessages(r2)
        L46:
            android.view.ViewParent r0 = r5.getParent()
            if (r0 == 0) goto L4f
            r0.requestDisallowInterceptTouchEvent(r2)
        L4f:
            boolean r5 = super.dispatchTouchEvent(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.blacklistapp.callintercept.widget.LocalTimePicker.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean h() {
        Handler handler = this.f26972f;
        if (handler != null && handler.hasMessages(1)) {
            if (C0846g.c()) {
                Log.d("LocalTimePicker", "hasTimeSetMessage");
            }
            return true;
        }
        return false;
    }

    public final void i() {
        this.f26971e = false;
        setOnTimeChangedListener(new b());
    }

    public boolean j() {
        return this.f26969c;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setExpanded(boolean z10) {
        this.f26969c = z10;
    }

    public void setOnTimeChangeEndListener(c cVar) {
        this.f26970d = cVar;
    }
}
