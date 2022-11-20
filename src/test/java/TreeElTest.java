import static org.junit.jupiter.api.Assertions.*;

class TreeElTest {

    @org.junit.jupiter.api.Test
    void balanceTree() {
        TreeEl wrongTree = Main.makeTree(new int[] {13,5,8,1,30});
        TreeEl correctTree = Main.makeTree(new int [] {13,5,30,1,8});
        wrongTree.balanceTree();
        assertArrayEquals(correctTree.getStructureTree(),wrongTree.getStructureTree());
    }

}