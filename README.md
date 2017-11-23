# Greendao
### greenDao是一个将对象映射到SQLite数据库中的轻量且快速的ORM解决方案。关于greenDAO的概念可以看官网

### 本demo进行了简单的封装可以直接拿来用，greendao简单的增，删，改，查
## greenDAO 优势
- 一个精简的库
- 性能最大化
- 内存开销最小化
- 易于使用的 APIs
- 对 Android 进行高度优化
## 引入greenDAO
```
dependencies {  
    classpath 'com.android.tools.build:gradle:2.1.0'  
    classpath 'org.greenrobot:greendao-gradle-plugin:3.1.0'  
  
    // NOTE: Do not place your application dependencies here; they belong  
    // in the individual module build.gradle files  
}  
```
### 然后在module的gradle文件中添加greenDAO的插件，并引入相关类库，修改之后如下：
```
apply plugin: 'com.android.application'  
apply plugin: 'org.greenrobot.greendao'  
  
android {  
    ...  
    ...  
  
    greendao{  
        schemaVersion 1  
        targetGenDir 'src/main/java'  
    }  
}  
  
dependencies {  
    ...  
    ...  
  
    compile 'org.greenrobot:greendao:3.1.0'  
}  
```

### 数据库初始化
```
@Entity  
public class User {  
    @Id  
    private Long id;  
    @Property(nameInDb = "USERNAME")  
    private String username;  
    @Property(nameInDb = "NICKNAME")  
    private String nickname;  
} 
###
```
DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "lenve.db", null);  
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());  
        DaoSession daoSession = daoMaster.newSession(); 
        userDao = daoSession.getUserDao();  
//有了这些基础，可以自己再封装，便于开发
```
