package com.android.contacts.scenecard;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DialerKeyListener;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.contacts.dialpad.view.DialEditText;
import com.customize.contacts.widget.DialDeleteImageButton;
import com.oplus.dialer.R;
import h1.C1073b;
import h1.C1074c;
import java.lang.reflect.Field;
import kotlin.Result;
import kotlin.text.Regex;
import kotlinx.coroutines.C1248i;

/* compiled from: SceneDialTextEditor.kt */
/* loaded from: classes.dex */
public final class SceneDialTextEditor {

    /* renamed from: o, reason: collision with root package name */
    public static final a f17185o = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f17186a;

    /* renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.E f17187b;

    /* renamed from: c, reason: collision with root package name */
    public x0.t f17188c;

    /* renamed from: d, reason: collision with root package name */
    public SceneDialPadViewController f17189d;

    /* renamed from: e, reason: collision with root package name */
    public final int f17190e;

    /* renamed from: f, reason: collision with root package name */
    public final int f17191f;

    /* renamed from: g, reason: collision with root package name */
    public final float f17192g;

    /* renamed from: h, reason: collision with root package name */
    public final kotlinx.coroutines.flow.i<String> f17193h;

    /* renamed from: i, reason: collision with root package name */
    public final kotlinx.coroutines.flow.m<String> f17194i;

    /* renamed from: j, reason: collision with root package name */
    public String f17195j;

    /* renamed from: k, reason: collision with root package name */
    public final SceneDialTextEditor$dialEditTextWatcher$1 f17196k;

    /* renamed from: l, reason: collision with root package name */
    public final View.OnTouchListener f17197l;

    /* renamed from: m, reason: collision with root package name */
    public final View.OnClickListener f17198m;

    /* renamed from: n, reason: collision with root package name */
    public final View.OnLongClickListener f17199n;

