package m1;

import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.coui.appcompat.searchview.COUISearchBar;
import com.oplus.dialer.R;

/* compiled from: EmailAddressPickerFragment.java */
/* loaded from: classes.dex */
public class G extends AbstractViewOnFocusChangeListenerC1314j<AbstractC1311g> {

    /* renamed from: q0, reason: collision with root package name */
    public N f34840q0;

    public G() {
        n2(false);
        k2(true);
        p2(true);
        c2(3);
    }

    public void A2(N n10) {
        this.f34840q0 = n10;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void R1(int i10, long j10) {
        z2(((F) m1()).O0(i10));
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        COUISearchBar cOUISearchBar;
        super.S0(cVar, cursor);
        if (cursor != null && cursor.getCount() > 0) {
            COUISearchBar cOUISearchBar2 = this.f34972l;
            if (cOUISearchBar2 != null) {
                cOUISearchBar2.setVisibility(0);
                return;
            }
            return;
        }
        if (!J1() && (cOUISearchBar = this.f34972l) != null) {
            cOUISearchBar.setVisibility(4);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public AbstractC1311g k1() {
        F f10 = new F(getActivity());
        f10.P(true);
        f10.w0(true);
        return f10;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public View z1(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.contact_list_content, (ViewGroup) null);
    }

    public final void z2(Uri uri) {
        this.f34840q0.a(uri);
    }
}
