import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;

public class FilterImpl extends UnicastRemoteObject implements Filter {

    protected FilterImpl() throws RemoteException {
        super();
    }

    @Override
    public Person[] filter(Person[] people, String name) throws RemoteException {
        ArrayList<Person> arrayList = new ArrayList<>(Arrays.asList(people));
        for(int i=0; i<arrayList.size(); i++){
            if(!arrayList.get(i).getName().equals(name)){
                arrayList.remove(i);
                i=0;
            }
        }
        if(!arrayList.get(0).getName().equals(name)){
            arrayList.remove(0);
        }
        return listToArray(arrayList);
    }

    private static Person[] listToArray(ArrayList<Person> arrayList){
        Person[] people = new Person[arrayList.size()];
        for(int i=0; i<people.length; i++){
            people[i]=arrayList.get(i);
        }
        return people;
    }
}