    /* compiled from: SceneDialTextEditor.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [com.android.contacts.scenecard.SceneDialTextEditor$dialEditTextWatcher$1] */
    public SceneDialTextEditor(Context context, kotlinx.coroutines.E coroutineScope) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(coroutineScope, "coroutineScope");
        this.f17186a = context;
        this.f17187b = coroutineScope;
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f17192g = f10;
        kotlinx.coroutines.flow.i<String> a10 = kotlinx.coroutines.flow.n.a(null);
        this.f17193h = a10;
        this.f17194i = a10;
        this.f17195j = "";
        this.f17190e = (int) ((context.getResources().getDimensionPixelSize(R.dimen.DP_20) / f10) + 0.5f);
        this.f17191f = (int) ((context.getResources().getDimensionPixelSize(R.dimen.DP_18) / f10) + 0.5f);
        this.f17196k = new TextWatcher() { // from class: com.android.contacts.scenecard.SceneDialTextEditor$dialEditTextWatcher$1
            /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
            /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
            @Override // android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void afterTextChanged(android.text.Editable r10) {
                /*
                    Method dump skipped, instructions count: 266
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.scenecard.SceneDialTextEditor$dialEditTextWatcher$1.afterTextChanged(android.text.Editable):void");
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence input, int i10, int i11, int i12) {
                kotlin.jvm.internal.i.f(input, "input");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence input, int i10, int i11, int i12) {
                kotlin.jvm.internal.i.f(input, "input");
            }
        };
        this.f17197l = new View.OnTouchListener() { // from class: com.android.contacts.scenecard.p
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean q10;
                q10 = SceneDialTextEditor.q(SceneDialTextEditor.this, view, motionEvent);
                return q10;
            }
        };
        this.f17198m = new View.OnClickListener() { // from class: com.android.contacts.scenecard.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SceneDialTextEditor.o(SceneDialTextEditor.this, view);
            }
        };
        this.f17199n = new View.OnLongClickListener() { // from class: com.android.contacts.scenecard.r
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean p10;
                p10 = SceneDialTextEditor.p(SceneDialTextEditor.this, view);
                return p10;
            }
        };
    }

    public static final void o(SceneDialTextEditor this$0, View view) {
        DialEditText dialEditText;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        view.setSoundEffectsEnabled(true);
        this$0.A(67);
        x0.t tVar = this$0.f17188c;
        if (tVar != null && (dialEditText = tVar.f37784I) != null) {
            dialEditText.requestFocus();
            if (this$0.v() == 0) {
                this$0.D(false);
            } else if (dialEditText.getSelectionStart() == dialEditText.getSelectionEnd() && dialEditText.getSelectionStart() != this$0.v()) {
                this$0.D(true);
            }
            SceneDialPadViewController sceneDialPadViewController = this$0.f17189d;
            if (sceneDialPadViewController != null) {
                sceneDialPadViewController.l0();
            }
        }
    }

    public static final boolean p(SceneDialTextEditor this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        return this$0.n();
    }

    public static final boolean q(SceneDialTextEditor this$0, View view, MotionEvent motionEvent) {
        SceneDialPadViewController sceneDialPadViewController;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
            } else {
                EditText editText = null;
                if (!this$0.z()) {
                    this$0.D(true);
                    SceneDialPadViewController sceneDialPadViewController2 = this$0.f17189d;
                    if (sceneDialPadViewController2 != null && !sceneDialPadViewController2.J() && (sceneDialPadViewController = this$0.f17189d) != null) {
                        SceneDialPadViewController.d0(sceneDialPadViewController, false, 1, null);
                    }
                }
                if (view instanceof EditText) {
                    editText = (EditText) view;
                }
                this$0.r(editText);
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            view.getParent().requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }

    public static final boolean y(View view) {
        return true;
    }

    public final void A(int i10) {
        DialEditText dialEditText;
        x0.t tVar;
        DialEditText dialEditText2;
        DialEditText dialEditText3;
        KeyEvent keyEvent = new KeyEvent(0, i10);
        x0.t tVar2 = this.f17188c;
        if (tVar2 != null && (dialEditText3 = tVar2.f37784I) != null) {
            dialEditText3.onKeyDown(i10, keyEvent);
        }
        if (i10 != 67) {
            int v10 = v();
            x0.t tVar3 = this.f17188c;
            if (tVar3 != null && (dialEditText = tVar3.f37784I) != null && v10 == dialEditText.getSelectionStart() && (tVar = this.f17188c) != null && (dialEditText2 = tVar.f37784I) != null && v10 == dialEditText2.getSelectionEnd()) {
                D(false);
            }
        }
    }

    public final void B(String str) {
        C1248i.d(this.f17187b, kotlinx.coroutines.S.b(), null, new SceneDialTextEditor$queryLocation$1(this, str, null), 2, null);
    }

    public final void C(String text) {
        DialEditText dialEditText;
        kotlin.jvm.internal.i.f(text, "text");
        x0.t tVar = this.f17188c;
        if (tVar != null && (dialEditText = tVar.f37784I) != null) {
            dialEditText.setText(text);
        }
    }

    public final void D(boolean z10) {
        DialEditText dialEditText;
        x0.t tVar = this.f17188c;
        if (tVar != null) {
            dialEditText = tVar.f37784I;
        } else {
            dialEditText = null;
        }
        if (dialEditText != null) {
            dialEditText.setCursorVisible(z10);
        }
    }

    public final void E(SceneDialPadViewController dialPadViewController) {
        kotlin.jvm.internal.i.f(dialPadViewController, "dialPadViewController");
        this.f17189d = dialPadViewController;
    }

    public final void F(boolean z10) {
        View view;
        int i10;
        H7.b.e("SceneDialTextEditor", "showOrHideBottomDividerLine : " + z10);
        x0.t tVar = this.f17188c;
        if (tVar != null) {
            view = tVar.f37782G;
        } else {
            view = null;
        }
        if (view != null) {
            if (!z10) {
                i10 = 4;
            } else {
                i10 = 0;
            }
            view.setVisibility(i10);
        }
    }

    public final void G(boolean z10) {
        boolean v10;
        boolean v11;
        boolean v12;
        boolean v13;
        boolean v14;
        H7.b.e("SceneDialTextEditor", "showOrHideLocation : " + z10);
        TextView textView = null;
        if (z10) {
            String b10 = new Regex("[ \\-().\\s]").b(u(), "");
            int length = b10.length();
            if (2 <= length && length < 21) {
                if (b10.length() >= 5) {
                    int length2 = C1073b.c().length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length2) {
                            break;
                        }
                        String str = C1073b.c()[i10];
                        kotlin.jvm.internal.i.e(str, "PhoneNumberFormatUtils.getIpcallPrefix()[i]");
                        v14 = kotlin.text.n.v(b10, str, false, 2, null);
                        if (v14) {
                            b10 = b10.substring(C1073b.c()[i10].length());
                            kotlin.jvm.internal.i.e(b10, "substring(...)");
                            break;
                        }
                        i10++;
                    }
                }
                if (b10.length() == 0) {
                    x0.t tVar = this.f17188c;
                    if (tVar != null) {
                        textView = tVar.f37786K;
                    }
                    if (textView != null) {
                        textView.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (b10.charAt(0) == '0') {
                    if (b10.length() == 3 && (b10.charAt(1) == '2' || b10.charAt(1) == '1')) {
                        B(b10);
                    } else {
                        if (b10.length() >= 4) {
                            v13 = kotlin.text.n.v(b10, "00", false, 2, null);
                            if (!v13) {
                                B(b10);
                            }
                        }
                        if (b10.length() >= 5) {
                            v12 = kotlin.text.n.v(b10, "008", false, 2, null);
                            if (v12) {
                                B(b10);
                            }
                        }
                        if (b10.length() >= 3) {
                            v11 = kotlin.text.n.v(b10, "00", false, 2, null);
                            if (v11) {
                                B(b10);
                            }
                        }
                    }
                    if (b10.length() < 4) {
                        if (b10.length() != 3 || (b10.charAt(1) != '1' && b10.charAt(1) != '2')) {
                            x0.t tVar2 = this.f17188c;
                            if (tVar2 != null) {
                                textView = tVar2.f37786K;
                            }
                            if (textView != null) {
                                textView.setVisibility(8);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (b10.charAt(0) != '1') {
                    v10 = kotlin.text.n.v(b10, "+", false, 2, null);
                    if (v10) {
                        if (b10.length() >= 3) {
                            B(b10);
                        }
                        if (b10.length() < 3) {
                            x0.t tVar3 = this.f17188c;
                            if (tVar3 != null) {
                                textView = tVar3.f37786K;
                            }
                            if (textView != null) {
                                textView.setVisibility(8);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    x0.t tVar4 = this.f17188c;
                    if (tVar4 != null) {
                        textView = tVar4.f37786K;
                    }
                    if (textView != null) {
                        textView.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (b10.length() >= 7) {
                    B(b10);
                    return;
                }
                x0.t tVar5 = this.f17188c;
                if (tVar5 != null) {
                    textView = tVar5.f37786K;
                }
                if (textView != null) {
                    textView.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        x0.t tVar6 = this.f17188c;
        if (tVar6 != null) {
            textView = tVar6.f37786K;
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final boolean l(String symbol) {
        DialEditText dialEditText;
        kotlin.jvm.internal.i.f(symbol, "symbol");
        if (v() == 0) {
            return false;
        }
        x0.t tVar = this.f17188c;
        if (tVar != null && (dialEditText = tVar.f37784I) != null) {
            int selectionStart = dialEditText.getSelectionStart();
            int selectionEnd = dialEditText.getSelectionEnd();
            int min = Math.min(selectionStart, selectionEnd);
            int max = Math.max(selectionStart, selectionEnd);
            Editable text = dialEditText.getText();
            if (text != null) {
                kotlin.jvm.internal.i.e(text, "text ?: return@apply");
                if (min != -1) {
                    if (min <= text.length() && max <= text.length()) {
                        if (min == max) {
                            text.replace(min, min, symbol);
                        } else {
                            text.replace(min, max, symbol);
                            int i10 = min + 1;
                            if (i10 <= dialEditText.length()) {
                                dialEditText.setSelection(i10);
                            }
                        }
                    }
                } else {
                    int length = dialEditText.length();
                    text.replace(length, length, symbol);
                }
            }
        }
        return true;
    }

    public final void m() {
        DialEditText dialEditText;
        Editable text;
        x0.t tVar = this.f17188c;
        if (tVar != null && (dialEditText = tVar.f37784I) != null && (text = dialEditText.getText()) != null) {
            text.clear();
        }
    }

    public final boolean n() {
        DialEditText dialEditText;
        H7.b.e("SceneDialTextEditor", "deleteDialTextBeforeCursor");
        if (z()) {
            return false;
        }
        x0.t tVar = this.f17188c;
        if (tVar != null && (dialEditText = tVar.f37784I) != null) {
            int selectionStart = dialEditText.getSelectionStart();
            String u10 = u();
            char[] charArray = u10.toCharArray();
            kotlin.jvm.internal.i.e(charArray, "toCharArray(...)");
            int length = u10.length();
            H7.b.e("SceneDialTextEditor", "deleteDialTextBeforeCursor index = " + selectionStart + "length = " + length);
            if (selectionStart < length) {
                dialEditText.setText(charArray, selectionStart, length - selectionStart);
                dialEditText.setSelection(0);
            } else {
                C("");
                D(false);
            }
            SceneDialPadViewController sceneDialPadViewController = this.f17189d;
            if (sceneDialPadViewController != null) {
                sceneDialPadViewController.l0();
                return true;
            }
            return true;
        }
        return true;
    }

    public final void r(EditText editText) {
        Object b10;
        if (editText != null) {
            try {
                Result.a aVar = Result.f34166a;
                Field declaredField = TextView.class.getDeclaredField("mEditor");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(editText);
                Field declaredField2 = obj.getClass().getDeclaredField("mInsertionControllerEnabled");
                declaredField2.setAccessible(true);
                declaredField2.set(obj, Boolean.FALSE);
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("SceneDialTextEditor", "disableEditorInsertionController : " + d10 + " " + d10.getMessage());
                return;
            }
            return;
        }
        H7.b.c("SceneDialTextEditor", "disableEditorInsertionController : editText is null");
    }

    public final Context s() {
        return this.f17186a;
    }

    public final kotlinx.coroutines.E t() {
        return this.f17187b;
    }

    public final String u() {
        DialEditText dialEditText;
        Editable text;
        String obj;
        x0.t tVar = this.f17188c;
        if (tVar == null || (dialEditText = tVar.f37784I) == null || (text = dialEditText.getText()) == null || (obj = text.toString()) == null) {
            return "";
        }
        return obj;
    }

    public final int v() {
        DialEditText dialEditText;
        Editable text;
        x0.t tVar = this.f17188c;
        if (tVar != null && (dialEditText = tVar.f37784I) != null && (text = dialEditText.getText()) != null) {
            return text.length();
        }
        return 0;
    }

    public final kotlinx.coroutines.flow.m<String> w() {
        return this.f17194i;
    }

    public final void x(androidx.databinding.o dialEditTextContainerStubProxy) {
        kotlin.jvm.internal.i.f(dialEditTextContainerStubProxy, "dialEditTextContainerStubProxy");
        if (!dialEditTextContainerStubProxy.j()) {
            H7.b.e("SceneDialTextEditor", "initDialEditTextContainer");
            ViewStub i10 = dialEditTextContainerStubProxy.i();
            if (i10 != null) {
                i10.inflate();
            }
            ViewDataBinding g10 = dialEditTextContainerStubProxy.g();
            kotlin.jvm.internal.i.d(g10, "null cannot be cast to non-null type com.android.contacts.databinding.SceneDialEditTextContainerBinding");
            x0.t tVar = (x0.t) g10;
            this.f17188c = tVar;
            DialEditText dialEditText = tVar.f37784I;
            dialEditText.setShowSoftInputOnFocus(false);
            dialEditText.setKeyListener(DialerKeyListener.getInstance());
            dialEditText.addTextChangedListener(this.f17196k);
            dialEditText.setOnTouchListener(this.f17197l);
            dialEditText.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.android.contacts.scenecard.o
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean y10;
                    y10 = SceneDialTextEditor.y(view);
                    return y10;
                }
            });
            C1074c.d(dialEditText.getContext(), dialEditText);
            androidx.core.widget.k.j(dialEditText, new b());
            DialDeleteImageButton dialDeleteImageButton = tVar.f37783H;
            dialDeleteImageButton.setOnClickListener(this.f17198m);
            dialDeleteImageButton.setOnLongClickListener(this.f17199n);
        }
    }

    public final boolean z() {
        if (v() == 0) {
            return true;
        }
        return false;
    }

    /* compiled from: SceneDialTextEditor.kt */
    /* loaded from: classes.dex */
    public static final class b implements ActionMode.Callback {
        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            if (menu != null) {
                menu.clear();
                return false;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }
    }
}
