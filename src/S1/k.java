package s1;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.calllog.A;
import com.android.contacts.calllog.y;
import com.android.contacts.calllog.z;
import com.android.contacts.util.C;
import com.android.contacts.voicemail.VoicemailDetailActivity;
import com.coui.appcompat.reddot.COUIHintRedDot;
import com.customize.contacts.util.AnimationAnimationListenerC0813y;
import com.customize.contacts.util.C0799j;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;

/* compiled from: VisualVoicemailListAdapter.java */
/* loaded from: classes.dex */
public class k extends CursorAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final LayoutInflater f36632a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f36633b;

    /* renamed from: c, reason: collision with root package name */
    public m f36634c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f36635d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f36636e;

    /* renamed from: f, reason: collision with root package name */
    public int f36637f;

    /* renamed from: g, reason: collision with root package name */
    public Z0.b f36638g;

    /* renamed from: h, reason: collision with root package name */
    public z f36639h;

    /* compiled from: VisualVoicemailListAdapter.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public String f36645a;

        /* renamed from: b, reason: collision with root package name */
        public int f36646b;

        public d(String str, int i10) {
            this.f36645a = str;
            this.f36646b = i10;
        }
    }

    /* compiled from: VisualVoicemailListAdapter.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public TextView f36647a;

        /* renamed from: b, reason: collision with root package name */
        public COUIHintRedDot f36648b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f36649c;

        /* renamed from: d, reason: collision with root package name */
        public CheckBox f36650d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f36651e;

        /* renamed from: f, reason: collision with root package name */
        public View f36652f;

        public e() {
        }

        public void a(View view) {
            this.f36647a = (TextView) view.findViewById(R.id.vvm_number);
            this.f36648b = (COUIHintRedDot) view.findViewById(R.id.vvm_unread_counts);
            this.f36649c = (TextView) view.findViewById(R.id.vvm_date);
            this.f36650d = (CheckBox) view.findViewById(R.id.listview_scrollchoice_checkbox);
            this.f36651e = (ImageView) view.findViewById(R.id.vvm_photo);
            this.f36652f = view.findViewById(R.id.bottom_divider);
        }
    }

    public k(Context context, Cursor cursor) {
        super(context, cursor);
        this.f36633b = context;
        this.f36632a = LayoutInflater.from(context);
        this.f36638g = Z0.b.g(context);
        this.f36637f = DisplayUtil.a(context, 33.0f);
        g();
    }

    public final void a(View view, y yVar, e eVar) {
        if (i()) {
            CheckBox checkBox = eVar.f36650d;
            if (this.f36635d) {
                if (checkBox.getVisibility() != 0) {
                    AnimationAnimationListenerC0813y.i(this.f36633b, null, 0).u(false, new b(checkBox), eVar.f36650d);
                    checkBox.setVisibility(0);
                }
            } else {
                checkBox.setVisibility(0);
                eVar.f36650d.setTranslationX(0.0f);
            }
            checkBox.setChecked(this.f36634c.g(yVar.f14061f));
            checkBox.setVisibility(0);
            checkBox.setTag(new d(yVar.f14061f, yVar.f14076u));
            C.b(view, checkBox.isChecked());
            return;
        }
        CheckBox checkBox2 = eVar.f36650d;
        if (checkBox2.getVisibility() == 0) {
            if (this.f36635d) {
                AnimationAnimationListenerC0813y.n(this.f36633b, null, 8).u(false, new c(checkBox2), eVar.f36650d);
                checkBox2.setAlpha(1.0f);
                checkBox2.setVisibility(8);
            } else {
                checkBox2.setAlpha(1.0f);
                checkBox2.setVisibility(8);
            }
            checkBox2.setChecked(false);
            C.b(view, false);
        }
    }

    public final void b(y yVar, e eVar) {
        eVar.f36649c.setText(C0799j.a(this.f36633b, yVar.f14070o));
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        e eVar = (e) view.getTag();
        y f10 = f(cursor);
        y o10 = this.f36639h.o(f10.f14061f, -1, 4, f10, false, false);
        c(o10, eVar, f10.f14062g);
        d(o10, eVar);
        b(f10, eVar);
        if (i()) {
            eVar.f36648b.setVisibility(8);
        } else {
            e(f10, eVar);
        }
        a(view, f10, eVar);
    }

    public final void c(y yVar, e eVar, String str) {
        if (TextUtils.isEmpty(yVar.f14058c)) {
            TextView textView = eVar.f36647a;
            if (TextUtils.isEmpty(str)) {
                str = yVar.f14061f;
            }
            textView.setText(str);
            return;
        }
        eVar.f36647a.setText(yVar.f14058c);
    }

    public final void d(y yVar, e eVar) {
        if (this.f36636e) {
            long j10 = yVar.f14066k;
            if (j10 <= 0) {
                eVar.f36651e.setImageResource(R.drawable.pb_ic_default_photo);
            } else {
                this.f36638g.q(eVar.f36651e, j10, false, false, null);
            }
            eVar.f36651e.setVisibility(0);
            return;
        }
        eVar.f36651e.setVisibility(8);
    }

    public final void e(y yVar, e eVar) {
        if (yVar.f14076u > 0) {
            eVar.f36648b.setPointMode(2);
            eVar.f36648b.setPointNumber(yVar.f14076u);
            eVar.f36648b.setVisibility(0);
            return;
        }
        eVar.f36648b.setVisibility(8);
    }

    public final y f(Cursor cursor) {
        y yVar = new y();
        yVar.f14057b = U7.g.b(cursor.getString(8));
        yVar.f14058c = cursor.getString(7);
        String string = cursor.getString(9);
        if (string == null) {
            string = cursor.getString(1);
        }
        yVar.f14061f = string;
        yVar.f14066k = cursor.getLong(10);
        yVar.f14067l = U7.g.b(cursor.getString(14));
        yVar.f14062g = cursor.getString(11);
        yVar.f14068m = cursor.getLong(3);
        yVar.f14069n = cursor.getInt(13);
        yVar.f14070o = cursor.getLong(2);
        yVar.f14071p = -1;
        yVar.f14074s = cursor.getString(16);
        yVar.f14076u = cursor.getInt(17);
        return yVar;
    }

    public final void g() {
        Context context = this.f36633b;
        z zVar = new z(context, new A(context, null), new a());
        this.f36639h = zVar;
        zVar.v(com.android.contacts.framework.baseui.util.w.e());
        this.f36639h.t(false);
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        View view2 = view;
        if (getCursor().moveToPosition(i10)) {
            if (view == null) {
                View newView = newView(this.f36633b, getCursor(), viewGroup);
                e eVar = new e();
                eVar.a(newView);
                newView.setTag(eVar);
                view2 = newView;
            }
            bindView(view2, this.f36633b, getCursor());
            return view2;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i10);
    }

    public void h() {
        this.f36639h.p();
    }

    public final boolean i() {
        m mVar = this.f36634c;
        if (mVar != null && mVar.h()) {
            return true;
        }
        return false;
    }

    public void j(m mVar) {
        this.f36634c = mVar;
    }

    public void k(boolean z10) {
        this.f36635d = z10;
    }

    public void l(boolean z10) {
        this.f36636e = z10;
    }

    public void m(boolean z10) {
        z zVar = this.f36639h;
        if (zVar == null) {
            return;
        }
        zVar.w(z10);
    }

    public void n() {
        z zVar = this.f36639h;
        if (zVar == null) {
            return;
        }
        zVar.y();
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f36632a.inflate(R.layout.voicemail_list_item, viewGroup, false);
    }

    public void o(int i10) {
        Cursor cursor = (Cursor) getItem(i10);
        if (cursor == null) {
            return;
        }
        Uri b10 = U7.g.b(cursor.getString(8));
        String string = cursor.getString(7);
        String string2 = cursor.getString(1);
        String string3 = cursor.getString(11);
        long j10 = -1;
        if (b10 != null) {
            try {
                j10 = ContentUris.parseId(b10);
            } catch (Exception unused) {
            }
        }
        Intent intent = new Intent(this.f36633b, (Class<?>) VoicemailDetailActivity.class);
        intent.putExtra("extra_number", string2);
        intent.putExtra("extra_format_number", string3);
        intent.putExtra("extra_name", string);
        intent.putExtra("extra_contact_id", j10);
        R7.b.c(this.f36633b, intent);
    }

    /* compiled from: VisualVoicemailListAdapter.java */
    /* loaded from: classes.dex */
    public class a implements z.b {
        public a() {
        }

        @Override // com.android.contacts.calllog.z.b
        public void a() {
            k.this.notifyDataSetChanged();
        }

        @Override // com.android.contacts.calllog.z.b
        public void i() {
        }
    }

    /* compiled from: VisualVoicemailListAdapter.java */
    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f36641a;

        public b(CheckBox checkBox) {
            this.f36641a = checkBox;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f36641a.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: VisualVoicemailListAdapter.java */
    /* loaded from: classes.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckBox f36643a;

        public c(CheckBox checkBox) {
            this.f36643a = checkBox;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f36643a.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f36643a.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
