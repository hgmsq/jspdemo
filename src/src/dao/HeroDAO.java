package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Hero;

public class HeroDAO {
    public HeroDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root",
                "123456");
    }

    /*
    * @Description: 获取总数
    []
    * @return int
    * @author xcc
    * @date 2019/8/6 11:33
    */
    public int GetTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
            String sql = "select count(id) from hero ";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("total:" + total);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    /*
    * @Description: TODO
    [hero]
    * @return void
    * @author xcc
    * @date 2019/8/6 11:42 
    */
    public void AddHero(Hero hero) {
        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    * @Description: TODO
    [hero]
    * @return void
    * @author xcc
    * @date 2019/8/6 11:42 
    */
    public  void UpdateHero(Hero hero){
        String sql=" update hero set name= ?, hp = ? , damage = ? where id = ? ";
        try (Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
            ps.setString(1, hero.name);
            ps.setFloat(2, hero.hp);
            ps.setInt(3, hero.damage);
            ps.setInt(4,hero.id);
            ps.execute();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    /*
    * @Description: 根据id删除记录
    [id]
    * @return void
    * @author xcc
    * @date 2019/8/6 11:45
    */
    public  void DeleteHero(int id){
        String sql=" delete from hero  where id = ? ";
        try (Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1, id);
            ps.execute();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    /*
    * @Description: 根据id获取实体
    [id]
    * @return bean.Hero
    * @author xcc
    * @date 2019/8/6 11:52
    */
    public Hero GetHeroById(int id)
    {
        Hero hero=null;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from hero where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return hero;
    }
    public List<Hero> List(){
        return list(0, Short.MAX_VALUE);
    }
    public List<Hero> list(int start, int count) {
        List<Hero> heros = new ArrayList<>();

        String sql = "select * from hero order by id asc limit ?,? ";

        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.id = id;
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                heros.add(hero);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return heros;
    }
}
