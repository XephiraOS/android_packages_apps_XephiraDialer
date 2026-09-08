package S3;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import com.android.contacts.framework.baseui.util.A;
import com.customize.contacts.camera.GridLineViewGroup;
import com.customize.contacts.widget.FinderView;
import com.customize.contacts.widget.ScrollTabLayout;

/* compiled from: UiSwitcher.java */
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3476a;

    /* renamed from: b, reason: collision with root package name */
    public GridLineViewGroup f3477b;

    /* renamed from: c, reason: collision with root package name */
    public View f3478c;

    /* renamed from: d, reason: collision with root package name */
    public FinderView f3479d;

    /* renamed from: e, reason: collision with root package name */
    public ScrollTabLayout f3480e;

    /* renamed from: f, reason: collision with root package name */
    public ScrollTabLayout f3481f;

    /* renamed from: g, reason: collision with root package name */
    public ImageButton f3482g;

    public p(Context context, GridLineViewGroup gridLineViewGroup, View view, FinderView finderView, ScrollTabLayout scrollTabLayout, ScrollTabLayout scrollTabLayout2, ImageButton imageButton) {
        this.f3476a = context;
        this.f3477b = gridLineViewGroup;
        this.f3478c = view;
        this.f3479d = finderView;
        this.f3480e = scrollTabLayout;
        this.f3481f = scrollTabLayout2;
        this.f3482g = imageButton;
    }

    public void a() {
        this.f3482g.setEnabled(true);
        this.f3482g.setImportantForAccessibility(1);
        this.f3477b.setVisibility(0);
        this.f3479d.setVisibility(4);
        H7.b.b("UiSwitcher", "switchToBusinessCard");
    }

    public void b() {
        this.f3479d.setVisibility(0);
        this.f3482g.setEnabled(false);
        this.f3482g.setImportantForAccessibility(2);
        this.f3477b.setVisibility(4);
        A.a(this.f3476a, 2000324, 200032402, null, false);
        H7.b.b("UiSwitcher", "switchToQrcode");
    }

    public void c() {
        ScrollTabLayout scrollTabLayout = this.f3480e;
        if (scrollTabLayout != null) {
            scrollTabLayout.setVisibility(0);
        }
        ScrollTabLayout scrollTabLayout2 = this.f3481f;
        if (scrollTabLayout2 != null) {
            scrollTabLayout2.setVisibility(0);
        }
        this.f3478c.setVisibility(0);
        H7.b.b("UiSwitcher", "switchToVersionCn");
    }

    public void d() {
        ScrollTabLayout scrollTabLayout = this.f3480e;
        if (scrollTabLayout != null) {
            scrollTabLayout.setVisibility(8);
        }
        ScrollTabLayout scrollTabLayout2 = this.f3481f;
        if (scrollTabLayout2 != null) {
            scrollTabLayout2.setVisibility(8);
        }
        this.f3478c.setVisibility(8);
        H7.b.b("UiSwitcher", "switchToVersionUs");
    }
}
