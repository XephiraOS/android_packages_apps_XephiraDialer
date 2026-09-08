package com.android.incallui.mvvm.view;

import O1.w;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.DialerKeyListener;
import android.text.method.NumberKeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.lifecycle.K;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c2.C0551b;
import com.android.incallui.BaseFragment;
import com.android.incallui.Log;
import com.android.incallui.Presenter;
import com.android.incallui.R;
import com.android.incallui.Ui;
import com.android.incallui.mvvm.command_model.DialpadCommandModel;
import com.android.incallui.mvvm.view_model.DialpadViewModel;
import e2.C0967b;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: OplusDialpadFragment.kt */
/* loaded from: classes.dex */
public final class OplusDialpadFragment extends BaseFragment<Presenter<Ui>, Ui> {

    /* renamed from: a, reason: collision with root package name */
    public final a f18634a = new a();

    /* renamed from: b, reason: collision with root package name */
    public final m9.d f18635b;

    /* renamed from: c, reason: collision with root package name */
    public final m9.d f18636c;

    /* compiled from: OplusDialpadFragment.kt */
    /* loaded from: classes.dex */
    public final class a extends DialerKeyListener {
        public a() {
        }

        public final char a(KeyEvent keyEvent) {
            char match;
            int metaState = keyEvent.getMetaState();
            char number = keyEvent.getNumber();
            if (((metaState & 3) != 0 || number == 0) && (match = keyEvent.getMatch(getAcceptedChars(), metaState)) != 0) {
                number = match;
            }
            return number;
        }

        public final boolean b(KeyEvent event) {
            kotlin.jvm.internal.i.f(event, "event");
            char a10 = a(event);
            Log.d("OplusDialpadFragment", "DTMFKeyListener.onKeyDown: event '" + a10 + '\'');
            if (event.getRepeatCount() == 0 && a10 != 0) {
                if (NumberKeyListener.ok(getAcceptedChars(), a10)) {
                    Log.d("OplusDialpadFragment", "DTMFKeyListener reading '" + a10 + "' from input.");
                    OplusDialpadFragment.this.g1().d().invoke(Character.valueOf(a10));
                    return true;
                }
                Log.d("OplusDialpadFragment", "DTMFKeyListener rejecting '" + a10 + "' from input.");
                return false;
            }
            return false;
        }

        @Override // android.text.method.BaseKeyListener
        public boolean backspace(View view, Editable content, int i10, KeyEvent event) {
            kotlin.jvm.internal.i.f(view, "view");
            kotlin.jvm.internal.i.f(content, "content");
            kotlin.jvm.internal.i.f(event, "event");
            return false;
        }

        public final boolean c(KeyEvent keyEvent) {
            if (keyEvent == null) {
                return true;
            }
            char a10 = a(keyEvent);
            Log.d("OplusDialpadFragment", "DTMFKeyListener.onKeyUp: event '" + a10 + '\'');
            boolean ok = NumberKeyListener.ok(getAcceptedChars(), a10);
            OplusDialpadFragment oplusDialpadFragment = OplusDialpadFragment.this;
            if (ok) {
                Log.d("OplusDialpadFragment", "Stopping the tone for '" + a10 + '\'');
                oplusDialpadFragment.g1().e().invoke();
                return true;
            }
            return ok;
        }

        @Override // android.text.method.DialerKeyListener, android.text.method.NumberKeyListener
        public char[] getAcceptedChars() {
            char[] K10;
            Pair<Character, String>[] a10 = DialpadViewModel.f18704f.a();
            ArrayList arrayList = new ArrayList(a10.length);
            for (Pair<Character, String> pair : a10) {
                Character c10 = pair.c();
                c10.charValue();
                arrayList.add(c10);
            }
            K10 = CollectionsKt___CollectionsKt.K(arrayList);
            return K10;
        }

