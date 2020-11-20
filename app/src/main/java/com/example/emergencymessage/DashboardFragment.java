package com.example.emergencymessage;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Fragment;
import java.util.Map;
import java.util.Objects;

public class DashboardFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_fragment, container, false);
//        表示をパソコンとスマートホンで分岐させる表示
//        if(isTwoPane) {
//            bundle = Objects.requireNonNull(getArguments());
//        } else {
//            Intent intent = activity.getIntent();
//            bundle = Objects.requireNonNull(intent.getExtras());
//        }
//      HomeFragmentフラグメントから渡された値を取得
        bundle = Objects.requireNonNull(getActivity());
//      渡された名前をキーにスパイスの詳細情報を取得
        Map<String, String> item = ListDataSource.getInfoByName(
                bundle.getString("name"));
//      渡された値をTextViewにセット
        ((TextView)view.findViewById(R.id.name)).setText(String.format(
                "%s（%s）",bundle.getString("name"), item.get("alias")));
        ((TextView) view.findViewById(R.id.info)).setText(item.get("info"));
        return view;
    }
}

