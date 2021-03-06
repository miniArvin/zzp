package com.tryine.zzp.ui;

import android.os.SystemClock;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

import static com.tryine.zzp.app.constant.Cons.SP_USER_ACCOUNT;
import static com.tryine.zzp.app.constant.Cons.SP_USER_EMAIL;
import static com.tryine.zzp.app.constant.Cons.SP_USER_FACE;
import static com.tryine.zzp.app.constant.Cons.SP_USER_ID;
import static com.tryine.zzp.app.constant.Cons.SP_USER_NAME;
import static com.tryine.zzp.app.constant.Cons.SP_USER_PHONE;
import static com.tryine.zzp.app.constant.Cons.SP_USER_TOKEN;

public class SplashActivity extends BaseStatusMActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void afterOnCreate() {
//        login();
        startUI();
    }

    public void startUI() {
        startAct(MainActivity.class);
        finish();
    }

//    public void login(){
//        OkHttpUtils
//                .post()
//                .url(Api.LOGIN)
//                .addParams("account", "18627594449")
//                .addParams("password", "1234567")
//                .build()
//                .execute(new Callback() {
//
//                    @Override
//                    public Object parseNetworkResponse(Response response, int id) throws Exception {
//                        String string = response.body().string();
//                        LogUtils.e("response.body", string);
//                        return string;
//                    }
//
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        LogUtils.e(e);
//                    }
//
//                    @Override
//                    public void onResponse(Object response, int id) {
//                        LogUtils.e("user,user", response.toString());
//                        try {
//                            JSONObject jsonObject = new JSONObject(response.toString());
//                            if (jsonObject.getInt("status") == 202) {
//                                LogUtils.e("user,status", jsonObject.getInt("status") + "");
//                                JSONObject userInfo = jsonObject.getJSONObject("user_info");
//                                JSONObject userToken = jsonObject.getJSONObject("user_token");
//                                LogUtils.e("user,response", userInfo.getString("user_id"));
//                                SPUtils.getInstance().put(SP_USER_ID,userInfo.getString("user_id"));
//                                SPUtils.getInstance().put(SP_USER_TOKEN,userToken.getString("token"));
//                                LogUtils.e(SPUtils.getInstance("spConfig").getString(SP_USER_TOKEN));
//                                SPUtils.getInstance().put(SP_USER_EMAIL,userInfo.getString("email"));
//                                SPUtils.getInstance().put(SP_USER_ACCOUNT,userInfo.getString("account"));
//                                SPUtils.getInstance().put(SP_USER_NAME,userInfo.getString("nickname"));
//                                SPUtils.getInstance().put(SP_USER_FACE,userInfo.getString("face"));
//                                new Thread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        SystemClock.sleep(100);
//                                        startUI();
//                                    }
//                                }).start();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                });
//    }

}
