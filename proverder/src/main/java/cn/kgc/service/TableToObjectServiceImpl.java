package cn.kgc.service;

import cn.kgc.mapper.TableToObjectMapper;
import cn.kgc.vo.TableToObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/3/20 0020.
 */
@Service
@Transactional
public class TableToObjectServiceImpl implements TableToObjectService{
	@Autowired
	    private TableToObjectMapper tableToObjectMapper;

	    @Override
	    public List<TableToObject> findOneList() {
	        return tableToObjectMapper.findOneList();
	    }

	    @Override
	    public TableToObject findByCondition(TableToObject tableToObject) {
	        return tableToObjectMapper.findByCondition(tableToObject);
	    }

	    @Override
	    public List<TableToObject> findByConditonList(TableToObject tableToObject) {
	        return tableToObjectMapper.findByConditonList(tableToObject);
	    }

	    @Override
	    public int addObject(TableToObject tableToObject) {
	        return tableToObjectMapper.addObject(tableToObject);
	    }

	    @Override
	    public int editObject(TableToObject tableToObject) {
	        return tableToObjectMapper.editObject(tableToObject);
	    }

	    @Override
	    public int deleteObject(Integer primaryKey) {
	        return tableToObjectMapper.deleteObject(primaryKey);
	    }

	    @Override
	    public PageInfo findPage(Integer pageno, Integer pagesize, TableToObject tableToObject) {
	        Page pageData= PageHelper.startPage(pageno,pagesize);
	        tableToObjectMapper.findByConditonList(tableToObject);
	        return new PageInfo(pageData);
	    }
}
