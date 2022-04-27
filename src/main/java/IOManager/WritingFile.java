package IOManager;

import java.io.*;

public class WritingFile implements WriteAbility{
    private final File file;

    public WritingFile(String path) throws IOException {
        file = new File(path);
        if (!file.isFile())
            while(file.createNewFile());
    }


    @Override
    public void write(String text){
        try (FileOutputStream out = new FileOutputStream(file);
             BufferedOutputStream fw = new BufferedOutputStream(out);) {
            byte[] t = text.getBytes();
            fw.write(t);
        }
        catch (IOException ex){
            System.err.println("Ошибка вывода");
        }

    }

    @Override
    public void writeln(String text){
        write(text+"\n");
    }
}