package com.example.transitiondemo;

import com.example.base.BaseJumpActivity;
import com.example.base.Utils;

import java.util.List;

/**
 * createBy keepon
 */
public class JumpActivity extends BaseJumpActivity {
    @Override
    protected void onRecyclerviewItemClick(int poisiton) {
        switch (poisiton) {
            case 0:
                Utils.startActivity(this, TransitionActivity.class);
                //这个方法需要在startActivity()或者finish()方法之后立即被调用。
                overridePendingTransition(R.anim.out_to_left, R.anim.in_from_right);
                break;
            case 1:
                Utils.startActivity(this, FragmentCustomAnimationsActivity.class);
                break;
            default:
                break;
        }

    }

    // @Override
    // public void overridePendingTransition(int enterAnim, int exitAnim) {
    //     super.overridePendingTransition(R.anim.in_from_right, R.anim.down_bottom_in);
    // }

    @Override
    protected void setData(List<String> titles) {
        titles.add("TransitionActivity");
        titles.add("FragmentCustomAnimationsActivity");
    }
}
