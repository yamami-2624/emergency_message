package com.example.emergencymessage;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import java.util.Map;
import java.util.Objects;


public class DetailsFragment extends Fragment {
    private boolean isTwoPane = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = Objects.requireNonNull(getActivity());
        if(activity.findViewById(
                R.id.detailsFrame) != null) {
            isTwoPane = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        Bundle bundle;
        AppCompatActivity activity = Objects.requireNonNull(getActivity());
        if(isTwoPane) {
            bundle = Objects.requireNonNull(getArguments());
        } else {
            Intent intent = activity.getIntent();
            bundle = Objects.requireNonNull(intent.getExtras());
        }
        Map<String, String> item = ListDataSource.getInfoByName(
                bundle.getString("name"));
        ((TextView)view.findViewById(R.id.name)).setText(String.format(
                "%s（%s）",bundle.getString("name"), item.get("alias")));
        ((TextView) view.findViewById(R.id.info)).setText(item.get("info"));
        return view;
    }
}

