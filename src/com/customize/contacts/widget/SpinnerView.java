package com.customize.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.PopupListItem;
import com.customize.contacts.widget.p;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SpinnerView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public COUIPopupListWindow f22436a;

    /* renamed from: b, reason: collision with root package name */
    public d f22437b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f22438c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f22439d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<PopupListItem> f22440e;

    /* renamed from: f, reason: collision with root package name */
    public p.a f22441f;

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            SpinnerView.this.f22441f.a(Integer.valueOf(i10));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements PopupWindow.OnDismissListener {
        public c() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            SpinnerView spinnerView = SpinnerView.this;
            spinnerView.f22436a = null;
            spinnerView.setupExpansionView(true);
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void onItemSelected(int i10);
    }

    public SpinnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22437b = null;
        this.f22441f = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setupExpansionView(boolean z10) {
        this.f22439d.setImageResource(R.drawable.pb_ic_expander_minimized);
        ViewPropertyAnimator interpolator = this.f22439d.animate().setDuration(400L).setInterpolator(Z3.f.f5907g);
        if (z10) {
            interpolator.rotation(0.0f).start();
        } else {
            interpolator.rotation(180.0f).start();
        }
    }

    public final COUIPopupListWindow b(ArrayList<PopupListItem> arrayList) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.DP_10);
        COUIPopupListWindow cOUIPopupListWindow = new COUIPopupListWindow(getContext());
        cOUIPopupListWindow.setInputMethodMode(2);
        cOUIPopupListWindow.setItemList(arrayList);
        cOUIPopupListWindow.setDismissTouchOutside(true);
        cOUIPopupListWindow.setOnItemClickListener(new b());
        cOUIPopupListWindow.setOnDismissListener(new c());
        cOUIPopupListWindow.setOffset(0, -dimensionPixelSize, getWidth() / 2, 0);
        return cOUIPopupListWindow;
    }

    public void c() {
        COUIPopupListWindow cOUIPopupListWindow = this.f22436a;
        if (cOUIPopupListWindow != null) {
            cOUIPopupListWindow.dismiss();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        TextView textView = (TextView) findViewById(R.id.text_view);
        this.f22438c = textView;
        com.oplus.foundation.util.ui.d.d(textView, 3);
        this.f22439d = (ImageView) findViewById(R.id.spinner_expansion_view);
    }

    @Override // android.view.View
    public boolean performClick() {
        COUIPopupListWindow b10 = b(this.f22440e);
        this.f22436a = b10;
        b10.show(this);
        setupExpansionView(false);
        return true;
    }

    public void setItemList(ArrayList<PopupListItem> arrayList) {
        this.f22440e = new ArrayList<>(arrayList);
        COUIPopupListWindow cOUIPopupListWindow = this.f22436a;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.isShowing()) {
            this.f22436a.setItemList(this.f22440e);
        }
    }

    public void setOnItemSelectedListener(d dVar) {
        this.f22437b = dVar;
    }

    public void setText(CharSequence charSequence) {
        this.f22438c.setText(charSequence);
    }

    /* loaded from: classes3.dex */
    public class a implements p.a {
        public a() {
        }

        @Override // com.customize.contacts.widget.p.a
        public void a(Object obj) {
            SpinnerView.this.f22437b.onItemSelected(((Integer) obj).intValue());
            COUIPopupListWindow cOUIPopupListWindow = SpinnerView.this.f22436a;
            if (cOUIPopupListWindow != null) {
                cOUIPopupListWindow.dismiss();
            }
        }

        @Override // com.customize.contacts.widget.p.a
        public void b() {
        }

        @Override // com.customize.contacts.widget.p.a
        public void c() {
        }
    }
}
