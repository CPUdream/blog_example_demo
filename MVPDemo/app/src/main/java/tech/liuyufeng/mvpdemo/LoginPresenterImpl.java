/*
* Copyright (C) 2016 CPUdream (http://liuyufeng.tech).
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package tech.liuyufeng.mvpdemo;

import android.os.Handler;
import android.os.Message;

/**
 * @author CPUdream on 2016/12/27
 */
public class LoginPresenterImpl implements LoginPresenter, LoginModel.OnLoginFinishedListener {
    private ImainView mLoginView;
    private LoginModel model;
    private Handler mHandler = new Handler() {
        @Override public void handleMessage(Message msg) {
            if (msg.what == 1) {
                mLoginView.hideProgress();
                mLoginView.setLoginSucess();
            } else {
                mLoginView.hideProgress();
                mLoginView.setLoginFail();
            }
        }
    };

    public LoginPresenterImpl(ImainView view) {
        mLoginView = view;
        model = new LoginModelImpl();
    }

    @Override public void login(String name, String password) {
        mLoginView.showProgress();
        model.login(name, password, this);
    }

    @Override public void onLoginFailed() {
        Message msg = Message.obtain();
        msg.what = 2;
        mHandler.sendMessage(msg);
    }

    @Override public void onLoginSucess() {
        Message msg = Message.obtain();
        msg.what = 1;
        mHandler.sendMessage(msg);
    }
}
