package com.zking.crm1.controller;

import com.zking.crm1.biz.ITreeNodeBiz;
import com.zking.crm1.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TreeNodeController {
    @Autowired
    private ITreeNodeBiz treeNodeBiz;

    @RequestMapping("doTReeNodeList")
    public List<Map<String, Object>> doTReeNodeList(TreeNode treeNode, String forward, HttpServletRequest request) {
        List<TreeNode> treeNodeList = treeNodeBiz.treeNodeList(treeNode);

        List<Map<String, Object>> treeNodes = new ArrayList<Map<String, Object>>();
        Map<String, Object> m = null;
        Map<String, Object> attributes = null;
        for (TreeNode t : treeNodeList) {
            m = new HashMap<String, Object>();
            // 节点内置属性
            m.put("id", t.getTreeNodeId());
            m.put("text", t.getTreeNodeName());
            m.put("state", t.getLenf() ? "open" : "closed");
            // 添加节点自定义属性
            attributes = new HashMap<String, Object>();
            attributes.put("url", t.getUrl());
            m.put("attributes", attributes);

            treeNodes.add(m);
        }
        if ("null".equals(forward)) {
         request.setAttribute("treeNodes", treeNodes);
        }
        return treeNodes;
    }
}
