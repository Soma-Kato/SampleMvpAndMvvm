package riberd.puzzle.app_mvp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import riberd.puzzle.app_mvp.contract.MainActivityContract;
import riberd.puzzle.app_mvp.R;
import riberd.puzzle.app_mvp.model.TodoModel;

/**
 * Created by Riberd on 2017/02/23.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private MainActivityContract.View itemView;
    private List<TodoModel> todoList;

    public RecyclerViewAdapter(Context context, MainActivityContract.View itemView) {
        this.context = context;
        this.itemView = itemView;
    }

    public void setItemAndRefresh(List<TodoModel> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        TodoModel item = todoList.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.timeTextView.setText(item.getTime());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = todoList.get(holder.getAdapterPosition()).getTitle();
                itemView.showToast(title);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (todoList == null) {
            return 0;
        }
        return todoList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final LinearLayout linearLayout;
        final TextView titleTextView;
        final TextView timeTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
            titleTextView = (TextView) itemView.findViewById(R.id.todo_text_view);
            timeTextView = (TextView) itemView.findViewById(R.id.time_text_view);
        }
    }
}
