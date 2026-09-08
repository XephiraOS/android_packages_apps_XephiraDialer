package x0;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.contacts.framework.baseui.widget.CheckableConstraintLayout;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.oplus.dialer.R;

/* compiled from: ContactsMainListItemBindingImpl.java */
/* loaded from: classes.dex */
public class j extends AbstractC1671i {

    /* renamed from: R, reason: collision with root package name */
    public static final ViewDataBinding.i f37728R = null;

    /* renamed from: S, reason: collision with root package name */
    public static final SparseIntArray f37729S;

    /* renamed from: Q, reason: collision with root package name */
    public long f37730Q;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37729S = sparseIntArray;
        sparseIntArray.put(R.id.photo_view, 5);
        sparseIntArray.put(R.id.check_box_view, 6);
        sparseIntArray.put(R.id.data_layout, 7);
        sparseIntArray.put(R.id.divider, 8);
    }

    public j(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 9, f37728R, f37729S));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        Drawable drawable;
        String str;
        int i10;
        boolean z10;
        long j11;
        long j12;
        synchronized (this) {
            j10 = this.f37730Q;
            this.f37730Q = 0L;
        }
        com.oplus.contacts.list.f fVar = this.f37727P;
        long j13 = j10 & 3;
        String str2 = null;
        int i11 = 0;
        if (j13 != 0) {
            if (fVar != null) {
                Drawable e10 = fVar.e();
                String j14 = fVar.j();
                str = fVar.f();
                z10 = fVar.q();
                drawable = e10;
                str2 = j14;
            } else {
                drawable = null;
                str = null;
                z10 = false;
            }
            if (j13 != 0) {
                if (z10) {
                    j12 = 32;
                } else {
                    j12 = 16;
                }
                j10 |= j12;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            if ((j10 & 3) != 0) {
                if (isEmpty) {
                    j11 = 8;
                } else {
                    j11 = 4;
                }
                j10 |= j11;
            }
            if (isEmpty) {
                i11 = 8;
            }
        } else {
            drawable = null;
            str = null;
            i10 = 0;
        }
        if ((j10 & 3) != 0) {
            L.c.e(this.f37721J, str2);
            this.f37721J.setVisibility(i11);
            com.oplus.contacts.list.g.c(this.f37723L, fVar);
            L.c.c(this.f37725N, drawable);
            L.c.e(this.f37725N, str);
            this.f37725N.setVisibility(i10);
            com.oplus.contacts.list.g.a(this.f37726O, fVar);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37730Q != 0) {
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
            this.f37730Q = 2L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (4 == i10) {
            i1((com.oplus.contacts.list.f) obj);
            return true;
        }
        return false;
    }

    @Override // x0.AbstractC1671i
    public void i1(com.oplus.contacts.list.f fVar) {
        this.f37727P = fVar;
        synchronized (this) {
            this.f37730Q |= 1;
        }
        r0(4);
        super.W0();
    }

    public j(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (CheckBox) objArr[6], (CheckableConstraintLayout) objArr[0], (LinearLayout) objArr[7], (TextView) objArr[4], (ImageView) objArr[8], (TextView) objArr[1], (COUIRoundImageView) objArr[5], (TextView) objArr[3], (TextView) objArr[2]);
        this.f37730Q = -1L;
        this.f37719H.setTag(null);
        this.f37721J.setTag(null);
        this.f37723L.setTag(null);
        this.f37725N.setTag(null);
        this.f37726O.setTag(null);
        c1(view);
        O0();
    }
}
