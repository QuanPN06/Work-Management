package quanpnph29471.example.quanpnph29471_asm.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import quanpnph29471.example.quanpnph29471_asm.Adapter.TaskAdapter;
import quanpnph29471.example.quanpnph29471_asm.DAO.TaskDAO;
import quanpnph29471.example.quanpnph29471_asm.DAO.UserDAO;
import quanpnph29471.example.quanpnph29471_asm.Model.Task;
import quanpnph29471.example.quanpnph29471_asm.Model.User;
import quanpnph29471.example.quanpnph29471_asm.R;

public class FragThongKe_MoiTao extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_thong_ke,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("USERNAME", "");

        RecyclerView rc;
        TaskAdapter taskAdapter;
        TaskDAO taskDAO;
        UserDAO userDao = new UserDAO(getContext());
        ArrayList<Task> list = new ArrayList<>();
        TextView tv_title;


        rc = view.findViewById(R.id.rc_thongke);
        tv_title = view.findViewById(R.id.tv_title);
        tv_title.setText("MỚI TẠO");

        taskDAO = new TaskDAO(getContext());
        list = taskDAO.getListCreate(userDao.getUserId(username).getId());

        taskAdapter = new TaskAdapter(list,getContext());
        rc.setAdapter(taskAdapter);

    }
}
