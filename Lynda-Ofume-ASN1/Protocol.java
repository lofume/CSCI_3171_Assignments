import java.util.*;
import java.io.*;
public class Protocol {

    public void l3(int hLength, int tLength, int maxSize) throws IOException {
        File thisFile = new File("src/Message.txt");
        Scanner myFile = new Scanner(thisFile);

        File pSpec = new File("src/ProtocolSpecification.txt");
        Scanner sPecs = new Scanner (pSpec);

        while (myFile.hasNext()){
            String info = myFile.nextLine();
            System.out.println("The message from the application is:");
            System.out.println(info);
            System.out.println();
        }
        System.out.println("The protocol specifications are:");
        while(sPecs.hasNextLine()){
            String str = sPecs.nextLine();
            System.out.println(str);
        }

//LAYER 3 PROTOCOL
        System.out.println();
        System.out.println("Layer 3 generates the following messages:");
        for(int i=1; i<hLength; i++) {
            if (hLength > 0) {
                System.out.print(hLength);

            }
        }
    }

//LAYER 2 PROTOCOL
    public void l2(int hLength, int tLength, int maxSize){
        System.out.println();
        System.out.println("Layer 2 generates the following messages:");
        for(int i=1; i<hLength; i++) {
            if (hLength > 0) {
                System.out.print(hLength);
            }
        }
    }

//LAYER 1 PROTOCOL
    public void l1(int hLength, int tLength, int maxSize){
        System.out.println();
        System.out.println("Layer 1 generates the following messages:");
        for(int i=1; i<hLength; i++) {
            if (hLength > 0) {
                System.out.print(hLength);
            }
        }
    }

    public static void main (String arg[]) throws Exception{

        Scanner kb= new Scanner(System.in);
        System.out.print("Enter filename to read from: ");
        String filename= kb.nextLine();

        File mSG = new File("src/Message.txt");
        Scanner myFile = new Scanner(mSG);

        File mSG1 = new File("src/Message.txt");
        Scanner myFile2 = new Scanner(mSG1);

        File mSG2 = new File("src/Message.txt");
        Scanner myFile3 = new Scanner(mSG2);

        Protocol prt = new Protocol();
        Protocol prt2 = new Protocol();
        Protocol prt3 = new Protocol();

        System.out.println();
//Protocol 3
        prt.l3(3,1,10);
        while (myFile.hasNextLine()) {
            String info = myFile.nextLine();
            System.out.print(info);
            System.out.println();
        }
//Protocol 2
        prt2.l2(0,1,15);
        while (myFile2.hasNextLine()) {
            String info = myFile2.nextLine();
                 System.out.println("33" +info+ (info.length()-8));
                 System.out.println();
        }
//Protocol 1
        prt3.l1(3,1,10);
        while (myFile3.hasNextLine()) {
            String info = myFile3.nextLine();
            System.out.println(info + "1");
            if(info.length() > 8){
                System.out.println("11133" + info + (info.length()-9));
            }
        }
    }
}