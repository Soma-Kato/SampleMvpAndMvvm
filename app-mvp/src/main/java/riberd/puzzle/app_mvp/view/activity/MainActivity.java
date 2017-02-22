package riberd.puzzle.app_mvp.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import riberd.puzzle.app_mvp.contract.MainActivityContract;
import riberd.puzzle.app_mvp.presenter.MainActivityPresenter;
import riberd.puzzle.app_mvp.R;
import riberd.puzzle.app_mvp.view.adapter.RecyclerViewAdapter;
import riberd.puzzle.app_mvp.model.TodoModel;

/**
 * Created by Riberd on 2017/02/23.
 */

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    private MainActivityPresenter presenter;
    private Button button;
    private EditText editText;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);
        setupViews();
    }

    private void setupViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.todo_recyclerview);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, this);
        recyclerView.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.edit_text);
        editText.addTextChangedListener(watcher);
        button = (Button) findViewById(R.id.resistor_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onResisterClick(editText.getText().toString());
            }
        });
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            presenter.onTextChange(editable.toString());
        }
    };

    @Override
    public void showList(List<TodoModel> todoList) {
        adapter.setItemAndRefresh(todoList);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showButton() {
        button.setEnabled(true);
    }

    @Override
    public void hideButton() {
        button.setEnabled(false);
    }
}
