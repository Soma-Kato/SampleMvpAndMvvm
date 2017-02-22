package riberd.puzzle.sampledatabinding.contract;

import java.util.List;

import riberd.puzzle.sampledatabinding.model.TodoModel;

/**
 * Created by Riberd on 2017/02/22.
 */

public interface MainActivityContract {
    void showToast(String message);

    void showList(List<TodoModel> todoModelList);
}
