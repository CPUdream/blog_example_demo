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

/**
 * @author CPUdream on 2016/12/27
 */
public class LoginModelImpl implements LoginModel {
    /**
     * Login operation include Login sucess and failed.
     *
     * @param name     Login username
     * @param password Login password
     * @param listener listener Login Finished
     */
    @Override public void login(final String name, final String password, final OnLoginFinishedListener listener) {
        new Thread() {
            @Override public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                    if ("1".equals(name) && "1".equals(password)) {
                        listener.onLoginSucess();

                    } else {
                        listener.onLoginFailed();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
