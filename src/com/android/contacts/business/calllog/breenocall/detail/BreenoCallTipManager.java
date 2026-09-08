package com.android.contacts.business.calllog.breenocall.detail;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.C0490m;
import androidx.lifecycle.InterfaceC0480c;
import androidx.lifecycle.InterfaceC0492o;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntityUtils;
import com.android.contacts.business.calllog.breenocall.FeatureOpt;
import com.android.contacts.business.calllog.breenocall.NameInfo;
import com.android.contacts.business.calllog.breenocall.statistics.BreenoCallStatistics;
import com.android.contacts.business.calllog.c;
import com.android.contacts.business.calllog.d;
import com.android.contacts.business.calllog.e;
import com.android.contacts.framework.baseui.util.r;
import com.android.contacts.framework.baseui.widget.ContactsRecommendView;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import m9.q;
import v9.l;

/* compiled from: BreenoCallTipManager.kt */
/* loaded from: classes.dex */
public final class BreenoCallTipManager extends ContentObserver implements InterfaceC0480c {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BreenoCallTipManager";
    public static final String TIP_ID = "BreenoCallTip";
    private final Context context;
    private E coroutineScope;
    private boolean enabled;
    private BreenoCallLogEntity entity;
    private boolean loaded;
    private final String number;
    private INumberTypeInfoQuery numberTypeInfoQueryer;
    private boolean queryNumberInfo;
    private final ITipController tipController;
    private ContactsRecommendView tipView;

    /* compiled from: BreenoCallTipManager.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: BreenoCallTipManager.kt */
    /* loaded from: classes.dex */
    public interface INumberTypeInfoQuery {
        NumberTypeInfo query(Context context, String str);
    }

    /* compiled from: BreenoCallTipManager.kt */
    /* loaded from: classes.dex */
    public interface ITipController {
        boolean isTipShownable();

        void onTipDismiss(String str, boolean z10);

        void onTipUpdated(String str);

        void requestSaveContact(BreenoCallLogEntity breenoCallLogEntity);

        void setNumberInfo(boolean z10, boolean z11, boolean z12);
    }

    /* compiled from: BreenoCallTipManager.kt */
    /* loaded from: classes.dex */
    public static final class NumberTypeInfo {
        private final boolean isBlacklistNum;
        private final boolean isServiceNumber;
        private final boolean isSpecialNumber;

        public NumberTypeInfo(boolean z10, boolean z11, boolean z12) {
            this.isSpecialNumber = z10;
            this.isServiceNumber = z11;
            this.isBlacklistNum = z12;
        }

        public static /* synthetic */ NumberTypeInfo copy$default(NumberTypeInfo numberTypeInfo, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = numberTypeInfo.isSpecialNumber;
            }
            if ((i10 & 2) != 0) {
                z11 = numberTypeInfo.isServiceNumber;
            }
            if ((i10 & 4) != 0) {
                z12 = numberTypeInfo.isBlacklistNum;
            }
            return numberTypeInfo.copy(z10, z11, z12);
        }

        public final boolean component1() {
            return this.isSpecialNumber;
        }

        public final boolean component2() {
            return this.isServiceNumber;
        }

        public final boolean component3() {
            return this.isBlacklistNum;
        }

