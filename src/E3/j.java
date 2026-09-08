package E3;

import E3.j;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.business.calllog.breenocall.FeatureOpt;
import com.android.contacts.business.calllog.breenocall.summary.BreenoCallSummaryUtils;
import com.android.contacts.calllog.CallTypeIconsView;
import com.android.contacts.calllog.k;
import com.android.contacts.detail.CallDetailActivityFragment;
import com.android.contacts.detail.CallLogDeleteHelper;
import com.android.contacts.detail.D;
import com.android.contacts.framework.baseui.calllog.CallRecordingsCache;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.util.w;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.mediaplayer.RecordPlayerPresenter;
import com.customize.contacts.util.C0799j;
import com.customize.contacts.util.C0801l;
import com.customize.contacts.util.h0;
import com.customize.contacts.widget.i;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.AppMetaFeatures;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import r0.C1498a;
import w0.C1643c;

/* compiled from: CallDetailListItemHelper.java */
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final ComponentActivity f560a;

    /* renamed from: b, reason: collision with root package name */
    public f f561b;

    /* renamed from: c, reason: collision with root package name */
    public RecordPlayerPresenter f562c;

    /* renamed from: d, reason: collision with root package name */
    public String f563d;

    /* renamed from: e, reason: collision with root package name */
    public View.OnClickListener f564e;

    /* renamed from: f, reason: collision with root package name */
    public View.OnClickListener f565f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f568i;

    /* renamed from: g, reason: collision with root package name */
    public int f566g = 0;

    /* renamed from: h, reason: collision with root package name */
    public CallDetailActivityFragment.g f567h = null;

    /* renamed from: j, reason: collision with root package name */
    public final View.OnClickListener f569j = new a();

    /* renamed from: k, reason: collision with root package name */
    public final View.OnClickListener f570k = new b();

    /* renamed from: l, reason: collision with root package name */
    public final COUISeekBar.OnSeekBarChangeListener f571l = new d();

    /* compiled from: CallDetailListItemHelper.java */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!C7.a.a()) {
                j.this.D();
            } else {
                H7.b.b("DetailListItemHelper", "click filter work in sStartStopButtonListener");
            }
        }
    }

    /* compiled from: CallDetailListItemHelper.java */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x004e, code lost:
        
            if (r2.f573a.f560a.getResources().getInteger(com.oplus.dialer.R.integer.product_flavor) == 1) goto L17;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onClick(android.view.View r3) {
            /*
                r2 = this;
                E3.j r3 = E3.j.this
                com.customize.contacts.mediaplayer.RecordPlayerPresenter r3 = E3.j.j(r3)
                if (r3 == 0) goto L13
                E3.j r3 = E3.j.this
                com.customize.contacts.mediaplayer.RecordPlayerPresenter r3 = E3.j.j(r3)
                java.lang.String r3 = r3.V()
                goto L14
            L13:
                r3 = 0
            L14:
                boolean r0 = H7.a.b()
                if (r0 == 0) goto L30
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "view callRecordingFilePath: "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "DetailListItemHelper"
                H7.b.b(r1, r0)
            L30:
                boolean r0 = android.text.TextUtils.isEmpty(r3)
                if (r0 != 0) goto L68
                boolean r0 = com.customize.contacts.FeatureOption.o()
                if (r0 == 0) goto L51
                E3.j r0 = E3.j.this
                androidx.activity.ComponentActivity r0 = E3.j.g(r0)
                android.content.res.Resources r0 = r0.getResources()
                r1 = 2131493005(0x7f0c008d, float:1.8609478E38)
                int r0 = r0.getInteger(r1)
                r1 = 1
                if (r0 != r1) goto L51
                goto L52
            L51:
                r1 = 0
            L52:
                E3.j r0 = E3.j.this
                androidx.activity.ComponentActivity r0 = E3.j.g(r0)
                com.android.contacts.framework.baseui.calllog.utils.CallRecordingUtils.f(r0, r1, r3)
                E3.j r2 = E3.j.this
                androidx.activity.ComponentActivity r2 = E3.j.g(r2)
                java.lang.String r3 = "click_item"
                java.lang.String r0 = "review_record"
                com.customize.contacts.util.h0.d(r2, r3, r0)
            L68:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: E3.j.b.onClick(android.view.View):void");
        }
    }

    /* compiled from: CallDetailListItemHelper.java */
    /* loaded from: classes3.dex */
    public class c implements Comparator<String> {
        public c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int lastIndexOf = str.lastIndexOf(".");
            int lastIndexOf2 = str2.lastIndexOf(".");
            if (lastIndexOf <= 0) {
                lastIndexOf = str.length();
            }
            if (lastIndexOf2 <= 0) {
                lastIndexOf2 = str2.length();
            }
            return str.substring(0, lastIndexOf).compareTo(str2.substring(0, lastIndexOf2));
        }
    }

    /* compiled from: CallDetailListItemHelper.java */
    /* loaded from: classes3.dex */
    public class d implements COUISeekBar.OnSeekBarChangeListener {
        public d() {
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.OnSeekBarChangeListener
        public void onProgressChanged(COUISeekBar cOUISeekBar, int i10, boolean z10) {
            if (z10) {
                j.this.f562c.v0(i10);
            }
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(COUISeekBar cOUISeekBar) {
            if (j.this.f562c != null) {
                j.this.f562c.s0();
            }
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(COUISeekBar cOUISeekBar) {
            if (j.this.f562c != null) {
                j.this.f562c.q0();
            }
        }
    }

    /* compiled from: CallDetailListItemHelper.java */
    /* loaded from: classes3.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f576a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PhoneCallDetails f577b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f578c;

        /* compiled from: CallDetailListItemHelper.java */
        /* loaded from: classes3.dex */
        public class a implements CallLogDeleteHelper.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PhoneCallDetails f580a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Q0.d f581b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ View f582c;

            public a(PhoneCallDetails phoneCallDetails, Q0.d dVar, View view) {
                this.f580a = phoneCallDetails;
                this.f581b = dVar;
                this.f582c = view;
            }

            @Override // com.android.contacts.detail.CallLogDeleteHelper.a
            public void a(Dialog dialog) {
                U0.n.d(dialog);
            }

            @Override // com.android.contacts.detail.CallLogDeleteHelper.a
            public void onClick(int i10, boolean z10) {
                boolean z11;
                Q0.b bVar = new Q0.b(this.f580a.f13167a.toString(), null, null, null, null, new ArrayList());
                bVar.a().add(this.f581b);
                ArrayList<Q0.b> arrayList = new ArrayList<>();
                arrayList.add(bVar);
                D d10 = new D(2, 1, null);
                if (z10 && j.this.f567h != null && j.this.f567h.a() != null && j.this.f566g == 4 && AppMetaFeatures.b() && CallRecordingsCache.f15754a.q(this.f580a.f13170d)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                H7.b.e("DetailListItemHelper", "Wait media: " + z11);
                if (z11) {
                    j.this.f567h.a().O5(arrayList, true);
                } else {
                    new k.l(j.this.f560a, arrayList, z10, null, d10).b();
                }
                h0.d(this.f582c.getContext(), "delete", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
            }
        }

        public e(f fVar, PhoneCallDetails phoneCallDetails, View view) {
            this.f576a = fVar;
            this.f577b = phoneCallDetails;
            this.f578c = view;
        }

        public final /* synthetic */ void b(PhoneCallDetails phoneCallDetails, View view, i.b bVar) {
            if (bVar.f22593a == R.id.delete_button) {
                if (phoneCallDetails.f13167a != null) {
                    Q0.d dVar = new Q0.d(phoneCallDetails.f13175i, phoneCallDetails.f13170d, phoneCallDetails.f13169c, phoneCallDetails.b(), phoneCallDetails.f13183q);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(dVar);
                    CallLogDeleteHelper.i(j.this.f560a, phoneCallDetails.f13167a.toString(), arrayList, 1, 2, new a(phoneCallDetails, dVar, view));
                    return;
                }
                H7.b.c("DetailListItemHelper", "Phone number is null!");
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (this.f576a.f596m.getVisibility() == 0) {
                H7.b.e("DetailListItemHelper", "Ignore long press when recording player view is shown.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new i.b(R.id.delete_button, R.string.delete_button));
            final PhoneCallDetails phoneCallDetails = this.f577b;
            final View view = this.f578c;
            i.a aVar = new i.a() { // from class: E3.k
                @Override // com.customize.contacts.widget.i.a
                public final void a(i.b bVar) {
                    j.e.this.b(phoneCallDetails, view, bVar);
                }
            };
            if (j.this.f562c != null) {
                j.this.f562c.n0();
            }
            com.customize.contacts.widget.i.w(this.f578c, (int) motionEvent.getX(), (int) motionEvent.getY(), arrayList, aVar, true);
        }
    }

    /* compiled from: CallDetailListItemHelper.java */
    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final View f584a;

        /* renamed from: b, reason: collision with root package name */
        public final int f585b;

        /* renamed from: c, reason: collision with root package name */
        public final TextView f586c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f587d;

        /* renamed from: e, reason: collision with root package name */
        public final TextView f588e;

        /* renamed from: f, reason: collision with root package name */
        public final ImageView f589f;

        /* renamed from: g, reason: collision with root package name */
        public final ImageView f590g;

        /* renamed from: h, reason: collision with root package name */
        public final CallTypeIconsView f591h;

        /* renamed from: i, reason: collision with root package name */
        public final TextView f592i;

        /* renamed from: j, reason: collision with root package name */
        public final CheckBox f593j;

        /* renamed from: k, reason: collision with root package name */
        public final ImageView f594k;

        /* renamed from: l, reason: collision with root package name */
        public TextView f595l;

        /* renamed from: m, reason: collision with root package name */
        public View f596m;

        /* renamed from: n, reason: collision with root package name */
        public COUISeekBar f597n;

        /* renamed from: o, reason: collision with root package name */
        public TextView f598o;

        /* renamed from: p, reason: collision with root package name */
        public TextView f599p;

        /* renamed from: q, reason: collision with root package name */
        public TextView f600q;

        /* renamed from: r, reason: collision with root package name */
        public final ImageView f601r;

        /* renamed from: s, reason: collision with root package name */
        public View f602s;

        /* renamed from: t, reason: collision with root package name */
        public int f603t;

        /* renamed from: u, reason: collision with root package name */
        public final ImageView f604u;

        /* renamed from: v, reason: collision with root package name */
        public final View f605v;

        /* renamed from: w, reason: collision with root package name */
        public final ImageView f606w;

        /* renamed from: x, reason: collision with root package name */
        public final View f607x;

        public f(View view, int i10, int i11) {
            this.f584a = view;
            this.f586c = (TextView) view.findViewById(R.id.date);
            this.f587d = (ImageView) view.findViewById(R.id.play_back);
            this.f588e = (TextView) view.findViewById(R.id.duration);
            this.f589f = (ImageView) view.findViewById(R.id.slot_id);
            this.f590g = (ImageView) view.findViewById(R.id.hd);
            this.f591h = (CallTypeIconsView) view.findViewById(R.id.call_type_icons);
            this.f592i = (TextView) view.findViewById(R.id.number);
            this.f593j = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
            this.f594k = (ImageView) view.findViewById(R.id.volte_vowifi_call);
            this.f595l = (TextView) view.findViewById(R.id.assistant_tips);
            this.f585b = i10;
            this.f597n = (COUISeekBar) view.findViewById(R.id.list_seek_bar);
            this.f599p = (TextView) view.findViewById(R.id.playTotaltime);
            this.f598o = (TextView) view.findViewById(R.id.currentPlayTime);
            this.f596m = view.findViewById(R.id.seek_bar_layout);
            TextView textView = (TextView) view.findViewById(R.id.view_recording_file);
            this.f600q = textView;
            COUITextViewCompatUtil.setPressRippleDrawable(textView);
            this.f601r = (ImageView) view.findViewById(R.id.breeno_icon);
            this.f602s = view.findViewById(R.id.bottom_divider);
            this.f604u = (ImageView) view.findViewById(R.id.breeno_summary_icon);
            this.f605v = view.findViewById(R.id.icons_group);
            this.f606w = (ImageView) view.findViewById(R.id.transcript_rtt);
            this.f607x = view.findViewById(R.id.phone_call_detail);
            this.f603t = i11;
        }
    }

    public j(ComponentActivity componentActivity) {
        boolean z10 = false;
        this.f568i = false;
        this.f560a = componentActivity;
        if (CommonOSPublicFeature.f() && com.android.contacts.framework.api.satellite.a.b()) {
            z10 = true;
        }
        this.f568i = z10;
    }

    public static String[] n(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr2[i10] = strArr[i10].split("/")[strArr[i10].split("/").length - 1];
        }
        return strArr2;
    }

    public static /* synthetic */ void p(View view, int i10, Object obj, Object obj2) {
        view.setVisibility(8);
        Object tag = view.getTag(R.id.call_detail);
        if (tag instanceof PhoneCallDetails) {
            PhoneCallDetails phoneCallDetails = (PhoneCallDetails) tag;
            phoneCallDetails.d(phoneCallDetails.b() ^ OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        }
    }

    public void A(RecordPlayerPresenter recordPlayerPresenter) {
        this.f562c = recordPlayerPresenter;
    }

    public final void B(ImageView imageView, boolean z10, long j10) {
        if (imageView != null && this.f560a != null) {
            if (z10) {
                if (j10 == 0) {
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.drawable.pb_ic_call_log_sim1);
                    return;
                } else if (j10 == 1) {
                    imageView.setVisibility(0);
                    imageView.setImageResource(R.drawable.pb_ic_call_log_sim2);
                    return;
                } else {
                    imageView.setVisibility(8);
                    return;
                }
            }
            imageView.setVisibility(8);
        }
    }

    public final void C(Context context, int i10, final String[] strArr) {
        Arrays.sort(strArr, new c());
        this.f562c.E0(new U0.b(context, 2132083073).setTitle((CharSequence) context.getString(R.string.check_call_records, Integer.valueOf(i10))).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setItems((CharSequence[]) n(strArr), new DialogInterface.OnClickListener() { // from class: E3.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                j.this.u(strArr, dialogInterface, i11);
            }
        }).show());
    }

    public final void D() {
        String str;
        RecordPlayerPresenter recordPlayerPresenter = this.f562c;
        if (recordPlayerPresenter == null) {
            H7.b.b("DetailListItemHelper", "mPresenter is null ,return");
            return;
        }
        if (recordPlayerPresenter.g0() && this.f562c.h0(this.f563d)) {
            this.f562c.t0(true);
            return;
        }
        A.a(this.f560a, 2000309, 200030911, null, false);
        try {
            ArrayList<Q0.c> m10 = Q0.c.m(this.f560a, true, "call_log_mapping=" + this.f563d, null);
            int size = m10.size();
            if (H7.a.b()) {
                H7.b.b("DetailListItemHelper", "Get recording count: " + size);
            }
            String str2 = "";
            if (size > 1) {
                if (this.f562c.W() && this.f562c.h0(this.f563d)) {
                    this.f562c.r0(true);
                    return;
                }
                if (!o()) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<Q0.c> it = m10.iterator();
                while (it.hasNext()) {
                    Q0.c next = it.next();
                    StringBuilder sb = new StringBuilder();
                    if (next.k()) {
                        str = "";
                    } else {
                        str = com.android.contacts.framework.baseui.calllog.a.f15768c;
                    }
                    sb.append(str);
                    sb.append(next.i());
                    arrayList.add(sb.toString());
                }
                if (H7.a.b()) {
                    Iterator<Q0.c> it2 = m10.iterator();
                    while (it2.hasNext()) {
                        Q0.c next2 = it2.next();
                        H7.b.b("DetailListItemHelper", "path: " + next2.i() + ", full: " + next2.k() + ", tiny: " + next2.l());
                    }
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        String str3 = (String) it3.next();
                        H7.b.b("DetailListItemHelper", "full path: " + str3 + ", " + new File(str3).exists());
                    }
                }
                C(this.f560a, size, (String[]) arrayList.toArray(new String[0]));
                return;
            }
            if (size != 1 || !o()) {
                return;
            }
            Q0.c cVar = m10.get(0);
            StringBuilder sb2 = new StringBuilder();
            if (!cVar.k()) {
                str2 = com.android.contacts.framework.baseui.calllog.a.f15768c;
            }
            sb2.append(str2);
            sb2.append(cVar.i());
            this.f562c.x0(this.f561b, sb2.toString(), this.f563d, true);
        } catch (Exception e10) {
            H7.b.c("DetailListItemHelper", "mStartStopButtonListener error " + e10);
        }
    }

    public final void l(f fVar, PhoneCallDetails phoneCallDetails, boolean z10) {
        if (FeatureOpt.isCallSummaryIconDisplayable() && com.android.contacts.framework.baseui.calllog.c.b(phoneCallDetails.b(), phoneCallDetails.f13183q)) {
            fVar.f604u.setVisibility(0);
            if (z10) {
                fVar.f604u.setOnClickListener(null);
                fVar.f604u.setEnabled(false);
                fVar.f604u.setClickable(false);
                fVar.f604u.setFocusable(false);
                return;
            }
            if (this.f565f == null) {
                this.f565f = new View.OnClickListener() { // from class: E3.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        j.this.q(view);
                    }
                };
            }
            fVar.f604u.setTag(phoneCallDetails.f13183q);
            fVar.f604u.setTag(R.id.call_detail, phoneCallDetails);
            fVar.f604u.setOnClickListener(this.f565f);
            fVar.f604u.setEnabled(true);
            return;
        }
        fVar.f604u.setVisibility(8);
        fVar.f604u.setOnClickListener(null);
    }

    public boolean m(String str) {
        if (AppMetaFeatures.b() && !TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        if (!w.l(this.f560a, new String[]{w.e()})) {
            w.y(this.f560a, false, null, w.e());
            return false;
        }
        return true;
    }

    public final /* synthetic */ void q(final View view) {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str)) {
            BreenoCallSummaryUtils.viewCallSummaryContent(this.f560a, str, new com.android.contacts.framework.baseui.util.t() { // from class: E3.i
                @Override // com.android.contacts.framework.baseui.util.t
                public final void a(int i10, Object obj, Object obj2) {
                    j.p(view, i10, obj, obj2);
                }
            });
            h0.d(this.f560a, "click_item", "review_AInote");
        } else {
            H7.b.c("DetailListItemHelper", "BreenoSummaryClick: no uuid!");
        }
    }

    public final /* synthetic */ void r(boolean z10, PhoneCallDetails phoneCallDetails, View view) {
        if (!z10) {
            R7.b.d(this.f560a, C1498a.a(phoneCallDetails.f13167a, phoneCallDetails.f13170d, phoneCallDetails.f13171e), R.string.activity_not_found);
        }
    }

    public final /* synthetic */ void s(View view) {
        com.android.contacts.framework.api.breenocall.a.a(view.getContext(), (String) view.getTag(), R.string.breeno_call_log_not_found);
        h0.d(this.f560a, "click_item", "review_breeno");
    }

    public final /* synthetic */ void u(String[] strArr, DialogInterface dialogInterface, int i10) {
        try {
            this.f562c.x0(this.f561b, strArr[i10], this.f563d, true);
        } catch (Exception e10) {
            H7.b.c("DetailListItemHelper", "Exception when checkCallsRecordFileDialog " + e10);
        }
    }

    public final void v(f fVar) {
        int i10;
        if (fVar.f587d.getVisibility() == 0) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (fVar.f601r.getVisibility() == 0) {
            i10++;
        }
        if (fVar.f604u.getVisibility() == 0) {
            i10++;
        }
        if (fVar.f606w.getVisibility() == 0) {
            i10++;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) fVar.f607x.getLayoutParams();
        if (i10 >= 3) {
            marginLayoutParams.setMarginEnd((int) this.f560a.getResources().getDimension(R.dimen.DP_145));
        } else {
            marginLayoutParams.setMarginEnd((int) this.f560a.getResources().getDimension(R.dimen.DP_100));
        }
        fVar.f607x.setLayoutParams(marginLayoutParams);
        if (H7.a.b()) {
            H7.b.b("DetailListItemHelper", "resetLayoutParams: rightIcons: " + i10 + ", " + marginLayoutParams.getMarginEnd());
        }
    }

    public void w(View view, final boolean z10, boolean z11, final PhoneCallDetails phoneCallDetails, boolean z12, boolean z13, int i10) {
        boolean z14;
        int i11;
        boolean z15;
        f fVar = (f) view.getTag();
        this.f561b = fVar;
        this.f566g = i10;
        int abs = Math.abs(phoneCallDetails.f13169c);
        int b10 = phoneCallDetails.b();
        String a10 = C0799j.a(this.f560a, phoneCallDetails.f13170d);
        if (H7.a.b()) {
            H7.b.e("DetailListItemHelper", "formatDateValue::" + a10);
        }
        ComponentActivity componentActivity = this.f560a;
        int i12 = b10 & 1;
        int i13 = 0;
        if (i12 == 1) {
            z14 = true;
        } else {
            z14 = false;
        }
        String str = (String) com.android.contacts.calllog.w.a(componentActivity, abs, z14);
        fVar.f586c.setTextDirection(3);
        fVar.f586c.setText(a10);
        TextView textView = fVar.f592i;
        if (textView != null) {
            if (z13) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                if (C0637b.h()) {
                    if (!TextUtils.isEmpty(phoneCallDetails.f13167a)) {
                        fVar.f592i.setText(C0637b.d(phoneCallDetails.f13167a.toString()));
                    }
                } else {
                    fVar.f592i.setText(phoneCallDetails.f13168b);
                }
                if (B3.a.f0()) {
                    if (TextUtils.equals(phoneCallDetails.f13167a, "-100")) {
                        fVar.f592i.setText(this.f560a.getResources().getString(R.string.anonymous_number));
                    }
                    if (TextUtils.equals(phoneCallDetails.f13167a, "-101")) {
                        fVar.f592i.setText(this.f560a.getResources().getString(R.string.unrecognized_number));
                    }
                    if (TextUtils.equals(phoneCallDetails.f13167a, "-102")) {
                        fVar.f592i.setText(this.f560a.getResources().getString(R.string.payphone_number));
                    }
                }
            }
        }
        CallTypeIconsView callTypeIconsView = fVar.f591h;
        if (callTypeIconsView != null) {
            callTypeIconsView.b();
            fVar.f591h.a(phoneCallDetails.f13169c, phoneCallDetails.b());
        }
        B(fVar.f589f, z12, phoneCallDetails.f13177k);
        C0801l.r(fVar.f594k, b10, phoneCallDetails.f13180n);
        C0801l.s(fVar.f590g, b10, phoneCallDetails.f13180n, this.f568i);
        if (C1643c.w()) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.ust_detail_icon_stub);
            if (viewStub != null) {
                viewStub.inflate();
            }
            C1643c.g((ImageView) view.findViewById(R.id.rtt_icon), (ImageView) view.findViewById(R.id.verification_icon), b10, phoneCallDetails.f13180n);
        }
        this.f563d = String.valueOf(phoneCallDetails.f13170d);
        if (this.f562c != null) {
            H7.b.b("DetailListItemHelper", "setCallDetailItemViews: presenter is same call log:" + this.f562c.h0(this.f563d));
        }
        z(fVar.f584a, z10, fVar.f587d, phoneCallDetails.f13179m);
        if (z10) {
            fVar.f587d.setEnabled(false);
            fVar.f587d.setFocusable(false);
            fVar.f587d.setClickable(false);
        } else {
            fVar.f587d.setEnabled(true);
        }
        if (z11) {
            y(fVar, z10, phoneCallDetails);
        }
        H7.b.b("DetailListItemHelper", "setCallDetailItemViews: view position:" + fVar.f603t);
        RecordPlayerPresenter recordPlayerPresenter = this.f562c;
        if (recordPlayerPresenter != null && recordPlayerPresenter.h0(this.f563d)) {
            RecordPlayerPresenter recordPlayerPresenter2 = this.f562c;
            if (recordPlayerPresenter2 != null && recordPlayerPresenter2.h0(this.f563d)) {
                this.f562c.H0(fVar);
            }
        } else {
            fVar.f596m.setVisibility(8);
        }
        if (abs == 4) {
            fVar.f588e.setText(str);
        } else if (abs == 3) {
            fVar.f588e.setText(str + " " + String.format(this.f560a.getResources().getString(R.string.oplus_ring_time), U7.a.b(phoneCallDetails.f13174h)));
        } else if (abs == 20) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_block_ring_once_for_detail));
        } else if (abs == 21) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_block_first_call_for_detail));
        } else if (abs == 22) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_block_no_number_for_detail));
        } else if (abs == 23) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_block_mark_number_for_detail));
        } else if (abs == 19) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.special_name_number));
        } else if (abs == 24) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_block_blacklist_attribution_for_detail));
        } else if (abs == 25) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_block_all_strangers_for_detail));
        } else if (abs == 26) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_block_all_calls_for_detail));
        } else if (abs == 27) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_black_list_call_type));
        } else if (abs == 56) {
            fVar.f588e.setText(this.f560a.getResources().getString(R.string.block_nafc_fraud));
        } else if (abs == 50) {
            if (E0.b.x()) {
                fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.mark_number_high_risk_for_detail));
            } else {
                fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.mark_number_fraud_for_detail));
            }
        } else if (abs == 51) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.mark_number_harassment_for_detail));
        } else if (abs == 52) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.mark_number_advertisement_for_detail));
        } else if (abs == 53) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.mark_number_intermediary_for_detail));
        } else if (abs == 54) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.penetrated_for_detail));
        } else if (abs == 49) {
            fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_criminal_number));
        } else {
            if (B3.a.f0()) {
                if (abs == 28) {
                    fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_block_anonymous_number_for_detail));
                } else if (abs == 29) {
                    fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_block_unrecognized_number_for_detail));
                } else if (abs == 30) {
                    fVar.f588e.setText(str + "  " + this.f560a.getResources().getString(R.string.oplus_block_payphone_number_for_detail));
                }
            } else if (B3.a.D() && !z13 && fVar.f592i != null) {
                if (phoneCallDetails.f13167a.equals(OplusPhoneUtils.DeviceState.INVALID_STATUS)) {
                    fVar.f592i.setText(R.string.unknown_number);
                }
                if (phoneCallDetails.f13167a.equals("-2")) {
                    fVar.f592i.setText(R.string.private_num);
                }
                if (phoneCallDetails.f13167a.equals("-3")) {
                    fVar.f592i.setText(R.string.payphone_number);
                }
            }
            fVar.f588e.setText(str + " " + C0799j.b(this.f560a, (int) phoneCallDetails.f13171e, abs));
        }
        if (C0801l.n(phoneCallDetails.b())) {
            Drawable drawable = this.f560a.getDrawable(R.drawable.pb_bg_assisant);
            drawable.setAlpha(50);
            fVar.f595l.setBackground(drawable);
            fVar.f595l.setVisibility(0);
            fVar.f595l.setOnClickListener(new View.OnClickListener() { // from class: E3.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    j.this.r(z10, phoneCallDetails, view2);
                }
            });
        } else {
            fVar.f595l.setVisibility(8);
        }
        if (FeatureOption.m() && com.android.contacts.framework.baseui.calllog.c.c(phoneCallDetails.b(), phoneCallDetails.f13183q)) {
            if (abs == 3) {
                ComponentActivity componentActivity2 = this.f560a;
                if (i12 == 1) {
                    z15 = true;
                } else {
                    z15 = false;
                }
                CharSequence a11 = com.android.contacts.calllog.w.a(componentActivity2, 1, z15);
                fVar.f588e.setText(((Object) a11) + " " + C0799j.b(this.f560a, (int) phoneCallDetails.f13171e, abs));
            }
            fVar.f601r.setVisibility(0);
            if (z10) {
                fVar.f601r.setOnClickListener(null);
                fVar.f601r.setEnabled(false);
                fVar.f601r.setClickable(false);
                fVar.f601r.setFocusable(false);
            } else {
                if (this.f564e == null) {
                    this.f564e = new View.OnClickListener() { // from class: E3.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            j.this.s(view2);
                        }
                    };
                }
                fVar.f601r.setTag(phoneCallDetails.f13183q);
                fVar.f601r.setOnClickListener(this.f564e);
                fVar.f601r.setEnabled(true);
            }
            i11 = 8;
        } else {
            i11 = 8;
            fVar.f601r.setVisibility(8);
            fVar.f601r.setOnClickListener(null);
        }
        l(fVar, phoneCallDetails, z10);
        fVar.f587d.setOnClickListener(this.f569j);
        fVar.f597n.setOnSeekBarChangeListener(this.f571l);
        fVar.f600q.setOnClickListener(this.f570k);
        if (C1643c.w()) {
            ImageView imageView = fVar.f606w;
            C1643c.f(this.f560a, imageView, phoneCallDetails.f13170d, Integer.valueOf(phoneCallDetails.f13181o));
            imageView.setEnabled(!z10);
        }
        if (i10 != 1 && i10 != 2) {
            fVar.f602s.setVisibility(4);
        } else {
            fVar.f602s.setVisibility(0);
        }
        View view2 = fVar.f605v;
        if (z10) {
            i13 = i11;
        }
        view2.setVisibility(i13);
        if (!z10) {
            v(fVar);
        }
    }

    public void x(CallDetailActivityFragment.g gVar) {
        this.f567h = gVar;
    }

    public final void y(f fVar, boolean z10, PhoneCallDetails phoneCallDetails) {
        View view = fVar.f584a;
        if (z10) {
            view.setOnTouchListener(null);
            return;
        }
        view.setClickable(true);
        final GestureDetector gestureDetector = new GestureDetector(view.getContext(), new e(fVar, phoneCallDetails, view));
        view.setOnTouchListener(new View.OnTouchListener() { // from class: E3.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean onTouchEvent;
                onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
                return onTouchEvent;
            }
        });
    }

    public final void z(View view, boolean z10, ImageView imageView, String str) {
        if (imageView == null) {
            return;
        }
        if (m(str)) {
            if (view != null && z10) {
                view.setOnClickListener(null);
                view.setClickable(false);
            }
            imageView.setVisibility(0);
            RecordPlayerPresenter recordPlayerPresenter = this.f562c;
            if (recordPlayerPresenter != null && recordPlayerPresenter.h0(this.f563d) && this.f562c.g0()) {
                imageView.setImageResource(R.drawable.pb_ic_voicemail_pause);
                return;
            } else if (z10) {
                imageView.setImageResource(R.drawable.pb_ic_voicemail_resume_disabled);
                return;
            } else {
                imageView.setImageResource(R.drawable.pb_ic_voicemail_resume);
                return;
            }
        }
        if (view != null) {
            view.setClickable(false);
        }
        imageView.setVisibility(8);
    }
}
