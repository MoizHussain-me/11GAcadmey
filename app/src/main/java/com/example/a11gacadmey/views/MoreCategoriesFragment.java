package com.example.a11gacadmey.views;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a11gacadmey.R;
import com.example.a11gacadmey.adapters.CategoryAdapter;
import com.example.a11gacadmey.adapters.CourseAdapter;
import com.example.a11gacadmey.databinding.FragmentMoreCategoriesBinding;
import com.example.a11gacadmey.interfaces.CourseInterface;
import com.example.a11gacadmey.models.CategoryModel;
import com.example.a11gacadmey.models.CourseModel;
import com.example.a11gacadmey.models.CourseSectionModel;
import com.example.a11gacadmey.viewmodels.CategoryViewModel;
import com.example.a11gacadmey.viewmodels.CourseViewModel;

import java.util.List;

public class MoreCategoriesFragment extends Fragment implements CourseInterface {

    FragmentMoreCategoriesBinding binding;
    CourseAdapter adapter;
    NavController navController;

    CourseViewModel courseViewModel;


    public MoreCategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMoreCategoriesBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new CourseAdapter(this);

        binding.categoryList.setAdapter(adapter);

        courseViewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);


        String cat = courseViewModel.getCategory();




        courseViewModel.getCourseSection().observe(requireActivity(), new Observer<List<CourseSectionModel>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(List<CourseSectionModel> courseSectionModels) {


                courseSectionModels.forEach(courseSectionModel -> {

                    if(courseSectionModel.getCategory().equals(cat))
                    {

                        adapter.submitList(courseSectionModel.getCourseList());

                    }

                });




            }
        });
        navController = Navigation.findNavController(view);


    }

    @Override
    public void moreCourses(String Category) {

    }

    @Override
    public void CourseDetail(CourseModel courseModel) {
        courseViewModel.setCourseModel(courseModel);
        navController.navigate(R.id.action_moreCategoriesFragment_to_courseDetailFragment);
    }
}