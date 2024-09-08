package com.zou;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.io.IOException;
import java.util.*;

/**
 * @Author zoulinchuan
 * @Date 2024年09月08日 星期日 10:23
 * @description: ${description}
 */
public class Main {
    public static void main(String[] args) throws IOException {

        String url = "https://juejin.cn/post/7411435643291746355";

        Connection connect = Jsoup.connect(url);
        Document document = connect
            .timeout(
                Integer.MAX_VALUE
            )
            .get();

        // 获取id为juejin的元素
        Element element = document.getElementById("juejin");

        /*
         * 这种做法只能遍历两层，只能遍历到juejin标签下所有元素的子元素
         * 遍历层级3级
         */
        // 遍历所有span
        for (Node item : element.children()) {
            // 遍历span中的子标签
            for (Node childNode : item.childNodes()) {
                // 如果是文本标签则打印出来
                if(childNode instanceof TextNode){
                    System.out.println(childNode);
                }
            }
        }

        // 递归遍历
        // recursiveDFS(element);

        // 迭代遍历
        iterativeDFS(element);
    }


    private static void recursiveDFS(Node root) {
        if(root instanceof TextNode) {
            System.out.println(root);
            return;
        }

        for (Node childNode : root.childNodes()) {
            recursiveDFS(childNode);
        }
    }

    private static void iterativeDFS(Node root){
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currNode = stack.pop();
            if (currNode instanceof TextNode) {
                System.out.println(currNode);
                continue;
            }

            List<Node> childNodeList = new ArrayList<>(currNode.childNodes());
            Collections.reverse(childNodeList);

            for (Node node : childNodeList) {
                stack.push(node);
            }
        }
    }
}