package lol.ye0yeg.thecamapp.app.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.melnykov.fab.FloatingActionButton;

import butterknife.ButterKnife;
import butterknife.InjectView;
import de.greenrobot.event.EventBus;
import lol.ye0yeg.thecamapp.R;
import lol.ye0yeg.thecamapp.common.util.DataUtils;
import lol.ye0yeg.thecamapp.stickercamera.App;
import lol.ye0yeg.thecamapp.stickercamera.AppConstants;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.fab)
    FloatingActionButton fab;
    @InjectView(R.id.recycle_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        EventBus.getDefault().register(this);
        initView();
        //如果没有PIC就打开Cam  [-0-]
        String str  = DataUtils.getStringPreferences(App.getApp(),
                AppConstants.FEED_INFO);
    }

    private void initView() {

    }

}
