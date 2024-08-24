package file;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSize {
  public static void main(String[] args) throws IOException {
    System.out.println("\n-----------Files을 이용한 파일 크기 설정");
    FilesEx files = new FilesEx();
    files.files();

    System.out.println("\n-----------FileChannel을 이용한 파일 크기 설정");
    FileChannelEx fileChannel = new FileChannelEx();
    fileChannel.fileChannel();

    System.out.println("\n-----------File을 이용한 파일 크기 설정");
    FileEx file = new FileEx();
    file.file();
  }
}

class FilesEx {
  public void files() throws IOException {
    Path path = Paths.get("C:\\Users\\namji\\OneDrive\\바탕 화면\\image\\meta.png");

    float bytes = Files.size(path);
    float kb = bytes / 1024;
    float mb = kb / 1024;
    float gb = mb / 1024;

    System.out.println("bytes : " + bytes);
    System.out.println("kb : " + kb);
    System.out.println("mb : " + mb);
    System.out.println("gb : " + gb);
  }
}

class FileChannelEx {
  public void fileChannel() throws IOException {
    Path path = Paths.get("C:\\Users\\namji\\OneDrive\\바탕 화면\\image\\meta.png");

    FileChannel fileChannel = FileChannel.open(path);

    float bytes = fileChannel.size();
    float kb = bytes / 1024;
    float mb = kb / 1024;
    float gb = mb / 1024;

    System.out.println("bytes : " + bytes);
    System.out.println("kb : " + kb);
    System.out.println("mb : " + mb);
    System.out.println("gb : " + gb);
  }
}

class FileEx {
  public void file() throws IOException {
    File file = new File("C:\\Users\\namji\\OneDrive\\바탕 화면\\image\\meta.png");

    float bytes = file.length();
    float kb = bytes / 1024;
    float mb = kb / 1024;
    float gb = mb / 1024;

    System.out.println("bytes : " + bytes);
    System.out.println("kb : " + kb);
    System.out.println("mb : " + mb);
    System.out.println("gb : " + gb);
  }
}