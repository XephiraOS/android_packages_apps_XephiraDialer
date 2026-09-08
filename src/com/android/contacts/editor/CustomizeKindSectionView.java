package com.android.contacts.editor;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.contacts.editor.A;
import com.android.contacts.editor.RawContactEditorView;
import com.android.contacts.framework.baseui.widget.SelectedCardView;
import com.android.contacts.model.EntityDelta;
import com.oplus.dialer.R;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CustomizeKindSectionView extends SelectedCardView implements A.a {

    /* renamed from: c, reason: collision with root package name */
    public ViewGroup f15204c;

    /* renamed from: d, reason: collision with root package name */
    public String f15205d;

    /* renamed from: e, reason: collision with root package name */
    public com.android.contacts.model.c f15206e;

    /* renamed from: f, reason: collision with root package name */
    public EntityDelta f15207f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15208g;

    /* renamed from: h, reason: collision with root package name */
    public ViewIdGenerator f15209h;

    /* renamed from: i, reason: collision with root package name */
    public LayoutInflater f15210i;

    /* renamed from: j, reason: collision with root package name */
    public RawContactEditorView.b f15211j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f15212k;

    /* renamed from: l, reason: collision with root package name */
    public A f15213l;

    public CustomizeKindSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View a(EntityDelta.ValuesDelta valuesDelta) {
        try {
            View inflate = this.f15210i.inflate(this.f15206e.f17002a, this.f15204c, false);
            inflate.setEnabled(isEnabled());
            if (inflate instanceof A) {
                A a10 = (A) inflate;
                a10.setDeletable(true);
                a10.g(this.f15206e, valuesDelta, this.f15207f, this.f15208g, this.f15209h);
                a10.setEditorListener(this);
                this.f15213l = a10;
            }
            this.f15204c.addView(inflate);
            return inflate;
        } catch (Exception e10) {
            throw new RuntimeException("Cannot allocate editor with layout resource ID " + this.f15206e.f17002a + " for MIME type " + this.f15206e.f17004c + " with error " + e10.toString());
        }
    }

    public final boolean b(EntityDelta.ValuesDelta valuesDelta) {
        if (!valuesDelta.M()) {
            return false;
        }
        int size = this.f15206e.f17018q.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!TextUtils.isEmpty(valuesDelta.z(this.f15206e.f17018q.get(i10).f16953a))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.android.contacts.editor.A.a
    public void c(int i10) {
        if (i10 == 3 || i10 == 4) {
            j();
        }
    }

    @Override // com.android.contacts.editor.A.a
    public void d(A a10) {
        if (getEditorCount() == 1) {
            a10.c();
        } else {
            a10.a();
        }
        j();
    }

    @Override // com.android.contacts.editor.A.a
    public void e(String str) {
        RawContactEditorView.b bVar = this.f15211j;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public void f() {
        this.f15204c.removeAllViews();
        boolean Q10 = this.f15207f.Q(this.f15206e.f17004c);
        if (H7.a.b()) {
            H7.b.b("CustomizeKindSectionView", "KindSectionView---rebuildFromState--mimeType=" + this.f15206e.f17004c);
        }
        if (Q10) {
            Iterator<EntityDelta.ValuesDelta> it = this.f15207f.D(this.f15206e.f17004c).iterator();
            while (it.hasNext()) {
                EntityDelta.ValuesDelta next = it.next();
                if (next.R() && !b(next)) {
                    if (H7.a.b()) {
                        H7.b.b("CustomizeKindSectionView", "KindSectionView---rebuildFromState--createEditorView");
                    }
                    a(next);
                    if ("vnd.android.cursor.item/organization".equals(this.f15206e.f17004c)) {
                        return;
                    }
                }
            }
        }
    }

    public A getEditor() {
        return this.f15213l;
    }

    public int getEditorCount() {
        return this.f15204c.getChildCount();
    }

    public A getOrganizationEditor() {
        ViewGroup viewGroup = this.f15204c;
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            return (A) this.f15204c.getChildAt(0);
        }
        return null;
    }

    public String getTitle() {
        return this.f15205d;
    }

    public final void h() {
        if ("vnd.android.cursor.item/organization".equals(this.f15206e.f17004c)) {
            this.f15212k.setImageResource(R.drawable.pb_ic_organization);
        }
    }

    public void i(com.android.contacts.model.c cVar, EntityDelta entityDelta, boolean z10, ViewIdGenerator viewIdGenerator) {
        String str;
        this.f15206e = cVar;
        this.f15207f = entityDelta;
        this.f15208g = z10;
        this.f15209h = viewIdGenerator;
        setId(viewIdGenerator.d(entityDelta, cVar, null, -1));
        int i10 = cVar.f17005d;
        if (i10 != -1 && i10 != 0) {
            str = getResources().getString(cVar.f17005d);
        } else {
            str = "";
        }
        this.f15205d = str;
        h();
        f();
        j();
        k();
    }

    public final void k() {
        int i10;
        if (getEditorCount() != 0) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        setVisibility(i10);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setDrawingCacheEnabled(true);
        setAlwaysDrawnWithCacheEnabled(true);
        this.f15210i = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.f15204c = (ViewGroup) findViewById(R.id.kind_editors);
        this.f15212k = (ImageView) findViewById(R.id.left_icon_view);
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        ViewGroup viewGroup = this.f15204c;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.f15204c.getChildAt(i10).setEnabled(z10);
            }
        }
        if (z10 && !this.f15208g) {
            if (H7.a.b()) {
                H7.b.b("CustomizeKindSectionView", "KindSectionView-----add visuable");
            }
        } else if (H7.a.b()) {
            H7.b.b("CustomizeKindSectionView", "KindSectionView-----add un-visuable");
        }
    }

    public void setShowOnlyDialogListener(RawContactEditorView.b bVar) {
        this.f15211j = bVar;
    }

    public void j() {
    }
}
