package tech.liuyufeng.databindingdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Administrator on 2017/3/23.
 */

public class UserBean extends BaseObservable{
    public String name;
    public String pwd;
    public UserBean(String name, String pwd){
        this.name = name;
        this.pwd = pwd;
    }
    @Bindable
    public String getName(){
        return this.name;
    }
    @Bindable
    public String getPwd(){
        return this.pwd;
    }
    public void setName(String name){
         this.name = name;
    }
    public void setPwd(String pwd){
        this.pwd = pwd;
    }



}
