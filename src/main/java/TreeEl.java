import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeEl implements MyTree {
    private TreeEl firstNode;
    private TreeEl left;
    private TreeEl right;
    private int value;

    public TreeEl(int el) {
        this.value = el;
    }

    public TreeEl() {

    }

    @Override
    public TreeEl balanceTree() {
        Queue<TreeEl> queue = new LinkedList<>();
        TreeEl fixedTree = new TreeEl();
        queue.add(firstNode);
        while (!queue.isEmpty()) {
            TreeEl root = queue.remove();
            fixedTree.add(root.value);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        firstNode = fixedTree.firstNode;
        return fixedTree;
    }

    @Override
    public void print() {
        // обход листа в ширину

        Queue<TreeEl> queue = new LinkedList<>();
        // берем первый элемент
        // записываем в двустороннюю очередь (в конец)
        queue.add(firstNode);

        // пока очередь не пустая
        while (!queue.isEmpty()) {
            // вынимаем из очереди (с начала)
            TreeEl root = queue.remove();
            int valueForPrint = root.value;
            System.out.println(valueForPrint);

            // берем левую и правую ноду элемента - кладем в очередь (в конец)
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }

    @Override
    public void add(int el) {
        TreeEl nodeNew = new TreeEl(el);
        if (firstNode == null) {
            firstNode = nodeNew;
        }
        TreeEl target = findParentNode(el);
        if (target.value > nodeNew.value) {
            target.left = nodeNew;
        }
        if (target.value < nodeNew.value) {
            target.right = nodeNew;
        }
    }

    private TreeEl findParentNode(int el) {
        TreeEl compare = firstNode;
        while (compare != null) {
            // если значение больше значения в сравниваемой ноде, то
            if (el > compare.value) {
                // идем вправо (к ноде, записанно справа от сравниваемой)
                // теперь эта нода - сравниваемая, и возвращаемся к началу вайла
                if (compare.right != null) {
                    compare = compare.right;
                } else {
                    return compare;
                }
            }
            if (el < compare.value) {
                // идем влево
                // если левая нода от сравниваемой не равна нулю, то
                if (compare.left != null) {
                    // теперь она является сравниваемой
                    compare = compare.left;
                } else {
                    // если равна, то возвращаем найденную родительскую ноду
                    return compare;
                }
            }
            if (el == compare.value) {
                return compare;
            }
        }
        return compare;
    }

    public int [] getStructureTree (){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeEl> queue = new LinkedList<>();
        queue.add(firstNode);

        while (!queue.isEmpty()) {
            TreeEl root = queue.remove();
            int valueOfRootNode = root.value;
            result.add(valueOfRootNode);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }

        int [] arr = result.stream().mapToInt(i -> i).toArray();

        return arr;
    }

    public void setFirstNode(TreeEl firstNode) {
        this.firstNode = firstNode;
    }

    public void setLeft(TreeEl left) {
        this.left = left;
    }

    public void setRight(TreeEl right) {
        this.right = right;
    }
}

