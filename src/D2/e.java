package D2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.incallui.Log;
import com.android.incallui.R;
import com.coui.appcompat.contextutil.COUIContextUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: OplusInterceptSelectionAdapter.java */
/* loaded from: classes.dex */
public class e extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public Context f429a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String> f430b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, a> f431c = new HashMap<>();

    /* compiled from: OplusInterceptSelectionAdapter.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f432a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f433b;

        public a(boolean z10, boolean z11) {
            this.f432a = z10;
            this.f433b = z11;
        }
    }

    /* compiled from: OplusInterceptSelectionAdapter.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public CheckBox f435a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f436b;
    }

    public e(Context context, ArrayList arrayList) {
        this.f429a = context;
        this.f430b = arrayList;
        b();
    }

    public a a(int i10) {
        return this.f431c.get(String.valueOf(i10));
    }

    public void b() {
        HashMap<String, a> hashMap = this.f431c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void c(int i10, a aVar) {
        this.f431c.put(String.valueOf(i10), aVar);
    }

    public void d(int i10, boolean z10, boolean z11) {
        Log.d("OplusInterceptSelectionAdapter", "setState: position = " + i10 + ", isChecked = " + z10 + ", isEnabled = " + z11);
        this.f431c.put(String.valueOf(i10), new a(z10, z11));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Log.d("OplusInterceptSelectionAdapter", "getCount = " + this.f430b.size());
        return this.f430b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        if (this.f430b.size() != 0) {
            return this.f430b.get(i10);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f429a).inflate(R.layout.oplus_intercept_selection_item, (ViewGroup) null);
            bVar = new b();
            bVar.f435a = (CheckBox) view.findViewById(R.id.checkBox);
            bVar.f436b = (TextView) view.findViewById(R.id.text);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f435a = (CheckBox) view.findViewById(R.id.checkBox);
        if (this.f431c.get(String.valueOf(i10)) == null) {
            d(i10, false, true);
        }
        bVar.f435a.setChecked(this.f431c.get(String.valueOf(i10)).f432a);
        if (this.f430b.size() > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) bVar.f436b.getLayoutParams();
            bVar.f436b.setText(this.f430b.get(i10));
            if (this.f431c.get(String.valueOf(i10)).f433b) {
                bVar.f435a.setVisibility(0);
                bVar.f436b.setTextColor(COUIContextUtil.getAttrColor(this.f429a, R.attr.couiColorPrimaryNeutral, 0));
                layoutParams.setMarginStart(this.f429a.getResources().getDimensionPixelSize(R.dimen.oplus_textview_margin_checkbox));
            } else {
                bVar.f435a.setVisibility(8);
                bVar.f436b.setTextColor(COUIContextUtil.getAttrColor(this.f429a, R.attr.couiColorDisabledNeutral, 0));
                layoutParams.setMarginStart(this.f429a.getResources().getDimensionPixelSize(R.dimen.oplus_textview_margin_start));
            }
            bVar.f436b.setLayoutParams(layoutParams);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i10) {
        a a10 = a(i10);
        if (a10 == null) {
            return true;
        }
        return a10.f433b;
    }
}
