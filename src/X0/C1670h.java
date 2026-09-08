package x0;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.coui.appcompat.imageview.COUIRoundImageView;
import com.oplus.contacts.list.ContactsMainListHeaderView;

/* compiled from: ContactsMainListHeaderViewBindingImpl.java */
/* renamed from: x0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1670h extends AbstractC1669g {

    /* renamed from: P, reason: collision with root package name */
    public static final ViewDataBinding.i f37714P = null;

    /* renamed from: Q, reason: collision with root package name */
    public static final SparseIntArray f37715Q = null;

    /* renamed from: N, reason: collision with root package name */
    public final ContactsMainListHeaderView f37716N;

    /* renamed from: O, reason: collision with root package name */
    public long f37717O;

    public C1670h(androidx.databinding.f fVar, View view) {
        this(fVar, view, ViewDataBinding.R0(fVar, view, 7, f37714P, f37715Q));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void A0() {
        long j10;
        float f10;
        boolean z10;
        long j11;
        synchronized (this) {
            j10 = this.f37717O;
            this.f37717O = 0L;
        }
        Boolean bool = this.f37713M;
        long j12 = j10 & 3;
        if (j12 != 0) {
            boolean Z02 = ViewDataBinding.Z0(bool);
            if (j12 != 0) {
                if (Z02) {
                    j11 = 8;
                } else {
                    j11 = 4;
                }
                j10 |= j11;
            }
            if (Z02) {
                f10 = 0.3f;
            } else {
                f10 = 1.0f;
            }
            z10 = ViewDataBinding.Z0(Boolean.valueOf(!Z02));
        } else {
            f10 = 0.0f;
            z10 = false;
        }
        if ((j10 & 3) != 0) {
            this.f37707G.setEnabled(z10);
            this.f37709I.setEnabled(z10);
            this.f37710J.setEnabled(z10);
            this.f37712L.setEnabled(z10);
            if (ViewDataBinding.I0() >= 11) {
                this.f37708H.setAlpha(f10);
                this.f37711K.setAlpha(f10);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean M0() {
        synchronized (this) {
            try {
                if (this.f37717O != 0) {
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
            this.f37717O = 2L;
        }
        W0();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean S0(int i10, Object obj, int i11) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean d1(int i10, Object obj) {
        if (6 == i10) {
            k1((Boolean) obj);
            return true;
        }
        return false;
    }

    @Override // x0.AbstractC1669g
    public void k1(Boolean bool) {
        this.f37713M = bool;
        synchronized (this) {
            this.f37717O |= 1;
        }
        r0(6);
        super.W0();
    }

    public C1670h(androidx.databinding.f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (RelativeLayout) objArr[4], (COUIRoundImageView) objArr[5], (TextView) objArr[6], (RelativeLayout) objArr[1], (COUIRoundImageView) objArr[2], (TextView) objArr[3]);
        this.f37717O = -1L;
        ContactsMainListHeaderView contactsMainListHeaderView = (ContactsMainListHeaderView) objArr[0];
        this.f37716N = contactsMainListHeaderView;
        contactsMainListHeaderView.setTag(null);
        this.f37707G.setTag(null);
        this.f37708H.setTag(null);
        this.f37709I.setTag(null);
        this.f37710J.setTag(null);
        this.f37711K.setTag(null);
        this.f37712L.setTag(null);
        c1(view);
        O0();
    }
}
