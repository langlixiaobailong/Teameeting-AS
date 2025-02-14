package org.dync.teameeting.helper;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;

import javax.xml.datatype.Duration;

public class Anims
{
    public static final Interpolator ACCELERATE = new AccelerateInterpolator();
    ;
    public static final Interpolator LINEA = new LinearInterpolator();
    public static final Interpolator EASE_IN_EASE_OUT = new AccelerateDecelerateInterpolator();
    public static final Interpolator EASE_OUT = new DecelerateInterpolator();

    public static void animateRightMarginTo(final View paramView, float startX, float endX, int Duration, TimeInterpolator paramTimeInterpolator)
    {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(paramView, "translationX",startX,endX );
        objectAnimator.setDuration(Duration);
        objectAnimator.setInterpolator(paramTimeInterpolator);
        objectAnimator.start();
    }

    public static void animateBottomMarginTo(final View paramView, int paramInt, long paramLong,
                                             TimeInterpolator paramTimeInterpolator)
    {
        final RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams) paramView
                .getLayoutParams();
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = localLayoutParams.bottomMargin;
        arrayOfInt[1] = paramInt;
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(arrayOfInt);
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
            {
                localLayoutParams.bottomMargin = ((Integer) paramAnonymousValueAnimator
                        .getAnimatedValue()).intValue();
                paramView.requestLayout();
            }
        });
        localValueAnimator.setInterpolator(paramTimeInterpolator);
        localValueAnimator.setDuration(paramLong);
        localValueAnimator.start();
    }

    public static void fadeOut(View paramView)
    {
        fadeOut(paramView, 200L);
    }

    public static void fadeOut(View paramView, long paramLong)
    {
        float[] arrayOfFloat = new float[2];
        arrayOfFloat[0] = paramView.getAlpha();
        arrayOfFloat[1] = 0.0F;
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha",
                arrayOfFloat);
        localObjectAnimator.setDuration(paramLong);
        localObjectAnimator.setInterpolator(EASE_OUT);
        localObjectAnimator.start();
    }

    public static void fadeIn(View paramView)
    {
        fadeIn(paramView, 200L, 0L);
    }

    public static void fadeIn(View paramView, long paramLong1, long paramLong2)
    {
        float[] arrayOfFloat = new float[2];
        arrayOfFloat[0] = paramView.getAlpha();
        arrayOfFloat[1] = 1.0F;
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha",
                arrayOfFloat);
        localObjectAnimator.setDuration(paramLong1);
        if (paramLong2 > 0L)
        {
            localObjectAnimator.setStartDelay(paramLong2);
        }
        localObjectAnimator.setInterpolator(EASE_OUT);
        localObjectAnimator.start();
        paramView.setVisibility(View.VISIBLE);
    }


}
