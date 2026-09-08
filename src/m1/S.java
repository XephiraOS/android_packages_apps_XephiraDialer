package m1;

import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.coui.appcompat.searchview.COUISearchBar;
import com.oplus.dialer.R;

/* compiled from: PostalAddressPickerFragment.java */
/* loaded from: classes.dex */
public class S extends AbstractViewOnFocusChangeListenerC1314j<AbstractC1311g> {

    /* renamed from: q0, reason: collision with root package name */
    public P f34853q0;

    public S() {
        n2(false);
        k2(true);
        p2(true);
        c2(3);
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void A1(View view) {
        super.A1(view);
        this.f34974m = (ImageView) view.findViewById(R.id.no_content);
        TextView textView = (TextView) view.findViewById(R.id.empty_view);
        this.f34964h = textView;
        textView.setText(R.string.noContacts);
        view.findViewById(R.id.search_view).setVisibility(8);
    }

    public void A2(P p10) {
        this.f34853q0 = p10;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public void R1(int i10, long j10) {
        if (!F1()) {
            z2(((Q) m1()).O0(i10));
        } else {
            z2(((K) m1()).L0(i10));
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j, androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1 */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        super.S0(cVar, cursor);
        COUISearchBar cOUISearchBar = this.f34972l;
        if (cOUISearchBar != null) {
            cOUISearchBar.setVisibility(8);
        }
        if (cursor != null && cursor.getCount() > 0) {
            this.f34974m.setVisibility(8);
            this.f34964h.setVisibility(8);
        } else {
            this.f34974m.setImageDrawable(getContext().getDrawable(R.drawable.pb_ic_no_contact));
            this.f34974m.setVisibility(0);
            this.f34964h.setVisibility(0);
        }
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public AbstractC1311g k1() {
        if (!F1()) {
            Q q10 = new Q(getActivity());
            q10.P(true);
            q10.w0(true);
            return q10;
        }
        K k10 = new K(getActivity());
        k10.P(false);
        k10.w0(false);
        return k10;
    }

    @Override // m1.AbstractViewOnFocusChangeListenerC1314j
    public View z1(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.contact_list_content, (ViewGroup) null);
    }

    public final void z2(Uri uri) {
        this.f34853q0.a(uri);
    }
}