        public final NumberTypeInfo copy(boolean z10, boolean z11, boolean z12) {
            return new NumberTypeInfo(z10, z11, z12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NumberTypeInfo)) {
                return false;
            }
            NumberTypeInfo numberTypeInfo = (NumberTypeInfo) obj;
            if (this.isSpecialNumber == numberTypeInfo.isSpecialNumber && this.isServiceNumber == numberTypeInfo.isServiceNumber && this.isBlacklistNum == numberTypeInfo.isBlacklistNum) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z10 = this.isSpecialNumber;
            int i10 = 1;
            ?? r02 = z10;
            if (z10) {
                r02 = 1;
            }
            int i11 = r02 * 31;
            ?? r22 = this.isServiceNumber;
            int i12 = r22;
            if (r22 != 0) {
                i12 = 1;
            }
            int i13 = (i11 + i12) * 31;
            boolean z11 = this.isBlacklistNum;
            if (!z11) {
                i10 = z11 ? 1 : 0;
            }
            return i13 + i10;
        }

        public final boolean isBlacklistNum() {
            return this.isBlacklistNum;
        }

        public final boolean isServiceNumber() {
            return this.isServiceNumber;
        }

        public final boolean isSpecialNumber() {
            return this.isSpecialNumber;
        }

        public String toString() {
            return "NumberTypeInfo(isSpecialNumber=" + this.isSpecialNumber + ", isServiceNumber=" + this.isServiceNumber + ", isBlacklistNum=" + this.isBlacklistNum + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreenoCallTipManager(Context context, String number, ITipController tipController, Handler handler) {
        super(handler);
        i.f(context, "context");
        i.f(number, "number");
        i.f(tipController, "tipController");
        this.context = context;
        this.number = number;
        this.tipController = tipController;
        this.enabled = true;
    }

    private final void asyncLoad(l<? super String, q> lVar) {
        E e10 = this.coroutineScope;
        if (e10 != null) {
            C1248i.d(e10, S.b(), null, new BreenoCallTipManager$asyncLoad$1(this, lVar, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTipView$lambda$5$lambda$2(BreenoCallTipManager this$0, View view) {
        i.f(this$0, "this$0");
        this$0.trySaveContact();
        BreenoCallStatistics.Companion.trackTipAction(this$0.context, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTipView$lambda$5$lambda$3(BreenoCallTipManager this$0, View view) {
        i.f(this$0, "this$0");
        this$0.tipController.onTipDismiss(TIP_ID, true);
        BreenoCallLogEntityUtils.Companion companion = BreenoCallLogEntityUtils.Companion;
        Context context = this$0.context;
        BreenoCallLogEntity breenoCallLogEntity = this$0.entity;
        i.c(breenoCallLogEntity);
        companion.deleteBreenoCallLogEntity(context, breenoCallLogEntity.get_id());
        BreenoCallStatistics.Companion.trackTipAction(this$0.context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean queryNumberTypeInfo(Context context, String str) {
        NumberTypeInfo query;
        boolean isTipShownable = this.tipController.isTipShownable();
        if (this.queryNumberInfo) {
            INumberTypeInfoQuery iNumberTypeInfoQuery = this.numberTypeInfoQueryer;
            if (iNumberTypeInfoQuery != null && (query = iNumberTypeInfoQuery.query(context, str)) != null) {
                this.tipController.setNumberInfo(query.isSpecialNumber(), query.isServiceNumber(), query.isBlacklistNum());
                isTipShownable = (query.isSpecialNumber() || query.isServiceNumber() || query.isBlacklistNum()) ? false : true;
            }
            this.queryNumberInfo = false;
        }
        return isTipShownable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTipViewContent(ContactsRecommendView contactsRecommendView, String str) {
        if (contactsRecommendView != null) {
            m mVar = m.f34245a;
            String string = this.context.getString(com.android.contacts.business.calllog.f.f13713b);
            i.e(string, "context.getString(R.stri…reeno_suggestion_contact)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            i.e(format, "format(...)");
            contactsRecommendView.e(c.f13707a, format, com.android.contacts.business.calllog.f.f13716e, com.android.contacts.business.calllog.f.f13717f);
        }
    }

    public final View getTipView() {
        List<NameInfo> nameInfoList;
        String name;
        BreenoCallLogEntity breenoCallLogEntity = this.entity;
        String str = null;
        if (breenoCallLogEntity == null) {
            H7.b.i(TAG, "getTipView: entity is null, return null.");
            return null;
        }
        if (breenoCallLogEntity != null) {
            breenoCallLogEntity.nomarlize();
            if (breenoCallLogEntity.getNameInfoList() == null || !(!r0.isEmpty())) {
                H7.b.i(TAG, "getTipView: no name, return null.");
                return null;
            }
        }
        if (this.tipView == null) {
            View inflate = LayoutInflater.from(this.context).inflate(e.f13710a, (ViewGroup) null);
            i.d(inflate, "null cannot be cast to non-null type com.android.contacts.framework.baseui.widget.ContactsRecommendView");
            ContactsRecommendView contactsRecommendView = (ContactsRecommendView) inflate;
            this.tipView = contactsRecommendView;
            if (contactsRecommendView != null) {
                contactsRecommendView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                contactsRecommendView.setActionViewClickListener(new View.OnClickListener() { // from class: com.android.contacts.business.calllog.breenocall.detail.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BreenoCallTipManager.getTipView$lambda$5$lambda$2(BreenoCallTipManager.this, view);
                    }
                });
                contactsRecommendView.setDismissViewClickListener(new View.OnClickListener() { // from class: com.android.contacts.business.calllog.breenocall.detail.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BreenoCallTipManager.getTipView$lambda$5$lambda$3(BreenoCallTipManager.this, view);
                    }
                });
                BreenoCallLogEntity breenoCallLogEntity2 = this.entity;
                if (breenoCallLogEntity2 != null && (nameInfoList = breenoCallLogEntity2.getNameInfoList()) != null) {
                    if (nameInfoList.isEmpty()) {
                        name = "";
                    } else {
                        name = nameInfoList.get(0).getName();
                    }
                    str = name;
                }
                updateTipViewContent(this.tipView, str);
                r.e(this.context, contactsRecommendView.findViewById(d.f13709a));
            }
        }
        return this.tipView;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        H7.b.b(TAG, "onChange: " + z10 + ", loaded: " + this.loaded);
        if (this.loaded) {
            asyncLoad(new l<String, q>() { // from class: com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager$onChange$1
                {
                    super(1);
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ q invoke(String str) {
                    invoke2(str);
                    return q.f35511a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    ContactsRecommendView contactsRecommendView;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    BreenoCallTipManager breenoCallTipManager = BreenoCallTipManager.this;
                    contactsRecommendView = breenoCallTipManager.tipView;
                    breenoCallTipManager.updateTipViewContent(contactsRecommendView, str);
                }
            });
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onCreate(InterfaceC0492o owner) {
        boolean z10;
        i.f(owner, "owner");
        super.onCreate(owner);
        this.coroutineScope = C0490m.a(owner.getLifecycle());
        if (this.tipController.isTipShownable() && FeatureOpt.isBreenoCallLogSupport()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.enabled = z10;
        if (z10) {
            this.context.getContentResolver().registerContentObserver(BreenoCallContract.Call.CONTENT_URI, false, this);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public void onDestroy(InterfaceC0492o owner) {
        i.f(owner, "owner");
        super.onDestroy(owner);
        if (this.enabled) {
            this.context.getContentResolver().unregisterContentObserver(this);
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
    public void onStart(InterfaceC0492o owner) {
        i.f(owner, "owner");
        super.onStart(owner);
        if (this.enabled && !this.loaded) {
            asyncLoad(null);
        }
    }

    @Override // androidx.lifecycle.InterfaceC0480c
    public /* bridge */ /* synthetic */ void onStop(InterfaceC0492o interfaceC0492o) {
        super.onStop(interfaceC0492o);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0074  */
    /* JADX WARN: Type inference failed for: r8v11, types: [m9.q] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity query(android.content.Context r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.i.f(r9, r0)
            java.lang.String r0 = "number"
            kotlin.jvm.internal.i.f(r10, r0)
            boolean r8 = r8.enabled
            r0 = 0
            if (r8 != 0) goto L10
            return r0
        L10:
            kotlin.Result$a r8 = kotlin.Result.f34166a     // Catch: java.lang.Throwable -> L49
            android.net.Uri r8 = com.android.contacts.business.calllog.breenocall.BreenoCallContract.Call.CONTENT_FILTER_URI     // Catch: java.lang.Throwable -> L49
            android.net.Uri r2 = android.net.Uri.withAppendedPath(r8, r10)     // Catch: java.lang.Throwable -> L49
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L49
            com.android.contacts.business.calllog.breenocall.BreenoCallLogEntityUtils$Companion r8 = com.android.contacts.business.calllog.breenocall.BreenoCallLogEntityUtils.Companion     // Catch: java.lang.Throwable -> L49
            java.lang.String[] r3 = r8.getQuery_projection()     // Catch: java.lang.Throwable -> L49
            java.lang.String r6 = "_id ASC"
            r4 = 0
            r5 = 0
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L49
            if (r9 == 0) goto L3f
            boolean r10 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L37
            if (r10 == 0) goto L39
            com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity r0 = r8.buildBreenoCallLogEntity(r9)     // Catch: java.lang.Throwable -> L37
            goto L39
        L37:
            r8 = move-exception
            goto L4b
        L39:
            m9.q r8 = m9.q.f35511a     // Catch: java.lang.Throwable -> L37
            r7 = r0
            r0 = r8
            r8 = r7
            goto L40
        L3f:
            r8 = r0
        L40:
            java.lang.Object r10 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L45
            goto L56
        L45:
            r10 = move-exception
            r0 = r8
            r8 = r10
            goto L4b
        L49:
            r8 = move-exception
            r9 = r0
        L4b:
            kotlin.Result$a r10 = kotlin.Result.f34166a
            java.lang.Object r8 = kotlin.b.a(r8)
            java.lang.Object r10 = kotlin.Result.b(r8)
            r8 = r0
        L56:
            java.lang.Throwable r10 = kotlin.Result.d(r10)
            if (r10 == 0) goto L72
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "query: Exception: "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            java.lang.String r0 = "BreenoCallTipManager"
            H7.b.c(r0, r10)
        L72:
            if (r9 == 0) goto L77
            r9.close()
        L77:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager.query(android.content.Context, java.lang.String):com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity");
    }

    public final void setINumberTypeInfoQueryer(INumberTypeInfoQuery iNumberTypeInfoQuery) {
        boolean z10;
        this.numberTypeInfoQueryer = iNumberTypeInfoQuery;
        if (iNumberTypeInfoQuery != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.queryNumberInfo = z10;
    }

    public final boolean trySaveContact() {
        BreenoCallLogEntity breenoCallLogEntity = this.entity;
        if (breenoCallLogEntity == null) {
            return false;
        }
        ITipController iTipController = this.tipController;
        i.c(breenoCallLogEntity);
        iTipController.requestSaveContact(breenoCallLogEntity);
        return true;
    }
}
