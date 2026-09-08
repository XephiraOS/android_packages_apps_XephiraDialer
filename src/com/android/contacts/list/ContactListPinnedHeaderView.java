package com.android.contacts.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.contacts.ContactsApplication;
import com.android.contacts.V0;
import com.oplus.dialer.R;

/* loaded from: classes.dex */
public class ContactListPinnedHeaderView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16840a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16841b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16842c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16843d;

    /* renamed from: e, reason: collision with root package name */
    public ViewGroup f16844e;

    /* renamed from: f, reason: collision with root package name */
    public int f16845f;

    /* renamed from: g, reason: collision with root package name */
    public int f16846g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f16847h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f16848i;

    /* renamed from: j, reason: collision with root package name */
    public View f16849j;

    /* renamed from: k, reason: collision with root package name */
    public int f16850k;

    public ContactListPinnedHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16848i = null;
        this.f16850k = 0;
        this.f16840a = context;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, V0.f13480n2);
        this.f16841b = obtainStyledAttributes.getDimensionPixelOffset(16, 0);
        this.f16842c = obtainStyledAttributes.getColor(4, -16777216);
        this.f16850k = getResources().getDimensionPixelSize(R.dimen.DP_20);
        this.f16843d = obtainStyledAttributes.getDimensionPixelSize(5, 12);
        obtainStyledAttributes.recycle();
        if (this.f16844e == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.contact_listitem_title, (ViewGroup) null);
            this.f16844e = viewGroup;
            TextView textView = (TextView) viewGroup.findViewById(R.id.title);
            this.f16847h = textView;
            if (ContactsApplication.f13094j) {
                textView.setGravity(5);
            } else {
                textView.setGravity(3);
            }
            this.f16849j = this.f16844e.findViewById(R.id.divider);
            this.f16847h.setAllCaps(true);
            this.f16844e.setVisibility(0);
            setItemBackground(0);
            addView(this.f16844e);
        }
    }

    public final boolean a(View view) {
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14 = i12 - i10;
        int paddingRight = i14 - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        if (a(this.f16848i)) {
            TextView textView = this.f16848i;
            int measuredWidth = (i14 - this.f16841b) - textView.getMeasuredWidth();
            int i15 = this.f16850k;
            textView.layout(measuredWidth - i15, 0, (i14 - this.f16841b) - i15, this.f16846g);
        }
        this.f16844e.layout(paddingLeft, 0, paddingRight, this.f16845f);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int resolveSize = View.resolveSize(0, i10);
        this.f16844e.measure(View.MeasureSpec.makeMeasureSpec(resolveSize, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f16845f = Math.max(this.f16845f, this.f16844e.getMeasuredHeight());
        this.f16846g = Math.max(this.f16846g, this.f16847h.getMeasuredHeight());
        setMeasuredDimension(resolveSize, this.f16845f);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        forceLayout();
    }

    public void setCountView(String str) {
        if (this.f16848i == null) {
            TextView textView = new TextView(this.f16840a);
            this.f16848i = textView;
            textView.setTextColor(this.f16842c);
            this.f16848i.setTextSize(0, this.f16843d);
            this.f16848i.setGravity(16);
            addView(this.f16848i);
        }
        this.f16848i.setText(str);
        if (str != null && !str.isEmpty()) {
            this.f16848i.setVisibility(0);
        } else {
            this.f16848i.setVisibility(8);
        }
    }

    public void setItemBackground(int i10) {
        ViewGroup viewGroup = this.f16844e;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(i10);
        }
    }

    public void setSectionHeader(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.equals(str, "*")) {
                if (ContactsApplication.f13094j) {
                    this.f16847h.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.pb_ic_section_star, 0);
                } else {
                    this.f16847h.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pb_ic_section_star, 0, 0, 0);
                }
                this.f16847h.setText("");
            } else {
                this.f16847h.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.f16847h.setText(str);
            }
            this.f16847h.setVisibility(0);
            View view = this.f16849j;
            if (view != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        this.f16847h.setVisibility(8);
        View view2 = this.f16849j;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }
}
