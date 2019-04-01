import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ConcatImpl extends UnicastRemoteObject implements Concat {

    protected ConcatImpl() throws RemoteException {
        super();
    }

    @Override
    public Person[] concat(Person[] peopleA, Person[] peopleB) throws RemoteException {
        Person[] people = new Person[peopleA.length+peopleB.length];
        int i=0;
        for(; i<peopleA.length; i++){
            people[i]=peopleA[i];
        }
        for(int k=0; k<peopleB.length; k++){
            people[i]=peopleB[k];
            i++;
        }
        return people;
    }
}
