package com.coui.appcompat.scroll;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.coui.appcompat.log.COUILog;

/* loaded from: classes.dex */
public class SpringOverScroller extends OverScroller implements COUIIOverScroller {
    public static final float COUI_FLING_FRICTION_FAST = 0.76f;
    public static final float COUI_FLING_FRICTION_NORMAL = 0.32f;
    public static final int COUI_FLING_MODE_FAST = 0;
    public static final int COUI_FLING_MODE_NORMAL = 1;
    public static boolean DEBUG = false;
    private static final float ERROR_THRESHOLD = 0.025f;
    private static final int FLING_MODE = 1;
    private static final int FLING_SPEED_INCREASE_COUNT_THRESHOLD = 4;
    private static final int FLING_SPEED_INCREASE_EDGE_REACHED_VELOCITY = 1000;
    private static final int FLING_SPEED_INCREASE_EDGE_REACHED_VELOCITY_THRESHOLD = 20000;
    private static final int FLING_SPEED_INCREASE_MAX_VELOCITY = 70000;
    private static final float FLING_SPEED_INCREASE_RATE = 1.4f;
    private static final int FLING_SPEED_INCREASE_TIME_INTERVAL_THRESHOLD = 500;
    private static final int FLING_SPEED_INCREASE_VELOCITY_THRESHOLD = 8000;
    private static final float MIN_FRAME_INTERVAL = 0.008f;
    private static final double MIN_UPDATE_ONE_STEP = 0.20000000298023224d;
    private static final float NANO_ONE_SECOND = 1.0E9f;
    private static final float NANO_TO_MILLIS = 1000000.0f;
    private static final float ONE_SECOND = 1000.0f;
    private static final int REST_MODE = 2;
    private static final int SCROLL_DEFAULT_DURATION = 250;
    private static final int SCROLL_MODE = 0;
    private static final float SOLVER_TIMESTEP_SEC = 0.016f;
    public static final String TAG = "SpringOverScroller";
    private static final int VSYNC_DURATION = 5000;
    private static float mRefreshTime;
    private static float mSpringBackFriction;
    private final Choreographer.FrameCallback mCallback;
    private boolean mCancelCallback;
    private Context mContext;
    private int mContinuousFlingCount;
    private long mCurrentComputeTimeFromCallback;
    private boolean mEnableFlingSpeedIncrease;
    private COUlFrameRateScrollSceneHelper mFrameRateHelper;
    private Interpolator mInterpolator;
    private boolean mIsUpdateTimeFromCallback;
    private long mLastComputeTimeFromCallback;
    private float mLastFlingSpeedIncreaseRate;
    private long mLastFlingTime;
    private int mMode;
    private ReboundOverScroller mScrollerX;
    private ReboundOverScroller mScrollerY;

    /* loaded from: classes.dex */
    public static class COUIViscousFluidInterpolator implements Interpolator {
        private static final float VISCOUS_FLUID_NORMALIZE;
        private static final float VISCOUS_FLUID_OFFSET;
        private static final float VISCOUS_FLUID_SCALE = 8.0f;

        static {
            float viscousFluid = 1.0f / viscousFluid(1.0f);
            VISCOUS_FLUID_NORMALIZE = viscousFluid;
            VISCOUS_FLUID_OFFSET = 1.0f - (viscousFluid * viscousFluid(1.0f));
        }

