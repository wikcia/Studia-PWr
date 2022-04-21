import java.io.*;

public class LZ77 {
    private static final int DEFAULT_BUFF_SIZE = 256; // declaration of buffer size
    private static final int DEFAULT_DICTIONARY_SIZE = 256;
    private final int mBufferSize;
    private final int dictionarySize;
    private Reader reader;
    private final StringBuffer stringBuffer;
    private final StringBuffer dictionaryBuffer;

    // this constructor calls the second constructor
    // this() is used to refer to the constructor belonging to the same class.
    public LZ77() {
        this(DEFAULT_BUFF_SIZE, DEFAULT_DICTIONARY_SIZE);
    }

    public LZ77(int buffSize, int dictionarySize) {
        this.mBufferSize = buffSize;
        this.dictionarySize = dictionarySize;
        stringBuffer = new StringBuffer(mBufferSize);
        dictionaryBuffer = new StringBuffer(dictionarySize);
    }

    private void trimSearchBuffer() {
        if (stringBuffer.length() > mBufferSize) {
            stringBuffer.delete(0,  stringBuffer.length() - mBufferSize);
        }
        if (dictionaryBuffer.length() > dictionarySize) {
            dictionaryBuffer.delete(0,  dictionaryBuffer.length() - dictionarySize);
        }
    }

    /**
     * UWAGA! wszystkie znaki między spacją a '}' zawierają kody ASCII MIĘDZY 32 A 125, '~' ma natomiast kod 126
     */
    public void uncompress(String infile) throws IOException {
        reader = new BufferedReader(new FileReader(infile));
        StreamTokenizer st = new StreamTokenizer(reader);

        st.ordinaryChar(' ');
        st.ordinaryChar('.');
        st.ordinaryChar(',');
        st.ordinaryChar('-');
        st.ordinaryChar('\n');

        st.wordChars('\n', '\n');
        st.wordChars(' ', '}');

        int offset, length;
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            switch (st.ttype) {
                case StreamTokenizer.TT_WORD -> {
                    dictionaryBuffer.append(st.sval);
                    System.out.print(st.sval);
                    // Adjust search buffer size if necessary
                    trimSearchBuffer();
                }
                case StreamTokenizer.TT_NUMBER -> {
                    offset = (int) st.nval; // set the offset
                    st.nextToken(); // get the separator
                    if (st.ttype == StreamTokenizer.TT_WORD) {
                        // we got a word instead of the separator,
                        // therefore the first number read was actually part of a word
                        dictionaryBuffer.append(offset).append(st.sval);
                        System.out.print(offset + st.sval);
                        break; // break out of the switch
                    }
                    // if we got this far then we must be reading a
                    // substitution pointer
                    st.nextToken(); // get the length
                    length = (int) st.nval;
                    // output substring from search buffer
                    String output = dictionaryBuffer.substring(offset, offset + length);
                    System.out.print(output);
                    dictionaryBuffer.append(output);
                    // Adjust search buffer size if necessary
                    trimSearchBuffer();
                }
                default -> {
                    // consume '~'
                }

            }
        }
        reader.close();
    }

    public void compress(String infile) throws IOException {
        // set up input and output
        reader = new BufferedReader(new FileReader(infile));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Result.txt")));

        int nextChar;
        String currentMatch = "";
        int matchIndex = 0, tempIndex;

        // while there are more characters - read a character
        while ((nextChar = reader.read()) != -1) {
            // look in our search buffer for a match
            tempIndex = stringBuffer.indexOf(currentMatch + (char)nextChar); // if no such value of k exists, then -1 is returned (by indexOf)
            // if match then append nextChar to currentMatch
            // and update index of match
            if (tempIndex != -1) {
                currentMatch += (char)nextChar;
                matchIndex = tempIndex;
            } else {
                // found the longest match, now should we encode it?
                String codedString = "~"+matchIndex+"~"+currentMatch.length()+"~"+(char)nextChar;
                String concat = currentMatch + (char)nextChar;
                // is coded string shorter than raw text?
                if (codedString.length() <= concat.length()) {
                    printWriter.print(codedString);
                    stringBuffer.append(concat); // append to the search buffer
                    currentMatch = "";
                    matchIndex = 0;
                } else {
                    // otherwise, output chars one at a time from
                    // currentMatch until we find a new match or
                    // run out of chars
                    currentMatch = concat; matchIndex = -1;
                    while (currentMatch.length() > 1 && matchIndex == -1) {
                        printWriter.print(currentMatch.charAt(0));
                        stringBuffer.append(currentMatch.charAt(0));
                        currentMatch = currentMatch.substring(1);
                        matchIndex = stringBuffer.indexOf(currentMatch);

                    }
                }
                // Adjust search buffer size if necessary
                trimSearchBuffer();
            }
        }
        // flush any match we may have had when EOF encountered
        if (matchIndex != -1) {
            String codedString =
                    "~" + matchIndex + "~" + currentMatch.length();
            if (codedString.length() <= currentMatch.length()) {
                printWriter.print("~" + matchIndex + "~" + currentMatch.length());
            } else {
                printWriter.print(currentMatch);
            }
        }
        // close files
        reader.close();
        printWriter.flush();
        printWriter.close();
    }

    public static void main(String [] args) {
        LZ77 lz = new LZ77();
        try {
            lz.compress(args[0]);
            System.out.println("Uncompressed file:");
            lz.uncompress(args[1]);

            System.out.println("---------------------------------");
            System.out.println("Entropy of coded data: ");
            new Entropy(args[1]);
            System.out.println("---------------------------------");
            System.out.println("Entropy of decoded data: ");
            new Entropy(args[0]);
            System.out.println("---------------------------------");

            long lengthOfCodedFile = new File(args[1]).length();
            System.out.println("Length of coded data: " + lengthOfCodedFile);
            long lengthOdDecodedFile = new File(args[0]).length();
            System.out.println("Length of decoded data: " + lengthOdDecodedFile);
            double l = ((double)lengthOfCodedFile / (double)lengthOdDecodedFile) * 100;
            System.out.println("---------------------------------");
            System.out.println("Compression ratio: " + l + " %");

        } catch (FileNotFoundException f) {
            System.err.println("File not found: " + args[0]);
        } catch (IOException e) {
            System.err.println("Problem processing file: " + args[0]);
        }
    }
}