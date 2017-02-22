package riberd.puzzle.app_mvp.contract;

import java.util.List;

import riberd.puzzle.app_mvp.model.TodoModel;

/**
 * Created by Riberd on 2017/02/23.
 */

public interface MainActivityContract {
    interface View {
        void showList(List<TodoModel> todoList);

        void showToast(String message);

        void showButton();

        void hideButton();
    }

    interface Action {
        void onTextChange(String text);

        void onResisterClick(String title);
    }
}
