package riberd.puzzle.sampledatabinding.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import riberd.puzzle.sampledatabinding.R;
import riberd.puzzle.sampledatabinding.contract.MainActivityContract;
import riberd.puzzle.sampledatabinding.databinding.ItemTodoBinding;
import riberd.puzzle.sampledatabinding.model.TodoModel;
import riberd.puzzle.sampledatabinding.viewmodel.TodoItemViewModel;

/**
 * Created by Riberd on 2017/02/22.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.BindingViewHolder> {
    private Context context;
    private MainActivityContract view;
    private List<TodoModel> todoList;

    public RecyclerViewAdapter(Context context, MainActivityContract view) {
        this.context = context;
        this.view = view;
    }

    public void setItemAndRefresh(List<TodoModel> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemTodoBinding itemTodoBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_todo, parent, false);
        itemTodoBinding.setViewModel(new TodoItemViewModel(view));
        return new BindingViewHolder(itemTodoBinding.getRoot(), itemTodoBinding.getViewModel());
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        holder.loadItem(todoList.get(position));
    }

    @Override
    public int getItemCount() {
        if (todoList == null) {
            return 0;
        }
        return todoList.size();
    }

    static class BindingViewHolder extends RecyclerView.ViewHolder {
        private final TodoItemViewModel viewModel;

        public BindingViewHolder(View itemView, TodoItemViewModel viewModel) {
            super(itemView);
            this.viewModel = viewModel;
        }

        public void loadItem(TodoModel todoModel) {
            viewModel.setTodo(todoModel);
        }
    }
}
