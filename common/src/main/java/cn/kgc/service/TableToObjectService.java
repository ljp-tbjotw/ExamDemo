package cn.kgc.service;

import cn.kgc.vo.TableToObject;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/3/20 0020.
 */
@Service
public interface TableToObjectService {
	//一方集合
	List<TableToObject> findOneList();

	//根据两条条件查询对象
	TableToObject findByCondition(TableToObject tableToObject);

	//根据各种条件联查返回对象两个表或某个表的集合
	List<TableToObject> findByConditonList(TableToObject tableToObject);

	//添加对象
	int addObject(TableToObject tableToObject);

	//编辑对象
	int editObject(TableToObject tableToObject);

	//删除对象
	int deleteObject(Integer primaryKey);

	//分页查询
	PageInfo findPage(Integer pageno, Integer pagesize, TableToObject tableToObject);
}
