package com.xutest;

import org.testng.TestListenerAdapter;
import org.testng.ITestResult;
import org.testng.ITestContext;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.xutest.Connect;


public class XListener extends TestListenerAdapter {
    long start_time;
    long end_time;
    @Override
    public void onStart(ITestContext var1) {
        super.onStart(var1);
        this.start_time = System.nanoTime();
    }

    @Override
    public void onFinish(ITestContext tr) {
        super.onFinish(tr);
        // 计算运行时间(纳秒级精度)
        this.end_time = System.nanoTime();
        long time = this.end_time - this.start_time;
        double run_time = time/1000000000.0;

        //extract test result
        JSONObject test_result = new JSONObject();
        JSONArray details = new JSONArray();
        for (ITestResult FailedTests : tr.getFailedTests().getAllResults()) {
            JSONObject detail = new JSONObject();
            String test_class = FailedTests.getTestClass().getName().toString();
            detail.put("status", "failures");
            detail.put("note", FailedTests.getThrowable().toString());
            detail.put("test_case", FailedTests.getName().toString());
            detail.put("explain", test_class);
            details.add(detail);
        }
        Integer p = tr.getPassedTests().size();
        Integer f = tr.getFailedTests().size();
        Integer s = tr.getSkippedTests().size();
        Integer t = p+f+s;
        boolean was_successful = (f == 0)? true: false;

        //all these should not be empty.
        test_result.put("was_successful", was_successful);
        test_result.put("errors", 0);
        test_result.put("failures", f);
        test_result.put("skipped", s);
        test_result.put("total", t);
        test_result.put("run_time", run_time);
        test_result.put("details", details);

        //TODO: you need to write your own function to get your project's version.
        test_result.put("pro_version", "0.0.0.0");

        //TODO: these should call from configure file.
        //change these config to your own x-utest.
        test_result.put("pro_id", "5a7fb0f047de9d5cf3d13a45");
        String base_url = "http://192.168.0.29:8011";
        String app_id = "376223a60d7811e883dc448a5b61a7f0";
        String app_key = "cf71ab7e937620de5767ecc08780a69b";

        // send to x-utest system
        Connect http = new Connect(base_url, app_id, app_key);
        try {
            http.auth();
            http.post_test_result(test_result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
