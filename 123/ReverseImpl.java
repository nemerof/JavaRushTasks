import java.rmi.RemoteException;

public class ReverseImpl implements Reverse {
    @Override
    public String reverse(String str) throws RemoteException
    {
        return new StringBuffer(str).reverse().toString();
    }
}
