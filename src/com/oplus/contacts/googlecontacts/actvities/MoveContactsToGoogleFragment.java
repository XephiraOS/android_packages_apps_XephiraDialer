package com.oplus.contacts.googlecontacts.actvities;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.p;
import c.C0543d;
import com.android.contacts.framework.baseui.util.A;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.button.SingleButtonWrap;
import com.oplus.contacts.googlecontacts.GoogleContactsImpl;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import m9.q;

/* compiled from: MoveContactsToGoogleFragment.kt */
/* loaded from: classes3.dex */
public final class MoveContactsToGoogleFragment extends Fragment implements View.OnClickListener, OnAccountsUpdateListener {

    /* renamed from: g, reason: collision with root package name */
    public static final a f27822g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public View f27823a;

    /* renamed from: b, reason: collision with root package name */
    public View f27824b;

    /* renamed from: c, reason: collision with root package name */
    public View f27825c;

    /* renamed from: d, reason: collision with root package name */
    public SingleButtonWrap f27826d;

    /* renamed from: e, reason: collision with root package name */
    public SingleButtonWrap f27827e;

    /* renamed from: f, reason: collision with root package name */
    public final androidx.activity.result.b<Intent> f27828f;

    /* compiled from: MoveContactsToGoogleFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public MoveContactsToGoogleFragment() {
        androidx.activity.result.b<Intent> registerForActivityResult = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: com.oplus.contacts.googlecontacts.actvities.c
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                MoveContactsToGoogleFragment.h1(MoveContactsToGoogleFragment.this, (ActivityResult) obj);
            }
        });
        i.e(registerForActivityResult, "registerForActivityResul…        }\n        }\n    }");
        this.f27828f = registerForActivityResult;
    }

    public static final void h1(MoveContactsToGoogleFragment this$0, ActivityResult activityResult) {
        Intent b10;
        i.f(this$0, "this$0");
        if (activityResult.d() == -1 && (b10 = activityResult.b()) != null) {
            boolean booleanExtra = b10.getBooleanExtra("result_success", false);
            if (b10.getBooleanExtra("result_success", false) && b10.getIntExtra("actual_count", 0) > 0) {
                e eVar = new e();
                eVar.setArguments(b10.getExtras());
                this$0.getChildFragmentManager().p().e(eVar, "move_result").j();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("transfer_result", Integer.valueOf(booleanExtra ? 1 : 0));
            A.a(this$0.getContext(), 2000314, 200033601, hashMap, false);
        }
    }

    public final void d1() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            Account[] accountsByType = AccountManager.get(getContext()).getAccountsByType("com.google");
            i.e(accountsByType, "get(context).getAccounts…tant.GOOGLE_ACCOUNT_TYPE)");
            int length = accountsByType.length;
            ArrayList<String> arrayList = new ArrayList<>(length);
            if (1 <= length) {
                int i10 = 1;
                while (true) {
                    arrayList.add(accountsByType[length - i10].name);
                    if (i10 == length) {
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            j1(arrayList);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("MoveContactsToGoogleFragment", "moveToGoogle getAccountsByType: " + d10.getMessage());
        }
    }

    public final void e1() {
        Context context = getContext();
        if (context != null) {
            GoogleContactsImpl.f27813c.a().h(context);
        }
    }

    public final void f1() {
        int p12;
        View view;
        FragmentActivity activity = getActivity();
        if ((activity instanceof MoveContactsToGoogleActivity) && (p12 = ((MoveContactsToGoogleActivity) activity).p1()) > 0 && (view = this.f27825c) != null) {
            view.setPadding(0, 0, 0, p12);
        }
    }

    public final void g1(String str) {
        Context applicationContext;
        Context context = getContext();
        if (context != null && (applicationContext = context.getApplicationContext()) != null) {
            C1248i.d(p.a(this), S.b(), null, new MoveContactsToGoogleFragment$saveDefaultGoogleAccount$1$1(str, applicationContext, null), 2, null);
        }
    }

    public final void i1() {
        String e12;
        Object b10;
        q qVar;
        Fragment m02 = getChildFragmentManager().m0("google_account_list");
        if ((m02 instanceof b) && (e12 = ((b) m02).e1()) != null) {
            try {
                Result.a aVar = Result.f34166a;
                g1(e12);
                Intent intent = new Intent("com.oplus.contacts.proc.COPY_CONTACTS_BETWEEN_ACCOUNTS");
                intent.putExtra("SRC_ACCOUNT", new com.android.contacts.model.Account(R0.a.f3165a, R0.a.f3166b));
                intent.putExtra("DEST_ACCOUNT", new com.android.contacts.model.Account(e12, "com.google"));
                intent.putExtra("need_delete", true);
                intent.putExtra("return_result", true);
                intent.putExtra("can_cancel", false);
                intent.putExtra("tittle_id", Y6.e.f5558b);
                Context context = getContext();
                if (context != null) {
                    intent.setPackage(context.getPackageName());
                    this.f27828f.a(intent);
                    qVar = q.f35511a;
                } else {
                    qVar = null;
                }
                b10 = Result.b(qVar);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("MoveContactsToGoogleFragment", "startMoveContactsToGoogle error: " + d10);
            }
        }
    }

    public final void j1(ArrayList<String> arrayList) {
        k1(arrayList);
        if (!arrayList.isEmpty()) {
            Fragment m02 = getChildFragmentManager().m0("google_account_list");
            if (m02 instanceof b) {
                ((b) m02).f1(arrayList);
                return;
            }
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("arg_google_account_list", arrayList);
            bVar.setArguments(bundle);
            getChildFragmentManager().p().t(Y6.b.f5546a, bVar, "google_account_list").i();
        }
    }

    public final void k1(ArrayList<String> arrayList) {
        View view;
        View view2 = this.f27823a;
        if (view2 != null && (view = this.f27824b) != null) {
            if (arrayList.isEmpty()) {
                view.setVisibility(8);
                view2.setVisibility(0);
            } else {
                view.setVisibility(0);
                view2.setVisibility(8);
            }
        }
    }

    @Override // android.accounts.OnAccountsUpdateListener
    public void onAccountsUpdated(Account[] accountArr) {
        d1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        i.f(v10, "v");
        int id = v10.getId();
        if (id == Y6.b.f5548c) {
            e1();
        } else if (id == Y6.b.f5552g) {
            i1();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        SingleButtonWrap singleButtonWrap = this.f27826d;
        if (singleButtonWrap != null) {
            singleButtonWrap.onConfigurationChanged(newConfig);
        }
        SingleButtonWrap singleButtonWrap2 = this.f27827e;
        if (singleButtonWrap2 != null) {
            singleButtonWrap2.onConfigurationChanged(newConfig);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        View view = inflater.inflate(Y6.c.f5554a, viewGroup, false);
        this.f27823a = view.findViewById(Y6.b.f5551f);
        this.f27824b = view.findViewById(Y6.b.f5547b);
        this.f27825c = view.findViewById(Y6.b.f5549d);
        COUIButton cOUIButton = (COUIButton) view.findViewById(Y6.b.f5548c);
        if (cOUIButton != null) {
            this.f27826d = new SingleButtonWrap(cOUIButton, 0);
            cOUIButton.setOnClickListener(this);
        }
        COUIButton cOUIButton2 = (COUIButton) view.findViewById(Y6.b.f5552g);
        if (cOUIButton2 != null) {
            this.f27827e = new SingleButtonWrap(cOUIButton2, 0);
            cOUIButton2.setOnClickListener(this);
        }
        i.e(view, "view");
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SingleButtonWrap singleButtonWrap = this.f27826d;
        if (singleButtonWrap != null) {
            singleButtonWrap.release();
        }
        SingleButtonWrap singleButtonWrap2 = this.f27827e;
        if (singleButtonWrap2 != null) {
            singleButtonWrap2.release();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        AccountManager.get(getContext()).addOnAccountsUpdatedListener(this, null, false);
        d1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        AccountManager.get(getContext()).removeOnAccountsUpdatedListener(this);
        super.onStop();
    }
}
