package cn.kgc.mapper;

import cn.kgc.vo.TableToObject;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2019/3/20 0020.
 */
@Repository
public interface TableToObjectMapper {
	  //查询一方集合
	          @Select("select * from classes")
	          List<TableToObject> findOneList();

	//根据两条条件查询对象
	@Select("<script>" +
			"select s.*,c.cname from classes c,student s where c.cid=s.cid" +
			"<if test='sid!=null'>" +
			" and s.sid=#{sid}" +
			"</if>" +
			"<if test='sname!=null and password!=null'>" +
			"    and s.sname=#{sname} and s.password=#{password}" +
			"</if>" +
			"</script>")
	default TableToObject findByCondition(TableToObject tableToObject) {
		return null;
	}

	//根据各种条件联查返回对象两个表或某个表的集合
	                  @Select("<script>" +
	                          "select s.*,c.cname from classes c,student s where c.cid=s.cid" +
	                          "<if test='cid!=null and cid!=-1'>" +
	                          "    and s.cid=#{cid}" +
	                          "</if>" +
	                          "</script>")
					  List<TableToObject> findByConditonList(TableToObject tableToObject);
	                  //添加对象
	                  @Insert("insert into student(sname,password,subject,cid) values(#{sname},#{password},#{subject},#{cid})")
	                  int addObject(TableToObject tableToObject);
	                  //编辑对象
	                   @Update("update student set sname=#{sname},password=#{password},subject=#{subject},cid=#{cid} where sid=#{sid}")
	                  int editObject(TableToObject tableToObject);
	                  //删除对象
	                   @Delete("delete from student where sid=#{sid}")
	                  int deleteObject(Integer primaryKey);


}
