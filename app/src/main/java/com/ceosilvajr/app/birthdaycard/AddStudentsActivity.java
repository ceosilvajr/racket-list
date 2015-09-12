package com.ceosilvajr.app.birthdaycard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.ceosilvajr.app.birthdaycard.adapters.StudentsAdapter;
import com.ceosilvajr.app.birthdaycard.objects.Student;

import java.util.ArrayList;
import java.util.List;

public class AddStudentsActivity extends AppCompatActivity {

    private EditText mEdtStudentName;
    private EditText mEdtSubject;
    private Button mBtnAddStudent;
    private ListView mLVStudents;

    private List<Student> mStudentsList;
    private StudentsAdapter mStudentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_students);

        initViews();
        initStudentAdapter();

    }

    private void initViews() {
        mEdtStudentName = (EditText) findViewById(R.id.edt_student_name);
        mEdtSubject = (EditText) findViewById(R.id.edt_subject);
        mBtnAddStudent = (Button) findViewById(R.id.btn_add);
        mLVStudents = (ListView) findViewById(R.id.list_item);

        mBtnAddStudent.setOnClickListener(onAddBtnClicked);
    }

    private void initStudentAdapter() {
        mStudentsList = new ArrayList<>();
        mStudentsAdapter = new StudentsAdapter(this, mStudentsList);
        mLVStudents.setAdapter(mStudentsAdapter);
    }

    private void addStudents(String studentName, String subject) {
        Student student = new Student(studentName, subject);
        mStudentsList.add(student);
        mStudentsAdapter.notifyDataSetChanged();
        clearEditText();
    }

    private void clearEditText() {
        mEdtStudentName.setText("");
        mEdtSubject.setText("");
    }

    private View.OnClickListener onAddBtnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String studentName = mEdtStudentName.getText().toString();
            String subject = mEdtSubject.getText().toString();

            if (studentName.isEmpty()) {
                mEdtStudentName.setError("PLease enter name");
                return;
            }
            if (subject.isEmpty()) {
                mEdtSubject.setError("Please enter subject");
                return;
            }

            addStudents(studentName, subject);
        }
    };

}
