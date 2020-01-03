package com.project.semicolon.eduactive.ui.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.project.semicolon.eduactive.R;
import com.project.semicolon.eduactive.customview.CourseTableLayout;
import com.project.semicolon.eduactive.customview.model.CourseInfo;
import com.project.semicolon.eduactive.customview.model.StudentCourse;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudyTimeTableFragment extends Fragment {
    private static final String TAG = "StudyTimeTableFragment";


    public StudyTimeTableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study_time_table, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CourseTableLayout courseTableLayout = view.findViewById(R.id.study_time_table);
        final CourseInfo courseInfo = new CourseInfo();
        final ArrayList<CourseInfo> courseInfoList = new ArrayList<>();
        courseInfo.setName("Human Computer Interaction");
        courseInfo.setCourseTime("1", "", "", "",
                "", "", "");
        courseInfoList.add(courseInfo);
        CourseInfo courseInfo1 = new CourseInfo();
        courseInfo1.setName("Operation Research");
        courseInfo1.setCourseTime("4", "", "", "",
                "", "", "");

        courseInfoList.add(courseInfo1);

        CourseInfo courseInfo2 = new CourseInfo();
        courseInfo2.setName("Fundamental of Thermodynamic");
        courseInfo2.setCourseTime("", "", "1", "", "", "", "");

        courseInfoList.add(courseInfo2);

        StudentCourse studentCourse = new StudentCourse();

        studentCourse.setCourseList(courseInfoList);
        courseTableLayout.setStudentCourse(studentCourse);

        courseTableLayout.setOnCourseClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CourseInfo tag = (CourseInfo) view.getTag();
                Log.d(TAG, "onClick: " + tag.getName());
                Toast.makeText(getContext(), "" + tag.getName(), Toast.LENGTH_SHORT).show();
            }
        });





  /*      RecyclerView studyTimeTableRecycler = view.findViewById(R.id.study_time_table_recycler);
        studyTimeTableRecycler.setHasFixedSize(true);
        studyTimeTableRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new StudyTimeTableAdapter();
        studyTimeTableRecycler.setAdapter(adapter);*/


//
//        setDummyData();


    }


//    private void setDummyData() {
//        List<StudyTimeTableModel> modelList = new ArrayList<>();
//
//        modelList.add(new StudyTimeTableModel("Course 1", "Instructor 1", "8.30 AM - 10 AM", "H214"));
//        modelList.add(new StudyTimeTableModel("Course 2", "Instructor 2", "10.10 AM - 11.40 AM", "H313"));
//        modelList.add(new StudyTimeTableModel("Course 3", "Instructor 3", "11.50 AM - 1.20 PM", "H214"));
//        modelList.add(new StudyTimeTableModel("Course 4", "Instructor 4", "1.40 PM - 3.10 PM", "H507"));
//
//        adapter.setModelList(modelList);
//
//    }

}
