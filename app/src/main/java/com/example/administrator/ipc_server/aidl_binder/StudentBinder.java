package com.example.administrator.ipc_server.aidl_binder;

import android.os.RemoteException;

import com.example.administrator.ipc_server.IStudentInterface;
import com.example.administrator.ipc_server.aidl_entity.Student;

import java.util.List;

public class StudentBinder extends IStudentInterface.Stub {

    private List<Student> studentList;

    public StudentBinder(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public void addStudent(Student s) throws RemoteException {
        studentList.add(s);
    }

    @Override
    public List<Student> getAllStudent() throws RemoteException {
        return studentList;
    }
}
