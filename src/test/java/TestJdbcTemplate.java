import com.java.entity.User;
import com.java.service.AccountService;
import com.java.service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestJdbcTemplate {

    @Test
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = (JdbcTemplate) app.getBean("jdbcTemplate");
        template.execute("update test_user set name='张哈1' where id=1");
    }
    @Test
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = (JdbcTemplate) app.getBean("jdbcTemplate");
        template.update("insert into test_user(id,name) values(2,'王五')");
    }
    @Test
    public void test3(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = (JdbcTemplate) app.getBean("jdbcTemplate");
        template.update("insert into test_user(id,name) values(?,?)",3,"海留");
    }
    @Test
    public void test4(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = (JdbcTemplate) app.getBean("jdbcTemplate");
        User user = (User) template.queryForObject("select * from test_user where id=1", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                return user;
            }
        });
        System.out.println("id:"+user.getId()+"   name:"+user.getName());
    }
    @Test
    public void test5(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = (JdbcTemplate) app.getBean("jdbcTemplate");
        List<User> users = template.query("select * from test_user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                return user;
            }
        });
        for (User user : users) {
            System.out.println("id:"+user.getId()+"   name:"+user.getName());
        }
    }
    @Test
    public void test6(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = (JdbcTemplate) app.getBean("jdbcTemplate");
        List<User> users = template.query("select * from test_user",new BeanPropertyRowMapper<>(User.class));
        for (User user : users) {
            System.out.println("id:"+user.getId()+"   name:"+user.getName());
        }
    }

    @Test
    public void test7(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = (JdbcTemplate) app.getBean("jdbcTemplate");
        List<User> users = template.query("select * from test_user",new BeanPropertyRowMapper<>(User.class));
        for (User user : users) {
            System.out.println("id:"+user.getId()+"   name:"+user.getName());
        }
    }

    @Test
    public void test8(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService as = (AccountServiceImpl) app.getBean("as");
        as.account("tom","marry",500.00);
    }

    @Test
    public void test9(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService as = (AccountService) app.getBean("as");
        as.account("tom","marry",500.00);
    }
}
