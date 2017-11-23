package com.example.administrator.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserDao userDao = EntityManager.getInstance().getUserDao();
        //增
        User user1 = new User(null,"qqq");
        userDao.insert(user1);
//        //删
//        User findUser = userDao.queryBuilder().where(UserDao.Properties.Username.eq("zhangsan")).build().unique();
//        if(findUser != null){
//            userDao.deleteByKey(findUser.getId());
//        }
        //改
        User findUser = userDao.queryBuilder().where(UserDao.Properties.Username.eq("qqq")).build().unique();
        if(findUser != null) {
            findUser.setUsername("huang");
            userDao.update(findUser);
            Toast.makeText(MyApplication.getContext(), "修改成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MyApplication.getContext(), "用户不存在", Toast.LENGTH_SHORT).show();
        }

        //查
//        List<User> userList = userDao.queryBuilder()
//                .where(UserDao.Properties.Id.notEq(1))
//                .limit(5)
//                .build().list();
        QueryBuilder<User> qb = userDao.queryBuilder();
        List<User> list = qb.list();
        for (int i=0;i<list.size();i++){
            System.out.println("*****"+list.get(i).getUsername());
        }

    }
}
