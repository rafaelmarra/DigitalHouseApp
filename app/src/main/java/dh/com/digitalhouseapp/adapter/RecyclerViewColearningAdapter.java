package dh.com.digitalhouseapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dh.com.digitalhouseapp.R;
import dh.com.digitalhouseapp.model.Colearn;

public class RecyclerViewColearningAdapter extends RecyclerView.Adapter<RecyclerViewColearningAdapter.ViewHolder> {

    private List<Colearn> colearnList;

    public RecyclerViewColearningAdapter(List<Colearn> colearnList) {
        this.colearnList = colearnList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_colearning_item, parent, false);

        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Colearn colearn = colearnList.get(position);
        viewHolder.bind(colearn);
    }

    @Override
    public int getItemCount() {
        return colearnList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView job;
        private TextView days;
        private TextView hours;
        private ImageView photo;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.colearning_item_name_id);
            job = itemView.findViewById(R.id.colearning_item_job_id);
            days = itemView.findViewById(R.id.colearning_item_days_id);
            hours = itemView.findViewById(R.id.colearning_item_hours_id);
            photo = itemView.findViewById(R.id.colearning_item_photo_id);

        }

        public void bind(final Colearn colearn) {
            name.setText(colearn.getName());
            job.setText(colearn.getJob());
            days.setText(colearn.getDays());
            hours.setText(colearn.getHours());
            Picasso.get().load(colearn.getImageUrl()).into(photo);

        }


    }
}
