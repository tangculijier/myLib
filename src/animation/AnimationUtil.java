package animation;


import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
/**
 * �������� ���ڲ���һЩ�ض��Ķ���
 */
public class AnimationUtil
{
	
	public final static int START_UPANIMATION = 0;
	
	public final static int START_DOWNANIMATION = 1;
	
	/**
	 * �Ŵ�1.3�� ͬʱ��ת360�� ��������
	 * @return 
	 */
	public static AnimationSet getAddBalanceAnimation()
	{
		AnimationSet animationSet = new AnimationSet(true);
		ScaleAnimation enlargeAnimation = new ScaleAnimation(1f, 1.3f, 1f, 1.3f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		RotateAnimation rorateAnimation =new RotateAnimation(0f,360f,
				Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		animationSet.addAnimation(rorateAnimation);
		animationSet.addAnimation(enlargeAnimation);
		animationSet.setDuration(2000);
		return animationSet;
		
	}
	
	/**
	 * ��С0.6�� ͬʱ��ת-360�� ��������
	 * @param reducePercent ��С�İٷֱ� 0f��С����ʧ
	 * @return 
	 */
	public static AnimationSet getSubBalanceAnimation(float reducePercent)
	{
		AnimationSet animationSet = new AnimationSet(true);
		ScaleAnimation decreaseAnimation = new ScaleAnimation(1f, reducePercent, 1f, reducePercent,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		RotateAnimation rorateAnimation =new RotateAnimation(0f,-360f,
				Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		animationSet.addAnimation(rorateAnimation);
		animationSet.addAnimation(decreaseAnimation);
		animationSet.setDuration(2000);
		boolean fillAfter = reducePercent == 0f ? true : false;
		animationSet.setFillAfter(fillAfter);
		return animationSet;
		
	}
	
	/**
	 * ��fromX�ƶ���Tox ͬʱ��ת-360��*4Ȧ
	 * @param duration ����ʱ�� 
	 * @return  ��������
	 */
	public static AnimationSet getFaceRollOutAnimation(float fromX,float ToX,long duration)
	{
		LogUtil.d("huang", "fromX="+fromX+" ToX"+ToX);
		AnimationSet animationSet = new AnimationSet(true);
		TranslateAnimation moveOutToLeftAnimaiton = new TranslateAnimation
				(fromX,ToX, 0f, 0f);
		moveOutToLeftAnimaiton.setDuration(duration);
		
		RotateAnimation rollAnimation = new RotateAnimation
				(0f,-360f*4,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		//rollAnimation.setRepeatCount(1);
		rollAnimation.setDuration(duration);
		animationSet.addAnimation(rollAnimation);
		animationSet.addAnimation(moveOutToLeftAnimaiton);
		animationSet.setInterpolator(new AccelerateInterpolator());
		//animationSet.setDuration(2000);
		return animationSet;
	}
	
	
	public static AnimationSet getFaceRollInAndOutAnimation(float fromX,float ToX,long duration)
	{
		LogUtil.d("huang", "fromX="+fromX+" ToX"+ToX);
		AnimationSet animationSet = new AnimationSet(true);
		TranslateAnimation moveOutToLeftAnimaiton = new TranslateAnimation
				(fromX,ToX, 0f, 0f);
		moveOutToLeftAnimaiton.setDuration(duration);
		
		RotateAnimation rollAnimation = new RotateAnimation
				(0f,-360f*4,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
		//rollAnimation.setRepeatCount(1);
		rollAnimation.setDuration(duration);
		animationSet.addAnimation(rollAnimation);
		animationSet.addAnimation(moveOutToLeftAnimaiton);
		animationSet.setInterpolator(new OvershootInterpolator());
		//animationSet.setDuration(2000);
		return animationSet;
	}
	
	/**
	 * �������� 
	 * @param fromY ��ʼλ��
	 * @param ToY����λ��
	 * @param duration ����ʱ�� 
	 * @return 
	 */
	public static AnimationSet getJumpUpAnimation(final float fromY,final float ToY,long duration)
	{
		AnimationSet animationSet = new AnimationSet(true);
		TranslateAnimation jumpUpAnimaiton = new TranslateAnimation
				(0f,0f, fromY, ToY);
		jumpUpAnimaiton.setDuration(duration);
		animationSet.addAnimation(jumpUpAnimaiton);
		animationSet.setFillAfter(false);//jumpUpAnimaiton.setFillAfter(true);//��Ч
		animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
		return animationSet;
	}
	
	/**
	 * ��������
	 * @param duration ����ʱ�� 
	 * @return 
	 */
	public static AnimationSet getDownAnimation(float fromY,float ToY,long duration)
	{
		AnimationSet animationSet = new AnimationSet(true);
		TranslateAnimation dwonAnimation = new TranslateAnimation(0f, 0f, fromY,ToY );
		dwonAnimation.setDuration(1000);
		dwonAnimation.setFillAfter(true);
		animationSet.setInterpolator(new BounceInterpolator());//dwonAnimation.setinterploatorû��
		animationSet.addAnimation(dwonAnimation);
		return animationSet;
	}
}
