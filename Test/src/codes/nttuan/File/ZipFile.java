package codes.nttuan.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {
    /**
     * main
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final File inputFile = new File("D:\\temp\\ziptest.txt");
        final String zipFilePath = "D:\\temp\\ziptest.zip";
        zipFile(inputFile, zipFilePath);
    }

    /**
     * zip file
     *
     * @param inputFile
     * @param zipFilePath
     * @throws IOException
     */
    private static void zipFile(File inputFile, String zipFilePath)
            throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ZipOutputStream zipos = null;

        try {
            fos = new FileOutputStream(zipFilePath);
            zipos = new ZipOutputStream(fos);

            ZipEntry zipEntry = new ZipEntry(inputFile.getName());
            zipos.putNextEntry(zipEntry);

            fis = new FileInputStream(inputFile);
            byte[] buf = new byte[1024];
            int length;
            while ((length = fis.read(buf)) > 0) {
                zipos.write(buf, 0, length);
            }
            System.out.println("File " + inputFile
                    + " da duoc zip thanh file " + zipFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zipos != null) {
                // close ZipEntry
                zipos.closeEntry();
                // close ZipOutputStream
                zipos.close();
            }
            // close FileOutputStream
            if (fos != null)
                fos.close();
            // close FileInputStream
            if (fis != null)
                fis.close();
        }
    }
}
