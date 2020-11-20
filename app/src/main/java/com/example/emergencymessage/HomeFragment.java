package com.example.emergencymessage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;

public class HomeFragment extends Fragment {

    private boolean isTwoPane = false;

//    @Override
//    // フラグメントの親であるactivity_mainが起動した時に呼び出される。
//    // Bundle　　画面の破棄、再生成の役割を果す。
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        Activity activity = Objects.requireNonNull(getActivity());
//        if(activity.findViewById(com.example.emergencymessage.homeFrame) != null) {
//            isTwoPane = true;
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Fragment activity = Objects.requireNonNull(getActivity());
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                activity, android.R.layout.simple_list_item_1,
                ListDataSource.getAllNames());
        ListView list = view.findViewById(R.id.home);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /*
            // タブレットだけの場合
            @Override
            public void onItemClick(
                AdapterView<?> parent, View view, int i, long id) {
                FragmentManager manager = Objects.requireNonNull(getFragmentManager());
                DetailsFragment fragment = new DetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name",
                    (String) parent.getItemAtPosition(i));
                fragment.setArguments(bundle);
                manager.beginTransaction()
                    .replace(R.id.detailsFrame, fragment)
                    .commit();
            }
            */


            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int i, long id) {
                FragmentManager manager = Objects.requireNonNull(getFragmentManager());
                DashboardFragment fragment = new DashboardFragment();
                //bundleに新しい値を設定、
                Bundle bundle = new Bundle();
                // クリックされたスパイスの名前をBundleに代入、nameという名前で登録
                bundle.putString("name", (String) parent.getItemAtPosition(i));
                if (isTwoPane) {
                    fragment.setArguments(bundle);
                    // フラグメントの操作かいし
                    manager.beginTransaction()
                            // フラグメントの置換、確定
                            .replace(R.id.dashboardfragment, fragment)
                            .commit();
                } else {
                    Intent intent = new Intent(getActivity(), DetailsActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
}

//    private HomeViewModel homeViewModel;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
//    }
