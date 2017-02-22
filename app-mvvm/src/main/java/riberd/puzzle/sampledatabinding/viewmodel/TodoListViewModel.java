package riberd.puzzle.sampledatabinding.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import riberd.puzzle.sampledatabinding.contract.MainActivityContract;
import riberd.puzzle.sampledatabinding.model.TodoModel;

/**
 * Created by Riberd on 2017/02/22.
 */

public class TodoListViewModel {
    public ObservableField<String> todoTitle = new ObservableField<>();
    public ObservableBoolean isValidButton = new ObservableBoolean(false);
    private MainActivityContract view;
    private List<TodoModel> todoList = new ArrayList<>();

    public TodoListViewModel(MainActivityContract view) {
        this.view = view;
    }

    public void onResisterClick(View itemView) {
        String time = String.valueOf(DateFormat.format("yyyy/MM/dd kk:mm:ss", java.util.Calendar.getInstance()));
        TodoModel item = new TodoModel();
        item.setTitle(todoTitle.get());
        item.setTime(time);
        todoList.add(item);
        view.showList(todoList);
    }

    public TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (!editable.toString().isEmpty()) {
                isValidButton.set(true);
                todoTitle.set(editable.toString());
            } else {
                isValidButton.set(false);
            }
        }
    };
}
