package com.example.a11gacadmey.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassification;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.a11gacadmey.R;
import com.example.a11gacadmey.adapters.CourseAdapter;
import com.example.a11gacadmey.adapters.SessionsAdapter;
import com.example.a11gacadmey.databinding.FragmentCourseDetailBinding;
import com.example.a11gacadmey.interfaces.CourseInterface;
import com.example.a11gacadmey.models.CourseModel;
import com.example.a11gacadmey.models.SessionsModel;
import com.example.a11gacadmey.viewmodels.CourseViewModel;
import com.example.a11gacadmey.viewmodels.SessionViewModel;

import org.checkerframework.checker.units.qual.C;

import java.util.List;

public class CourseDetailFragment extends Fragment implements CourseInterface {

    FragmentCourseDetailBinding binding;
CourseViewModel viewModel;
SessionViewModel sessionViewModel;
SessionsAdapter adapter;
CourseAdapter adapter2;

NavController navController;



    public CourseDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentCourseDetailBinding.inflate(inflater,container,false);

        return binding.getRoot();
 }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        adapter = new SessionsAdapter();
        adapter2 = new CourseAdapter(this);
        viewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);


        sessionViewModel = new ViewModelProvider(requireActivity()).get(SessionViewModel.class);

        binding.setVariable(viewModel.getCourseModel());


        sessionViewModel.getSessions(viewModel.getCourseModel().getId()).observe(requireActivity(), new Observer<List<SessionsModel>>() {
            @Override
            public void onChanged(List<SessionsModel> sessionsModels) {

                adapter.submitList(sessionsModels);
            }
        });


        viewModel.getAllCoursesByTrainer(viewModel.getCourseModel().getTrainer().getId()).observe(requireActivity(), new Observer<List<CourseModel>>() {
            @Override
            public void onChanged(List<CourseModel> courseModels) {


                adapter2.submitList(courseModels);
            }
        });




        binding.SessionsDataList.setAdapter(adapter);

        binding.courseDataList.setAdapter(adapter2);


        navController = Navigation.findNavController(view);


    }

    @Override
    public void moreCourses(String Category) {

    }

    @Override
    public void CourseDetail(CourseModel courseModel) {
        viewModel.setCourseModel(courseModel);
        navController.navigate(R.id.action_courseDetailFragment_self);
    }
}