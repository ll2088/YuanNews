package mapper.manager;

import cn.hpu.yuan.ssm.mapper.manager.CateManagerMapper;
import cn.hpu.yuan.ssm.model.vo.CateVo;
import common.MapperContanst;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by yuan on 16-4-1.
 * 分类信息管理 - 单元测试 实现
 */
public class CateManagerTest {

    private ApplicationContext context;
    private CateManagerMapper managerMapper;

    @Before
    public void setUp() throws Exception{
        context=new ClassPathXmlApplicationContext(MapperContanst.APPLIACTION_CONTEXT_LOCATION);
        managerMapper= (CateManagerMapper) context.getBean("cateManagerMapper");
    }

    /**
     * 通过id，查询分类信息
     */
    @Test
    public void findCateById(){
        CateVo cateById = managerMapper.findCateById(1);
        System.out.printf("分类测试结果 ： "+cateById);
    }


    /**
     * 查询所有的分类信息
     */
    @Test
    public void findCates(){
        List<CateVo> cates = managerMapper.findCates();
        System.out.printf("分类测试结果 ： "+cates.toString());
    }

    /**
     * 修改分类信息，没有的话 返回 0
     */
    @Test
    public void updateCate(){
        Integer result = managerMapper.updateCate(3, "笑话");
        System.out.printf("分类测试结果 ： "+result + (result>0?"成功":"失败"));
    }

    /**
     * 删除分类 ，直接删除 ，找不到 返回 0 ，删除成功为 1
     */
    @Test
    public void deleteCate(){
        Integer result = managerMapper.deleteCate(6);
        System.out.printf("分类测试结果 ： "+result + (result>0?"成功":"失败"));
    }

    /**
     * 添加分类信息
     */
    @Test
    public void insertCate(){
        Integer result = managerMapper.insertCate("我是测试专家");
        System.out.printf("分类测试结果 ： "+result + (result>0?"成功":"失败"));
    }






}