        private static float viscousFluid(float f10) {
            float f11 = f10 * VISCOUS_FLUID_SCALE;
            if (f11 < 1.0f) {
                return f11 - (1.0f - ((float) Math.exp(-f11)));
            }
            return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f11))) * 0.63212055f);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float viscousFluid = VISCOUS_FLUID_NORMALIZE * viscousFluid(f10);
            if (viscousFluid > 0.0f) {
                return viscousFluid + VISCOUS_FLUID_OFFSET;
            }
            return viscousFluid;
        }
    }

    /* loaded from: classes.dex */
    public static class ReboundOverScroller {
        private static final float FLING_CHANGE_INCREASE_STEP = 1.2f;
        private static final float FLING_CHANGE_REDUCE_STEP = 0.6f;
        private static final float FLING_DXDT_RATIO = 0.167f;
        private static final double FLING_FRICTION_DIVISOR = 10000.0d;
        private static final float FLOAT_1 = 1.0f;
        private static final float FLOAT_2 = 2.0f;
        private static final double INCREASE_FRICTION_COEF = 0.00125d;
        private static final double MAX_VELOCITY_ADJUST_FRICTION = 10000.0d;
        private static final double MID_FLING_BASE_FRICTION = 2.6d;
        private static final double MID_VELOCITY_ADJUST_FRICTION = 4000.0d;
        private static final double MIN_FLING_FRICTION_REDUCE = 2.0d;
        private static final double MIN_VELOCITY_ADJUST_FRICTION = 1000.0d;
        private static final int NUM_60 = 60;
        private static final float ONE_MILLION = 1.0E-7f;
        private static final double REDUCE_FRICTION_COEF = 0.00125d;
        private static final double SLOW_FLING_BASE_FRICTION = 4.5d;
        private static final int SPRING_BACK_ADJUST_TENSION_VALUE = 100;
        private static final int SPRING_BACK_ADJUST_THRESHOLD = 180;
        private static final float SPRING_BACK_FRICTION = 12.19f;
        private static final float SPRING_BACK_STOP_THRESHOLD = 0.25f;
        private static final float SPRING_BACK_TENSION = 16.0f;
        private static final long TIME_ADJUST_FRICTION = 480;
        private static final double VELOCITY_REDUCE_FRICTION = 2000.0d;
        private static float sTimeIncrease = 1.0f;
        private boolean mCancelCallback;
        private boolean mComputeTimeFromCallbackUpdated;
        private ReboundConfig mConfig;
        private long mCurrentComputeTime;
        private long mCurrentComputeTimeFromCallback;
        private double mEndValue;
        private long mFlingPreTime;
        private long mFlingStartTime;
        private boolean mIsSpringBack;
        private long mLastComputeTime;
        private long mLastComputeTimeFromCallback;
        private int mScrollDuration;
        private int mScrollFinal;
        private int mScrollStart;
        private long mScrollStartTime;
        private double mStartValue;
        private boolean mTensionAdjusted;
        private PhysicsState mCurrentState = new PhysicsState();
        private PhysicsState mPreviousState = new PhysicsState();
        private PhysicsState mTempState = new PhysicsState();
        private float mFlingFriction = 0.32f;
        private double mRestSpeedThreshold = 20.0d;
        private double mDisplacementFromRestThreshold = 0.05d;
        private int mCOUICount = 1;
        private boolean mIsScrollView = false;
        private float mSpringBackTensionMultiple = 0.83f;
        private ReboundConfig mFlingConfig = new ReboundConfig(0.32f, 0.0d);
        private ReboundConfig mSpringBackConfig = new ReboundConfig(12.1899995803833d, 16.0d);

        /* loaded from: classes.dex */
        public static class PhysicsState {
            double mPosition;
            double mVelocity;
        }

        /* loaded from: classes.dex */
        public static class ReboundConfig {
            double mFriction;
            double mTension;

            public ReboundConfig(double d10, double d11) {
                this.mFriction = frictionFromOrigamiValue((float) d10);
                this.mTension = tensionFromOrigamiValue((float) d11);
            }

            private float frictionFromOrigamiValue(float f10) {
                if (f10 == 0.0f) {
                    return 0.0f;
                }
                return 25.0f + ((f10 - 8.0f) * 3.0f);
            }

            private double tensionFromOrigamiValue(float f10) {
                if (f10 == 0.0f) {
                    return 0.0d;
                }
                return ((f10 - 30.0f) * 3.62f) + 194.0f;
            }

            public void setFriction(double d10) {
                this.mFriction = frictionFromOrigamiValue((float) d10);
            }

            public void setTension(double d10) {
                this.mTension = tensionFromOrigamiValue((float) d10);
            }
        }

        public ReboundOverScroller() {
            setConfig(this.mFlingConfig);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateComputeTimeFromCallback(long j10) {
            this.mLastComputeTimeFromCallback = this.mCurrentComputeTimeFromCallback;
            this.mCurrentComputeTimeFromCallback = j10;
            this.mComputeTimeFromCallbackUpdated = true;
        }

        public void fling(int i10, int i11) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mFlingStartTime = currentAnimationTimeMillis;
            this.mFlingPreTime = currentAnimationTimeMillis;
            this.mCOUICount = 1;
            sTimeIncrease = 1.0f;
            this.mFlingConfig.setFriction(this.mFlingFriction);
            this.mFlingConfig.setTension(0.0d);
            setConfig(this.mFlingConfig);
            setCurrentValue(i10, true);
            setVelocity(i11);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mLastComputeTime = elapsedRealtime;
            this.mCurrentComputeTime = elapsedRealtime;
        }

        public double getCurrentValue() {
            return this.mCurrentState.mPosition;
        }

        public double getDisplacementDistanceForState(PhysicsState physicsState) {
            return Math.abs(this.mEndValue - physicsState.mPosition);
        }

        public double getEndValue() {
            return this.mEndValue;
        }

        public double getVelocity() {
            return this.mCurrentState.mVelocity;
        }

        public boolean isAtRest() {
            if (Math.abs(this.mCurrentState.mVelocity) <= this.mRestSpeedThreshold && (getDisplacementDistanceForState(this.mCurrentState) <= this.mDisplacementFromRestThreshold || this.mConfig.mTension == 0.0d)) {
                return true;
            }
            return false;
        }

        public void notifyEdgeReached(int i10, int i11, int i12) {
            PhysicsState physicsState = this.mCurrentState;
            physicsState.mPosition = i10;
            PhysicsState physicsState2 = this.mPreviousState;
            physicsState2.mPosition = 0.0d;
            physicsState2.mVelocity = 0.0d;
            PhysicsState physicsState3 = this.mTempState;
            physicsState3.mPosition = i11;
            physicsState3.mVelocity = physicsState.mVelocity;
        }

        public void setAtRest() {
            PhysicsState physicsState = this.mCurrentState;
            double d10 = physicsState.mPosition;
            this.mEndValue = d10;
            this.mTempState.mPosition = d10;
            physicsState.mVelocity = 0.0d;
            this.mIsSpringBack = false;
            this.mCancelCallback = true;
        }

        public void setConfig(ReboundConfig reboundConfig) {
            if (reboundConfig != null) {
                this.mConfig = reboundConfig;
                return;
            }
            throw new IllegalArgumentException("springConfig is required");
        }

        public void setCurrentValue(double d10, boolean z10) {
            this.mStartValue = d10;
            if (!this.mIsScrollView) {
                this.mPreviousState.mPosition = 0.0d;
                this.mTempState.mPosition = 0.0d;
            }
            this.mCurrentState.mPosition = d10;
            if (z10) {
                setAtRest();
            }
        }

        public void setEndValue(double d10) {
            if (this.mEndValue == d10) {
                return;
            }
            this.mStartValue = getCurrentValue();
            this.mEndValue = d10;
        }

        public void setVelocity(double d10) {
            if (Math.abs(d10 - this.mCurrentState.mVelocity) < 1.0000000116860974E-7d) {
                return;
            }
            this.mCurrentState.mVelocity = d10;
        }

        public boolean springBack(int i10, int i11, int i12) {
            setCurrentValue(i10, false);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mLastComputeTime = elapsedRealtime;
            this.mCurrentComputeTime = elapsedRealtime;
            if (i10 <= i12 && i10 >= i11) {
                setConfig(new ReboundConfig(this.mFlingFriction, 0.0d));
                return false;
            }
            if (i10 > i12) {
                setEndValue(i12);
            } else if (i10 < i11) {
                setEndValue(i11);
            }
            this.mIsSpringBack = true;
            this.mSpringBackConfig.setFriction(SpringOverScroller.mSpringBackFriction);
            this.mSpringBackConfig.setTension(this.mSpringBackTensionMultiple * 16.0f);
            setConfig(this.mSpringBackConfig);
            return true;
        }

        public void startScroll(int i10, int i11, int i12, long j10) {
            this.mScrollStart = i10;
            int i13 = i10 + i11;
            this.mScrollFinal = i13;
            this.mEndValue = i13;
            this.mScrollDuration = i12;
            this.mScrollStartTime = j10;
            setConfig(this.mFlingConfig);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mLastComputeTime = elapsedRealtime;
            this.mCurrentComputeTime = elapsedRealtime;
        }

        public boolean update() {
            double d10;
            double d11;
            String str;
            if (isAtRest()) {
                return false;
            }
            this.mCurrentComputeTime = SystemClock.elapsedRealtime();
            boolean z10 = this.mComputeTimeFromCallbackUpdated;
            String str2 = SpringOverScroller.TAG;
            if (z10) {
                this.mComputeTimeFromCallbackUpdated = false;
                if (SpringOverScroller.DEBUG) {
                    Log.d(SpringOverScroller.TAG, "update if: " + (((float) (this.mCurrentComputeTimeFromCallback - this.mLastComputeTimeFromCallback)) / SpringOverScroller.NANO_ONE_SECOND));
                }
                float unused = SpringOverScroller.mRefreshTime = Math.max(SpringOverScroller.MIN_FRAME_INTERVAL, ((float) (this.mCurrentComputeTimeFromCallback - this.mLastComputeTimeFromCallback)) / SpringOverScroller.NANO_ONE_SECOND);
            } else {
                if (SpringOverScroller.DEBUG) {
                    Log.d(SpringOverScroller.TAG, "update else: " + (((float) (this.mCurrentComputeTime - this.mLastComputeTime)) / SpringOverScroller.ONE_SECOND));
                }
                float unused2 = SpringOverScroller.mRefreshTime = Math.max(SpringOverScroller.MIN_FRAME_INTERVAL, ((float) (this.mCurrentComputeTime - this.mLastComputeTime)) / SpringOverScroller.ONE_SECOND);
            }
            if (SpringOverScroller.mRefreshTime > SpringOverScroller.ERROR_THRESHOLD) {
                if (SpringOverScroller.DEBUG) {
                    Log.d(SpringOverScroller.TAG, "update: error mRefreshTime = " + SpringOverScroller.mRefreshTime);
                }
                float unused3 = SpringOverScroller.mRefreshTime = SpringOverScroller.MIN_FRAME_INTERVAL;
            }
            if (SpringOverScroller.DEBUG) {
                Log.d(SpringOverScroller.TAG, "update: mRefreshTime = " + SpringOverScroller.mRefreshTime + " mLastComputeTime = " + this.mLastComputeTime);
            }
            this.mLastComputeTime = this.mCurrentComputeTime;
            PhysicsState physicsState = this.mCurrentState;
            double d12 = physicsState.mPosition;
            double d13 = physicsState.mVelocity;
            PhysicsState physicsState2 = this.mTempState;
            double d14 = physicsState2.mPosition;
            double d15 = physicsState2.mVelocity;
            if (!this.mIsSpringBack) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long j10 = currentAnimationTimeMillis - this.mFlingStartTime;
                if (this.mCOUICount == 1) {
                    d10 = d13;
                    if (Math.abs(this.mCurrentState.mVelocity) > MID_VELOCITY_ADJUST_FRICTION) {
                        d11 = d14;
                        if (Math.abs(this.mCurrentState.mVelocity) < 10000.0d) {
                            this.mConfig.mFriction = (Math.abs(this.mCurrentState.mVelocity) / 10000.0d) + MID_FLING_BASE_FRICTION;
                            this.mFlingPreTime = currentAnimationTimeMillis;
                        }
                    } else {
                        d11 = d14;
                    }
                    if (Math.abs(this.mCurrentState.mVelocity) <= MID_VELOCITY_ADJUST_FRICTION) {
                        this.mConfig.mFriction = (Math.abs(this.mCurrentState.mVelocity) / 10000.0d) + SLOW_FLING_BASE_FRICTION;
                    }
                    this.mFlingPreTime = currentAnimationTimeMillis;
                } else {
                    d10 = d13;
                    d11 = d14;
                }
                if (this.mCOUICount > 1) {
                    if (j10 > TIME_ADJUST_FRICTION) {
                        if (Math.abs(this.mCurrentState.mVelocity) > VELOCITY_REDUCE_FRICTION) {
                            this.mConfig.mFriction += SpringOverScroller.mRefreshTime * 0.00125d;
                        } else {
                            ReboundConfig reboundConfig = this.mConfig;
                            double d16 = reboundConfig.mFriction;
                            if (d16 > MIN_FLING_FRICTION_REDUCE) {
                                reboundConfig.mFriction = d16 - (SpringOverScroller.mRefreshTime * 0.00125d);
                            }
                        }
                    }
                    this.mFlingPreTime = currentAnimationTimeMillis;
                }
                if (isAtRest()) {
                    this.mCancelCallback = true;
                }
            } else {
                d10 = d13;
                d11 = d14;
                double displacementDistanceForState = getDisplacementDistanceForState(physicsState);
                if (!this.mTensionAdjusted && displacementDistanceForState < 180.0d) {
                    this.mTensionAdjusted = true;
                } else if (displacementDistanceForState < 0.25d) {
                    this.mCurrentState.mPosition = this.mEndValue;
                    this.mTensionAdjusted = false;
                    this.mIsSpringBack = false;
                    this.mCancelCallback = true;
                    return false;
                }
            }
            double d17 = d12;
            double d18 = d10;
            double d19 = d11;
            while (true) {
                ReboundConfig reboundConfig2 = this.mConfig;
                str = str2;
                double d20 = d12;
                double d21 = (reboundConfig2.mTension * (this.mEndValue - d19)) - (reboundConfig2.mFriction * d15);
                double d22 = ((SpringOverScroller.mRefreshTime * d18) / MIN_FLING_FRICTION_REDUCE) + d17;
                double d23 = ((SpringOverScroller.mRefreshTime * d21) / MIN_FLING_FRICTION_REDUCE) + d18;
                ReboundConfig reboundConfig3 = this.mConfig;
                double d24 = (reboundConfig3.mTension * (this.mEndValue - d22)) - (reboundConfig3.mFriction * d23);
                double d25 = ((SpringOverScroller.mRefreshTime * d23) / MIN_FLING_FRICTION_REDUCE) + d17;
                double d26 = ((SpringOverScroller.mRefreshTime * d24) / MIN_FLING_FRICTION_REDUCE) + d18;
                ReboundConfig reboundConfig4 = this.mConfig;
                double d27 = (reboundConfig4.mTension * (this.mEndValue - d25)) - (reboundConfig4.mFriction * d26);
                d19 = d17 + (SpringOverScroller.mRefreshTime * d26);
                double d28 = (SpringOverScroller.mRefreshTime * d27) + d18;
                ReboundConfig reboundConfig5 = this.mConfig;
                double d29 = d17;
                double d30 = (reboundConfig5.mTension * (this.mEndValue - d19)) - (reboundConfig5.mFriction * d28);
                double d31 = (((d23 + d26) * MIN_FLING_FRICTION_REDUCE) + d18 + d28) * 0.16699999570846558d;
                double d32 = (d21 + ((d24 + d27) * MIN_FLING_FRICTION_REDUCE) + d30) * 0.16699999570846558d;
                d17 = d29 + (d31 * SpringOverScroller.mRefreshTime);
                d18 += d32 * SpringOverScroller.mRefreshTime;
                PhysicsState physicsState3 = this.mTempState;
                physicsState3.mVelocity = d28;
                physicsState3.mPosition = d19;
                PhysicsState physicsState4 = this.mCurrentState;
                physicsState4.mVelocity = d18;
                physicsState4.mPosition = d17;
                if (Math.abs(d20 - d17) > SpringOverScroller.MIN_UPDATE_ONE_STEP || !this.mIsSpringBack || isAtRest()) {
                    break;
                }
                d15 = d28;
                str2 = str;
                d12 = d20;
            }
            if (SpringOverScroller.DEBUG) {
                Log.d(str, "update: tension = " + this.mConfig.mTension + " friction = " + this.mConfig.mFriction + "\nupdate: velocity = " + d18 + " position = " + d17);
            }
            this.mCOUICount++;
            return true;
        }

        public void updateScroll(float f10) {
            PhysicsState physicsState = this.mCurrentState;
            int i10 = this.mScrollStart;
            physicsState.mPosition = i10 + Math.round(f10 * (this.mScrollFinal - i10));
        }
    }

    static {
        boolean z10;
        if (!COUILog.LOG_DEBUG && !COUILog.isLoggable(TAG, 3)) {
            z10 = false;
        } else {
            z10 = true;
        }
        DEBUG = z10;
        mSpringBackFriction = 12.19f;
    }

    public SpringOverScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.mMode = 2;
        this.mEnableFlingSpeedIncrease = true;
        this.mLastFlingSpeedIncreaseRate = 1.0f;
        this.mIsUpdateTimeFromCallback = false;
        this.mCallback = new Choreographer.FrameCallback() { // from class: com.coui.appcompat.scroll.SpringOverScroller.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j10) {
                if (SpringOverScroller.this.mScrollerX != null) {
                    SpringOverScroller.this.mScrollerX.updateComputeTimeFromCallback(j10);
                }
                if (SpringOverScroller.this.mScrollerY != null) {
                    SpringOverScroller.this.mScrollerY.updateComputeTimeFromCallback(j10);
                }
                SpringOverScroller springOverScroller = SpringOverScroller.this;
                springOverScroller.mLastComputeTimeFromCallback = springOverScroller.mCurrentComputeTimeFromCallback;
                SpringOverScroller.this.mCurrentComputeTimeFromCallback = j10;
                SpringOverScroller.this.mIsUpdateTimeFromCallback = true;
                if (!SpringOverScroller.this.mCancelCallback) {
                    Choreographer.getInstance().postFrameCallback(this);
                }
            }
        };
        this.mScrollerX = new ReboundOverScroller();
        this.mScrollerY = new ReboundOverScroller();
        if (interpolator == null) {
            this.mInterpolator = new COUIViscousFluidInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
        setRefreshRateUnConvert(SOLVER_TIMESTEP_SEC);
        this.mContext = context;
        this.mFrameRateHelper = new COUlFrameRateScrollSceneHelper(false);
    }

    private int increaseVelocityIfNeed(int i10) {
        if (this.mEnableFlingSpeedIncrease) {
            long currentTimeMillis = System.currentTimeMillis();
            int i11 = this.mContinuousFlingCount;
            if (i11 > 0) {
                if (currentTimeMillis - this.mLastFlingTime <= 500 && i10 >= 8000) {
                    this.mLastFlingTime = currentTimeMillis;
                    int i12 = i11 + 1;
                    this.mContinuousFlingCount = i12;
                    if (i12 > 4) {
                        float f10 = this.mLastFlingSpeedIncreaseRate * FLING_SPEED_INCREASE_RATE;
                        this.mLastFlingSpeedIncreaseRate = f10;
                        return Math.max(-70000, Math.min((int) (i10 * f10), FLING_SPEED_INCREASE_MAX_VELOCITY));
                    }
                    return i10;
                }
                resetFlingSpeedValue();
                return i10;
            }
            if (i11 == 0) {
                this.mContinuousFlingCount = i11 + 1;
                this.mLastFlingTime = currentTimeMillis;
                return i10;
            }
            return i10;
        }
        return i10;
    }

    private void limitEdgeReachedVelocityIfNeed(ReboundOverScroller reboundOverScroller) {
        if (this.mEnableFlingSpeedIncrease && this.mContinuousFlingCount > 4) {
            ReboundOverScroller.PhysicsState physicsState = reboundOverScroller.mCurrentState;
            double d10 = physicsState.mVelocity;
            if (d10 > 20000.0d) {
                physicsState.mVelocity = 1000.0d;
            } else if (d10 < -20000.0d) {
                physicsState.mVelocity = -1000.0d;
            }
        }
    }

    private void resetFlingSpeedValue() {
        this.mLastFlingTime = 0L;
        this.mContinuousFlingCount = 0;
        this.mLastFlingSpeedIncreaseRate = 1.0f;
    }

    private void setRefreshRateUnConvert(float f10) {
        mRefreshTime = f10;
    }

    private static synchronized void setStaticSpringBackFriction(float f10) {
        synchronized (SpringOverScroller.class) {
            mSpringBackFriction = f10;
        }
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.scroll.COUIIOverScroller
    public void abortAnimation() {
        if (DEBUG) {
            Log.d(TAG, "abortAnimation", new Throwable());
        }
        this.mMode = 2;
        this.mScrollerX.setAtRest();
        this.mScrollerY.setAtRest();
        this.mCancelCallback = true;
        this.mFrameRateHelper.setFrameRate(false);
    }

    public void cancelCallback() {
        this.mCancelCallback = true;
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.scroll.COUIIOverScroller
    public boolean computeScrollOffset() {
        boolean z10 = true;
        if (isCOUIFinished()) {
            if (!this.mScrollerX.mCancelCallback || !this.mScrollerY.mCancelCallback) {
                z10 = false;
            }
            this.mCancelCallback = z10;
            return false;
        }
        int i10 = this.mMode;
        if (i10 != 0) {
            if (i10 == 1 && !this.mScrollerX.update() && !this.mScrollerY.update()) {
                abortAnimation();
            }
        } else {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mScrollerX.mScrollStartTime;
            int i11 = this.mScrollerX.mScrollDuration;
            if (currentAnimationTimeMillis < i11) {
                float interpolation = this.mInterpolator.getInterpolation(((float) currentAnimationTimeMillis) / i11);
                this.mScrollerX.updateScroll(interpolation);
                this.mScrollerY.updateScroll(interpolation);
            } else {
                this.mScrollerX.updateScroll(1.0f);
                this.mScrollerY.updateScroll(1.0f);
                abortAnimation();
            }
        }
        return true;
    }

    public void enableFrameRate(boolean z10) {
        this.mFrameRateHelper.enableFrameRate(z10);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.scroll.COUIIOverScroller
    public void fling(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        fling(i10, i11, i12, i13, i14, i15, i16, i17);
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public final int getCOUICurrX() {
        return (int) Math.round(this.mScrollerX.getCurrentValue());
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public final int getCOUICurrY() {
        return (int) Math.round(this.mScrollerY.getCurrentValue());
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public final int getCOUIFinalX() {
        return (int) this.mScrollerX.getEndValue();
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public final int getCOUIFinalY() {
        return (int) this.mScrollerY.getEndValue();
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.scroll.COUIIOverScroller
    public float getCurrVelocity() {
        double velocity = this.mScrollerX.getVelocity();
        double velocity2 = this.mScrollerY.getVelocity();
        return (int) Math.sqrt((velocity * velocity) + (velocity2 * velocity2));
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public float getCurrVelocityX() {
        return (float) this.mScrollerX.getVelocity();
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public float getCurrVelocityY() {
        return (float) this.mScrollerY.getVelocity();
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public final boolean isCOUIFinished() {
        boolean isAtRest = this.mScrollerX.isAtRest();
        boolean isAtRest2 = this.mScrollerY.isAtRest();
        if (DEBUG) {
            Log.d(TAG, "scrollX is rest: " + this.mScrollerX.isAtRest() + "  scrollY is rest: " + this.mScrollerY.isAtRest() + "  mMode = " + this.mMode);
        }
        if (isAtRest && isAtRest2 && this.mMode != 0) {
            return true;
        }
        return false;
    }

    public boolean isEnableFlingSpeedIncrease() {
        return this.mEnableFlingSpeedIncrease;
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public boolean isScrollingInDirection(float f10, float f11) {
        int i10 = (int) (this.mScrollerX.mEndValue - this.mScrollerX.mStartValue);
        int i11 = (int) (this.mScrollerY.mEndValue - this.mScrollerY.mStartValue);
        if (!isFinished() && Math.signum(f10) == Math.signum(i10) && Math.signum(f11) == Math.signum(i11)) {
            return true;
        }
        return false;
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.scroll.COUIIOverScroller
    public void notifyHorizontalEdgeReached(int i10, int i11, int i12) {
        this.mScrollerX.notifyEdgeReached(i10, i11, i12);
        springBack(i10, 0, 0, i11, 0, 0);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.scroll.COUIIOverScroller
    public void notifyVerticalEdgeReached(int i10, int i11, int i12) {
        this.mScrollerY.notifyEdgeReached(i10, i11, i12);
        springBack(0, i10, 0, 0, 0, i11);
    }

    public void postChoreographerCallback() {
        if (DEBUG) {
            Log.d(TAG, "postChoreographerCallback: post Callback");
        }
        Choreographer.getInstance().postFrameCallback(this.mCallback);
    }

    public void removeChoreographerCallback() {
        if (DEBUG) {
            Log.d(TAG, "removeChoreographerCallback: remove Callback");
        }
        Choreographer.getInstance().removeFrameCallback(this.mCallback);
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void setCurrVelocityX(float f10) {
        this.mScrollerX.mCurrentState.mVelocity = f10;
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void setCurrVelocityY(float f10) {
        this.mScrollerY.mCurrentState.mVelocity = f10;
    }

    public void setDebug(boolean z10) {
        DEBUG = z10;
    }

    public void setEnableFlingSpeedIncrease(boolean z10) {
        if (this.mEnableFlingSpeedIncrease == z10) {
            return;
        }
        this.mEnableFlingSpeedIncrease = z10;
        resetFlingSpeedValue();
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void setFlingFriction(float f10) {
        this.mScrollerX.mFlingFriction = f10;
        this.mScrollerY.mFlingFriction = f10;
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void setInterpolator(Interpolator interpolator) {
        if (interpolator == null) {
            this.mInterpolator = new COUIViscousFluidInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void setIsScrollView(boolean z10) {
        this.mScrollerX.mIsScrollView = z10;
        this.mScrollerY.mIsScrollView = z10;
    }

    public void setRefreshRate(float f10) {
        mRefreshTime = Math.round(10000.0f / f10) / 10000.0f;
    }

    public void setSpringBackFriction(float f10) {
        setStaticSpringBackFriction(f10);
    }

    public void setSpringBackTensionMultiple(float f10) {
        this.mScrollerX.mSpringBackTensionMultiple = f10;
        this.mScrollerY.mSpringBackTensionMultiple = f10;
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.scroll.COUIIOverScroller
    public boolean springBack(int i10, int i11, int i12, int i13, int i14, int i15) {
        if (DEBUG) {
            Log.d(TAG, "springBack startX = " + i10 + " startY = " + i11 + " minX = " + i12 + " minY = " + i14 + " maxY = " + i15, new Throwable());
        }
        boolean springBack = this.mScrollerX.springBack(i10, i12, i13);
        boolean springBack2 = this.mScrollerY.springBack(i11, i14, i15);
        if (springBack || springBack2) {
            this.mMode = 1;
        }
        if (springBack || springBack2) {
            return true;
        }
        return false;
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.scroll.COUIIOverScroller
    public void startScroll(int i10, int i11, int i12, int i13) {
        startScroll(i10, i11, i12, i13, SCROLL_DEFAULT_DURATION);
    }

    public void triggerCallback() {
        removeChoreographerCallback();
        postChoreographerCallback();
        this.mCancelCallback = false;
        this.mScrollerX.mCancelCallback = false;
        this.mScrollerY.mCancelCallback = false;
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.scroll.COUIIOverScroller
    public void fling(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        fling(i10, i11, i12, i13);
    }

    @Override // android.widget.OverScroller, com.coui.appcompat.scroll.COUIIOverScroller
    public void startScroll(int i10, int i11, int i12, int i13, int i14) {
        if (DEBUG) {
            Log.d(TAG, "startScroll startX = " + i10 + " startY = " + i11 + " dx = " + i12 + " dy = " + i13 + " duration = " + i14, new Throwable());
        }
        this.mMode = 0;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.mScrollerX.startScroll(i10, i12, i14, currentAnimationTimeMillis);
        this.mScrollerY.startScroll(i11, i13, i14, currentAnimationTimeMillis);
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void fling(int i10, int i11, int i12, int i13) {
        if (DEBUG) {
            Log.d(TAG, "fling startX = " + i10 + " startY = " + i11 + " velocityX = " + i12 + " velocityY = " + i13, new Throwable());
        }
        this.mMode = 1;
        this.mScrollerX.fling(i10, increaseVelocityIfNeed(i12));
        this.mScrollerY.fling(i11, increaseVelocityIfNeed(i13));
        this.mFrameRateHelper.setFrameRate(true);
    }

    public SpringOverScroller(Context context) {
        this(context, null);
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void setCOUIFriction(float f10) {
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void setDurationRatio(float f10) {
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void setFinalX(int i10) {
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void setFinalY(int i10) {
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void setVelocityXRatio(float f10) {
    }

    @Override // com.coui.appcompat.scroll.COUIIOverScroller
    public void setVelocityYRatio(float f10) {
    }
}
