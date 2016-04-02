package com.quhaofeng.broadcastbestpractice;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    //  一个测试用例
    public void testAddActivity(){
        assertEquals(0, ActivityCollecter.sActivities.size());//断言sActivities.size()的大小为0
        LoginActivity loginActivity = new LoginActivity();
        ActivityCollecter.addActivity(loginActivity);
        assertEquals(1, ActivityCollecter.sActivities.size());//断言添加一个activity之后 其大小变成了1
        ActivityCollecter.addActivity(loginActivity);
        assertEquals(1, ActivityCollecter.sActivities.size());//又添加了一个之后断言其大小为1，错误
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}