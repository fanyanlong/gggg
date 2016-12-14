package test.mvp.login.model;

import test.mvp.login.bean.ICallBack;

/**
 * autour: 樊彦龙
 * date: 2016/12/13 18:44 
 * update: 2016/12/13
 */

public interface ILoginBean {
    void login(String userName,String pwd,ICallBack callBack);
}
