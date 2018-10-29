package com.example.administrator.ipc_server.aidl_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.administrator.ipc_server.aidl_binder.StudentBinder;
import com.example.administrator.ipc_server.aidl_entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManagerService extends Service {

    private static final String TAG = "StudentManagerService";
    private StudentBinder studentBinder;
    private List<Student> studentList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: service start");
        initData();
        studentBinder = new StudentBinder(studentList);
    }

    private void initData() {
        for (int i = 0 ; i < 5 ; i ++){
            studentList.add(new Student("what-->"+i , 1 , 24+i));
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return studentBinder;
    }


}
