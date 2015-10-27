package com.mycompany.newsagregator;

import com.mycompany.newsagregator.Algorithms.Algorithm;
import java.util.ArrayList;

public class NewsConfig {

    private static ArrayList<String> folders = new ArrayList<String>();
    private static ArrayList<String> links = new ArrayList<String>();
    private static Algorithm algorithm;
    private static Integer size = 10;

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }

    public  ArrayList<String> getFolders() {
        return folders;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    public void setFolders(ArrayList<String> folders) {
        this.folders = folders;
    }

    public void setLink(ArrayList<String> links) {
        this.links = links;
    }
    public void addFolder(String folder) {
        this.folders.add(folder);
    }
    public void addLink(String link) {
        this.links.add(link);
    }
}
