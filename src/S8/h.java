package S8;

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
import com.oplus.utils.C0846g;
import kotlin.Result;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: BottomDialogManager.kt */
/* loaded from: classes4.dex */
public final class h {

    /* renamed from: e, reason: collision with root package name */
    public static final a f3541e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public androidx.appcompat.app.b f3542a;

    /* renamed from: b, reason: collision with root package name */
    public S8.b f3543b;

    /* renamed from: c, reason: collision with root package name */
    public COUIEditText f3544c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3545d = true;

    /* compiled from: BottomDialogManager.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: BottomDialogManager.kt */
    /* loaded from: classes4.dex */
    public static final class b implements TextWatcher {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f3547b;

        public b(boolean z10) {
            this.f3547b = z10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            CharSequence charSequence;
            CharSequence j02;
            COUIEditText cOUIEditText = h.this.f3544c;
            if (cOUIEditText != null) {
                charSequence = cOUIEditText.getText();
            } else {
                charSequence = null;
            }
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z10 = false;
            if (!this.f3547b) {
                S8.b bVar = h.this.f3543b;
                if (bVar != null) {
                    if (charSequence.length() > 0) {
                        z10 = true;
                    }
                    bVar.j(-1, z10);
                    return;
                }
                return;
            }
            S8.b bVar2 = h.this.f3543b;
            if (bVar2 != null) {
                j02 = StringsKt__StringsKt.j0(charSequence);
                if (j02.length() > 0) {
                    z10 = true;
                }
                bVar2.j(-1, z10);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            C0846g.i("BottomSheetDialogManager", "s = " + ((Object) charSequence) + ", start = " + i10 + ", count = " + i11 + ", after = " + i12);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            C0846g.i("BottomSheetDialogManager", "s = " + ((Object) charSequence) + ", start = " + i10 + ", before = " + i11 + ", count = " + i12);
        }
    }

