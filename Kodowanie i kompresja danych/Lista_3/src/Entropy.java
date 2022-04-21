import java.io.*;

class Entropy {

    // constructor
    public Entropy (String filepath){

        File file = new File(filepath);
        try (FileInputStream fin = new FileInputStream(file)){
            byte[] fileContent = new byte[(int) file.length()];

            // Read data into the byte array
            // int read(byte[] b) - this method is used to read up to b.length bytes of data from the input stream.
            fin.read(fileContent);

            // create an array to keep track of frequency of bytes
            int [] characterOccurrencesInAFile = new int[256];


            int fileContentLength = fileContent.length - 1;

            // count frequency of occurring bytes
            for(int i = 0; i < fileContentLength; i++) {

                byte byteValue = fileContent[i];

                int castedValue = Byte.toUnsignedInt(byteValue);

                characterOccurrencesInAFile[castedValue]++;
            }

            // calculate entropy
            double entropy = getEntropy(characterOccurrencesInAFile, fileContentLength);
            // calculate conditional entropy
            // output the entropy calculated
            System.out.println(entropy);

        }

        catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }

        catch (IOException ioe) {
            System.out.println("Exception while reading file " + ioe);
        }
    }

    // entropy as a sum from 0 to n p(xi) * log2(p(xi))
    private static double getEntropy(int[] characterOccurrencesInAFile, double fileContentLength) {
        double entropy = 0;
        for(int i = 0; i < characterOccurrencesInAFile.length; i++) {
            if(characterOccurrencesInAFile[i] != 0) {
                // calculate the probability of a particular byte occurring
                double probabilityOfByte = (double) characterOccurrencesInAFile[i] / fileContentLength;

                // calculate the next value to sum to previous entropy calculation
                double value = probabilityOfByte * customLog(probabilityOfByte);

                entropy = entropy + value;
            }
        }
        entropy = entropy * -1;
        return entropy;
    }

    // function to evaluate the value of a logarithm with a custom base
    private static double customLog(double logNumber) {
        return Math.log(logNumber) / Math.log(2);
    }
}