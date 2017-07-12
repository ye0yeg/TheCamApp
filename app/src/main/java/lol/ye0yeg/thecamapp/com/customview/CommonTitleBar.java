package lol.ye0yeg.thecamapp.com.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import lol.ye0yeg.thecamapp.R;

/**
 * Created by Administrator on 7/12/2017.
 */

public class CommonTitleBar extends RelativeLayout {




    public CommonTitleBar(Context context, AttributeSet attrs) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_title_bar, this);
    }


}
