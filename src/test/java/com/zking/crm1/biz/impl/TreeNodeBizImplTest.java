package com.zking.crm1.biz.impl;

import com.zking.crm1.biz.ITreeNodeBiz;
import com.zking.crm1.mapper.TreeNodeMapper;
import com.zking.crm1.model.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TreeNodeBizImplTest {
    @Autowired
    private ITreeNodeBiz treeNodeBiz;
    private TreeNode treeNode;
    @Before
    public void setUp() throws Exception {
        treeNode=new TreeNode();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void treeNodeList() throws Exception {

        List<TreeNode> treeNodeList = treeNodeBiz.treeNodeList(treeNode);
        for (TreeNode t:treeNodeList){
            System.out.println(t);
        }

    }

}