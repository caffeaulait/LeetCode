package com.caffeaulait.problemset;

import java.util.*;

public class _0588_Design_In_Memory_File_System {
    /**
     * Design an in-memory file system to simulate the following functions:
     *
     * ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.
     *
     * mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.
     *
     * addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.
     *
     * readContentFromFile: Given a file path, return its content in string format.
     *
     * 输入:
     * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
     * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
     *
     * 输出:
     * [null,[],null,null,["a"],"hello"]
     */

    public static void main(String[] args) {
        _0588_Design_In_Memory_File_System fileSystem = new _0588_Design_In_Memory_File_System();
        System.out.println(fileSystem.ls("/"));
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        System.out.println(fileSystem.ls("/"));
        System.out.println(fileSystem.readContentToFile("/a/b/c/d"));
    }
    class Node {
        String name;
        boolean flag;
        String content;

        Map<String, Node> children;

        public Node(String name, boolean flag, String content, Map<String, Node> children) {
            this.name = name;
            this.flag = flag;
            this.content = content;
            this.children = children;
        }

        public Node(String name, boolean flag, String content) {
            this(name, flag, content, new HashMap<>());
        }

        public Node(String name, boolean flag) {
            this(name, flag, "");
        }
    }

    private Node root;

    public _0588_Design_In_Memory_File_System() {
        root = new Node("", false);
    }

    public List<String> ls(String path) {
        Node curr = root;
        if(path.length() > 1) {
            String[] parts = path.split("/");
            parts = Arrays.copyOfRange(parts, 1, parts.length);
            for(String p : parts) {
                curr = curr.children.get(p);
            }
        }
        if(curr.flag) {
            return Collections.singletonList(curr.name);
        } else {
            List<String> children = new ArrayList<>(curr.children.keySet());
            Collections.sort(children);
            return children;
        }
    }

    public void mkdir(String path) {
        Node curr = root;
        String[] parts = path.split("/");
        parts = Arrays.copyOfRange(parts, 1, parts.length);
        for(String p : parts) {
            if(!curr.children.containsKey(p)) {
                curr.children.put(p, new Node(p, false));
            }
            curr = curr.children.get(p);
        }
    }

    public void addContentToFile(String path, String content) {
        Node curr = root;
        String[] parts = path.split("/");
        parts = Arrays.copyOfRange(parts, 1, parts.length-1);
        for(String p : parts) {
            curr = curr.children.get(p);
        }
        String lastPart = parts[parts.length-1];
        if(!curr.children.containsKey(lastPart)) {
            curr.children.put(lastPart, new Node(lastPart, true));
        }
        curr.children.get(lastPart).content += content;
    }

    public String readContentToFile(String path) {
        Node curr = root;
        String[] parts = path.split("/");
        parts = Arrays.copyOfRange(parts, 1, parts.length);
        for(String p : parts) {
            curr = curr.children.get(p);
        }
        return curr.content;
    }
}
