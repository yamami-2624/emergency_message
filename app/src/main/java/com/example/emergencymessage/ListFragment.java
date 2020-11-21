package com.example.emergencymessage;
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

public class ListFragment extends Fragment {
    // スマホ版とpc版で表示のさせ方を分岐させている。
    private boolean isTwoPane = false;


    @Override
    // フラグメントの親であるactivity_mainが起動した時に呼び出される。
    // Bundle　　画面の破棄、再生成の役割を果す。
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AppCompatActivity activity = Objects.requireNonNull(getActivity());
        if(activity.findViewById(R.id.detailsFrame) != null) {
            isTwoPane = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AppCompatActivity activity = Objects.requireNonNull(getActivity());
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                activity, android.R.layout.simple_list_item_1,
                ListDataSource.getAllNames());
        ListView list = view.findViewById(R.id.list);
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
                DetailsFragment fragment = new DetailsFragment();
                //bundleに新しい値を設定、
                Bundle bundle = new Bundle();
                // クリックされたスパイスの名前をBundleに代入、nameという名前で登録
                bundle.putString("name", (String) parent.getItemAtPosition(i));
                if (isTwoPane) {
                    fragment.setArguments(bundle);
                    // フラグメントの操作かいし
                    manager.beginTransaction()
                            // フラグメントの置換、確定
                            .replace(R.id.detailsFrame, fragment)
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
