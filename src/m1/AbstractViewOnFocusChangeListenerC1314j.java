package m1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.loader.app.a;
import com.android.contacts.framework.baseui.widget.a;
import com.android.contacts.list.ContactListItemView;
import com.coui.appcompat.searchview.COUISearchBar;
import com.customize.contacts.util.C0806q;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.customize.contacts.util.i0;
import com.customize.contacts.widget.ContactTouchSearchView;
import com.customize.contacts.widget.ContactsHeaderView;
import com.customize.contacts.widget.TouchSearchView;
import com.oplus.dialer.R;
import java.util.HashMap;
import m1.AbstractC1311g;
import m1.AbstractC1316l;
import o1.C1393c;

/* compiled from: ContactEntryListFragment.java */
/* renamed from: m1.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractViewOnFocusChangeListenerC1314j<T extends AbstractC1311g> extends Fragment implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener, View.OnFocusChangeListener, View.OnTouchListener, a.InterfaceC0129a<Cursor>, TouchSearchView.d, AbstractC1316l.a, COUISearchBar.OnStateChangeListener {

    /* renamed from: A, reason: collision with root package name */
    public com.customize.contacts.manager.f f34924A;

    /* renamed from: B, reason: collision with root package name */
    public Z3.i f34925B;

    /* renamed from: C, reason: collision with root package name */
    public DataSetObserver f34926C;

    /* renamed from: F, reason: collision with root package name */
    public AbstractC1316l f34929F;

    /* renamed from: H, reason: collision with root package name */
    public RelativeLayout f34931H;

    /* renamed from: K, reason: collision with root package name */
    public int f34934K;

    /* renamed from: L, reason: collision with root package name */
    public int f34935L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f34936M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f34937N;

    /* renamed from: P, reason: collision with root package name */
    public boolean f34939P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f34940Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f34941R;

    /* renamed from: T, reason: collision with root package name */
    public String f34943T;

    /* renamed from: V, reason: collision with root package name */
    public boolean f34945V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f34946W;

    /* renamed from: Z, reason: collision with root package name */
    public boolean f34949Z;

    /* renamed from: a0, reason: collision with root package name */
    public Context f34951a0;

    /* renamed from: b, reason: collision with root package name */
    public T f34952b;

    /* renamed from: b0, reason: collision with root package name */
    public androidx.loader.app.a f34953b0;

    /* renamed from: c, reason: collision with root package name */
    public C1393c f34954c;

    /* renamed from: c0, reason: collision with root package name */
    public Parcelable f34955c0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f34956d;

    /* renamed from: d0, reason: collision with root package name */
    public int f34957d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f34959e0;

    /* renamed from: h0, reason: collision with root package name */
    public Z0.b f34965h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f34967i0;

    /* renamed from: j, reason: collision with root package name */
    public ContactTouchSearchView f34968j;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f34969j0;

    /* renamed from: k0, reason: collision with root package name */
    public ContactsHeaderView f34971k0;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f34974m;

    /* renamed from: m0, reason: collision with root package name */
    public V3.a f34975m0;

    /* renamed from: n, reason: collision with root package name */
    public View f34976n;

    /* renamed from: o, reason: collision with root package name */
    public View f34978o;

    /* renamed from: a, reason: collision with root package name */
    public ListView f34950a = null;

    /* renamed from: e, reason: collision with root package name */
    public int f34958e = -1;

    /* renamed from: f, reason: collision with root package name */
    public boolean f34960f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f34962g = false;

    /* renamed from: h, reason: collision with root package name */
    public TextView f34964h = null;

    /* renamed from: i, reason: collision with root package name */
    public com.customize.contacts.util.I f34966i = null;

    /* renamed from: k, reason: collision with root package name */
    public EditText f34970k = null;

    /* renamed from: l, reason: collision with root package name */
    public COUISearchBar f34972l = null;

    /* renamed from: p, reason: collision with root package name */
    public View f34980p = null;

    /* renamed from: q, reason: collision with root package name */
    public boolean f34982q = false;

    /* renamed from: r, reason: collision with root package name */
    public int f34983r = -1;

    /* renamed from: x, reason: collision with root package name */
    public boolean f34984x = false;

    /* renamed from: y, reason: collision with root package name */
    public boolean f34985y = false;

    /* renamed from: z, reason: collision with root package name */
    public com.customize.contacts.manager.g f34986z = null;

    /* renamed from: D, reason: collision with root package name */
    public Intent f34927D = null;

    /* renamed from: E, reason: collision with root package name */
    public boolean f34928E = false;

    /* renamed from: G, reason: collision with root package name */
    public C0806q f34930G = null;

    /* renamed from: I, reason: collision with root package name */
    public int f34932I = 0;

    /* renamed from: J, reason: collision with root package name */
    public int f34933J = 0;

    /* renamed from: O, reason: collision with root package name */
    public boolean f34938O = true;

    /* renamed from: S, reason: collision with root package name */
    public int f34942S = 2;

    /* renamed from: U, reason: collision with root package name */
    public int f34944U = 0;

    /* renamed from: X, reason: collision with root package name */
    public boolean f34947X = true;

    /* renamed from: Y, reason: collision with root package name */
    public int f34948Y = 0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f34961f0 = true;

    /* renamed from: g0, reason: collision with root package name */
    public int f34963g0 = 50;

    /* renamed from: l0, reason: collision with root package name */
    public int f34973l0 = -1;

    /* renamed from: n0, reason: collision with root package name */
    public final Handler f34977n0 = new a(Looper.getMainLooper());

    /* renamed from: o0, reason: collision with root package name */
    public C1393c.b f34979o0 = new b();

    /* renamed from: p0, reason: collision with root package name */
    public final TextWatcher f34981p0 = new c();

    /* compiled from: ContactEntryListFragment.java */
    /* renamed from: m1.j$a */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AbstractViewOnFocusChangeListenerC1314j.this.O1(message.arg1, (D) message.obj);
            }
        }
    }

    /* compiled from: ContactEntryListFragment.java */
    /* renamed from: m1.j$b */
    /* loaded from: classes.dex */
    public class b implements C1393c.b {
        public b() {
        }

        @Override // o1.C1393c.b
        public void onChange() {
            if (AbstractViewOnFocusChangeListenerC1314j.this.Q1()) {
                AbstractViewOnFocusChangeListenerC1314j.this.V1();
            }
        }
    }

    private int t1(CharSequence charSequence) {
        ListView u12 = u1();
        int i10 = 0;
        if (charSequence.equals("*")) {
            return 0;
        }
        Object[] sections = m1().getSections();
        if (sections != null && sections.length != 0) {
            String charSequence2 = charSequence.toString();
            while (true) {
                if (i10 != sections.length) {
                    if (charSequence2.equals(sections[i10].toString())) {
                        break;
                    }
                    i10++;
                } else {
                    i10 = -1;
                    break;
                }
            }
            int headerViewsCount = u12.getHeaderViewsCount();
            if (i10 != -1) {
                return m1().getPositionForSection(i10) + headerViewsCount;
            }
        }
        return i10;
    }

    public void A1(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.contact_list_view_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        ContactTouchSearchView contactTouchSearchView = (ContactTouchSearchView) view.findViewById(R.id.spell_bar);
        this.f34968j = contactTouchSearchView;
        if (contactTouchSearchView != null && B3.a.L()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f34968j.getLayoutParams();
            layoutParams.setMarginEnd(getActivity().getResources().getDimensionPixelOffset(R.dimen.curved_contactslist_margin));
            this.f34968j.setLayoutParams(layoutParams);
        }
        ListView listView = (ListView) view.findViewById(android.R.id.list);
        this.f34950a = listView;
        if (listView != null) {
            this.f34934K = getResources().getDimensionPixelSize(R.dimen.DP_30);
            this.f34935L = getResources().getDimensionPixelSize(R.dimen.DP_100);
            View findViewById = view.findViewById(android.R.id.empty);
            if (findViewById != null) {
                this.f34950a.setEmptyView(findViewById);
            }
            this.f34950a.setOnItemClickListener(this);
            this.f34950a.setOnFocusChangeListener(this);
            this.f34950a.setOnTouchListener(this);
            this.f34950a.setFastScrollEnabled(false);
            this.f34950a.setDividerHeight(0);
            this.f34950a.setSaveEnabled(false);
            this.f34950a.setOnScrollListener(this);
            i1();
            h1();
            boolean J12 = J1();
            this.f34952b.F0(J12);
            this.f34952b.T(false, J12);
            this.f34952b.A0(this.f34965h0);
            this.f34950a.setAdapter((ListAdapter) this.f34952b);
            return;
        }
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
    }

    public void B1(View view) {
        this.f34972l = (COUISearchBar) view.findViewById(R.id.search_view);
        this.f34978o = view.findViewById(R.id.search_line);
        if (this.f34972l != null) {
            y2();
            String string = this.f34951a0.getString(R.string.menu_search);
            this.f34972l.setContentDescription(string);
            this.f34972l.findViewById(R.id.animated_search_icon).setContentDescription(string);
            this.f34972l.setOnClickListener(new View.OnClickListener() { // from class: m1.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AbstractViewOnFocusChangeListenerC1314j.this.M1(view2);
                }
            });
            this.f34972l.getFunctionalButton().setOnClickListener(new View.OnClickListener() { // from class: m1.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AbstractViewOnFocusChangeListenerC1314j.this.N1(view2);
                }
            });
            this.f34970k = this.f34972l.getSearchEditText();
            this.f34972l.addOnStateChangeListener(this);
            this.f34970k.addTextChangedListener(this.f34981p0);
            com.android.contacts.util.z.e(this.f34970k, 50);
        }
        this.f34980p = view.findViewById(R.id.window_mask);
        ContactTouchSearchView contactTouchSearchView = this.f34968j;
        if (contactTouchSearchView != null) {
            contactTouchSearchView.O(this.f34972l, null);
        }
    }

    public void C1(LayoutInflater layoutInflater) {
        ContactsHeaderView contactsHeaderView = (ContactsHeaderView) layoutInflater.inflate(R.layout.contact_list_header_view, (ViewGroup) null);
        this.f34971k0 = contactsHeaderView;
        contactsHeaderView.d();
    }

    public void D1() {
        this.f34967i0 = Q1();
        this.f34948Y = 0;
        this.f34949Z = true;
        w2();
    }

    public boolean E1() {
        return false;
    }

    public boolean F1() {
        return this.f34946W;
    }

    public boolean G1() {
        T t10 = this.f34952b;
        if ((t10 != null && t10.k0()) || H1()) {
            return true;
        }
        return false;
    }

    public boolean H1() {
        int i10;
        if (J1() && p1() != 0 && ((i10 = this.f34948Y) == 0 || i10 == 1)) {
            return true;
        }
        return false;
    }

    public boolean I1() {
        return this.f34937N;
    }

    public final boolean J1() {
        return this.f34940Q;
    }

    public boolean K1() {
        return this.f34936M;
    }

    public boolean L1() {
        return this.f34945V;
    }

    @Override // m1.AbstractC1316l.a
    public void M0() {
        ContactTouchSearchView contactTouchSearchView = this.f34968j;
        if (contactTouchSearchView != null) {
            contactTouchSearchView.r();
        }
    }

    public final /* synthetic */ void M1(View view) {
        this.f34972l.changeStateWithAnimation(1);
    }

    public final /* synthetic */ void N1(View view) {
        SoftKeyboardUtil.a().b(view);
        this.f34972l.changeStateWithAnimation(0);
    }

    public void O1(int i10, D d10) {
        Bundle bundle = new Bundle();
        bundle.putLong("directoryId", d10.b());
        getLoaderManager().g(i10, bundle, this);
    }

    public final void P1(int i10, D d10) {
        this.f34977n0.removeMessages(1, d10);
        this.f34977n0.sendMessageDelayed(this.f34977n0.obtainMessage(1, i10, 0, d10), 300L);
    }

    public boolean Q1() {
        boolean z10;
        boolean j10;
        if (o1() != this.f34954c.g()) {
            Z1(this.f34954c.g());
            z10 = true;
        } else {
            z10 = false;
        }
        if (w1() != this.f34954c.h()) {
            q2(this.f34954c.h());
            z10 = true;
        }
        if (com.customize.contacts.util.K.f() && r1() != (j10 = this.f34954c.j())) {
            f2(j10);
            return true;
        }
        return z10;
    }

    public abstract void R1(int i10, long j10);

    @Override // androidx.loader.app.a.InterfaceC0129a
    /* renamed from: S1, reason: merged with bridge method [inline-methods] */
    public void S0(W.c<Cursor> cVar, Cursor cursor) {
        if (!this.f34947X) {
            return;
        }
        if (cursor != null && !(cursor instanceof C1322s)) {
            cursor = new C1322s(cursor);
        }
        int j10 = cVar.j();
        if (j10 == -1) {
            this.f34948Y = 2;
            this.f34952b.S(cursor);
            w2();
            return;
        }
        T1(j10, cursor);
        if (J1()) {
            int p12 = p1();
            if (H7.a.b()) {
                H7.b.b("ContactEntryListFragment", "onLoadFinished, The directorySearchMode IS " + p12 + ", the mDirectoryListStatus is " + this.f34948Y);
            }
            if (p12 != 0) {
                if (this.f34948Y == 0) {
                    this.f34948Y = 1;
                    getLoaderManager().e(-1, null, this);
                    return;
                } else {
                    w2();
                    return;
                }
            }
            return;
        }
        this.f34948Y = 0;
        getLoaderManager().a(-1);
    }

    public void T1(int i10, Cursor cursor) {
        if (cursor != null) {
            this.f34983r = cursor.getCount();
        }
        if (i10 >= this.f34952b.r()) {
            return;
        }
        this.f34952b.h(i10, cursor);
        l2();
        if (isAdded()) {
            u2(i10, cursor);
            if (!G1()) {
                f1();
            }
        }
    }

    public void V1() {
        W1();
        this.f34952b.q0();
        this.f34949Z = true;
        this.f34967i0 = true;
        w2();
    }

    public void W1() {
        this.f34977n0.removeMessages(1);
    }

    public void X1(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.f34936M = bundle.getBoolean("sectionHeaderDisplayEnabled");
        this.f34937N = bundle.getBoolean("photoLoaderEnabled");
        this.f34938O = bundle.getBoolean("quickContactEnabled");
        this.f34939P = bundle.getBoolean("includeProfile");
        this.f34940Q = bundle.getBoolean("searchMode");
        this.f34941R = bundle.getBoolean("visibleScrollbarEnabled");
        this.f34942S = bundle.getInt("scrollbarPosition");
        this.f34944U = bundle.getInt("directorySearchMode");
        this.f34945V = bundle.getBoolean("selectionVisible");
        this.f34946W = bundle.getBoolean("legacyCompatibility");
        this.f34943T = bundle.getString("queryString");
        this.f34963g0 = bundle.getInt("directoryResultLimit");
        this.f34969j0 = bundle.getBoolean("darkTheme");
        this.f34955c0 = bundle.getParcelable("liststate");
    }

    public void Y1(boolean z10) {
        if (z10) {
            RelativeLayout relativeLayout = this.f34931H;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.f34931H;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
    }

    @Override // androidx.loader.app.a.InterfaceC0129a
    public W.c<Cursor> Z(int i10, Bundle bundle) {
        long j10;
        if (H7.a.b()) {
            H7.b.b("ContactEntryListFragment", "onCreateLoader, The id is " + i10);
        }
        if (i10 == -1) {
            C c10 = new C(this.f34951a0);
            this.f34952b.U(c10);
            return c10;
        }
        W.b j12 = j1();
        if (bundle != null && bundle.containsKey("directoryId")) {
            j10 = bundle.getLong("directoryId");
        } else {
            j10 = 0;
        }
        this.f34952b.V(j12, j10);
        return j12;
    }

    public void Z1(int i10) {
        this.f34957d0 = i10;
        T t10 = this.f34952b;
        if (t10 != null) {
            t10.s0(i10);
        }
    }

    public void a2(Context context) {
        this.f34951a0 = context;
        h1();
    }

    public void b2(int i10) {
        this.f34963g0 = i10;
    }

    public void c2(int i10) {
        this.f34944U = i10;
    }

    public void d2(boolean z10) {
        this.f34939P = z10;
        T t10 = this.f34952b;
        if (t10 != null) {
            t10.z0(z10);
        }
    }

    public void e2(boolean z10) {
        this.f34960f = z10;
    }

    public void f1() {
        Parcelable parcelable = this.f34955c0;
        if (parcelable != null) {
            this.f34950a.onRestoreInstanceState(parcelable);
            this.f34955c0 = null;
        }
    }

    public void f2(boolean z10) {
        this.f34961f0 = z10;
    }

    public void g1() {
        T t10 = this.f34952b;
        if (t10 == null) {
            return;
        }
        t10.E0(this.f34938O);
        this.f34952b.z0(this.f34939P);
        this.f34952b.C0(this.f34943T);
        this.f34952b.v0(this.f34944U);
        this.f34952b.F(false);
        this.f34952b.s0(this.f34957d0);
        this.f34952b.H0(this.f34959e0);
        this.f34952b.P(this.f34936M);
        this.f34952b.G0(this.f34945V);
        this.f34952b.u0(this.f34963g0);
        this.f34952b.t0(this.f34969j0);
    }

    public void g2(boolean z10) {
        this.f34946W = z10;
    }

    @Override // androidx.fragment.app.Fragment, com.android.incallui.AnswerPresenter.AnswerUi
    public Context getContext() {
        return this.f34951a0;
    }

    @Override // androidx.fragment.app.Fragment
    public androidx.loader.app.a getLoaderManager() {
        return this.f34953b0;
    }

    public final void h1() {
        Context context;
        if (I1() && (context = this.f34951a0) != null) {
            if (this.f34965h0 == null) {
                this.f34965h0 = Z0.b.g(context);
            }
            T t10 = this.f34952b;
            if (t10 != null) {
                t10.A0(this.f34965h0);
            }
        }
    }

    public void h2(boolean z10) {
        int i10;
        ListView listView = this.f34950a;
        if (listView != null) {
            int paddingTop = listView.getPaddingTop();
            if (z10) {
                i10 = this.f34935L;
            } else {
                i10 = this.f34934K;
            }
            listView.setPadding(0, paddingTop, 0, i10);
        }
    }

    public final void i1() {
        ListView listView = this.f34950a;
        if (listView != null) {
            listView.setFastScrollEnabled(false);
            this.f34950a.setFastScrollAlwaysVisible(false);
            ListView listView2 = this.f34950a;
            listView2.setPadding(0, listView2.getPaddingTop(), 0, this.f34950a.getPaddingBottom());
        }
    }

    public void i2(int i10) {
        this.f34973l0 = i10 - getResources().getDimensionPixelSize(R.dimen.list_padding_top);
    }

    public W.b j1() {
        return new P3.a(this.f34951a0, null, null, null, null, null);
    }

    public void j2(androidx.loader.app.a aVar) {
        this.f34953b0 = aVar;
    }

    public abstract T k1();

    public void k2(boolean z10) {
        this.f34937N = z10;
        h1();
    }

    public void l1(CharSequence charSequence) {
        ListView u12 = u1();
        if (charSequence.equals("*")) {
            u12.setSelectionFromTop(u12.getHeaderViewsCount(), -this.f34932I);
            return;
        }
        Object[] sections = m1().getSections();
        if (sections != null && sections.length != 0) {
            String charSequence2 = charSequence.toString();
            int i10 = 0;
            while (true) {
                if (i10 != sections.length) {
                    if (charSequence2.equals(sections[i10].toString())) {
                        break;
                    } else {
                        i10++;
                    }
                } else {
                    i10 = -1;
                    break;
                }
            }
            int headerViewsCount = u12.getHeaderViewsCount();
            if (i10 != -1) {
                int positionForSection = m1().getPositionForSection(i10) + headerViewsCount;
                int i11 = this.f34973l0;
                if (i11 > 0) {
                    u12.setSelectionFromTop(positionForSection, i11 - this.f34932I);
                } else {
                    u12.setSelectionFromTop(positionForSection, -this.f34932I);
                }
                ListView listView = this.f34950a;
                listView.dispatchWindowVisibilityChanged(listView.getVisibility());
            }
        }
    }

    public void l2() {
        this.f34956d = false;
    }

    public T m1() {
        return this.f34952b;
    }

    public void m2(String str, boolean z10) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        if (!TextUtils.equals(this.f34943T, str)) {
            this.f34943T = str;
            o2(!TextUtils.isEmpty(str));
            T t10 = this.f34952b;
            if (t10 != null) {
                t10.C0(str);
                V1();
            }
        }
    }

    public COUISearchBar n1() {
        return this.f34972l;
    }

    public void n2(boolean z10) {
        this.f34938O = z10;
    }

    public int o1() {
        return this.f34957d0;
    }

    public void o2(boolean z10) {
        if (this.f34940Q != z10) {
            this.f34940Q = z10;
            p2(!z10);
            if (!z10) {
                this.f34948Y = 0;
                getLoaderManager().a(-1);
            }
            T t10 = this.f34952b;
            if (t10 != null) {
                t10.F0(z10);
                this.f34952b.i();
                if (!z10) {
                    int r10 = this.f34952b.r();
                    while (true) {
                        r10--;
                        if (r10 < 1) {
                            break;
                        } else {
                            this.f34952b.B(r10);
                        }
                    }
                }
                this.f34952b.T(false, z10);
            }
            ListView listView = this.f34950a;
            if (listView != null) {
                listView.setFastScrollEnabled(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        a2(activity);
        j2(super.getLoaderManager());
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (H7.a.b()) {
            H7.b.b("ContactEntryListFragment", "onConfigurationChanged");
        }
        r2();
        ContactTouchSearchView contactTouchSearchView = this.f34968j;
        if (contactTouchSearchView != null) {
            contactTouchSearchView.q(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f34954c = new C1393c(this.f34951a0);
        X1(bundle);
        AbstractC1316l f10 = AbstractC1316l.f(getActivity());
        this.f34929F = f10;
        f10.b(false);
        this.f34929F.a(this);
        this.f34954c.l(this.f34979o0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f34952b = k1();
        View z12 = z1(layoutInflater, viewGroup);
        if (E1()) {
            this.f34932I = this.f34951a0.getResources().getDimensionPixelSize(R.dimen.from_top_first);
            this.f34933J = this.f34951a0.getResources().getDimensionPixelSize(R.dimen.from_top_other);
        }
        A1(z12);
        return z12;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        AbstractC1316l abstractC1316l = this.f34929F;
        if (abstractC1316l != null) {
            abstractC1316l.g(this);
        }
        C1393c c1393c = this.f34954c;
        if (c1393c != null) {
            c1393c.p();
        }
        super.onDestroy();
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        if (view == this.f34950a && z10) {
            SoftKeyboardUtil.a().b(this.f34950a);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        SoftKeyboardUtil.a().b(this.f34950a);
        int headerViewsCount = i10 - this.f34950a.getHeaderViewsCount();
        if (headerViewsCount >= 0) {
            R1(headerViewsCount, j10);
        }
    }

    public void onKey(CharSequence charSequence) {
        if (this.f34968j == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spellbar_click_text", charSequence);
        com.android.contacts.framework.baseui.util.A.a(getContext(), 2000307, 200030043, hashMap, false);
        l1(charSequence);
        if (charSequence.equals("*")) {
            this.f34968j.setFirstKeyPopupDrawable(this.f34951a0.getDrawable(2131232622));
            return;
        }
        this.f34968j.setFirstKeyPopupDrawable(null);
        if (charSequence.equals("#")) {
            this.f34968j.setName(new String[0]);
            return;
        }
        com.customize.contacts.util.I i10 = this.f34966i;
        if (i10 == null) {
            return;
        }
        i10.i(charSequence);
    }

    @Override // com.customize.contacts.widget.TouchSearchView.d
    public void onNameClick(CharSequence charSequence) {
        int t12;
        if (H7.a.b()) {
            H7.b.b("ContactEntryListFragment", "onNameClick: ");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spellbar_click_text", charSequence);
        com.android.contacts.framework.baseui.util.A.a(getContext(), 2000307, 200030044, hashMap, false);
        com.customize.contacts.util.I i10 = this.f34966i;
        if (i10 != null && (t12 = t1(i10.d()) + this.f34966i.b(charSequence)) != -1) {
            ListView u12 = u1();
            if (this.f34966i.h(charSequence)) {
                int i11 = this.f34973l0;
                if (i11 > 0) {
                    u12.setSelectionFromTop(t12, i11 - this.f34932I);
                } else {
                    u12.setSelectionFromTop(t12, -this.f34932I);
                }
            } else {
                if (this.f34958e == -1) {
                    View H10 = this.f34952b.H(getContext(), null);
                    H10.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    this.f34958e = H10.getMeasuredHeight();
                }
                int i12 = this.f34973l0;
                if (i12 > 0) {
                    u12.setSelectionFromTop(t12, i12 - this.f34933J);
                } else {
                    u12.setSelectionFromTop(t12, this.f34958e - this.f34933J);
                }
            }
            ListView listView = this.f34950a;
            listView.dispatchWindowVisibilityChanged(listView.getVisibility());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        W1();
        i0.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("sectionHeaderDisplayEnabled", this.f34936M);
        bundle.putBoolean("photoLoaderEnabled", this.f34937N);
        bundle.putBoolean("quickContactEnabled", this.f34938O);
        bundle.putBoolean("includeProfile", this.f34939P);
        bundle.putBoolean("searchMode", this.f34940Q);
        bundle.putBoolean("visibleScrollbarEnabled", this.f34941R);
        bundle.putInt("scrollbarPosition", this.f34942S);
        bundle.putInt("directorySearchMode", this.f34944U);
        bundle.putBoolean("selectionVisible", this.f34945V);
        bundle.putBoolean("legacyCompatibility", this.f34946W);
        bundle.putString("queryString", this.f34943T);
        bundle.putInt("directoryResultLimit", this.f34963g0);
        bundle.putBoolean("darkTheme", this.f34969j0);
        ListView listView = this.f34950a;
        if (listView != null) {
            bundle.putParcelable("liststate", listView.onSaveInstanceState());
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i10) {
        r2();
        if (i10 == 2) {
            this.f34965h0.r();
        } else if (I1()) {
            this.f34965h0.w();
        }
        if (i10 != 2 && i10 != 1) {
            ContactTouchSearchView contactTouchSearchView = this.f34968j;
            if (contactTouchSearchView != null) {
                contactTouchSearchView.setEnabled(true);
                return;
            }
            return;
        }
        ContactTouchSearchView contactTouchSearchView2 = this.f34968j;
        if (contactTouchSearchView2 != null) {
            contactTouchSearchView2.setEnabled(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        T t10 = this.f34952b;
        if (t10 != null) {
            t10.i();
        }
        D1();
        y2();
    }

    public void onStateChange(int i10, int i11) {
        V3.a aVar;
        if (i11 == 1) {
            V3.a aVar2 = this.f34975m0;
            if (aVar2 != null) {
                aVar2.e();
                return;
            }
            return;
        }
        if (i11 == 0 && (aVar = this.f34975m0) != null) {
            aVar.a();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if ((view == this.f34950a || (view instanceof ContactListItemView)) && (motionEvent.getAction() & 255) == 0) {
            EditText editText = this.f34970k;
            if (editText != null) {
                editText.clearFocus();
            }
            SoftKeyboardUtil.a().b(view);
            return false;
        }
        return false;
    }

    public int p1() {
        return this.f34944U;
    }

    public void p2(boolean z10) {
        if (this.f34936M != z10) {
            this.f34936M = z10;
            T t10 = this.f34952b;
            if (t10 != null) {
                t10.P(z10);
            }
            i1();
        }
    }

    public ContactsHeaderView q1() {
        return this.f34971k0;
    }

    public void q2(int i10) {
        this.f34959e0 = i10;
        T t10 = this.f34952b;
        if (t10 != null) {
            t10.H0(i10);
        }
    }

    public boolean r1() {
        return this.f34961f0;
    }

    public void r2() {
        ContactTouchSearchView contactTouchSearchView = this.f34968j;
        if (contactTouchSearchView != null) {
            contactTouchSearchView.r();
        }
    }

    public int s1() {
        return this.f34935L;
    }

    public void s2(boolean z10) {
        if (H7.a.b()) {
            H7.b.b("ContactEntryListFragment", "isShow = " + z10);
        }
        if (z10) {
            ContactTouchSearchView contactTouchSearchView = this.f34968j;
            if (contactTouchSearchView != null) {
                contactTouchSearchView.setVisibility(0);
                return;
            }
            return;
        }
        ContactTouchSearchView contactTouchSearchView2 = this.f34968j;
        if (contactTouchSearchView2 != null) {
            contactTouchSearchView2.setVisibility(4);
            this.f34968j.r();
        }
    }

    public void t2(boolean z10) {
        if (this.f34941R != z10) {
            this.f34941R = z10;
            i1();
        }
    }

    public ListView u1() {
        return this.f34950a;
    }

    public final String v1() {
        return this.f34943T;
    }

    public void v2() {
        ContactsHeaderView contactsHeaderView = this.f34971k0;
        if (contactsHeaderView != null) {
            contactsHeaderView.setVisibility(0);
            for (int i10 = 0; i10 < this.f34971k0.getChildCount(); i10++) {
                this.f34971k0.getChildAt(i10).setVisibility(0);
            }
        }
    }

    public int w1() {
        return this.f34959e0;
    }

    public void w2() {
        if (this.f34952b == null) {
            return;
        }
        g1();
        int r10 = this.f34952b.r();
        for (int i10 = 0; i10 < r10; i10++) {
            a.C0167a q10 = this.f34952b.q(i10);
            if (q10 instanceof D) {
                D d10 = (D) q10;
                if (d10.d() == 0 && (d10.g() || !this.f34949Z)) {
                    x2(i10);
                }
            } else {
                try {
                    getLoaderManager().e(i10, null, this);
                } catch (RuntimeException e10) {
                    H7.b.c("ContactEntryListFragment", " RuntimeException " + e10);
                    getLoaderManager().d(i10).h();
                }
            }
        }
        this.f34949Z = false;
    }

    public View x1() {
        return this.f34980p;
    }

    public final void x2(int i10) {
        D d10 = (D) this.f34952b.q(i10);
        d10.m(1);
        long b10 = d10.b();
        if (b10 == 0) {
            if (d10.d() == 0) {
                if (H7.a.b()) {
                    H7.b.b("ContactEntryListFragment", "startLoadingDirectoryPartition, the local contacts did not load completely now");
                }
                this.f34967i0 = true;
            }
        } else {
            this.f34967i0 = true;
        }
        if (this.f34967i0) {
            if (b10 == 0) {
                O1(i10, d10);
                return;
            } else {
                P1(i10, d10);
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putLong("directoryId", b10);
        try {
            getLoaderManager().e(i10, bundle, this);
        } catch (RuntimeException e10) {
            H7.b.c("ContactEntryListFragment", "startLoadingDirectoryPartition startLoadingDirectoryPartition" + e10);
            getLoaderManager().d(i10).h();
        }
    }

    public void y1() {
        ContactsHeaderView contactsHeaderView = this.f34971k0;
        if (contactsHeaderView != null) {
            contactsHeaderView.setVisibility(8);
            for (int i10 = 0; i10 < this.f34971k0.getChildCount(); i10++) {
                this.f34971k0.getChildAt(i10).setVisibility(8);
            }
        }
    }

    public void y2() {
        COUISearchBar cOUISearchBar = this.f34972l;
        if (cOUISearchBar == null) {
            return;
        }
        cOUISearchBar.setBackgroundResource(R.drawable.pb_bg_another_search_view);
    }

    public abstract View z1(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void Q(W.c<Cursor> cVar) {
    }

    public void U1() {
    }

    public void u2(int i10, Cursor cursor) {
    }

    /* compiled from: ContactEntryListFragment.java */
    /* renamed from: m1.j$c */
    /* loaded from: classes.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AbstractViewOnFocusChangeListenerC1314j.this.f34972l.getQuickDeleteButton().setContentDescription(AbstractViewOnFocusChangeListenerC1314j.this.f34951a0.getString(R.string.delete_button));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            AbstractViewOnFocusChangeListenerC1314j.this.U1();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
    }
}
