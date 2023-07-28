import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
public class ATWP {
    Node root;
    public void treeT(Node n){
        if(n != null){
            treeT(n.left);
            System.out.print(" " + n.pointer);
            treeT(n.right);
        }
    }
    public static void main(String args[]) throws IOException {
        File atwp = new File("src/Input.txt");
        BufferedReader br = new BufferedReader(new FileReader(atwp));


        String N = br.readLine();
        String node = br.readLine();


        System.out.println("The number of stations in the network under investigation is: " + N);
        System.out.println("The stations that have a frame to send are: " + node);

        ATWP leaf = new ATWP();

        leaf.root = new Node("C");
        leaf.root.left = new Node("E");
        leaf.root.right = new Node("F");
        leaf.root.left.left = new Node("H");

        System.out.println();

        leaf.treeT(leaf.root);
    }
}
