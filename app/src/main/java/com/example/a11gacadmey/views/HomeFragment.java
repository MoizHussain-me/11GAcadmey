package com.example.a11gacadmey.views;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.a11gacadmey.R;
import com.example.a11gacadmey.adapters.CategoryAdapter;
import com.example.a11gacadmey.adapters.CategoryAdapterHome;
import com.example.a11gacadmey.adapters.CourseAdapter;
import com.example.a11gacadmey.adapters.CourseSectionAdapter;
import com.example.a11gacadmey.databinding.FragmentHomeBinding;
import com.example.a11gacadmey.interfaces.CourseInterface;
import com.example.a11gacadmey.models.CategoryModel;
import com.example.a11gacadmey.models.CourseModel;
import com.example.a11gacadmey.models.CourseSectionModel;
import com.example.a11gacadmey.viewmodels.CategoryViewModel;
import com.example.a11gacadmey.viewmodels.CourseViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements CourseInterface {

    NavController navController;
    CourseSectionAdapter adapter;
    CategoryAdapterHome categoryAdapter;

    CourseViewModel viewModel;
    CategoryViewModel catviewModel;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        categoryAdapter = new CategoryAdapterHome();


        FragmentHomeBinding binding =   FragmentHomeBinding.inflate(inflater, container,false );

        adapter = new CourseSectionAdapter(this);

        binding.courseList.setAdapter(adapter);

        binding.deals.setAdapter(categoryAdapter);

        viewModel = new ViewModelProvider(requireActivity()).get(CourseViewModel.class);

        viewModel.getCourseSection().observe(requireActivity(), new Observer<List<CourseSectionModel>>() {
            @Override
            public void onChanged(List<CourseSectionModel> courseSectionModels) {

                adapter.submitList(courseSectionModels);
            }
        });

        catviewModel = new ViewModelProvider(requireActivity()).get(CategoryViewModel.class);

        catviewModel.getCatList().observe(requireActivity(), new Observer<List<CategoryModel>>() {


            public void onChanged(List<CategoryModel> categoryModels) {

                int count = 0;
                ArrayList<CategoryModel> filteredList = new ArrayList<>();
                for (CategoryModel cat: categoryModels) {

                    if(count < 5)
                    {

                        filteredList.add(cat);
                        count++;
                    }


                }


                categoryAdapter.submitList(filteredList);

            }
        });





        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        navController = Navigation.findNavController(view);



    }

    @Override
    public void moreCourses(String Category) {

        viewModel.setCategory(Category);
        navController.navigate(R.id.action_homeFragment_to_moreCategoriesFragment);


    }

    @Override
    public void CourseDetail(CourseModel courseModel) {

        viewModel.setCourseModel(courseModel);
        navController.navigate(R.id.action_homeFragment_to_courseDetailFragment);
    }
}