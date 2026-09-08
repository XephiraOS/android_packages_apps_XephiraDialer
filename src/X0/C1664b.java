package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.COUICollapsingToolbarLayout;
import com.oplus.contacts.list.widget.ContactsMainListCollapsableAppBarLayout;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.SuitableSizeTextView;

/* compiled from: ContactsMainListCollapsingAppbarLayoutBindingImpl.java */
/* renamed from: x0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1664b extends AbstractC1663a {

    /* renamed from: N, reason: collision with root package name */
    public static final ViewDataBinding.i f37689N = null;

    /* renamed from: O, reason: collision with root package name */
    public static final SparseIntArray f37690O;

    /* renamed from: M, reason: collision with root package name */
    public long f37691M;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37690O = sparseIntArray;
        sparseIntArray.put(R.id.collapsingToolbarLayout, 1);
        sparseIntArray.put(R.id.coui_toolbar, 2);
        sparseIntArray.put(R.id.coui_appbar_subtitle_content, 3);
        sparseIntArray.put(R.id.subtitle_icon, 4);
        sparseIntArray.put(R.id.coui_appbar_subtitle_text_view, 5);
    }

    public C1664b(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 6, f37689N, f37690O));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        synchronized (this) {
            this.f37691M = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37691M != 0) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void O0() {
        synchronized (this) {
            this.f37691M = 1L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        return true;
    }

    public C1664b(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ContactsMainListCollapsableAppBarLayout) objArr[0], (COUICollapsingToolbarLayout) objArr[1], (ConstraintLayout) objArr[3], (SuitableSizeTextView) objArr[5], (COUIToolbar) objArr[2], (ImageView) objArr[4]);
        this.f37691M = -1L;
        this.f37683G.setTag(null);
        c1(view);
        O0();
    }
}
