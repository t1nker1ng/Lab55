package IOManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class File_Reader implements ReadAbility{
    private String path;
    private BufferedReader br;
    private final List<String> lines;
    private int it;
    Scanner scanner;

    public File_Reader(String path) throws IOException{
        lines = Files.readAllLines(Paths.get(path));
        it = 0;
    }

    @Override
    public String readline() {
        if (it == lines.size())
            return null;
        return lines.get(it++);
    }
    public Float readFloat(){
        if (scanner.hasNextFloat())
            return scanner.nextFloat();
        else
            scanner.next();
        return null;
    }
    public Long readLong(){
        if (scanner.hasNextLong())
            return scanner.nextLong();
        else
            scanner.next();
        return null;
    }
}
