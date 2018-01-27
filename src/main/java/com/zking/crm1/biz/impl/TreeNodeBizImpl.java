package com.zking.crm1.biz.impl;

import com.zking.crm1.biz.ITreeNodeBiz;
import com.zking.crm1.mapper.TreeNodeMapper;
import com.zking.crm1.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeNodeBizImpl implements ITreeNodeBiz {
    @Autowired
    private TreeNodeMapper treeNodeMapper;
    @Override
    public List<TreeNode> treeNodeList(TreeNode treeNode) {
        return treeNodeMapper.treeNodeList(treeNode);
    }
}
