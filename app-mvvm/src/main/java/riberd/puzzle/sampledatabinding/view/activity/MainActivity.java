package riberd.puzzle.sampledatabinding.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import java.util.List;

import riberd.puzzle.sampledatabinding.R;
import riberd.puzzle.sampledatabinding.contract.MainActivityContract;
import riberd.puzzle.sampledatabinding.databinding.ActivityMainBinding;
import riberd.puzzle.sampledatabinding.model.TodoModel;
import riberd.puzzle.sampledatabinding.view.adapter.RecyclerViewAdapter;
import riberd.puzzle.sampledatabinding.viewmodel.TodoListViewModel;

/**
 * Created by Riberd on 2017/02/22.
 */

public class MainActivity extends AppCompatActivity implements MainActivityContract {
    private ActivityMainBinding activityMainBinding;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new TodoListViewModel(this));

        setupViews();
    }

    private void setupViews() {
        activityMainBinding.todoRecyclerview.setHasFixedSize(false);
        activityMainBinding.todoRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, this);
        activityMainBinding.todoRecyclerview.setAdapter(adapter);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showList(List<TodoModel> todoModelList) {
        adapter.setItemAndRefresh(todoModelList);
    }
}
