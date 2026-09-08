package com.android.contacts.voicemail;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.contacts.voicemail.VoicemailAsyncTaskUtil;
import com.android.contacts.voicemail.VoicemailPlaybackPresenter;
import com.coui.appcompat.pressfeedback.COUIPressFeedbackHelper;
import com.coui.appcompat.reddot.COUIHintRedDot;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.customize.contacts.util.C0799j;
import com.customize.contacts.widget.TelescopicTextView;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class VoicemailPlaybackLayout extends LinearLayout implements VoicemailPlaybackPresenter.f, VoicemailAsyncTaskUtil.c {

    /* renamed from: y, reason: collision with root package name */
    public static final String f17843y = "VoicemailPlaybackLayout";

    /* renamed from: a, reason: collision with root package name */
    public Context f17844a;

    /* renamed from: b, reason: collision with root package name */
    public VoicemailPlaybackPresenter f17845b;

    /* renamed from: c, reason: collision with root package name */
    public int f17846c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f17847d;

    /* renamed from: e, reason: collision with root package name */
    public final View.OnClickListener f17848e;

    /* renamed from: f, reason: collision with root package name */
    public Uri f17849f;

    /* renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f17850g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17851h;

    /* renamed from: i, reason: collision with root package name */
    public COUISeekBar f17852i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f17853j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f17854k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f17855l;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f17856m;

    /* renamed from: n, reason: collision with root package name */
    public View f17857n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f17858o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f17859p;

    /* renamed from: q, reason: collision with root package name */
    public TelescopicTextView f17860q;

    /* renamed from: r, reason: collision with root package name */
    public final COUISeekBar.OnSeekBarChangeListener f17861r;

    /* renamed from: x, reason: collision with root package name */
    public e f17862x;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoicemailPlaybackLayout.this.f17845b != null) {
                VoicemailPlaybackLayout.this.t(!r2.f17847d);
                if (VoicemailPlaybackLayout.this.f17851h) {
                    VoicemailPlaybackLayout.this.f17845b.F(!VoicemailPlaybackLayout.this.f17847d);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                if (i10 == -3 || i10 == -1) {
                    VoicemailAsyncTaskUtil.a(VoicemailPlaybackLayout.this.f17844a, VoicemailPlaybackLayout.this.f17849f, VoicemailPlaybackLayout.this);
                }
            }
        }

        public b() {
        }

        public final void a() {
            a aVar = new a();
            new U0.b(VoicemailPlaybackLayout.this.f17844a, 2132083073).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) aVar).setNeutralButton(com.oplus.dialer.R.string.delete_voicemail, (DialogInterface.OnClickListener) aVar).show();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VoicemailPlaybackLayout.this.f17845b == null) {
                return;
            }
            VoicemailPlaybackLayout.this.f17845b.t();
            a();
        }
    }

    /* loaded from: classes.dex */
    public class c implements COUISeekBar.OnSeekBarChangeListener {
        public c() {
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.OnSeekBarChangeListener
        public void onProgressChanged(COUISeekBar cOUISeekBar, int i10, boolean z10) {
            VoicemailPlaybackLayout.this.a(i10, cOUISeekBar.getMax());
            if (z10) {
                VoicemailPlaybackLayout.this.f17845b.C(i10);
            }
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(COUISeekBar cOUISeekBar) {
            if (VoicemailPlaybackLayout.this.f17845b != null) {
                VoicemailPlaybackLayout.this.f17845b.v();
            }
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(COUISeekBar cOUISeekBar) {
            if (VoicemailPlaybackLayout.this.f17845b != null) {
                VoicemailPlaybackLayout.this.f17845b.B(cOUISeekBar.getProgress());
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ COUIPressFeedbackHelper f17867a;

        public d(COUIPressFeedbackHelper cOUIPressFeedbackHelper) {
            this.f17867a = cOUIPressFeedbackHelper;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f17867a.executeFeedbackAnimator(true);
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.f17867a.executeFeedbackAnimator(false);
                if (VoicemailPlaybackLayout.this.f17845b == null) {
                    return false;
                }
                if (!VoicemailPlaybackLayout.this.f17851h) {
                    VoicemailPlaybackPresenter voicemailPlaybackPresenter = VoicemailPlaybackLayout.this.f17845b;
                    VoicemailPlaybackLayout voicemailPlaybackLayout = VoicemailPlaybackLayout.this;
                    voicemailPlaybackPresenter.D(voicemailPlaybackLayout, voicemailPlaybackLayout.f17849f);
                    VoicemailPlaybackLayout.this.f17845b.A();
                } else {
                    VoicemailPlaybackLayout.this.f17845b.t();
                }
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f17869a;

        /* renamed from: c, reason: collision with root package name */
        public int f17871c;

        /* renamed from: d, reason: collision with root package name */
        public ScheduledFuture<?> f17872d;

        /* renamed from: b, reason: collision with root package name */
        public final Object f17870b = new Object();

        /* renamed from: e, reason: collision with root package name */
        public Runnable f17873e = new a();

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (e.this.f17870b) {
                    if (e.this.f17872d != null && VoicemailPlaybackLayout.this.f17845b != null) {
                        int i10 = VoicemailPlaybackLayout.this.f17845b.i();
                        e eVar = e.this;
                        VoicemailPlaybackLayout.this.a(i10, eVar.f17871c);
                    }
                }
            }
        }

        public e(int i10, ScheduledExecutorService scheduledExecutorService) {
            this.f17871c = i10;
            this.f17869a = scheduledExecutorService;
        }

        public final void d() {
            ScheduledFuture<?> scheduledFuture = this.f17872d;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                this.f17872d = null;
            }
            VoicemailPlaybackLayout.this.removeCallbacks(this.f17873e);
        }

        public void e() {
            synchronized (this.f17870b) {
                d();
                this.f17872d = this.f17869a.scheduleAtFixedRate(this, 0L, 33L, TimeUnit.MILLISECONDS);
            }
        }

        public void f() {
            synchronized (this.f17870b) {
                d();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            VoicemailPlaybackLayout.this.post(this.f17873e);
        }
    }

    public VoicemailPlaybackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17848e = new a();
        this.f17850g = new b();
        this.f17851h = false;
        this.f17861r = new c();
        this.f17844a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(com.oplus.dialer.R.layout.voicemail_playback_layout, this);
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public void a(int i10, int i11) {
        int max = Math.max(0, i10);
        int max2 = Math.max(max, i11);
        if (this.f17852i.getMax() != max2) {
            this.f17852i.setMax(max2);
        }
        this.f17852i.setProgress(max);
        this.f17859p.setText(r(i11));
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public void b() {
        this.f17851h = false;
        this.f17853j.setImageResource(com.oplus.dialer.R.drawable.pb_ic_voicemail_resume);
        e eVar = this.f17862x;
        if (eVar != null) {
            eVar.f();
            this.f17862x = null;
        }
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public void c() {
        this.f17855l.setEnabled(true);
        this.f17853j.setEnabled(true);
        this.f17852i.setEnabled(true);
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public void d() {
        this.f17853j.setEnabled(true);
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public void f() {
        e eVar = this.f17862x;
        if (eVar != null) {
            eVar.f();
        }
        h();
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public int getDesiredClipPosition() {
        return this.f17852i.getProgress();
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public int getPlaybackPosition() {
        return this.f17846c;
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public boolean getSpeakerphoneOn() {
        return this.f17847d;
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public void h() {
        this.f17853j.setEnabled(false);
        u();
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public void i() {
        h();
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public void j(int i10) {
        this.f17846c = i10;
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public void k(int i10, ScheduledExecutorService scheduledExecutorService) {
        VoicemailAsyncTaskUtil.e(getContext(), this.f17849f);
        this.f17851h = true;
        this.f17853j.setImageResource(com.oplus.dialer.R.drawable.pb_ic_voicemail_pause);
        e eVar = this.f17862x;
        if (eVar != null) {
            eVar.f();
            this.f17862x = null;
        }
        e eVar2 = new e(i10, scheduledExecutorService);
        this.f17862x = eVar2;
        eVar2.e();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f17852i = (COUISeekBar) findViewById(com.oplus.dialer.R.id.playback_seek);
        this.f17853j = (ImageView) findViewById(com.oplus.dialer.R.id.playback_start_stop);
        this.f17854k = (ImageView) findViewById(com.oplus.dialer.R.id.playback_speakerphone);
        this.f17855l = (ImageView) findViewById(com.oplus.dialer.R.id.delete_voicemail);
        this.f17856m = (ImageView) findViewById(com.oplus.dialer.R.id.slot_id);
        this.f17857n = (COUIHintRedDot) findViewById(com.oplus.dialer.R.id.is_read);
        this.f17858o = (TextView) findViewById(com.oplus.dialer.R.id.date);
        this.f17859p = (TextView) findViewById(com.oplus.dialer.R.id.total_duration_text);
        this.f17860q = (TelescopicTextView) findViewById(com.oplus.dialer.R.id.expanded_text);
        this.f17852i.setOnSeekBarChangeListener(this.f17861r);
        this.f17854k.setOnClickListener(this.f17848e);
        this.f17855l.setOnClickListener(this.f17850g);
        this.f17859p.setText(r(0));
        s(0, this.f17853j);
    }

    public void q(long j10, long j11, String str, long j12, long j13, String str2, String str3, int i10, boolean z10, int i11, String str4, boolean z11) {
        String a10 = C0799j.a(this.f17844a, j10);
        if (H7.a.b()) {
            H7.b.e(f17843y, "formatDateValue::" + a10);
        }
        TextView textView = this.f17858o;
        if (textView != null) {
            textView.setText(a10);
        }
        TextView textView2 = this.f17859p;
        if (textView2 != null) {
            textView2.setText(r(i11 * 1000));
        }
        C1.a.a(f17843y, "simId " + j11 + " simId1 " + j12 + " simId2 " + j13 + " simCount " + i10 + " phoneAccountId " + str + " iccId1 " + str2 + " iccid2 " + str3);
        if (i10 > 1) {
            if (j11 != j12 && (TextUtils.isEmpty(str2) || !TextUtils.equals(str, str2))) {
                if (j11 != j13 && (TextUtils.isEmpty(str3) || !TextUtils.equals(str, str3))) {
                    this.f17856m.setVisibility(8);
                } else {
                    this.f17856m.setImageResource(com.oplus.dialer.R.drawable.pb_ic_call_log_sim2);
                    this.f17856m.setVisibility(0);
                }
            } else {
                this.f17856m.setImageResource(com.oplus.dialer.R.drawable.pb_ic_call_log_sim1);
                this.f17856m.setVisibility(0);
            }
        } else {
            this.f17856m.setVisibility(8);
        }
        this.f17857n.setVisibility(z10 ? 8 : 0);
        t(this.f17847d);
        if (!TextUtils.isEmpty(str4)) {
            if (CommonFeatureOption.m()) {
                if (getResources().getConfiguration().orientation == 2) {
                    this.f17860q.j(Resources.getSystem().getDisplayMetrics().widthPixels - this.f17844a.getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.DP_400));
                } else {
                    this.f17860q.j(Resources.getSystem().getDisplayMetrics().widthPixels - this.f17844a.getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.DP_255));
                }
            } else {
                this.f17860q.j(Resources.getSystem().getDisplayMetrics().widthPixels - this.f17844a.getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.DP_64));
            }
            this.f17860q.setContent(str4);
            this.f17860q.setVisibility(0);
        } else {
            this.f17860q.setVisibility(8);
        }
        this.f17854k.setVisibility(z11 ? 0 : 8);
    }

    public final String r(int i10) {
        int i11 = i10 / 1000;
        int i12 = i11 / 60;
        int i13 = i11 - (i12 * 60);
        if (i12 > 99) {
            i12 = 99;
        }
        return String.format("%02d:%02d", Integer.valueOf(i12), Integer.valueOf(i13));
    }

    public final void s(int i10, View view) {
        view.setOnTouchListener(new d(new COUIPressFeedbackHelper(view, i10)));
    }

    public void t(boolean z10) {
        this.f17847d = z10;
        if (z10) {
            this.f17854k.setImageResource(com.oplus.dialer.R.drawable.pb_ic_voicemail_volume_on);
        } else {
            this.f17854k.setImageResource(com.oplus.dialer.R.drawable.pb_ic_voicemail_volume_off);
        }
    }

    public void u() {
        this.f17852i.setProgress(0);
        this.f17852i.setEnabled(false);
    }

    public void v(VoicemailPlaybackPresenter voicemailPlaybackPresenter, Uri uri) {
        this.f17845b = voicemailPlaybackPresenter;
        this.f17849f = uri;
    }

    @Override // com.android.contacts.voicemail.VoicemailPlaybackPresenter.f
    public void e() {
    }

    @Override // com.android.contacts.voicemail.VoicemailAsyncTaskUtil.c
    public void g() {
    }
}
