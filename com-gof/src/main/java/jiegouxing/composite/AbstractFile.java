package jiegouxing.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象构建
 * Create by Administrator on 2018/12/19 0019
 */
public interface AbstractFile {
    void killVirus(); //杀毒
}

class ImageFile implements AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---图像文件:" + name + "进行查杀!");
    }
}

class TextFile implements AbstractFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---文本文件:" + name + "进行查杀!");
    }
}

class VideoFile implements AbstractFile {
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---视频文件:" + name + "进行查杀!");
    }
}

class Folder implements AbstractFile {
    private String name;
    //定义一个容器
    private List<AbstractFile> list = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile file) {
        list.add(file);
    }

    public void remove(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile getChile(int index) {
        return list.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("---文件夹：" + name + "，进行查杀!");
        for (AbstractFile abstractFile : list) {
            abstractFile.killVirus();
        }
    }
}