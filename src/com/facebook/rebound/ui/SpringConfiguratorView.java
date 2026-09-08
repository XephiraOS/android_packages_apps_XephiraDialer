package com.facebook.rebound.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableLayout;
import android.widget.TextView;
import c4.g;
import c4.h;
import c4.i;
import c4.j;
import c4.l;
import d4.AbstractC0953a;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class SpringConfiguratorView extends FrameLayout {

    /* renamed from: n, reason: collision with root package name */
    public static final DecimalFormat f22621n = new DecimalFormat("#.#");

    /* renamed from: a, reason: collision with root package name */
    public final e f22622a;

    /* renamed from: b, reason: collision with root package name */
    public final List<h> f22623b;

    /* renamed from: c, reason: collision with root package name */
    public final g f22624c;

    /* renamed from: d, reason: collision with root package name */
    public final float f22625d;

    /* renamed from: e, reason: collision with root package name */
    public final float f22626e;

    /* renamed from: f, reason: collision with root package name */
    public final i f22627f;

    /* renamed from: g, reason: collision with root package name */
    public final int f22628g;

    /* renamed from: h, reason: collision with root package name */
    public SeekBar f22629h;

    /* renamed from: i, reason: collision with root package name */
    public SeekBar f22630i;

    /* renamed from: j, reason: collision with root package name */
    public Spinner f22631j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f22632k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f22633l;

    /* renamed from: m, reason: collision with root package name */
    public h f22634m;

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                SpringConfiguratorView.this.p();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class e extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final Context f22638a;

        /* renamed from: b, reason: collision with root package name */
        public final List<String> f22639b = new ArrayList();

        public e(Context context) {
            this.f22638a = context;
        }

        public void a(String str) {
            this.f22639b.add(str);
            notifyDataSetChanged();
        }

        public void b() {
            this.f22639b.clear();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f22639b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return this.f22639b.get(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            TextView textView;
            if (view == null) {
                textView = new TextView(this.f22638a);
                textView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                int d10 = AbstractC0953a.d(12.0f, SpringConfiguratorView.this.getResources());
                textView.setPadding(d10, d10, d10, d10);
                textView.setTextColor(SpringConfiguratorView.this.f22628g);
            } else {
                textView = (TextView) view;
            }
            textView.setText(this.f22639b.get(i10));
            return textView;
        }
    }

    public SpringConfiguratorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final View n(Context context) {
        Resources resources = getResources();
        int d10 = AbstractC0953a.d(5.0f, resources);
        int d11 = AbstractC0953a.d(10.0f, resources);
        int d12 = AbstractC0953a.d(20.0f, resources);
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMargins(0, 0, d10, 0);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(AbstractC0953a.a(-1, AbstractC0953a.d(300.0f, resources)));
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams b10 = AbstractC0953a.b();
        b10.setMargins(0, d12, 0, 0);
        frameLayout2.setLayoutParams(b10);
        frameLayout2.setBackgroundColor(Color.argb(100, 0, 0, 0));
        frameLayout.addView(frameLayout2);
        this.f22631j = new Spinner(context, 0);
        FrameLayout.LayoutParams c10 = AbstractC0953a.c();
        c10.gravity = 48;
        c10.setMargins(d11, d11, d11, 0);
        this.f22631j.setLayoutParams(c10);
        frameLayout2.addView(this.f22631j);
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams c11 = AbstractC0953a.c();
        c11.setMargins(0, 0, 0, AbstractC0953a.d(80.0f, resources));
        c11.gravity = 80;
        linearLayout.setLayoutParams(c11);
        linearLayout.setOrientation(1);
        frameLayout2.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context);
        FrameLayout.LayoutParams c12 = AbstractC0953a.c();
        c12.setMargins(d11, d11, d11, d12);
        linearLayout2.setPadding(d11, d11, d11, d11);
        linearLayout2.setLayoutParams(c12);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2);
        SeekBar seekBar = new SeekBar(context);
        this.f22629h = seekBar;
        seekBar.setLayoutParams(layoutParams);
        linearLayout2.addView(this.f22629h);
        TextView textView = new TextView(getContext());
        this.f22633l = textView;
        textView.setTextColor(this.f22628g);
        FrameLayout.LayoutParams a10 = AbstractC0953a.a(AbstractC0953a.d(50.0f, resources), -1);
        this.f22633l.setGravity(19);
        this.f22633l.setLayoutParams(a10);
        this.f22633l.setMaxLines(1);
        linearLayout2.addView(this.f22633l);
        LinearLayout linearLayout3 = new LinearLayout(context);
        FrameLayout.LayoutParams c13 = AbstractC0953a.c();
        c13.setMargins(d11, d11, d11, d12);
        linearLayout3.setPadding(d11, d11, d11, d11);
        linearLayout3.setLayoutParams(c13);
        linearLayout3.setOrientation(0);
        linearLayout.addView(linearLayout3);
        SeekBar seekBar2 = new SeekBar(context);
        this.f22630i = seekBar2;
        seekBar2.setLayoutParams(layoutParams);
        linearLayout3.addView(this.f22630i);
        TextView textView2 = new TextView(getContext());
        this.f22632k = textView2;
        textView2.setTextColor(this.f22628g);
        FrameLayout.LayoutParams a11 = AbstractC0953a.a(AbstractC0953a.d(50.0f, resources), -1);
        this.f22632k.setGravity(19);
        this.f22632k.setLayoutParams(a11);
        this.f22632k.setMaxLines(1);
        linearLayout3.addView(this.f22632k);
        View view = new View(context);
        FrameLayout.LayoutParams a12 = AbstractC0953a.a(AbstractC0953a.d(60.0f, resources), AbstractC0953a.d(40.0f, resources));
        a12.gravity = 49;
        view.setLayoutParams(a12);
        view.setOnTouchListener(new b());
        view.setBackgroundColor(Color.argb(255, 0, 164, 209));
        frameLayout.addView(view);
        return frameLayout;
    }

    public void o() {
        Map<h, String> b10 = this.f22627f.b();
        this.f22622a.b();
        this.f22623b.clear();
        for (Map.Entry<h, String> entry : b10.entrySet()) {
            if (entry.getKey() != h.f12775c) {
                this.f22623b.add(entry.getKey());
                this.f22622a.a(entry.getValue());
            }
        }
        this.f22623b.add(h.f12775c);
        this.f22622a.a(b10.get(h.f12775c));
        this.f22622a.notifyDataSetChanged();
        if (this.f22623b.size() > 0) {
            this.f22631j.setSelection(0);
        }
    }

    public final void p() {
        double e10 = this.f22624c.e();
        g gVar = this.f22624c;
        double d10 = 1.0d;
        if (e10 == 1.0d) {
            d10 = 0.0d;
        }
        gVar.n(d10);
    }

    public final void q(h hVar) {
        int round = Math.round(((((float) c4.e.c(hVar.f12777b)) - 0.0f) * 100000.0f) / 200.0f);
        int round2 = Math.round(((((float) c4.e.b(hVar.f12776a)) - 0.0f) * 100000.0f) / 50.0f);
        this.f22629h.setProgress(round);
        this.f22630i.setProgress(round2);
    }

    public SpringConfiguratorView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f22623b = new ArrayList();
        this.f22628g = Color.argb(255, 225, 225, 225);
        l h10 = l.h();
        this.f22627f = i.c();
        e eVar = new e(context);
        this.f22622a = eVar;
        Resources resources = getResources();
        this.f22626e = AbstractC0953a.d(40.0f, resources);
        float d10 = AbstractC0953a.d(280.0f, resources);
        this.f22625d = d10;
        g c10 = h10.c();
        this.f22624c = c10;
        c10.l(1.0d).n(1.0d).a(new c());
        addView(n(context));
        d dVar = new d();
        this.f22629h.setMax(100000);
        this.f22629h.setOnSeekBarChangeListener(dVar);
        this.f22630i.setMax(100000);
        this.f22630i.setOnSeekBarChangeListener(dVar);
        this.f22631j.setAdapter((SpinnerAdapter) eVar);
        this.f22631j.setOnItemSelectedListener(new f());
        o();
        setTranslationY(d10);
    }

    /* loaded from: classes3.dex */
    public class c implements j {
        public c() {
        }

        @Override // c4.j
        public void onSpringUpdate(g gVar) {
            float c10 = (float) gVar.c();
            float f10 = SpringConfiguratorView.this.f22626e;
            SpringConfiguratorView.this.setTranslationY((c10 * (SpringConfiguratorView.this.f22625d - f10)) + f10);
        }

        @Override // c4.j
        public void onSpringActivate(g gVar) {
        }

        @Override // c4.j
        public void onSpringAtRest(g gVar) {
        }

        @Override // c4.j
        public void onSpringEndStateChange(g gVar) {
        }
    }

    /* loaded from: classes3.dex */
    public class d implements SeekBar.OnSeekBarChangeListener {
        public d() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (seekBar == SpringConfiguratorView.this.f22629h) {
                double d10 = ((i10 * 200.0f) / 100000.0f) + 0.0f;
                SpringConfiguratorView.this.f22634m.f12777b = c4.e.d(d10);
                String format = SpringConfiguratorView.f22621n.format(d10);
                SpringConfiguratorView.this.f22633l.setText("T:" + format);
            }
            if (seekBar == SpringConfiguratorView.this.f22630i) {
                double d11 = ((i10 * 50.0f) / 100000.0f) + 0.0f;
                SpringConfiguratorView.this.f22634m.f12776a = c4.e.a(d11);
                String format2 = SpringConfiguratorView.f22621n.format(d11);
                SpringConfiguratorView.this.f22632k.setText("F:" + format2);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements AdapterView.OnItemSelectedListener {
        public f() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            SpringConfiguratorView springConfiguratorView = SpringConfiguratorView.this;
            springConfiguratorView.f22634m = (h) springConfiguratorView.f22623b.get(i10);
            SpringConfiguratorView springConfiguratorView2 = SpringConfiguratorView.this;
            springConfiguratorView2.q(springConfiguratorView2.f22634m);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }
}
