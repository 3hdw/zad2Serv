import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MyServer {

    public static void main(String args[]){
        if(args.length<3){
            System.out.println("" +
                    "You have to enter RMI object address in" +
                    "the form: //host_address/worker1 //host_address/worker2 //host_address/worker3");
            return;
        }
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        try {
            Filter filter = new FilterImpl();
            Concat concat = new ConcatImpl();
            Naming.rebind(args[0],filter);
            Naming.rebind(args[1],filter);
            Naming.rebind(args[2],concat);
            System.out.println("Server is registered now :-)");
            System.out.println("Press ctl+c to stop...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
