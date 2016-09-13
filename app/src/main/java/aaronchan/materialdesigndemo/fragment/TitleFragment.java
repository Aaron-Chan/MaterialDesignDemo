package aaronchan.materialdesigndemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import aaronchan.materialdesigndemo.R;
import aaronchan.materialdesigndemo.activity.PlaceDetailActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitleFragment extends Fragment {


    @BindView(R.id.iv_place)
    ImageView mIvPlace;

    public TitleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.iv_place)
    public void onClick() {
        Intent intent = new Intent(getActivity(), PlaceDetailActivity.class);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), mIvPlace, "place");
        startActivity(intent, optionsCompat.toBundle());
    }
}
