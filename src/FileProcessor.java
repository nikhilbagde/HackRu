import java.io.*;

/**
 * Created by Nikhil on 1/27/2016.
 */
public class FileProcessor {
    String fileName;
    public BufferedReader reader = null;
    public BufferedWriter bw = null;
    public int fileEmptyFlag = 0;

    /**
     * Constructor will initiate buffer reader object provided file name
     * @param fileName
     * @throws FileNotFoundException
     */
    public FileProcessor(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        File file = new File(this.fileName);
        reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
        //Logger.writeMessage("In FileProcessor Constructor.", Logger.DebugLevel.CONSTRUCTOR);
        //scanner = new Scanner(new FileReader(file.getAbsolutePath()));
    }

    /**
     * It will read each line; one line at a time.
     * @return line String
     * @throws IOException
     */
    public synchronized String readLineFromFile() throws IOException {
        String line = reader.readLine();
        //line = scanner.nextLine();
        return line;
    }
    public void writeLineToFile(String outputFile, int outputStr, int count) {

        try {
            if (bw == null) {

                if (fileEmptyFlag == 0) {
                    PrintWriter writer = new PrintWriter(outputFile);
                    writer.print("");
                    fileEmptyFlag = 1;
                }

                bw = new BufferedWriter(new FileWriter(outputFile, true));
            }
        } catch (IOException e) {
            System.out.println("IOException occured while opening file " + outputFile + ". The file may be corrupt, unreadable or may not exist.");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            //bw.write(String.valueOf(outputStr) + " "  + count);
            bw.write(String.valueOf(count));
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error occured while writing to file " + outputFile + ".");
            System.exit(1);
        } finally {
            try {
                bw.close();
                bw = null;
            } catch (IOException e) {
                System.out.println("Error occured while closing file " + outputFile + ".");
                System.exit(1);
            }
        }

        }

    /**
     * specialized write function to print output in format
     * [    [x,x,x,x,x....50 times],
     *      [x,x,x,x,x....50 times],
     *      .
     *      .50
     *      .times
     *      .
     *      [x,x,x,x,x....50 times], ] for javascript handling
     * @param outputFile
     * @param countList
     */
    public void writeLineToFile(String outputFile, int[] countList) {

        try {
            if (bw == null) {

                if (fileEmptyFlag == 0) {
                    PrintWriter writer = new PrintWriter(outputFile);
                    writer.print("");
                    fileEmptyFlag = 1;
                }

                bw = new BufferedWriter(new FileWriter(outputFile, true));
            }
        } catch (IOException e) {
            System.out.println("IOException occured while opening file " + outputFile + ". The file may be corrupt, unreadable or may not exist.");
            e.printStackTrace();
            System.exit(1);
        }

        try {
            //bw.write(String.valueOf(outputStr) + " "  + count);
            bw.write("[ ");
            bw.write("[");
            for (int i = 1; i <= countList.length; i++) {
                while(i%50 !=0) {
                    bw.write(countList[i - 1] + ",");
                    i++;
                }
                bw.write(countList[i - 1] + "],");
                bw.newLine();
                if(i!= countList.length)
                    bw.write("[");
            }
            bw.write("]");
            //bw.write(String.valueOf(count));
            //bw.newLine();
        } catch (IOException e) {
            System.out.println("Error occured while writing to file " + outputFile + ".");
            System.exit(1);
        } finally {
            try {
                bw.close();
                bw = null;
            } catch (IOException e) {
                System.out.println("Error occured while closing file " + outputFile + ".");
                System.exit(1);
            }
        }

    }

    }
