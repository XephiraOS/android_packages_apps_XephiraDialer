package com.android.contacts.business.calllog.breenocall.summary;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.C0490m;
import androidx.lifecycle.InterfaceC0480c;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.statistics.BreenoCallStatistics;
import com.android.contacts.business.calllog.d;
import com.android.contacts.business.calllog.e;
import com.android.contacts.framework.baseui.util.r;
import com.android.contacts.framework.baseui.util.t;
import com.android.contacts.framework.baseui.widget.ContactsRecommendView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import m9.q;

/* compiled from: AutoCallSummaryTipManager.kt */
/* loaded from: classes.dex */
public final class AutoCallSummaryTipManager extends ContentObserver implements InterfaceC0480c {
    public static final int HIDE_TIP = 0;
    private static final String ISO_CN = "CN";
    private static final boolean LOCAL_DEBUG = false;
    public static final int SHOW_TIP = 1;
    public static final String TIP_ID = "CallSummaryTip";
    private Context context;
    private boolean inSuperPowerSaveMode;
    private Lifecycle lifecycle;
    private String name;
    private final ArrayList<String> normalizedNumbers;
    private final ArrayList<String> numbers;
    private t simpleCallback;
    private final ArrayList<AutoCallSummaryEntity> summaryEntities;
    private ContactsRecommendView tipView;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "AutoCallSummaryTipManager";
    private static final int DEFAULT_SHOW_TIP_MIN_SUMMARY_COUNT = 2;
    private static final boolean USE_UI_NUMBER_FORMAT = true;

    /* compiled from: AutoCallSummaryTipManager.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ArrayList<AutoCallSummaryEntity> loadNumbersSummaryState(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
            int i10 = AutoCallSummaryTipManager.DEFAULT_SHOW_TIP_MIN_SUMMARY_COUNT;
            boolean z10 = true;
            if (!AutoCallSummaryTipManager.LOCAL_DEBUG && (!com.android.contacts.framework.api.breenocall.a.e(true) || !com.android.contacts.framework.api.breenocall.a.c(context))) {
                z10 = false;
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            if (defaultSharedPreferences.contains("count_for_number_call_summary") && (i10 = defaultSharedPreferences.getInt("count_for_number_call_summary", AutoCallSummaryTipManager.DEFAULT_SHOW_TIP_MIN_SUMMARY_COUNT)) <= 0) {
                H7.b.i(AutoCallSummaryTipManager.TAG, "Check the min summary limit count: " + i10);
                i10 = AutoCallSummaryTipManager.DEFAULT_SHOW_TIP_MIN_SUMMARY_COUNT;
            }
            ArrayList<AutoCallSummaryEntity> arrayList3 = new ArrayList<>();
            if (z10) {
                arrayList3 = AutoCallSummaryEntity.Companion.getSummaryEntities(context, arrayList, arrayList2, "(count>=" + i10 + " AND ignored=0 AND whitelist_timestamp=0 AND ever_added=0)");
            }
            H7.b.e(AutoCallSummaryTipManager.TAG, "loadNumbersSummaryState: supportCallSummary: " + z10 + ", minCount: " + i10 + ", summaryEntities: " + arrayList3.size());
            if (H7.a.b()) {
                for (AutoCallSummaryEntity autoCallSummaryEntity : arrayList3) {
                    H7.b.b(AutoCallSummaryTipManager.TAG, H7.a.d(autoCallSummaryEntity.getNumber()) + ", " + autoCallSummaryEntity.getCount());
                }
            }
            return arrayList3;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public /* synthetic */ AutoCallSummaryTipManager(Context context, Lifecycle lifecycle, t tVar, int i10, f fVar) {
        this(context, (i10 & 2) != 0 ? null : lifecycle, (i10 & 4) != 0 ? null : tVar);
    }

