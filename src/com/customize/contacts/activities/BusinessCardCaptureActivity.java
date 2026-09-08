package com.customize.contacts.activities;

import F3.a;
import S3.a;
import U3.f;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.VelocityTracker;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.model.Account;
import com.coui.appcompat.pressfeedback.COUIPressFeedbackHelper;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import com.coui.appcompat.theme.COUIThemeOverlay;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.BusinessCardCaptureActivity;
import com.customize.contacts.camera.CameraSurfaceView;
import com.customize.contacts.camera.GridLineViewGroup;
import com.customize.contacts.camera.RotateImageView;
import com.customize.contacts.widget.FinderView;
import com.customize.contacts.widget.ScrollTabLayout;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oua.ocr.ContactInfo;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class BusinessCardCaptureActivity extends BasicActivity implements View.OnClickListener, CameraSurfaceView.a, a.e, Camera.PreviewCallback, a.d {

    /* renamed from: j0, reason: collision with root package name */
    public static ThreadPoolExecutor f20112j0;

    /* renamed from: k0, reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f20113k0;

    /* renamed from: B, reason: collision with root package name */
    public VelocityTracker f20117B;

    /* renamed from: D, reason: collision with root package name */
    public F3.a f20119D;

    /* renamed from: E, reason: collision with root package name */
    public a.c f20120E;

    /* renamed from: F, reason: collision with root package name */
    public boolean f20121F;

    /* renamed from: G, reason: collision with root package name */
    public k f20122G;

    /* renamed from: K, reason: collision with root package name */
    public Context f20126K;

    /* renamed from: Q, reason: collision with root package name */
    public Rect f20132Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f20133R;

    /* renamed from: S, reason: collision with root package name */
    public GridLineViewGroup f20134S;

    /* renamed from: U, reason: collision with root package name */
    public l f20136U;

    /* renamed from: V, reason: collision with root package name */
    public S3.a f20137V;

    /* renamed from: W, reason: collision with root package name */
    public View f20138W;

    /* renamed from: X, reason: collision with root package name */
    public FinderView f20139X;

    /* renamed from: Y, reason: collision with root package name */
    public ScrollTabLayout f20140Y;

    /* renamed from: Z, reason: collision with root package name */
    public ScrollTabLayout f20141Z;

    /* renamed from: a0, reason: collision with root package name */
    public S3.p f20142a0;

    /* renamed from: b0, reason: collision with root package name */
    public S3.d f20143b0;

    /* renamed from: c0, reason: collision with root package name */
    public CountDownTimer f20144c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f20145d0;

    /* renamed from: e0, reason: collision with root package name */
    public ImageView f20146e0;

    /* renamed from: f0, reason: collision with root package name */
    public S3.i f20147f0;

    /* renamed from: q, reason: collision with root package name */
    public CameraSurfaceView f20152q;

    /* renamed from: r, reason: collision with root package name */
    public RotateImageView f20153r;

    /* renamed from: x, reason: collision with root package name */
    public RelativeLayout f20154x;

    /* renamed from: y, reason: collision with root package name */
    public ImageButton f20155y;

    /* renamed from: z, reason: collision with root package name */
    public RotateImageView f20156z;

    /* renamed from: i0, reason: collision with root package name */
    public static final Object f20111i0 = new Object();

    /* renamed from: l0, reason: collision with root package name */
    public static ArrayList<ContentProviderOperation> f20114l0 = new ArrayList<>();

    /* renamed from: m0, reason: collision with root package name */
    public static HashSet<ArrayList<ContentProviderOperation>> f20115m0 = null;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20150o = true;

    /* renamed from: p, reason: collision with root package name */
    public Thread f20151p = null;

    /* renamed from: A, reason: collision with root package name */
    public String f20116A = "off";

    /* renamed from: C, reason: collision with root package name */
    public GestureDetector f20118C = null;

    /* renamed from: H, reason: collision with root package name */
    public int f20123H = -1;

    /* renamed from: I, reason: collision with root package name */
    public androidx.appcompat.app.b f20124I = null;

    /* renamed from: J, reason: collision with root package name */
    public String f20125J = "";

    /* renamed from: L, reason: collision with root package name */
    public long f20127L = -1;

    /* renamed from: M, reason: collision with root package name */
    public boolean f20128M = false;

    /* renamed from: N, reason: collision with root package name */
    public boolean f20129N = false;

    /* renamed from: O, reason: collision with root package name */
    public boolean f20130O = false;

    /* renamed from: P, reason: collision with root package name */
    public boolean f20131P = false;

    /* renamed from: T, reason: collision with root package name */
    public boolean f20135T = false;

    /* renamed from: g0, reason: collision with root package name */
    public int[] f20148g0 = new int[2];

    /* renamed from: h0, reason: collision with root package name */
    public Runnable f20149h0 = new b();

    /* loaded from: classes3.dex */
    public class a extends CountDownTimer {
        public a(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (BusinessCardCaptureActivity.this.f20124I != null && BusinessCardCaptureActivity.this.f20124I.isShowing()) {
                BusinessCardCaptureActivity.this.f20124I.dismiss();
            }
            com.oplus.foundation.util.ui.c.b(BusinessCardCaptureActivity.this.f20126K, R.string.oplus_card_not_recognized);
            BusinessCardCaptureActivity.this.s2(true);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            if (BusinessCardCaptureActivity.this.f20124I != null && !BusinessCardCaptureActivity.this.f20124I.isShowing()) {
                BusinessCardCaptureActivity.this.f20144c0.cancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BusinessCardCaptureActivity.this.f20137V.l() == 0) {
                return;
            }
            BusinessCardCaptureActivity.this.v2();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.c {
        public c() {
        }

        @Override // F3.a.c
        public void a(Object obj) {
            BusinessCardCaptureActivity.this.U1();
            if (TextUtils.isEmpty((String) obj)) {
                com.oplus.foundation.util.ui.c.d(BusinessCardCaptureActivity.this, R.string.edit_image_failed);
                BusinessCardCaptureActivity.this.s2(true);
            } else if (BusinessCardCaptureActivity.this.f20124I != null) {
                BusinessCardCaptureActivity.this.f20124I.dismiss();
            }
        }

        @Override // F3.a.c
        public Object b(byte[] bArr, Integer... numArr) {
            String i10 = F3.b.i(BusinessCardCaptureActivity.this, bArr);
            BusinessCardCaptureActivity.this.p2(i10, false);
            return i10;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BusinessCardCaptureActivity.this.f20119D.d();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BusinessCardCaptureActivity.this.f20119D.z(BusinessCardCaptureActivity.this);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BusinessCardCaptureActivity.this.f20119D.E();
            BusinessCardCaptureActivity.this.f20133R = true;
            if (BusinessCardCaptureActivity.this.f20122G != null) {
                BusinessCardCaptureActivity.this.f20122G.disable();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f20163a;

        public g(Uri uri) {
            this.f20163a = uri;
        }

        @Override // java.lang.Runnable
        public void run() {
            InputStream inputStream;
            StringBuilder sb;
            String b10;
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2 = null;
            try {
                inputStream = BusinessCardCaptureActivity.this.getContentResolver().openInputStream(this.f20163a);
                try {
                    try {
                        b10 = F3.f.g(BusinessCardCaptureActivity.this.getApplicationContext()).b(F3.b.d() + ".jpg");
                        fileOutputStream = new FileOutputStream(b10);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        try {
                            byte[] bArr = new byte[102400];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                            }
                            if (BusinessCardCaptureActivity.this.f20137V.l() == 0) {
                                BusinessCardCaptureActivity.this.p2(b10, true);
                            } else {
                                try {
                                    BusinessCardCaptureActivity.this.f20143b0.c(b10, BusinessCardCaptureActivity.this.f20124I);
                                } catch (Exception e10) {
                                    H7.b.c("CardCaptureActivity", "e=" + e10);
                                }
                            }
                            try {
                                fileOutputStream.close();
                                inputStream.close();
                            } catch (Exception e11) {
                                e = e11;
                                sb = new StringBuilder();
                                sb.append("Exception e: ");
                                sb.append(e);
                                H7.b.c("CardCaptureActivity", sb.toString());
                            }
                        } catch (Exception e12) {
                            e = e12;
                            fileOutputStream2 = fileOutputStream;
                            H7.b.c("CardCaptureActivity", "e=" + e);
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Exception e13) {
                                    e = e13;
                                    sb = new StringBuilder();
                                    sb.append("Exception e: ");
                                    sb.append(e);
                                    H7.b.c("CardCaptureActivity", sb.toString());
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e14) {
                                H7.b.c("CardCaptureActivity", "Exception e: " + e14);
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (Exception e15) {
                    e = e15;
                }
            } catch (Exception e16) {
                e = e16;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BusinessCardCaptureActivity f20165a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f20166b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Intent f20167c;

        public h(BusinessCardCaptureActivity businessCardCaptureActivity, Context context, Intent intent) {
            this.f20165a = businessCardCaptureActivity;
            this.f20166b = context;
            this.f20167c = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            BusinessCardCaptureActivity businessCardCaptureActivity = this.f20165a;
            if (businessCardCaptureActivity != null) {
                businessCardCaptureActivity.getWindow().setFlags(2048, 2048);
            }
            R7.b.c(this.f20166b, this.f20167c);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Callable<Boolean> {
        public i() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            try {
                if (BusinessCardCaptureActivity.this.f20151p != null) {
                    BusinessCardCaptureActivity.this.f20151p.join();
                    BusinessCardCaptureActivity.this.f20151p = null;
                }
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Callable<Boolean> {
        public j() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            try {
                if (BusinessCardCaptureActivity.this.f20119D != null) {
                    BusinessCardCaptureActivity.this.f20119D.E();
                    BusinessCardCaptureActivity.this.f20133R = true;
                }
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends OrientationEventListener {
        public k(Context context) {
            super(context);
        }

        public final int a(int i10, int i11) {
            if (i11 != -1) {
                int abs = Math.abs(i10 - i11);
                if (Math.min(abs, 360 - abs) < 65) {
                    return i11;
                }
            }
            return (((i10 + 30) / 90) * 90) % 360;
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i10) {
            int a10;
            if (i10 != -1 && BusinessCardCaptureActivity.this.f20123H != (a10 = a(i10 + DisplayUtil.b(BusinessCardCaptureActivity.this.f20126K), BusinessCardCaptureActivity.this.f20123H))) {
                if (H7.a.b()) {
                    H7.b.b("CardCaptureActivity", "onOrientationChanged, mOrientation: " + BusinessCardCaptureActivity.this.f20123H + " -> " + a10);
                }
                BusinessCardCaptureActivity.this.f20123H = a10;
                BusinessCardCaptureActivity businessCardCaptureActivity = BusinessCardCaptureActivity.this;
                businessCardCaptureActivity.r2(businessCardCaptureActivity.f20123H);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class l extends AsyncTask<Void, Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<BusinessCardCaptureActivity> f20172a;

        /* renamed from: b, reason: collision with root package name */
        public long f20173b;

        public l(BusinessCardCaptureActivity businessCardCaptureActivity) {
            this.f20172a = new WeakReference<>(businessCardCaptureActivity);
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            BusinessCardCaptureActivity businessCardCaptureActivity = this.f20172a.get();
            this.f20173b = SystemClock.elapsedRealtime();
            int i10 = -1;
            if (businessCardCaptureActivity == null) {
                return -1;
            }
            Account account = new Account(R0.a.f3165a, R0.a.f3166b);
            long j10 = N3.b.j(businessCardCaptureActivity, "Business Card in ColorOS", account);
            if (j10 == -1) {
                j10 = N3.b.g(businessCardCaptureActivity, account);
            }
            businessCardCaptureActivity.f20127L = j10;
            boolean j11 = U3.f.i().j(businessCardCaptureActivity);
            if (j11) {
                synchronized (BusinessCardCaptureActivity.f20111i0) {
                    BusinessCardCaptureActivity.f20111i0.notify();
                    businessCardCaptureActivity.f20128M = true;
                }
            }
            if (j11) {
                i10 = 0;
            }
            return Integer.valueOf(i10);
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            BusinessCardCaptureActivity businessCardCaptureActivity = this.f20172a.get();
            if (businessCardCaptureActivity == null) {
                return;
            }
            H7.b.b("CardCaptureActivity", "Initialize the SDK time = " + (SystemClock.elapsedRealtime() - this.f20173b) + " ,result = " + num);
            if (num.intValue() == 0) {
                businessCardCaptureActivity.f20128M = true;
            } else {
                com.oplus.foundation.util.ui.c.d(businessCardCaptureActivity, R.string.oplus_init_bcrsdk_failed);
                businessCardCaptureActivity.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ void k() {
            BusinessCardCaptureActivity.this.f20137V.y();
        }

        public final /* synthetic */ void l() {
            BusinessCardCaptureActivity.this.f20137V.y();
        }

        public final /* synthetic */ void m() {
            BusinessCardCaptureActivity.this.f20137V.z();
        }

        public final /* synthetic */ void n() {
            BusinessCardCaptureActivity.this.f20137V.z();
        }

        public final /* synthetic */ void o() {
            BusinessCardCaptureActivity.this.f20137V.z();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            if (motionEvent != null && motionEvent2 != null) {
                try {
                    if (motionEvent.getX() - motionEvent2.getX() > 100.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) < 300.0f && Math.abs(f10) > 200.0f) {
                        if (BusinessCardCaptureActivity.this.h2()) {
                            BusinessCardCaptureActivity.this.runOnUiThread(new Runnable() { // from class: com.customize.contacts.activities.e
                                @Override // java.lang.Runnable
                                public final void run() {
                                    BusinessCardCaptureActivity.m.this.k();
                                }
                            });
                        } else {
                            if (BusinessCardCaptureActivity.this.f20123H != 0 && BusinessCardCaptureActivity.this.f20123H != -1) {
                                if (BusinessCardCaptureActivity.this.f20123H == 180) {
                                    BusinessCardCaptureActivity.this.runOnUiThread(new Runnable() { // from class: com.customize.contacts.activities.g
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            BusinessCardCaptureActivity.m.this.m();
                                        }
                                    });
                                }
                            }
                            BusinessCardCaptureActivity.this.runOnUiThread(new Runnable() { // from class: com.customize.contacts.activities.f
                                @Override // java.lang.Runnable
                                public final void run() {
                                    BusinessCardCaptureActivity.m.this.l();
                                }
                            });
                        }
                    } else if (motionEvent2.getX() - motionEvent.getX() > 100.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) < 300.0f && Math.abs(f10) > 200.0f) {
                        if (BusinessCardCaptureActivity.this.h2()) {
                            BusinessCardCaptureActivity.this.runOnUiThread(new Runnable() { // from class: com.customize.contacts.activities.h
                                @Override // java.lang.Runnable
                                public final void run() {
                                    BusinessCardCaptureActivity.m.this.n();
                                }
                            });
                        } else {
                            if (BusinessCardCaptureActivity.this.f20123H != 0 && BusinessCardCaptureActivity.this.f20123H != -1) {
                                if (BusinessCardCaptureActivity.this.f20123H == 180) {
                                    BusinessCardCaptureActivity.this.runOnUiThread(new Runnable() { // from class: com.customize.contacts.activities.j
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            BusinessCardCaptureActivity.m.this.p();
                                        }
                                    });
                                }
                            }
                            BusinessCardCaptureActivity.this.runOnUiThread(new Runnable() { // from class: com.customize.contacts.activities.i
                                @Override // java.lang.Runnable
                                public final void run() {
                                    BusinessCardCaptureActivity.m.this.o();
                                }
                            });
                        }
                    } else if (motionEvent.getY() - motionEvent2.getY() > 100.0f && Math.abs(motionEvent.getX() - motionEvent2.getX()) < 300.0f && Math.abs(f11) > 200.0f) {
                        if (!BusinessCardCaptureActivity.this.h2()) {
                            if (BusinessCardCaptureActivity.this.f20123H == 270) {
                                BusinessCardCaptureActivity.this.runOnUiThread(new Runnable() { // from class: com.customize.contacts.activities.k
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        BusinessCardCaptureActivity.m.this.q();
                                    }
                                });
                            } else if (BusinessCardCaptureActivity.this.f20123H == 90) {
                                BusinessCardCaptureActivity.this.runOnUiThread(new Runnable() { // from class: com.customize.contacts.activities.l
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        BusinessCardCaptureActivity.m.this.r();
                                    }
                                });
                            }
                        }
                    } else if (motionEvent2.getY() - motionEvent.getY() > 100.0f && Math.abs(motionEvent.getX() - motionEvent2.getX()) < 300.0f && Math.abs(f11) > 200.0f && !BusinessCardCaptureActivity.this.h2()) {
                        if (BusinessCardCaptureActivity.this.f20123H == 90) {
                            BusinessCardCaptureActivity.this.runOnUiThread(new Runnable() { // from class: com.customize.contacts.activities.m
                                @Override // java.lang.Runnable
                                public final void run() {
                                    BusinessCardCaptureActivity.m.this.s();
                                }
                            });
                        } else if (BusinessCardCaptureActivity.this.f20123H == 270) {
                            BusinessCardCaptureActivity.this.runOnUiThread(new Runnable() { // from class: com.customize.contacts.activities.n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    BusinessCardCaptureActivity.m.this.t();
                                }
                            });
                        }
                    }
                } catch (Exception e10) {
                    H7.b.c("CardCaptureActivity", "e=" + e10);
                }
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (BusinessCardCaptureActivity.this.f20119D != null && BusinessCardCaptureActivity.this.f20119D.h() != null) {
                int actionIndex = motionEvent.getActionIndex();
                int x10 = (int) (motionEvent.getX(actionIndex) + 0.5d);
                int y10 = (int) (motionEvent.getY(actionIndex) + 0.5d);
                if (!BusinessCardCaptureActivity.this.f20129N && BusinessCardCaptureActivity.this.e2(x10, y10)) {
                    try {
                        if (BusinessCardCaptureActivity.this.h2()) {
                            BusinessCardCaptureActivity.this.f20119D.r(x10, y10 - BusinessCardCaptureActivity.this.f20145d0, BusinessCardCaptureActivity.this.f20152q.getWidth(), BusinessCardCaptureActivity.this.f20152q.getHeight());
                        } else {
                            BusinessCardCaptureActivity.this.f20119D.r(x10 - ((DisplayUtil.f(BusinessCardCaptureActivity.this, true) - BusinessCardCaptureActivity.this.f20152q.getWidth()) / 2), y10, BusinessCardCaptureActivity.this.f20152q.getWidth(), BusinessCardCaptureActivity.this.f20152q.getHeight());
                        }
                        return true;
                    } catch (Exception e10) {
                        H7.b.c("CardCaptureActivity", "requestManualFocus error." + e10);
                    }
                }
                BusinessCardCaptureActivity.this.W1(motionEvent, x10, y10);
            }
            return true;
        }

        public final /* synthetic */ void p() {
            BusinessCardCaptureActivity.this.f20137V.y();
        }

        public final /* synthetic */ void q() {
            BusinessCardCaptureActivity.this.f20137V.y();
        }

        public final /* synthetic */ void r() {
            BusinessCardCaptureActivity.this.f20137V.z();
        }

        public final /* synthetic */ void s() {
            BusinessCardCaptureActivity.this.f20137V.y();
        }

        public final /* synthetic */ void t() {
            BusinessCardCaptureActivity.this.f20137V.z();
        }

        public m() {
        }
    }

    private void S1() {
        if (!com.android.contacts.util.w.l(this.f20126K, new String[]{"android.permission.CAMERA"})) {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 2001);
        }
    }

    public static /* synthetic */ boolean i2(COUIPressFeedbackHelper cOUIPressFeedbackHelper, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (C7.a.a()) {
                return true;
            }
            cOUIPressFeedbackHelper.executeFeedbackAnimator(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            cOUIPressFeedbackHelper.executeFeedbackAnimator(false);
        }
        return view.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r2(int i10) {
        if (h2()) {
            this.f20153r.g(i10, true);
            this.f20156z.g(i10, true);
        }
        this.f20119D.A(i10);
        this.f20134S.b(i10, true);
        this.f20139X.c(i10, true);
        this.f20147f0.c(i10, true);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean D0() {
        return true;
    }

    @Override // com.customize.contacts.camera.CameraSurfaceView.a
    public void F(boolean z10) {
        try {
            if (!this.f20133R) {
                this.f20119D.j(z10);
            }
        } catch (Exception e10) {
            H7.b.c("CardCaptureActivity", "e = " + e10);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    public final boolean Q1() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        i iVar = new i();
        Boolean bool = Boolean.FALSE;
        try {
            try {
                try {
                    try {
                        Boolean bool2 = (Boolean) newFixedThreadPool.submit(iVar).get(COUIScrollBar.SCROLLER_FADE_TIMEOUT, TimeUnit.MILLISECONDS);
                        newFixedThreadPool.shutdown();
                        bool = bool2;
                    } catch (TimeoutException unused) {
                        H7.b.c("CardCaptureActivity", "cameraCloseThread is time out.");
                        return bool.booleanValue();
                    }
                } catch (InterruptedException unused2) {
                    H7.b.c("CardCaptureActivity", "cameraCloseThread is interrupted.");
                    return bool.booleanValue();
                }
            } catch (Exception unused3) {
                H7.b.c("CardCaptureActivity", "cameraCloseThread has an error.");
                return bool.booleanValue();
            }
            return bool.booleanValue();
        } finally {
            newFixedThreadPool.shutdown();
        }
    }

    public final boolean R1() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        j jVar = new j();
        Boolean bool = Boolean.FALSE;
        try {
            try {
                try {
                    try {
                        Boolean bool2 = (Boolean) newFixedThreadPool.submit(jVar).get(COUIScrollBar.SCROLLER_FADE_TIMEOUT, TimeUnit.MILLISECONDS);
                        newFixedThreadPool.shutdown();
                        bool = bool2;
                    } catch (TimeoutException unused) {
                        H7.b.c("CardCaptureActivity", "cameraStopPreview is time out.");
                        return bool.booleanValue();
                    }
                } catch (InterruptedException unused2) {
                    H7.b.c("CardCaptureActivity", "cameraStopPreview is interrupted.");
                    return bool.booleanValue();
                }
            } catch (Exception unused3) {
                H7.b.c("CardCaptureActivity", "cameraStopPreview has an error.");
                return bool.booleanValue();
            }
            return bool.booleanValue();
        } finally {
            newFixedThreadPool.shutdown();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean T0() {
        return false;
    }

    public void T1() {
        if (f20112j0 == null) {
            return;
        }
        H7.b.b("CardCaptureActivity", "clearOneShotPreview");
        f20112j0.execute(new d());
    }

    public final void U1() {
        if ("torch".equals(this.f20116A)) {
            try {
                this.f20116A = "off";
                this.f20156z.setImageResource(R.drawable.pb_ic_flash_switch_off);
                this.f20119D.u(this.f20116A);
            } catch (RuntimeException e10) {
                H7.b.c("CardCaptureActivity", "Camera has closed." + e10);
            }
        }
    }

    public final void V1(int i10) {
        S3.a aVar = new S3.a(this, R.layout.view_camera_menu, this, h2());
        this.f20137V = aVar;
        aVar.q(i10);
    }

    public void W1(MotionEvent motionEvent, int i10, int i11) {
        S3.a aVar = this.f20137V;
        if (aVar != null && aVar.j(i10, i11)) {
            this.f20137V.o(motionEvent, this.f20123H);
        }
    }

    public final void X1() {
        if (com.android.contacts.util.w.l(this.f20126K, new String[]{"android.permission.CAMERA"})) {
            if (this.f20129N) {
                this.f20129N = false;
                s2(true);
                x2();
            }
            if (H7.a.b()) {
                H7.b.b("CardCaptureActivity", "handlePermissions mIsOnPause = " + this.f20135T);
            }
            if (!this.f20135T) {
                o2();
            }
        }
    }

    public final boolean Y1(Context context, ArrayList<ContentProviderOperation> arrayList, List<ContactInfo.ContactItem> list, boolean z10) {
        ArrayList<ContentProviderOperation> arrayList2;
        ArrayList<? extends Parcelable> arrayList3;
        ArrayList<ContentProviderOperation> arrayList4;
        int i10;
        String str;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList5;
        ArrayList<ContentProviderOperation> arrayList6;
        String str5;
        String str6;
        String str7;
        ArrayList<? extends Parcelable> arrayList7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        ArrayList arrayList8;
        BusinessCardCaptureActivity businessCardCaptureActivity = this;
        if (list == null) {
            return false;
        }
        String str13 = "account_name";
        String str14 = "data1";
        String str15 = "mimetype";
        if (z10) {
            arrayList4 = arrayList;
            arrayList3 = new ArrayList<>();
            i10 = 0;
        } else {
            if (arrayList == null) {
                arrayList2 = new ArrayList<>();
            } else {
                arrayList2 = arrayList;
            }
            if (f20115m0 == null) {
                HashSet<ArrayList<ContentProviderOperation>> hashSet = new HashSet<>();
                f20115m0 = hashSet;
                hashSet.add(arrayList2);
            }
            int size = arrayList2.size();
            if (size >= 100) {
                arrayList2 = new ArrayList<>();
                f20115m0.add(arrayList2);
                size = arrayList2.size();
            }
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.RawContacts.CONTENT_URI));
            newInsert.withValue("account_name", R0.a.f3165a);
            newInsert.withValue("account_type", R0.a.f3166b);
            arrayList2.add(newInsert.build());
            ContentProviderOperation.Builder newInsert2 = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
            newInsert2.withValueBackReference("raw_contact_id", size);
            newInsert2.withValue("mimetype", "vnd.android.cursor.item/group_membership");
            newInsert2.withValue("data1", Long.valueOf(businessCardCaptureActivity.f20127L));
            arrayList2.add(newInsert2.build());
            arrayList3 = null;
            arrayList4 = arrayList2;
            i10 = size;
        }
        ArrayList arrayList9 = (ArrayList) list;
        if (H7.a.b()) {
            H7.b.b("CardCaptureActivity", "constructInsertOperations items size = " + arrayList9.size() + " ,backReferenceIndex = " + i10 + " ,isSingleMode = " + z10);
        }
        Iterator it = arrayList9.iterator();
        String str16 = "";
        ArrayList arrayList10 = null;
        String str17 = "";
        String str18 = str17;
        String str19 = str18;
        while (it.hasNext()) {
            ContactInfo.ContactItem contactItem = (ContactInfo.ContactItem) it.next();
            if (contactItem == null) {
                str = str17;
                str2 = str16;
                str3 = str18;
                str4 = str19;
                arrayList5 = arrayList10;
                arrayList6 = arrayList4;
                str5 = str15;
                str6 = str14;
                str7 = str13;
                arrayList7 = arrayList3;
            } else {
                String str20 = str17;
                if (contactItem.getType() == 1) {
                    ContactInfo.NameItem nameItem = (ContactInfo.NameItem) contactItem;
                    String firstName = nameItem.getFirstName();
                    String lastName = nameItem.getLastName();
                    String middleName = nameItem.getMiddleName();
                    String value = nameItem.getValue();
                    if (TextUtils.isEmpty(firstName) && TextUtils.isEmpty(middleName) && TextUtils.isEmpty(lastName)) {
                        str18 = firstName;
                        str19 = value;
                        str16 = lastName;
                        str17 = middleName;
                    } else {
                        arrayList5 = arrayList10;
                        ArrayList<ContentProviderOperation> arrayList11 = arrayList4;
                        int i11 = i10;
                        str5 = str15;
                        com.customize.contacts.util.P.e(lastName, middleName, firstName, null, null, arrayList3, arrayList11, z10, i11);
                        str18 = firstName;
                        arrayList6 = arrayList11;
                        str6 = str14;
                        str7 = str13;
                        str19 = value;
                        str16 = lastName;
                        str17 = middleName;
                        i10 = i11;
                        arrayList7 = arrayList3;
                    }
                } else {
                    ArrayList<ContentProviderOperation> arrayList12 = arrayList4;
                    int i12 = i10;
                    ArrayList<? extends Parcelable> arrayList13 = arrayList3;
                    str5 = str15;
                    arrayList5 = arrayList10;
                    if (contactItem.getType() == 4) {
                        if (arrayList5 == null) {
                            arrayList8 = new ArrayList();
                        } else {
                            arrayList8 = arrayList5;
                        }
                        arrayList8.add((ContactInfo.CompanyItem) contactItem);
                        str17 = str20;
                        arrayList5 = arrayList8;
                        str6 = str14;
                        str7 = str13;
                        i10 = i12;
                        arrayList7 = arrayList13;
                        arrayList6 = arrayList12;
                    } else {
                        if (contactItem.getType() == 3) {
                            ContactInfo.PhoneItem phoneItem = (ContactInfo.PhoneItem) contactItem;
                            String value2 = phoneItem.getValue();
                            int subType = phoneItem.getSubType();
                            if (subType == -1) {
                                subType = 2;
                            }
                            if (TextUtils.isEmpty(value2)) {
                                str = str20;
                                arrayList6 = arrayList12;
                                str2 = str16;
                                str3 = str18;
                                str4 = str19;
                                str6 = str14;
                                str7 = str13;
                                i10 = i12;
                                arrayList7 = arrayList13;
                            } else {
                                str8 = str20;
                                str11 = str16;
                                str12 = str18;
                                str4 = str19;
                                com.customize.contacts.util.P.g(value2, subType, arrayList13, arrayList12, z10, i12);
                                arrayList6 = arrayList12;
                                str2 = str11;
                                str3 = str12;
                                str = str8;
                                str6 = str14;
                                str7 = str13;
                                i10 = i12;
                                arrayList7 = arrayList13;
                                str16 = str2;
                                str19 = str4;
                                str18 = str3;
                                str17 = str;
                            }
                        } else {
                            str8 = str20;
                            String str21 = str18;
                            str4 = str19;
                            String str22 = str16;
                            if (contactItem.getType() == 2) {
                                ContactInfo.EmailItem emailItem = (ContactInfo.EmailItem) contactItem;
                                String value3 = emailItem.getValue();
                                int subType2 = emailItem.getSubType();
                                if (TextUtils.isEmpty(value3)) {
                                    str2 = str22;
                                    str3 = str21;
                                } else {
                                    str11 = str22;
                                    str12 = str21;
                                    com.customize.contacts.util.P.c(value3, subType2, arrayList13, arrayList12, z10, i12);
                                    arrayList6 = arrayList12;
                                    str2 = str11;
                                    str3 = str12;
                                    str = str8;
                                    str6 = str14;
                                    str7 = str13;
                                    i10 = i12;
                                    arrayList7 = arrayList13;
                                    str16 = str2;
                                    str19 = str4;
                                    str18 = str3;
                                    str17 = str;
                                }
                            } else {
                                int i13 = 15;
                                if (contactItem.getType() == 7) {
                                    ContactInfo.IMItem iMItem = (ContactInfo.IMItem) contactItem;
                                    String value4 = iMItem.getValue();
                                    int subType3 = iMItem.getSubType() - 1;
                                    String label = iMItem.getLabel();
                                    if (TextUtils.isEmpty(value4)) {
                                        str2 = str22;
                                        str3 = str21;
                                    } else {
                                        if (subType3 > 15) {
                                            subType3 = -1;
                                        }
                                        if (TextUtils.isEmpty(label)) {
                                            str10 = businessCardCaptureActivity.f20126K.getString(R.string.contact_other);
                                        } else {
                                            str10 = label;
                                        }
                                        str9 = str22;
                                        arrayList6 = arrayList12;
                                        str3 = str21;
                                        i10 = i12;
                                        com.customize.contacts.util.P.d(value4, subType3, str10, arrayList13, arrayList6, z10, i10);
                                    }
                                } else {
                                    str9 = str22;
                                    str3 = str21;
                                    if (contactItem.getType() == 9) {
                                        ContactInfo.SNSItem sNSItem = (ContactInfo.SNSItem) contactItem;
                                        String value5 = sNSItem.getValue();
                                        String label2 = sNSItem.getLabel();
                                        if (!TextUtils.isEmpty(value5)) {
                                            if (contactItem.getSubType() == 23) {
                                                label2 = businessCardCaptureActivity.f20126K.getString(R.string.imProtocolWeChat);
                                            } else {
                                                i13 = -1;
                                            }
                                            if (TextUtils.isEmpty(label2)) {
                                                label2 = businessCardCaptureActivity.f20126K.getString(R.string.contact_other);
                                            }
                                            arrayList6 = arrayList12;
                                            i10 = i12;
                                            com.customize.contacts.util.P.h(value5, i13, label2, arrayList13, arrayList6, z10, i10);
                                        }
                                    } else if (contactItem.getType() == 5) {
                                        ContactInfo.AddressItem addressItem = (ContactInfo.AddressItem) contactItem;
                                        String country = addressItem.getCountry();
                                        String province = addressItem.getProvince();
                                        String city = addressItem.getCity();
                                        String street = addressItem.getStreet();
                                        String postCode = addressItem.getPostCode();
                                        String value6 = addressItem.getValue();
                                        int subType4 = addressItem.getSubType();
                                        if (!TextUtils.isEmpty(country) || !TextUtils.isEmpty(province) || !TextUtils.isEmpty(city) || !TextUtils.isEmpty(street) || !TextUtils.isEmpty(postCode)) {
                                            str = str8;
                                            str2 = str9;
                                            str6 = str14;
                                            str7 = str13;
                                            com.customize.contacts.util.P.a(value6, subType4, country, province, city, street, postCode, arrayList13, arrayList12, z10, i12);
                                            arrayList6 = arrayList12;
                                            i10 = i12;
                                            arrayList7 = arrayList13;
                                            str16 = str2;
                                            str19 = str4;
                                            str18 = str3;
                                            str17 = str;
                                        }
                                    } else {
                                        str2 = str9;
                                        str = str8;
                                        str6 = str14;
                                        str7 = str13;
                                        if (contactItem.getType() == 11) {
                                            String value7 = ((ContactInfo.NickNameItem) contactItem).getValue();
                                            if (TextUtils.isEmpty(value7)) {
                                                arrayList6 = arrayList12;
                                                i10 = i12;
                                                arrayList7 = arrayList13;
                                            } else {
                                                ContentValues contentValues = new ContentValues();
                                                ContentProviderOperation.Builder newInsert3 = ContentProviderOperation.newInsert(R0.d.a(ContactsContract.Data.CONTENT_URI));
                                                if (z10) {
                                                    contentValues.put(str5, "vnd.android.cursor.item/nickname");
                                                    contentValues.put(str6, value7);
                                                    arrayList7 = arrayList13;
                                                    arrayList7.add(contentValues);
                                                    arrayList6 = arrayList12;
                                                    i10 = i12;
                                                } else {
                                                    i10 = i12;
                                                    arrayList7 = arrayList13;
                                                    newInsert3.withValueBackReference("raw_contact_id", i10);
                                                    newInsert3.withValue(str5, "vnd.android.cursor.item/nickname");
                                                    newInsert3.withValue(str6, value7);
                                                    arrayList6 = arrayList12;
                                                    arrayList6.add(newInsert3.build());
                                                }
                                            }
                                        } else {
                                            arrayList6 = arrayList12;
                                            i10 = i12;
                                            arrayList7 = arrayList13;
                                            if (contactItem.getType() == 6) {
                                                String value8 = contactItem.getValue();
                                                if (!TextUtils.isEmpty(value8)) {
                                                    com.customize.contacts.util.P.i(value8, arrayList7, arrayList6, z10, i10);
                                                }
                                            }
                                        }
                                        str16 = str2;
                                        str19 = str4;
                                        str18 = str3;
                                        str17 = str;
                                    }
                                    arrayList6 = arrayList12;
                                    str2 = str9;
                                    str = str8;
                                    str6 = str14;
                                    str7 = str13;
                                    i10 = i12;
                                    arrayList7 = arrayList13;
                                }
                                str2 = str9;
                                str = str8;
                                str6 = str14;
                                str7 = str13;
                                arrayList7 = arrayList13;
                                str16 = str2;
                                str19 = str4;
                                str18 = str3;
                                str17 = str;
                            }
                            str = str8;
                            str6 = str14;
                            str7 = str13;
                            i10 = i12;
                            arrayList7 = arrayList13;
                            arrayList6 = arrayList12;
                        }
                        str13 = str7;
                        businessCardCaptureActivity = this;
                        str15 = str5;
                    }
                }
                str14 = str6;
                arrayList4 = arrayList6;
                arrayList3 = arrayList7;
                arrayList10 = arrayList5;
                str13 = str7;
                businessCardCaptureActivity = this;
                str15 = str5;
            }
            str14 = str6;
            arrayList4 = arrayList6;
            arrayList3 = arrayList7;
            arrayList10 = arrayList5;
            str16 = str2;
            str19 = str4;
            str18 = str3;
            str17 = str;
            str13 = str7;
            businessCardCaptureActivity = this;
            str15 = str5;
        }
        String str23 = str17;
        String str24 = str16;
        String str25 = str18;
        String str26 = str19;
        ArrayList<? extends Parcelable> arrayList14 = arrayList3;
        String str27 = str13;
        ArrayList arrayList15 = arrayList10;
        ArrayList<ContentProviderOperation> arrayList16 = arrayList4;
        if (arrayList15 != null && arrayList15.size() > 0) {
            int size2 = arrayList15.size();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for (int i14 = 0; i14 < size2; i14++) {
                ContactInfo.CompanyItem companyItem = (ContactInfo.CompanyItem) arrayList15.get(i14);
                String company = companyItem.getCompany();
                String title = companyItem.getTitle();
                String department = companyItem.getDepartment();
                if (!TextUtils.isEmpty(company)) {
                    sb.append(company);
                    if (size2 > 1 && i14 < size2 - 1) {
                        sb.append(" ");
                    }
                }
                if (!TextUtils.isEmpty(title)) {
                    sb2.append(title);
                    if (size2 > 1 && i14 < size2 - 1) {
                        sb2.append(" ");
                    }
                }
                if (!TextUtils.isEmpty(department)) {
                    sb3.append(department);
                    if (size2 > 1 && i14 < size2 - 1) {
                        sb3.append(" ");
                    }
                }
            }
            com.customize.contacts.util.P.b(sb, sb3, sb2, arrayList14, arrayList16, z10, i10);
        }
        if (!z10) {
            return true;
        }
        if (arrayList14.size() > 0) {
            Intent intent = new Intent(com.customize.contacts.util.k0.f22137a, ContactsContract.Contacts.CONTENT_URI);
            intent.putExtra("name", str26);
            intent.putExtra("data2", str25);
            intent.putExtra("data3", str24);
            intent.putExtra("data5", str23);
            intent.putParcelableArrayListExtra("data", arrayList14);
            intent.putExtra("STORAGE_TYPE", R0.a.f3166b);
            intent.putExtra(str27, R0.a.f3165a);
            intent.putExtra("group_id", this.f20127L);
            intent.putExtra("business_card_photo_path", F3.f.g(getApplicationContext()).f(this));
            BusinessCardCaptureActivity businessCardCaptureActivity2 = (BusinessCardCaptureActivity) context;
            if (businessCardCaptureActivity2 != null) {
                businessCardCaptureActivity2.runOnUiThread(new h(businessCardCaptureActivity2, context, intent));
            }
            return true;
        }
        return false;
    }

    public final void Z1(int i10, View view) {
        final COUIPressFeedbackHelper cOUIPressFeedbackHelper = new COUIPressFeedbackHelper(view, i10);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.customize.contacts.activities.b
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean i22;
                i22 = BusinessCardCaptureActivity.i2(COUIPressFeedbackHelper.this, view2, motionEvent);
                return i22;
            }
        });
    }

    public void a2() {
        Window window = getWindow();
        window.addFlags(256);
        window.setFlags(-65537, 65536);
        window.addFlags(128);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        window.setDecorFitsSystemWindows(false);
        window.setNavigationBarContrastEnforced(false);
        window.getDecorView().setSystemUiVisibility(1024);
    }

    public final void b2(int i10) {
        if (FeatureOption.i()) {
            this.f20142a0.c();
            this.f20142a0.a();
            x(i10);
        } else {
            this.f20142a0.d();
            this.f20142a0.a();
            x(i10);
        }
    }

    @Override // com.customize.contacts.camera.CameraSurfaceView.a
    public void c() {
        this.f20121F = false;
        if (!R1()) {
            finish();
        }
    }

    public final void c2(int i10) {
        CameraSurfaceView cameraSurfaceView = (CameraSurfaceView) findViewById(R.id.surface_view);
        this.f20152q = cameraSurfaceView;
        cameraSurfaceView.setCallback(this);
        this.f20119D = new F3.a(this, this.f20152q);
        this.f20138W = findViewById(R.id.menu_line);
        this.f20140Y = (ScrollTabLayout) findViewById(R.id.menu_panel);
        this.f20141Z = (ScrollTabLayout) findViewById(R.id.widescreen_menu_panel);
        this.f20134S = (GridLineViewGroup) findViewById(R.id.grid_line_view_group);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.control_panel);
        this.f20154x = relativeLayout;
        this.f20147f0 = new S3.i(relativeLayout, this, this.f20150o);
        this.f20153r = (RotateImageView) this.f20154x.findViewById(R.id.thumbnail);
        this.f20155y = (ImageButton) this.f20154x.findViewById(R.id.shutterbtn);
        this.f20156z = (RotateImageView) findViewById(R.id.flash_mode);
        this.f20146e0 = (ImageView) findViewById(R.id.back_icon);
        u2();
        this.f20155y.setOnClickListener(this);
        this.f20156z.setOnClickListener(this);
        Z1(0, this.f20156z);
        this.f20153r.setOnClickListener(this);
        Z1(0, this.f20153r);
        this.f20146e0.setOnClickListener(this);
        FinderView finderView = (FinderView) findViewById(R.id.qrcode_guide_view);
        this.f20139X = finderView;
        this.f20142a0 = new S3.p(this, this.f20134S, this.f20138W, finderView, this.f20140Y, this.f20141Z, this.f20155y);
        this.f20143b0 = new S3.d(this);
        V1(i10);
        b2(i10);
    }

    public final void d2() {
        if (this.f20132Q == null) {
            this.f20132Q = new Rect();
            if (h2()) {
                this.f20132Q.set(0, this.f20145d0, this.f20152q.getWidth(), DisplayUtil.e(this, true) - this.f20154x.getHeight());
            } else {
                int f10 = (DisplayUtil.f(this, true) - this.f20152q.getWidth()) / 2;
                int e10 = DisplayUtil.e(this, true);
                if (!com.android.contacts.framework.baseui.util.n.b() && !CommonFeatureOption.m()) {
                    e10 -= DisplayUtil.d(this);
                }
                this.f20132Q.set(f10, 0, this.f20152q.getWidth() + f10, e10);
            }
            if (H7.a.b()) {
                H7.b.b("CardCaptureActivity", "innerGetFocusTouchRect mFocusTouchRect:" + this.f20132Q);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f20117B == null) {
            this.f20117B = VelocityTracker.obtain();
        }
        this.f20117B.addMovement(motionEvent);
        if (this.f20118C == null) {
            this.f20118C = new GestureDetector(this, new m());
        }
        this.f20118C.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    public final boolean e2(int i10, int i11) {
        if ((!h2() && g2(i10, i11)) || !this.f20119D.n()) {
            return false;
        }
        d2();
        return this.f20132Q.contains(i10, i11);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void f1(Activity activity, boolean z10, boolean z11) {
        if (!com.android.contacts.framework.baseui.util.n.b()) {
            if (!CommonFeatureOption.m()) {
                i1();
            } else {
                getWindow().getDecorView().setSystemUiVisibility(6);
            }
        }
        COUIThemeOverlay.getInstance().applyThemeOverlays(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:
    
        if (r1 != 270) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f2(android.view.View r5, int r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            int[] r1 = r4.f20148g0
            r5.getLocationOnScreen(r1)
            boolean r1 = r4.h2()
            r2 = 1
            if (r1 == 0) goto L2c
            int[] r1 = r4.f20148g0
            r1 = r1[r0]
            if (r6 <= r1) goto L2b
            int r3 = r5.getWidth()
            int r1 = r1 + r3
            if (r6 >= r1) goto L2b
            int[] r4 = r4.f20148g0
            r4 = r4[r2]
            if (r7 <= r4) goto L2b
            int r5 = r5.getHeight()
            int r4 = r4 + r5
            if (r7 >= r4) goto L2b
            r0 = r2
        L2b:
            return r0
        L2c:
            int r1 = r4.f20123H
            r3 = 90
            if (r1 == r3) goto L3b
            r3 = 180(0xb4, float:2.52E-43)
            if (r1 == r3) goto L5a
            r3 = 270(0x10e, float:3.78E-43)
            if (r1 == r3) goto L7b
            goto L98
        L3b:
            int[] r1 = r4.f20148g0
            r1 = r1[r0]
            if (r6 <= r1) goto L5a
            int r3 = r5.getHeight()
            int r1 = r1 + r3
            if (r6 >= r1) goto L5a
            int[] r1 = r4.f20148g0
            r1 = r1[r2]
            int r3 = r5.getWidth()
            int r1 = r1 - r3
            if (r7 <= r1) goto L5a
            int[] r1 = r4.f20148g0
            r1 = r1[r2]
            if (r7 >= r1) goto L5a
            return r2
        L5a:
            int[] r1 = r4.f20148g0
            r1 = r1[r0]
            int r3 = r5.getWidth()
            int r1 = r1 - r3
            if (r6 <= r1) goto L7b
            int[] r1 = r4.f20148g0
            r3 = r1[r0]
            if (r6 >= r3) goto L7b
            r1 = r1[r2]
            int r3 = r5.getHeight()
            int r1 = r1 - r3
            if (r7 <= r1) goto L7b
            int[] r1 = r4.f20148g0
            r1 = r1[r2]
            if (r7 >= r1) goto L7b
            return r2
        L7b:
            int[] r1 = r4.f20148g0
            r1 = r1[r0]
            int r3 = r5.getHeight()
            int r1 = r1 - r3
            if (r6 <= r1) goto L98
            int[] r1 = r4.f20148g0
            r3 = r1[r0]
            if (r6 >= r3) goto L98
            r1 = r1[r2]
            if (r7 <= r1) goto L98
            int r3 = r5.getWidth()
            int r1 = r1 + r3
            if (r7 >= r1) goto L98
            return r2
        L98:
            int[] r1 = r4.f20148g0
            r1 = r1[r0]
            if (r6 <= r1) goto Lb3
            int r3 = r5.getWidth()
            int r1 = r1 + r3
            if (r6 >= r1) goto Lb3
            int[] r4 = r4.f20148g0
            r4 = r4[r2]
            if (r7 <= r4) goto Lb3
            int r5 = r5.getHeight()
            int r4 = r4 + r5
            if (r7 >= r4) goto Lb3
            return r2
        Lb3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.activities.BusinessCardCaptureActivity.f2(android.view.View, int, int):boolean");
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    public final boolean g2(int i10, int i11) {
        if (f2(this.f20146e0, i10, i11) || f2(this.f20155y, i10, i11) || f2(this.f20156z, i10, i11) || f2(this.f20153r, i10, i11) || f2(this.f20141Z, i10, i11)) {
            return true;
        }
        return false;
    }

    public boolean h2() {
        return this.f20150o;
    }

    public final /* synthetic */ void j2(byte[] bArr, Point point) {
        try {
            if (this.f20137V.l() != 0 && !this.f20143b0.d(bArr, point.x, point.y)) {
                this.f20143b0.a().postDelayed(this.f20149h0, 1000L);
            }
        } catch (Exception e10) {
            H7.b.c("CardCaptureActivity", "e =" + e10);
            if (this.f20137V.l() == -1) {
                this.f20143b0.a().postDelayed(this.f20149h0, 1000L);
            }
        }
    }

    public final /* synthetic */ void k2(long j10, HashMap hashMap, List list) {
        H7.b.b("CardCaptureActivity", "onRecognize time = " + (System.currentTimeMillis() - j10));
        boolean Y12 = Y1(this.f20126K, null, list, true);
        androidx.appcompat.app.b bVar = this.f20124I;
        if (bVar != null && bVar.isShowing()) {
            if (!isFinishing() && !isDestroyed()) {
                this.f20124I.dismiss();
            } else {
                H7.b.b("CardCaptureActivity", "recognize getContactInfo return");
                return;
            }
        }
        if (Y12 && list.size() > 0) {
            H7.b.b("CardCaptureActivity", "recognize getContactInfo contactItems = " + list.size());
            hashMap.put("recognize_success_count", 1);
            com.android.contacts.framework.baseui.util.A.a(getApplicationContext(), 2000322, 200030281, hashMap, false);
            finish();
            return;
        }
        H7.b.b("CardCaptureActivity", "recognize getContactInfo contactItems.size()==0");
        hashMap.put("recognize_success_count", 0);
        com.oplus.foundation.util.ui.c.b(this.f20126K, R.string.oplus_card_not_recognized);
        this.f20119D.C();
        this.f20133R = false;
        s2(true);
        com.android.contacts.framework.baseui.util.A.a(getApplicationContext(), 2000322, 200030281, hashMap, false);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void l0() {
        if (CommonFeatureOption.m()) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(5);
        }
    }

    public final /* synthetic */ void l2(HashMap hashMap, Exception exc) {
        H7.b.b("CardCaptureActivity", "recognize getContactInfo error");
        hashMap.put("recognize_success_count", 0);
        com.android.contacts.framework.baseui.util.A.a(getApplicationContext(), 2000322, 200030281, hashMap, false);
        androidx.appcompat.app.b bVar = this.f20124I;
        if (bVar != null && bVar.isShowing()) {
            if (!isFinishing() && !isDestroyed()) {
                this.f20124I.dismiss();
            } else {
                H7.b.b("CardCaptureActivity", "recognize getContactInfo return");
                return;
            }
        }
        com.oplus.foundation.util.ui.c.b(this.f20126K, R.string.oplus_card_not_recognized);
        this.f20119D.C();
        this.f20133R = false;
        s2(true);
    }

    public final void m2() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        intent.setType("image/*");
        if (P7.c.b(intent, this.f20126K, true) != null) {
            Q7.b.b(this, intent, 1, 0);
        } else {
            Q7.b.b(this, com.android.contacts.util.i.m(), 1005, 0);
        }
    }

    public final void n2() {
        CountDownTimer countDownTimer = this.f20144c0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f20144c0 = null;
        }
        a aVar = new a(10000L, 1000L);
        this.f20144c0 = aVar;
        aVar.start();
    }

    public final void o2() {
        if (H7.a.b()) {
            H7.b.b("CardCaptureActivity", "realStartPreview");
        }
        this.f20154x.setVisibility(0);
        this.f20119D.C();
        this.f20133R = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        t2(true);
        if ((i10 == 1 || i10 == 1005) && i11 == -1) {
            if (intent == null) {
                H7.b.i("CardCaptureActivity", "onActivityResult， data is null!");
                return;
            }
            Uri data = intent.getData();
            if (data == null) {
                return;
            }
            this.f20124I = U0.k.o(this, getString(R.string.oplus_card_recognizing));
            f20112j0.execute(new g(data));
            return;
        }
        if (i10 == 999 && !isFinishing()) {
            if (checkSelfPermission("android.permission.CAMERA") != 0) {
                if (shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 2001);
                    return;
                } else {
                    com.android.contacts.util.w.C(this, false, getString(R.string.oplus_card_recognize_name), null, new String[]{"android.permission.CAMERA"});
                    return;
                }
            }
            l lVar = this.f20136U;
            if (lVar != null) {
                lVar.cancel(true);
                this.f20136U = null;
            }
            l lVar2 = new l(this);
            this.f20136U = lVar2;
            lVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            o2();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        getWindow().setFlags(2048, 2048);
        super.onBackPressed();
        HashSet<ArrayList<ContentProviderOperation>> hashSet = f20115m0;
        if (hashSet != null) {
            hashSet.clear();
            f20115m0 = null;
        }
        ArrayList<ContentProviderOperation> arrayList = f20114l0;
        if (arrayList != null) {
            arrayList.clear();
            f20114l0 = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.flash_mode) {
            w2();
        } else if (view.getId() == R.id.thumbnail) {
            t2(false);
            U1();
            try {
                m2();
            } catch (Exception e10) {
                H7.b.c("CardCaptureActivity", "onThumbNailClick(), e=" + e10);
                t2(true);
            }
        }
        if (C7.a.a()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.back_icon) {
            if (id == R.id.shutterbtn) {
                if (this.f20119D.F()) {
                    s2(false);
                    this.f20124I = U0.k.o(this, getString(R.string.oplus_card_recognizing));
                    n2();
                    return;
                }
                com.oplus.foundation.util.ui.c.b(this.f20126K, R.string.oplus_card_not_recognized);
                return;
            }
            return;
        }
        onBackPressed();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        boolean z10;
        super.onCreate(bundle);
        a2();
        setContentView(R.layout.activity_camera);
        if (findViewById(R.id.menu_panel) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f20150o = z10;
        this.f20126K = this;
        this.f20121F = false;
        this.f20145d0 = getResources().getDimensionPixelSize(R.dimen.camera_layout_margin_top);
        if (f20112j0 == null) {
            f20113k0 = new LinkedBlockingQueue<>();
            f20112j0 = new ThreadPoolExecutor(1, 1, 100L, TimeUnit.SECONDS, f20113k0);
        }
        if (bundle != null) {
            c2(bundle.getInt("menu_state", 0));
        } else {
            c2(0);
        }
        l lVar = this.f20136U;
        if (lVar != null) {
            lVar.cancel(true);
            this.f20136U = null;
        }
        l lVar2 = new l(this);
        this.f20136U = lVar2;
        lVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        c cVar = new c();
        this.f20120E = cVar;
        this.f20119D.t(cVar);
        S1();
        String l10 = C7.e.l(getIntent(), "mode");
        HashMap hashMap = new HashMap();
        if ("from_main_activity".equals(l10)) {
            hashMap.put("scan_from", 0);
        } else if ("from_card_activity".equals(l10)) {
            hashMap.put("scan_from", 1);
        } else {
            hashMap.put("scan_from", 2);
        }
        com.android.contacts.framework.baseui.util.A.a(getApplicationContext(), 2000322, 200030280, hashMap, false);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        U3.f.i().f();
        this.f20143b0.a().removeCallbacks(this.f20149h0);
        l lVar = this.f20136U;
        if (lVar != null) {
            lVar.cancel(true);
            this.f20136U = null;
        }
        if (f20112j0 != null) {
            if (H7.a.b()) {
                H7.b.b("CardCaptureActivity", "onDestroy getTaskCount = " + f20112j0.getTaskCount() + " ,getActiveCount = " + f20112j0.getActiveCount());
            }
            if (f20112j0.getActiveCount() > 0) {
                f20112j0.shutdown();
                try {
                    f20112j0.awaitTermination(1L, TimeUnit.SECONDS);
                } catch (InterruptedException e10) {
                    H7.b.c("CardCaptureActivity", "" + e10);
                }
            }
        }
        if (!isChangingConfigurations()) {
            F3.f.g(getApplicationContext()).a();
        }
        f20112j0 = null;
        CountDownTimer countDownTimer = this.f20144c0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f20144c0 = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f20135T = true;
        FinderView finderView = this.f20139X;
        if (finderView != null) {
            finderView.b(false);
        }
        if (this.f20151p == null) {
            Thread thread = new Thread(new f());
            this.f20151p = thread;
            thread.start();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(final byte[] bArr, Camera camera) {
        final Point g10 = this.f20119D.g();
        ThreadPoolExecutor threadPoolExecutor = f20112j0;
        if (threadPoolExecutor == null) {
            return;
        }
        threadPoolExecutor.execute(new Runnable() { // from class: com.customize.contacts.activities.a
            @Override // java.lang.Runnable
            public final void run() {
                BusinessCardCaptureActivity.this.j2(bArr, g10);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        this.f20130O = false;
        for (int i11 : iArr) {
            if (i11 != 0) {
                this.f20130O = true;
                if (!shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                    com.android.contacts.util.w.C(this, false, getString(R.string.oplus_card_recognize_name), null, new String[]{"android.permission.CAMERA"});
                    return;
                } else {
                    finish();
                    return;
                }
            }
        }
        l lVar = this.f20136U;
        if (lVar != null) {
            lVar.cancel(true);
            this.f20136U = null;
        }
        l lVar2 = new l(this);
        this.f20136U = lVar2;
        lVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        o2();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f20135T && !this.f20130O) {
            S1();
        }
        FinderView finderView = this.f20139X;
        if (finderView != null) {
            finderView.b(true);
        }
        if (!this.f20129N && !this.f20130O) {
            if (!Q1()) {
                finish();
            }
            int i10 = ((this.f20119D.i() - DisplayUtil.b(this.f20126K)) + 360) % 360;
            if (CommonFeatureOption.m()) {
                i10 = 0;
            }
            this.f20119D.s(i10);
            this.f20119D.D(this.f20135T);
            this.f20133R = false;
        }
        if (this.f20122G == null) {
            this.f20122G = new k(this);
        }
        this.f20135T = false;
        this.f20122G.enable();
        t2(true);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        S3.a aVar = this.f20137V;
        if (aVar != null) {
            bundle.putInt("menu_state", aVar.l());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        if (this.f20131P) {
            this.f20131P = false;
            getWindow().clearFlags(2048);
        }
        super.onStart();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!Q1()) {
            finish();
        }
    }

    public final void p2(String str, boolean z10) {
        q2(str, z10, false);
    }

    public final void q2(String str, boolean z10, boolean z11) {
        if (TextUtils.equals(str, this.f20125J) && !z11) {
            H7.b.b("CardCaptureActivity", "this business card is being recognized");
            return;
        }
        this.f20125J = str;
        if (H7.a.b()) {
            H7.b.b("CardCaptureActivity", "languages is  ,offline = " + z11);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (!this.f20128M) {
            try {
                Object obj = f20111i0;
                synchronized (obj) {
                    obj.wait(5000L);
                }
            } catch (InterruptedException e10) {
                H7.b.c("CardCaptureActivity", e10.toString());
            }
        }
        final HashMap hashMap = new HashMap();
        if (z10) {
            hashMap.put("scan_mode", 2);
        } else {
            hashMap.put("scan_mode", 0);
        }
        hashMap.put("recognize_total_count", 1);
        U3.f.i().h(str, new f.a() { // from class: com.customize.contacts.activities.c
            @Override // U3.f.a
            public final void a(Object obj2) {
                BusinessCardCaptureActivity.this.k2(currentTimeMillis, hashMap, (List) obj2);
            }
        }, new f.a() { // from class: com.customize.contacts.activities.d
            @Override // U3.f.a
            public final void a(Object obj2) {
                BusinessCardCaptureActivity.this.l2(hashMap, (Exception) obj2);
            }
        });
    }

    @Override // F3.a.d
    public void r(int i10, int i11) {
        if (i10 < 0 && H7.a.b()) {
            H7.b.b("CardCaptureActivity", "fixedPositionForUI::previewValue invalid");
        }
        U3.g.f3851a.a(this, i11, this.f20152q, this.f20139X, this.f20145d0, this.f20154x);
    }

    public final void s2(boolean z10) {
        int i10;
        if (z10 && this.f20137V.l() != 0) {
            return;
        }
        this.f20155y.setEnabled(z10);
        ImageButton imageButton = this.f20155y;
        if (z10) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        imageButton.setImportantForAccessibility(i10);
    }

    @Override // com.customize.contacts.camera.CameraSurfaceView.a
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            H7.b.c("CardCaptureActivity", "*** WARNING *** surfaceCreated() gave us a null surface!");
        } else if (!this.f20121F) {
            this.f20121F = true;
            X1();
        }
    }

    public final void t2(boolean z10) {
        RotateImageView rotateImageView = this.f20153r;
        if (rotateImageView != null) {
            rotateImageView.setEnabled(z10);
        }
    }

    public final void u2() {
        if (B3.a.H()) {
            this.f20156z.setVisibility(0);
        } else {
            this.f20156z.setVisibility(8);
        }
    }

    public void v2() {
        if (f20112j0 == null) {
            return;
        }
        H7.b.b("CardCaptureActivity", "startOneShotPreview");
        f20112j0.execute(new e());
    }

    public final void w2() {
        if ("torch".equals(this.f20116A)) {
            this.f20116A = "off";
            if (h2()) {
                this.f20156z.setImageResource(R.drawable.pb_ic_flash_switch_off);
            } else {
                this.f20156z.setImageResource(R.drawable.pb_ic_flash_switch_off_tablet);
            }
        } else if ("off".equals(this.f20116A)) {
            this.f20116A = "torch";
            this.f20156z.setImageResource(R.drawable.pb_ic_flash_switch_on);
        }
        if (H7.a.b()) {
            H7.b.b("CardCaptureActivity", "switchFlashlight,flash_mode=" + this.f20116A);
        }
        this.f20119D.u(this.f20116A);
    }

    @Override // S3.a.e
    public void x(int i10) {
        this.f20137V.v(i10);
        H7.b.b(null, "currentSelecedIndex = " + this.f20137V.l() + " functionIndex = " + i10);
        if (i10 != -1) {
            if (i10 == 0) {
                this.f20142a0.a();
                T1();
                return;
            }
            return;
        }
        this.f20142a0.b();
        v2();
    }

    public final void x2() {
        this.f20153r.setVisibility(0);
        this.f20155y.setEnabled(true);
        this.f20155y.setImportantForAccessibility(1);
    }
}
