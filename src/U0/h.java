package U0;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.coui.appcompat.edittext.COUIEditText;
import kotlin.Result;
import kotlin.text.StringsKt__StringsKt;
import m9.q;

/* compiled from: BottomDialogManager.kt */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: e, reason: collision with root package name */
    public static final a f3809e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public androidx.appcompat.app.b f3810a;

    /* renamed from: b, reason: collision with root package name */
    public U0.b f3811b;

    /* renamed from: c, reason: collision with root package name */
    public COUIEditText f3812c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3813d = true;

    /* compiled from: BottomDialogManager.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: BottomDialogManager.kt */
    /* loaded from: classes.dex */
    public static final class b implements TextWatcher {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f3815b;

        public b(boolean z10) {
            this.f3815b = z10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CharSequence charSequence;
            CharSequence j02;
            COUIEditText cOUIEditText = h.this.f3812c;
            if (cOUIEditText != null) {
                charSequence = cOUIEditText.getText();
            } else {
                charSequence = null;
            }
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z10 = false;
            if (!this.f3815b) {
                U0.b bVar = h.this.f3811b;
                if (bVar != null) {
                    if (charSequence.length() > 0) {
                        z10 = true;
                    }
                    bVar.k(-1, z10);
                    return;
                }
                return;
            }
            U0.b bVar2 = h.this.f3811b;
            if (bVar2 != null) {
                j02 = StringsKt__StringsKt.j0(charSequence);
                if (j02.length() > 0) {
                    z10 = true;
                }
                bVar2.k(-1, z10);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (H7.a.b()) {
                H7.b.b("BottomDialogManager", "s = " + ((Object) charSequence) + ", start = " + i10 + ", count = " + i11 + ", after = " + i12);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (H7.a.b()) {
                H7.b.e("BottomDialogManager", "s = " + ((Object) charSequence) + ", start = " + i10 + ", before = " + i11 + ", count = " + i12);
            }
        }
    }

    /* compiled from: BottomDialogManager.kt */
    /* loaded from: classes.dex */
    public static final class c implements TextView.OnEditorActionListener {
        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            Object b10;
            kotlin.jvm.internal.i.f(textView, "textView");
            if (i10 != 6) {
                return false;
            }
            try {
                Result.a aVar = Result.f34166a;
                Object systemService = textView.getContext().getSystemService("input_method");
                kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(textView.getApplicationWindowToken(), 0);
                }
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("BottomDialogManager", "onEditorAction e = " + d10);
                return true;
            }
            return true;
        }
    }

    public static /* synthetic */ View r(h hVar, Context context, int i10, Y0.a aVar, String str, String str2, String str3, boolean z10, String str4, int i11, Object obj) {
        boolean z11;
        String str5;
        if ((i11 & 64) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        if ((i11 & 128) != 0) {
            str5 = null;
        } else {
            str5 = str4;
        }
        return hVar.q(context, i10, aVar, str, str2, str3, z11, str5);
    }

    public static final void s(Y0.a listener, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(listener, "$listener");
        listener.onCancel();
    }

    public static final void t(Y0.a listener, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(listener, "$listener");
        listener.g();
    }

    public static final void u(boolean z10, Context context, h this$0, DialogInterface dialogInterface) {
        U0.b bVar;
        androidx.appcompat.app.b j10;
        kotlin.jvm.internal.i.f(context, "$context");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (z10 && (context instanceof AppCompatActivity)) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) context;
            if (!appCompatActivity.isFinishing() && this$0.f3813d && (bVar = this$0.f3811b) != null && (j10 = bVar.j()) != null && !j10.isShowing()) {
                appCompatActivity.overridePendingTransition(0, 0);
                appCompatActivity.finish();
            }
        }
    }

    public final void g() {
        androidx.appcompat.app.b bVar = this.f3810a;
        if (bVar != null && bVar.isShowing()) {
            bVar.dismiss();
        }
        this.f3810a = null;
        this.f3812c = null;
        n.h();
    }

    public final androidx.appcompat.app.b h() {
        return this.f3810a;
    }

    public final U0.b i() {
        return this.f3811b;
    }

    public final COUIEditText j() {
        return this.f3812c;
    }

    public final void k(View view, boolean z10, String hint, boolean z11) {
        Window window;
        kotlin.jvm.internal.i.f(hint, "hint");
        if (view == null) {
            return;
        }
        COUIEditText cOUIEditText = (COUIEditText) view.findViewById(N0.i.f1938p);
        this.f3812c = cOUIEditText;
        if (cOUIEditText != null) {
            cOUIEditText.setHint(hint);
        }
        COUIEditText cOUIEditText2 = this.f3812c;
        if (cOUIEditText2 != null) {
            cOUIEditText2.setOnClickListener(new View.OnClickListener() { // from class: U0.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    h.l(view2);
                }
            });
        }
        COUIEditText cOUIEditText3 = this.f3812c;
        if (cOUIEditText3 != null) {
            cOUIEditText3.setSelectAllOnFocus(true);
        }
        COUIEditText cOUIEditText4 = this.f3812c;
        if (cOUIEditText4 != null) {
            cOUIEditText4.addTextChangedListener(new b(z11));
        }
        COUIEditText cOUIEditText5 = this.f3812c;
        if (cOUIEditText5 != null) {
            cOUIEditText5.setOnEditorActionListener(new c());
        }
        if (z10) {
            COUIEditText cOUIEditText6 = this.f3812c;
            if (cOUIEditText6 != null) {
                cOUIEditText6.setFocusable(true);
            }
            COUIEditText cOUIEditText7 = this.f3812c;
            if (cOUIEditText7 != null) {
                cOUIEditText7.requestFocus();
            }
            androidx.appcompat.app.b bVar = this.f3810a;
            if (bVar != null) {
                window = bVar.getWindow();
            } else {
                window = null;
            }
            if (window != null) {
                window.setSoftInputMode(5);
            }
        }
    }

    public final void m(String text) {
        Window window;
        kotlin.jvm.internal.i.f(text, "text");
        COUIEditText cOUIEditText = this.f3812c;
        if (cOUIEditText != null) {
            cOUIEditText.setText(text);
        }
        COUIEditText cOUIEditText2 = this.f3812c;
        if (cOUIEditText2 != null) {
            cOUIEditText2.setSelectAllOnFocus(true);
        }
        COUIEditText cOUIEditText3 = this.f3812c;
        if (cOUIEditText3 != null) {
            cOUIEditText3.setFocusable(true);
        }
        COUIEditText cOUIEditText4 = this.f3812c;
        if (cOUIEditText4 != null) {
            cOUIEditText4.requestFocus();
        }
        androidx.appcompat.app.b bVar = this.f3810a;
        if (bVar != null) {
            window = bVar.getWindow();
        } else {
            window = null;
        }
        if (window != null) {
            window.setSoftInputMode(5);
        }
    }

    public final void n(boolean z10) {
        this.f3813d = z10;
    }

    public final View o(Context context, int i10, Y0.a listener, String title, String negativeButtonText, String positiveButtonText) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(listener, "listener");
        kotlin.jvm.internal.i.f(title, "title");
        kotlin.jvm.internal.i.f(negativeButtonText, "negativeButtonText");
        kotlin.jvm.internal.i.f(positiveButtonText, "positiveButtonText");
        return r(this, context, i10, listener, title, negativeButtonText, positiveButtonText, false, null, 192, null);
    }

    public final View p(Context context, int i10, Y0.a listener, String title, String negativeButtonText, String positiveButtonText, boolean z10) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(listener, "listener");
        kotlin.jvm.internal.i.f(title, "title");
        kotlin.jvm.internal.i.f(negativeButtonText, "negativeButtonText");
        kotlin.jvm.internal.i.f(positiveButtonText, "positiveButtonText");
        return r(this, context, i10, listener, title, negativeButtonText, positiveButtonText, z10, null, 128, null);
    }

    public final View q(final Context context, int i10, final Y0.a listener, String title, String negativeButtonText, String positiveButtonText, final boolean z10, String str) {
        androidx.appcompat.app.b bVar;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(listener, "listener");
        kotlin.jvm.internal.i.f(title, "title");
        kotlin.jvm.internal.i.f(negativeButtonText, "negativeButtonText");
        kotlin.jvm.internal.i.f(positiveButtonText, "positiveButtonText");
        androidx.appcompat.app.b bVar2 = this.f3810a;
        if (bVar2 != null && bVar2.isShowing() && (bVar = this.f3810a) != null) {
            bVar.dismiss();
        }
        this.f3811b = new U0.b(context, N0.l.f1985a);
        Object systemService = context.getSystemService("layout_inflater");
        kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        androidx.appcompat.app.b bVar3 = null;
        View inflate = ((LayoutInflater) systemService).inflate(i10, (ViewGroup) null);
        U0.b bVar4 = this.f3811b;
        if (bVar4 != null) {
            bVar4.setTitle((CharSequence) title);
            bVar4.setView(inflate);
            bVar4.setNegativeButton((CharSequence) negativeButtonText, new DialogInterface.OnClickListener() { // from class: U0.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    h.s(Y0.a.this, dialogInterface, i11);
                }
            });
            bVar4.setPositiveButton((CharSequence) positiveButtonText, new DialogInterface.OnClickListener() { // from class: U0.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    h.t(Y0.a.this, dialogInterface, i11);
                }
            });
            bVar4.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: U0.g
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    h.u(z10, context, this, dialogInterface);
                }
            });
            if (str != null) {
                bVar4.setMessage((CharSequence) str);
            }
        }
        U0.b bVar5 = this.f3811b;
        if (bVar5 != null) {
            bVar3 = bVar5.show();
        }
        this.f3810a = bVar3;
        U0.b bVar6 = this.f3811b;
        if (bVar6 != null) {
            bVar6.k(-1, false);
        }
        n.d(this.f3810a);
        return inflate;
    }

    public static final void l(View view) {
    }
}
