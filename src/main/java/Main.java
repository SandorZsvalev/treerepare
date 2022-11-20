import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        TreeEl wrongTree = makeTree(new int [] {13,5,8,1,30});
        TreeEl correctTree = makeTree(new int [] {13,5,30,1,8});

        wrongTree.print();
        System.out.println();

        wrongTree.balanceTree();
        wrongTree.print();
        System.out.println();
        correctTree.print();

    }

    public static TreeEl makeTree(int [] nums){
        TreeEl wrongTree = new TreeEl();
        TreeEl one = new TreeEl(nums[0]);
        TreeEl two = new TreeEl(nums[1]);
        TreeEl three = new TreeEl(nums[2]);
        TreeEl four = new TreeEl(nums[3]);
        TreeEl five = new TreeEl(nums[4]);
        wrongTree.setFirstNode(one);
        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        return wrongTree;
    }

}
