package com.tryine.zzp.ui.activity.mine.message;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Response;

public class SettingActivity extends BaseStatusMActivity implements View.OnClickListener {
    private TextView view_head_title;
    private CircleImageView setting_img_headimg;
    private TextView setting_name_tv;
    private ImageView setting_level_iv;
    private TextView setting_level_tv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void afterOnCreate() {
        loadMessage();
        loadData();
    }

    public void loadData(){
        findViewById(R.id.view_head_back).setOnClickListener(this);
        view_head_title= (TextView) findViewById(R.id.view_head_title);
        view_head_title.setText("设置");
        findViewById(R.id.setting_help_rl).setOnClickListener(this);
        findViewById(R.id.setting_member_rl).setOnClickListener(this);
        findViewById(R.id.contact_us_rl).setOnClickListener(this);
        findViewById(R.id.about_zzp_rl).setOnClickListener(this);
        findViewById(R.id.setting_logout_tv).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_head_back:
                finish();
                break;
            case R.id.contact_us_rl:
                startAct(ContactUsActivity.class);
                break;
            case R.id.setting_help_rl:
                startAct(HelpCenterActivity.class);
                break;
            case R.id.setting_member_rl:
                break;
            case R.id.about_zzp_rl:
                break;
            case R.id.setting_logout_tv:
                settingLogout();
                break;
            default:
                break;
        }
    }

    public void loadMessage(){
        OkHttpUtils
                .post()
                .url(Api.SETTING)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        LogUtils.e(string);
                        return string;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e(e);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        try {
                            JSONObject jsonObject =new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                            if (jsonObject.getInt("status")==330){
                                JSONObject list = new JSONObject(jsonObject.getString("list"));
                                String rank_name=list.getString("rank_name");
                                String face= list.getString("face");
                                String nick_name=list.getString("nickname");
                                String prestige =list.getString("prestige");
                                if (!rank_name.equals("null")){
                                    setting_level_tv.setText(rank_name);
                                }
                                if (!nick_name.equals("null")){
                                    setting_name_tv.setText(nick_name);
                                }
                            }
                        }catch (Exception e){

                        }
                    }
                });
    }

    public void settingLogout(){
        OkHttpUtils
                .post()
                .url(Api.LOGOUT)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        LogUtils.e(string);
                        return string;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e(e);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                            if (jsonObject.getInt("status")==330){
                                ToastUtils.showShort("注销成功！");
                            }
                        }catch (Exception e){

                        }
                    }
                });
    }

}