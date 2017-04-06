package org.caworks.library.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Basis of all fragment
 * Created by Gallon on 2017/3/16
 */

public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    protected View mViewRoot;

    private boolean inViewPager = false;
    private boolean isVisiable = false;
    private boolean isInit = false;
    private int layoutId;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isInit = true;
        if (mViewRoot == null) {
//            WWLog.d("gallon", "onCreateView:" + this.getClass().getSimpleName());
            mViewRoot = inflater.inflate(getLayoutId(), null);
            init();
        }
        return mViewRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mViewRoot != null) {
            ViewParent parent = mViewRoot.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeView(mViewRoot);
            }
        }
    }

    /**
     * Be called when used in ViewPager
     * Note: method will be called before onCreateView first time
     * @see #onCreateView
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (!isInit)
            return;

        if (getUserVisibleHint()) {
            isVisiable = true;
        } else {
            isVisiable = false;
        }
    }

    protected abstract int getLayoutId();

    protected abstract void init();
}
