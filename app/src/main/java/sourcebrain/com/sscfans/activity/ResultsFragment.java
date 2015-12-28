package sourcebrain.com.sscfans.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;



import java.util.ArrayList;

import sourcebrain.com.sscfans.R;
import sourcebrain.com.sscfans.adapter.ResultsAdapter;
import sourcebrain.com.sscfans.model.Result;


public class ResultsFragment extends Fragment {

    public ResultsFragment() {
        // Required empty public constructor
    }

    ListView mListResults;
    Spinner mSpinnerTeams;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        System.out.println("onCreate");
       //
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_results, container, false);

        mListResults = (ListView) rootView.findViewById(R.id.listResults);
        mListResults.setAdapter(new ResultsAdapter(getActivity(), SSCHomeActivity.mArrayResults));

        mSpinnerTeams = (Spinner) rootView.findViewById(R.id.spinnerTeams);

        mSpinnerTeams.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    mListResults.setAdapter(new ResultsAdapter(getActivity(), SSCHomeActivity.mArrayResults));
                } else {
                    filterFixtures(mSpinnerTeams.getSelectedItem().toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Inflate the layout for this fragment
        return rootView;
    }

    void filterFixtures(String teamselected) {
        ArrayList<Result> filteredList = new ArrayList<Result>();
        filteredList.clear();
        for(int i = 0; i < SSCHomeActivity.mArrayResults.size(); i++) {
            if(SSCHomeActivity.mArrayResults.get(i).getTeam1().contains(teamselected)
                    || SSCHomeActivity.mArrayResults.get(i).getTeam2().contains(teamselected)) {
                filteredList.add(SSCHomeActivity.mArrayResults.get(i));
            }
        }
        mListResults.setAdapter(new ResultsAdapter(getActivity(), filteredList));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        System.out.println("onAttach");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("onDetach");
    }

}
