package com.example.demofacebook.Fragment.StudioDetailFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demofacebook.Adapter.StudioDetail.FeedbackAdapter;
import com.example.demofacebook.Adapter.StudioDetail.Interface.IClickItemFeedbackListener;
import com.example.demofacebook.Model.Feedback;
import com.example.demofacebook.Model.Studio;
import com.example.demofacebook.R;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StudioFeedbackFragment extends Fragment {
    final private Studio studio;
    private RecyclerView recyclerViewFeedback;
    private FeedbackAdapter feedbackAdapter;
    private List<Feedback> mFeedbackList;

    public StudioFeedbackFragment(Studio studio) {
        this.studio = studio;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewFeedback = view.findViewById(R.id.FeedbackRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerViewFeedback.setLayoutManager(linearLayoutManager);
        mFeedbackList = getFeedbackData();
        feedbackAdapter = new FeedbackAdapter(mFeedbackList, new IClickItemFeedbackListener() {
            @Override
            public void onClickItemFeedback(Feedback feedback) {
                Toast.makeText(getActivity(), feedback.getFeedbackUserName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerViewFeedback.setAdapter(feedbackAdapter);

    }

    private List<Feedback> getFeedbackData() {
        List<Feedback> myList = new ArrayList<>();
        String str = "2015-03-31";
        Date dateChange = Date.valueOf(str);
        myList.add(new Feedback(R.drawable.download, studio.getTitle(), 5, getString(R.string.feedbackString), R.drawable.download, dateChange));
        myList.add(new Feedback(R.drawable.download, studio.getTitle(), 5, getString(R.string.feedbackString), R.drawable.download, dateChange));
        myList.add(new Feedback(R.drawable.download, studio.getTitle(), 5, getString(R.string.feedbackString), R.drawable.download, dateChange));
        myList.add(new Feedback(R.drawable.download, studio.getTitle(), 5, getString(R.string.feedbackString), R.drawable.download, dateChange));
        myList.add(new Feedback(R.drawable.download, studio.getTitle(), 5, getString(R.string.feedbackString), R.drawable.download, dateChange));
        myList.add(new Feedback(R.drawable.download, studio.getTitle(), 5, getString(R.string.feedbackString), R.drawable.download, dateChange));

        return myList;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_studio_feedback, container, false);
        return view;
    }
}