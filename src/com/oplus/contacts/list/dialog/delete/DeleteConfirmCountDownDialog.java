package com.oplus.contacts.list.dialog.delete;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.fragment.app.m;
import androidx.lifecycle.InterfaceC0485h;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.lifecycle.N;
import androidx.lifecycle.p;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.dialer.R;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import m9.g;
import v9.InterfaceC1637a;

/* compiled from: DeleteConfirmCountDownDialog.kt */
/* loaded from: classes3.dex */
public final class DeleteConfirmCountDownDialog extends DialogInterfaceOnCancelListenerC0472c implements DialogInterface.OnShowListener {

    /* renamed from: d, reason: collision with root package name */
    public static final a f27908d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public int f27909a = 3;

    /* renamed from: b, reason: collision with root package name */
    public Button f27910b;

    /* renamed from: c, reason: collision with root package name */
    public final m9.d f27911c;

    /* compiled from: DeleteConfirmCountDownDialog.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final DeleteConfirmCountDownDialog a(int i10) {
            DeleteConfirmCountDownDialog deleteConfirmCountDownDialog = new DeleteConfirmCountDownDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("total_second_time", i10);
            deleteConfirmCountDownDialog.setArguments(bundle);
            return deleteConfirmCountDownDialog;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public DeleteConfirmCountDownDialog() {
        final InterfaceC1637a<Fragment> interfaceC1637a = new InterfaceC1637a<Fragment>() { // from class: com.oplus.contacts.list.dialog.delete.DeleteConfirmCountDownDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f27911c = FragmentViewModelLazyKt.a(this, k.b(DeleteConfirmCountDownDialogViewModel.class), new InterfaceC1637a<M>() { // from class: com.oplus.contacts.list.dialog.delete.DeleteConfirmCountDownDialog$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final M invoke() {
                M viewModelStore = ((N) InterfaceC1637a.this.invoke()).getViewModelStore();
                i.e(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new InterfaceC1637a<K.b>() { // from class: com.oplus.contacts.list.dialog.delete.DeleteConfirmCountDownDialog$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final K.b invoke() {
                Object invoke = InterfaceC1637a.this.invoke();
                InterfaceC0485h interfaceC0485h = invoke instanceof InterfaceC0485h ? (InterfaceC0485h) invoke : null;
                K.b defaultViewModelProviderFactory = interfaceC0485h != null ? interfaceC0485h.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                i.e(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final void i1(DialogInterface dialogInterface, int i10) {
        F.c.a(g.a("key_which_btn", -2), g.a("dialog_fragment_tag", "tag_count_down_dialog"));
    }

    public static final void j1(DeleteConfirmCountDownDialog this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        m.a(this$0, "request_key_dialog_btn_click", F.c.a(g.a("key_which_btn", -1), g.a("dialog_fragment_tag", "tag_count_down_dialog")));
    }

    public final DeleteConfirmCountDownDialogViewModel g1() {
        return (DeleteConfirmCountDownDialogViewModel) this.f27911c.getValue();
    }

    public final void h1() {
        p.a(this).b(new DeleteConfirmCountDownDialog$observeCountDownTimer$1(this, null));
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0472c
    public Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f27909a = arguments.getInt("total_second_time", 3);
        }
        androidx.appcompat.app.b create = new COUIAlertDialogBuilder(requireContext(), 2132083078).setTitle(R.string.delete_multiple_contacts_tips_tablet).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.oplus.contacts.list.dialog.delete.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                DeleteConfirmCountDownDialog.i1(dialogInterface, i10);
            }
        }).setPositiveButton((CharSequence) getString(R.string.countdown_delete_button, Integer.valueOf(this.f27909a)), new DialogInterface.OnClickListener() { // from class: com.oplus.contacts.list.dialog.delete.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                DeleteConfirmCountDownDialog.j1(DeleteConfirmCountDownDialog.this, dialogInterface, i10);
            }
        }).create();
        i.e(create, "dialogBuilder.create()");
        create.setOnShowListener(this);
        return create;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        androidx.appcompat.app.b bVar;
        Dialog dialog = getDialog();
        Button button = null;
        if (dialog instanceof androidx.appcompat.app.b) {
            bVar = (androidx.appcompat.app.b) dialog;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            button = bVar.b(-1);
        }
        this.f27910b = button;
        h1();
        g1().i(this.f27909a);
    }
}
