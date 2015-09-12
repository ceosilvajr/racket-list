package com.ceosilvajr.app.birthdaycard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ceosilvajr.app.birthdaycard.R;
import com.ceosilvajr.app.birthdaycard.objects.Student;

import java.util.List;

/**
 * Created by ceosilvajr on 9/12/15.
 */
public class StudentsAdapter extends ArrayAdapter<Student> {

    private Context mContext;
    private List<Student> mStudentList;

    public StudentsAdapter(Context context, List<Student> objects) {
        super(context, 0, objects);
        this.mContext = context;
        this.mStudentList = objects;
    }

    static class ViewHolder {

        TextView tvStudentName;
        TextView tvSubject;

        public ViewHolder(View view) {
            tvStudentName = (TextView) view.findViewById(R.id.tv_student_name);
            tvSubject = (TextView) view.findViewById(R.id.tv_student_subject);
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if (convertView != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            LayoutInflater layoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.container_student, parent, false);

            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        Student student = getItem(position);
        viewHolder.tvStudentName.setText(student.getName());
        viewHolder.tvSubject.setText(student.getSubject());

        return view;
    }

    @Override
    public int getCount() {
        return mStudentList.size();
    }

    @Override
    public Student getItem(int position) {
        return mStudentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