    private final void setupTipView() {
        final ContactsRecommendView contactsRecommendView = this.tipView;
        if (contactsRecommendView != null) {
            contactsRecommendView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            final ArrayList arrayList = new ArrayList();
            Iterator<T> it = this.summaryEntities.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((AutoCallSummaryEntity) it.next()).getId()));
            }
            contactsRecommendView.setActionViewClickListener(new View.OnClickListener() { // from class: com.android.contacts.business.calllog.breenocall.summary.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AutoCallSummaryTipManager.setupTipView$lambda$7$lambda$5(AutoCallSummaryTipManager.this, arrayList, contactsRecommendView, view);
                }
            });
            contactsRecommendView.setDismissViewClickListener(new View.OnClickListener() { // from class: com.android.contacts.business.calllog.breenocall.summary.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AutoCallSummaryTipManager.setupTipView$lambda$7$lambda$6(AutoCallSummaryTipManager.this, arrayList, contactsRecommendView, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTipView$lambda$7$lambda$5(AutoCallSummaryTipManager this$0, ArrayList idList, ContactsRecommendView view, View view2) {
        i.f(this$0, "this$0");
        i.f(idList, "$idList");
        i.f(view, "$view");
        BreenoCallSummaryUtils.openAutoCallSummaryForNumber(this$0.context, idList);
        BreenoCallStatistics.Companion.trackTipAction(this$0.context, BreenoCallStatistics.EVENT_ID_SUMMARY_TIP_CLICK, true);
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTipView$lambda$7$lambda$6(AutoCallSummaryTipManager this$0, ArrayList idList, ContactsRecommendView view, View view2) {
        i.f(this$0, "this$0");
        i.f(idList, "$idList");
        i.f(view, "$view");
        BreenoCallSummaryUtils.ignoreCallSummaryTipShow(this$0.context, idList);
        BreenoCallStatistics.Companion.trackTipAction(this$0.context, BreenoCallStatistics.EVENT_ID_SUMMARY_TIP_CLICK, false);
        view.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void update(ArrayList<String> arrayList, ArrayList<AutoCallSummaryEntity> arrayList2, ArrayList<String> arrayList3) {
        this.numbers.clear();
        if (!arrayList.isEmpty()) {
            this.numbers.addAll(arrayList);
        }
        this.normalizedNumbers.clear();
        if (arrayList3 != null && (!arrayList3.isEmpty())) {
            this.normalizedNumbers.addAll(arrayList3);
        }
        if (H7.a.b()) {
            H7.b.b(TAG, "update: number count: " + arrayList.size() + ", " + this.normalizedNumbers.size() + ", list size: " + arrayList2.size());
        }
        this.summaryEntities.clear();
        if (!arrayList2.isEmpty()) {
            this.summaryEntities.addAll(arrayList2);
        }
    }

    private final void updateTipTextContent() {
        boolean z10;
        String str;
        String number;
        String number2;
        int i10 = 0;
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.summaryEntities.size() == 1) {
            if (USE_UI_NUMBER_FORMAT && !z10) {
                number2 = PhoneNumberUtils.formatNumber(this.summaryEntities.get(0).getNumber(), null, ISO_CN);
            } else {
                number2 = this.summaryEntities.get(0).getNumber();
            }
            str = this.context.getString(com.android.contacts.business.calllog.f.f13719h, number2);
            i.e(str, "context.getString(R.stri…ip_for_number_v4, number)");
        } else {
            String str2 = "";
            if (this.summaryEntities.size() <= 1) {
                str = "";
            } else {
                StringBuilder sb = new StringBuilder();
                String string = this.context.getString(com.android.contacts.business.calllog.f.f13720i);
                i.e(string, "context.getString(R.string.punctuation_cn_comma)");
                Iterator<AutoCallSummaryEntity> it = this.summaryEntities.iterator();
                while (it.hasNext()) {
                    AutoCallSummaryEntity next = it.next();
                    i10++;
                    if (USE_UI_NUMBER_FORMAT && !z10) {
                        number = PhoneNumberUtils.formatNumber(next.getNumber(), null, ISO_CN);
                    } else {
                        number = next.getNumber();
                    }
                    sb.append(number);
                    if (i10 < this.summaryEntities.size()) {
                        sb.append(string);
                    }
                }
                Context context = this.context;
                int i11 = com.android.contacts.business.calllog.f.f13718g;
                String str3 = this.name;
                if (str3 != null) {
                    str2 = str3;
                }
                str = context.getString(i11, str2, sb.toString());
                i.e(str, "context.getString(R.stri… name?:\"\", sb.toString())");
            }
        }
        ContactsRecommendView contactsRecommendView = this.tipView;
        if (contactsRecommendView != null) {
            contactsRecommendView.e(com.android.contacts.business.calllog.c.f13708b, str, com.android.contacts.business.calllog.f.f13714c, com.android.contacts.business.calllog.f.f13717f);
        }
    }

    public final void asyncLoad(String str, ArrayList<String> numbers, ArrayList<String> arrayList) {
        LifecycleCoroutineScope a10;
        i.f(numbers, "numbers");
        this.name = str;
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null && (a10 = C0490m.a(lifecycle)) != null) {
            C1248i.d(a10, S.b(), null, new AutoCallSummaryTipManager$asyncLoad$1(this, numbers, arrayList, null), 2, null);
        }
    }

    public final View getTipView(View view, ViewGroup parent) {
        View view2;
        i.f(parent, "parent");
        if (view instanceof ContactsRecommendView) {
            this.tipView = (ContactsRecommendView) view;
        } else if (this.tipView == null) {
            View inflate = LayoutInflater.from(this.context).inflate(e.f13710a, parent, false);
            i.d(inflate, "null cannot be cast to non-null type com.android.contacts.framework.baseui.widget.ContactsRecommendView");
            ContactsRecommendView contactsRecommendView = (ContactsRecommendView) inflate;
            this.tipView = contactsRecommendView;
            if (contactsRecommendView != null) {
                contactsRecommendView.setVisibility(0);
            }
            setupTipView();
            Context context = this.context;
            ContactsRecommendView contactsRecommendView2 = this.tipView;
            if (contactsRecommendView2 != null) {
                view2 = contactsRecommendView2.findViewById(d.f13709a);
            } else {
                view2 = null;
            }
            r.e(context, view2);
        }
        updateTipTextContent();
        return this.tipView;
    }

    public final boolean isShowCallSummaryTip() {
        boolean z10 = true;
        boolean z11 = !this.summaryEntities.isEmpty();
        boolean z12 = !this.inSuperPowerSaveMode;
        if (!z11 || !z12) {
            z10 = false;
        }
        if (H7.a.b()) {
            H7.b.b(TAG, "isShowCallSummaryTip: " + z10 + "[" + z11 + ", " + z12 + "]");
        }
        return z10;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        H7.b.b(TAG, "onChange: " + z10);
        if ((!this.numbers.isEmpty()) || (!this.normalizedNumbers.isEmpty())) {
            asyncLoad(this.name, this.numbers, this.normalizedNumbers);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onCreate(InterfaceC0492o lifecycleOwner) {
        Object b10;
        i.f(lifecycleOwner, "lifecycleOwner");
        super.onCreate(lifecycleOwner);
        try {
            Result.a aVar = Result.f34166a;
            this.context.getContentResolver().registerContentObserver(BreenoCallContract.Summary.CONTENT_URI, false, this);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c(TAG, "registerContentObserver: exception: " + d10);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onDestroy(InterfaceC0492o lifecycleOwner) {
        Object b10;
        i.f(lifecycleOwner, "lifecycleOwner");
        super.onDestroy(lifecycleOwner);
        try {
            Result.a aVar = Result.f34166a;
            this.context.getContentResolver().unregisterContentObserver(this);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c(TAG, "unregisterContentObserver: exception: " + d10);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public /* bridge */ /* synthetic */ void onPause(InterfaceC0492o interfaceC0492o) {
        super.onPause(interfaceC0492o);
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public /* bridge */ /* synthetic */ void onResume(InterfaceC0492o interfaceC0492o) {
        super.onResume(interfaceC0492o);
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public /* bridge */ /* synthetic */ void onStart(InterfaceC0492o interfaceC0492o) {
        super.onStart(interfaceC0492o);
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public /* bridge */ /* synthetic */ void onStop(InterfaceC0492o interfaceC0492o) {
        super.onStop(interfaceC0492o);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoCallSummaryTipManager(Context context, Lifecycle lifecycle, t tVar) {
        super(new Handler(Looper.getMainLooper()));
        i.f(context, "context");
        this.context = context;
        this.lifecycle = lifecycle;
        this.simpleCallback = tVar;
        this.numbers = new ArrayList<>();
        this.normalizedNumbers = new ArrayList<>();
        this.summaryEntities = new ArrayList<>();
    }
}
