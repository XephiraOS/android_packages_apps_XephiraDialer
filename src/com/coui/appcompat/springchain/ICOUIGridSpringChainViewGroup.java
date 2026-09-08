package com.coui.appcompat.springchain;

/* compiled from: ICOUIGridSpringChainViewGroup.kt */
/* loaded from: classes.dex */
public interface ICOUIGridSpringChainViewGroup {

    /* compiled from: ICOUIGridSpringChainViewGroup.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static float getLastTranslationY(ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup) {
            COUIGridSpringChain springChain = iCOUIGridSpringChainViewGroup.getSpringChain();
            if (springChain != null) {
                return springChain.getLastTranslationY();
            }
            return 0.0f;
        }

        public static COUIGridSpringChain getSpringChain(ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup) {
            return null;
        }

        public static int isSpringSystemRunning(ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup) {
            COUIGridSpringChain springChain = iCOUIGridSpringChainViewGroup.getSpringChain();
            if (springChain != null) {
                return springChain.isSpringSystemRunning();
            }
            return 0;
        }

        public static void releaseSpring(ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup) {
            COUIGridSpringChain springChain = iCOUIGridSpringChainViewGroup.getSpringChain();
            if (springChain != null) {
                springChain.releaseSpring();
            }
        }

        public static void startRebound(ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup, int i10) {
            COUIGridSpringChain springChain = iCOUIGridSpringChainViewGroup.getSpringChain();
            if (springChain != null) {
                springChain.startRebound(i10);
            }
        }

        public static void updateMoveTranslation(ICOUIGridSpringChainViewGroup iCOUIGridSpringChainViewGroup, float f10, int i10) {
            COUIGridSpringChain springChain = iCOUIGridSpringChainViewGroup.getSpringChain();
            if (springChain != null) {
                springChain.updateMoveTranslation(f10, i10);
            }
        }
    }

    float getLastTranslationY();

    COUIGridSpringChain getSpringChain();

    int isSpringSystemRunning();

    void releaseSpring();

    void startRebound(int i10);

    void updateMoveTranslation(float f10, int i10);
}
