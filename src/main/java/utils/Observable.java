package utils;

public interface Observable {
    void ajouterObservateur(Observateur o);
    void notifierObservateurs(String message);
}
