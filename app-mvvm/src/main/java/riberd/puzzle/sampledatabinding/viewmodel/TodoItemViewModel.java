package riberd.puzzle.sampledatabinding.viewmodel;

import android.databinding.ObservableField;
import android.view.View;

import riberd.puzzle.sampledatabinding.contract.MainActivityContract;
import riberd.puzzle.sampledatabinding.model.TodoModel;

/**
 * Created by Riberd on 2017/02/22.
 */

public class TodoItemViewModel {
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> time = new ObservableField<>();
    private MainActivityContract view;
    private String itemTitle;

    public TodoItemViewModel(MainActivityContract view) {
        this.view = view;
    }

    public void setTodo(TodoModel todo) {
        itemTitle = todo.getTitle();
        title.set(todo.getTitle());
        time.set(todo.getTime());
    }

    public void onItemClick(View itemView) {
        view.showToast(itemTitle);
    }
}