        @Override // android.text.method.NumberKeyListener, android.text.method.BaseKeyListener, android.text.method.MetaKeyKeyListener, android.text.method.KeyListener
        public boolean onKeyDown(View view, Editable content, int i10, KeyEvent event) {
            kotlin.jvm.internal.i.f(view, "view");
            kotlin.jvm.internal.i.f(content, "content");
            kotlin.jvm.internal.i.f(event, "event");
            char lookup = (char) lookup(event, content);
            if (event.getRepeatCount() == 0 && super.onKeyDown(view, content, i10, event)) {
                boolean ok = NumberKeyListener.ok(getAcceptedChars(), lookup);
                Log.d("OplusDialpadFragment", "DTMFKeyListener reading '" + lookup + "' from input. keyOK = " + ok);
                if (ok) {
                    OplusDialpadFragment.this.g1().d().invoke(Character.valueOf(lookup));
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // android.text.method.MetaKeyKeyListener, android.text.method.KeyListener
        public boolean onKeyUp(View view, Editable content, int i10, KeyEvent event) {
            kotlin.jvm.internal.i.f(view, "view");
            kotlin.jvm.internal.i.f(content, "content");
            kotlin.jvm.internal.i.f(event, "event");
            super.onKeyUp(view, content, i10, event);
            char lookup = (char) lookup(event, content);
            boolean ok = NumberKeyListener.ok(getAcceptedChars(), lookup);
            OplusDialpadFragment oplusDialpadFragment = OplusDialpadFragment.this;
            if (ok) {
                Log.d("OplusDialpadFragment", "Stopping the tone for '" + lookup + "'.");
                oplusDialpadFragment.g1().e().invoke();
            }
            return ok;
        }
    }

    /* compiled from: OplusDialpadFragment.kt */
    /* loaded from: classes.dex */
    public static final class b extends Presenter<Ui> {
    }

    public OplusDialpadFragment() {
        m9.d b10;
        m9.d b11;
        b10 = kotlin.a.b(new InterfaceC1637a<DialpadViewModel>() { // from class: com.android.incallui.mvvm.view.OplusDialpadFragment$mDialpadViewModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final DialpadViewModel invoke() {
                return (DialpadViewModel) new K(OplusDialpadFragment.this).a(DialpadViewModel.class);
            }
        });
        this.f18635b = b10;
        b11 = kotlin.a.b(new InterfaceC1637a<DialpadCommandModel>() { // from class: com.android.incallui.mvvm.view.OplusDialpadFragment$mDialpadCommandModel$2
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final DialpadCommandModel invoke() {
                DialpadViewModel h12;
                h12 = OplusDialpadFragment.this.h1();
                return new DialpadCommandModel(h12);
            }
        });
        this.f18636c = b11;
    }

    private final void initView(View view) {
        boolean z10;
        boolean z11;
        Integer num;
        String valueOf;
        EditText editText = (EditText) view.findViewById(R.id.et_dtmf_dialer_field);
        editText.setKeyListener(this.f18634a);
        editText.setShowSoftInputOnFocus(false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_dialpad_buttons);
        recyclerView.setLayoutManager(new GridLayoutManager(requireActivity(), 3));
        DialpadCommandModel g12 = g1();
        Pair<Character, String>[] a10 = DialpadViewModel.f18704f.a();
        ArrayList arrayList = new ArrayList(a10.length);
        for (Pair<Character, String> pair : a10) {
            char charValue = pair.c().charValue();
            String d10 = pair.d();
            if (charValue != '*' && charValue != '#' && charValue != '0') {
                z10 = true;
            } else {
                z10 = false;
            }
            if (charValue != '*' && charValue != '#') {
                z11 = true;
            } else {
                z11 = false;
            }
            if (charValue == '*') {
                num = Integer.valueOf(R.drawable.incall_ic_dialpad_star);
            } else if (charValue == '#') {
                num = Integer.valueOf(R.drawable.incall_ic_dialpad_hash);
            } else {
                num = null;
            }
            Integer num2 = num;
            if (charValue == '*') {
                valueOf = getString(R.string.oplus_star_string);
            } else if (charValue == '#') {
                valueOf = getString(R.string.oplus_well_string);
            } else {
                valueOf = String.valueOf(charValue);
            }
            kotlin.jvm.internal.i.e(valueOf, "when (numberChar) {\n    …                        }");
            arrayList.add(new C0967b(charValue, z11, d10, z10, num2, valueOf));
        }
        recyclerView.setAdapter(new C0551b(g12, arrayList));
    }

    @Override // com.android.incallui.BaseFragment
    public Presenter<Ui> createPresenter() {
        return new b();
    }

    public final void e1() {
        h1().i().o("");
        q qVar = q.f35511a;
        Log.d("OplusDialpadFragment", "clearDigits()...");
    }

    public final String f1() {
        String value = h1().i().getValue();
        Log.d("OplusDialpadFragment", "getDigits() : " + value);
        return value;
    }

    public final DialpadCommandModel g1() {
        return (DialpadCommandModel) this.f18636c.getValue();
    }

    public final DialpadViewModel h1() {
        return (DialpadViewModel) this.f18635b.getValue();
    }

    public final boolean j1(KeyEvent event) {
        kotlin.jvm.internal.i.f(event, "event");
        boolean b10 = this.f18634a.b(event);
        Log.d("OplusDialpadFragment", "Notifying dtmf key down: " + b10);
        return b10;
    }

    public final boolean k1(KeyEvent keyEvent) {
        boolean c10 = this.f18634a.c(keyEvent);
        Log.d("OplusDialpadFragment", "Notifying dtmf key up: " + c10);
        return c10;
    }

    public final void l1(boolean z10) {
        h1().j().o(Boolean.valueOf(z10));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        Log.d("OplusDialpadFragment", "onCreateView...");
        View it = inflater.inflate(R.layout.oplus_dialpad_fragment, viewGroup, false);
        w i12 = w.i1(it);
        i12.k1(h1());
        i12.b1(getViewLifecycleOwner());
        kotlin.jvm.internal.i.e(it, "it");
        initView(it);
        return it;
    }

    @Override // com.android.incallui.Ui
    public void setVisible(boolean z10) {
        int i10;
        Log.d("OplusDialpadFragment", "setVisible vis = " + z10);
        View view = getView();
        if (view != null) {
            if (z10) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            view.setVisibility(i10);
        }
    }

    @Override // com.android.incallui.BaseFragment
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public OplusDialpadFragment getUi() {
        return this;
    }
}
