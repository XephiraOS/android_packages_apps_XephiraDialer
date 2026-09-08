package com.android.incallui.oplus.answerview.view;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.android.internal.annotations.VisibleForTesting;

/* compiled from: SwipeAnswerImageViewHelper.kt */
/* loaded from: classes.dex */
public final class j implements View.OnTouchListener {

    /* renamed from: l, reason: collision with root package name */
    public static final a f18835l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public float f18836a;

    /* renamed from: b, reason: collision with root package name */
    public b f18837b;

    /* renamed from: c, reason: collision with root package name */
    public float f18838c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f18839d;

    /* renamed from: e, reason: collision with root package name */
    public final b f18840e;

    /* renamed from: f, reason: collision with root package name */
    public final b f18841f;

    /* renamed from: g, reason: collision with root package name */
    public final b f18842g;

    /* renamed from: h, reason: collision with root package name */
    public final b f18843h;

    /* renamed from: i, reason: collision with root package name */
    public float f18844i;

    /* renamed from: j, reason: collision with root package name */
    public float f18845j;

    /* renamed from: k, reason: collision with root package name */
    public c f18846k;

    /* compiled from: SwipeAnswerImageViewHelper.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final void a(j helper, View swipeButton, c listener) {
            kotlin.jvm.internal.i.f(helper, "helper");
            kotlin.jvm.internal.i.f(swipeButton, "swipeButton");
            kotlin.jvm.internal.i.f(listener, "listener");
            helper.f18846k = listener;
            swipeButton.setOnTouchListener(helper);
        }

        public final void b(View swipeButton, j helper) {
            kotlin.jvm.internal.i.f(swipeButton, "swipeButton");
            kotlin.jvm.internal.i.f(helper, "helper");
            swipeButton.setOnTouchListener(null);
            helper.f18846k = null;
        }

        public final j c() {
            return new j(null);
        }

        public final void d(j helper, float f10, float f11) {
            kotlin.jvm.internal.i.f(helper, "helper");
            helper.f18844i = f10;
            helper.f18845j = f11;
        }

        public final float e(float f10, float f11) {
            return h2.b.f32052a.a(Math.abs(f10 / f11), 0.0f, 1.0f);
        }

        public final void f(j helper) {
            kotlin.jvm.internal.i.f(helper, "helper");
            helper.q(helper.f18840e);
        }

        public final void g(j helper, boolean z10) {
            kotlin.jvm.internal.i.f(helper, "helper");
            helper.o(z10);
        }

        public final void h(j helper) {
            kotlin.jvm.internal.i.f(helper, "helper");
            helper.q(helper.f18843h);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SwipeAnswerImageViewHelper.kt */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b(View view, int i10);

        void d();

        void e(float f10);

