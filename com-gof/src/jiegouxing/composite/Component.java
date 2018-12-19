package jiegouxing.composite;

/**
 * 抽象组件
 * Create by Administrator on 2018/12/19 0019
 */
public interface Component {
    void operation();
}

//叶子组件
interface Leaf extends Component {
}

//容器组件
interface Composite extends Component {
    void add(Component c);

    void remove(Component c);

    Component getChild(int index);
}