package sourcebrain.com.sscfans.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

import sourcebrain.com.sscfans.R;
import sourcebrain.com.sscfans.model.Fixture;


public class FixturesAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<Fixture> mArrayFixtures;

    public FixturesAdapter(Context context, ArrayList<Fixture> fixtures) {
        mContext = context;
        mArrayFixtures = fixtures;
    }

    @Override
    public int getCount() {
        return mArrayFixtures.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayFixtures.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        FixtureViewHolder holder;

        if(view == null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            view = inflater.inflate(R.layout.row_fixture, parent, false);

            holder = new FixtureViewHolder();
            holder.mTxtMatchId = (TextView) view.findViewById(R.id.txtMatchId);
            holder.mImgTeam1 = (ImageView) view.findViewById(R.id.imgTeam1);
            holder.mTxtTeam1 = (TextView) view.findViewById(R.id.txtTeam1);
            holder.mImgTeam2 = (ImageView) view.findViewById(R.id.imgTeam2);
            holder.mTxtTeam2 = (TextView) view.findViewById(R.id.txtTeam2);
            holder.mTxtDateTime = (TextView) view.findViewById(R.id.txtDateTime);
            holder.mTxtVenue = (TextView) view.findViewById(R.id.txtVenue);
            holder.mImgTeam1 = (ImageView) view.findViewById(R.id.imgTeam1);
            holder.mImgTeam2 = (ImageView) view.findViewById(R.id.imgTeam2);


            view.setTag(holder);
        } else {
            holder = (FixtureViewHolder) view.getTag();
        }
        holder.mTxtMatchId.setText("Match " + mArrayFixtures.get(position).getMatchID());
        holder.mTxtTeam1.setText(mArrayFixtures.get(position).getTeam1());
        holder.mTxtTeam2.setText(mArrayFixtures.get(position).getTeam2());

        switch (mArrayFixtures.get(position).getTeam1()) {
            case "India":
                holder.mImgTeam1.setImageResource(R.drawable.ic_launcher);
                break;
            case "Maldives":
                holder.mImgTeam1.setImageResource(R.drawable.ic_launcher);
                break;
            case "Nepal":
                holder.mImgTeam1.setImageResource(R.drawable.ic_launcher);
                break;
            case "Bhutan":
                holder.mImgTeam1.setImageResource(R.drawable.ic_launcher);
                break;
            case "Bangladesh":
                holder.mImgTeam1.setImageResource(R.drawable.ic_launcher);
                break;
            case "Afghanistan":
                holder.mImgTeam1.setImageResource(R.drawable.ic_launcher);
                break;
            case "Sri Lanka":
                holder.mImgTeam1.setImageResource(R.drawable.ic_launcher);
                break;
            default:
                holder.mImgTeam1.setImageResource(R.drawable.ic_launcher);
                break;
        }
        switch (mArrayFixtures.get(position).getTeam2()) {
            case "India":
                holder.mImgTeam2.setImageResource(R.drawable.ic_launcher);
                break;
            case "Maldives":
                holder.mImgTeam2.setImageResource(R.drawable.ic_launcher);
                break;
            case "Nepal":
                holder.mImgTeam2.setImageResource(R.drawable.ic_launcher);
                break;
            case "Bhutan":
                holder.mImgTeam2.setImageResource(R.drawable.ic_launcher);
                break;
            case "Bangladesh":
                holder.mImgTeam2.setImageResource(R.drawable.ic_launcher);
                break;
            case "Afghanistan":
                holder.mImgTeam2.setImageResource(R.drawable.ic_launcher);
                break;
            case "Sri Lanka":
                holder.mImgTeam2.setImageResource(R.drawable.ic_launcher);
                break;
            default:
                holder.mImgTeam2.setImageResource(R.drawable.ic_launcher);
                break;
        }


        holder.mTxtDateTime.setText(mArrayFixtures.get(position).getDate() + ", "
                                        + mArrayFixtures.get(position).getTime());
        holder.mTxtVenue.setText(mArrayFixtures.get(position).getVenue());

        return view;
    }

    static class FixtureViewHolder{
        TextView mTxtMatchId;
        ImageView mImgTeam1;
        TextView mTxtTeam1;
        ImageView mImgTeam2;
        TextView mTxtTeam2;
        TextView mTxtDateTime;
        TextView mTxtVenue;
    }
}