        void f();
    }

    /* compiled from: SwipeAnswerImageViewHelper.kt */
    /* loaded from: classes.dex */
    public static final class d implements b {

        /* renamed from: a, reason: collision with root package name */
        public final String f18847a = "ActiveState";

        public d() {
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public void a() {
            b.a.b(this);
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public String b() {
            return this.f18847a;
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public void c() {
            b.a.a(this);
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        
            if (r1 != 3) goto L19;
         */
        @Override // com.android.incallui.oplus.answerview.view.j.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean d(android.view.View r5, android.view.MotionEvent r6) {
            /*
                r4 = this;
                java.lang.String r0 = "view"
                kotlin.jvm.internal.i.f(r5, r0)
                java.lang.String r0 = "event"
                kotlin.jvm.internal.i.f(r6, r0)
                float r0 = r6.getRawY()
                com.android.incallui.oplus.answerview.view.j r1 = com.android.incallui.oplus.answerview.view.j.this
                float r1 = com.android.incallui.oplus.answerview.view.j.b(r1)
                float r0 = r0 - r1
                int r1 = r6.getActionMasked()
                r2 = 1
                if (r1 == 0) goto L30
                if (r1 == r2) goto L26
                r3 = 2
                if (r1 == r3) goto L30
                r5 = 3
                if (r1 == r5) goto L26
                goto L56
            L26:
                com.android.incallui.oplus.answerview.view.j r4 = com.android.incallui.oplus.answerview.view.j.this
                com.android.incallui.oplus.answerview.view.j$b r5 = com.android.incallui.oplus.answerview.view.j.d(r4)
                r4.q(r5)
                goto L56
            L30:
                r1 = 0
                int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r3 < 0) goto L37
                r0 = r1
                goto L51
            L37:
                com.android.incallui.oplus.answerview.view.j r1 = com.android.incallui.oplus.answerview.view.j.this
                float r1 = com.android.incallui.oplus.answerview.view.j.g(r1)
                float r1 = -r1
                int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r1 >= 0) goto L51
                com.android.incallui.oplus.answerview.view.j r4 = com.android.incallui.oplus.answerview.view.j.this
                com.android.incallui.oplus.answerview.view.j$b r0 = r4.m()
                com.android.incallui.oplus.answerview.view.j$b r4 = r4.q(r0)
                boolean r4 = r4.d(r5, r6)
                return r4
            L51:
                com.android.incallui.oplus.answerview.view.j r4 = com.android.incallui.oplus.answerview.view.j.this
                com.android.incallui.oplus.answerview.view.j.l(r4, r5, r0)
            L56:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.oplus.answerview.view.j.d.d(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* compiled from: SwipeAnswerImageViewHelper.kt */
    /* loaded from: classes.dex */
    public static final class e implements b {

        /* renamed from: a, reason: collision with root package name */
        public final String f18849a = "CurrentState";

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public void a() {
            b.a.b(this);
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public String b() {
            return this.f18849a;
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public void c() {
            b.a.a(this);
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public boolean d(View view, MotionEvent motionEvent) {
            return b.a.c(this, view, motionEvent);
        }
    }

    /* compiled from: SwipeAnswerImageViewHelper.kt */
    /* loaded from: classes.dex */
    public static final class f implements b {

        /* renamed from: a, reason: collision with root package name */
        public final String f18850a = "FinishState";

        public f() {
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public void a() {
            b.a.b(this);
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public String b() {
            return this.f18850a;
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public void c() {
            c cVar = j.this.f18846k;
            if (cVar != null) {
                cVar.d();
            }
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public boolean d(View view, MotionEvent event) {
            kotlin.jvm.internal.i.f(view, "view");
            kotlin.jvm.internal.i.f(event, "event");
            c cVar = j.this.f18846k;
            if (cVar != null) {
                cVar.b(view, event.getDeviceId());
                return true;
            }
            return true;
        }
    }

    /* compiled from: SwipeAnswerImageViewHelper.kt */
    /* loaded from: classes.dex */
    public static final class g implements b {

        /* renamed from: a, reason: collision with root package name */
        public final String f18852a = "IdleState";

        public g() {
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public void a() {
            c cVar = j.this.f18846k;
            if (cVar != null) {
                cVar.f();
            }
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public String b() {
            return this.f18852a;
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public void c() {
            c cVar = j.this.f18846k;
            if (cVar != null) {
                cVar.d();
            }
            c cVar2 = j.this.f18846k;
            if (cVar2 != null) {
                cVar2.a();
            }
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public boolean d(View view, MotionEvent event) {
            kotlin.jvm.internal.i.f(view, "view");
            kotlin.jvm.internal.i.f(event, "event");
            if (event.getActionMasked() == 0) {
                j.this.f18838c = event.getRawY();
                j jVar = j.this;
                return jVar.q(jVar.f18841f).d(view, event);
            }
            return true;
        }
    }

    /* compiled from: SwipeAnswerImageViewHelper.kt */
    /* loaded from: classes.dex */
    public static final class h implements b {

        /* renamed from: a, reason: collision with root package name */
        public final String f18854a = "TriggerState";

        public h() {
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public void a() {
            b.a.b(this);
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public String b() {
            return this.f18854a;
        }

        @Override // com.android.incallui.oplus.answerview.view.j.b
        public void c() {
            b.a.a(this);
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        
            if (r1 != 3) goto L32;
         */
        @Override // com.android.incallui.oplus.answerview.view.j.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean d(android.view.View r7, android.view.MotionEvent r8) {
            /*
                r6 = this;
                java.lang.String r0 = "view"
                kotlin.jvm.internal.i.f(r7, r0)
                java.lang.String r0 = "event"
                kotlin.jvm.internal.i.f(r8, r0)
                float r0 = r8.getRawY()
                com.android.incallui.oplus.answerview.view.j r1 = com.android.incallui.oplus.answerview.view.j.this
                float r1 = com.android.incallui.oplus.answerview.view.j.b(r1)
                float r0 = r0 - r1
                int r1 = r8.getActionMasked()
                r2 = 1
                if (r1 == 0) goto L78
                if (r1 == r2) goto L27
                r3 = 2
                if (r1 == r3) goto L78
                r0 = 3
                if (r1 == r0) goto L27
                goto La9
            L27:
                com.android.incallui.CallList r0 = com.android.incallui.CallList.getInstance()
                java.lang.String r1 = "null cannot be cast to non-null type com.android.incallui.OplusCallList"
                kotlin.jvm.internal.i.d(r0, r1)
                com.android.incallui.OplusCallList r0 = (com.android.incallui.OplusCallList) r0
                int r1 = r7.getId()
                int r3 = com.android.incallui.R.id.voice_ans_view
                if (r1 == r3) goto L42
                int r1 = r7.getId()
                int r3 = com.android.incallui.R.id.video_ans_view
                if (r1 != r3) goto L69
            L42:
                android.content.Context r1 = com.android.incallui.OplusInCallApp.getAppContext()
                int r3 = r8.getDeviceId()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                int r4 = r7.getId()
                int r5 = com.android.incallui.R.id.video_ans_view
                if (r4 != r5) goto L58
                r4 = r2
                goto L59
            L58:
                r4 = 0
            L59:
                boolean r0 = com.android.incallui.OplusPhoneUtils.isShowPrivacyToast(r1, r3, r0, r4)
                if (r0 == 0) goto L69
                com.android.incallui.oplus.answerview.view.j r6 = com.android.incallui.oplus.answerview.view.j.this
                com.android.incallui.oplus.answerview.view.j$b r7 = com.android.incallui.oplus.answerview.view.j.d(r6)
                r6.q(r7)
                return r2
            L69:
                com.android.incallui.oplus.answerview.view.j r6 = com.android.incallui.oplus.answerview.view.j.this
                com.android.incallui.oplus.answerview.view.j$b r0 = com.android.incallui.oplus.answerview.view.j.c(r6)
                com.android.incallui.oplus.answerview.view.j$b r6 = r6.q(r0)
                boolean r6 = r6.d(r7, r8)
                return r6
            L78:
                com.android.incallui.oplus.answerview.view.j r1 = com.android.incallui.oplus.answerview.view.j.this
                float r1 = com.android.incallui.oplus.answerview.view.j.g(r1)
                float r1 = -r1
                int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r1 <= 0) goto L92
                com.android.incallui.oplus.answerview.view.j r6 = com.android.incallui.oplus.answerview.view.j.this
                com.android.incallui.oplus.answerview.view.j$b r0 = com.android.incallui.oplus.answerview.view.j.a(r6)
                com.android.incallui.oplus.answerview.view.j$b r6 = r6.q(r0)
                boolean r6 = r6.d(r7, r8)
                return r6
            L92:
                com.android.incallui.oplus.answerview.view.j r8 = com.android.incallui.oplus.answerview.view.j.this
                float r8 = com.android.incallui.oplus.answerview.view.j.e(r8)
                float r8 = -r8
                int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r8 >= 0) goto La4
                com.android.incallui.oplus.answerview.view.j r8 = com.android.incallui.oplus.answerview.view.j.this
                float r8 = com.android.incallui.oplus.answerview.view.j.e(r8)
                float r0 = -r8
            La4:
                com.android.incallui.oplus.answerview.view.j r6 = com.android.incallui.oplus.answerview.view.j.this
                com.android.incallui.oplus.answerview.view.j.l(r6, r7, r0)
            La9:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.oplus.answerview.view.j.h.d(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public /* synthetic */ j(kotlin.jvm.internal.f fVar) {
        this();
    }

    public final b m() {
        return this.f18842g;
    }

    public final void n(float f10) {
        if (this.f18836a != f10) {
            this.f18836a = f10;
            c cVar = this.f18846k;
            if (cVar != null) {
                cVar.e(f10);
            }
        }
    }

    public final void o(boolean z10) {
        this.f18839d = z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r2 != 3) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = "SwipeAnswerImageViewHelper"
            if (r6 == 0) goto L77
            if (r7 != 0) goto L8
            goto L77
        L8:
            int r2 = r7.getAction()
            r3 = 1
            if (r2 == 0) goto L1c
            if (r2 == r3) goto L18
            r4 = 2
            if (r2 == r4) goto L1c
            r4 = 3
            if (r2 == r4) goto L18
            goto L1f
        L18:
            r6.setPressed(r0)
            goto L1f
        L1c:
            r6.setPressed(r3)
        L1f:
            int r0 = r7.getPointerCount()
            if (r0 <= r3) goto L51
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "onTouch: PointerCount more one PointerCount("
            r6.append(r0)
            int r7 = r7.getPointerCount()
            r6.append(r7)
            java.lang.String r7 = "), and CurrentState is "
            r6.append(r7)
            com.android.incallui.oplus.answerview.view.j$b r7 = r5.f18837b
            java.lang.String r7 = r7.b()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r1, r6)
            com.android.incallui.oplus.answerview.view.j$b r6 = r5.f18840e
            r5.q(r6)
            return r3
        L51:
            boolean r0 = r5.f18839d
            if (r0 != 0) goto L70
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "onTouch: not support touch and CurrentState is "
            r6.append(r7)
            com.android.incallui.oplus.answerview.view.j$b r5 = r5.f18837b
            java.lang.String r5 = r5.b()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            android.util.Log.d(r1, r5)
            return r3
        L70:
            com.android.incallui.oplus.answerview.view.j$b r5 = r5.f18837b
            boolean r5 = r5.d(r6, r7)
            return r5
        L77:
            java.lang.String r5 = "onTouch: illegal parameter"
            android.util.Log.d(r1, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.oplus.answerview.view.j.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void p(View view, float f10) {
        view.setTranslationY(f10);
        n(f18835l.e(f10, this.f18844i));
    }

    @VisibleForTesting
    public final b q(b nextState) {
        kotlin.jvm.internal.i.f(nextState, "nextState");
        if (!kotlin.jvm.internal.i.b(this.f18837b, nextState)) {
            this.f18837b.a();
            this.f18837b = nextState;
            nextState.c();
        }
        return this.f18837b;
    }

    public j() {
        this.f18837b = new e();
        this.f18840e = new g();
        this.f18841f = new d();
        this.f18842g = new h();
        this.f18843h = new f();
    }

    /* compiled from: SwipeAnswerImageViewHelper.kt */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public interface b {
        void a();

        String b();

        void c();

        boolean d(View view, MotionEvent motionEvent);

        /* compiled from: SwipeAnswerImageViewHelper.kt */
        /* loaded from: classes.dex */
        public static final class a {
            public static boolean c(b bVar, View view, MotionEvent event) {
                kotlin.jvm.internal.i.f(view, "view");
                kotlin.jvm.internal.i.f(event, "event");
                Log.d("SwipeAnswerImageViewHelper", "onTouchEvent: Error EventProcessorState");
                return false;
            }

            public static void a(b bVar) {
            }

            public static void b(b bVar) {
            }
        }
    }
}
