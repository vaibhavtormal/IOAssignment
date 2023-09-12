import java.io.*;

public class FileUtil {
        public static boolean copy(String src, String des) {
            File filein = new File(src);
            if(!filein.exists()) {
                return false;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(filein);
                FileOutputStream fileOutputStream = new FileOutputStream(des);

                byte [] data = new byte[1024*8];

                int count = 0;
                while((count = fileInputStream.read()) != -1) {

                    fileOutputStream.write(data,0,count);

                }
                fileInputStream.close();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;

        }

        public static long size(String path) {
            File file = new File(path);
            if(file.isFile()){
                return file.length();
            }
            return file.length();
        }

        public static long count(  String path) {
            File files = new File(path);
            if(files. isFile()) {
                return 1;
            }
            if(files .isDirectory()){
                long count = 0;
                File [] file =files.listFiles();
                if(file != null && file.length > 0) {
                    for(File filename : file) {

                        count += count(filename.getAbsolutePath());

                    }

                }

                return count;
            }

            return 0;




        }

        public static boolean delete(String path) {
            File file = new File(path);
            if(file.isFile()) {
                file.delete();
                return true;
            }
            file.delete();
            return true;
        }

}
