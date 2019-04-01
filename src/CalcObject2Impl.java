import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcObject2Impl extends UnicastRemoteObject implements CalcObject2 {

    protected CalcObject2Impl() throws RemoteException {
        super();
    }

    @Override
    public ResultType calcute(InputType inputParam) throws RemoteException {
        double zm1, zm2;
        ResultType wynik = new ResultType();
        zm1 = inputParam.getX1();
        zm2 = inputParam.getX2();
        wynik.setResultDescripton("Operacja " + inputParam.getOperation());
        switch (inputParam.getOperation()) {
            case "add":
                wynik.setResult(zm1+zm2);
                break;
            case "sub":
                wynik.setResult(zm1-zm2);
                break;
            default:
                wynik.setResult(0);
                wynik.setResultDescripton("zla operacja");
                break;
        }
        return wynik;
    }
}
