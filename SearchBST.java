public class SearchBST {

    // Inner Node Class
    class BSTNode {
        String data;
        BSTNode left, right;

        public BSTNode(String data) {
            this.data = data;
            left = right = null;
        }
    }

    private BSTNode root;

    public SearchBST() {
        root = null;
    }

    // Insert Record
    public void insert(String data) {
        root = insertRec(root, data);
    }

    private BSTNode insertRec(BSTNode root, String data) {

        if (root == null) {
            root = new BSTNode(data);
            return root;
        }

        if (data.compareToIgnoreCase(root.data) < 0) {
            root.left = insertRec(root.left, data);
        }
        else if (data.compareToIgnoreCase(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Search Record
    public boolean search(String data) {
        return searchRec(root, data);
    }

    private boolean searchRec(BSTNode root, String data) {

        if (root == null)
            return false;

        if (root.data.equalsIgnoreCase(data))
            return true;

        if (data.compareToIgnoreCase(root.data) < 0)
            return searchRec(root.left, data);

        return searchRec(root.right, data);
    }
}