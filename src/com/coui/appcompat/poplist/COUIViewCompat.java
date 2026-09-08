package com.coui.appcompat.poplist;

import android.view.View;

/* loaded from: classes.dex */
public class COUIViewCompat {
    static final ViewCompatImpl IMPL = new JbMr1ViewCompatImpl();

    /* loaded from: classes.dex */
    public static class JBViewCompatImpl extends BaseViewCompatImpl {
        @Override // com.coui.appcompat.poplist.COUIViewCompat.BaseViewCompatImpl, com.coui.appcompat.poplist.COUIViewCompat.ViewCompatImpl
        public int getTextAlignment(View view) {
            return view.getTextAlignment();
        }

        @Override // com.coui.appcompat.poplist.COUIViewCompat.BaseViewCompatImpl, com.coui.appcompat.poplist.COUIViewCompat.ViewCompatImpl
        public boolean isVisibleToUser(View view) {
            return true;
        }

        @Override // com.coui.appcompat.poplist.COUIViewCompat.BaseViewCompatImpl, com.coui.appcompat.poplist.COUIViewCompat.ViewCompatImpl
        public void setTextAlignment(View view, int i10) {
            view.setTextAlignment(i10);
        }
    }

    /* loaded from: classes.dex */
    public static class JbMr1ViewCompatImpl extends JBViewCompatImpl {
        @Override // com.coui.appcompat.poplist.COUIViewCompat.BaseViewCompatImpl, com.coui.appcompat.poplist.COUIViewCompat.ViewCompatImpl
        public int getRawLayoutDirection(View view) {
            return 2;
        }
    }

    /* loaded from: classes.dex */
    public interface ViewCompatImpl {
        int getRawLayoutDirection(View view);

        int getTextAlignment(View view);

        boolean isVisibleToUser(View view);

        void setTextAlignment(View view, int i10);
    }

    public static int getRawLayoutDirection(View view) {
        return IMPL.getRawLayoutDirection(view);
    }

    public static int getTextAlignment(View view) {
        return IMPL.getTextAlignment(view);
    }

    public static boolean isVisibleToUser(View view) {
        return IMPL.isVisibleToUser(view);
    }

    public static void setTextAlignment(View view, int i10) {
        IMPL.setTextAlignment(view, i10);
    }

    /* loaded from: classes.dex */
    public static class BaseViewCompatImpl implements ViewCompatImpl {
        @Override // com.coui.appcompat.poplist.COUIViewCompat.ViewCompatImpl
        public int getRawLayoutDirection(View view) {
            return view.getLayoutDirection();
        }

        @Override // com.coui.appcompat.poplist.COUIViewCompat.ViewCompatImpl
        public int getTextAlignment(View view) {
            return 0;
        }

        @Override // com.coui.appcompat.poplist.COUIViewCompat.ViewCompatImpl
        public boolean isVisibleToUser(View view) {
            return true;
        }

        @Override // com.coui.appcompat.poplist.COUIViewCompat.ViewCompatImpl
        public void setTextAlignment(View view, int i10) {
        }
    }
}
