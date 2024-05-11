package com.oukelaile.vebAdmin.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TreeBuilderUtils {

    public static JSONArray buildTree(JSONArray jsonArray, String idKey, String parentIdKey) {
        Map<String, TreeItem<JSONObject>> nodeMap = new HashMap<>();
        List<TreeItem<JSONObject>> roots = new ArrayList<>();

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String itemId = jsonObject.getString(idKey);
            String parentId = jsonObject.getString(parentIdKey);

            TreeItem<JSONObject> currentNode = new TreeItem<>(jsonObject);
            nodeMap.put(itemId, currentNode);

            if (parentId == null || parentId.isEmpty() || !nodeMap.containsKey(parentId)) {
                roots.add(currentNode);
            } else {
                TreeItem<JSONObject> parentNode = nodeMap.get(parentId);
                if (parentNode != null) {
                    parentNode.addChild(currentNode);
                }
            }
        }

        return convertTreeToJSONArray(roots);
    }

    public static JSONArray convertTreeToJSONArray(List<TreeBuilderUtils.TreeItem<JSONObject>> treeItems) {
        JSONArray jsonArray = new JSONArray();
        for (TreeBuilderUtils.TreeItem<JSONObject> item : treeItems) {
            JSONObject treeNode = new JSONObject();
            treeNode.putAll(item.getData());

            // 递归处理子节点，无论当前节点是顶层节点还是子节点
            JSONArray childrenJsonArray = convertTreeToJSONArray(item.getChildren());
            if (!childrenJsonArray.isEmpty()) {
                treeNode.put("children", childrenJsonArray);
            }

            jsonArray.add(treeNode);
        }
        return jsonArray;
    }


    public static class TreeItem<T> {
        private T data;
        private List<TreeItem<T>> children;

        public TreeItem(T data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        public void addChild(TreeItem<T> child) {
            children.add(child);
        }

        public T getData() {
            return data;
        }

        public List<TreeItem<T>> getChildren() {
            return children;
        }
    }

}



