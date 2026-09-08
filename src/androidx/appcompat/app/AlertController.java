package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.K;
import androidx.core.widget.NestedScrollView;
import e.C0961a;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class AlertController {

    /* renamed from: A, reason: collision with root package name */
    public NestedScrollView f7157A;

    /* renamed from: C, reason: collision with root package name */
    public Drawable f7159C;

    /* renamed from: D, reason: collision with root package name */
    public ImageView f7160D;

    /* renamed from: E, reason: collision with root package name */
    public TextView f7161E;

    /* renamed from: F, reason: collision with root package name */
    public TextView f7162F;

    /* renamed from: G, reason: collision with root package name */
    public View f7163G;

    /* renamed from: H, reason: collision with root package name */
    public ListAdapter f7164H;

    /* renamed from: J, reason: collision with root package name */
    public int f7166J;

    /* renamed from: K, reason: collision with root package name */
    public int f7167K;

    /* renamed from: L, reason: collision with root package name */
    public int f7168L;

    /* renamed from: M, reason: collision with root package name */
    public int f7169M;

    /* renamed from: N, reason: collision with root package name */
    public int f7170N;

    /* renamed from: O, reason: collision with root package name */
    public int f7171O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f7172P;

    /* renamed from: R, reason: collision with root package name */
    public Handler f7174R;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7176a;

    /* renamed from: b, reason: collision with root package name */
    public final i f7177b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f7178c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7179d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f7180e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f7181f;

    /* renamed from: g, reason: collision with root package name */
    public ListView f7182g;

    /* renamed from: h, reason: collision with root package name */
    public View f7183h;

    /* renamed from: i, reason: collision with root package name */
    public int f7184i;

    /* renamed from: j, reason: collision with root package name */
    public int f7185j;

    /* renamed from: k, reason: collision with root package name */
    public int f7186k;

    /* renamed from: l, reason: collision with root package name */
    public int f7187l;

    /* renamed from: m, reason: collision with root package name */
    public int f7188m;

    /* renamed from: o, reason: collision with root package name */
    public Button f7190o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f7191p;

    /* renamed from: q, reason: collision with root package name */
    public Message f7192q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f7193r;

    /* renamed from: s, reason: collision with root package name */
    public Button f7194s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f7195t;

    /* renamed from: u, reason: collision with root package name */
    public Message f7196u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f7197v;

    /* renamed from: w, reason: collision with root package name */
    public Button f7198w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f7199x;

    /* renamed from: y, reason: collision with root package name */
    public Message f7200y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f7201z;

    /* renamed from: n, reason: collision with root package name */
    public boolean f7189n = false;

    /* renamed from: B, reason: collision with root package name */
    public int f7158B = 0;

    /* renamed from: I, reason: collision with root package name */
    public int f7165I = -1;

    /* renamed from: Q, reason: collision with root package name */
    public int f7173Q = 0;

    /* renamed from: S, reason: collision with root package name */
    public final View.OnClickListener f7175S = new a();

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: a, reason: collision with root package name */
        public final int f7202a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7203b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.f30478m2);
            this.f7203b = obtainStyledAttributes.getDimensionPixelOffset(e.j.f30483n2, -1);
            this.f7202a = obtainStyledAttributes.getDimensionPixelOffset(e.j.f30488o2, -1);
        }

        public void a(boolean z10, boolean z11) {
            int i10;
            int i11;
            if (!z11 || !z10) {
                int paddingLeft = getPaddingLeft();
                if (z10) {
                    i10 = getPaddingTop();
                } else {
                    i10 = this.f7202a;
                }
                int paddingRight = getPaddingRight();
                if (z11) {
                    i11 = getPaddingBottom();
                } else {
                    i11 = this.f7203b;
                }
                setPadding(paddingLeft, i10, paddingRight, i11);
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.f7190o && (message4 = alertController.f7192q) != null) {
                message = Message.obtain(message4);
            } else if (view == alertController.f7194s && (message3 = alertController.f7196u) != null) {
                message = Message.obtain(message3);
            } else if (view == alertController.f7198w && (message2 = alertController.f7200y) != null) {
                message = Message.obtain(message2);
            } else {
                message = null;
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f7174R.obtainMessage(1, alertController2.f7177b).sendToTarget();
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: A, reason: collision with root package name */
        public int f7205A;

        /* renamed from: B, reason: collision with root package name */
        public int f7206B;

        /* renamed from: C, reason: collision with root package name */
        public int f7207C;

        /* renamed from: D, reason: collision with root package name */
        public int f7208D;

        /* renamed from: F, reason: collision with root package name */
        public boolean[] f7210F;

        /* renamed from: G, reason: collision with root package name */
        public boolean f7211G;

        /* renamed from: H, reason: collision with root package name */
        public boolean f7212H;

        /* renamed from: J, reason: collision with root package name */
        public DialogInterface.OnMultiChoiceClickListener f7214J;

        /* renamed from: K, reason: collision with root package name */
        public Cursor f7215K;

        /* renamed from: L, reason: collision with root package name */
        public String f7216L;

        /* renamed from: M, reason: collision with root package name */
        public String f7217M;

        /* renamed from: N, reason: collision with root package name */
        public boolean f7218N;

        /* renamed from: O, reason: collision with root package name */
        public AdapterView.OnItemSelectedListener f7219O;

        /* renamed from: a, reason: collision with root package name */
        public final Context f7221a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f7222b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f7224d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f7226f;

        /* renamed from: g, reason: collision with root package name */
        public View f7227g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f7228h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f7229i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f7230j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f7231k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f7232l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f7233m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f7234n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f7235o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f7236p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f7237q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f7239s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f7240t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f7241u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f7242v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f7243w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f7244x;

        /* renamed from: y, reason: collision with root package name */
        public int f7245y;

        /* renamed from: z, reason: collision with root package name */
        public View f7246z;

        /* renamed from: c, reason: collision with root package name */
        public int f7223c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f7225e = 0;

        /* renamed from: E, reason: collision with root package name */
        public boolean f7209E = false;

        /* renamed from: I, reason: collision with root package name */
        public int f7213I = -1;

        /* renamed from: P, reason: collision with root package name */
        public boolean f7220P = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f7238r = true;

        /* loaded from: classes.dex */
        public class a extends ArrayAdapter<CharSequence> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f7247a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f7247a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = b.this.f7210F;
                if (zArr != null && zArr[i10]) {
                    this.f7247a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        /* renamed from: androidx.appcompat.app.AlertController$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0100b extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final int f7249a;

            /* renamed from: b, reason: collision with root package name */
            public final int f7250b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f7251c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AlertController f7252d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0100b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f7251c = recycleListView;
                this.f7252d = alertController;
                Cursor cursor2 = getCursor();
                this.f7249a = cursor2.getColumnIndexOrThrow(b.this.f7216L);
                this.f7250b = cursor2.getColumnIndexOrThrow(b.this.f7217M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f7249a));
                RecycleListView recycleListView = this.f7251c;
                int position = cursor.getPosition();
                int i10 = cursor.getInt(this.f7250b);
                boolean z10 = true;
                if (i10 != 1) {
                    z10 = false;
                }
                recycleListView.setItemChecked(position, z10);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return b.this.f7222b.inflate(this.f7252d.f7169M, viewGroup, false);
            }
        }

        /* loaded from: classes.dex */
        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AlertController f7254a;

            public c(AlertController alertController) {
                this.f7254a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                b.this.f7244x.onClick(this.f7254a.f7177b, i10);
                if (!b.this.f7212H) {
                    this.f7254a.f7177b.dismiss();
                }
            }
        }

        /* loaded from: classes.dex */
        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f7256a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AlertController f7257b;

            public d(RecycleListView recycleListView, AlertController alertController) {
                this.f7256a = recycleListView;
                this.f7257b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                boolean[] zArr = b.this.f7210F;
                if (zArr != null) {
                    zArr[i10] = this.f7256a.isItemChecked(i10);
                }
                b.this.f7214J.onClick(this.f7257b.f7177b, i10, this.f7256a.isItemChecked(i10));
            }
        }

        public b(Context context) {
            this.f7221a = context;
            this.f7222b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.f7227g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f7226f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f7224d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i10 = this.f7223c;
                if (i10 != 0) {
                    alertController.m(i10);
                }
                int i11 = this.f7225e;
                if (i11 != 0) {
                    alertController.m(alertController.d(i11));
                }
            }
            CharSequence charSequence2 = this.f7228h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f7229i;
            if (charSequence3 != null || this.f7230j != null) {
                alertController.k(-1, charSequence3, this.f7231k, null, this.f7230j);
            }
            CharSequence charSequence4 = this.f7232l;
            if (charSequence4 != null || this.f7233m != null) {
                alertController.k(-2, charSequence4, this.f7234n, null, this.f7233m);
            }
            CharSequence charSequence5 = this.f7235o;
            if (charSequence5 != null || this.f7236p != null) {
                alertController.k(-3, charSequence5, this.f7237q, null, this.f7236p);
            }
            if (this.f7242v != null || this.f7215K != null || this.f7243w != null) {
                b(alertController);
            }
            View view2 = this.f7246z;
            if (view2 != null) {
                if (this.f7209E) {
                    alertController.t(view2, this.f7205A, this.f7206B, this.f7207C, this.f7208D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i12 = this.f7245y;
            if (i12 != 0) {
                alertController.r(i12);
            }
        }

        public final void b(AlertController alertController) {
            int i10;
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f7222b.inflate(alertController.f7168L, (ViewGroup) null);
            if (this.f7211G) {
                if (this.f7215K == null) {
                    listAdapter = new a(this.f7221a, alertController.f7169M, R.id.text1, this.f7242v, recycleListView);
                } else {
                    listAdapter = new C0100b(this.f7221a, this.f7215K, false, recycleListView, alertController);
                }
            } else {
                if (this.f7212H) {
                    i10 = alertController.f7170N;
                } else {
                    i10 = alertController.f7171O;
                }
                int i11 = i10;
                if (this.f7215K != null) {
                    listAdapter = new SimpleCursorAdapter(this.f7221a, i11, this.f7215K, new String[]{this.f7216L}, new int[]{R.id.text1});
                } else {
                    listAdapter = this.f7243w;
                    if (listAdapter == null) {
                        listAdapter = new d(this.f7221a, i11, R.id.text1, this.f7242v);
                    }
                }
            }
            alertController.f7164H = listAdapter;
            alertController.f7165I = this.f7213I;
            if (this.f7244x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.f7214J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f7219O;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.f7212H) {
                recycleListView.setChoiceMode(1);
            } else if (this.f7211G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f7182g = recycleListView;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f7259a;

        public c(DialogInterface dialogInterface) {
            this.f7259a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != -3 && i10 != -2 && i10 != -1) {
                if (i10 == 1) {
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
                return;
            }
            ((DialogInterface.OnClickListener) message.obj).onClick(this.f7259a.get(), message.what);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, i iVar, Window window) {
        this.f7176a = context;
        this.f7177b = iVar;
        this.f7178c = window;
        this.f7174R = new c(iVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, e.j.f30317H, C0961a.f30115n, 0);
        this.f7166J = obtainStyledAttributes.getResourceId(e.j.f30322I, 0);
        this.f7167K = obtainStyledAttributes.getResourceId(e.j.f30332K, 0);
        this.f7168L = obtainStyledAttributes.getResourceId(e.j.f30342M, 0);
        this.f7169M = obtainStyledAttributes.getResourceId(e.j.f30347N, 0);
        this.f7170N = obtainStyledAttributes.getResourceId(e.j.f30357P, 0);
        this.f7171O = obtainStyledAttributes.getResourceId(e.j.f30337L, 0);
        this.f7172P = obtainStyledAttributes.getBoolean(e.j.f30352O, true);
        this.f7179d = obtainStyledAttributes.getDimensionPixelSize(e.j.f30327J, 0);
        obtainStyledAttributes.recycle();
        iVar.supportRequestWindowFeature(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0961a.f30114m, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public Button c(int i10) {
        if (i10 != -3) {
            if (i10 != -2) {
                if (i10 != -1) {
                    return null;
                }
                return this.f7190o;
            }
            return this.f7194s;
        }
        return this.f7198w;
    }

    public int d(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f7176a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f7182g;
    }

    public void f() {
        this.f7177b.setContentView(j());
        y();
    }

    public boolean g(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f7157A;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean h(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f7157A;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public final ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final int j() {
        int i10 = this.f7167K;
        if (i10 == 0) {
            return this.f7166J;
        }
        if (this.f7173Q == 1) {
            return i10;
        }
        return this.f7166J;
    }

    public void k(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f7174R.obtainMessage(i10, onClickListener);
        }
        if (i10 != -3) {
            if (i10 != -2) {
                if (i10 == -1) {
                    this.f7191p = charSequence;
                    this.f7192q = message;
                    this.f7193r = drawable;
                    return;
                }
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f7195t = charSequence;
            this.f7196u = message;
            this.f7197v = drawable;
            return;
        }
        this.f7199x = charSequence;
        this.f7200y = message;
        this.f7201z = drawable;
    }

    public void l(View view) {
        this.f7163G = view;
    }

    public void m(int i10) {
        this.f7159C = null;
        this.f7158B = i10;
        ImageView imageView = this.f7160D;
        if (imageView != null) {
            if (i10 != 0) {
                imageView.setVisibility(0);
                this.f7160D.setImageResource(this.f7158B);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void n(Drawable drawable) {
        this.f7159C = drawable;
        this.f7158B = 0;
        ImageView imageView = this.f7160D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.f7160D.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void o(CharSequence charSequence) {
        this.f7181f = charSequence;
        TextView textView = this.f7162F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void p(ViewGroup viewGroup, View view, int i10, int i11) {
        View findViewById = this.f7178c.findViewById(e.f.f30193A);
        View findViewById2 = this.f7178c.findViewById(e.f.f30239z);
        K.C0(view, i10, i11);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    public void q(CharSequence charSequence) {
        this.f7180e = charSequence;
        TextView textView = this.f7161E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i10) {
        this.f7183h = null;
        this.f7184i = i10;
        this.f7189n = false;
    }

    public void s(View view) {
        this.f7183h = view;
        this.f7184i = 0;
        this.f7189n = false;
    }

    public void t(View view, int i10, int i11, int i12, int i13) {
        this.f7183h = view;
        this.f7184i = 0;
        this.f7189n = true;
        this.f7185j = i10;
        this.f7186k = i11;
        this.f7187l = i12;
        this.f7188m = i13;
    }

    public final void u(ViewGroup viewGroup) {
        int i10;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f7190o = button;
        button.setOnClickListener(this.f7175S);
        if (TextUtils.isEmpty(this.f7191p) && this.f7193r == null) {
            this.f7190o.setVisibility(8);
            i10 = 0;
        } else {
            this.f7190o.setText(this.f7191p);
            Drawable drawable = this.f7193r;
            if (drawable != null) {
                int i11 = this.f7179d;
                drawable.setBounds(0, 0, i11, i11);
                this.f7190o.setCompoundDrawables(this.f7193r, null, null, null);
            }
            this.f7190o.setVisibility(0);
            i10 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f7194s = button2;
        button2.setOnClickListener(this.f7175S);
        if (TextUtils.isEmpty(this.f7195t) && this.f7197v == null) {
            this.f7194s.setVisibility(8);
        } else {
            this.f7194s.setText(this.f7195t);
            Drawable drawable2 = this.f7197v;
            if (drawable2 != null) {
                int i12 = this.f7179d;
                drawable2.setBounds(0, 0, i12, i12);
                this.f7194s.setCompoundDrawables(this.f7197v, null, null, null);
            }
            this.f7194s.setVisibility(0);
            i10 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f7198w = button3;
        button3.setOnClickListener(this.f7175S);
        if (TextUtils.isEmpty(this.f7199x) && this.f7201z == null) {
            this.f7198w.setVisibility(8);
        } else {
            this.f7198w.setText(this.f7199x);
            Drawable drawable3 = this.f7201z;
            if (drawable3 != null) {
                int i13 = this.f7179d;
                drawable3.setBounds(0, 0, i13, i13);
                this.f7198w.setCompoundDrawables(this.f7201z, null, null, null);
            }
            this.f7198w.setVisibility(0);
            i10 |= 4;
        }
        if (z(this.f7176a)) {
            if (i10 == 1) {
                b(this.f7190o);
            } else if (i10 == 2) {
                b(this.f7194s);
            } else if (i10 == 4) {
                b(this.f7198w);
            }
        }
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public final void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f7178c.findViewById(e.f.f30194B);
        this.f7157A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.f7157A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.f7162F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f7181f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.f7157A.removeView(this.f7162F);
        if (this.f7182g != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.f7157A.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.f7157A);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.f7182g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void w(ViewGroup viewGroup) {
        View view = this.f7183h;
        boolean z10 = false;
        if (view == null) {
            if (this.f7184i != 0) {
                view = LayoutInflater.from(this.f7176a).inflate(this.f7184i, viewGroup, false);
            } else {
                view = null;
            }
        }
        if (view != null) {
            z10 = true;
        }
        if (!z10 || !a(view)) {
            this.f7178c.setFlags(131072, 131072);
        }
        if (z10) {
            FrameLayout frameLayout = (FrameLayout) this.f7178c.findViewById(e.f.f30228o);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f7189n) {
                frameLayout.setPadding(this.f7185j, this.f7186k, this.f7187l, this.f7188m);
            }
            if (this.f7182g != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void x(ViewGroup viewGroup) {
        if (this.f7163G != null) {
            viewGroup.addView(this.f7163G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f7178c.findViewById(e.f.f30212T).setVisibility(8);
            return;
        }
        this.f7160D = (ImageView) this.f7178c.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(this.f7180e)) && this.f7172P) {
            TextView textView = (TextView) this.f7178c.findViewById(e.f.f30224k);
            this.f7161E = textView;
            textView.setText(this.f7180e);
            int i10 = this.f7158B;
            if (i10 != 0) {
                this.f7160D.setImageResource(i10);
                return;
            }
            Drawable drawable = this.f7159C;
            if (drawable != null) {
                this.f7160D.setImageDrawable(drawable);
                return;
            } else {
                this.f7161E.setPadding(this.f7160D.getPaddingLeft(), this.f7160D.getPaddingTop(), this.f7160D.getPaddingRight(), this.f7160D.getPaddingBottom());
                this.f7160D.setVisibility(8);
                return;
            }
        }
        this.f7178c.findViewById(e.f.f30212T).setVisibility(8);
        this.f7160D.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        boolean z10;
        boolean z11;
        boolean z12;
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3;
        View findViewById4 = this.f7178c.findViewById(e.f.f30238y);
        int i10 = e.f.f30213U;
        View findViewById5 = findViewById4.findViewById(i10);
        int i11 = e.f.f30227n;
        View findViewById6 = findViewById4.findViewById(i11);
        int i12 = e.f.f30225l;
        View findViewById7 = findViewById4.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) findViewById4.findViewById(e.f.f30229p);
        w(viewGroup);
        View findViewById8 = viewGroup.findViewById(i10);
        View findViewById9 = viewGroup.findViewById(i11);
        View findViewById10 = viewGroup.findViewById(i12);
        ViewGroup i13 = i(findViewById8, findViewById5);
        ViewGroup i14 = i(findViewById9, findViewById6);
        ViewGroup i15 = i(findViewById10, findViewById7);
        v(i14);
        u(i15);
        x(i13);
        int i16 = 0;
        if (viewGroup.getVisibility() != 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i13 != null && i13.getVisibility() != 8) {
            z11 = 1;
        } else {
            z11 = 0;
        }
        if (i15 != null && i15.getVisibility() != 8) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12 && i14 != null && (findViewById3 = i14.findViewById(e.f.f30208P)) != null) {
            findViewById3.setVisibility(0);
        }
        if (z11 != 0) {
            NestedScrollView nestedScrollView = this.f7157A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            if (this.f7181f == null && this.f7182g == null) {
                findViewById2 = null;
            } else {
                findViewById2 = i13.findViewById(e.f.f30211S);
            }
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        } else if (i14 != null && (findViewById = i14.findViewById(e.f.f30209Q)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f7182g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z11, z12);
        }
        if (!z10) {
            View view = this.f7182g;
            if (view == null) {
                view = this.f7157A;
            }
            if (view != null) {
                if (z12) {
                    i16 = 2;
                }
                p(i14, view, z11 | i16, 3);
            }
        }
        ListView listView2 = this.f7182g;
        if (listView2 != null && (listAdapter = this.f7164H) != null) {
            listView2.setAdapter(listAdapter);
            int i17 = this.f7165I;
            if (i17 > -1) {
                listView2.setItemChecked(i17, true);
                listView2.setSelection(i17);
            }
        }
    }
}