    /* compiled from: BottomDialogManager.kt */
    /* loaded from: classes4.dex */
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
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                C0846g.j("BottomSheetDialogManager", "onEditorAction e = " + d10);
                return true;
            }
            return true;
        }
    }

    public static /* synthetic */ void k(h hVar, androidx.appcompat.app.b bVar, boolean z10, String str, boolean z11, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        hVar.j(bVar, z10, str, z11);
    }

    public static /* synthetic */ androidx.appcompat.app.b o(h hVar, Context context, int i10, i iVar, String str, String str2, String str3, String str4, boolean z10, int i11, Object obj) {
        String str5;
        boolean z11;
        if ((i11 & 16) != 0) {
            str5 = null;
        } else {
            str5 = str2;
        }
        if ((i11 & 128) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        return hVar.n(context, i10, iVar, str, str5, str3, str4, z11);
    }

    public static final void p(i listener, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(listener, "$listener");
        listener.onCancel();
    }

    public static final void q(i listener, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(listener, "$listener");
        listener.g();
    }

    public static final void r(boolean z10, Context context, h this$0, DialogInterface dialogInterface) {
        S8.b bVar;
        androidx.appcompat.app.b i10;
        kotlin.jvm.internal.i.f(context, "$context");
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (z10 && (context instanceof AppCompatActivity)) {
            AppCompatActivity appCompatActivity = (AppCompatActivity) context;
            if (!appCompatActivity.isFinishing() && this$0.f3545d && (bVar = this$0.f3543b) != null && (i10 = bVar.i()) != null && !i10.isShowing()) {
                appCompatActivity.overridePendingTransition(0, 0);
                appCompatActivity.finish();
            }
        }
    }

    public final void g() {
        androidx.appcompat.app.b bVar = this.f3542a;
        if (bVar != null && bVar.isShowing()) {
            bVar.dismiss();
        }
        this.f3542a = null;
        this.f3544c = null;
    }

    public final COUIEditText h() {
        return this.f3544c;
    }

    public final void i(androidx.appcompat.app.b bVar, boolean z10, String hint) {
        kotlin.jvm.internal.i.f(hint, "hint");
        k(this, bVar, z10, hint, false, 8, null);
    }

    public final void j(androidx.appcompat.app.b bVar, boolean z10, String hint, boolean z11) {
        Window window;
        kotlin.jvm.internal.i.f(hint, "hint");
        if (bVar == null) {
            return;
        }
        COUIEditText cOUIEditText = (COUIEditText) bVar.findViewById(com.oplus.blacklistapp.p.f27397k0);
        this.f3544c = cOUIEditText;
        if (cOUIEditText != null) {
            cOUIEditText.setHint(hint);
        }
        COUIEditText cOUIEditText2 = this.f3544c;
        if (cOUIEditText2 != null) {
            cOUIEditText2.setOnClickListener(new View.OnClickListener() { // from class: S8.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.l(view);
                }
            });
        }
        COUIEditText cOUIEditText3 = this.f3544c;
        if (cOUIEditText3 != null) {
            cOUIEditText3.setSelectAllOnFocus(true);
        }
        COUIEditText cOUIEditText4 = this.f3544c;
        if (cOUIEditText4 != null) {
            cOUIEditText4.addTextChangedListener(new b(z11));
        }
        COUIEditText cOUIEditText5 = this.f3544c;
        if (cOUIEditText5 != null) {
            cOUIEditText5.setOnEditorActionListener(new c());
        }
        if (z10) {
            COUIEditText cOUIEditText6 = this.f3544c;
            if (cOUIEditText6 != null) {
                cOUIEditText6.setFocusable(true);
            }
            COUIEditText cOUIEditText7 = this.f3544c;
            if (cOUIEditText7 != null) {
                cOUIEditText7.requestFocus();
            }
            androidx.appcompat.app.b bVar2 = this.f3542a;
            if (bVar2 != null) {
                window = bVar2.getWindow();
            } else {
                window = null;
            }
            if (window != null) {
                window.setSoftInputMode(5);
            }
        }
    }

    public final androidx.appcompat.app.b m(Context context, int i10, i listener, String title, String str, String negativeButtonText, String positiveButtonText) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(listener, "listener");
        kotlin.jvm.internal.i.f(title, "title");
        kotlin.jvm.internal.i.f(negativeButtonText, "negativeButtonText");
        kotlin.jvm.internal.i.f(positiveButtonText, "positiveButtonText");
        return o(this, context, i10, listener, title, str, negativeButtonText, positiveButtonText, false, 128, null);
    }

    public final androidx.appcompat.app.b n(final Context context, int i10, final i listener, String title, String str, String negativeButtonText, String positiveButtonText, final boolean z10) {
        androidx.appcompat.app.b bVar;
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(listener, "listener");
        kotlin.jvm.internal.i.f(title, "title");
        kotlin.jvm.internal.i.f(negativeButtonText, "negativeButtonText");
        kotlin.jvm.internal.i.f(positiveButtonText, "positiveButtonText");
        androidx.appcompat.app.b bVar2 = this.f3542a;
        if (bVar2 != null && bVar2.isShowing() && (bVar = this.f3542a) != null) {
            bVar.dismiss();
        }
        this.f3543b = new S8.b(context, X8.n.f5033e, 0, 4, null);
        Object systemService = context.getSystemService("layout_inflater");
        kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        androidx.appcompat.app.b bVar3 = null;
        View inflate = ((LayoutInflater) systemService).inflate(i10, (ViewGroup) null);
        S8.b bVar4 = this.f3543b;
        if (bVar4 != null) {
            bVar4.setTitle((CharSequence) title);
            if (str != null) {
                bVar4.setMessage((CharSequence) str);
            }
            bVar4.setView(inflate);
            bVar4.setNegativeButton((CharSequence) negativeButtonText, new DialogInterface.OnClickListener() { // from class: S8.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    h.p(i.this, dialogInterface, i11);
                }
            });
            bVar4.setPositiveButton((CharSequence) positiveButtonText, new DialogInterface.OnClickListener() { // from class: S8.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    h.q(i.this, dialogInterface, i11);
                }
            });
            bVar4.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: S8.f
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    h.r(z10, context, this, dialogInterface);
                }
            });
        }
        S8.b bVar5 = this.f3543b;
        if (bVar5 != null) {
            bVar3 = bVar5.show();
        }
        this.f3542a = bVar3;
        S8.b bVar6 = this.f3543b;
        if (bVar6 != null) {
            bVar6.j(-1, false);
        }
        S8.b bVar7 = this.f3543b;
        if (bVar7 != null) {
            bVar7.updateViewAfterShown();
        }
        return this.f3542a;
    }

    public static final void l(View view) {
    }
}
