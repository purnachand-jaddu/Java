package com.mentor.training;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class TreeWithNodes {
    public static JTree getTree()
    {
        JTree tree=new JTree(getModel());
        tree.setSize(600,600);
        tree.setVisible(true);
        return tree;
    }

    private static DefaultTreeModel getModel() {
        DefaultTreeModel model=new DefaultTreeModel(getRoot());
        return model;
    }

    private static TreeNode getRoot() {
        return new TreeNode() {
            @Override
            public TreeNode getChildAt(int childIndex) {
                return null;
            }

            @Override
            public int getChildCount() {
                return 0;
            }

            @Override
            public TreeNode getParent() {
                return null;
            }

            @Override
            public int getIndex(TreeNode node) {
                return 0;
            }

            @Override
            public boolean getAllowsChildren() {
                return true;
            }

            @Override
            public boolean isLeaf() {
                return false;
            }

            @Override
            public Enumeration children() {
                return null;
            }
        };
    }

}
