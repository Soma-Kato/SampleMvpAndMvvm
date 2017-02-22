package riberd.puzzle.app_mvp.presenter;

import android.text.format.DateFormat;

import java.util.ArrayList;
import java.util.List;

import riberd.puzzle.app_mvp.contract.MainActivityContract;
import riberd.puzzle.app_mvp.model.TodoModel;

/**
 * Created by Riberd on 2017/02/23.
 */

public class MainActivityPresenter implements MainActivityContract.Action {
    private MainActivityContract.View contractView;
    private List<TodoModel> todoList = new ArrayList<>();

    public MainActivityPresenter(MainActivityContract.View contractView) {
        this.contractView = contractView;
    }

    @Override
    public void onTextChange(String text) {
        if (text.isEmpty()) {
            contractView.hideButton();
        } else {
            contractView.showButton();
        }
    }

    @Override
    public void onResisterClick(String title) {
        String time = String.valueOf(DateFormat.format("yyyy/MM/dd kk:mm:ss", java.util.Calendar.getInstance()));
        TodoModel model = new TodoModel();
        model.setTitle(title);
        model.setTime(time);
        todoList.add(model);
        contractView.showList(todoList);
    }
}
