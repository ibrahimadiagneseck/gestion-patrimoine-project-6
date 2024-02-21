package sn.douanes.gestionPatrimoineVehiculeSpringBoot.exception.entities;

public class AgentExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public AgentExistException(String message) {
        super(message);
    }
}
