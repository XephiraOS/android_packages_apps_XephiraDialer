package com.android.contacts.Engineer;

import G0.c;
import H7.b;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.ActionBar;
import com.android.contacts.compat.data.f;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.incallui.OplusSpecialNumberUtils;
import com.coui.appcompat.couiswitch.COUISwitch;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;
import java.io.IOException;
import java.util.ArrayList;
import o0.C1388a;
import o0.C1389b;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class CommonLogSwitchActivity extends BasicActivity implements AdapterView.OnItemClickListener {

    /* renamed from: o, reason: collision with root package name */
    public COUIListView f13126o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList<C1389b> f13127p;

    /* renamed from: q, reason: collision with root package name */
    public C1388a f13128q;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBarLayout f13129a;

        public a(AppBarLayout appBarLayout) {
            this.f13129a = appBarLayout;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f13129a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredHeight = this.f13129a.getMeasuredHeight() + CommonLogSwitchActivity.this.getResources().getDimensionPixelSize(R.dimen.list_padding_top);
            CommonLogSwitchActivity.this.f13126o.setPadding(0, measuredHeight, 0, CommonLogSwitchActivity.this.getResources().getDimensionPixelSize(R.dimen.DP_54));
            CommonLogSwitchActivity.this.f13126o.smoothScrollByOffset(-measuredHeight);
        }
    }

    private void init() {
        this.f13127p = new ArrayList<>();
        r1();
        C1388a c1388a = new C1388a(this, this.f13127p);
        this.f13128q = c1388a;
        this.f13126o.setAdapter((ListAdapter) c1388a);
        this.f13126o.setOnItemClickListener(this);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.common_log_switch);
        setSupportActionBar((COUIToolbar) findViewById(R.id.toolbar));
        q1();
        this.f13126o = (COUIListView) findViewById(android.R.id.list);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new a(appBarLayout));
        this.f13126o.setNestedScrollingEnabled(true);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        COUISwitch cOUISwitch = (COUISwitch) view.findViewById(R.id.customize_switch);
        boolean z10 = !cOUISwitch.isChecked();
        cOUISwitch.setChecked(z10);
        C1389b c1389b = this.f13127p.get(i10);
        String d10 = c1389b.d();
        if ("opluswirelesssettings.log.switch".equals(d10) || "oplussimsettings.log.switch".equals(d10)) {
            d10 = f.b(d10);
        }
        try {
            c.n(this, 0, d10, z10 ? 1 : 0);
        } catch (Throwable th) {
            b.c("CommonLogSwitchActivity", "th = " + th);
        }
        String str = d10 + ".broadcast";
        Intent intent = new Intent(str);
        intent.putExtra(d10, z10);
        intent.putExtra("ext_int", c1389b.c());
        sendBroadcast(intent, R0.b.f3175i);
        b.e("CommonLogSwitchActivity", "action = " + str);
        this.f13128q.notifyDataSetChanged();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        init();
    }

    public final void q1() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
        }
    }

    public final void r1() {
        XmlResourceParser xml = getResources().getXml(R.xml.comm_app_list);
        setTitle(R.string.oplus_log_switch_comm);
        if (xml != null) {
            while (xml.getEventType() != 1) {
                try {
                    try {
                        try {
                            if (xml.getEventType() == 2 && xml.getName().endsWith("app")) {
                                String str = null;
                                String str2 = null;
                                String str3 = null;
                                String str4 = null;
                                int i10 = -1;
                                for (int i11 = 0; i11 <= 4; i11++) {
                                    String attributeName = xml.getAttributeName(i11);
                                    if (OplusSpecialNumberUtils.OplusSpecialNumColumns.EN_NAME.equals(attributeName)) {
                                        str = xml.getAttributeValue(i11);
                                    } else if (OplusSpecialNumberUtils.OplusSpecialNumColumns.CN_NAME.equals(attributeName)) {
                                        str2 = xml.getAttributeValue(i11);
                                    } else if (OplusSpecialNumberUtils.OplusSpecialNumColumns.TW_NAME.equals(attributeName)) {
                                        str3 = xml.getAttributeValue(i11);
                                    } else if ("switch".equals(attributeName)) {
                                        str4 = xml.getAttributeValue(i11);
                                    } else if ("ext_int".equals(attributeName)) {
                                        i10 = Integer.parseInt(xml.getAttributeValue(i11));
                                    }
                                }
                                this.f13127p.add(new C1389b(str, str2, str3, str4, i10));
                            }
                            xml.next();
                        } catch (IOException e10) {
                            b.c("CommonLogSwitchActivity", "IOException: " + e10);
                        }
                    } catch (XmlPullParserException e11) {
                        b.c("CommonLogSwitchActivity", "XmlPullParserException: " + e11);
                    } catch (Throwable th) {
                        b.c("CommonLogSwitchActivity", "Throwable: " + th);
                    }
                } catch (Throwable th2) {
                    xml.close();
                    throw th2;
                }
            }
        }
        if (xml == null) {
            return;
        }
        xml.close();
    }
}
