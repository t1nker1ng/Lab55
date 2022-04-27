package IOManager;

public class EmptyOut implements WriteAbility{
    public EmptyOut(){};
    @Override
    public void write(String s){
        return;
    }

    @Override
    public void writeln(String s) {
        return;
    }
}
