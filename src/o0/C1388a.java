package o0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.coui.appcompat.couiswitch.COUISwitch;
import com.customize.contacts.util.K;
import com.oplus.dialer.R;
import java.util.ArrayList;

/* compiled from: AppListAdapter.java */
/* renamed from: o0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1388a extends ArrayAdapter<C1389b> {

    /* renamed from: a, reason: collision with root package name */
    public final LayoutInflater f35656a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f35657b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<C1389b> f35658c;

    /* renamed from: d, reason: collision with root package name */
    public final int f35659d;

    public C1388a(Context context, ArrayList<C1389b> arrayList) {
        super(context, R.layout.app_item, arrayList);
        this.f35657b = context;
        this.f35658c = arrayList;
        this.f35656a = LayoutInflater.from(context);
        this.f35659d = a();
    }

    public final int a() {
        String a10 = K.a();
        if (!a10.startsWith("zh-Hans") && !a10.equalsIgnoreCase("zh-CN")) {
            if (!a10.equalsIgnoreCase("zh-Hant-TW") && !a10.equalsIgnoreCase("zh-TW")) {
                return 1;
            }
            return 3;
        }
        return 2;
    }

    public final boolean b(String str) {
        if ("opluswirelesssettings.log.switch".equals(str) || "oplussimsettings.log.switch".equals(str)) {
            str = com.android.contacts.compat.data.f.b(str);
        }
        H7.b.e("AppListAdapter", "tag = " + str);
        if (G0.c.d(this.f35657b, 0, str, 0) != 1) {
            return false;
        }
        return true;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f35656a.inflate(R.layout.app_item, viewGroup, false);
        }
        C1389b c1389b = this.f35658c.get(i10);
        TextView textView = (TextView) view.findViewById(R.id.name);
        int i11 = this.f35659d;
        if (3 == i11) {
            textView.setText(c1389b.e());
        } else if (2 == i11) {
            textView.setText(c1389b.a());
        } else {
            textView.setText(c1389b.b());
        }
        COUISwitch cOUISwitch = (COUISwitch) view.findViewById(R.id.customize_switch);
        boolean b10 = b(c1389b.d());
        cOUISwitch.setChecked(b10);
        if (H7.a.b()) {
            H7.b.e("AppListAdapter", "name = " + ((Object) textView.getText()) + " checked = " + b10);
        }
        return view;
    }
}
