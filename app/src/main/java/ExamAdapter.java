import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.project.semicolon.eduactive.R;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ViewHolder> {
    @NonNull
    @Override
    public ExamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.exam, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExamAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView imageView;
        public TextView titleView,levelView1,yearView2,instView3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.Examcard);
            imageView=itemView.findViewById(R.id.Examdown);
            titleView=itemView.findViewById(R.id.Examtitle);
            levelView1=itemView.findViewById(R.id.Examlevel);
            yearView2=itemView.findViewById(R.id.Examyear);
            instView3=itemView.findViewById(R.id.Examinst);
        }
    }
}
