package com.example.emergencymessage.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.emergencymessage.R;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // レイアウトファイルを取得
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // クリックイベントリスナーを登録
        view.findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Navigation.findNavController(v).navigate(R.id.afterFragment);
                    /*
                    Bundle bundle = new Bundle();
                    bundle.putInt("num", (new Random()).nextInt(100));
                    Navigation.findNavController(v).navigate(R.id.afterFragment, bundle);
                    */
//                        HomeFragmentDirections.ActionBeforeFragmentToAfterFragment
//                                action = HomeFragmentDirections.actionBeforeFragmentToAfterFragment();
//                        action.setNum((new Random()).nextInt());
                        //Navigation.findNavControllerでナビゲーションを用いて画面を遷移するメソッドを取得する。
                        Navigation.findNavController(v).navigate(R.id.navigation_dashboard);
                    }
                }
        );
        return view;
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
}